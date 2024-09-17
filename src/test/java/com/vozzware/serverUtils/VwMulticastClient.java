package vozzware.serverUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.net.SocketAddress;
import java.nio.charset.StandardCharsets;

import static java.lang.System.exit;

/*
============================================================================================

    Source File Name: Transaction.java

    Author:           petervosburgh
    
    Date Generated:   4/7/22

    Time Generated:   10:07 AM

============================================================================================
*/
public class VwMulticastClient
{
  private String m_strId;

  private BufferedReader m_br = new BufferedReader( new InputStreamReader( System.in ) );
  private MulticastSocket m_mcastSocket;
  private SocketAddress m_mcastGroup;
  private int m_nPort;
  private String m_strMulticastHost;
  NetworkInterface m_ni;

  public VwMulticastClient( String strId, String strMulticastHost, int nPort)
  {
    m_strId  = strId;

    m_strMulticastHost = strMulticastHost;
    m_nPort = nPort;

    System.out.println("Starting Chat for id: " + strId + ", Multicast Addtress: " + strMulticastHost + " on port : " + nPort );
    
    setupMulticastSocket();

    sendMsg();
  }

  private void setupMulticastSocket()
  {
    try
    {

      m_mcastSocket = new MulticastSocket( m_nPort );
      m_mcastGroup = new InetSocketAddress( m_strMulticastHost, m_nPort );

      m_ni = NetworkInterface.getByName( "etho" );
      m_mcastSocket.joinGroup( m_mcastGroup, m_ni );

      ReceiveMsgThread receiveMsgThread = new ReceiveMsgThread( m_mcastSocket, m_mcastGroup, m_nPort );

      receiveMsgThread.start();
      
    }
    catch( Exception ex )
    {
      ex.printStackTrace();
      exit( 1 );
    }
  }
  private void sendMsg()
  {
    try
    {
      while ( true )
      {
        System.out.print( "\nEnter message to send:" );
 
        String strMsg = getInput();

        byte[] abBuffer = strMsg.getBytes( StandardCharsets.UTF_8 );
        DatagramPacket datagram = new
          DatagramPacket( abBuffer, abBuffer.length, m_mcastGroup );

        m_mcastSocket.send( datagram );

        if ( strMsg.equals( "bye" ) )
        {
          break;
        }

      } // end while()

      exit( 0 );
    } // end try{}
    catch( Exception ex )
    {
      ex.printStackTrace();
    }
  }
  private String getInput() throws Exception
  {

    return m_strId + ":" + m_br.readLine();

  }

  private class ReceiveMsgThread extends Thread
  {
    MulticastSocket m_mcastSocket;
    SocketAddress m_mcastGroup;
    int m_nPort;

    ReceiveMsgThread( MulticastSocket mcastSocket, SocketAddress mcastGroup, int nPort )
    {
      m_mcastSocket = mcastSocket;
      m_mcastGroup = mcastGroup;
      m_nPort = nPort;

    }

    public void run()
    {
      try
      {
        while ( true )
        {
          byte[] buffer = new byte[1024];
          DatagramPacket datagram = new DatagramPacket(buffer,buffer.length,m_mcastGroup );

          m_mcastSocket.receive( datagram );

          String strMsg = new String( buffer, 0, datagram.getLength(), "UTF-8" );

          String[] aMsgPieces = strMsg.split( ":" );

          strMsg = aMsgPieces[ 1 ];


          if ( strMsg.equals( "bye" ))
          {
            break;
          }

          // Dont print out messages from me

          if ( aMsgPieces[0].equals( m_strId ) )
          {
            continue;
          }

          if ( strMsg.equals( "IDENTITY"))
          {
            byte[] abBuffer = (m_strId + ":" + m_strId).getBytes();
            DatagramPacket datagram1 = new
              DatagramPacket( abBuffer, abBuffer.length, m_mcastGroup );

            m_mcastSocket.send( datagram1 );

            continue;

          }

          System.out.println( "Got Msg: " + m_strId + ":" + strMsg );
        }

        leave();
         exit( 0);
      }
      catch ( Exception ex )
      {
        leave();
        exit( 0 );
      }
    }


    private void leave()
    {
      try
      {
        m_mcastSocket.leaveGroup( m_mcastGroup, NetworkInterface.getByName( "etho" ) );
        m_mcastSocket.close();
      }
      catch( Exception ex )
      {
        ex.printStackTrace();
      }
    }
  } // end class ReceiveMsgThread

  public static void main( String[] astrArgs )
  {
    try
    {

      if ( astrArgs.length != 3 )
      {
        System.out.println( "Three args are required: Unique id (String), Multicast host address(String) and port number(int)");
        exit( 1 );
      }

      new VwMulticastClient( astrArgs[ 0 ],astrArgs[ 1 ], Integer.valueOf( astrArgs[2] ));

    }
    catch( Exception ex )
    {
      ex.printStackTrace();
    }

  }
 
}
