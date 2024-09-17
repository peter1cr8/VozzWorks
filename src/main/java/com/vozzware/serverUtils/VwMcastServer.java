/*
  ===========================================================================================

                                 I t c   S e r v e r s


                                  Copyright(c) 2000 by

                   I n t e r n e t  T e c h n o l o g i e s   C o m p a n y

                                 All Rights Reserved


  Source Name:   ItcMcastServer.java


  ============================================================================================
*/

package com.vozzware.serverUtils;

import com.vozzware.util.VwDelimString;
import com.vozzware.util.VwLogger;
import com.vozzware.util.VwResourceMgr;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.net.SocketAddress;

/**
 * This class listens on the multicast port for datagram broadcasts. It's initial primary
 * purpose is to identify this servers host name and port nbr. for other servers
 * or clients that are dynamically searching for active servers on the network.
 */
public class VwMcastServer extends Thread
{
  private VwServerInfo        m_serverInfo;

  private MulticastSocket     m_mcastSocket;    // Multicast Socket

  private DatagramPacket      m_dgData;         // Datagram data packet


  private SocketAddress m_ia;             // Inetaddress class ofr mcast address

  private boolean             m_fQuit = false;  // Thread termination flag

  private int                 m_nMcastPort = VwResourceMgr.getInt( "server.multicast.port", 8888 ); // Port the datagrams are sent to
  private int                 m_nMcastResponsePort = VwResourceMgr.getInt( "server.multicast.response.port", 4001 ); // Port the datagrams are sent to

  private  String             m_strMulticastAddress = VwResourceMgr.getString( "server.multicast.address", "224.0.0.3");

  private VwLogger            m_logger;

  private VwServerNotificationHandler m_notificationHandler;


  /**
   * Constructs this class
   *
   *
   * @exception - throws Exception if the mulicast socket could not be created
   */
  public VwMcastServer( VwServerInfo serverInfo, VwLogger logger, VwServerNotificationHandler notificationHandler ) throws Exception
  {
    m_serverInfo = serverInfo;
    m_notificationHandler = notificationHandler;

    m_mcastSocket = new MulticastSocket( m_nMcastPort );
    SocketAddress group = new InetSocketAddress(m_strMulticastAddress, 40);
    NetworkInterface ni = NetworkInterface.getByName( "etho" );

    m_mcastSocket.joinGroup( group, ni );

    m_dgData = new DatagramPacket( new byte[200], 200 );

    m_logger = logger;

    m_logger.info( this.getClass(), "Launching Multicast Server for: "  + serverInfo.toString() );

    broadcastStartup();

  } // end ItcMcastServer

  public void setMCastPort( int nPort )
  {
    m_nMcastPort = nPort ;
  }
  /**
   * Sends a multicast msg that this server is now on line
   */
  public void broadcastStartup() throws Exception
  {
    DatagramSocket ds = new DatagramSocket();

    String strResponse = "1," + m_serverInfo.toString();

    DatagramPacket dp = new DatagramPacket( strResponse.getBytes(), strResponse.length(),
                                            m_serverInfo.getInetAddress(),
                                            m_nMcastPort );

    //Thread.currentThread().sleep( 100 );

    ds.send( dp );
    dp = null;
    ds.close();

    m_logger.info( this.getClass(),"Broadcasting Server Startup For: "  + m_serverInfo.toString() );

  } // end broadcastStartup()

  /**
   * Sends a multicast msg that this server is now on line
   */
  public void broadcastMsg( String strMsg ) throws Exception
  {
    DatagramSocket ds = new DatagramSocket();

    DatagramPacket dp = new DatagramPacket( strMsg.getBytes(), strMsg.length(),
                                            m_serverInfo.getInetAddress(),
                                            m_nMcastPort );

    //Thread.currentThread().sleep( 100 );

    ds.send( dp );
    dp = null;
    ds.close();


  } // end broadcastStartup()


  /**
   * Sends a multicast msg that this server is now on line
   */
  public void broadcastShutdown() throws Exception
  {
    DatagramSocket ds = new DatagramSocket();

    String strResponse = "0," + m_serverInfo.toString();

    DatagramPacket dp = new DatagramPacket( strResponse.getBytes(), strResponse.length(),
                                            m_serverInfo.getInetAddress(),
                                            m_nMcastPort );

    //Thread.currentThread().sleep( 100 );

    ds.send( dp );
    dp = null;
    ds.close();

    m_logger.info( this.getClass(), "Broadcasting Server Shutdown For: "  + m_serverInfo.toString() );

  } // end broadcastStartup()

  /**
   * Sends a multicast msg that this server is now on line
   */
  public void requestIndentity() throws Exception
  {
    DatagramSocket ds = new DatagramSocket();

    String strResponse = "IDENTITY," + m_serverInfo.toString();

    DatagramPacket dp = new DatagramPacket( strResponse.getBytes(), strResponse.length(),
                                            m_serverInfo.getInetAddress(),
                                            m_nMcastPort );

    //Thread.currentThread().sleep( 100 );

    ds.send( dp );
    dp = null;
    ds.close();

    m_logger.info( this.getClass(),"Broadcasting Server Identity For: "  + m_serverInfo.toString() );

  } // end broadcastStartup()

  /**
   * Closes the socket and thread
   */
  public final void close() throws Exception
  {
    broadcastShutdown();;

    m_fQuit = true;
    m_mcastSocket.close();

  } // end close()


  /**
   * Override of Thread run() method
   */
  public void run()
  {

    m_logger.info( "Starting Listener thread for : " + m_serverInfo.getDnsName() + " -- Thread ID: " + Thread.currentThread().getName());
    while( true )
    {
      try
      {
        m_logger.info( Thread.currentThread().getName() + " is entering receive ");
        m_mcastSocket.receive( m_dgData );
        String str = new String( m_dgData.getData(), 0, m_dgData.getLength() );

        m_logger.info( "Thjread ID: " + Thread.currentThread().getName() + " Got datagram from " + str + " server instance is " + m_serverInfo.getDnsName() );

        VwDelimString dlmsReq = new VwDelimString( ",", str );
        String strReq = dlmsReq.getNext();

        if ( strReq.equalsIgnoreCase( "IDENTITY_REPLY"  ) )
        {
          m_logger.info( "GOT IDENTITY_REPLY from " + str );

        }

        if ( strReq.equalsIgnoreCase( "IDENTITY"  ) )
        {
          m_logger.debug( this.getClass(), "Got Server IDENTITY Request, Sending ServerInfor: " + m_serverInfo.toString() );
          DatagramSocket ds = new DatagramSocket();

          String strResponse = "IDENTITY_REPLY," + m_serverInfo.toString();

          DatagramPacket dp = new DatagramPacket( strResponse.getBytes(), strResponse.length(),
                                                  m_serverInfo.getInetAddress(),
                                                  m_nMcastPort );


          ds.send( dp );

          Thread.currentThread().sleep( 500 );

          dp = null;
          ds.close();
        }
        else
        if ( strReq.equals( "0") || strReq.equals( "1") )
        {
          boolean bOnline = strReq.equals( "1")?true:false;

          if ( m_notificationHandler != null )
          {
            String[] astrServerInfoPieces = str.split( ",");
            m_notificationHandler.serverChange( bOnline, new VwServerInfo( astrServerInfoPieces[1], astrServerInfoPieces[4] , Integer.valueOf( astrServerInfoPieces[3] )));
          }
        }

        dlmsReq = null;

      } // end while()

      catch( Exception iox )
      {
        System.out.println( iox );
        if ( m_fQuit )
          break;
      }

    } // end while()

    try
    {
      System.out.println( "LEAVING group from server: " + m_serverInfo.getDnsName() );
      m_mcastSocket.leaveGroup( m_ia, null );
    }
    catch( Exception e )
    {}

  } // end run

} // end class ItcMcastServer

// *** End ItcMcastServer.java ***