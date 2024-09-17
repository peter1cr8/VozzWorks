package vozzware.serverUtils;

import com.vozzware.serverUtils.VwMcastServer;
import com.vozzware.serverUtils.VwServerInfo;
import com.vozzware.serverUtils.VwServerNotificationHandler;
import com.vozzware.util.VwLogger;
import com.vozzware.util.VwResourceMgr;
import org.junit.Test;

/*
============================================================================================

    Source File Name: Transaction.java

    Author:           petervosburgh
    
    Date Generated:   4/6/22

    Time Generated:   11:18 AM

============================================================================================
*/
public class VwServerUtilsTester
{

  @Test
  public void testMcastServerClient() throws Exception
  {
    VwLogger logger = VwLogger.getInstance( "junitDb.properties");

    VwServerNotificationHandler notificationHandler = new VwServerNotificationHandler()
    {
      @Override
      public void serverChange( boolean bOnline, VwServerInfo serverInfo )
      {
        String strAction;

        if ( bOnline )
        {
          strAction = "Online";
        }
        else
        {
          strAction = "OffLine";
        }

        logger.info( "Server: " + serverInfo.getDnsName() + " is comming " + strAction );
      }
    };

    VwServerInfo serverInfo2 = new VwServerInfo( "local1", "Server 2", 8081 );

    VwMcastServer mcastServer2 = new VwMcastServer( serverInfo2, logger, notificationHandler);
    mcastServer2.setName( "Server 2" );
    mcastServer2.start();

    Thread.sleep( 20000 );

    mcastServer2.broadcastMsg( "Hello from Server 2");

    Thread.sleep( 15000 );
    return;
  }

  @Test
  public void testMcastServerServer() throws Exception
  {
    VwLogger logger = VwLogger.getInstance( "junitDb.properties");

    VwServerNotificationHandler notificationHandler = new VwServerNotificationHandler()
    {
      @Override
      public void serverChange( boolean bOnline, VwServerInfo serverInfo )
      {
        String strAction;

        if ( bOnline )
        {
          strAction = "Online";
        }
        else
        {
          strAction = "OffLine";
        }

        logger.info( "Server: " + serverInfo.getDnsName() + " is comming " + strAction );
      }
    };

    VwServerInfo serverInfo1 = new VwServerInfo( "local", "Server 1", 8080 );

    VwMcastServer mcastServer1 = new VwMcastServer( serverInfo1, logger, notificationHandler );

    mcastServer1.setName( "Server 1" );

    mcastServer1.start();

    //Thread.sleep( 10000 );

    //mcastServer1.requestIndentity();

    Thread.sleep( 30000 );
    //mcastServer1.broadcastShutdown();


  }
}
