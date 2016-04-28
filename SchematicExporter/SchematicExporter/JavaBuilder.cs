using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using fNbt;

namespace SchematicExporter
{
    class JavaBuilder
    {
        public static String makeSetBlockLine(Schematic s, ref List<String> imports, int x, int y, int z)
        {
            Block b = s.getBlockAt(x, y, z);
            StringBuilder sb = new StringBuilder();
            String nsp = b.getNamespacePrefix();
            if (nsp == IdMapper.CLASS_BLOCKS)
                imports.Require("net.minecraft.init.Blocks");
            else if (nsp == IdMapper.CLASS_PSWM)
                imports.Require("com.parzivail.pswm.StarWarsMod");
            sb.AppendLine(String.Format("\t\tthis.b(world, i + {0}, j + {1}, k + {2}, {3}, 0);", x, y, z, b.createJavaVariable()));
            if (s.getBlockMetadataAt(x, y, z) != 0)
                sb.AppendLine(String.Format("\t\tthis.m(world, i + {0}, j + {1}, k + {2}, {3});", x, y, z, s.getBlockMetadataAt(x, y, z)));
            return sb.ToString();
        }

        public static String makeGen(int genId)
        {
            return String.Format("\tpublic boolean generate{0}(World world, int i, int j, int k)", genId == 0 ? "" : ("_" + genId.ToString()));
        }

        public static String makeCallGen(int genId)
        {
            return String.Format("\t\tgenerate_{0}(world, i, j, k);", genId);
        }

        public static String makeNbt(String nameBase, ref List<String> imports, NbtCompound compound, String setTag, String linePrefix)
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

            StringBuilder sb = new StringBuilder();

            sb.AppendLine(String.Format("{0}NBTTagCompound {1} = new NBTTagCompound();", linePrefix, nameBase));
            imports.Require("net.minecraft.nbt.NBTTagCompound");
            
            foreach (String tName in compound.Names)
            {
                NbtTag tag = compound[tName];
                if (tag == null)
                    continue;
                switch (tag.TagType)
                {
                    case NbtTagType.Byte:
                        sb.AppendLine(String.Format("{0}{1}.setByte(\"{2}\", (byte){3});", linePrefix, nameBase, tName, tag.ByteValue));
                        break;
                    case NbtTagType.ByteArray:
                        sb.AppendLine(String.Format("{0}{1}.setByteArray(\"{2}\", new byte[] {3});", linePrefix, nameBase, tName, tag.ByteArrayValue));
                        break;
                    case NbtTagType.Compound:
                        sb.Append(makeNbt(nameBase + "_nest", ref imports, ((NbtCompound)tag), nameBase, linePrefix));
                        break;
                    case NbtTagType.List:
                        sb.AppendLine(String.Format("{0}NBTTagList {1} = new NBTTagList();", linePrefix, nameBase + "_list"));
                        imports.Require("net.minecraft.nbt.NBTTagList");
                        int lItem = 0;
                        foreach (NbtTag tagList in (NbtList)tag)
                            if (tagList.TagType == NbtTagType.Compound)
                            {
                                sb.AppendLine(makeNbt(nameBase + "_listItem" + lItem.ToString(), ref imports, ((NbtCompound)tagList), null, linePrefix));
                                sb.AppendLine(String.Format("{0}{1}_list.appendTag({2}_listItem{3});", linePrefix, nameBase, nameBase, lItem.ToString()));
                                lItem++;
                            }
                        sb.AppendLine(String.Format("{0}{1}.setTag(\"{2}\", {3});", linePrefix, nameBase, tName, nameBase + "_list"));
                        break;
                    case NbtTagType.Double:
                        sb.AppendLine(String.Format("{0}{1}.setDouble(\"{2}\", {3});", linePrefix, nameBase, tName, tag.DoubleValue));
                        break;
                    case NbtTagType.Float:
                        sb.AppendLine(String.Format("{0}{1}.setFloat(\"{2}\", {3}F);", linePrefix, nameBase, tName, tag.FloatValue));
                        break;
                    case NbtTagType.Int:
                        sb.AppendLine(String.Format("{0}{1}.setInteger(\"{2}\", {3});", linePrefix, nameBase, tName, tag.IntValue));
                        break;
                    case NbtTagType.IntArray:
                        sb.AppendLine(String.Format("{0}{1}.setIntArray(\"{2}\", new int[] {3});", linePrefix, nameBase, tName, tag.IntArrayValue));
                        break;
                    case NbtTagType.Long:
                        sb.AppendLine(String.Format("{0}{1}.setLong(\"{2}\", {3}L);", linePrefix, nameBase, tName, tag.LongValue));
                        break;
                    case NbtTagType.Short:
                        sb.AppendLine(String.Format("{0}{1}.setShort(\"{2}\", (short){3});", linePrefix, nameBase, tName, tag.ShortValue));
                        break;
                    case NbtTagType.String:
                        sb.AppendLine(String.Format("{0}{1}.setString(\"{2}\", \"{3}\");", linePrefix, nameBase, tName, tag.StringValue));
                        break;
                }
            }

            if (setTag != null)
                sb.AppendLine(String.Format("{0}{1}.setTag(\"{2}\", {3});", linePrefix, setTag, compound.Name, nameBase));

            return sb.ToString();
        }

        public static String makeChest(ref Schematic s, ref List<String> imports, int chestID, int x, int y, int z, String linePrefix)
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

            StringBuilder sb = new StringBuilder();

            NbtCompound c = s.getTileEntityAt(x, y, z);

            if (c != null && ((NbtList)c["Items"]).Count > 0)
            {
                sb.AppendLine(String.Format("{0}TileEntityChest chest{4} = (TileEntityChest)world.getTileEntity(i + {1}, j + {2}, k + {3});", linePrefix, x, y, z, chestID));
                imports.Require("net.minecraft.tileentity.TileEntityChest");
                
                foreach (NbtCompound itemstack in (NbtList)c["Items"])
                {
                    int slot = itemstack["Slot"].ByteValue;
                    int id = itemstack["id"].ShortValue;
                    int count = itemstack["Count"].ByteValue;
                    int damage = itemstack["Damage"].ShortValue;
                    if (slot == 0)
                    {
                        if (id == IdMapper.instance.getIdFromItem("blaze_rod")) // blaze rod in top left = randomize loot
                        {
                            sb.Clear();
                            sb.AppendLine(String.Format("{0}LootGenUtils.fillLootChest(world.provider.dimensionId, world.rand, (TileEntityChest)world.getTileEntity(i + {1}, j + {2}, k + {3});", linePrefix, x, y, z));
                            imports.Require("com.parzivail.pswm.utils.LootGenUtils");
                            break;
                        }
                        else if (id == IdMapper.instance.getIdFromItem("lever")) // lever in top left = spawn entity
                        {
                            sb.Clear();

                            NbtCompound item = (NbtCompound)c["Items"][1]; // slot 2
                            Item n = IdMapper.instance.getItemFromId(item["id"].ShortValue);
                            Entity e = IdMapper.instance.getEntityFromAssociation(n);

                            if (e != null)
                            {
                                s.setFlagAt(x, y, z, true);
                                imports.Require(e.getQualifiedName());
                                return makeEntitySpawn(e, chestID, x, y, z, "\t\t");
                            }

                            break;
                        }
                    }
                    //new ItemStack(item, size, meta)
                    sb.AppendLine(String.Format("{0}chest{5}.setInventorySlotContents({1}, new ItemStack({2}, {3}, {4}));", linePrefix, slot, IdMapper.instance.getItemFromId(id).createJavaVariable(), count, damage, chestID));
                    String nsp = IdMapper.instance.getItemFromId(id).getNamespacePrefix();
                    if (nsp == IdMapper.CLASS_BLOCKS)
                        imports.Require("net.minecraft.init.Blocks");
                    else if (nsp == IdMapper.CLASS_ITEMS)
                        imports.Require("net.minecraft.init.Items");
                    else if (nsp == IdMapper.CLASS_PSWM)
                        imports.Require("com.parzivail.pswm.StarWarsMod");
                }
            }

            return sb.ToString();
        }

        public static String makeEntitySpawn(Entity e, int entityID, int x, int y, int z, String linePrefix)
        {
            StringBuilder sb = new StringBuilder();

            sb.AppendLine(String.Format("{0}if (!world.isRemote)", linePrefix));
            sb.AppendLine(String.Format("{0}{{", linePrefix));
            sb.AppendLine(String.Format("{0}\t{1} entity{2} = new {1}(world);", linePrefix, e.getName(), entityID));
            sb.AppendLine(String.Format("{0}\tentity{1}.setPosition(i + 0.5D + {2}, j + {3}, k + 0.5D + {4});", linePrefix, entityID, x, y, z));
            sb.AppendLine(String.Format("{0}\tworld.spawnEntityInWorld(entity{1});", linePrefix, entityID));
            sb.AppendLine(String.Format("{0}}}", linePrefix));

            return sb.ToString();
        }
    }
}
