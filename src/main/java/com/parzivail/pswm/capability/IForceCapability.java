package com.parzivail.pswm.capability;

/**
 * Created by colby on 5/18/2017.
 */
public interface IForceCapability
{
	int getForceXp();

	int getForceXpLimit();

	boolean consume(int xp);

	void produce(int xp);

	void increment();

	void set(int xp);

	void setLimit(int xp);
}
