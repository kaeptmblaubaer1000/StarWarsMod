/*    */package org.eclipse.jdt.internal.jarinjarloader;

/*    */
/*    */import java.io.IOException;
/*    */
import java.io.InputStream;
/*    */
import java.net.MalformedURLException;
/*    */
import java.net.URL;
/*    */
import java.net.URLConnection;
/*    */
import java.net.URLDecoder;

/*    */
/*    */public class RsrcURLConnection extends URLConnection
/*    */
{
	/*    */private ClassLoader classLoader;

	/*    */
	/*    */public RsrcURLConnection(URL url, ClassLoader classLoader)
	/*    */
	{
		/* 16 */super(url);
		/* 17 */this.classLoader = classLoader;
		/*    */}

	/*    */
	/*    */public void connect() throws IOException
	/*    */
	{
	}

	/*    */
	/*    */public InputStream getInputStream() throws IOException
	{
		/* 24 */String file = URLDecoder.decode(this.url.getFile(), "UTF-8");
		/* 25 */InputStream result = this.classLoader.getResourceAsStream(file);
		/* 26 */if (result == null)
		{
			/* 27 */throw new MalformedURLException("Could not open InputStream for URL '" + this.url + "'");
			/*    */}
		/* 29 */return result;
		/*    */}
	/*    */
}

/*
 * Location:
 * F:\Forge\schematicconverter\SchematicConverter.jar!\org\eclipse\jdt\
 * internal\jarinjarloader\RsrcURLConnection.class Java compiler version: 5
 * (49.0) JD-Core Version: 0.7.1
 */