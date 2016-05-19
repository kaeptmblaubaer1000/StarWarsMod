package com.parzivail.pswm.quest;

/**
 * Created by Colby on 5/5/2016.
 */
public class QuestNpcUtils
{
	public static String makeNpcId(String quest, String side, String skin)
	{
		return quest + ":" + side + ":" + skin;
	}

	public static String getNpcQuest(String npcId)
	{
		String[] ids = npcId.split(":");
		return (ids.length == 3) ? ids[0] : "";
	}

	public static String getNpcSide(String npcId)
	{
		String[] ids = npcId.split(":");
		return (ids.length == 3) ? ids[1] : "";
	}

	public static String getNpcSkin(String npcId)
	{
		String[] ids = npcId.split(":");
		return (ids.length == 3) ? ids[2] : "";
	}
}
