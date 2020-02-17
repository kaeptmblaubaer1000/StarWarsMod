package com.parzivail.util.entity;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.mobs.EntityDroidBase;
import com.parzivail.util.math.RaytraceHit;
import com.parzivail.util.math.RaytraceHitBlock;
import com.parzivail.util.math.RaytraceHitEntity;
import com.parzivail.util.ui.LangUtils;
import com.parzivail.util.ui.Lumberjack;
import com.parzivail.util.world.WorldUtils;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class EntityUtils
{
	@SuppressWarnings("unchecked")
	public static final Map<Integer, Class<? extends Entity>> IDtoClassMapping = (Map<Integer, Class<? extends Entity>>)EntityList.IDtoClassMapping;
	@SuppressWarnings("unchecked")
	public static final Map<Integer, EntityList.EntityEggInfo> entityEggs = (Map<Integer, EntityList.EntityEggInfo>)EntityList.entityEggs;

	private static int mobId = 300;

	/**
	 * Gets the Droid sitting message
	 *
	 * @param isSitting Whether or not the target is sitting
	 *
	 * @return The appropriate string based on isSitting
	 */
	public static String getDroidSittingMessage(boolean isSitting)
	{
		return isSitting ? "Restrained" : "Unrestrained";
	}

	/**
	 * Gets the Debug text of a Rebel droid based on the given parameters about the droid
	 *
	 * @return The List<String> of debug text
	 */
	public static List<String> getRebelDroidDebugText(EntityDroidBase droid, List<String> list, EntityPlayer player, World world, int x, int y, int z)
	{
		list.add(droid.isTamed() ? LangUtils.translate("owned") : LangUtils.translate("for.sale"));
		if (droid.getOwner() != null)
			list.add(LangUtils.translate("owner.0", droid.getOwner().getCommandSenderName()));
		list.add(droid.isSitting() ? LangUtils.translate("restrained") : LangUtils.translate("unrestrained"));

		return list;
	}

	/**
	 * Gets the Debug text of a Rebel droid based on the given parameters about the droid
	 *
	 * @return The List<String> of debug text
	 */
	public static List<String> getImperialDroidDebugText(EntityDroidBase droid, List<String> list, EntityPlayer player, World world, int x, int y, int z)
	{
		list.add(droid.isTamed() ? LangUtils.translate("hacked") : LangUtils.translate("employed"));
		if (droid.getOwner() != null)
			list.add("Hacker: " + droid.getOwner().getCommandSenderName());
		list.add(droid.isSitting() ? LangUtils.translate("restrained") : LangUtils.translate("unrestrained"));

		return list;
	}

	/**
	 * Gets the last used Mob ID
	 */
	public static int getLastUsedId()
	{
		return mobId;
	}

	/**
	 * Ray-traces from the given entity's POV
	 *
	 * @param distance   The range of the trace
	 * @param fromEntity The POV entity
	 * @param exclude    The entity references to exclude (Note: not classes, but
	 *                   inequality between two entity pointers)
	 *
	 * @return Returns the entity the trace hit, or null if none is hit
	 */
	public static Entity rayTrace(int distance, EntityLivingBase fromEntity, Entity[] exclude)
	{
		if (fromEntity != null)
			if (fromEntity.worldObj != null)
			{
				Entity pointedEntity = null;
				MovingObjectPosition objectMouseOver = fromEntity.rayTrace(distance, 1);
				double d1 = distance;
				Vec3 vec3 = fromEntity.getPosition(0);

				if (objectMouseOver != null)
					d1 = objectMouseOver.hitVec.distanceTo(vec3);

				Vec3 vec31 = fromEntity.getLook(0);
				Vec3 vec32 = vec3.addVector(vec31.xCoord * (double)distance, vec31.yCoord * (double)distance, vec31.zCoord * (double)distance);
				float f1 = 1.0F;
				List<Entity> list = WorldUtils.getEntitiesWithinAABBExcludingEntity(fromEntity.worldObj, fromEntity, fromEntity.boundingBox.addCoord(vec31.xCoord * (double)distance, vec31.yCoord * (double)distance, vec31.zCoord * (double)distance).expand(f1, f1, f1));
				double d2 = d1;

				for (Entity entity : list)
				{
					if (entity.canBeCollidedWith())
					{
						float f2 = entity.getCollisionBorderSize();
						AxisAlignedBB axisalignedbb = entity.boundingBox.expand(f2, f2, f2);
						MovingObjectPosition movingobjectposition = axisalignedbb.calculateIntercept(vec3, vec32);

						if (axisalignedbb.isVecInside(vec3))
						{
							if (0.0D < d2 || d2 == 0.0D)
								if (!Arrays.asList(exclude).contains(entity))
								{
									pointedEntity = entity;
									d2 = 0.0D;
								}
						}
						else if (movingobjectposition != null)
						{
							double d3 = vec3.distanceTo(movingobjectposition.hitVec);

							if (d3 < d2 || d2 == 0.0D)
								if (!Arrays.asList(exclude).contains(entity))
								{
									pointedEntity = entity;
									d2 = d3;
								}
						}
					}
				}
				return pointedEntity;
			}
		return null;
	}

	public static RaytraceHit rayTrace(Vec3 fromDir, double distance, Entity fromEntity, Entity[] exclude, boolean includeBlocks)
	{
		if (fromEntity == null || fromEntity.worldObj == null)
			return null;

		Vec3 startPos = Vec3.createVectorHelper(fromEntity.posX, fromEntity.posY, fromEntity.posZ).addVector(0, fromEntity.getEyeHeight(), 0);
		return rayTraceFromPosition(startPos, fromDir, distance, fromEntity, exclude, includeBlocks);
	}

	private static RaytraceHit rayTraceFromPosition(Vec3 startPos, Vec3 fromDir, double distance, Entity fromEntity, Entity[] exclude, boolean includeBlocks)
	{
		Entity pointedEntity = null;
		RaytraceHitBlock rhb = null;
		Vec3 endPos = startPos.addVector(fromDir.xCoord * distance, fromDir.yCoord * distance, fromDir.zCoord * distance);
		List<Entity> list = WorldUtils.getEntitiesWithinAABBExcludingEntity(fromEntity.worldObj, fromEntity, fromEntity.boundingBox.addCoord(fromDir.xCoord * distance, fromDir.yCoord * distance, fromDir.zCoord * distance).expand(1, 1, 1));

		if (includeBlocks)
		{
			Vec3 newEnd = Vec3.createVectorHelper(startPos.xCoord, startPos.yCoord, startPos.zCoord);
			MovingObjectPosition mop = fromEntity.worldObj.rayTraceBlocks(newEnd, endPos);
			if (mop != null && mop.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)
			{
				rhb = new RaytraceHitBlock(mop.hitVec, mop.blockX, mop.blockY, mop.blockZ, mop.sideHit);
				distance = mop.hitVec.distanceTo(startPos);
				endPos = newEnd;
			}
		}

		for (Entity e : list)
		{

			if (e.canBeCollidedWith())
			{
				float f2 = e.getCollisionBorderSize();
				AxisAlignedBB axisalignedbb = e.boundingBox.expand(f2, f2, f2);
				MovingObjectPosition movingobjectposition = axisalignedbb.calculateIntercept(startPos, endPos);

				if (axisalignedbb.isVecInside(startPos) && (0.0D < distance || distance == 0.0D) && !Arrays.asList(exclude).contains(e))
				{
					pointedEntity = e;
					distance = 0.0D;
				}
				else if (movingobjectposition != null)
				{
					double d3 = startPos.distanceTo(movingobjectposition.hitVec);

					if ((d3 < distance || distance == 0.0D) && !Arrays.asList(exclude).contains(e))
					{
						pointedEntity = e;
						distance = d3;
					}
				}
			}
		}

		if (pointedEntity != null)
			return new RaytraceHitEntity(pointedEntity);

		return rhb;
	}

	public static RaytraceHit rayTrace(Entity from, double distance)
	{
		return rayTrace(from.getLookVec(), distance, from, new Entity[0], false);
	}

	/**
	 * Registers an Entity with FML
	 *
	 * @param entityClass The class to register
	 * @param entityName  The name of the entity
	 */
	public static void registerEntity(Class<? extends Entity> entityClass, String entityName)
	{
		while (EntityList.getClassFromID(mobId) != null)
			mobId += 1;
		EntityRegistry.registerModEntity(entityClass, entityName, mobId, StarWarsMod.instance, 80, 1, true);
		IDtoClassMapping.put(mobId, entityClass);
		Lumberjack.debug("Registered entity \"" + entityName + "\" as ID " + mobId);
	}

	/**
	 * Registers an Entity with FML, and creates a genComposite egg
	 *
	 * @param mobClass The class to register
	 * @param mobName  The name of the entity
	 * @param bgColor  The background color of the egg
	 * @param fgColor  The foreground color of the egg
	 */
	public static void registerWithSpawnEgg(Class<? extends Entity> mobClass, String mobName, int bgColor, int fgColor)
	{
		while (EntityList.getClassFromID(mobId) != null)
			mobId += 1;
		EntityRegistry.registerModEntity(mobClass, mobName, mobId, StarWarsMod.instance, 80, 1, true);
		IDtoClassMapping.put(mobId, mobClass);
		entityEggs.put(mobId, new EntityList.EntityEggInfo(mobId, bgColor, fgColor));
		Lumberjack.debug("Registered entity (and egg) \"" + mobName + "\" as ID " + mobId);
	}
}