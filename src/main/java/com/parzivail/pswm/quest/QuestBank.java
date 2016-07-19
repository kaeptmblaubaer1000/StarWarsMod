package com.parzivail.pswm.quest;

import com.parzivail.pswm.quest.imperial.*;
import com.parzivail.pswm.quest.jedi.Jedi1_1;
import com.parzivail.pswm.quest.jedi.Jedi1_2;
import com.parzivail.pswm.quest.jedi.Jedi2;
import com.parzivail.pswm.quest.jedi.Jedi3;
import com.parzivail.pswm.quest.rebel.*;
import com.parzivail.pswm.quest.sith.Sith1;
import com.parzivail.pswm.quest.sith.Sith2;
import com.parzivail.pswm.quest.sith.Sith3;
import com.parzivail.pswm.quest.sith.Sith3_PostSaber;

public class QuestBank
{
	public static Quest questNotAvailable = new QuestNotAvailable();

	public static Quest rebel0 = new Rebel0();
	public static Quest rebel1 = new Rebel1();
	public static Quest rebel2 = new Rebel2();
	public static Quest rebel3 = new Rebel3();
	public static Quest rebel4 = new Rebel4();
	public static Quest rebel5 = new Rebel5();
	public static Quest rebel6 = new Rebel6();
	public static Quest rebel6_PostEndor = new Rebel6_PostEndor();
	public static Quest rebel7 = new Rebel7();
	public static Quest rebel8 = new Rebel8();
	public static Quest rebel8_PostArmor = new Rebel8_PostArmor();
	public static Quest rebel8_Yavin = new Rebel8_Yavin();
	public static Quest rebel9 = new Rebel9();
	public static Quest rebel10 = new Rebel10();
	public static Quest rebel10_Over = new Rebel10_Over();

	public static Quest imperial0 = new Imperial0();
	public static Quest imperial1 = new Imperial1();
	public static Quest imperial2 = new Imperial2();
	public static Quest imperial3_2 = new Imperial3_2();
	public static Quest imperial3_1 = new Imperial3_1();
	public static Quest imperial4_1 = new Imperial4_1();
	public static Quest imperial4_2 = new Imperial4_2();
	public static Quest imperial4_3 = new Imperial4_3();
	public static Quest imperial5 = new Imperial5();
	public static Quest imperial6_1 = new Imperial6_1();
	public static Quest imperial6_2 = new Imperial6_2();
	public static Quest imperial6_3 = new Imperial6_3();
	public static Quest imperial7 = new Imperial7();
	public static Quest imperial8_1 = new Imperial8_1();
	public static Quest imperial8_2 = new Imperial8_2();
	public static Quest imperial8_3 = new Imperial8_3();
	public static Quest imperial9 = new Imperial9();
	public static Quest imperial10_1 = new Imperial10_1();
	public static Quest imperial10_2 = new Imperial10_2();

	public static Quest jedi1_1 = new Jedi1_1();
	public static Quest jedi1_2 = new Jedi1_2();
	public static Quest jedi2 = new Jedi2();
	public static Quest jedi3 = new Jedi3();

	public static Quest sith1 = new Sith1();
	public static Quest sith2 = new Sith2();
	public static Quest sith3 = new Sith3();
	public static Quest sith3_PostSaber = new Sith3_PostSaber();

	public static Quest[] quests = { rebel0, rebel1, rebel2, rebel3, rebel4, rebel5, rebel6, rebel6_PostEndor, rebel7, rebel8, rebel8_PostArmor, rebel8_Yavin, rebel9, rebel10, rebel10_Over, imperial0, imperial1, imperial2, imperial3_2, imperial3_1, imperial4_1, imperial4_2, imperial4_3, imperial5, imperial6_1, imperial6_2, imperial6_3, imperial7, imperial8_1, imperial8_2, imperial8_3, imperial9, imperial10_1, imperial10_2, jedi1_1, jedi1_2, jedi2, jedi3, sith1, sith2, sith3, sith3_PostSaber };

	public static Quest getQuestByName(String name)
	{
		for (Quest quest : quests)
			if (quest.getID().toLowerCase().replaceAll("[^a-z]", "").equals(name))
				return quest;
		return null;
	}
}
