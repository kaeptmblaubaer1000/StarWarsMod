/*    */package org.jnbt;

/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */public final class ShortTag
/*    */extends Tag
/*    */
{
	/*    */private final short value;

	/*    */
	/*    */
	/*    */
	/*    */
	/*    */
	/*    */
	/*    */
	/*    */
	/*    */
	/*    */
	/*    */
	/*    */
	/*    */
	/*    */
	/*    */
	/*    */
	/*    */
	/*    */
	/*    */
	/*    */
	/*    */
	/*    */
	/*    */
	/*    */public ShortTag(String name, short value)
	/*    */
	{
		/* 54 */super(name);
		/* 55 */this.value = value;
		/*    */}

	/*    */
	/*    */public Short getValue()
	/*    */
	{
		/* 60 */return Short.valueOf(this.value);
		/*    */}

	/*    */
	/*    */public String toString()
	/*    */
	{
		/* 65 */String name = getName();
		/* 66 */String append = "";
		/* 67 */if ((name != null) && (!name.equals("")))
		{
			/* 68 */append = "(\"" + getName() + "\")";
			/*    */}
		/* 70 */return "TAG_Short" + append + ": " + this.value;
		/*    */}
	/*    */
}

/*
 * Location:
 * F:\Forge\schematicconverter\SchematicConverter.jar!\org\jnbt\ShortTag.class
 * Java compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */