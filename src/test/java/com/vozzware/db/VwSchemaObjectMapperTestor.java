package com.vozzware.db;

import com.vozzware.db.VwSchemaObjectMapper;
import org.junit.Test;

/*
============================================================================================

    Source File Name: 

    Author:           petervosburgh
    
    Date Generated:   2/16/16

    Time Generated:   7:29 AM

============================================================================================
*/
public class VwSchemaObjectMapperTestor
{


  @Test
  public void testRunSchemaMapper() throws Exception
  {

    String[] astrArgs = new String[]{ "Cr8JunitDAO.xml", "-g", "-o", "-p", "schemaMapper"};

    VwSchemaObjectMapper.main( astrArgs );

    return;



  }
}
