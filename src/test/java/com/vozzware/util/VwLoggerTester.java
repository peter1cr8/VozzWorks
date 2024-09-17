package com.vozzware.util;

import junit.framework.Assert;
import org.apache.logging.log4j.Level;
import org.junit.Test;


/*
============================================================================================

    Source File Name: 

    Author:           petervosburgh
    
    Date Generated:   5/15/15

    Time Generated:   6:45 AM

============================================================================================
*/
public class VwLoggerTester
{
  @Test
  public void testRollingLogs() throws Exception
  {

    System.out.println( "in testRollingLogs");
    VwLogger logger = VwLogger.getInstance( "junitDb.properties" );

    Level level = logger.getLevel();
    logger.setLevel( Level.INFO );

    logger.error( this.getClass(), "FUCKING Error" );
    logger.info( this.getClass(), "My INFO Test Msg");
    logger.info( "First Test ");
    logger.debug( "DEBUG First Test, This should not show in Info level" );

    logger.setLevel( Level.DEBUG );

    level = logger.getLevel();

    //logger.clearLog();

    logger.debug( "DEBUG First Test ");

    for ( int x = 0; x < 5; x++ )
    {
        logger.debug( this.getClass(), "User Id:  100  -- This is test line: " + x );
    }

  }


  @Test
  public void testError() throws Exception
  {

    VwLogger test1 = VwLogger.getInstance( "./src/test_en.properties");
    test1.info( "Test one");

    VwResourceMgr.loadBundle( "test", true );

    System.out.println( "3sMapping: " + VwResourceMgr.getString( "3DMapping") );
    
    VwLogger logger1 = null;

    String strTest = null;

    try
    {
      logger1 = VwLogger.getInstance( "junit.properties" );
      logger1.debug( getClass(), "MUTHA FUKKA");
      strTest.length();

    }
    catch( Exception ex )
    {
      logger1.fatal( getClass(), ex.toString(), ex );

    }
  }

}
