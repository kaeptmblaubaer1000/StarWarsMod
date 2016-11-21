package com.parzivail.pswm.gui;

/**
 * Created by colby on 11/20/2016.
 */
public class Tuple<T, T1>
{
	private T a;
	private T1 b;

	public Tuple(T a, T1 b)
	{
		this.a = a;
		this.b = b;
	}

	public T getA()
	{
		return a;
	}

	public T1 getB()
	{
		return b;
	}
}
