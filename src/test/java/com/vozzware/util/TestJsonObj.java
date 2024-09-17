package com.vozzware.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
============================================================================================

    Source File Name: Transaction.java

    Author:           petervosburgh
    
    Date Generated:   5/22/24

    Time Generated:   3:38 PM

============================================================================================
*/
public class TestJsonObj
{
  private Map<String,Object> m_mapExtras = Collections.synchronizedMap( new HashMap<>() );
  private List<String> m_listColors = Collections.synchronizedList( new ArrayList() );

  private String m_strTest;

  public Map<String, Object> getMapExtras()
  {
    return m_mapExtras;
  }

  public void setMapExtras( Map<String, Object> mapExtras )
  {
    m_mapExtras = mapExtras;
  }

  public List<String> getColors()
  {
    return m_listColors;
  }

  public void setColors( List<String> listColors )
  {
    m_listColors = listColors;
  }

  public String getTest()
  {
    return m_strTest;
  }

  public void setTest( String strTest )
  {
    m_strTest = strTest;
  }
}
