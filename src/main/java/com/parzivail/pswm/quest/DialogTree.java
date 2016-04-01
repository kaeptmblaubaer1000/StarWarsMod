package com.parzivail.pswm.quest;

public class DialogTree
{
	public String npcHeader = null;
	public Response response1 = null;
	public Response response2 = null;
	public Response response3 = null;

	public static class Response
	{
		public String text = null;
		public DialogTree npcDialog = null;
	}
}
