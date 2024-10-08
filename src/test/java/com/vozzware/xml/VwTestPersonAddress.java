package com.vozzware.xml;/*
============================================================================================

                       V o z z W o r k s   C o d e   G e n e r a t o r                      

                                    Copyright(c) 2011 By                                    

                        V   o   z   z   w   a   r   e   L   L   C   .                       

                            A L L   R I G H T S   R E S E R V E D                           

    Source File Name: Transaction.java

    Author:           Vozzware LLC

    Date Generated:   04-23-2011

    Time Generated:   12:55:42

============================================================================================
*/

public class VwTestPersonAddress
{
  private String m_strFirstName;
  private String m_strLastName;
  private Integer m_nAge;
  private boolean m_fIsSingle;

  private VwTestAddress m_address;

  public VwTestPersonAddress()
  {
    ;
  }

  public VwTestPersonAddress( String strFirstName, String strLastName, Integer nAge )
  {
    m_strFirstName = strFirstName;
    m_strLastName = strLastName;
    m_nAge = nAge;
    m_fIsSingle = true;

  }

  public void setVwTestAddress( VwTestAddress address )
  { m_address = address; }

  public VwTestAddress getVwTestAddress()
  { return m_address; }

  public String getFirstName()
  {
    return m_strFirstName;
  }

  public void setFirstName( String strFirstName )
  {
    m_strFirstName = strFirstName;
  }

  public String getLastName()
  {
    return m_strLastName;
  }

  public void setLastName( String strLastName )
  {
    m_strLastName = strLastName;
  }

  public Integer getAge()
  {
    return m_nAge;
  }

  public void setAge( Integer nAge )
  {
    m_nAge = nAge;
  }

  public boolean getIsSingle()
  {
    return m_fIsSingle;
  }

  public void setIsSingle( boolean fIsSingle )
  {
    m_fIsSingle = fIsSingle;
  }
}
