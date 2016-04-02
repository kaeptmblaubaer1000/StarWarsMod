using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Xml;
using System.Xml.Linq;

namespace CreateQuestTreesGUI
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void bAddNPCNode_Click(object sender, EventArgs e)
        {
            String t = "";
            if (Clipboard.ContainsText()) t = Clipboard.GetText();
            InputForm fInput = new InputForm(t);
            fInput.ShowDialog();
            if (!fInput.cancel)
            {
                TreeNode n = new TreeNode();
                n.Name = "npc";
                n.Text = fInput.text;
                n.BackColor = Color.FromArgb(0xA4C2F4);
                if (questTree.SelectedNode == null && questTree.Nodes.Count == 0)
                {
                    questTree.Nodes.Add(n);
                }
                else if (questTree.SelectedNode != null && questTree.SelectedNode.Name == "player" && questTree.SelectedNode.Nodes.Count < 3)
                {
                    questTree.SelectedNode.Nodes.Add(n);
                    questTree.SelectedNode.Expand();
                }
            }
        }

        private void bAddDialogNode_Click(object sender, EventArgs e)
        {
            String t = "";
            if (Clipboard.ContainsText()) t = Clipboard.GetText();
            InputForm fInput = new InputForm(t);
            fInput.ShowDialog();
            if (!fInput.cancel)
            {
                TreeNode n = new TreeNode();
                n.Name = "player";
                n.Text = fInput.text;
                n.BackColor = Color.Yellow;
                if (questTree.SelectedNode != null && questTree.SelectedNode.Name == "npc" && questTree.SelectedNode.Nodes.Count < 3)
                {
                    questTree.SelectedNode.Nodes.Add(n);
                    questTree.SelectedNode.Expand();
                }
            }
        }

        private void bRemoveNode_Click(object sender, EventArgs e)
        {
            if (questTree.SelectedNode != null)
            {
                questTree.Nodes.Remove(questTree.SelectedNode);
            }
        }

        private void questTree_NodeMouseDoubleClick(object sender, TreeNodeMouseClickEventArgs e)
        {
            if (questTree.SelectedNode == null) return;
            InputForm fInput = new InputForm(questTree.SelectedNode.Text);
            fInput.ShowDialog();
            if (!fInput.cancel)
            {
                questTree.SelectedNode.Text = fInput.text;
            }
        }

        private void bExport_Click(object sender, EventArgs e)
        {
            SaveFileDialog sfd = new SaveFileDialog();
            sfd.FileName = "";
            sfd.Filter = "Java Files|*.java";

            if (sfd.ShowDialog() != System.Windows.Forms.DialogResult.Cancel)
            {
                new Exporter(sfd.FileName, questTree.Nodes);
            }
        }

        private void bSave_Click(object sender, EventArgs e)
        {
            SaveFileDialog sfd = new SaveFileDialog();
            sfd.FileName = "";
            sfd.Filter = "XML Files|*.xml";

            if (sfd.ShowDialog() != System.Windows.Forms.DialogResult.Cancel)
            {
                var rootElement = new XElement("root", CreateXmlElement(questTree.Nodes));
                var document = new XDocument(rootElement);
                document.Save(sfd.FileName);
            }
        }

        private static List<XElement> CreateXmlElement(TreeNodeCollection treeViewNodes)
        {
            var elements = new List<XElement>();
            foreach (TreeNode treeViewNode in treeViewNodes)
            {
                var element = new XElement(treeViewNode.Name);
                element.SetAttributeValue(XName.Get("dialog"), treeViewNode.Text);
                element.Add(CreateXmlElement(treeViewNode.Nodes));
                elements.Add(element);
            }
            return elements;
        }

        private void bLoad_Click(object sender, EventArgs e)
        {
            OpenFileDialog ofd = new OpenFileDialog();
            ofd.FileName = "";
            ofd.Filter = "XML Files|*.xml";

            if (ofd.ShowDialog() != System.Windows.Forms.DialogResult.Cancel)
            {
                XmlDocument doc = new XmlDocument();
                doc.Load(ofd.FileName);

                questTree.Nodes.Clear();
                TreeNode tNode = new TreeNode();
                tNode.Name = "npc";
                tNode.BackColor = Color.FromArgb(0xA4C2F4);
                tNode.Text = doc.DocumentElement["npc"].Attributes[0].Value;

                AddNode(doc.DocumentElement["npc"], tNode);

                questTree.Nodes.Add(tNode);
                questTree.ExpandAll();
            }
        }

        private void AddNode(XmlNode inXmlNode, TreeNode inTreeNode)
        {
            XmlNode xNode;
            TreeNode tNode;
            XmlNodeList nodeList;

            // Loop through the XML nodes until the leaf is reached.
            // Add the nodes to the TreeView during the looping process.
            if (inXmlNode.HasChildNodes)
            {
                nodeList = inXmlNode.ChildNodes;
                for (int i = 0; i <= nodeList.Count - 1; i++)
                {
                    xNode = inXmlNode.ChildNodes[i];
                    TreeNode t = new TreeNode();
                    t.Name = xNode.Name;
                    t.Text = xNode.Attributes[0].Value;
                    if (xNode.Attributes[0].Value == "npc")
                        t.BackColor = Color.FromArgb(0xA4C2F4);
                    else
                        t.BackColor = Color.Yellow;
                    inTreeNode.Nodes.Add(t);
                    tNode = inTreeNode.Nodes[i];
                    AddNode(xNode, tNode);
                }
            }
        } 
    }
}
