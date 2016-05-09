namespace CreateQuestTreesGUI
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form1));
            this.questTree = new System.Windows.Forms.TreeView();
            this.toolStrip1 = new System.Windows.Forms.ToolStrip();
            this.tbExport = new System.Windows.Forms.ToolStripButton();
            this.toolStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // questTree
            // 
            this.questTree.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.questTree.Cursor = System.Windows.Forms.Cursors.Arrow;
            this.questTree.Location = new System.Drawing.Point(14, 28);
            this.questTree.Name = "questTree";
            this.questTree.Size = new System.Drawing.Size(761, 682);
            this.questTree.TabIndex = 0;
            this.questTree.NodeMouseClick += new System.Windows.Forms.TreeNodeMouseClickEventHandler(this.questTree_NodeMouseClick);
            this.questTree.NodeMouseDoubleClick += new System.Windows.Forms.TreeNodeMouseClickEventHandler(this.questTree_NodeMouseDoubleClick);
            // 
            // toolStrip1
            // 
            this.toolStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.tbExport});
            this.toolStrip1.Location = new System.Drawing.Point(0, 0);
            this.toolStrip1.Name = "toolStrip1";
            this.toolStrip1.Size = new System.Drawing.Size(787, 25);
            this.toolStrip1.TabIndex = 1;
            this.toolStrip1.Text = "toolStrip1";
            // 
            // tbExport
            // 
            this.tbExport.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.tbExport.Image = ((System.Drawing.Image)(resources.GetObject("tbExport.Image")));
            this.tbExport.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.tbExport.Name = "tbExport";
            this.tbExport.Size = new System.Drawing.Size(23, 22);
            this.tbExport.Text = "Export";
            this.tbExport.Click += new System.EventHandler(this.bExport_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(787, 725);
            this.Controls.Add(this.toolStrip1);
            this.Controls.Add(this.questTree);
            this.Font = new System.Drawing.Font("Consolas", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "Form1";
            this.Text = "Quest Dialog Toolkit";
            this.toolStrip1.ResumeLayout(false);
            this.toolStrip1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TreeView questTree;
        private System.Windows.Forms.ToolStrip toolStrip1;
        private System.Windows.Forms.ToolStripButton tbExport;
    }
}

