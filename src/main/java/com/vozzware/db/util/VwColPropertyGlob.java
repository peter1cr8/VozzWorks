/*
============================================================================================

                       V o z z W o r k s   C o d e   G e n e r a t o r                      

                               2009 by V o z z W a r e   L L C                              

    Source File Name: VwColPropertyGlob.java

    Author:           

    Date Generated:   06-03-2024

    Time Generated:   15:06:31

============================================================================================
*/

package com.vozzware.db.util;

import java.io.Serializable;
import java.lang.Cloneable;
import com.vozzware.db.VwDVOBase;
import com.vozzware.util.VwBeanUtils;


public class VwColPropertyGlob extends VwDVOBase implements Serializable, Cloneable
{

  private String                 m_strFrom;                      
  private String                 m_strTo;                        

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
   * Sets the from property
   */
  public void setFrom( String strFrom )
  { 
    testDirty( "from", strFrom );
    m_strFrom = strFrom;
  }

  /**
   * Gets from property
   * 
   * @return  The from property
   */
  public String getFrom()
  { return m_strFrom; }

  /**
   * Sets the to property
   */
  public void setTo( String strTo )
  { 
    testDirty( "to", strTo );
    m_strTo = strTo;
  }

  /**
   * Gets to property
   * 
   * @return  The to property
   */
  public String getTo()
  { return m_strTo; }

  /**
   * Clones this object
   *
   */
  public Object clone()
  {
    VwColPropertyGlob classClone = new VwColPropertyGlob();
    
    classClone.m_strFrom = m_strFrom;
    classClone.m_strTo = m_strTo;

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

    VwColPropertyGlob objToTest = (VwColPropertyGlob)objTest;

    if ( ! doObjectEqualsTest( m_strFrom, objToTest.m_strFrom ) )
      return false; 

    if ( ! doObjectEqualsTest( m_strTo, objToTest.m_strTo ) )
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
} // *** End of class VwColPropertyGlob{}

// *** End Of VwColPropertyGlob.java