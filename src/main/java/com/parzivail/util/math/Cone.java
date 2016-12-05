package com.parzivail.util.math;

import com.parzivail.util.lwjgl.Vector3f;
import net.minecraft.entity.Entity;

import java.util.ArrayList;
import java.util.List;

public class Cone
{
	/**
	 * @param entities  List of nearby entities
	 * @param startPos  starting position
	 * @param radius    distance cone travels
	 * @param degrees   angle of cone
	 * @param direction direction of the cone
	 * @return All entities inside the cone
	 */
	public static List<Entity> getEntitiesInCone(List<Entity> entities, Vector3f startPos, float radius, float degrees, Vector3f direction)
	{

		List<Entity> newEntities = new ArrayList<>();
		float squaredRadius = radius * radius;

		for (Entity e : entities)
		{
			Vector3f relativePosition = new Vector3f(e.posX, e.posY, e.posZ);
			relativePosition = Vector3f.sub(relativePosition, startPos, null);
			if (relativePosition.lengthSquared() > squaredRadius)
				continue;
			if (MathUtils.getAngleBetweenVectors(direction, relativePosition) > degrees)
				continue;
			newEntities.add(e);
		}
		return newEntities;
	}

	public static float getAngleBetween(Entity view, Entity entity)
	{
		Vector3f relativePosition = new Vector3f(entity.posX, entity.posY, entity.posZ);
		relativePosition = Vector3f.sub(relativePosition, new Vector3f(view.posX, view.posY, view.posZ), null);
		return MathUtils.getAngleBetweenVectors(Vector3f.fromVec3(view.getLookVec()), relativePosition);
	}
}