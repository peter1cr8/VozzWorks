package com.vozzware.util;

import org.jcodec.common.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;

/*
============================================================================================

    Source File Name: Transaction.java

    Author:           petervosburgh
    
    Date Generated:   4/10/24

    Time Generated:   1:22 PM

============================================================================================
*/
public class VwFileUtilTester
{
  @Test
  public void testDeleteFullPath() throws Exception
  {
    File filePath = new File( "/tmp/junit1/files");
    filePath.mkdirs();

    File fileTest = new File("/tmp/junit1/files/test.txt" );
    FileOutputStream fos = new FileOutputStream( fileTest );

    fos.write( "Testing".getBytes());
    fos.close();

    VwFileUtil.deleteFilePath( "/tmp/junit1" );

    Assert.assertTrue( !filePath.exists() );

  }
}
