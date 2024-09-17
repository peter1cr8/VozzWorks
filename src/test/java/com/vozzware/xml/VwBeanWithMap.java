package com.vozzware.xml;

import java.util.HashMap;
import java.util.Map;

/*
============================================================================================

    Source File Name: Transaction.java

    Author:           petervosburgh
    
    Date Generated:   11/13/23

    Time Generated:   10:17 AM

============================================================================================
*/
public class VwBeanWithMap
{
  private String m_strName;
  private int    m_age;
  private Map<String,String>m_mapProps = new HashMap<>();

  public String getName()
  {
    return m_strName;
  }

  public void setName( String strName )
  {
    m_strName = strName;
  }

  public int getAge()
  {
    return m_age;
  }

  public void setAge( int age )
  {
    m_age = age;
  }

  public void addProperty( String strName, String strVal )
  {
    m_mapProps.put( strName, strVal );
  }

  public Map getProperties()
  {
    return m_mapProps;
  }
}
