package com.parzivail.pswm;

import com.parzivail.util.PNBTSerial;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

/**
 * Created by Colby on 6/28/2016.
 */
public class TestNBTSerial extends PNBTSerial
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

	public static NBTTagCompound serialized;

	public TestNBTSerial()
	{
		this.b = 127;
		this.s = 4096;
		this.i = 12345;
		this.l = 79864980256456L;
		this.f = 123.4567f;
		this.d = 123.456789d;
		this.bo = false;
		this.c = 'x';
		this.st = "Hello, World!";

		this.cmp = new NBTTagCompound();
		this.cmp.setInteger("testInt", 456);
		this.cmp.setIntArray("testArray", new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });

		this.stack = new ItemStack(StarWarsItems.blasterHeavy);

		serialized = this.serialize();
	}
}
