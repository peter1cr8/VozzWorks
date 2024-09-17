/*
============================================================================================

                       V o z z W o r k s   C o d e   G e n e r a t o r                      

                                    Copyright(c) 2024 By                                    

                         V   o   z   z   w   a   r   e   L   L   C .                        

                            A L L   R I G H T S   R E S E R V E D                           

    Source File Name: JunitUser.java

    Author:           VozzWorks

    Date Generated:   06-24-2024

    Time Generated:   15:28:40

============================================================================================
*/

package com.vozzware.db.dao.dvo;

import java.io.Serializable;
import java.lang.Cloneable;
import com.vozzware.db.VwDVOBase;
import com.vozzware.util.annotations.VwJsonProperty;
import java.util.Date;
import com.vozzware.util.VwBeanUtils;


public class JunitUser extends VwDVOBase implements Serializable, Cloneable
{

  private Long                   m_idPk;                         
  private String                 m_strFirstName;                 
  private String                 m_strLastName;                  
  private Boolean                m_isActive = true;              
  private String                 m_strDepartment = "Org";        
  private Long                   m_orgCount = 20L;               
  private Date                   m_dtDateLastLoggedIn = new Date(); 

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
   * Sets the idPk property
   */
  @VwJsonProperty( prop = "id" )
  public void setIdPk( Long idPk )
  { 
    testDirty( "idPk", idPk );
    m_idPk = idPk;
  }

  /**
   * Gets idPk property
   * 
   * @return  The idPk property
   */
  @VwJsonProperty( prop = "id" )
  public Long getIdPk()
  { return m_idPk; }

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
   * Sets the isActive property
   */
  public void setIsActive( Boolean isActive )
  { 
    testDirty( "isActive", isActive );
    m_isActive = isActive;
  }

  /**
   * Gets isActive property
   * 
   * @return  The isActive property
   */
  public Boolean getIsActive()
  { return m_isActive; }

  /**
   * Sets the department property
   */
  public void setDepartment( String strDepartment )
  { 
    testDirty( "department", strDepartment );
    m_strDepartment = strDepartment;
  }

  /**
   * Gets department property
   * 
   * @return  The department property
   */
  public String getDepartment()
  { return m_strDepartment; }

  /**
   * Sets the orgCount property
   */
  public void setOrgCount( Long orgCount )
  { 
    testDirty( "orgCount", orgCount );
    m_orgCount = orgCount;
  }

  /**
   * Gets orgCount property
   * 
   * @return  The orgCount property
   */
  public Long getOrgCount()
  { return m_orgCount; }

  /**
   * Sets the dateLastLoggedIn property
   */
  public void setDateLastLoggedIn( Date dtDateLastLoggedIn )
  { 
    testDirty( "dateLastLoggedIn", dtDateLastLoggedIn );
    m_dtDateLastLoggedIn = dtDateLastLoggedIn;
  }

  /**
   * Gets dateLastLoggedIn property
   * 
   * @return  The dateLastLoggedIn property
   */
  public Date getDateLastLoggedIn()
  { return m_dtDateLastLoggedIn; }

  /**
   * Clones this object
   *
   */
  public Object clone()
  {
    JunitUser classClone = new JunitUser();
    
    classClone.m_idPk = m_idPk;
    classClone.m_strFirstName = m_strFirstName;
    classClone.m_strLastName = m_strLastName;
    classClone.m_isActive = m_isActive;
    classClone.m_strDepartment = m_strDepartment;
    classClone.m_orgCount = m_orgCount;

    if ( m_dtDateLastLoggedIn  != null )
      classClone.m_dtDateLastLoggedIn = (Date)m_dtDateLastLoggedIn.clone();

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

    JunitUser objToTest = (JunitUser)objTest;

    if ( ! doObjectEqualsTest( m_idPk, objToTest.m_idPk ) )
      return false; 

    if ( ! doObjectEqualsTest( m_strFirstName, objToTest.m_strFirstName ) )
      return false; 

    if ( ! doObjectEqualsTest( m_strLastName, objToTest.m_strLastName ) )
      return false; 

    if ( ! doObjectEqualsTest( m_isActive, objToTest.m_isActive ) )
      return false; 

    if ( ! doObjectEqualsTest( m_strDepartment, objToTest.m_strDepartment ) )
      return false; 

    if ( ! doObjectEqualsTest( m_orgCount, objToTest.m_orgCount ) )
      return false; 

    if ( ! doObjectEqualsTest( m_dtDateLastLoggedIn, objToTest.m_dtDateLastLoggedIn ) )
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
} // *** End of class JunitUser{}

// *** End Of JunitUser.java