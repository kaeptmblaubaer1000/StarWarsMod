/*    */package org.eclipse.jdt.internal.jarinjarloader;

/*    */
/*    */import java.io.IOException;
/*    */
import java.io.InputStream;
/*    */
import java.io.PrintStream;
/*    */
import java.lang.reflect.InvocationTargetException;
/*    */
import java.lang.reflect.Method;
/*    */
import java.net.URL;
/*    */
import java.net.URLClassLoader;
/*    */
import java.util.ArrayList;
/*    */
import java.util.Enumeration;
/*    */
import java.util.List;
/*    */
import java.util.jar.Attributes;
/*    */
import java.util.jar.Manifest;

/*    */
/*    */public class JarRsrcLoader
/*    */
{
	/*    */public static void main(String[] args) throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchMethodException, IOException
	/*    */
	{
		/* 20 */ManifestInfo mi = getManifestInfo();
		/* 21 */ClassLoader cl = Thread.currentThread().getContextClassLoader();
		/* 22 */URL.setURLStreamHandlerFactory(new RsrcURLStreamHandlerFactory(cl));
		/* 23 */URL[] rsrcUrls = new URL[mi.rsrcClassPath.length];
		/* 24 */for (int i = 0; i < mi.rsrcClassPath.length; i++)
		{
			/* 25 */String rsrcPath = mi.rsrcClassPath[i];
			/* 26 */if (rsrcPath.endsWith("/"))
			{
				/* 27 */rsrcUrls[i] = new URL("rsrc:" + rsrcPath);
				/*    */}
			else
				/* 29 */rsrcUrls[i] = new URL("jar:rsrc:" + rsrcPath + "!/");
			/*    */}
		/* 31 */ClassLoader jceClassLoader = new URLClassLoader(rsrcUrls, null);
		/* 32 */Thread.currentThread().setContextClassLoader(jceClassLoader);
		/* 33 */Class<?> c = Class.forName(mi.rsrcMainClass, true, jceClassLoader);
		/* 34 */Method main = c.getMethod("main", new Class[] { args.getClass() });
		/* 35 */main.invoke(null, new Object[] { args });
		/*    */}

	/*    */
	/*    */private static ManifestInfo getManifestInfo() throws IOException
	/*    */
	{
		/* 40 */Enumeration<?> resEnum = Thread.currentThread().getContextClassLoader().getResources("META-INF/MANIFEST.MF");
		/* 41 */while (resEnum.hasMoreElements())
		{
			/*    */try
			{
				/* 43 */URL url = (URL)resEnum.nextElement();
				/* 44 */InputStream is = url.openStream();
				/* 45 */if (is != null)
				{
					/* 46 */ManifestInfo result = new ManifestInfo(null);
					/* 47 */Manifest manifest = new Manifest(is);
					/* 48 */Attributes mainAttribs = manifest.getMainAttributes();
					/* 49 */result.rsrcMainClass = mainAttribs.getValue("Rsrc-Main-Class");
					/* 50 */String rsrcCP = mainAttribs.getValue("Rsrc-Class-Path");
					/* 51 */if (rsrcCP == null)
					/* 52 */rsrcCP = "";
					/* 53 */result.rsrcClassPath = splitSpaces(rsrcCP);
					/* 54 */if ((result.rsrcMainClass != null) && (!result.rsrcMainClass.trim().equals("")))
					{
						/* 55 */return result;
						/*    */}
					/*    */}
				/*    */}
			/*    */catch (Exception localException)
			{
			}
			/*    */}
		/*    */
		/* 62 */System.err.println("Missing attributes for JarRsrcLoader in Manifest (Rsrc-Main-Class, Rsrc-Class-Path)");
		/* 63 */return null;
		/*    */}

	/*    */
	/*    */private static String[] splitSpaces(String line)
	/*    */
	{
		/* 68 */if (line == null)
		/* 69 */return null;
		/* 70 */List<String> result = new ArrayList();
		/* 71 */int firstPos = 0;
		/* 72 */while (firstPos < line.length())
		{
			/* 73 */int lastPos = line.indexOf(' ', firstPos);
			/* 74 */if (lastPos == -1)
			/* 75 */lastPos = line.length();
			/* 76 */if (lastPos > firstPos)
			{
				/* 77 */result.add(line.substring(firstPos, lastPos));
				/*    */}
			/* 79 */firstPos = lastPos + 1;
			/*    */}
		/* 81 */return (String[])result.toArray(new String[result.size()]);
		/*    */}

	/*    */
	/*    */
	/*    */private static class ManifestInfo
	/*    */
	{
		/*    */String rsrcMainClass;
		/*    */
		/*    */String[] rsrcClassPath;

		/*    */
		/*    */private ManifestInfo()
		{
		}

		/*    */
		/*    */ManifestInfo(ManifestInfo paramManifestInfo)
		/*    */
		{
			/* 95 */this();
			/*    */}
		/*    */
	}
	/*    */
}

/*
 * Location:
 * F:\Forge\schematicconverter\SchematicConverter.jar!\org\eclipse\jdt\
 * internal\jarinjarloader\JarRsrcLoader.class Java compiler version: 5 (49.0)
 * JD-Core Version: 0.7.1
 */