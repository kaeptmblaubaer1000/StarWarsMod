using System;
using System.Collections.Generic;
using System.Text;
using fNbt;

namespace SchematicExporter
{
    internal class JavaBuilder
    {
        public static string MakeSetBlockLine(Schematic s, ref List<string> imports, int x, int y, int z)
        {
            var b = s.GetBlockAt(x, y, z);
            var sb = new StringBuilder();
            var nsp = b.GetNamespacePrefix();
            switch (nsp)
            {
                case IdMapper.ClassBlocks:
                    imports.Require("net.minecraft.init.Blocks");
                    break;
                case IdMapper.ClassPswm:
                    imports.Require("com.parzivail.pswm.StarWarsMod");
                    break;
            }
            sb.AppendLine(string.Format("\t\tthis.b(world, i + {0}, j + {1}, k + {2}, {3}, 0);", x, y, z, b.CreateJavaVariable()));
            if (s.GetBlockMetadataAt(x, y, z) != 0)
                sb.AppendLine(string.Format("\t\tthis.m(world, i + {0}, j + {1}, k + {2}, {3});", x, y, z, s.GetBlockMetadataAt(x, y, z)));
            return sb.ToString();
        }

        public static string MakeGen(int genId)
        {
            return string.Format("\tpublic boolean generate{0}(World world, int i, int j, int k)", genId == 0 ? "" : "_" + genId);
        }

        public static string MakeCallGen(int genId)
        {
            return string.Format("\t\tgenerate_{0}(world, i, j, k);", genId);
        }

        public static string MakeNbt(string nameBase, ref List<string> imports, NbtCompound compound, string setTag, string linePrefix)
        {
            // world.getTileEntity(i, j, k).readFromNBT(NBTTagCompound);
            // NBTTagCompound tag = new NBTTagCompound();
            // tag.setTag("key", value);

            /*
                TAG_Compound: 7 entries {
                  TAG_Compound("droplets"): 3 entries {
                    TAG_Short("id"): 4174
                    TAG_Byte("Count"): 7
                    TAG_Short("Damage"): 0
                  }
                  TAG_Int("progress"): 505
                  TAG_Short("facing"): 0
                  TAG_String("id"): "teMoistureVaporator"
                  TAG_Int("x"): 8
                  TAG_Int("y"): 0
                  TAG_Int("z"): 8
                }
             */

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
                        sb.AppendLine(string.Format("{0}{1}.setByte(\"{2}\", (byte){3});", linePrefix, nameBase, tName, tag.ByteValue));
                        break;
                    case NbtTagType.ByteArray:
                        sb.AppendLine(string.Format("{0}{1}.setByteArray(\"{2}\", new byte[] {3});", linePrefix, nameBase, tName, tag.ByteArrayValue));
                        break;
                    case NbtTagType.Compound:
                        sb.Append(MakeNbt(nameBase + "_nest", ref imports, (NbtCompound)tag, nameBase, linePrefix));
                        break;
                    case NbtTagType.List:
                        sb.AppendLine(string.Format("{0}NBTTagList {1} = new NBTTagList();", linePrefix, nameBase + "_list"));
                        imports.Require("net.minecraft.nbt.NBTTagList");
                        var lItem = 0;
                        foreach (var tagList in (NbtList)tag)
                            if (tagList.TagType == NbtTagType.Compound)
                            {
                                sb.AppendLine(MakeNbt(nameBase + "_listItem" + lItem, ref imports, (NbtCompound)tagList, null, linePrefix));
                                sb.AppendLine(string.Format("{0}{1}_list.appendTag({2}_listItem{3});", linePrefix, nameBase, nameBase, lItem));
                                lItem++;
                            }
                        sb.AppendLine(string.Format("{0}{1}.setTag(\"{2}\", {3});", linePrefix, nameBase, tName, nameBase + "_list"));
                        break;
                    case NbtTagType.Double:
                        sb.AppendLine(string.Format("{0}{1}.setDouble(\"{2}\", {3});", linePrefix, nameBase, tName, tag.DoubleValue));
                        break;
                    case NbtTagType.Float:
                        sb.AppendLine(string.Format("{0}{1}.setFloat(\"{2}\", {3}F);", linePrefix, nameBase, tName, tag.FloatValue));
                        break;
                    case NbtTagType.Int:
                        sb.AppendLine(string.Format("{0}{1}.setInteger(\"{2}\", {3});", linePrefix, nameBase, tName, tag.IntValue));
                        break;
                    case NbtTagType.IntArray:
                        sb.AppendLine(string.Format("{0}{1}.setIntArray(\"{2}\", new int[] {3});", linePrefix, nameBase, tName, tag.IntArrayValue));
                        break;
                    case NbtTagType.Long:
                        sb.AppendLine(string.Format("{0}{1}.setLong(\"{2}\", {3}L);", linePrefix, nameBase, tName, tag.LongValue));
                        break;
                    case NbtTagType.Short:
                        sb.AppendLine(string.Format("{0}{1}.setShort(\"{2}\", (short){3});", linePrefix, nameBase, tName, tag.ShortValue));
                        break;
                    case NbtTagType.String:
                        sb.AppendLine(string.Format("{0}{1}.setString(\"{2}\", \"{3}\");", linePrefix, nameBase, tName, tag.StringValue));
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

        public static string MakeChest(ref Schematic s, ref List<string> imports, int chestId, int x, int y, int z, string linePrefix)
        {
            // TileEntityChest chest = (TileEntityChest)world.getTileEntity(i + 2, j + 1, k + 3);
            // chest.setInventorySlotContents(slot, ItemStack);
            // LootGenUtils.fillLootChest(world.provider.dimensionId, world.rand, (TileEntityChest)world.getTileEntity(i + 4, j + 1, k + 6));

            /*
              TAG_List("Items"): 15 entries {
              TAG_Compound: 4 entries {
                TAG_Byte("Slot"): 0
                TAG_Short("id"): 295
                TAG_Byte("Count"): 5
                TAG_Short("Damage"): 0
              }
              TAG_Compound: 4 entries {
                TAG_Byte("Slot"): 1
                TAG_Short("id"): 295
                TAG_Byte("Count"): 5
                TAG_Short("Damage"): 0
              }
             */

            var sb = new StringBuilder();

            var c = s.GetTileEntityAt(x, y, z);

            if (c == null || ((NbtList) c["Items"]).Count <= 0) return sb.ToString();

            sb.AppendLine(string.Format("{0}TileEntityChest chest{4} = (TileEntityChest)world.getTileEntity(i + {1}, j + {2}, k + {3});", linePrefix, x, y, z, chestId));
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
                    if (id == IdMapper.Instance.GetIdFromItem("blaze_rod") || (((NbtList)c["Items"]).Count == 0 && Program.EmptyChestNotRandom)) // blaze rod in top left = randomize loot
                    {
                        sb.Clear();
                        sb.AppendLine(string.Format("{0}LootGenUtils.fillLootChest(world.provider.dimensionId, world.rand, (TileEntityChest)world.getTileEntity(i + {1}, j + {2}, k + {3});", linePrefix, x, y, z));
                        imports.Require("com.parzivail.pswm.utils.LootGenUtils");
                        break;
                    }
                    else if (id == IdMapper.Instance.GetIdFromItem("lever") && !Program.IgnoreChestToEntity) // lever in top left = spawn entity
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
                sb.AppendLine(string.Format("{0}chest{5}.setInventorySlotContents({1}, new ItemStack({2}, {3}, {4}));", linePrefix, slot, IdMapper.Instance.GetItemFromId(id).CreateJavaVariable(), count, damage, chestId));
                var nsp = IdMapper.Instance.GetItemFromId(id).GetNamespacePrefix();
                if (nsp == IdMapper.ClassBlocks)
                    imports.Require("net.minecraft.init.Blocks");
                else if (nsp == IdMapper.ClassItems)
                    imports.Require("net.minecraft.init.Items");
                else if (nsp == IdMapper.ClassPswm)
                    imports.Require("com.parzivail.pswm.StarWarsMod");
            }

            return sb.ToString();
        }

        public static string MakeEntitySpawn(Entity e, int entityId, int x, int y, int z, string linePrefix)
        {
            var sb = new StringBuilder();

            sb.AppendLine(string.Format("{0}if (!world.isRemote)", linePrefix));
            sb.AppendLine(string.Format("{0}{{", linePrefix));
            sb.AppendLine(string.Format("{0}\t{1} entity{2} = new {1}(world);", linePrefix, e.GetName(), entityId));
            sb.AppendLine(string.Format("{0}\tentity{1}.setPosition(i + 0.5D + {2}, j + {3}, k + 0.5D + {4});", linePrefix, entityId, x, y, z));
            sb.AppendLine(string.Format("{0}\tworld.spawnEntityInWorld(entity{1});", linePrefix, entityId));
            sb.AppendLine(string.Format("{0}}}", linePrefix));

            return sb.ToString();
        }
    }
}
