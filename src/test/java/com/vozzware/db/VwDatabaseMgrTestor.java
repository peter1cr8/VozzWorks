package com.vozzware.db;

import com.vozzware.util.VwLogger;
import com.vozzware.util.VwPropertiesProcessor;
import org.junit.Test;

/*
============================================================================================

    Source File Name: 

    Author:           petervosburgh
    
    Date Generated:   2/16/16

    Time Generated:   7:29 AM

============================================================================================
*/
public class VwDatabaseMgrTestor
{


  @Test
  public void testDbMgrOpenClose() throws Exception
  {
    Class clsDocFinder = Class.forName( "com.vozzware.util.VwDocFinder" );

    String strName = clsDocFinder.getName();

    VwPropertiesProcessor dbProps = new VwPropertiesProcessor();
    dbProps.putBoolean( "useConnPool", false );
    VwDbMgr dbMgr = new VwDbMgr( "POSTGRES", "LOCAL", VwLogger.getInstance(), dbProps );

    VwDatabase db = dbMgr.login( "cr8web", "2cr8Web" );


    dbMgr.close();

  }

  @Test
  public void testDao()
  {
    try
    {
      VwLogger logger = VwLogger.getInstance();

     }
    catch( Exception ex )
    {
      ex.printStackTrace();
    }

  }
}
