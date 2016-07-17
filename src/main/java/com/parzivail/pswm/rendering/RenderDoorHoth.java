package com.parzivail.pswm.rendering;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.entities.EntityTilePassthrough;
import com.parzivail.pswm.models.blocks.ModelDoorHoth;
import com.parzivail.pswm.tileentities.TileEntityDoorHoth;
import com.parzivail.util.block.TileEntityRotate;
import com.parzivail.util.ui.P3D;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class RenderDoorHoth extends TileEntitySpecialRenderer
{
	public static ResourceLocation texture = new ResourceLocation(Resources.MODID + ":" + "textures/models/doorHoth.png");

	private final ModelBase model;

	public RenderDoorHoth()
	{
		this.model = new ModelDoorHoth();
	}

	private void adjustRotatePivotViaMeta(World world, int x, int y, int z)
	{
	}

	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float p)
	{
		GL11.glPushMatrix();
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		GL11.glTranslated(x + 0.5f, y + 1.5f, z + 0.5f);
		GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
		P3D.glScalef(1.25f);
		if (te instanceof TileEntityRotate)
			GL11.glRotatef(90 * ((TileEntityDoorHoth)te).getFacing(), 0, 1, 0);

		TileEntityDoorHoth door = (TileEntityDoorHoth)te;

		if (te.getWorldObj().getEntitiesWithinAABB(Entity.class, te.getRenderBoundingBox().expand(3, 3, 3)).size() > 0)
		{
			door.isClosing = false;
			door.isOpening = true;
		}
		else
		{
			door.isClosing = true;
			door.isOpening = false;
		}

		p = door.isMoving ? door.isOpening ? p : -p : 0;

		p = door.progressTicks + 1 > door.totalTicks || door.progressTicks - 1 <= 0 ? 0 : p;

		float percent = (door.progressTicks + p) / door.totalTicks;

		((ModelDoorHoth)this.model).DoorParent.offsetY = -2.75f * percent;
		((ModelDoorHoth)this.model).DoorChild1.offsetY = -2.75f * percent;
		((ModelDoorHoth)this.model).DoorChild2.offsetY = -2.75f * percent;
		((ModelDoorHoth)this.model).DoorChild3.offsetY = -2.75f * percent;
		((ModelDoorHoth)this.model).DoorChild4.offsetY = -2.75f * percent;
		((ModelDoorHoth)this.model).DoorChild5.offsetY = -2.75f * percent;
		((ModelDoorHoth)this.model).DoorChild6.offsetY = -2.75f * percent;

		this.model.render(new EntityTilePassthrough(te), 0, 0, 0, 0.0F, 0.0F, 0.05F);
		GL11.glPopMatrix();
	}
}

