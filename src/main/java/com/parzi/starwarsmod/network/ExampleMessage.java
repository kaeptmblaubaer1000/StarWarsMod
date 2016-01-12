package com.parzi.starwarsmod.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ExampleMessage extends Message
{

	public byte b;
	public short s;
	public int i;
	public long l;
	public float f;
	public double d;
	public boolean bo;
	public char c;
	public String st;
	public NBTTagCompound cmp;
	public ItemStack stack;

	public transient int trInt = 4;

	public ExampleMessage()
	{
	}

	public ExampleMessage(byte b, short s, int i, long l, float f, double d, boolean bo, char c, String st, NBTTagCompound cmp, ItemStack stack, int trInt)
	{
		this.b = b;
		this.s = s;
		this.i = i;
		this.l = l;
		this.f = f;
		this.d = d;
		this.bo = bo;
		this.c = c;
		this.st = st;
		this.cmp = cmp;
		this.stack = stack;

		this.trInt = trInt;
	}

	@Override
	public IMessage handleMessage(MessageContext context)
	{
		System.out.println("byte is " + b);
		System.out.println("short is " + s);
		System.out.println("int is " + i);
		System.out.println("long is " + l);
		System.out.println("float is " + f);
		System.out.println("double is " + d);
		System.out.println("boolean is " + bo);
		System.out.println("char is " + c);
		System.out.println("String is " + st);
		System.out.println("NBTTagCompount is " + cmp);
		System.out.println("ItemStack is " + stack);
		System.out.println("trInt is " + trInt);
		return null;
	}

}