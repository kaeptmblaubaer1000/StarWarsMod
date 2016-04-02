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
            this.bAddNPCNode = new System.Windows.Forms.Button();
            this.bRemoveNode = new System.Windows.Forms.Button();
            this.bAddDialogNode = new System.Windows.Forms.Button();
            this.bExport = new System.Windows.Forms.Button();
            this.bSave = new System.Windows.Forms.Button();
            this.bLoad = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // questTree
            // 
            this.questTree.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.questTree.Cursor = System.Windows.Forms.Cursors.Arrow;
            this.questTree.Location = new System.Drawing.Point(14, 14);
            this.questTree.Name = "questTree";
            this.questTree.Size = new System.Drawing.Size(634, 696);
            this.questTree.TabIndex = 0;
            this.questTree.NodeMouseDoubleClick += new System.Windows.Forms.TreeNodeMouseClickEventHandler(this.questTree_NodeMouseDoubleClick);
            // 
            // bAddNPCNode
            // 
            this.bAddNPCNode.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.bAddNPCNode.FlatStyle = System.Windows.Forms.FlatStyle.Popup;
            this.bAddNPCNode.Image = ((System.Drawing.Image)(resources.GetObject("bAddNPCNode.Image")));
            this.bAddNPCNode.ImageAlign = System.Drawing.ContentAlignment.TopLeft;
            this.bAddNPCNode.Location = new System.Drawing.Point(656, 14);
            this.bAddNPCNode.Name = "bAddNPCNode";
            this.bAddNPCNode.Size = new System.Drawing.Size(118, 43);
            this.bAddNPCNode.TabIndex = 1;
            this.bAddNPCNode.Text = "Add NPC Response";
            this.bAddNPCNode.UseVisualStyleBackColor = true;
            this.bAddNPCNode.Click += new System.EventHandler(this.bAddNPCNode_Click);
            // 
            // bRemoveNode
            // 
            this.bRemoveNode.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.bRemoveNode.FlatStyle = System.Windows.Forms.FlatStyle.Popup;
            this.bRemoveNode.Location = new System.Drawing.Point(656, 668);
            this.bRemoveNode.Name = "bRemoveNode";
            this.bRemoveNode.Size = new System.Drawing.Size(118, 43);
            this.bRemoveNode.TabIndex = 2;
            this.bRemoveNode.Text = "Remove Selected";
            this.bRemoveNode.UseVisualStyleBackColor = true;
            this.bRemoveNode.Click += new System.EventHandler(this.bRemoveNode_Click);
            // 
            // bAddDialogNode
            // 
            this.bAddDialogNode.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.bAddDialogNode.FlatStyle = System.Windows.Forms.FlatStyle.Popup;
            this.bAddDialogNode.Image = ((System.Drawing.Image)(resources.GetObject("bAddDialogNode.Image")));
            this.bAddDialogNode.ImageAlign = System.Drawing.ContentAlignment.TopLeft;
            this.bAddDialogNode.Location = new System.Drawing.Point(656, 63);
            this.bAddDialogNode.Name = "bAddDialogNode";
            this.bAddDialogNode.Size = new System.Drawing.Size(118, 43);
            this.bAddDialogNode.TabIndex = 3;
            this.bAddDialogNode.Text = "Add Player Response";
            this.bAddDialogNode.UseVisualStyleBackColor = true;
            this.bAddDialogNode.Click += new System.EventHandler(this.bAddDialogNode_Click);
            // 
            // bExport
            // 
            this.bExport.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.bExport.FlatStyle = System.Windows.Forms.FlatStyle.Popup;
            this.bExport.Image = ((System.Drawing.Image)(resources.GetObject("bExport.Image")));
            this.bExport.ImageAlign = System.Drawing.ContentAlignment.TopLeft;
            this.bExport.Location = new System.Drawing.Point(656, 411);
            this.bExport.Name = "bExport";
            this.bExport.Size = new System.Drawing.Size(118, 43);
            this.bExport.TabIndex = 4;
            this.bExport.Text = "Export Java";
            this.bExport.UseVisualStyleBackColor = true;
            this.bExport.Click += new System.EventHandler(this.bExport_Click);
            // 
            // bSave
            // 
            this.bSave.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.bSave.Enabled = false;
            this.bSave.FlatStyle = System.Windows.Forms.FlatStyle.Popup;
            this.bSave.Image = ((System.Drawing.Image)(resources.GetObject("bSave.Image")));
            this.bSave.ImageAlign = System.Drawing.ContentAlignment.TopLeft;
            this.bSave.Location = new System.Drawing.Point(656, 262);
            this.bSave.Name = "bSave";
            this.bSave.Size = new System.Drawing.Size(118, 43);
            this.bSave.TabIndex = 5;
            this.bSave.Text = "Save XML";
            this.bSave.UseVisualStyleBackColor = true;
            this.bSave.Click += new System.EventHandler(this.bSave_Click);
            // 
            // bLoad
            // 
            this.bLoad.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.bLoad.Enabled = false;
            this.bLoad.FlatStyle = System.Windows.Forms.FlatStyle.Popup;
            this.bLoad.Image = ((System.Drawing.Image)(resources.GetObject("bLoad.Image")));
            this.bLoad.ImageAlign = System.Drawing.ContentAlignment.TopLeft;
            this.bLoad.Location = new System.Drawing.Point(656, 312);
            this.bLoad.Name = "bLoad";
            this.bLoad.Size = new System.Drawing.Size(118, 43);
            this.bLoad.TabIndex = 6;
            this.bLoad.Text = "Load XML";
            this.bLoad.UseVisualStyleBackColor = true;
            this.bLoad.Click += new System.EventHandler(this.bLoad_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(787, 725);
            this.Controls.Add(this.bLoad);
            this.Controls.Add(this.bSave);
            this.Controls.Add(this.bExport);
            this.Controls.Add(this.bAddDialogNode);
            this.Controls.Add(this.bRemoveNode);
            this.Controls.Add(this.bAddNPCNode);
            this.Controls.Add(this.questTree);
            this.Font = new System.Drawing.Font("Consolas", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Name = "Form1";
            this.Text = "Quest Dialog Toolkit";
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button bAddNPCNode;
        private System.Windows.Forms.Button bRemoveNode;
        private System.Windows.Forms.Button bAddDialogNode;
        private System.Windows.Forms.Button bExport;
        private System.Windows.Forms.Button bSave;
        private System.Windows.Forms.Button bLoad;
        private System.Windows.Forms.TreeView questTree;
    }
}

