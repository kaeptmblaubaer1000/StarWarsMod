using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace CreateQuestTreesGUI
{
    class Exporter
    {
        Dictionary<String, int> pfxs = new Dictionary<String, int>();

        public Exporter(String fileName, TreeNodeCollection nodes)
        {
            using (StreamWriter w = new StreamWriter(fileName))
            {
                w.WriteLine("this.tree = new DialogTree();");

                foreach (TreeNode node in nodes)
                {
                    processNodes("this.tree.", node, w);
                }
            }
        }

        public static string FixString(string s)
        {
            if (s.IndexOf('\u2013') > -1) s = s.Replace('\u2013', '-');
            if (s.IndexOf('\u2014') > -1) s = s.Replace('\u2014', '-');
            if (s.IndexOf('\u2015') > -1) s = s.Replace('\u2015', '-');
            if (s.IndexOf('\u2017') > -1) s = s.Replace('\u2017', '_');
            if (s.IndexOf('\u2018') > -1) s = s.Replace('\u2018', '\'');
            if (s.IndexOf('\u2019') > -1) s = s.Replace('\u2019', '\'');
            if (s.IndexOf('\u201a') > -1) s = s.Replace('\u201a', ',');
            if (s.IndexOf('\u201b') > -1) s = s.Replace('\u201b', '\'');
            if (s.IndexOf('\u201c') > -1) s = s.Replace('\u201c', '\"');
            if (s.IndexOf('\u201d') > -1) s = s.Replace('\u201d', '\"');
            if (s.IndexOf('\u201e') > -1) s = s.Replace('\u201e', '\"');
            if (s.IndexOf('\u2026') > -1) s = s.Replace("\u2026", "...");
            if (s.IndexOf('\u2032') > -1) s = s.Replace('\u2032', '\'');
            if (s.IndexOf('\u2033') > -1) s = s.Replace('\u2033', '\"');
            if (s.IndexOf('"') > -1) s = s.Replace("\"", "\\\"");
            if (s.IndexOf("  ", StringComparison.Ordinal) > -1) s = s.Replace("  ", " ");
            return s;
        }

        public void processNodes(String pfx, TreeNode node, StreamWriter w)
        {
            Console.WriteLine(node.Name);
            if (node.Name == "npc")
            {
                w.WriteLine("{1}npcHeader = \"{0}\";", node.Text, pfx);
                pfxs.Add(pfx, 1);
                foreach (TreeNode node2 in node.Nodes)
                {
                    processNodes(pfx, node2, w);
                }
            }
            else if (node.Name == "player")
            {
                w.WriteLine("{2}response{0} = \"{1}\";", pfxs[pfx], node.Text, pfx);
                w.WriteLine("{2}response{0}DT = new DialogTree();", pfxs[pfx], node.Text, pfx);

                foreach (TreeNode node2 in node.Nodes)
                {
                    processNodes(pfx + "response" + pfxs[pfx] + "DT.", node2, w);
                }

                pfxs[pfx]++;
            }
        }
    }
}
