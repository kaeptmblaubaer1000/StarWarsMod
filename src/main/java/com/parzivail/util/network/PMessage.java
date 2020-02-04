package com.parzivail.util.network;

import com.parzivail.pswm.utils.EntityCooldownEntry;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import org.apache.commons.lang3.tuple.Pair;

import java.awt.*;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class PMessage<REQ extends PMessage> implements Serializable, IMessage, IMessageHandler<REQ, IMessage>
{
	private static final HashMap<Class, Pair<Reader, Writer>> handlers = new HashMap<>();
	private static final HashMap<Class, Field[]> fieldCache = new HashMap<>(); // TODO: MethodHandles

	static
	{
		map(byte.class, PMessage::readByte, PMessage::writeByte);
		map(short.class, PMessage::readShort, PMessage::writeShort);
		map(int.class, PMessage::readInt, PMessage::writeInt);
		map(long.class, PMessage::readLong, PMessage::writeLong);
		map(float.class, PMessage::readFloat, PMessage::writeFloat);
		map(double.class, PMessage::readDouble, PMessage::writeDouble);
		map(boolean.class, PMessage::readBoolean, PMessage::writeBoolean);
		map(char.class, PMessage::readChar, PMessage::writeChar);
		map(String.class, PMessage::readString, PMessage::writeString);
		map(NBTTagCompound.class, PMessage::readNBT, PMessage::writeNBT);
		map(ItemStack.class, PMessage::readItemStack, PMessage::writeItemStack);

		map(EntityPlayer.class, PMessage::readPlayer, PMessage::writePlayer);
		map(Entity.class, PMessage::readEntity, PMessage::writeEntity);
		map(Vec3.class, PMessage::readVec3, PMessage::writeVec3);
		map(EntityCooldownEntry.class, PMessage::readEntityCooldownEntry, PMessage::writeEntityCooldownEntry);
		map(Color.class, PMessage::readColor, PMessage::writeColor);
		map(World.class, PMessage::readWorld, PMessage::writeWorld);
		map(ItemStack[].class, PMessage::readItemStacks, PMessage::writeItemStacks);
	}

	private static boolean acceptField(Field f, Class<?> type)
	{
		int mods = f.getModifiers();
		return !(Modifier.isFinal(mods) || Modifier.isStatic(mods) || Modifier.isTransient(mods)) && handlers.containsKey(type);
	}

	private static Field[] getClassFields(Class<?> clazz)
	{
		if (fieldCache.containsKey(clazz))
			return fieldCache.get(clazz);
		else
		{
			Field[] fields = clazz.getFields();
			Arrays.sort(fields, Comparator.comparing(Field::getName));
			fieldCache.put(clazz, fields);
			return fields;
		}
	}

	private static Pair<Reader, Writer> getHandler(Class<?> clazz)
	{
		Pair<Reader, Writer> pair = handlers.get(clazz);
		if (pair == null)
			throw new RuntimeException("No R/W handler for  " + clazz);
		return pair;
	}

	private static <T> void map(Class<T> type, Reader<T> reader, Writer<T> writer)
	{
		handlers.put(type, Pair.of(reader, writer));
	}

	private static boolean readBoolean(ByteBuf buf)
	{
		return buf.readBoolean();
	}

	private static byte readByte(ByteBuf buf)
	{
		return buf.readByte();
	}

	private static char readChar(ByteBuf buf)
	{
		return buf.readChar();
	}

	private static Color readColor(ByteBuf buf)
	{
		return new Color(buf.readInt());
	}

	private static double readDouble(ByteBuf buf)
	{
		return buf.readDouble();
	}

	private static Entity readEntity(ByteBuf buf)
	{
		int dim = buf.readInt();
		int id = buf.readInt();
		if (MinecraftServer.getServer() == null)
			return Minecraft.getMinecraft().theWorld.getEntityByID(id);
		return MinecraftServer.getServer().worldServerForDimension(dim).getEntityByID(id);
	}

	private static EntityCooldownEntry readEntityCooldownEntry(ByteBuf buf)
	{
		Entity e = readEntity(buf);
		String name = ByteBufUtils.readUTF8String(buf);
		int cooldownLeft = buf.readInt();
		return new EntityCooldownEntry(e, name, cooldownLeft);
	}

	private static float readFloat(ByteBuf buf)
	{
		return buf.readFloat();
	}

	private static int readInt(ByteBuf buf)
	{
		return buf.readInt();
	}

	private static ItemStack readItemStack(ByteBuf buf)
	{
		return ByteBufUtils.readItemStack(buf);
	}

	private static ItemStack[] readItemStacks(ByteBuf buf)
	{
		ArrayList<ItemStack> stacks = new ArrayList<>();
		int count = readInt(buf);
		for (int i = 0; i < count; i++)
			stacks.add(readItemStack(buf));
		return stacks.toArray(new ItemStack[count]);
	}

	private static long readLong(ByteBuf buf)
	{
		return buf.readLong();
	}

	private static NBTTagCompound readNBT(ByteBuf buf)
	{
		return ByteBufUtils.readTag(buf);
	}

	private static EntityPlayer readPlayer(ByteBuf buf)
	{
		// int dim = buf.readInt();
		// String uname = ByteBufUtils.readUTF8String(buf);
		// return
		// MinecraftServer.getServer().worldServerForDimension(dim).getPlayerEntityByName(uname);
		return (EntityPlayer)readEntity(buf);
	}

	private static short readShort(ByteBuf buf)
	{
		return buf.readShort();
	}

	private static String readString(ByteBuf buf)
	{
		return ByteBufUtils.readUTF8String(buf);
	}

	private static Vec3 readVec3(ByteBuf buf)
	{
		double x = buf.readDouble();
		double y = buf.readDouble();
		double z = buf.readDouble();
		return Vec3.createVectorHelper(x, y, z);
	}

	private static World readWorld(ByteBuf buf)
	{
		int dim = buf.readInt();
		return MinecraftServer.getServer().worldServerForDimension(dim);
	}

	private static void writeWorld(World w, ByteBuf buf)
	{
		buf.writeInt(w.provider.dimensionId);
	}

	private static void writeBoolean(boolean b, ByteBuf buf)
	{
		buf.writeBoolean(b);
	}

	private static void writeByte(byte b, ByteBuf buf)
	{
		buf.writeByte(b);
	}

	private static void writeChar(char c, ByteBuf buf)
	{
		buf.writeChar(c);
	}

	private static void writeColor(Color c, ByteBuf buf)
	{
		buf.writeInt(c.getRGB());
	}

	private static void writeDouble(double d, ByteBuf buf)
	{
		buf.writeDouble(d);
	}

	private static void writeEntity(Entity entity, ByteBuf buf)
	{
		buf.writeInt(entity.dimension);
		buf.writeInt(entity.getEntityId());
	}

	private static void writeEntityCooldownEntry(EntityCooldownEntry entry, ByteBuf buf)
	{
		writeEntity(entry.entity, buf);
		ByteBufUtils.writeUTF8String(buf, entry.effect);
		buf.writeInt(entry.cooldownLeft);
	}

	private static void writeFloat(float f, ByteBuf buf)
	{
		buf.writeFloat(f);
	}

	private static void writeInt(int i, ByteBuf buf)
	{
		buf.writeInt(i);
	}

	private static void writeItemStack(ItemStack stack, ByteBuf buf)
	{
		ByteBufUtils.writeItemStack(buf, stack);
	}

	private static void writeItemStacks(ItemStack[] stack, ByteBuf buf)
	{
		writeInt(stack.length, buf);
		for (ItemStack stack1 : stack)
			ByteBufUtils.writeItemStack(buf, stack1);
	}

	private static void writeLong(long l, ByteBuf buf)
	{
		buf.writeLong(l);
	}

	private static void writeNBT(NBTTagCompound cmp, ByteBuf buf)
	{
		ByteBufUtils.writeTag(buf, cmp);
	}

	private static void writePlayer(EntityPlayer player, ByteBuf buf)
	{
		// buf.writeInt(ship.dimension);
		// ByteBufUtils.writeUTF8String(buf, ship.getCommandSenderName());
		writeEntity(player, buf);
	}

	private static void writeShort(short s, ByteBuf buf)
	{
		buf.writeShort(s);
	}

	private static void writeString(String s, ByteBuf buf)
	{
		ByteBufUtils.writeUTF8String(buf, s);
	}

	private static void writeVec3(Vec3 vec, ByteBuf buf)
	{
		buf.writeDouble(vec.xCoord);
		buf.writeDouble(vec.yCoord);
		buf.writeDouble(vec.zCoord);
	}

	@Override
	public final void fromBytes(ByteBuf buf)
	{
		try
		{
			Class<?> clazz = this.getClass();
			Field[] clFields = getClassFields(clazz);
			for (Field f : clFields)
			{
				Class<?> type = f.getType();
				if (acceptField(f, type))
					this.readField(f, type, buf);
			}
		}
		catch (Exception e)
		{
			throw new RuntimeException("Error at reading packet " + this, e);
		}
	}

	// The thing you override!
	public IMessage handleMessage(MessageContext context)
	{
		return null;
	}

	@Override
	public final IMessage onMessage(REQ message, MessageContext context)
	{
		return message.handleMessage(context);
	}

	private void readField(Field f, Class clazz, ByteBuf buf) throws IllegalArgumentException, IllegalAccessException
	{
		Pair<Reader, Writer> handler = getHandler(clazz);
		f.set(this, handler.getLeft().read(buf));
	}

	@Override
	public final void toBytes(ByteBuf buf)
	{
		try
		{
			Class<?> clazz = this.getClass();
			Field[] clFields = getClassFields(clazz);
			for (Field f : clFields)
			{
				Class<?> type = f.getType();
				if (acceptField(f, type))
					this.writeField(f, type, buf);
			}
		}
		catch (Exception e)
		{
			throw new RuntimeException("Error at writing packet " + this, e);
		}
	}

	@SuppressWarnings("unchecked")
	private void writeField(Field f, Class clazz, ByteBuf buf) throws IllegalArgumentException, IllegalAccessException
	{
		Pair<Reader, Writer> handler = getHandler(clazz);
		handler.getRight().write(f.get(this), buf);
	}

	public interface Reader<T>
	{
		T read(ByteBuf buf);
	}

	public interface Writer<T>
	{
		void write(T t, ByteBuf buf);
	}

}