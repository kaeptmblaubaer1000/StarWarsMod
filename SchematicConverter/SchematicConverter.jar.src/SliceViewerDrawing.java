import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;

public class SliceViewerDrawing extends JPanel
{
	private static final long serialVersionUID = 6137637338570301645L;
	private SchematicManager manager;
	private Timer updateTimer;
	private BufferedImage bg;

	public SliceViewerDrawing()
	{
		this.manager = null;
		this.bg = new BufferedImage(1024, 1024, 2);
	}

	public boolean isDoubleBuffered()
	{
		return true;
	}

	public void setManagerInstance(SchematicManager manager)
	{
		this.manager = manager;
		if (manager == null)
		{
			this.bg = new BufferedImage(1024, 1024, 2);
			return;
		}

		Graphics bgGr = this.bg.getGraphics();
		bgGr.clearRect(0, 0, this.bg.getWidth(), this.bg.getHeight());

		getGraphics().drawImage(this.bg, 0, 0, null);

		this.bg = new BufferedImage(manager.getCanvasWidth(), manager.getCanvasHeight(), 2);
		this.updateTimer = new Timer("SliceViewerDrawingUpdate");
		this.updateTimer.scheduleAtFixedRate(new SliceViewerDrawing.UpdateTimer(this), 100L, 100L);
	}

	public SchematicManager getManagerInstance()
	{
		return this.manager;
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics bgGr = this.bg.getGraphics();
		bgGr.clearRect(0, 0, this.bg.getWidth(), this.bg.getHeight());
		if (this.manager != null)
		{
			this.manager.draw(bgGr);
		}
		g.drawImage(this.bg, 0, 0, null);
	}

	public class UpdateTimer extends TimerTask
	{
		SliceViewerDrawing reference;

		public UpdateTimer(SliceViewerDrawing ref)
		{
			this.reference = ref;
		}

		public void run()
		{
			this.reference.repaint();
		}
	}
}

/*
 * Location:
 * F:\Forge\schematicconverter\SchematicConverter.jar!\SliceViewerDrawing.class
 * Java compiler version: 5 (49.0) JD-Core Version: 0.7.1
 */