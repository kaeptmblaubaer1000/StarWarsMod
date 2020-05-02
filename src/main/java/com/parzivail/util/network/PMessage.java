package com.parzivail.util.network;

import com.parzivail.pswm.utils.EntityCooldownEntry;
import com.parzivail.util.common.Pair;
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

import java.awt.*;
import java.io.Serializable;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

public class PMessage<REQ extends PMessage<REQ>> implements Serializable, IMessage, IMessageHandler<REQ, IMessage>
{
	@Deprecated // TODO: delete
	private static final HashMap<Class, Pair<Reader, Writer>> handlers = new HashMap<>();
	private static final HashMap<Class, Field[]> fieldCache = new HashMap<>(); // TODO: MethodHandles
	private static final HashMap<Class, Pair<MethodHandle, MethodHandle>> methodHandleHandlers = new HashMap<>();
	protected static final HashMap<Class<? extends PMessage<?>>, MethodHandle> builtToBytes = new HashMap<>();
	protected static final HashMap<Class<? extends PMessage<?>>, MethodHandle> builtFromBytes = new HashMap<>();

	static
	{
		try
		{
			final MethodHandles.Lookup lookup = MethodHandles.lookup();
			map(byte.class, PMessage::readByte, PMessage::writeByte);
			map(byte.class, lookup.findStatic(PMessage.class, "readByte", MethodType.methodType(byte.class, ByteBuf.class)), lookup.findStatic(PMessage.class, "writeByte", MethodType.methodType(void.class, byte.class, ByteBuf.class)));
			map(short.class, PMessage::readShort, PMessage::writeShort);
			map(short.class, lookup.findStatic(PMessage.class, "readShort", MethodType.methodType(short.class, ByteBuf.class)), lookup.findStatic(PMessage.class, "writeShort", MethodType.methodType(void.class, short.class, ByteBuf.class)));
			map(int.class, PMessage::readInt, PMessage::writeInt);
			map(int.class, lookup.findStatic(PMessage.class, "readInt", MethodType.methodType(int.class, ByteBuf.class)), lookup.findStatic(PMessage.class, "writeInt", MethodType.methodType(void.class, int.class, ByteBuf.class)));
			map(long.class, PMessage::readLong, PMessage::writeLong);
			map(long.class, lookup.findStatic(PMessage.class, "readLong", MethodType.methodType(long.class, ByteBuf.class)), lookup.findStatic(PMessage.class, "writeLong", MethodType.methodType(void.class, long.class, ByteBuf.class)));
			map(float.class, PMessage::readFloat, PMessage::writeFloat);
			map(float.class, lookup.findStatic(PMessage.class, "readFloat", MethodType.methodType(float.class, ByteBuf.class)), lookup.findStatic(PMessage.class, "writeFloat", MethodType.methodType(void.class, float.class, ByteBuf.class)));
			map(double.class, PMessage::readDouble, PMessage::writeDouble);
			map(double.class, lookup.findStatic(PMessage.class, "readDouble", MethodType.methodType(double.class, ByteBuf.class)), lookup.findStatic(PMessage.class, "writeDouble", MethodType.methodType(void.class, double.class, ByteBuf.class)));
			map(boolean.class, PMessage::readBoolean, PMessage::writeBoolean);
			map(boolean.class, lookup.findStatic(PMessage.class, "readBoolean", MethodType.methodType(boolean.class, ByteBuf.class)), lookup.findStatic(PMessage.class, "writeBoolean", MethodType.methodType(void.class, boolean.class, ByteBuf.class)));
			map(char.class, PMessage::readChar, PMessage::writeChar);
			map(char.class, lookup.findStatic(PMessage.class, "readChar", MethodType.methodType(char.class, ByteBuf.class)), lookup.findStatic(PMessage.class, "writeChar", MethodType.methodType(void.class, char.class, ByteBuf.class)));
			map(String.class, PMessage::readString, PMessage::writeString);
			map(String.class, lookup.findStatic(PMessage.class, "readString", MethodType.methodType(String.class, ByteBuf.class)), lookup.findStatic(PMessage.class, "writeString", MethodType.methodType(void.class, String.class, ByteBuf.class)));
			map(NBTTagCompound.class, PMessage::readNBT, PMessage::writeNBT);
			map(NBTTagCompound.class, lookup.findStatic(PMessage.class, "readNBT", MethodType.methodType(NBTTagCompound.class, ByteBuf.class)), lookup.findStatic(PMessage.class, "writeNBT", MethodType.methodType(void.class, NBTTagCompound.class, ByteBuf.class)));
			map(ItemStack.class, PMessage::readItemStack, PMessage::writeItemStack);
			map(ItemStack.class, lookup.findStatic(PMessage.class, "readItemStack", MethodType.methodType(ItemStack.class, ByteBuf.class)), lookup.findStatic(PMessage.class, "writeItemStack", MethodType.methodType(void.class, ItemStack.class, ByteBuf.class)));

			map(EntityPlayer.class, PMessage::readPlayer, PMessage::writePlayer);
			map(EntityPlayer.class, lookup.findStatic(PMessage.class, "readPlayer", MethodType.methodType(EntityPlayer.class, ByteBuf.class)), lookup.findStatic(PMessage.class, "writePlayer", MethodType.methodType(void.class, EntityPlayer.class, ByteBuf.class)));
			map(Entity.class, PMessage::readEntity, PMessage::writeEntity);
			map(Entity.class, lookup.findStatic(PMessage.class, "readEntity", MethodType.methodType(Entity.class, ByteBuf.class)), lookup.findStatic(PMessage.class, "writeEntity", MethodType.methodType(void.class, Entity.class, ByteBuf.class)));
			map(Vec3.class, PMessage::readVec3, PMessage::writeVec3);
			map(Vec3.class, lookup.findStatic(PMessage.class, "readVec3", MethodType.methodType(Vec3.class, ByteBuf.class)), lookup.findStatic(PMessage.class, "writeVec3", MethodType.methodType(void.class, Vec3.class, ByteBuf.class)));
			map(EntityCooldownEntry.class, PMessage::readEntityCooldownEntry, PMessage::writeEntityCooldownEntry);
			map(EntityCooldownEntry.class, lookup.findStatic(PMessage.class, "readEntityCooldownEntry", MethodType.methodType(EntityCooldownEntry.class, ByteBuf.class)), lookup.findStatic(PMessage.class, "writeEntityCooldownEntry", MethodType.methodType(void.class, EntityCooldownEntry.class, ByteBuf.class)));
			map(Color.class, PMessage::readColor, PMessage::writeColor);
			map(Color.class, lookup.findStatic(PMessage.class, "readColor", MethodType.methodType(Color.class, ByteBuf.class)), lookup.findStatic(PMessage.class, "writeColor", MethodType.methodType(void.class, Color.class, ByteBuf.class)));
			map(World.class, PMessage::readWorld, PMessage::writeWorld);
			map(World.class, lookup.findStatic(PMessage.class, "readWorld", MethodType.methodType(World.class, ByteBuf.class)), lookup.findStatic(PMessage.class, "writeWorld", MethodType.methodType(void.class, World.class, ByteBuf.class)));
			map(ItemStack[].class, PMessage::readItemStacks, PMessage::writeItemStacks);
			map(ItemStack[].class, lookup.findStatic(PMessage.class, "readItemStacks", MethodType.methodType(ItemStack[].class, ByteBuf.class)), lookup.findStatic(PMessage.class, "writeItemStacks", MethodType.methodType(void.class, ItemStack[].class, ByteBuf.class)));
		}
		catch (NoSuchMethodException | IllegalAccessException e)
		{
			e.printStackTrace();
		}
	}

	private static boolean ignoreField(Field field)
	{
		int modifiers = field.getModifiers();
		return Modifier.isFinal(modifiers) || Modifier.isStatic(modifiers) || Modifier.isTransient(modifiers);
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
		handlers.put(type, new Pair<>(reader, writer));
	}

	private static void map(Class<?> type, MethodHandle reader, MethodHandle writer)
	{
		methodHandleHandlers.put(type, new Pair<>(reader, writer));
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
		{
			return Minecraft.getMinecraft().theWorld.getEntityByID(id);
		}
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

	public static MethodHandle createFromBytes(Class<? extends PMessage<?>> clazz)
	{
		try
		{
			final MethodHandles.Lookup lookup = MethodHandles.lookup();
			final Field[] fields = clazz.getFields();
			Arrays.sort(fields, Comparator.comparing(Field::getName).reversed());
			MethodHandle prev = null;
			for (final Field field : fields)
			{
				if (ignoreField(field))
				{
					continue;
				}
				final MethodHandle setter = lookup.unreflectSetter(field);
				// The asType should be a no-op, but do it anyways to be safe
				MethodHandle read = methodHandleHandlers.get(field.getType()).left.asType(MethodType.methodType(field.getType(), ByteBuf.class));
				if (field.isAnnotationPresent(OptionalField.class))
				{
					read = MethodHandles.guardWithTest(lookup.findStatic(PMessage.class, "readBoolean", MethodType.methodType(boolean.class, ByteBuf.class)), read, MethodHandles.dropArguments(MethodHandles.constant(field.getType(), null), 0, ByteBuf.class));
				}
				if (prev == null)
				{
					prev = MethodHandles.filterArguments(setter, 1, read);
				}
				else
				{
					prev = MethodHandles.permuteArguments(MethodHandles.filterArguments(MethodHandles.foldArguments(MethodHandles.permuteArguments(prev, MethodType.methodType(void.class, clazz, field.getType(), ByteBuf.class), 0, 2), setter), 1, read), MethodType.methodType(void.class, clazz, ByteBuf.class), 0, 1, 1);
				}
			}
			if (prev == null)
			{
				prev = MethodHandles.dropArguments(lookup.findStatic(PMessage.class, "noValue", MethodType.methodType(void.class)), 0, clazz, ByteBuf.class);
			}
			return prev;
		}
		catch (ReflectiveOperationException e)
		{
			throw new RuntimeException(e);
		}
	}

	private static MethodHandle composeFromBytesMethods(ArrayList<Class<? extends PMessage<?>>> classes) throws NoSuchMethodException, IllegalAccessException
	{
		final MethodHandles.Lookup lookup = MethodHandles.lookup();
		MethodHandle prev = MethodHandles.dropArguments(lookup.findStatic(PMessage.class, "throwNotRegistered", MethodType.methodType(void.class, PMessage.class)), 1, ByteBuf.class);
		for (Class<? extends PMessage<?>> clazz : classes)
		{
			final MethodHandle instanceCheck = lookup.bind(clazz, "isInstance", MethodType.methodType(boolean.class, Object.class)).asType(MethodType.methodType(boolean.class, PMessage.class));
			final MethodHandle fromBytes = builtFromBytes.computeIfAbsent(clazz, PMessage::createFromBytes).asType(MethodType.methodType(void.class, PMessage.class, ByteBuf.class));
			prev = MethodHandles.guardWithTest(instanceCheck, fromBytes, prev);
		}
		return prev;
	}

	private static <T extends PMessage<T>> void throwNotRegistered(PMessage<T> message)
	{
		throw new RuntimeException(message.getClass().getName() + " is not a registered PMessage");
	}

	@SuppressWarnings("unchecked")
	protected static <T extends Throwable> void hideException(Throwable t) throws T
	{
		throw (T)t;
	}

	@Override
	public void fromBytes(ByteBuf buf)
	{
		try
		{
			try
			{
				composedFromBytes.invokeExact(this, buf);
			}
			catch (Throwable t)
			{
				hideException(t);
			}
			/*Class<?> clazz = this.getClass();
			Field[] clFields = getClassFields(clazz);
			for (Field f : clFields)
			{
				Class<?> type = f.getType();
				if (acceptField(f, type))
					this.readField(f, type, buf);
			}*/
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
		f.set(this, handler.left.read(buf));
	}

	/**
	 * @return {@link MethodHandle} with {@code void (T, io.netty.buffer.ByteBuf)} signature that writes the message to the {@link ByteBuf}
	 */
	public static MethodHandle createToBytes(Class<? extends PMessage<?>> clazz)
	{
		try
		{
			final MethodHandles.Lookup lookup = MethodHandles.lookup();
			Field[] fields = clazz.getFields();
			Arrays.sort(fields, Comparator.comparing(Field::getName).reversed());
			MethodHandle prev = null;
			for (final Field field : fields)
			{
				if (ignoreField(field))
				{
					continue;
				}
				final MethodHandle getter = lookup.unreflectGetter(field);
				// The asType should be a no-op, but do it anyways to be safe
				MethodHandle write = methodHandleHandlers.get(field.getType()).right.asType(MethodType.methodType(void.class, field.getType(), ByteBuf.class));
				if (field.isAnnotationPresent(OptionalField.class))
				{
					write = MethodHandles.guardWithTest(MethodHandles.dropArguments(lookup.findStatic(Objects.class, "nonNull", MethodType.methodType(boolean.class, Object.class)), 1, ByteBuf.class).asType(MethodType.methodType(boolean.class, field.getType(), ByteBuf.class)), MethodHandles.foldArguments(write, MethodHandles.dropArguments(MethodHandles.insertArguments(lookup.findStatic(PMessage.class, "writeBoolean", MethodType.methodType(void.class, boolean.class, ByteBuf.class)), 0, true), 0, field.getType())), MethodHandles.dropArguments(MethodHandles.insertArguments(lookup.findStatic(PMessage.class, "writeBoolean", MethodType.methodType(void.class, boolean.class, ByteBuf.class)), 0, false), 0, field.getType()));
				}
				if (prev == null)
				{
					prev = MethodHandles.filterArguments(write, 0, getter);
				}
				else
				{
					prev = MethodHandles.permuteArguments(MethodHandles.filterArguments(MethodHandles.foldArguments(MethodHandles.permuteArguments(prev, MethodType.methodType(void.class, field.getType(), ByteBuf.class, clazz, ByteBuf.class), 2, 3), write), 0, getter), MethodType.methodType(void.class, clazz, ByteBuf.class), 0, 1, 0, 1);
				}
			}
			if (prev == null)
			{
				prev = MethodHandles.dropArguments(lookup.findStatic(PMessage.class, "noValue", MethodType.methodType(void.class)), 0, clazz, ByteBuf.class);
			}
			return prev;
		}
		catch (ReflectiveOperationException e)
		{
			throw new RuntimeException(e);
		}
	}

	private static MethodHandle composeToBytesMethods(ArrayList<Class<? extends PMessage<?>>> classes) throws NoSuchMethodException, IllegalAccessException
	{
		final MethodHandles.Lookup lookup = MethodHandles.lookup();
		MethodHandle prev = MethodHandles.dropArguments(lookup.findStatic(PMessage.class, "throwNotRegistered", MethodType.methodType(void.class, PMessage.class)), 1, ByteBuf.class);
		for (Class<? extends PMessage<?>> clazz : classes)
		{
			final MethodHandle instanceCheck = lookup.bind(clazz, "isInstance", MethodType.methodType(boolean.class, Object.class)).asType(MethodType.methodType(boolean.class, PMessage.class));
			final MethodHandle toBytes = builtToBytes.computeIfAbsent(clazz, PMessage::createToBytes).asType(MethodType.methodType(void.class, PMessage.class, ByteBuf.class));
			prev = MethodHandles.guardWithTest(instanceCheck, toBytes, prev);
		}
		return prev;
	}

	public static void noValue()
	{
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		try
		{
			try
			{
				composedToBytes.invokeExact(this, buf);
			}
			catch (Throwable t)
			{
				hideException(t);
			}
			/*Class<?> clazz = this.getClass();
			Field[] clFields = getClassFields(clazz);
			for (Field f : clFields)
			{
				Class<?> type = f.getType();
				if (acceptField(f, type))
					this.writeField(f, type, buf);
			}*/
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
		handler.right.write(f.get(this), buf);
	}

	public interface Reader<T>
	{
		T read(ByteBuf buf);
	}

	public interface Writer<T>
	{
		void write(T t, ByteBuf buf);
	}

	private static MethodHandle composedToBytes;
	private static MethodHandle composedFromBytes;

	public static void initializeSerialization(ArrayList<Class<? extends PMessage<?>>> messages) throws NoSuchMethodException, IllegalAccessException
	{
		composedToBytes = composeToBytesMethods(messages);
		composedFromBytes = composeFromBytesMethods(messages);
	}
}
