using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using fNbt;

namespace SchematicExporter
{
    class NBTBuilder
    {
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
        public static String makeJavaNbt(String nameBase, NbtCompound compound, String setTag, String linePrefix)
        {
            // world.getTileEntity(i, j, k).readFromNBT(NBTTagCompound);
            // NBTTagCompound tag = new NBTTagCompound();
            // tag.setTag("key", value);

            StringBuilder sb = new StringBuilder();

            sb.AppendLine(String.Format("{0}NBTTagCompound {1} = new NBTTagCompound();", linePrefix, nameBase));
            
            foreach (String tName in compound.Names)
            {
                NbtTag tag = compound[tName];
                if (tag == null)
                    continue;
                switch (tag.TagType)
                {
                    case NbtTagType.Byte:
                        sb.AppendLine(String.Format("{0}{1}.setByte(\"{2}\", {3});", linePrefix, nameBase, tName, tag.ByteValue));
                        break;
                    case NbtTagType.ByteArray:
                        sb.AppendLine(String.Format("{0}{1}.setByteArray(\"{2}\", new byte[] {3});", linePrefix, nameBase, tName, tag.ByteArrayValue));
                        break;
                    case NbtTagType.Compound:
                        sb.Append(makeJavaNbt(nameBase + "_nest", ((NbtCompound)tag), nameBase, linePrefix));
                        break;
                    case NbtTagType.Double:
                        sb.AppendLine(String.Format("{0}{1}.setDouble(\"{2}\", {3});", linePrefix, nameBase, tName, tag.DoubleValue));
                        break;
                    case NbtTagType.Float:
                        sb.AppendLine(String.Format("{0}{1}.setFloat(\"{2}\", {3}f);", linePrefix, nameBase, tName, tag.FloatValue));
                        break;
                    case NbtTagType.Int:
                        sb.AppendLine(String.Format("{0}{1}.setInteger(\"{2}\", {3});", linePrefix, nameBase, tName, tag.IntValue));
                        break;
                    case NbtTagType.IntArray:
                        sb.AppendLine(String.Format("{0}{1}.setIntArray(\"{2}\", new int[] {3});", linePrefix, nameBase, tName, tag.IntArrayValue));
                        break;
                    case NbtTagType.Long:
                        sb.AppendLine(String.Format("{0}{1}.setLong(\"{2}\", {3});", linePrefix, nameBase, tName, tag.LongValue));
                        break;
                    case NbtTagType.Short:
                        sb.AppendLine(String.Format("{0}{1}.setShort(\"{2}\", {3});", linePrefix, nameBase, tName, tag.ShortValue));
                        break;
                    case NbtTagType.String:
                        sb.AppendLine(String.Format("{0}{1}.setString(\"{2}\", \"{3}\");", linePrefix, nameBase, tName, tag.StringValue));
                        break;
                }
            }

            if (setTag != null)
                sb.AppendLine(String.Format("{0}{1}.setTag(\"{2}\", {3})", linePrefix, setTag, compound.Name, nameBase));

            return sb.ToString();
        }
    }
}
