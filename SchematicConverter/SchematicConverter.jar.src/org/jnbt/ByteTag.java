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
/*    */public final class ByteTag
/*    */extends Tag
/*    */
{
	/*    */private final byte value;

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
	/*    */public ByteTag(String name, byte value)
	/*    */
	{
		/* 54 */super(name);
		/* 55 */this.value = value;
		/*    */}

	/*    */
	/*    */public Byte getValue()
	/*    */
	{
		/* 60 */return Byte.valueOf(this.value);
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
		/* 70 */return "TAG_Byte" + append + ": " + this.value;
		/*    */}
	/*    */
}

/*
 * Location:
 * F:\Forge\schematicconverter\SchematicConverter.jar!\org\jnbt\ByteTag.class
 * Java compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */