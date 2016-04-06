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
            this.text = textQuestText.Text;
            if (this.text.IndexOf('\u2013') > -1) this.text = this.text.Replace('\u2013', '-');
            if (this.text.IndexOf('\u2014') > -1) this.text = this.text.Replace('\u2014', '-');
            if (this.text.IndexOf('\u2015') > -1) this.text = this.text.Replace('\u2015', '-');
            if (this.text.IndexOf('\u2017') > -1) this.text = this.text.Replace('\u2017', '_');
            if (this.text.IndexOf('\u2018') > -1) this.text = this.text.Replace('\u2018', '\'');
            if (this.text.IndexOf('\u2019') > -1) this.text = this.text.Replace('\u2019', '\'');
            if (this.text.IndexOf('\u201a') > -1) this.text = this.text.Replace('\u201a', ',');
            if (this.text.IndexOf('\u201b') > -1) this.text = this.text.Replace('\u201b', '\'');
            if (this.text.IndexOf('\u201c') > -1) this.text = this.text.Replace('\u201c', '\"');
            if (this.text.IndexOf('\u201d') > -1) this.text = this.text.Replace('\u201d', '\"');
            if (this.text.IndexOf('\u201e') > -1) this.text = this.text.Replace('\u201e', '\"');
            if (this.text.IndexOf('\u2026') > -1) this.text = this.text.Replace("\u2026", "...");
            if (this.text.IndexOf('\u2032') > -1) this.text = this.text.Replace('\u2032', '\'');
            if (this.text.IndexOf('\u2033') > -1) this.text = this.text.Replace('\u2033', '\"');
            if (this.text.IndexOf('"') > -1) this.text = this.text.Replace("\"", "\\\"");
            if (this.text.IndexOf("  ") > -1) this.text = this.text.Replace("  ", " ");
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
