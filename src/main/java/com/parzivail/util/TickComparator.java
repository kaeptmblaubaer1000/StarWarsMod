package com.parzivail.util;

/**
 * Compares a boolean between two ticks to check for a change. Useful for
 * starting or stopping things, or events, based on what a player's doing
 * 
 * @author Colby
 *
 */
public class TickComparator
{
	private boolean was = false;
	/** Set this every tick to whatever you're checking **/
	public boolean is = false;

	/**
	 * Checks if there was a change from false to true
	 * 
	 * @return Returns true if there was a change from false to true this tick
	 */
	public boolean changeTrue()
	{
		return this.is && !this.was;
	}

	/**
	 * Checks if there was a change from true to false
	 * 
	 * @return Returns true if there was a change from true to false this tick
	 */
	public boolean changeFalse()
	{
		return !this.is && this.was;
	}

	/**
	 * Sets was to is, so we can store last tick's boolean
	 */
	public void tick()
	{
		this.was = this.is;
	}
}
