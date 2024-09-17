/*
============================================================================================

    Source File Name: VwPropertiesProcessor

    Author:           petervosburgh

    Date Generated:   4/3/22

    Time Generated:   9:19 AM

============================================================================================
*/
package com.vozzware.util;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

/**
 * This class manages property files that are not in a classpath. It requires a url to a properties file
 */
public class VwPropertiesProcessor
{
  private Properties m_props;

  /**
   * Default constructor.
   * @throws Exception
   */
  public VwPropertiesProcessor()
  {
    m_props = new Properties();
  } // end VwPropertiesProcessor()

  /**
   *
   * @param urlProps
   * @throws Exception
   */
  public VwPropertiesProcessor( URL urlProps ) throws Exception
  {
    InputStream insProps;

    try
    {
      insProps = urlProps.openStream();
    }
    catch( FileNotFoundException fne )
    {
      throw new Exception ("Path to properties file: " + urlProps.getFile() + " does not exist" );

    }
    catch( Exception ex )
    {
      throw new Exception ("Error opening url tp properties file: " + urlProps.getFile() + "Reason: " + ex.getMessage() );

    }

    m_props = new Properties();
    m_props.load( insProps );

  } // end constructor()

  /**
   * Gets the property value is key exists
   *
   * @param strKey The property key to retrieve
   * @return The property value ot null if property key does not exist
   */
  public String getString( String strKey )
  {
    return m_props.getProperty( strKey  );

  } // end getString()

  /**
   * Gets property value to the specified default value if property does not exists
   *
   * @param strKey The property key of the value to retrieve
   * @param strDefault  The default value if key does not exists
   * @return
   */
  public String getString( String strKey, String strDefault )
  {
    return m_props.getProperty( strKey, strDefault  );

  } // end getString()

  public int getInt( String strKey ) throws Exception
  {
    String strVal  = getString( strKey );

    if ( strVal == null )
    {
      throw new Exception( "Property: " + strKey + " is null" );

    }

    return Integer.valueOf( strVal );

  } // end getInt()

  public int getInt( String strKey, int nDefault ) throws Exception
  {
    String strVal  = getString( strKey );

    if ( strVal == null )
    {
      return nDefault;

    }

    return Integer.valueOf( strVal );

  } // end getInt()

  /**
   * Returns property value as a double if valuew is a double
   *
   * @param strKey The property key of the value to retrieve
   * @return value as a double
   * @throws Exception If value returned is null
   */
  public double getDouble( String strKey ) throws Exception
  {
    String strVal  = getString( strKey );

    if ( strVal == null )
    {
      throw new Exception( "Property: " + strKey + " is null" );

    }

    return Double.valueOf( strVal );

  } // end getDouble()

  /**
   * 
   * @param strKey
   * @param dblDefault
   * @return
   * @throws Exception
   */
  public double getDouble( String strKey, double dblDefault ) throws Exception
  {
    String strVal  = getString( strKey );

    if ( strVal == null )
    {
      return dblDefault;

    }

    return Double.valueOf( strVal );

  } // end getDouble()

  /**
   * Gets the property as a boolean. If object returned is not of type boolean, an exception is thrown
    * @return
   * @throws Exception if value is typ of type boolean
   */
  public Boolean getBoolean( String strKey ) throws Exception
  {
    Object objVal  = m_props.get( strKey );

    if ( objVal == null )
    {
      return null;
    }

    if ( !(objVal instanceof Boolean ) )
    {
      throw new Exception( "Property key: " + strKey + " is not of type boolean");
    }

    return (Boolean)objVal;

  } // end getBoolean()

  /**
   * Gets the property as a boolean. If object returned is not of type boolean, an exception is thrown
   * @param strKey
   * @param bDefault
   * @return
   * @throws Exception if value is typ of type boolean
   */
  public Boolean getBoolean( String strKey, boolean bDefault ) throws Exception
  {
    Object objVal  = m_props.get( strKey );

    if ( objVal == null )
    {
      return bDefault;
    }

    if ( !(objVal instanceof Boolean ) )
    {
      throw new Exception( "Property key: " + strKey + " is not of type boolean");
    }

    return (boolean)objVal;

  } // end getBoolean()

  /**
   * Gets property as an object
   * @param strKey The property key
   * @return
   */
  public Object getObject( String strKey )
  {
    return m_props.get( strKey );
  } // end getObject()

  /**
   * Gets property as an object
   * @param strKey The property key
   * @param objDefault The default object if val ue is null
   * @return
   */
  public Object getObject( String strKey, Object objDefault )
  {
    Object objVal =  m_props.get( strKey );;
    if ( objVal == null )
    {
      return objDefault;
    }

    return objVal;

  } // end getObject()

  /**
   * Puts a string value property
   *
   * @param strPropName The name of the property
   * @param strPropValue The property value
   */
  public void putString( String strPropName, String strPropValue )
  {
    m_props.put( strPropName, strPropValue );

  } // end putString(()

  /**
   * Puts an int value property
   *
   * @param strPropName The property name
   * @param nVal The int value
   */
  public void putInt( String strPropName, int nVal )
  {
    m_props.put( strPropName, nVal );

  } // end putInt()

  /**
   * Puts a double property
   * @param strPropName The property name
   * @param dblVal The double value
   */
  public void putDouble( String strPropName, double dblVal )
  {
    m_props.put( strPropName, dblVal );
  } // end putDouble()

  /**
   * Puts a boolean property
   * @param strPropName The property name
   * @param bVal the boolean value
   */
  public void putBoolean( String strPropName, boolean bVal )
  {
    m_props.put( strPropName, bVal );
  } // end putBoolean()

  public void putObject( String strPropName, Object objVal )
  {
    m_props.put( strPropName, objVal );
  } // end putBoolean()

} // end VwPropertiesProcessor{}
