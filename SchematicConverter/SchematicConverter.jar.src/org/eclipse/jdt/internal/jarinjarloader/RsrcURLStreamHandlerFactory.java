/*    */package org.eclipse.jdt.internal.jarinjarloader;

/*    */
/*    */import java.net.URLStreamHandler;
/*    */
import java.net.URLStreamHandlerFactory;

/*    */
/*    */public class RsrcURLStreamHandlerFactory
/*    */implements URLStreamHandlerFactory
/*    */
{
	/*    */private ClassLoader classLoader;
	/*    */private URLStreamHandlerFactory chainFac;

	/*    */
	/*    */public RsrcURLStreamHandlerFactory(ClassLoader cl)
	/*    */
	{
		/* 14 */this.classLoader = cl;
		/*    */}

	/*    */
	/*    */public URLStreamHandler createURLStreamHandler(String protocol)
	{
		/* 18 */if ("rsrc".equals(protocol))
		/* 19 */return new RsrcURLStreamHandler(this.classLoader);
		/* 20 */if (this.chainFac != null)
		/* 21 */return this.chainFac.createURLStreamHandler(protocol);
		/* 22 */return null;
		/*    */}

	/*    */
	/*    */public void setURLStreamHandlerFactory(URLStreamHandlerFactory fac)
	/*    */
	{
		/* 27 */this.chainFac = fac;
		/*    */}
	/*    */
}

/*
 * Location:
 * F:\Forge\schematicconverter\SchematicConverter.jar!\org\eclipse\jdt\
 * internal\jarinjarloader\RsrcURLStreamHandlerFactory.class Java compiler
 * version: 5 (49.0) JD-Core Version: 0.7.1
 */