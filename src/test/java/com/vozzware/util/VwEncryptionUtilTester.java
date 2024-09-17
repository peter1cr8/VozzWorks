package com.vozzware.util;

import com.vozzware.util.VwEncryptionUtil;
import org.jcodec.common.Assert;
import org.junit.Test;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.io.File;

/*
============================================================================================

    Source File Name: 

    Author:           petervosburgh
    
    Date Generated:   4/9/16

    Time Generated:   9:56 AM

============================================================================================
*/
public class VwEncryptionUtilTester
{

  @Test
  public void Aes256StringEncryption() throws Exception
  {
    String strDataToEncrypt = "LetMeIn1!";

    IvParameterSpec iv4 = VwEncryptionUtil.genIv4();
    SecretKey key = VwEncryptionUtil.genAes256SecretKey();

    String strEncrypted = VwEncryptionUtil.encryptAes256( key, iv4, strDataToEncrypt );

    String strDeCrypted = VwEncryptionUtil.decryptAes256( key, iv4, strEncrypted );

    Assert.assertTrue( strDataToEncrypt.equals( strDeCrypted ) );

  } // end Aes256StringEncryption()

  @Test
  public void Aes256FileEncryption() throws Exception
  {
    File fileDir = new File( "");
    String strCurDir = fileDir.getAbsolutePath();

    File fileToEncrypt = new File( strCurDir + "/testFiles/mypiano.jpg");

    if ( !fileToEncrypt.exists() )
    {
      throw new Exception( "File: " + fileToEncrypt.getAbsolutePath() + " does not exist");
    }

    File fileEncrypted = new File( strCurDir + "/testFiles/mypiano.enc");

    IvParameterSpec iv4 = VwEncryptionUtil.genIv4();
    SecretKey key = VwEncryptionUtil.genAes256SecretKey();

    VwEncryptionUtil.encryptAes256( key, iv4, fileToEncrypt, fileEncrypted );

    File fileToDecrypt = new File( strCurDir + "/testFiles/mypiano.enc" );
    File fileToDecrypted = new File( strCurDir + "/testFiles/mypianoDecrypted.jpg" );

    VwEncryptionUtil.decryptAes256( key, iv4, fileToDecrypt, fileToDecrypted );

    // Decrypt to another file

  } // end Aes256StringEncryption()

  @Test
  public void testStringEncrypt() throws Exception
  {
    String strEnCrypt = "DAD5CCACKFV2cmRlZmluZWQ=f602pc3RpbmdTa2e5ffZ2V0VXNlckxdad3VsP2xpZD11b4918MDMwMDAwMGIwMTAwMDAwYjAwMDAwMDBiMDIwMDAwMGI=fc04c6af9b0bf0adc56e2e5d8b8b195d";

    String strDeCrypt = VwEncryptionUtil.deCrypt( strEnCrypt );

    System.out.printf( strDeCrypt );
  }

  @Test
  public void testArgon2()
  {
    String strArgon2Digest = VwEncryptionUtil.genArgon2Digest( "Letmein1!" );

    boolean bMatch = VwEncryptionUtil.validateArgon2Digest( "Letmein1!", strArgon2Digest   );

    String strArgon2Digest2 = VwEncryptionUtil.genArgon2Digest( "Letmein2!" );

    bMatch = VwEncryptionUtil.validateArgon2Digest( "Letmenin2!", strArgon2Digest );

  }
}
