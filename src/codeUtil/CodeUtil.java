/*
 * Copyright SocialTwist Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of SocialTwist.
 * You shall not disclose such confidential information and shall use it only
 * in accordance with the terms of the source code license agreement you
 * entered into with SocialTwist.
 *
 */
package codeUtil;

//import org.apache.log4j.Logger;
/**
 * @author <a href="mailto:ayush@socialtwist.com">Ayush Kulshrestha</a>
 * @since 28-Aug-2014

public class CodeUtil
{
	//private static final Logger logger = Logger.getLogger(CodeUtil.class);

	//public static void close( Closeable c, Logger log )
	{

		if( c != null )
		{
			try
			{
				c.close();
			}
			catch( IOException e )
			{
				log.error("Failed to close the stream", e);
			}
		}
	}

	public static void close( Closeable c )
	{
		close(c, logger);
	}
}
*/