package com.parzivail.pswm.capability;

/**
 * Created by colby on 5/18/2017.
 */
public class ForceXp implements IForceCapability
{
	private static final int SECONDS_TO_REFILL = 10;
	int xp = 100;
	int limit = 100;

	@Override
	public int getForceXp()
	{
		return xp;
	}

	@Override
	public int getForceXpLimit()
	{
		return limit;
	}

	@Override
	public boolean consume(int xp)
	{
		if (this.xp - xp >= 0)
		{
			this.xp -= xp;
			return true;
		}

		return false;
	}

	@Override
	public void produce(int xp)
	{
		this.xp = Math.min(this.xp + xp, limit);
	}

	@Override
	public void increment()
	{
		this.produce(this.limit / SECONDS_TO_REFILL);
	}

	@Override
	public void set(int xp)
	{
		this.xp = Math.min(limit, xp);
	}

	@Override
	public void setLimit(int xp)
	{
		this.limit = xp;
		this.xp = Math.min(this.xp, limit);
	}
}
