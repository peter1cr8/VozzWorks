/*
============================================================================================

                       V o z z W o r k s   C o d e   G e n e r a t o r                      

                                    Copyright(c) 2024 By                                    

                                  V o z z w a r e   L L C.                                  

                            A L L   R I G H T S   R E S E R V E D                           

    Source File Name: Cr8UserAddress.java

    Author:           VozzWorks

    Date Generated:   06-03-2024

    Time Generated:   15:09:51

============================================================================================
*/

package com.vozzware.db.dao.dvo;

import java.io.Serializable;
import java.lang.Cloneable;
import com.vozzware.db.VwDVOBase;
import com.vozzware.util.VwBeanUtils;


public class Cr8UserAddress extends VwDVOBase implements Serializable, Cloneable
{

  private String                 m_strFirstName;                 
  private String                 m_strLastName;                  
  private String                 m_strStreetAddress;             
  private String                 m_strCity;                      
  private String                 m_strPostalCode;                

  /**
   * Renders bean instance property values to a String
   * 
   * @return  A String containing the bean property values
   */
  public String toString()
  {
    return VwBeanUtils.dumpBeanValues( this );
  } // End of toString()



  // *** The following members set or get data from the class members *** 

  /**
   * Sets the firstName property
   */
  public void setFirstName( String strFirstName )
  { 
    testDirty( "firstName", strFirstName );
    m_strFirstName = strFirstName;
  }

  /**
   * Gets firstName property
   * 
   * @return  The firstName property
   */
  public String getFirstName()
  { return m_strFirstName; }

  /**
   * Sets the lastName property
   */
  public void setLastName( String strLastName )
  { 
    testDirty( "lastName", strLastName );
    m_strLastName = strLastName;
  }

  /**
   * Gets lastName property
   * 
   * @return  The lastName property
   */
  public String getLastName()
  { return m_strLastName; }

  /**
   * Sets the streetAddress property
   */
  public void setStreetAddress( String strStreetAddress )
  { 
    testDirty( "streetAddress", strStreetAddress );
    m_strStreetAddress = strStreetAddress;
  }

  /**
   * Gets streetAddress property
   * 
   * @return  The streetAddress property
   */
  public String getStreetAddress()
  { return m_strStreetAddress; }

  /**
   * Sets the city property
   */
  public void setCity( String strCity )
  { 
    testDirty( "city", strCity );
    m_strCity = strCity;
  }

  /**
   * Gets city property
   * 
   * @return  The city property
   */
  public String getCity()
  { return m_strCity; }

  /**
   * Sets the postalCode property
   */
  public void setPostalCode( String strPostalCode )
  { 
    testDirty( "postalCode", strPostalCode );
    m_strPostalCode = strPostalCode;
  }

  /**
   * Gets postalCode property
   * 
   * @return  The postalCode property
   */
  public String getPostalCode()
  { return m_strPostalCode; }

  /**
   * Clones this object
   *
   */
  public Object clone()
  {
    Cr8UserAddress classClone = new Cr8UserAddress();
    
    classClone.m_strFirstName = m_strFirstName;
    classClone.m_strLastName = m_strLastName;
    classClone.m_strStreetAddress = m_strStreetAddress;
    classClone.m_strCity = m_strCity;
    classClone.m_strPostalCode = m_strPostalCode;

    return classClone;
  }



  /**
   * Performs deep equal test on this object
   *
   * @param objTest The object to compare this object to
   *
   * @return if the two objects are equal, false otherwise
   *
   */
  public boolean equals( Object objTest )
  {

    if ( objTest == null )
      return false;

    if ( this.getClass() != objTest.getClass() )
      return false;

    Cr8UserAddress objToTest = (Cr8UserAddress)objTest;

    if ( ! doObjectEqualsTest( m_strFirstName, objToTest.m_strFirstName ) )
      return false; 

    if ( ! doObjectEqualsTest( m_strLastName, objToTest.m_strLastName ) )
      return false; 

    if ( ! doObjectEqualsTest( m_strStreetAddress, objToTest.m_strStreetAddress ) )
      return false; 

    if ( ! doObjectEqualsTest( m_strCity, objToTest.m_strCity ) )
      return false; 

    if ( ! doObjectEqualsTest( m_strPostalCode, objToTest.m_strPostalCode ) )
      return false; 

    return true;
  }



  /**
   * Perform an equals test on an Object
   *
   * @param obj1 first object
   * @param obj2 second object
   *
   * @return true if objects are equal, false otherwise
   *
   */
  private boolean doObjectEqualsTest( Object obj1, Object obj2 )
  {
    if ( obj1 != null )
    {
      if ( obj2 == null )
        return false;
      return obj1.equals( obj2 );
    }
    else
    if ( obj2 != null )
      return false;

    return true;

  }
} // *** End of class Cr8UserAddress{}

// *** End Of Cr8UserAddress.java