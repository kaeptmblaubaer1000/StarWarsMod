package com.parzivail.pswm.force;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.force.powers.PowerNaturalAwareness;
import com.parzivail.util.ui.LangUtils;
import com.parzivail.util.world.ItemUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StringUtils;
import net.minecraft.world.World;

import java.util.List;

public class ItemHolocron extends Item
{
	public String name = "holocron";

	public ItemHolocron()
	{
		this.setUnlocalizedName(Resources.MODID + "." + this.name);
		this.setTextureName(Resources.MODID + ":" + this.name);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
	}

	public String getItemStackDisplayName(ItemStack stack)
	{
		if (stack.hasTagCompound())
		{
			String s = stack.stackTagCompound.getString(Resources.nbtMaster);

			if (!StringUtils.isNullOrEmpty(s))
				return LangUtils.translate("0.s.holocron", s);
		}

		return super.getItemStackDisplayName(stack);
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool)
	{
		list.add(LangUtils.translate("level.0", String.valueOf((int)Math.floor(Cron.getLevel(stack) / 10f))));
	}

	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int a, boolean b)
	{
		if ((ItemUtils.initNBT(stack) || !stack.stackTagCompound.hasKey(Resources.nbtPowers)) && entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)entity;

			stack.stackTagCompound.setString(Resources.nbtMaster, player.getCommandSenderName());
			stack.stackTagCompound.setString(Resources.nbtSide, Cron.SIDE_JEDI);

			stack.stackTagCompound.setInteger(Resources.nbtXp, 1);
			stack.stackTagCompound.setInteger(Resources.nbtMaxXp, 100);
			stack.stackTagCompound.setInteger(Resources.nbtRemainingPts, 0);

			stack.stackTagCompound.setTag(Resources.nbtWield, new NBTTagCompound());
			stack.stackTagCompound.setTag(Resources.nbtPowers, Cron.makeNewPowersNBT());
		}
		if (!stack.stackTagCompound.hasKey("askedJediSith")) {
			if (stack.stackTagCompound.getString(Resources.nbtSide).equals(Cron.SIDE_SITH)) {
				stack.stackTagCompound.setBoolean("askedJediSith", true);
			} else if (stack.stackTagCompound.getInteger(Resources.nbtLevel) > 34 && stack.stackTagCompound.getCompoundTag(Resources.nbtPowers).getCompoundTag("naturalAwareness").getInteger("currentLevel") > 0) {
				stack.stackTagCompound.setBoolean("askedJediSith", true);
			} else {
				stack.stackTagCompound.setBoolean("askedJediSith", false);
			}
		}
	}
}