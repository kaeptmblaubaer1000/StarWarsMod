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
