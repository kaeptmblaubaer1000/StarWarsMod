package com.parzivail.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Colby on 1/30/2017.
 */
public class Group
{
	@SafeVarargs
	public static <T> List<T> of(T... elements)
	{
		ArrayList<T> l = new ArrayList<T>();
		Collections.addAll(l, elements);
		return l;
	}
}
