package com.vozzware.annotations;

import com.vozzware.util.annotations.VwJsonProperty;

/*
============================================================================================

    Source File Name: Transaction.java

    Author:           petervosburgh
    
    Date Generated:   5/30/24

    Time Generated:   9:25 AM

============================================================================================
*/
public class VwAnnotationDemo
{
  private String  m_strName;
  private int    m_nAge;
  private int     m_idPk;

  @VwJsonProperty(prop = "id")
  public void setIdPk( int id)
  {
    m_idPk = id;
  }

  @VwJsonProperty(prop = "id")
  public int getIdPk()
  {
    return m_idPk;
  }

  public void setName( String strName )
  {
    m_strName = strName;
  }

  public String getName()
  {
    return m_strName;
  }

  public void setAge( int nAge)
  {
    m_nAge = nAge;
  }
  
  public int getAge()
  {
    return m_nAge;
  }

  public String getNotAnnotated()
  {
    return null;
  }

}
