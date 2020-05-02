package com.parzivail.pswm.network;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.force.Force;
import com.parzivail.pswm.force.ForcePower;
import com.parzivail.pswm.force.ForceUser;
import com.parzivail.pswm.force.exceptions.NotAForceUserException;
import com.parzivail.pswm.force.powers_old.PowerBase;
import com.parzivail.pswm.force.powers_old.PowerDefend;
import com.parzivail.pswm.force.powers_old.PowerDeflect;
import com.parzivail.pswm.utils.StatTrack;
import com.parzivail.util.common.Lumberjack;
import com.parzivail.util.network.OptionalField;
import com.parzivail.util.network.PMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

import java.lang.invoke.MethodHandle;

public class MessageActivateForcePower extends PMessage<MessageActivateForcePower>
{
	public EntityPlayer player;
	public String power;
	@OptionalField
	public Entity target;

	public MessageActivateForcePower(EntityPlayer player, String power, Entity target)
	{

		this.player = player;
		this.power = power;
		this.target = target;
	}

	@SuppressWarnings("unused") // used by FML
	public MessageActivateForcePower()
	{
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		final ForceUser forceUser;
		try
		{
			forceUser = new ForceUser(player);
		}
		catch (NotAForceUserException e)
		{
			Lumberjack.warn(e.getMessage());
			return null;
		}
		if (forceUser.getActivePower() != null) {
			return null; // a power is already active
		}

		ForcePower forcePower = Force.getPower(power);
		if (forcePower == null) {
			return null;
		}
		final ForcePower.PowerData power = forcePower.new PowerData(forceUser.getPowersNBT().getCompoundTag(forcePower.name));
		final PowerBase powerBase = null;
		if (forceUser.canUse(power)) //(forcePower != null && Force.getXP(cron) - power.getCost() >= 0 && !Cron.isCooling(forcePower.name))
		{
			if (target == null || !player.canEntityBeSeen(target))
				target = null;
			boolean coolFlag = true;
			StatTrack.addStat("useForcePower-" + forcePower.name);
			if (forcePower.activate(player, power.getData(), target))
			{
				if (forcePower.isSingleAction) {
					power.setRemainingRecharge(forcePower.rechargeTime);
				} else {
					// set active power here, or let activate do that
				}
			}
			if (false)
			switch (forcePower.name)
			{
				case "defend":
					PowerDefend powerDefend = (PowerDefend)(Object)forcePower;
					if (powerDefend.isRunning)
					{
						powerDefend.isRunning = false;
						powerDefend.health = 0;
						powerDefend.recharge = powerDefend.rechargeTime;
					}
					else
					{
						powerDefend.run(player, null);
						coolFlag = false;
					}
					break;
				case "deflect":
					PowerDeflect powerDeflect = (PowerDeflect)(Object)forcePower;
					if (!powerDeflect.isRunning)
					{
						powerDeflect.isRunning = true;
						powerDeflect.recharge = 0;
						coolFlag = false;
					}
					break;
				case "lightning":
					//if (!powerBase.isRunning)
					//{
					//	powerBase.isRunning = true;
					//	powerBase.recharge = 0;
					//	coolFlag = false;
					//}
					break;
				case "grab":
					if (powerBase.isRunning)
					{
						powerBase.isRunning = false;
						powerBase.recharge = powerBase.rechargeTime;
					}
					else
					{
						powerBase.run(player, null);
						coolFlag = false;
					}
					break;
				default:
					powerBase.run(player, target);
					powerBase.recharge = powerBase.rechargeTime;
					break;
			}

			StarWarsMod.network.sendToAll(new MessageHolocronSetClientActive(player, forcePower.name));
			forceUser.setXp(forceUser.getXp() - power.getCost()); // TODO: sync to client
			StarWarsMod.network.sendToAll(new MessageHolocronRefreshClientPowers(forceUser));
		}

		return null;
	}

	private static final MethodHandle toBytes = PMessage.builtToBytes.computeIfAbsent(MessageActivateForcePower.class, PMessage::createToBytes);
	private static final MethodHandle fromBytes = PMessage.builtFromBytes.computeIfAbsent(MessageActivateForcePower.class, PMessage::createFromBytes);

	@Override
	public void fromBytes(ByteBuf buf)
	{
		try
		{
			try
			{
				fromBytes.invokeExact(this, buf);
			}
			catch (Throwable t)
			{
				hideException(t);
			}
		}
		catch (Exception e)
		{
			throw new RuntimeException("Error at reading packet " + this, e);
		}
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		try
		{
			try
			{
				toBytes.invokeExact(this, buf);
			}
			catch (Throwable t)
			{
				hideException(t);
			}
		}
		catch (Exception e)
		{
			throw new RuntimeException("Error at writing packet " + this, e);
		}
	}
}
