package com.parzivail.pswm.dimension;

import com.parzivail.util.math.FPoint;
import com.parzivail.util.math.Spline2D;

/**
 * Created by Colby on 5/15/2016.
 */
public class TradeRoute
{
	private Spline2D route;

	public TradeRoute(FPoint[] points)
	{
		this.route = new Spline2D(points);
	}

	public FPoint getPointAlongPath(float percent)
	{
		if (percent > 1)
			percent = 1;
		if (percent < 0)
			percent = 0;
		return this.route.getPoint(percent);
	}

	public Spline2D getRoute()
	{
		return route;
	}
}
