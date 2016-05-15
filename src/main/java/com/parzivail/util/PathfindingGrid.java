package com.parzivail.util;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Created by Colby on 5/14/2016.
 */
public class PathfindingGrid
{
	public class GridPoint
	{
		int x;
		int y;
		int weight;

		public GridPoint(int x, int y, int weight)
		{
			this.x = x;
			this.y = y;
			this.weight = weight;
		}

		public Point getPosition()
		{
			return new Point(x, y);
		}
	}

	class PPoint implements Comparable<PPoint>
	{
		Point p;
		int priority;

		public PPoint(int x, int y, int priority)
		{
			this.p = new Point(x, y);
			this.priority = priority;
		}

		@Override
		public int compareTo(PPoint o)
		{
			return Integer.compare(this.priority, o.priority);
		}
	}

	GridPoint[][] grid;
	int width;
	int height;

	public PathfindingGrid(int width, int height, int baseWeight)
	{
		this.width = width;
		this.height = height;
		grid = new GridPoint[width][height];
		for (int i = 0; i < width; i++)
			for (int j = 0; j < height; j++)
				grid[i][j] = new GridPoint(i, j, baseWeight);
	}

	public void setWeightAt(int x, int y, int weight)
	{
		grid[x][y] = new GridPoint(x, y, weight);
	}

	public GridPoint getPointAt(int x, int y)
	{
		return grid[x][y];
	}

	public ArrayList<GridPoint> getNeighborsOf(int x, int y)
	{
		ArrayList<GridPoint> neighbors = new ArrayList<>();
		if (x + 1 < width)
			neighbors.add(getPointAt(x + 1, y));
		if (x - 1 >= 0)
			neighbors.add(getPointAt(x - 1, y));
		if (y + 1 < height)
			neighbors.add(getPointAt(x, y + 1));
		if (y - 1 >= 0)
			neighbors.add(getPointAt(x, y - 1));
		return neighbors;
	}

	public ArrayList<Point> getPathFrom(int x1, int y1, int x2, int y2)
	{
		Point start = new Point(x1, y1);
		Point goal = new Point(x2, y2);

		PriorityQueue<PPoint> frontier = new PriorityQueue<>();
		frontier.add(new PPoint(x1, y1, 0));

		HashMap<Point, Point> cameFrom = new HashMap<>();
		cameFrom.put(start, null);

		HashMap<Point, Integer> costSoFar = new HashMap<Point, Integer>();
		costSoFar.put(start, 0);

		while (!frontier.isEmpty())
		{
			PPoint current = frontier.poll();

			for (GridPoint next : getNeighborsOf(current.p.x, current.p.y))
			{
				int newCost = costSoFar.get(current.p) + next.weight;
				if (!costSoFar.containsKey(next.getPosition()) || newCost < costSoFar.get(next.getPosition()))
				{
					costSoFar.put(next.getPosition(), newCost);
					frontier.add(new PPoint(next.getPosition().x, next.getPosition().y, newCost));
					cameFrom.put(next.getPosition(), current.p);
				}
			}
		}

		Point current = goal;
		ArrayList<Point> path = new ArrayList<>();
		path.add(current);

		while (cameFrom.get(current) != null)
		{
			current = cameFrom.get(current);
			path.add(current);
		}

		Collections.reverse(path);

		return path;
	}
}
