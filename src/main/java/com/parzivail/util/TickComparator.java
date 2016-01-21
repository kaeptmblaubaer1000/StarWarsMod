package com.parzivail.util;

public class TickComparator
{
	public boolean was = false;
	public boolean is = false;
	
	public boolean changeTrue()
	{
		return this.is && !this.was;
	}
	
	public boolean changeFalse()
	{
		return !this.is && this.was;
	}
	
	public void tick()
	{
		this.was = this.is;
	}
}
