package com.parzivail.pswm.item;

import com.parzivail.pswm.PSWM;
import com.parzivail.util.basic.BasicItem;

/**
 * Created by colby on 2/5/2017.
 */
public class BlasterBase extends BasicItem
{
	public BlasterBase(String name)
	{
		super(name);
		this.setCreativeTab(PSWM.tabWeapons);
	}
}
