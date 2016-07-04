package com.parzivail.pswm.rendering.helper;

import com.parzivail.util.ui.GFX;

public class VehicleLineDraw
{
	public static void drawAWing(float x, float y, int lineWidth, int color, float scale)
	{
		GFX.drawLine(x + -123 * scale, y + -70 * scale, x + 0 * scale, y + -70 * scale, lineWidth, color);
		GFX.drawLine(x + 0 * scale, y + -70 * scale, x + 122 * scale, y + -70 * scale, lineWidth, color);
		GFX.drawLine(x + 122 * scale, y + -70 * scale, x + 210 * scale, y + -35 * scale, lineWidth, color);
		GFX.drawLine(x + 210 * scale, y + -35 * scale, x + 210 * scale, y + 35 * scale, lineWidth, color);
		GFX.drawLine(x + 210 * scale, y + 35 * scale, x + 122 * scale, y + 70 * scale, lineWidth, color);
		GFX.drawLine(x + 122 * scale, y + 70 * scale, x + -123 * scale, y + 70 * scale, lineWidth, color);
		GFX.drawLine(x + -123 * scale, y + 70 * scale, x + -210 * scale, y + 35 * scale, lineWidth, color);
		GFX.drawLine(x + -210 * scale, y + 35 * scale, x + -210 * scale, y + -35 * scale, lineWidth, color);
		GFX.drawLine(x + -210 * scale, y + -35 * scale, x + -123 * scale, y + -70 * scale, lineWidth, color);
		GFX.drawLine(x + -158 * scale, y + -35 * scale, x + -158 * scale, y + 35 * scale, lineWidth, color);
		GFX.drawLine(x + -158 * scale, y + 35 * scale, x + -88 * scale, y + 35 * scale, lineWidth, color);
		GFX.drawLine(x + -88 * scale, y + 35 * scale, x + -88 * scale, y + -35 * scale, lineWidth, color);
		GFX.drawLine(x + -88 * scale, y + -35 * scale, x + -158 * scale, y + -35 * scale, lineWidth, color);
		GFX.drawLine(x + 157 * scale, y + -35 * scale, x + 157 * scale, y + 35 * scale, lineWidth, color);
		GFX.drawLine(x + 157 * scale, y + 35 * scale, x + 87 * scale, y + 35 * scale, lineWidth, color);
		GFX.drawLine(x + 87 * scale, y + 35 * scale, x + 87 * scale, y + -35 * scale, lineWidth, color);
		GFX.drawLine(x + 87 * scale, y + -35 * scale, x + 157 * scale, y + -35 * scale, lineWidth, color);
		GFX.drawLine(x + 105 * scale, y + -70 * scale, x + 105 * scale, y + -140 * scale, lineWidth, color);
		GFX.drawLine(x + 105 * scale, y + -140 * scale, x + 140 * scale, y + -140 * scale, lineWidth, color);
		GFX.drawLine(x + 140 * scale, y + -140 * scale, x + 140 * scale, y + -70 * scale, lineWidth, color);
		GFX.drawLine(x + 105 * scale, y + 70 * scale, x + 105 * scale, y + 140 * scale, lineWidth, color);
		GFX.drawLine(x + 105 * scale, y + 140 * scale, x + 140 * scale, y + 140 * scale, lineWidth, color);
		GFX.drawLine(x + 140 * scale, y + 140 * scale, x + 140 * scale, y + 70 * scale, lineWidth, color);
		GFX.drawLine(x + -105 * scale, y + -70 * scale, x + -105 * scale, y + -140 * scale, lineWidth, color);
		GFX.drawLine(x + -105 * scale, y + -140 * scale, x + -140 * scale, y + -140 * scale, lineWidth, color);
		GFX.drawLine(x + -140 * scale, y + -140 * scale, x + -140 * scale, y + -70 * scale, lineWidth, color);
		GFX.drawLine(x + -105 * scale, y + 70 * scale, x + -105 * scale, y + 140 * scale, lineWidth, color);
		GFX.drawLine(x + -105 * scale, y + 140 * scale, x + -140 * scale, y + 140 * scale, lineWidth, color);
		GFX.drawLine(x + -140 * scale, y + 140 * scale, x + -140 * scale, y + 70 * scale, lineWidth, color);
		GFX.drawLine(x + -70 * scale, y + -53 * scale, x + -70 * scale, y + -18 * scale, lineWidth, color);
		GFX.drawLine(x + -70 * scale, y + -18 * scale, x + 70 * scale, y + -18 * scale, lineWidth, color);
		GFX.drawLine(x + 70 * scale, y + -18 * scale, x + 70 * scale, y + -53 * scale, lineWidth, color);
		GFX.drawLine(x + 70 * scale, y + -53 * scale, x + -70 * scale, y + -53 * scale, lineWidth, color);
		GFX.drawLine(x + -70 * scale, y + 17 * scale, x + -70 * scale, y + 52 * scale, lineWidth, color);
		GFX.drawLine(x + -70 * scale, y + 52 * scale, x + 70 * scale, y + 52 * scale, lineWidth, color);
		GFX.drawLine(x + 70 * scale, y + 52 * scale, x + 70 * scale, y + 17 * scale, lineWidth, color);
		GFX.drawLine(x + 70 * scale, y + 17 * scale, x + -70 * scale, y + 17 * scale, lineWidth, color);
		GFX.drawLine(x + 210 * scale, y + -18 * scale, x + 262 * scale, y + -18 * scale, lineWidth, color);
		GFX.drawLine(x + 262 * scale, y + -18 * scale, x + 262 * scale, y + 17 * scale, lineWidth, color);
		GFX.drawLine(x + 262 * scale, y + 17 * scale, x + 210 * scale, y + 17 * scale, lineWidth, color);
		GFX.drawLine(x + -210 * scale, y + -18 * scale, x + -263 * scale, y + -18 * scale, lineWidth, color);
		GFX.drawLine(x + -263 * scale, y + -18 * scale, x + -263 * scale, y + 17 * scale, lineWidth, color);
		GFX.drawLine(x + -263 * scale, y + 17 * scale, x + -210 * scale, y + 17 * scale, lineWidth, color);
		GFX.drawLine(x + 227 * scale, y + -18 * scale, x + 227 * scale, y + -53 * scale, lineWidth, color);
		GFX.drawLine(x + 227 * scale, y + -53 * scale, x + 245 * scale, y + -53 * scale, lineWidth, color);
		GFX.drawLine(x + 245 * scale, y + -53 * scale, x + 245 * scale, y + -18 * scale, lineWidth, color);
		GFX.drawLine(x + 227 * scale, y + 17 * scale, x + 227 * scale, y + 52 * scale, lineWidth, color);
		GFX.drawLine(x + 227 * scale, y + 52 * scale, x + 245 * scale, y + 52 * scale, lineWidth, color);
		GFX.drawLine(x + 245 * scale, y + 52 * scale, x + 245 * scale, y + 17 * scale, lineWidth, color);
		GFX.drawLine(x + -245 * scale, y + -18 * scale, x + -245 * scale, y + -53 * scale, lineWidth, color);
		GFX.drawLine(x + -245 * scale, y + -53 * scale, x + -228 * scale, y + -53 * scale, lineWidth, color);
		GFX.drawLine(x + -228 * scale, y + -53 * scale, x + -228 * scale, y + -18 * scale, lineWidth, color);
		GFX.drawLine(x + -245 * scale, y + 17 * scale, x + -245 * scale, y + 52 * scale, lineWidth, color);
		GFX.drawLine(x + -245 * scale, y + 52 * scale, x + -228 * scale, y + 52 * scale, lineWidth, color);
		GFX.drawLine(x + -228 * scale, y + 52 * scale, x + -228 * scale, y + 17 * scale, lineWidth, color);
		GFX.drawLine(x + -140 * scale, y + -18 * scale, x + -140 * scale, y + 17 * scale, lineWidth, color);
		GFX.drawLine(x + -140 * scale, y + 17 * scale, x + -105 * scale, y + 17 * scale, lineWidth, color);
		GFX.drawLine(x + -105 * scale, y + 17 * scale, x + -105 * scale, y + -18 * scale, lineWidth, color);
		GFX.drawLine(x + -105 * scale, y + -18 * scale, x + -140 * scale, y + -18 * scale, lineWidth, color);
		GFX.drawLine(x + 105 * scale, y + -18 * scale, x + 105 * scale, y + 17 * scale, lineWidth, color);
		GFX.drawLine(x + 105 * scale, y + 17 * scale, x + 140 * scale, y + 17 * scale, lineWidth, color);
		GFX.drawLine(x + 140 * scale, y + 17 * scale, x + 140 * scale, y + -18 * scale, lineWidth, color);
		GFX.drawLine(x + 140 * scale, y + -18 * scale, x + 105 * scale, y + -18 * scale, lineWidth, color);
		GFX.drawLine(x + -35 * scale, y + -70 * scale, x + -35 * scale, y + -123 * scale, lineWidth, color);
		GFX.drawLine(x + -35 * scale, y + -123 * scale, x + 35 * scale, y + -123 * scale, lineWidth, color);
		GFX.drawLine(x + 35 * scale, y + -123 * scale, x + 35 * scale, y + -70 * scale, lineWidth, color);
	}

	public static void drawTie(float x, float y, int lineWidth, int color, float scale)
	{
		GFX.drawLine(x + 0 * scale, y + -70 * scale, x + 17 * scale, y + -70 * scale, lineWidth, color);
		GFX.drawLine(x + 17 * scale, y + -70 * scale, x + 35 * scale, y + -53 * scale, lineWidth, color);
		GFX.drawLine(x + 35 * scale, y + -53 * scale, x + 52 * scale, y + -35 * scale, lineWidth, color);
		GFX.drawLine(x + 52 * scale, y + -35 * scale, x + 70 * scale, y + -18 * scale, lineWidth, color);
		GFX.drawLine(x + 70 * scale, y + -18 * scale, x + 70 * scale, y + 0 * scale, lineWidth, color);
		GFX.drawLine(x + 70 * scale, y + 0 * scale, x + 70 * scale, y + 17 * scale, lineWidth, color);
		GFX.drawLine(x + 70 * scale, y + 17 * scale, x + 52 * scale, y + 35 * scale, lineWidth, color);
		GFX.drawLine(x + 52 * scale, y + 35 * scale, x + 35 * scale, y + 52 * scale, lineWidth, color);
		GFX.drawLine(x + 35 * scale, y + 52 * scale, x + 17 * scale, y + 70 * scale, lineWidth, color);
		GFX.drawLine(x + 17 * scale, y + 70 * scale, x + 0 * scale, y + 70 * scale, lineWidth, color);
		GFX.drawLine(x + 0 * scale, y + 70 * scale, x + -18 * scale, y + 70 * scale, lineWidth, color);
		GFX.drawLine(x + -18 * scale, y + 70 * scale, x + -35 * scale, y + 52 * scale, lineWidth, color);
		GFX.drawLine(x + -35 * scale, y + 52 * scale, x + -53 * scale, y + 35 * scale, lineWidth, color);
		GFX.drawLine(x + -53 * scale, y + 35 * scale, x + -70 * scale, y + 17 * scale, lineWidth, color);
		GFX.drawLine(x + -70 * scale, y + 17 * scale, x + -70 * scale, y + -18 * scale, lineWidth, color);
		GFX.drawLine(x + -70 * scale, y + -18 * scale, x + -53 * scale, y + -35 * scale, lineWidth, color);
		GFX.drawLine(x + -53 * scale, y + -35 * scale, x + -35 * scale, y + -53 * scale, lineWidth, color);
		GFX.drawLine(x + -35 * scale, y + -53 * scale, x + -18 * scale, y + -70 * scale, lineWidth, color);
		GFX.drawLine(x + -18 * scale, y + -70 * scale, x + 0 * scale, y + -70 * scale, lineWidth, color);
		GFX.drawLine(x + 70 * scale, y + -18 * scale, x + 140 * scale, y + -18 * scale, lineWidth, color);
		GFX.drawLine(x + 140 * scale, y + -18 * scale, x + 140 * scale, y + 17 * scale, lineWidth, color);
		GFX.drawLine(x + 140 * scale, y + 17 * scale, x + 70 * scale, y + 17 * scale, lineWidth, color);
		GFX.drawLine(x + -140 * scale, y + -18 * scale, x + -70 * scale, y + -18 * scale, lineWidth, color);
		GFX.drawLine(x + -70 * scale, y + -18 * scale, x + -70 * scale, y + 17 * scale, lineWidth, color);
		GFX.drawLine(x + -70 * scale, y + 17 * scale, x + -140 * scale, y + 17 * scale, lineWidth, color);
		GFX.drawLine(x + -140 * scale, y + 17 * scale, x + -140 * scale, y + -18 * scale, lineWidth, color);
		GFX.drawLine(x + 140 * scale, y + -158 * scale, x + 140 * scale, y + 0 * scale, lineWidth, color);
		GFX.drawLine(x + 140 * scale, y + 0 * scale, x + 140 * scale, y + 157 * scale, lineWidth, color);
		GFX.drawLine(x + 140 * scale, y + 157 * scale, x + 192 * scale, y + 157 * scale, lineWidth, color);
		GFX.drawLine(x + 192 * scale, y + 157 * scale, x + 192 * scale, y + -158 * scale, lineWidth, color);
		GFX.drawLine(x + 192 * scale, y + -158 * scale, x + 140 * scale, y + -158 * scale, lineWidth, color);
		GFX.drawLine(x + -140 * scale, y + 0 * scale, x + -140 * scale, y + -158 * scale, lineWidth, color);
		GFX.drawLine(x + -140 * scale, y + -158 * scale, x + -193 * scale, y + -158 * scale, lineWidth, color);
		GFX.drawLine(x + -193 * scale, y + -158 * scale, x + -193 * scale, y + 157 * scale, lineWidth, color);
		GFX.drawLine(x + -193 * scale, y + 157 * scale, x + -140 * scale, y + 157 * scale, lineWidth, color);
		GFX.drawLine(x + -140 * scale, y + 157 * scale, x + -140 * scale, y + 17 * scale, lineWidth, color);
		GFX.drawLine(x + -18 * scale, y + -18 * scale, x + -18 * scale, y + 17 * scale, lineWidth, color);
		GFX.drawLine(x + -18 * scale, y + 17 * scale, x + 17 * scale, y + 17 * scale, lineWidth, color);
		GFX.drawLine(x + 17 * scale, y + 17 * scale, x + 17 * scale, y + -18 * scale, lineWidth, color);
		GFX.drawLine(x + 17 * scale, y + -18 * scale, x + -18 * scale, y + -18 * scale, lineWidth, color);
		GFX.drawLine(x + 52 * scale, y + -35 * scale, x + 87 * scale, y + -35 * scale, lineWidth, color);
		GFX.drawLine(x + 87 * scale, y + -35 * scale, x + 87 * scale, y + -18 * scale, lineWidth, color);
		GFX.drawLine(x + 52 * scale, y + 35 * scale, x + 87 * scale, y + 35 * scale, lineWidth, color);
		GFX.drawLine(x + 87 * scale, y + 35 * scale, x + 87 * scale, y + 17 * scale, lineWidth, color);
		GFX.drawLine(x + -53 * scale, y + -35 * scale, x + -88 * scale, y + -35 * scale, lineWidth, color);
		GFX.drawLine(x + -88 * scale, y + -35 * scale, x + -88 * scale, y + -18 * scale, lineWidth, color);
		GFX.drawLine(x + -88 * scale, y + 17 * scale, x + -88 * scale, y + 35 * scale, lineWidth, color);
		GFX.drawLine(x + -88 * scale, y + 35 * scale, x + -53 * scale, y + 35 * scale, lineWidth, color);
	}

	public static void drawTieInterceptor(float x, float y, int lineWidth, int color, float scale)
	{
		GFX.drawLine(x + 0 * scale, y + -18 * scale, x + 17 * scale, y + -18 * scale, lineWidth, color);
		GFX.drawLine(x + 17 * scale, y + -18 * scale, x + 17 * scale, y + 17 * scale, lineWidth, color);
		GFX.drawLine(x + 17 * scale, y + 17 * scale, x + -18 * scale, y + 17 * scale, lineWidth, color);
		GFX.drawLine(x + -18 * scale, y + 17 * scale, x + -18 * scale, y + -18 * scale, lineWidth, color);
		GFX.drawLine(x + -18 * scale, y + -18 * scale, x + 0 * scale, y + -18 * scale, lineWidth, color);
		GFX.drawLine(x + 0 * scale, y + -70 * scale, x + 17 * scale, y + -70 * scale, lineWidth, color);
		GFX.drawLine(x + 17 * scale, y + -70 * scale, x + 70 * scale, y + -18 * scale, lineWidth, color);
		GFX.drawLine(x + 70 * scale, y + -18 * scale, x + 70 * scale, y + 17 * scale, lineWidth, color);
		GFX.drawLine(x + 70 * scale, y + 17 * scale, x + 17 * scale, y + 70 * scale, lineWidth, color);
		GFX.drawLine(x + 17 * scale, y + 70 * scale, x + -18 * scale, y + 70 * scale, lineWidth, color);
		GFX.drawLine(x + -18 * scale, y + 70 * scale, x + -70 * scale, y + 17 * scale, lineWidth, color);
		GFX.drawLine(x + -70 * scale, y + 17 * scale, x + -70 * scale, y + -18 * scale, lineWidth, color);
		GFX.drawLine(x + -70 * scale, y + -18 * scale, x + -18 * scale, y + -70 * scale, lineWidth, color);
		GFX.drawLine(x + -18 * scale, y + -70 * scale, x + 0 * scale, y + -70 * scale, lineWidth, color);
		GFX.drawLine(x + 70 * scale, y + -18 * scale, x + 140 * scale, y + -18 * scale, lineWidth, color);
		GFX.drawLine(x + 140 * scale, y + -18 * scale, x + 140 * scale, y + 17 * scale, lineWidth, color);
		GFX.drawLine(x + 140 * scale, y + 17 * scale, x + 70 * scale, y + 17 * scale, lineWidth, color);
		GFX.drawLine(x + -140 * scale, y + -18 * scale, x + -70 * scale, y + -18 * scale, lineWidth, color);
		GFX.drawLine(x + -70 * scale, y + -18 * scale, x + -70 * scale, y + 17 * scale, lineWidth, color);
		GFX.drawLine(x + -70 * scale, y + 17 * scale, x + -140 * scale, y + 17 * scale, lineWidth, color);
		GFX.drawLine(x + -140 * scale, y + 17 * scale, x + -140 * scale, y + -18 * scale, lineWidth, color);
		GFX.drawLine(x + 140 * scale, y + -70 * scale, x + 140 * scale, y + -70 * scale, lineWidth, color);
		GFX.drawLine(x + 140 * scale, y + -70 * scale, x + 140 * scale, y + 70 * scale, lineWidth, color);
		GFX.drawLine(x + 175 * scale, y + -70 * scale, x + 175 * scale, y + 70 * scale, lineWidth, color);
		GFX.drawLine(x + 140 * scale, y + -70 * scale, x + 87 * scale, y + -158 * scale, lineWidth, color);
		GFX.drawLine(x + 175 * scale, y + -70 * scale, x + 122 * scale, y + -158 * scale, lineWidth, color);
		GFX.drawLine(x + 122 * scale, y + -158 * scale, x + 87 * scale, y + -158 * scale, lineWidth, color);
		GFX.drawLine(x + 140 * scale, y + 70 * scale, x + 87 * scale, y + 157 * scale, lineWidth, color);
		GFX.drawLine(x + 175 * scale, y + 70 * scale, x + 122 * scale, y + 157 * scale, lineWidth, color);
		GFX.drawLine(x + 87 * scale, y + 157 * scale, x + 122 * scale, y + 157 * scale, lineWidth, color);
		GFX.drawLine(x + -140 * scale, y + -70 * scale, x + -140 * scale, y + 70 * scale, lineWidth, color);
		GFX.drawLine(x + -175 * scale, y + -70 * scale, x + -175 * scale, y + 70 * scale, lineWidth, color);
		GFX.drawLine(x + -140 * scale, y + -70 * scale, x + -88 * scale, y + -158 * scale, lineWidth, color);
		GFX.drawLine(x + -175 * scale, y + -70 * scale, x + -123 * scale, y + -158 * scale, lineWidth, color);
		GFX.drawLine(x + -123 * scale, y + -158 * scale, x + -88 * scale, y + -158 * scale, lineWidth, color);
		GFX.drawLine(x + -140 * scale, y + 70 * scale, x + -88 * scale, y + 157 * scale, lineWidth, color);
		GFX.drawLine(x + -175 * scale, y + 70 * scale, x + -123 * scale, y + 157 * scale, lineWidth, color);
		GFX.drawLine(x + -123 * scale, y + 157 * scale, x + -88 * scale, y + 157 * scale, lineWidth, color);
		GFX.drawLine(x + -53 * scale, y + -35 * scale, x + -88 * scale, y + -35 * scale, lineWidth, color);
		GFX.drawLine(x + -88 * scale, y + -35 * scale, x + -88 * scale, y + -18 * scale, lineWidth, color);
		GFX.drawLine(x + -88 * scale, y + 17 * scale, x + -88 * scale, y + 35 * scale, lineWidth, color);
		GFX.drawLine(x + -88 * scale, y + 35 * scale, x + -53 * scale, y + 35 * scale, lineWidth, color);
		GFX.drawLine(x + 52 * scale, y + -35 * scale, x + 87 * scale, y + -35 * scale, lineWidth, color);
		GFX.drawLine(x + 87 * scale, y + -35 * scale, x + 87 * scale, y + -18 * scale, lineWidth, color);
		GFX.drawLine(x + 87 * scale, y + 17 * scale, x + 87 * scale, y + 35 * scale, lineWidth, color);
		GFX.drawLine(x + 87 * scale, y + 35 * scale, x + 52 * scale, y + 35 * scale, lineWidth, color);
	}

	public static void drawXWing(float x, float y, int lineWidth, int color, float scale)
	{
		GFX.drawLine(x + -35 * scale, y + -53 * scale, x + 35 * scale, y + -53 * scale, lineWidth, color);
		GFX.drawLine(x + 35 * scale, y + -53 * scale, x + 52 * scale, y + 0 * scale, lineWidth, color);
		GFX.drawLine(x + 52 * scale, y + 0 * scale, x + 35 * scale, y + 52 * scale, lineWidth, color);
		GFX.drawLine(x + 35 * scale, y + 52 * scale, x + -35 * scale, y + 52 * scale, lineWidth, color);
		GFX.drawLine(x + -35 * scale, y + 52 * scale, x + -53 * scale, y + 0 * scale, lineWidth, color);
		GFX.drawLine(x + -53 * scale, y + 0 * scale, x + -35 * scale, y + -53 * scale, lineWidth, color);
		GFX.drawLine(x + -18 * scale, y + -35 * scale, x + -35 * scale, y + 0 * scale, lineWidth, color);
		GFX.drawLine(x + -35 * scale, y + 0 * scale, x + -18 * scale, y + 35 * scale, lineWidth, color);
		GFX.drawLine(x + -18 * scale, y + 35 * scale, x + 17 * scale, y + 35 * scale, lineWidth, color);
		GFX.drawLine(x + 17 * scale, y + 35 * scale, x + 35 * scale, y + 0 * scale, lineWidth, color);
		GFX.drawLine(x + 35 * scale, y + 0 * scale, x + 17 * scale, y + -35 * scale, lineWidth, color);
		GFX.drawLine(x + 17 * scale, y + -35 * scale, x + -18 * scale, y + -35 * scale, lineWidth, color);
		GFX.drawLine(x + 52 * scale, y + 0 * scale, x + 262 * scale, y + 0 * scale, lineWidth, color);
		GFX.drawLine(x + -263 * scale, y + 0 * scale, x + -53 * scale, y + 0 * scale, lineWidth, color);
		GFX.drawLine(x + 52 * scale, y + -18 * scale, x + 262 * scale, y + -18 * scale, lineWidth, color);
		GFX.drawLine(x + 262 * scale, y + -18 * scale, x + 262 * scale, y + 17 * scale, lineWidth, color);
		GFX.drawLine(x + 262 * scale, y + 17 * scale, x + 52 * scale, y + 17 * scale, lineWidth, color);
		GFX.drawLine(x + -53 * scale, y + -18 * scale, x + -263 * scale, y + -18 * scale, lineWidth, color);
		GFX.drawLine(x + -263 * scale, y + -18 * scale, x + -263 * scale, y + 17 * scale, lineWidth, color);
		GFX.drawLine(x + -263 * scale, y + 17 * scale, x + -53 * scale, y + 17 * scale, lineWidth, color);
		GFX.drawLine(x + -105 * scale, y + 17 * scale, x + -35 * scale, y + 52 * scale, lineWidth, color);
		GFX.drawLine(x + -35 * scale, y + 52 * scale, x + 35 * scale, y + 52 * scale, lineWidth, color);
		GFX.drawLine(x + 35 * scale, y + 52 * scale, x + 105 * scale, y + 17 * scale, lineWidth, color);
		GFX.drawLine(x + -105 * scale, y + -18 * scale, x + -35 * scale, y + -53 * scale, lineWidth, color);
		GFX.drawLine(x + -35 * scale, y + -53 * scale, x + 35 * scale, y + -53 * scale, lineWidth, color);
		GFX.drawLine(x + 35 * scale, y + -53 * scale, x + 105 * scale, y + -18 * scale, lineWidth, color);
		GFX.drawLine(x + -88 * scale, y + -35 * scale, x + -105 * scale, y + -35 * scale, lineWidth, color);
		GFX.drawLine(x + -105 * scale, y + -35 * scale, x + -105 * scale, y + -70 * scale, lineWidth, color);
		GFX.drawLine(x + -105 * scale, y + -70 * scale, x + -70 * scale, y + -70 * scale, lineWidth, color);
		GFX.drawLine(x + -70 * scale, y + -70 * scale, x + -70 * scale, y + -35 * scale, lineWidth, color);
		GFX.drawLine(x + -70 * scale, y + -35 * scale, x + -88 * scale, y + -35 * scale, lineWidth, color);
		GFX.drawLine(x + 70 * scale, y + -35 * scale, x + 105 * scale, y + -35 * scale, lineWidth, color);
		GFX.drawLine(x + 105 * scale, y + -35 * scale, x + 105 * scale, y + -70 * scale, lineWidth, color);
		GFX.drawLine(x + 105 * scale, y + -70 * scale, x + 70 * scale, y + -70 * scale, lineWidth, color);
		GFX.drawLine(x + 70 * scale, y + -70 * scale, x + 70 * scale, y + -35 * scale, lineWidth, color);
		GFX.drawLine(x + -70 * scale, y + 35 * scale, x + -70 * scale, y + 70 * scale, lineWidth, color);
		GFX.drawLine(x + -70 * scale, y + 70 * scale, x + -105 * scale, y + 70 * scale, lineWidth, color);
		GFX.drawLine(x + -105 * scale, y + 70 * scale, x + -105 * scale, y + 35 * scale, lineWidth, color);
		GFX.drawLine(x + -105 * scale, y + 35 * scale, x + -70 * scale, y + 35 * scale, lineWidth, color);
		GFX.drawLine(x + 70 * scale, y + 35 * scale, x + 70 * scale, y + 70 * scale, lineWidth, color);
		GFX.drawLine(x + 70 * scale, y + 70 * scale, x + 105 * scale, y + 70 * scale, lineWidth, color);
		GFX.drawLine(x + 105 * scale, y + 70 * scale, x + 105 * scale, y + 35 * scale, lineWidth, color);
		GFX.drawLine(x + 105 * scale, y + 35 * scale, x + 70 * scale, y + 35 * scale, lineWidth, color);
		GFX.drawLine(x + -263 * scale, y + -35 * scale, x + -245 * scale, y + -35 * scale, lineWidth, color);
		GFX.drawLine(x + -245 * scale, y + -35 * scale, x + -245 * scale, y + -53 * scale, lineWidth, color);
		GFX.drawLine(x + -245 * scale, y + -53 * scale, x + -263 * scale, y + -53 * scale, lineWidth, color);
		GFX.drawLine(x + -263 * scale, y + -53 * scale, x + -263 * scale, y + -35 * scale, lineWidth, color);
		GFX.drawLine(x + -263 * scale, y + -35 * scale, x + -255 * scale, y + -36 * scale, lineWidth, color);
		GFX.drawLine(x + -255 * scale, y + -36 * scale, x + -255 * scale, y + -19 * scale, lineWidth, color);
		GFX.drawLine(x + -263 * scale, y + 35 * scale, x + -245 * scale, y + 35 * scale, lineWidth, color);
		GFX.drawLine(x + -245 * scale, y + 35 * scale, x + -245 * scale, y + 52 * scale, lineWidth, color);
		GFX.drawLine(x + -245 * scale, y + 52 * scale, x + -263 * scale, y + 52 * scale, lineWidth, color);
		GFX.drawLine(x + -263 * scale, y + 52 * scale, x + -263 * scale, y + 35 * scale, lineWidth, color);
		GFX.drawLine(x + -263 * scale, y + 35 * scale, x + -255 * scale, y + 35 * scale, lineWidth, color);
		GFX.drawLine(x + -255 * scale, y + 35 * scale, x + -256 * scale, y + 18 * scale, lineWidth, color);
		GFX.drawLine(x + 262 * scale, y + -35 * scale, x + 245 * scale, y + -35 * scale, lineWidth, color);
		GFX.drawLine(x + 245 * scale, y + -35 * scale, x + 245 * scale, y + -53 * scale, lineWidth, color);
		GFX.drawLine(x + 245 * scale, y + -53 * scale, x + 262 * scale, y + -53 * scale, lineWidth, color);
		GFX.drawLine(x + 262 * scale, y + -53 * scale, x + 262 * scale, y + -35 * scale, lineWidth, color);
		GFX.drawLine(x + 262 * scale, y + -35 * scale, x + 255 * scale, y + -35 * scale, lineWidth, color);
		GFX.drawLine(x + 255 * scale, y + -35 * scale, x + 255 * scale, y + -19 * scale, lineWidth, color);
		GFX.drawLine(x + 262 * scale, y + 35 * scale, x + 245 * scale, y + 35 * scale, lineWidth, color);
		GFX.drawLine(x + 245 * scale, y + 35 * scale, x + 245 * scale, y + 52 * scale, lineWidth, color);
		GFX.drawLine(x + 245 * scale, y + 52 * scale, x + 262 * scale, y + 52 * scale, lineWidth, color);
		GFX.drawLine(x + 262 * scale, y + 52 * scale, x + 262 * scale, y + 35 * scale, lineWidth, color);
		GFX.drawLine(x + 262 * scale, y + 35 * scale, x + 255 * scale, y + 35 * scale, lineWidth, color);
		GFX.drawLine(x + 255 * scale, y + 35 * scale, x + 255 * scale, y + 18 * scale, lineWidth, color);
	}
}
