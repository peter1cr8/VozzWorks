/*
============================================================================================

                       V o z z W o r k s   C o d e   G e n e r a t o r                      

                                    Copyright(c) 2024 By                                    

                         V   o   z   z   w   a   r   e   L   L   C .                        

                            A L L   R I G H T S   R E S E R V E D                           

    Source File Name: Cr8JunitDAOImpl.java

    Author:           VozzWorks

    Date Generated:   09-18-2024

    Time Generated:   08:01:33

============================================================================================
*/

package com.vozzware.db.dao;

import com.vozzware.db.VwDbResourceMgrImpl;
import java.net.URL;
import java.util.Date;
import java.sql.Timestamp;
import com.vozzware.db.VwSqlMgr;
import com.vozzware.db.VwTimestampOutOfSyncException;
import com.vozzware.util.VwLogger;
import com.vozzware.util.VwResourceMgr;
import com.vozzware.util.VwResourceStoreFactory;
import com.vozzware.util.VwStackTraceWriter;
import com.vozzware.db.dao.dvo.JunitAddress;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import com.vozzware.db.dao.dvo.JunitUser;


public class Cr8JunitDAOImpl extends VwDbResourceMgrImpl implements Cr8JunitDAO
{

  private static Cr8JunitDAO     s_instance = null;                 // singleton DAO instance

  /**
   * Constructs the Cr8JunitDAOImpl instance
   */
  protected Cr8JunitDAOImpl( String strDriverId, String strUrlId, URL urlMappingDoc, VwLogger loggerSql, VwLogger loggerDbMgr ) throws Exception
  {
        super( strDriverId, strUrlId, urlMappingDoc, loggerSql, loggerDbMgr   );

  } // End of Cr8JunitDAOImpl()


  /**
   * Singleton access method
   * @throws Exception if any database connection errors occur
   */
  public static synchronized Cr8JunitDAO getInstance( VwLogger loggerSql, VwLogger loggerDbMgr ) throws Exception
  {
    if (s_instance == null)
    {
      VwResourceMgr.loadBundle( "dao", true );
      String strDriverId = VwResourceMgr.getString( "daoDriverName" );
      String strUrlId = VwResourceMgr.getString( "daoUrlId" );
      String strUrlXsmDocName = VwResourceMgr.getString( "daoMappingDoc" );
      String[] astrLoggerProperties = (VwResourceMgr.getString( "daoLoggerProperties" )).split( "," );
      
      URL urlMappingDoc = VwResourceStoreFactory.getInstance().getStore().getDocument( strUrlXsmDocName );

      VwLogger logSql = null;
      VwLogger logDbMgr = null;

      // Loggers for the App Db Logger and VwDbMgr logger

      if ( loggerSql != null )
      {
        logSql = loggerSql;
      }
      else
      if ( !astrLoggerProperties[0].equals( "daoLoggerProperties" ) )
      {
        logSql = VwLogger.getInstance( astrLoggerProperties[0] );	// configure logger from named properties file
      }

      if ( loggerDbMgr != null )
      {
        logDbMgr = loggerDbMgr;
      }
      else
      if ( !astrLoggerProperties[1].equals( "daoLoggerProperties" ) )
      {
        logDbMgr = VwLogger.getInstance( astrLoggerProperties[1] );	// configure logger from named properties file
      }

      // Mapping document required
      if ( urlMappingDoc == null )
      {
        String strMissingUrl = "Cannot find mapping document '" +  strUrlXsmDocName + "' for resource key 'daoMappingDoc' ";

        if ( loggerSql != null )
        {
          loggerSql.error( Cr8JunitDAO.class, strMissingUrl );
        }

        throw new Exception( strMissingUrl );
      }
      
      s_instance = new Cr8JunitDAOImpl( strDriverId, strUrlId, urlMappingDoc, logSql, logDbMgr );
    }
    
    return s_instance;
  } // End of getInstance()



  /**
   * Direct SQL execution
   * 
   * @param strSql - The sql to execute
   * 
   * @param objParams - Object containing param(s) a String, a map or a bean
   * @throws Exception if any database errors occur
   */
  public void exec( String strSql, Object objParams ) throws Exception
  {
    if ( m_loggerSql.isDebugEnabled() )
    {
      m_loggerSql.debug( this.getClass(), "Entering DAO Method: exec()" );
    }

    VwSqlMgr sqlMgr = null;

    VwSqlMgr sqlMgrTrans = getTransactionSqlMgr();

    if ( sqlMgrTrans != null )
    {
      sqlMgr = sqlMgrTrans;
    }
    else
    {
      sqlMgr = getSqlMgr();
    }

    Exception exExec = null;

    try
    {
      if ( sqlMgrTrans == null )
      {
        sqlMgr.setAutoCommit( false );
      }

      sqlMgr.exec( strSql, objParams );

      if ( sqlMgrTrans == null )
      {
        sqlMgr.commit();
      }

    }
    catch( Exception ex )
    {
      exExec = ex;
      if ( sqlMgrTrans == null )
      {
        rollback( sqlMgr, ex);
      }

      throw ex;

    }
    finally
    {
      if ( sqlMgrTrans == null )
      {
      	closeResources( sqlMgr, exExec );
      }
    }
  } // End of exec()



  /**
   * Fetch com.vozzware.db.dao.dvo.JunitAddress by primary key
   * 
   * @param lIdCk - Primary Key
   * 
   * @param lUserIdCk - Primary Key
   * 
   * @return  com.vozzware.db.dao.dvo.JunitAddress or null if not found
   * @throws Exception if any database errors occur
   */
  public JunitAddress getJunitAddress( long lIdCk, long lUserIdCk ) throws Exception
  {
    if ( m_loggerSql.isDebugEnabled() )
    {
      m_loggerSql.debug( this.getClass(), "Entering DAO Method: getJunitAddress()" );
    }

    VwSqlMgr sqlMgr = getSqlMgr();
    Exception exFind = null;
    Map<String,Object> mapCompositeKeys = new HashMap<String,Object>();
    mapCompositeKeys.put( "idCk", lIdCk );    mapCompositeKeys.put( "userIdCk", lUserIdCk );
    
    try
    {
      return (com.vozzware.db.dao.dvo.JunitAddress)sqlMgr.findByPrimaryKey( com.vozzware.db.dao.dvo.JunitAddress.class, mapCompositeKeys );
    }
    catch( Exception ex )
    {
      exFind = ex;
      throw ex;
    }
    finally
    {
     	closeResources( sqlMgr, exFind );
    }
  } // End of getJunitAddress()



  /**
   * Fetch com.vozzware.db.dao.dvo.JunitAddress List
   * 
   * @return  com.vozzware.db.dao.dvo.JunitAddress List or null if not found
   * @throws Exception if any database errors occur
   */
  public List<JunitAddress> getJunitAddressList() throws Exception
  {
    if ( m_loggerSql.isDebugEnabled() )
    {
      m_loggerSql.debug( this.getClass(), "Entering DAO Method: getJunitAddressList()" );
    }

    VwSqlMgr sqlMgr = getSqlMgr();
    Exception exFind = null;
    
    try
    {
      return (List<JunitAddress>)sqlMgr.findAll( JunitAddress.class );
    }
    catch( Exception ex )
    {
      exFind = ex;
      throw ex;
    }
    finally
    {
     	closeResources( sqlMgr, exFind );
    }
  } // End of getJunitAddressList()



  /**
   * Fetch com.vozzware.db.dao.dvo.JunitUser by primary key
   * 
   * @param lIdPk - Primary Key
   * 
   * @return  com.vozzware.db.dao.dvo.JunitUser or null if not found
   * @throws Exception if any database errors occur
   */
  public JunitUser getJunitUser( long lIdPk ) throws Exception
  {
    VwSqlMgr sqlMgr = getSqlMgr();
    Exception exFind = null;
    
    try
    {
      return (com.vozzware.db.dao.dvo.JunitUser)sqlMgr.findByPrimaryKey( com.vozzware.db.dao.dvo.JunitUser.class, lIdPk );
    }
    catch( Exception ex )
    {
      exFind = ex;
      throw ex;
    }
    finally
    {
     	closeResources( sqlMgr, exFind );
    }
  } // End of getJunitUser()



  /**
   * Fetch com.vozzware.db.dao.dvo.JunitUser List
   * 
   * @return  com.vozzware.db.dao.dvo.JunitUser List or null if not found
   * @throws Exception if any database errors occur
   */
  public List<JunitUser> getJunitUserList() throws Exception
  {
    if ( m_loggerSql.isDebugEnabled() )
    {
      m_loggerSql.debug( this.getClass(), "Entering DAO Method: getJunitUserList()" );
    }

    VwSqlMgr sqlMgr = getSqlMgr();
    Exception exFind = null;
    
    try
    {
      return (List<JunitUser>)sqlMgr.findAll( JunitUser.class );
    }
    catch( Exception ex )
    {
      exFind = ex;
      throw ex;
    }
    finally
    {
     	closeResources( sqlMgr, exFind );
    }
  } // End of getJunitUserList()



  /**
   * Saves the object
   *<br>This methods performs and insert or update based on the existence of the primary key
   * 
   * @param objToSave - The bean object to save
   * @throws Exception if any database errors occur
   */
  public void save( Object objToSave ) throws Exception
  {
    if ( m_loggerSql.isDebugEnabled() )
    {
      m_loggerSql.debug( this.getClass(), "Entering DAO Method: save()" );
    }

    VwSqlMgr sqlMgr = null;

    VwSqlMgr sqlMgrTrans = getTransactionSqlMgr();

    if ( sqlMgrTrans != null )
    {
      sqlMgr = sqlMgrTrans;
    }
    else
    {
      sqlMgr = getSqlMgr();
    }

    Exception exSave = null;

    try
    {
      if ( sqlMgrTrans == null )
      {
        sqlMgr.setAutoCommit( false );
      }

      sqlMgr.save( objToSave );

      if ( sqlMgrTrans == null )
      {
        sqlMgr.commit();
      }
    }
    catch( Exception ex )
    {
      exSave = ex;
      if ( sqlMgrTrans == null )
      {
        rollback( sqlMgr, ex);
      }

      throw ex;
    }
    finally
    {
      if ( sqlMgrTrans == null )
     	{
     	  closeResources( sqlMgr, exSave );
     	}
    }
  } // End of save()



  /**
   * Saves the object
   *<br>This methods performs and insert or update based on the existence of the primary key
   * 
   * @param objToSave - The bean object to save
   * 
   * @param strMappingId - The mapping id specified in the xsm document
   * @throws Exception if any database errors occur
   */
  public void save( Object objToSave, String strMappingId ) throws Exception
  {
    if ( m_loggerSql.isDebugEnabled() )
    {
      m_loggerSql.debug( this.getClass(), "Entering DAO Method: save()" );
    }

    VwSqlMgr sqlMgr = null;

    VwSqlMgr sqlMgrTrans = getTransactionSqlMgr();

    if ( sqlMgrTrans != null )
    {
      sqlMgr = sqlMgrTrans;
    }
    else
    {
      sqlMgr = getSqlMgr();
    }

    Exception exSave = null;

    try
    {
      if ( sqlMgrTrans == null )
      {
        sqlMgr.setAutoCommit( false );
      }

      sqlMgr.save( objToSave, strMappingId );

      if ( sqlMgrTrans == null )
      {
        sqlMgr.commit();
      }
    }
    catch( Exception ex )
    {
      exSave = ex;
      if ( sqlMgrTrans == null )
      {
        rollback( sqlMgr, ex);
      }

      throw ex;
    }
    finally
    {
      if ( sqlMgrTrans == null )
     	{
     	  closeResources( sqlMgr, exSave );
     	}
    }
  } // End of save()



  /**
   * Saves the object
   *<br>This methods performs and insert or update based on the existence of the primary key
   *<br>if an upadte operation results then a timestamp check is performed. Please refer to the syncSave method
   *<br>javadoc on the VwSqlMgr class for complete details
   * 
   * @param objToSave - The bean object to save
   * @throws VwTimestampOutOfSyncException if the row changed in between the read and the save
   * @throws Exception if any database errors occur
   */
  public void syncSave( Object objToSave ) throws VwTimestampOutOfSyncException, Exception
  {
    if ( m_loggerSql.isDebugEnabled() )
    {
      m_loggerSql.debug( this.getClass(), "Entering DAO Method: syncSave()" );
    }

    VwSqlMgr sqlMgr = null;

    VwSqlMgr sqlMgrTrans = getTransactionSqlMgr();

    if ( sqlMgrTrans != null )
    {
      sqlMgr = sqlMgrTrans;
    }
    else
    {
      sqlMgr = getSqlMgr();
    }

    Exception exSave = null;

    try
    {
      if ( sqlMgrTrans == null )
      {
        sqlMgr.setAutoCommit( false );
      }

      sqlMgr.syncSave( objToSave );

      if ( sqlMgrTrans == null )
      {
        sqlMgr.commit();
      }
    }
    catch( Exception ex )
    {
      exSave = ex;
      if ( sqlMgrTrans == null )
      {
        rollback( sqlMgr, ex);
      }

      throw ex;
    }
    finally
    {
      if ( sqlMgrTrans == null )
     	{
     	  closeResources( sqlMgr, exSave );
     	}
    }
  } // End of syncSave()



  /**
   * Deletes the object by its primary key
   * 
   * @param objToDelete - The bean object to delete
   * @throws Exception if any database errors occur
   */
  public void delete( Object objToDelete ) throws Exception
  {
    if ( m_loggerSql.isDebugEnabled() )
    {
      m_loggerSql.debug( this.getClass(), "Entering DAO Method: delete()" );
    }

    VwSqlMgr sqlMgr = null;

    VwSqlMgr sqlMgrTrans = getTransactionSqlMgr();

    if ( sqlMgrTrans != null )
    {
      sqlMgr = sqlMgrTrans;
    }
    else
    {
      sqlMgr = getSqlMgr();
    }

    Exception exDelete = null;

    try
    {
      if ( sqlMgrTrans == null )
      {
        sqlMgr.setAutoCommit( false );
      }

      sqlMgr.delete( objToDelete );

      if ( sqlMgrTrans == null )
      {
        sqlMgr.commit();
      }
    }
    catch( Exception ex )
    {
      exDelete = ex;

      if ( sqlMgrTrans == null )
      {
        rollback( sqlMgr, ex);
      }

      throw ex;

    }
    finally
    {
      if ( sqlMgrTrans == null )
     	{
     	  closeResources( sqlMgr, exDelete );
     	}
    }
  } // End of delete()



  /**
   * Deletes the entire object graph
   * 
   * @param objToDelete - The bean object to delete
   * @throws Exception if any database errors occur
   */
  public void deleteAll( Object objToDelete ) throws Exception
  {
    if ( m_loggerSql.isDebugEnabled() )
    {
      m_loggerSql.debug( this.getClass(), "Entering DAO Method: deleteAll()" );
    }

    VwSqlMgr sqlMgr = null;

    VwSqlMgr sqlMgrTrans = getTransactionSqlMgr();

    if ( sqlMgrTrans != null )
    {
      sqlMgr = sqlMgrTrans;
    }
    else
    {
      sqlMgr = getSqlMgr();
    }

    Exception exDelete = null;

    try
    {
      if ( sqlMgrTrans == null )
      {
        sqlMgr.setAutoCommit( false );
      }

      sqlMgr.deleteAll( objToDelete );

      if ( sqlMgrTrans == null )
      {
        sqlMgr.commit();
      }
    }
    catch( Exception ex )
    {
      exDelete = ex;

      if ( sqlMgrTrans == null )
      {
        rollback( sqlMgr, ex);
      }

      throw ex;

    }
    finally
    {
      if ( sqlMgrTrans == null )
     	{
     	  closeResources( sqlMgr, exDelete );
     	}
    }
  } // End of deleteAll()



  /**
   * Deletes the entire object graph
   * 
   * @param objToDelete - The bean object to delete
   * @throws VwTimestampOutOfSyncException if the row changed in between the read and the delete
   * @throws Exception if any database errors occur
   */
  public void syncDelete( Object objToDelete ) throws VwTimestampOutOfSyncException, Exception
  {
    if ( m_loggerSql.isDebugEnabled() )
    {
      m_loggerSql.debug( this.getClass(), "Entering DAO Method: syncDelete()" );
    }

    VwSqlMgr sqlMgr = null;

    VwSqlMgr sqlMgrTrans = getTransactionSqlMgr();

    if ( sqlMgrTrans != null )
    {
      sqlMgr = sqlMgrTrans;
    }
    else
    {
      sqlMgr = getSqlMgr();
    }

    Exception exDelete = null;

    try
    {
      if ( sqlMgrTrans == null )
      {
        sqlMgr.setAutoCommit( false );
      }

      sqlMgr.syncDelete( objToDelete );

      if ( sqlMgrTrans == null )
      {
        sqlMgr.commit();
      }
    }
    catch( Exception ex )
    {
      exDelete = ex;

      if ( sqlMgrTrans == null )
      {
        rollback( sqlMgr, ex);
      }

      throw ex;

    }
    finally
    {
      if ( sqlMgrTrans == null )
     	{
     	  closeResources( sqlMgr, exDelete );
     	}
    }
  } // End of syncDelete()



  /**
   * Deletes the entire object graph
   * 
   * @param objToDelete - The bean object to delete
   * @throws VwTimestampOutOfSyncException if the row changed in between the read and the delete
   * @throws Exception if any database errors occur
   */
  public void syncDeleteAll( Object objToDelete ) throws VwTimestampOutOfSyncException, Exception
  {
    if ( m_loggerSql.isDebugEnabled() )
    {
      m_loggerSql.debug( this.getClass(), "Entering DAO Method: syncDeleteAll()" );
    }

    VwSqlMgr sqlMgr = null;

    VwSqlMgr sqlMgrTrans = getTransactionSqlMgr();

    if ( sqlMgrTrans != null )
    {
      sqlMgr = sqlMgrTrans;
    }
    else
    {
      sqlMgr = getSqlMgr();
    }

    Exception exDelete = null;

    try
    {
      if ( sqlMgrTrans == null )
      {
        sqlMgr.setAutoCommit( false );
      }

      sqlMgr.syncDeleteAll( objToDelete );

      if ( sqlMgrTrans == null )
      {
        sqlMgr.commit();
      }
    }
    catch( Exception ex )
    {
      exDelete = ex;

      if ( sqlMgrTrans == null )
      {
        rollback( sqlMgr, ex);
      }

      throw ex;

    }
    finally
    {
      if ( sqlMgrTrans == null )
     	{
     	  closeResources( sqlMgr, exDelete );
     	}
    }
  } // End of syncDeleteAll()



  /**
   * See if the object exists based on its primary key(s)
   * 
   * @param objToTest - See if the object exists based on its primary key(s)
   * @throws Exception if any database erors occur
   */
  public boolean exists( Object objToTest ) throws Exception
  {
    VwSqlMgr sqlMgr = getSqlMgr();
    Exception exFind = null;
    
    try
    {
      return sqlMgr.exists( objToTest );
    }
    catch( Exception ex )
    {
      exFind = ex;
      throw ex;
    }
    finally
    {
     	closeResources( sqlMgr, exFind );
    }
  } // End of exists()


} // *** End of class Cr8JunitDAOImpl{}

// *** End Of Cr8JunitDAOImpl.java