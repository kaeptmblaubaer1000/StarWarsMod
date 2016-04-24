import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class UI
{
	private static int width;
	private static int height;
	private static int smallHeight = 340;
	static JFrame mainframe;
	static Container stage;
	static Insets insets;
	static HashMap<String, String> classes;
	static HashMap<String, SchematicManager> drawers;
	static int windowState = 0;
	static final int RESULT_SUCCESS = 0;
	static final int RESULT_FAILED = 1;
	static final int RESULT_NEUTRAL = 2;
	static JButton btnGenerate;
	static JButton btnAddFile;
	static JButton btnRemoveFile;
	static JButton btnSelectOutputLocation;
	static JButton btnShowSliceViewer;
	static JButton btnNextSlice;
	static JButton btnPrevSlice;
	static JButton btnAddSpawnBlock;
	static JButton btnRemoveSpawnBlock;
	static JLabel lblCurrentOutputDir;
	static JLabel lblFileList;
	static JLabel lblSliceViewer;
	static JLabel lblSliceCount;
	static JLabel lblBlockName;
	static JLabel lblHeightTolerance;
	static JLabel lblAvailableBlocks;
	static JLabel lblSpawnBlocks;
	static JTextField txtCurrentOutputDir;
	static JList<String> lsSelectedFiles;
	static DefaultListModel<String> model;
	static JList<BlockDisplay> lsAvailableBlocks;
	static JList<BlockDisplay> lsSpawnBlocks;
	static DefaultListModel<BlockDisplay> mdAvailableBlocks;
	static DefaultListModel<BlockDisplay> mdSpawnBlocks;
	static JCheckBox cbIgnoreAir;
	static JCheckBox cbSmartSpawning;
	static JScrollPane listScrollBar;
	static JScrollPane sliceViewerScrollBar;
	static JScrollPane availableBlocksScrollBar;
	static JScrollPane spawnBlocksScrollBar;
	static JSlider slHeightTolerance;
	static SliceViewerDrawing sliceViewer;
	static JFileChooser jfc;

	public UI(int width, int height)
	{
		this.width = width;
		this.height = height;
		classes = new HashMap();
		drawers = new HashMap();
	}

	public void Show()
	{
		CreateWindow();
		InitControls();
		PopulateSpawnList();
		SetWindowVisible();
	}

	private void CreateWindow()
	{
		BlockResources.instance.Init();
		mainframe = new JFrame("Parzi's Schematic to Java (MC 1.7.10) (Original by Mithon)");
		mainframe.setSize(width, smallHeight);
		mainframe.setDefaultCloseOperation(3);

		mainframe.addComponentListener(new ComponentAdapter()
		{

			public void componentResized(ComponentEvent e)
			{
			}

		});
		stage = mainframe.getContentPane();
		insets = mainframe.getInsets();
		mainframe.setLayout(null);
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (ClassNotFoundException localClassNotFoundException)
		{
		}
		catch (InstantiationException localInstantiationException)
		{
		}
		catch (IllegalAccessException localIllegalAccessException)
		{
		}
		catch (UnsupportedLookAndFeelException localUnsupportedLookAndFeelException)
		{
		}

		jfc = new JFileChooser();
		jfc.setCurrentDirectory(new File("."));
		jfc.setMultiSelectionEnabled(true);
	}

	private void SetWindowVisible()
	{
		mainframe.setVisible(true);
	}

	private void InitControls()
	{
		InstantiateControls();
		PositionControls();
		AddControlsToStage();
		AddEventListeners();
	}

	private void InstantiateControls()
	{
		btnGenerate = new JButton("Generate");
		btnAddFile = new JButton("Add File");
		btnRemoveFile = new JButton("Remove Selected File(s)");
		btnSelectOutputLocation = new JButton("Change");
		btnShowSliceViewer = new JButton("Show Slice Viewer");
		btnNextSlice = new JButton("+");
		btnPrevSlice = new JButton("-");
		btnAddSpawnBlock = new JButton("Add");
		btnRemoveSpawnBlock = new JButton("Rem");

		lblCurrentOutputDir = new JLabel("Output Directory:");
		lblFileList = new JLabel("File(s) to convert:"
				+ "                                               "
				+ "Resize to show advaced controls");
		lblSliceViewer = new JLabel("Slice Viewer:");
		lblSliceCount = new JLabel("Viewing Slice 0 of 0");
		lblBlockName = new JLabel("Unknown");
		lblAvailableBlocks = new JLabel("Known Blocks:");
		lblSpawnBlocks = new JLabel("Structure can Spawn on:");

		File outputPath = new File("Output\\");
		outputPath.mkdirs();

		txtCurrentOutputDir = new JTextField(outputPath.getAbsolutePath());
		txtCurrentOutputDir.setEnabled(false);

		model = new DefaultListModel();
		mdAvailableBlocks = new DefaultListModel();
		mdSpawnBlocks = new DefaultListModel();

		lsSelectedFiles = new JList(model);
		lsAvailableBlocks = new JList(mdAvailableBlocks);
		lsSpawnBlocks = new JList(mdSpawnBlocks);

		lsSelectedFiles.setCellRenderer(new UI.ResultCellRenderer());

		cbIgnoreAir = new JCheckBox("Ignore Air");
		cbIgnoreAir.setSelected(true);
		cbSmartSpawning = new JCheckBox("Smart Spawning Enabled");
		cbSmartSpawning.setSelected(false);

		sliceViewer = new SliceViewerDrawing();

		listScrollBar = new JScrollPane(lsSelectedFiles);
		availableBlocksScrollBar = new JScrollPane(lsAvailableBlocks);
		spawnBlocksScrollBar = new JScrollPane(lsSpawnBlocks);
		sliceViewerScrollBar = new JScrollPane(sliceViewer);

		slHeightTolerance = new JSlider(0, 25, 0);
		lblHeightTolerance = new JLabel("Spawn Height Tolerance: 00");
	}

	private void PositionControls()
	{
		lblFileList.setBounds(insets.left + 5, insets.top + 5, lblFileList.getPreferredSize().width, lblFileList.getPreferredSize().height);
		lblSliceCount.setBounds(width, insets.top + 5, 200, lblSliceCount.getPreferredSize().height);
		lblBlockName.setBounds(lblSliceCount.getX() + lblSliceCount.getWidth() + 5, insets.top + 5, 300, lblBlockName.getPreferredSize().height);

		listScrollBar.setBounds(insets.left + 5, lblFileList.getY() + lblFileList.getHeight() + 5, width - 30, 200);
		sliceViewerScrollBar.setBounds(width + 25, insets.top + 5 + lblSliceCount.getHeight(), width, height - lblSliceCount.getHeight() - 55);
		sliceViewerScrollBar.setPreferredSize(new Dimension(sliceViewerScrollBar.getWidth(), sliceViewerScrollBar.getHeight()));
		sliceViewerScrollBar.setMinimumSize(new Dimension(sliceViewerScrollBar.getWidth(), sliceViewerScrollBar.getHeight()));
		sliceViewerScrollBar.setMaximumSize(new Dimension(sliceViewerScrollBar.getWidth(), sliceViewerScrollBar.getHeight()));
		btnNextSlice.setBounds(sliceViewerScrollBar.getX() + sliceViewerScrollBar.getWidth() + 2, sliceViewerScrollBar.getY(), btnNextSlice.getPreferredSize().width, btnNextSlice.getPreferredSize().height);
		btnPrevSlice.setBounds(sliceViewerScrollBar.getX() + sliceViewerScrollBar.getWidth() + 2, sliceViewerScrollBar.getY() + sliceViewerScrollBar.getHeight() - btnPrevSlice.getPreferredSize().height, btnPrevSlice.getPreferredSize().width, btnPrevSlice.getPreferredSize().height);

		btnAddFile.setBounds(insets.left + 5, listScrollBar.getY() + listScrollBar.getHeight() + 5, btnAddFile.getPreferredSize().width, btnAddFile.getPreferredSize().height);
		btnRemoveFile.setBounds(width - 30 - btnRemoveFile.getPreferredSize().width, listScrollBar.getY() + listScrollBar.getHeight() + 5, btnRemoveFile.getPreferredSize().width, btnRemoveFile.getPreferredSize().height);

		lblCurrentOutputDir.setBounds(insets.left + 5, btnAddFile.getY() + btnAddFile.getHeight() + 5, lblCurrentOutputDir.getPreferredSize().width, lblCurrentOutputDir.getPreferredSize().height);
		btnSelectOutputLocation.setBounds(width - 30 - btnSelectOutputLocation.getPreferredSize().width, lblCurrentOutputDir.getY() + lblCurrentOutputDir.getHeight() + 5, btnSelectOutputLocation.getPreferredSize().width, txtCurrentOutputDir.getPreferredSize().height);
		txtCurrentOutputDir.setBounds(insets.left + 5, lblCurrentOutputDir.getY() + lblCurrentOutputDir.getHeight() + 5, width - 30 - btnSelectOutputLocation.getWidth() - 5, txtCurrentOutputDir.getPreferredSize().height);

		btnGenerate.setBounds(width - 30 - btnGenerate.getPreferredSize().width, 0, btnGenerate.getPreferredSize().width, btnGenerate.getPreferredSize().height);

		cbIgnoreAir.setBounds(insets.left + 5, txtCurrentOutputDir.getY() + txtCurrentOutputDir.getHeight() + 5, cbIgnoreAir.getPreferredSize().width, cbIgnoreAir.getPreferredSize().height);
		cbSmartSpawning.setBounds(insets.left + 5, cbIgnoreAir.getY() + cbIgnoreAir.getHeight() + 5, cbSmartSpawning.getPreferredSize().width, cbSmartSpawning.getPreferredSize().height);

		lblHeightTolerance.setBounds(insets.left + 5, cbSmartSpawning.getY() + cbSmartSpawning.getHeight() + 5, lblHeightTolerance.getPreferredSize().width, lblHeightTolerance.getPreferredSize().height);
		slHeightTolerance.setBounds(lblHeightTolerance.getX() + lblHeightTolerance.getWidth() + 5, lblHeightTolerance.getY(), slHeightTolerance.getPreferredSize().width, slHeightTolerance.getPreferredSize().height);

		availableBlocksScrollBar.setBounds(insets.left + 5, slHeightTolerance.getY() + slHeightTolerance.getHeight() + 20, availableBlocksScrollBar.getPreferredSize().width, availableBlocksScrollBar.getPreferredSize().height);
		spawnBlocksScrollBar.setBounds(width - spawnBlocksScrollBar.getPreferredSize().width - 30, availableBlocksScrollBar.getY(), spawnBlocksScrollBar.getPreferredSize().width, spawnBlocksScrollBar.getPreferredSize().height);

		lblAvailableBlocks.setBounds(availableBlocksScrollBar.getX(), availableBlocksScrollBar.getY() - lblAvailableBlocks.getPreferredSize().height - 3, lblAvailableBlocks.getPreferredSize().width, lblAvailableBlocks.getPreferredSize().height);
		lblSpawnBlocks.setBounds(spawnBlocksScrollBar.getX(), spawnBlocksScrollBar.getY() - lblSpawnBlocks.getPreferredSize().height - 3, lblSpawnBlocks.getPreferredSize().width, lblSpawnBlocks.getPreferredSize().height);

		int spawnControlXPos = (spawnBlocksScrollBar.getX() - (availableBlocksScrollBar.getX() + availableBlocksScrollBar.getWidth()) - btnAddSpawnBlock.getPreferredSize().width) / 2 + availableBlocksScrollBar.getX() + availableBlocksScrollBar.getWidth();
		int spawnControlBaseYPos = availableBlocksScrollBar.getY() + availableBlocksScrollBar.getHeight() / 2 - btnAddSpawnBlock.getPreferredSize().height / 2;

		btnAddSpawnBlock.setBounds(spawnControlXPos, spawnControlBaseYPos - btnAddSpawnBlock.getPreferredSize().height - 5, btnAddSpawnBlock.getPreferredSize().width, btnAddSpawnBlock.getPreferredSize().height);
		btnRemoveSpawnBlock.setBounds(spawnControlXPos, spawnControlBaseYPos + btnRemoveSpawnBlock.getPreferredSize().height + 5, btnRemoveSpawnBlock.getPreferredSize().width, btnRemoveSpawnBlock.getPreferredSize().height);

		btnShowSliceViewer.setBounds(width - 30 - btnShowSliceViewer.getPreferredSize().width, cbSmartSpawning.getY(), btnShowSliceViewer.getPreferredSize().width, btnShowSliceViewer.getPreferredSize().height);
	}

	private void AddControlsToStage()
	{
		stage.add(lblAvailableBlocks);
		stage.add(lblSpawnBlocks);
		stage.add(lblFileList);
		stage.add(lblSliceCount);
		stage.add(listScrollBar);
		stage.add(lblBlockName);
		stage.add(sliceViewerScrollBar);
		stage.add(btnNextSlice);
		stage.add(btnPrevSlice);
		stage.add(btnAddFile);
		stage.add(btnRemoveFile);
		stage.add(lblCurrentOutputDir);
		stage.add(txtCurrentOutputDir);
		stage.add(cbSmartSpawning);
		stage.add(cbIgnoreAir);
		stage.add(btnGenerate);
		stage.add(btnSelectOutputLocation);

		stage.add(slHeightTolerance);
		stage.add(lblHeightTolerance);
		stage.add(availableBlocksScrollBar);
		stage.add(spawnBlocksScrollBar);
		stage.add(btnAddSpawnBlock);
		stage.add(btnRemoveSpawnBlock);
	}

	private void AddEventListeners()
	{
		btnGenerate.addActionListener(new UI.GenerateClicked());
		btnAddFile.addActionListener(new UI.AddClicked());
		btnRemoveFile.addActionListener(new UI.RemoveClicked());
		btnSelectOutputLocation.addActionListener(new UI.ChangeDirectoryClicked());
		btnShowSliceViewer.addActionListener(new UI.ShowSliceViewerClicked());
		lsSelectedFiles.addListSelectionListener(new UI.CurrentSchematicFileChanged());
		btnNextSlice.addActionListener(new UI.IncrementCurrentSlice());
		btnPrevSlice.addActionListener(new UI.DecrementCurrentSlice());
		cbIgnoreAir.addChangeListener(new UI.IgnoreAirClicked());
		sliceViewer.addMouseListener(new UI.SchematicMouseHandler());
		sliceViewer.addMouseMotionListener(new UI.SchematicMouseMovementHandler());
		slHeightTolerance.addChangeListener(new UI.HeightToleranceScrollHandler());
		cbSmartSpawning.addChangeListener(new UI.SmartSpawningClicked());
		btnAddSpawnBlock.addActionListener(new UI.AddSpawnBlockClicked());
		btnRemoveSpawnBlock.addActionListener(new UI.RemoveSpawnBlockClicked());
	}

	private void PopulateSpawnList()
	{
		TextureMappingData[] arrayOfTextureMappingData;
		int j = (arrayOfTextureMappingData = BlockResources.instance.getAllTextureMappingData()).length;
		for (int i = 0; i < j; i++)
		{
			TextureMappingData tmd = arrayOfTextureMappingData[i];
			BlockDisplay bd = new BlockDisplay(tmd.getName(), tmd.getBlockID());
			mdAvailableBlocks.add(mdAvailableBlocks.size(), bd);
		}
	}

	private static void ToggleSliceViewer()
	{
		boolean sliceViewerVisible = (windowState & 0x1) == 1;
		if (sliceViewerVisible)
		{
			mainframe.setSize(width, height);
			windowState &= 0xFFFFFFFE;
			btnShowSliceViewer.setText("Show Slice Viewer");
		}
		else
		{
			mainframe.setSize(width * 2 + 85, height);
			windowState |= 0x1;
			btnShowSliceViewer.setText("Hide Slice Viewer");
		}
	}

	private static void HideSliceViewer()
	{
		mainframe.setSize(width, height);
		windowState &= 0xFFFFFFFE;
		btnShowSliceViewer.setText("Show Slice Viewer");
	}

	private static void ShowSliceViewer()
	{
		mainframe.setSize(width * 2 + 85, height);
		windowState |= 0x1;
		btnShowSliceViewer.setText("Hide Slice Viewer");
	}

	private static void HideAdvancedOptions()
	{
		HideSliceViewer();
		mainframe.setSize(mainframe.getWidth(), smallHeight);
	}

	private static void ShowAdvancedOptions()
	{
		mainframe.setSize(mainframe.getWidth(), height);
		ShowSliceViewer();
	}

	private static void SetIndexColorBasedOnResult(String className, int state)
	{
		int index = -1;
		for (int i = 0; i < model.size(); i++)
		{
			String s = ((String)model.get(i)).toString();
			if (s.endsWith("[" + className + "]"))
			{
				index = i;
				break;
			}
		}
		if (index == -1) { return; }
		String label = ((String)model.get(index)).toString();
		switch (state)
		{
			case 0:
				label = label + "[success]";
				break;
			case 1:
				label = label + "[failed]";
				break;
			case 2:
				label = label.replace("[success]", "").replace("[failure]", "");
		}

		model.set(index, label);
	}

	public static class AddClicked implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			UI.jfc.setAcceptAllFileFilterUsed(false);
			UI.jfc.setFileFilter(new SchematicFilter());
			int returnVal = UI.jfc.showOpenDialog(UI.mainframe);
			if (returnVal == 0)
			{
				File[] files = UI.jfc.getSelectedFiles();
				File[] arrayOfFile1;
				int j = (arrayOfFile1 = files).length;
				for (int i = 0; i < j; i++)
				{
					File f = arrayOfFile1[i];
					String key = f.getPath();
					String value = f.getName().replace(".schematic", "").replaceAll("[^A-Za-z0-9_]", "");
					if (!UI.classes.containsKey(key))
					{

						UI.classes.put(key, value);
						SchematicManager drawer = new SchematicManager();
						drawer.setFileName(key, UI.cbIgnoreAir.isSelected());
						UI.drawers.put(key, drawer);
						UI.model.add(UI.model.size(), key + "[" + value + "]");
						Logging.instance.info("Added " + key + " to the list of files to convert.");
					}
				}
			}
		}
	}

	public static class AddSpawnBlockClicked implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			SchematicManager manager = UI.sliceViewer.getManagerInstance();
			if (manager == null) { return; }

			List<BlockDisplay> values = UI.lsAvailableBlocks.getSelectedValuesList();
			if (values.size() == 0) { return; }
			for (Object value : values)
			{
				BlockDisplay itemToAdd = (BlockDisplay)value;
				if (!UI.mdSpawnBlocks.contains(itemToAdd))
				{
					UI.mdSpawnBlocks.add(UI.mdSpawnBlocks.size(), itemToAdd);
					manager.AddAllowedSpawnBlock(itemToAdd.blockID);
				}
			}
		}
	}

	public static class ChangeDirectoryClicked implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JFileChooser workingDirChooser = new JFileChooser();
			workingDirChooser.setFileSelectionMode(1);
			workingDirChooser.setDialogTitle("Set Output Directory");
			File fi = new File(UI.txtCurrentOutputDir.getText());
			if (fi.exists())
			{
				workingDirChooser.setCurrentDirectory(fi);
			}
			int returnVal = workingDirChooser.showOpenDialog(UI.mainframe);
			if (returnVal == 0)
			{
				UI.txtCurrentOutputDir.setText(workingDirChooser.getSelectedFile().getPath());
				Logging.instance.fine("Set " + UI.txtCurrentOutputDir.getText() + " as the current working directory");
			}
		}
	}

	public static class CurrentSchematicFileChanged implements ListSelectionListener
	{
		public void valueChanged(ListSelectionEvent e)
		{
			if (UI.lsSelectedFiles.getSelectedIndices().length != 1)
			{
				UI.sliceViewer.setManagerInstance(null);
				UI.lblSliceCount.setText("Viewing Slice 0 of 0");
				return;
			}
			String s = ((String)UI.lsSelectedFiles.getSelectedValue()).toString();
			String cls = s.substring(0, s.indexOf("["));
			SchematicManager manager = (SchematicManager)UI.drawers.get(cls);
			UI.sliceViewer.setPreferredSize(new Dimension(manager.getCanvasWidth(), manager.getCanvasHeight()));
			UI.sliceViewer.setManagerInstance(manager);

			UI.sliceViewerScrollBar.revalidate();

			UI.lblSliceCount.setText("Viewing Slice " + manager.getCurrentSlice() + " of " + manager.getSliceCount());
			UI.slHeightTolerance.setValue(manager.getSpawnVarianceTolerance());

			UI.cbIgnoreAir.setSelected(manager.GetIgnoreAir());
			UI.cbSmartSpawning.setSelected(manager.GetConditionalSpawning());

			Integer[] spawnBlocks = manager.getAllowedSpawnBlocks();
			UI.mdSpawnBlocks.clear();
			Integer[] arrayOfInteger1;
			int j = (arrayOfInteger1 = spawnBlocks).length;
			for (int i = 0; i < j; i++)
			{
				Integer i2 = arrayOfInteger1[i];
				TextureMappingData tmd = BlockResources.instance.getTextureMappingData(i2.intValue());
				if (tmd != null)
				{
					BlockDisplay bd = new BlockDisplay(tmd.getName(), tmd.getBlockID());
					UI.mdSpawnBlocks.add(UI.mdSpawnBlocks.size(), bd);
				}
			}
		}
	}

	public static class DecrementCurrentSlice implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			SchematicManager manager = UI.sliceViewer.getManagerInstance();
			if (manager == null) { return; }
			manager.decrementSlice();
			UI.lblSliceCount.setText("Viewing Slice " + manager.getCurrentSlice() + " of " + manager.getSliceCount());
		}
	}

	public static class GenerateClicked implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			if (UI.classes.size() == 0)
			{
				JOptionPane.showMessageDialog(UI.mainframe, "Might want to select a file to convert first, no?");
				return;
			}

			if ((UI.cbSmartSpawning.isSelected()) && (!allManagersHaveAtLeastOneSpawnBlock()))
			{
				JOptionPane.showMessageDialog(UI.mainframe, "One or more of your structures doesn't have a spawn block set...meaning it will never spawn!");
				return;
			}

			Iterator<String> classIterator = UI.classes.keySet().iterator();

			while (classIterator.hasNext())
			{
				String className = (String)classIterator.next();
				UI.SetIndexColorBasedOnResult(className, 2);
			}

			for (String inFile : UI.drawers.keySet())
			{
				Converter c = new Converter();

				String cls = (String)UI.classes.get(inFile);
				SchematicManager manager = (SchematicManager)UI.drawers.get(inFile);
				UI.SetIndexColorBasedOnResult(cls, c.Convert(UI.txtCurrentOutputDir.getText(), cls, manager) ? 0 : 1);
			}
		}

		private boolean allManagersHaveAtLeastOneSpawnBlock()
		{
			for (SchematicManager manager : UI.drawers.values())
			{
				if (manager.getAllowedSpawnBlocks().length == 0) { return false; }
			}
			return true;
		}
	}

	public static class HeightToleranceScrollHandler implements ChangeListener
	{
		public void stateChanged(ChangeEvent arg0)
		{
			SchematicManager manager = UI.sliceViewer.getManagerInstance();
			if (manager != null)
			{
				manager.setSpawnVarianceTolerance(UI.slHeightTolerance.getValue());
				UI.lblHeightTolerance.setText("Spawn Height Tolerance: " + UI.slHeightTolerance.getValue());
			}
		}
	}

	public static class IgnoreAirClicked implements ChangeListener
	{
		public void stateChanged(ChangeEvent arg0)
		{
			SchematicManager manager = UI.sliceViewer.getManagerInstance();
			if (manager != null)
			{
				manager.toggleIgnoreAir(UI.cbIgnoreAir.isSelected());
			}
		}
	}

	public static class IncrementCurrentSlice implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			SchematicManager manager = UI.sliceViewer.getManagerInstance();
			if (manager == null) { return; }
			manager.incrementSlice();
			UI.lblSliceCount.setText("Viewing Slice " + manager.getCurrentSlice() + " of " + manager.getSliceCount());
		}
	}

	public static class RemoveClicked implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			List<String> selectedItems = UI.lsSelectedFiles.getSelectedValuesList();
			for (Object o : selectedItems)
			{
				String key = o.toString().substring(0, o.toString().indexOf("["));
				if (UI.classes.containsKey(key))
				{
					UI.classes.remove(key);
					UI.drawers.remove(key);
					Logging.instance.fine("Removed  " + key + " from the list of files to convert.");
				}
			}

			if (UI.lsSelectedFiles.getSelectedIndices().length > 0)
			{
				int[] tmp = UI.lsSelectedFiles.getSelectedIndices();
				int[] selectedIndices = UI.lsSelectedFiles.getSelectedIndices();

				for (int i = tmp.length - 1; i >= 0; i--)
				{
					selectedIndices = UI.lsSelectedFiles.getSelectedIndices();
					UI.model.removeElementAt(selectedIndices[i]);
				}
			}
		}
	}

	public static class RemoveSpawnBlockClicked implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			SchematicManager manager = UI.sliceViewer.getManagerInstance();
			if (manager == null) { return; }

			List<BlockDisplay> values = UI.lsSpawnBlocks.getSelectedValuesList();
			if (values.size() == 0) { return; }
			for (Object value : values)
			{
				BlockDisplay itemToRemove = (BlockDisplay)value;
				if (UI.mdSpawnBlocks.contains(itemToRemove))
				{
					UI.mdSpawnBlocks.removeElement(itemToRemove);
					manager.RemoveAllowedSpawnBlock(itemToRemove.blockID);
				}
			}
		}
	}

	class ResultCellRenderer extends JLabel implements ListCellRenderer<Object>
	{
		public ResultCellRenderer()
		{
			setOpaque(true);
		}

		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus)
		{
			setText(value.toString());
			if (isSelected)
			{
				setBackground(Color.BLUE);
				setForeground(Color.WHITE);
			}
			else
			{
				setForeground(Color.BLACK);
				if (value.toString().contains("[success]"))
				{
					setBackground(Color.GREEN);
				}
				else if (value.toString().contains("[failure]"))
				{
					setBackground(Color.RED);
				}
				else
				{
					setBackground(Color.WHITE);
				}
			}
			return this;
		}
	}

	public static class SchematicMouseHandler implements MouseListener
	{
		public void mouseClicked(MouseEvent arg0)
		{
			int x = arg0.getX() / 16;
			int z = arg0.getY() / 16;
			int btn = arg0.getButton();

			if (btn != 1) { return; }

			SchematicManager manager = UI.sliceViewer.getManagerInstance();
			if (manager != null)
			{
				manager.toggleBlockIgnored(x, z);
			}
		}

		public void mouseEntered(MouseEvent arg0)
		{
		}

		public void mouseExited(MouseEvent arg0)
		{
		}

		public void mousePressed(MouseEvent arg0)
		{
		}

		public void mouseReleased(MouseEvent arg0)
		{
		}
	}

	public static class SchematicMouseMovementHandler implements MouseMotionListener
	{
		public void mouseDragged(MouseEvent arg0)
		{
		}

		public void mouseMoved(MouseEvent arg0)
		{
			int x = arg0.getX() / 16;
			int z = arg0.getY() / 16;

			SchematicManager manager = UI.sliceViewer.getManagerInstance();
			if (manager == null) { return; }
			UI.lblBlockName.setText(manager.getBlockNameAt(x, z));
		}
	}

	public static class ShowSliceViewerClicked implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
		}
	}

	public static class SmartSpawningClicked implements ChangeListener
	{
		public void stateChanged(ChangeEvent arg0)
		{
			SchematicManager manager = UI.sliceViewer.getManagerInstance();

			if (UI.cbSmartSpawning.isSelected())
			{
				setControlsEnabled(true);
				if (manager != null)
				{
					manager.SetConditionalSpawning(true);
				}
			}
			else
			{
				setControlsEnabled(false);
				if (manager != null)
				{
					manager.SetConditionalSpawning(false);
				}
			}
		}

		private void setControlsEnabled(boolean enabled)
		{
			UI.lsAvailableBlocks.setEnabled(enabled);
			UI.lsSpawnBlocks.setEnabled(enabled);
			UI.btnAddSpawnBlock.setEnabled(enabled);
			UI.btnRemoveSpawnBlock.setEnabled(enabled);
			UI.slHeightTolerance.setEnabled(enabled);
		}
	}
}

/*
 * Location: F:\Forge\schematicconverter\SchematicConverter.jar!\UI.class Java
 * compiler version: 5 (49.0) JD-Core Version: 0.7.1
 */