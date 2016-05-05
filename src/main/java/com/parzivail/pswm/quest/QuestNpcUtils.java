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
}
