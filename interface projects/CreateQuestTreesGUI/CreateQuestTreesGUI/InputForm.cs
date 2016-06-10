using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace CreateQuestTreesGUI
{
    public partial class InputForm : Form
    {
        public String text = "";
        public bool cancel = true;

        public InputForm(String text)
        {
            InitializeComponent();
            this.textQuestText.Text = text;
            textQuestText.Focus();
        }

        private void toolStripButton3_Click(object sender, EventArgs e)
        {
            this.text = Exporter.FixString(textQuestText.Text);
            cancel = false;
            this.Close();
        }

        private void toolStripButton2_Click(object sender, EventArgs e)
        {
            if (!Clipboard.ContainsText()) return;
            textQuestText.Text = Clipboard.GetText();
        }

        private void toolStripButton1_Click(object sender, EventArgs e)
        {
            Clipboard.SetText(textQuestText.SelectedText);
        }
    }
}
