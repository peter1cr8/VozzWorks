/*
============================================================================================

                       V o z z W o r k s   C o d e   G e n e r a t o r                      

                                    Copyright(c) 2024 By                                    

                         V   o   z   z   w   a   r   e   L   L   C .                        

                            A L L   R I G H T S   R E S E R V E D                           

    Source File Name: Cr8JunitDAO.java

    Author:           VozzWorks

    Date Generated:   09-18-2024

    Time Generated:   08:01:33

============================================================================================
*/

package com.vozzware.db.dao;

import com.vozzware.db.VwTimestampOutOfSyncException;
import com.vozzware.db.VwDbResourceMgr;
import java.util.Date;
import java.sql.Timestamp;
import com.vozzware.db.dao.dvo.JunitAddress;
import java.util.List;
import com.vozzware.db.dao.dvo.JunitUser;


public interface Cr8JunitDAO extends VwDbResourceMgr
{


  /**
   * Direct SQL execution
   * 
   * @param strSql - The sql to execute
   * 
   * @param objParams - Object containing param(s) a String, a map or a bean
   * @throws Exception if any database errors occur
   */
  public void exec( String strSql, Object objParams ) throws Exception;

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
  public JunitAddress getJunitAddress( long lIdCk, long lUserIdCk ) throws Exception;

  /**
   * Fetch com.vozzware.db.dao.dvo.JunitAddress List
   * 
   * @return  com.vozzware.db.dao.dvo.JunitAddress List or null if not found
   * @throws Exception if any database errors occur
   */
  public List<JunitAddress> getJunitAddressList() throws Exception;

  /**
   * Fetch com.vozzware.db.dao.dvo.JunitUser by primary key
   * 
   * @param lIdPk - Primary Key
   * 
   * @return  com.vozzware.db.dao.dvo.JunitUser or null if not found
   * @throws Exception if any database errors occur
   */
  public JunitUser getJunitUser( long lIdPk ) throws Exception;

  /**
   * Fetch com.vozzware.db.dao.dvo.JunitUser List
   * 
   * @return  com.vozzware.db.dao.dvo.JunitUser List or null if not found
   * @throws Exception if any database errors occur
   */
  public List<JunitUser> getJunitUserList() throws Exception;

  /**
   * Saves the object
   *<br>This methods performs and insert or update based on the existence of the primary key
   * 
   * @param objToSave - The bean object to save
   * @throws Exception if any database errors occur
   */
  public void save( Object objToSave ) throws Exception;

  /**
   * Saves the object
   *<br>This methods performs and insert or update based on the existence of the primary key
   * 
   * @param objToSave - The bean object to save
   * 
   * @param strMappingId - The mapping id specified in the xsm document
   * @throws Exception if any database errors occur
   */
  public void save( Object objToSave, String strMappingId ) throws Exception;

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
  public void syncSave( Object objToSave ) throws VwTimestampOutOfSyncException, Exception;

  /**
   * Deletes the object by its primary key
   * 
   * @param objToDelete - The bean object to delete
   * @throws Exception if any database errors occur
   */
  public void delete( Object objToDelete ) throws Exception;

  /**
   * Deletes the entire object graph
   * 
   * @param objToDelete - The bean object to delete
   * @throws Exception if any database errors occur
   */
  public void deleteAll( Object objToDelete ) throws Exception;

  /**
   * Deletes the entire object graph
   * 
   * @param objToDelete - The bean object to delete
   * @throws VwTimestampOutOfSyncException if the row changed in between the read and the delete
   * @throws Exception if any database errors occur
   */
  public void syncDelete( Object objToDelete ) throws VwTimestampOutOfSyncException, Exception;

  /**
   * Deletes the entire object graph
   * 
   * @param objToDelete - The bean object to delete
   * @throws VwTimestampOutOfSyncException if the row changed in between the read and the delete
   * @throws Exception if any database errors occur
   */
  public void syncDeleteAll( Object objToDelete ) throws VwTimestampOutOfSyncException, Exception;

  /**
   * See if the object exists based on its primary key(s)
   * 
   * @param objToTest - See if the object exists based on its primary key(s)
   * @throws Exception if any database erors occur
   */
  public boolean exists( Object objToTest ) throws Exception;
} // *** End of interface Cr8JunitDAO{}

// *** End Of Cr8JunitDAO.java