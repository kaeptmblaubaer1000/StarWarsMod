package com.parzivail.pswm.quest;

import com.parzivail.pswm.quest.rebel.Quest0Welcome;
import com.parzivail.pswm.quest.rebel.Quest1Enlisting;
import com.parzivail.pswm.quest.rebel.Quest2TargetPractice;
import com.parzivail.pswm.quest.rebel.Quest3TicketToTheGalaxy;
import com.parzivail.pswm.quest.rebel.Quest4Shhh;
import com.parzivail.pswm.quest.rebel.Quest5BeggarsCanyon;
import com.parzivail.pswm.quest.rebel.Quest6ThatsNoMoon;

public class QuestBank
{
	public static final IQuest quest0Welcome = new Quest0Welcome();
	public static final IQuest quest1Enlisting = new Quest1Enlisting();
	public static final IQuest quest2TargetPractice = new Quest2TargetPractice();
	public static final IQuest quest3TicketToTheGalaxy = new Quest3TicketToTheGalaxy();
	public static final IQuest quest4Shhh = new Quest4Shhh();
	public static final IQuest quest5BeggarsCanyon = new Quest5BeggarsCanyon();
	public static final IQuest quest6ThatsNoMoon = new Quest6ThatsNoMoon();
}
