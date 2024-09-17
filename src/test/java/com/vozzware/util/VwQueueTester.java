package com.vozzware.util;

import org.junit.Test;

import java.util.Queue;

/*
============================================================================================

    Source File Name: Transaction.java

    Author:           petervosburgh
    
    Date Generated:   8/20/22

    Time Generated:   2:53 PM

============================================================================================
*/
public class VwQueueTester
{
  class MyThread extends Thread
  {
    VwQueue m_queue;

    public MyThread()
    {
      m_queue = new VwQueue();

    }

    public void close()
    {
      m_queue.close();

    }
    public void run()
    {
      try
      {
        m_queue.getNext( 0 );

        System.out.println( "Thread Closed" );
      }
      catch( Exception ex )
      {
        ex.printStackTrace();
      }
    }
  }
  @Test
  public void TestBlockingQueue() throws Exception
  {

    MyThread tester = new MyThread();

    tester.start();

    Thread.sleep( 3000);

    tester.close();

    tester.join();

    System.out.println( "Tester Thread closed" );

  }

}
