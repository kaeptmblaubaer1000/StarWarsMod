/*    */package org.eclipse.jdt.internal.jarinjarloader;

/*    */
/*    */import java.io.IOException;
/*    */
import java.net.URL;
/*    */
import java.net.URLConnection;
/*    */
import java.net.URLStreamHandler;

/*    */
/*    */public class RsrcURLStreamHandler extends URLStreamHandler
/*    */
{
	/*    */private ClassLoader classLoader;

	/*    */
	/*    */public RsrcURLStreamHandler(ClassLoader classLoader)
	/*    */
	{
		/* 14 */this.classLoader = classLoader;
		/*    */}

	/*    */
	/*    */protected URLConnection openConnection(URL u) throws IOException
	{
		/* 18 */return new RsrcURLConnection(u, this.classLoader);
		/*    */}

	/*    */
	/*    */protected void parseURL(URL url, String spec, int start, int limit)
	{
		/*    */String file;
		/* 24 */if (spec.startsWith("rsrc:"))
		{
			/* 25 */file = spec.substring(5);
			/*    */}
		/*    */else
		{
			/* 29 */if (url.getFile().equals("./"))
			{
				/* 30 */file = spec;
				/*    */}
			/*    */else
			{
				/* 34 */if (url.getFile().endsWith("/"))
				{
					/* 35 */file = url.getFile() + spec;
					/*    */}
				else
					/* 37 */file = spec;
				/*    */}
			/*    */}
		/* 40 */setURL(url, "rsrc", "", -1, null, null, file, null, null);
		/*    */}
	/*    */
}

/*
 * Location:
 * F:\Forge\schematicconverter\SchematicConverter.jar!\org\eclipse\jdt\
 * internal\jarinjarloader\RsrcURLStreamHandler.class Java compiler version: 5
 * (49.0) JD-Core Version: 0.7.1
 */