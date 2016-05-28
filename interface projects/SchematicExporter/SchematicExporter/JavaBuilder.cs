using System;
using System.Collections.Generic;
using System.Text;
using fNbt;

namespace SchematicExporter
{
    internal static class JavaBuilder
    {
        /// <summary>
        /// Creates a setBlock like from the given arguments
        /// </summary>
        /// <param name="s">The schematic to pull from</param>
        /// <param name="imports">The imports list to modify as needed</param>
        /// <param name="x">X</param>
        /// <param name="y">Y</param>
        /// <param name="z">Z</param>
        /// <param name="chunkX">Chunk X</param>
        /// <param name="chunkZ">Chunk Z</param>
        /// <returns>The generated setBlock line</returns>
        public static string MakeSetBlockLine(Schematic s, ref List<string> imports, int x, int y, int z, int chunkX, int chunkZ)
        {
            var b = s.GetBlockAt(x, y, z);
            var sb = new StringBuilder();
            var nsp = b.GetNamespacePrefix();
            switch (nsp)
            {
                case IdMapper.ClassBlocks:
                    imports.Require("net.minecraft.init.Blocks.*");
                    break;
                case IdMapper.ClassPswm:
                    imports.Require("com.parzivail.pswm.StarWarsMod.*");
                    break;
                default:
                    imports.Require(nsp);
                    break;
            }
            sb.AppendFormat("{4}b(w,i+{0},j+{1}, k+{2},{3},0);\r\n", x - chunkX, y, z - chunkZ, b.GetName(), "\t\t");
            if (s.GetBlockMetadataAt(x, y, z) != 0)
                sb.AppendFormat("{4}m(w,i+{0},j+{1},k+{2},{3});\r\n", x - chunkX, y, z - chunkZ, s.GetBlockMetadataAt(x, y, z), "\t\t");
            return sb.ToString().Replace("+0", "");
        }

        /// <summary>
        /// Creates a generate method
        /// </summary>
        /// <param name="genId">The ID of the gen statement (method name suffix)</param>
        /// <returns>The generated method</returns>
        public static string MakeGen(int genId)
        {
            return new StringBuilder().AppendFormat("{1}public static void generate{0}(World w, int i, int j, int k)",
                genId == 0 ? "" : "_" + genId, "\t").ToString();
        }

        /// <summary>
        /// Creates a call to a generate method
        /// </summary>
        /// <param name="genId">The generate method to call (method name suffix)</param>
        /// <returns>The generated line</returns>
        public static string MakeCallGen(int genId)
        {
            return new StringBuilder().AppendFormat("{1}generate_{0}(w, i, j, k);", genId, "\t\t").ToString();
        }

        /// <summary>
        /// Generates NBT creation calls for a tile entity
        /// </summary>
        /// <param name="nameBase">The name of the NBT variable</param>
        /// <param name="imports">The imports list to modify as needed</param>
        /// <param name="compound">The TileEntity as a NbtCompound</param>
        /// <param name="setTag">The parent tag to append this tag to, if needed</param>
        /// <param name="linePrefix">The line prefix</param>
        /// <returns>The generated line</returns>
        public static string MakeNbt(string nameBase, ref List<string> imports, NbtCompound compound, string setTag,
            string linePrefix)
        {
            var sb = new StringBuilder();

            sb.AppendLine(string.Format("{0}NBTTagCompound {1} = new NBTTagCompound();", linePrefix, nameBase));
            imports.Require("net.minecraft.nbt.NBTTagCompound");

            foreach (var tName in compound.Names)
            {
                var tag = compound[tName];
                if (tag == null)
                    continue;
                switch (tag.TagType)
                {
                    case NbtTagType.Byte:
                        sb.AppendLine(string.Format("{0}{1}.setByte(\"{2}\", (byte){3});", linePrefix, nameBase, tName,
                            tag.ByteValue));
                        break;
                    case NbtTagType.ByteArray:
                        sb.AppendLine(string.Format("{0}{1}.setByteArray(\"{2}\", new byte[] {3});", linePrefix,
                            nameBase, tName, tag.ByteArrayValue));
                        break;
                    case NbtTagType.Compound:
                        sb.Append(MakeNbt(nameBase + "_nest", ref imports, (NbtCompound) tag, nameBase, linePrefix));
                        break;
                    case NbtTagType.List:
                        sb.AppendLine(string.Format("{0}NBTTagList {1} = new NBTTagList();", linePrefix,
                            nameBase + "_list"));
                        imports.Require("net.minecraft.nbt.NBTTagList");
                        var lItem = 0;
                        foreach (var tagList in (NbtList) tag)
                            if (tagList.TagType == NbtTagType.Compound)
                            {
                                sb.AppendLine(MakeNbt(nameBase + "_listItem" + lItem, ref imports, (NbtCompound) tagList,
                                    null, linePrefix));
                                sb.AppendLine(string.Format("{0}{1}_list.appendTag({2}_listItem{3});", linePrefix,
                                    nameBase, nameBase, lItem));
                                lItem++;
                            }
                        sb.AppendLine(string.Format("{0}{1}.setTag(\"{2}\", {3});", linePrefix, nameBase, tName,
                            nameBase + "_list"));
                        break;
                    case NbtTagType.Double:
                        sb.AppendLine(string.Format("{0}{1}.setDouble(\"{2}\", {3});", linePrefix, nameBase, tName,
                            tag.DoubleValue));
                        break;
                    case NbtTagType.Float:
                        sb.AppendLine(string.Format("{0}{1}.setFloat(\"{2}\", {3}F);", linePrefix, nameBase, tName,
                            tag.FloatValue));
                        break;
                    case NbtTagType.Int:
                        sb.AppendLine(string.Format("{0}{1}.setInteger(\"{2}\", {3});", linePrefix, nameBase, tName,
                            tag.IntValue));
                        break;
                    case NbtTagType.IntArray:
                        sb.AppendLine(string.Format("{0}{1}.setIntArray(\"{2}\", new int[] {3});", linePrefix, nameBase,
                            tName, tag.IntArrayValue));
                        break;
                    case NbtTagType.Long:
                        sb.AppendLine(string.Format("{0}{1}.setLong(\"{2}\", {3}L);", linePrefix, nameBase, tName,
                            tag.LongValue));
                        break;
                    case NbtTagType.Short:
                        sb.AppendLine(string.Format("{0}{1}.setShort(\"{2}\", (short){3});", linePrefix, nameBase, tName,
                            tag.ShortValue));
                        break;
                    case NbtTagType.String:
                        sb.AppendLine(string.Format("{0}{1}.setString(\"{2}\", \"{3}\");", linePrefix, nameBase, tName,
                            tag.StringValue));
                        break;
                    case NbtTagType.Unknown:
                        break;
                    case NbtTagType.End:
                        break;
                    default:
                        throw new ArgumentOutOfRangeException();
                }
            }

            if (setTag != null)
                sb.AppendLine(string.Format("{0}{1}.setTag(\"{2}\", {3});", linePrefix, setTag, compound.Name, nameBase));

            return sb.ToString();
        }

        /// <summary>
        /// Creates a chest from a NbtCompound'ed TileEntity
        /// </summary>
        /// <param name="s">The schematic to pull from</param>
        /// <param name="imports">The imports list to modify as needed</param>
        /// <param name="chestId">The ID of the chest (variable suffix)</param>
        /// <param name="x">X</param>
        /// <param name="y">Y</param>
        /// <param name="z">Z</param>
        /// <param name="linePrefix">The line prefix</param>
        /// <returns>The generated line</returns>
        public static string MakeChest(ref Schematic s, ref List<string> imports, int chestId, int x, int y, int z,
            string linePrefix)
        {
            var sb = new StringBuilder();

            var c = s.GetTileEntityAt(x, y, z);

            if (c == null) return sb.ToString();

            if (((NbtList)c["Items"]).Count == 0 && Arguments.EmptyChestRandom)
            {
                sb.Clear();
                sb.AppendLine(
                    string.Format(
                        "{0}LootGenUtils.fillLootChest(w.provider.dimensionId, w.rand, (TileEntityChest)w.getTileEntity(i + {1}, j + {2}, k + {3}));",
                        linePrefix, x, y, z));
                imports.Require("com.parzivail.pswm.utils.LootGenUtils");
                return sb.ToString();
            }

            sb.AppendLine(
                string.Format(
                    "{0}TileEntityChest chest{4} = (TileEntityChest)w.getTileEntity(i + {1}, j + {2}, k + {3});",
                    linePrefix, x, y, z, chestId));
            imports.Require("net.minecraft.tileentity.TileEntityChest");

            foreach (var nbtTag in (NbtList) c["Items"])
            {
                var itemstack = (NbtCompound) nbtTag;
                int slot = itemstack["Slot"].ByteValue;
                int id = itemstack["id"].ShortValue;
                int count = itemstack["Count"].ByteValue;
                int damage = itemstack["Damage"].ShortValue;
                if (slot == 0)
                {
                    if (id == IdMapper.Instance.GetIdFromItem("blaze_rod"))
                        // blaze rod in top left = randomize loot
                    {
                        sb.Clear();
                        sb.Append(
                            string.Format(
                                "{0}LootGenUtils.fillLootChest(w.provider.dimensionId, w.rand, (TileEntityChest)w.getTileEntity(i + {1}, j + {2}, k + {3});",
                                linePrefix, x, y, z));
                        imports.Require("com.parzivail.pswm.utils.LootGenUtils");
                        break;
                    }
                    if (id == IdMapper.Instance.GetIdFromItem("lever") && !Arguments.IgnoreChestToEntity)
                        // lever in top left = spawn entity
                    {
                        sb.Clear();

                        var item = (NbtCompound) c["Items"][1]; // slot 2
                        var n = IdMapper.Instance.GetItemFromId(item["id"].ShortValue);
                        var e = IdMapper.Instance.GetEntityFromAssociation(n);

                        if (e != null)
                        {
                            s.SetFlagAt(x, y, z, true);
                            imports.Require(e.GetQualifiedName());
                            return MakeEntitySpawn(e, chestId, x, y, z, "\t\t");
                        }

                        break;
                    }
                }
                //new ItemStack(item, size, meta)
                sb.AppendLine(string.Format("{0}chest{5}.setInventorySlotContents({1}, new ItemStack({2}, {3}, {4}));",
                    linePrefix, slot, IdMapper.Instance.GetItemFromId(id).CreateJavaVariable(), count, damage, chestId));
                var nsp = IdMapper.Instance.GetItemFromId(id).GetNamespacePrefix();
                switch (nsp)
                {
                    case IdMapper.ClassBlocks:
                        imports.Require("net.minecraft.init.Blocks");
                        break;
                    case IdMapper.ClassItems:
                        imports.Require("net.minecraft.init.Items");
                        break;
                    case IdMapper.ClassPswm:
                        imports.Require("com.parzivail.pswm.StarWarsMod");
                        break;
                }
            }

            return sb.ToString();
        }

        /// <summary>
        /// Makes an entity spawn
        /// </summary>
        /// <param name="e">The entity to spawn</param>
        /// <param name="entityId">The ID of the entity (variable suffix)</param>
        /// <param name="x">X</param>
        /// <param name="y">Y</param>
        /// <param name="z">Z</param>
        /// <param name="linePrefix">The line prefix</param>
        /// <returns>The generated line</returns>
        private static string MakeEntitySpawn(Entity e, int entityId, int x, int y, int z, string linePrefix)
        {
            var sb = new StringBuilder();

            sb.AppendLine(string.Format("{0}if (!w.isRemote)", linePrefix));
            sb.AppendLine(string.Format("{0}{{", linePrefix));
            sb.AppendLine(string.Format("{0}\t{1} entity{2} = new {1}(w);", linePrefix, e.GetName(), entityId));
            sb.AppendLine(string.Format("{0}\tentity{1}.setPosition(i + 0.5D + {2}, j + {3}, k + 0.5D + {4});",
                linePrefix, entityId, x, y, z));
            sb.AppendLine(string.Format("{0}\tw.spawnEntityInWorld(entity{1});", linePrefix, entityId));
            sb.AppendLine(string.Format("{0}}}", linePrefix));

            return sb.ToString();
        }
    }
}
