package com.vozzware.annotations;

import com.vozzware.util.VwBeanUtils;
import com.vozzware.util.VwJsonUtils;
import com.vozzware.util.annotations.VwJsonProperty;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
============================================================================================

    Source File Name: Transaction.java

    Author:           petervosburgh
    
    Date Generated:   5/30/24

    Time Generated:   9:18 AM

============================================================================================
*/
public class VwAnnotationsTester
{
  @Test
  public void testVwAnnotionDemo() throws Exception
  {
    Class clazz = VwAnnotationDemo.class;
    Map<String,Method> mapAnnoMethods = new HashMap<>(); ;

    List<Method> listReadMethods = VwBeanUtils.getReadMethods( clazz );

    for (Method method : listReadMethods )
    {
      VwJsonProperty jsonProp = method.getAnnotation( VwJsonProperty.class );

      if ( method.isAnnotationPresent( VwJsonProperty.class ))
      {
        VwJsonProperty vwJsonProperty = method.getAnnotation( VwJsonProperty.class );
        mapAnnoMethods.put( vwJsonProperty.prop(), method );


        if ( vwJsonProperty.prop().length() > 0  )
        {
          System.out.println( "Method : " + method.getName() + " json name is " + vwJsonProperty.prop() );

        }
        System.out.println( "Method : " + method.getName() + " is available for JSON");
      }
      else
      {
        System.out.println( "Method : " + method.getName() + " is NOT available for JSON");

      }
    }

    System.out.println("done");

  } // testVwAnnotionDemo()

  @Test
  public void jsonToBeanAnnotationTester() throws Exception
  {
    VwAnnotationDemo demo = new VwAnnotationDemo();
    demo.setAge( 35 );
    demo.setName( "Irving Confelterschnidt" );;
    demo.setIdPk( 101 );

    String strJson = VwJsonUtils.toJson( demo );

    VwAnnotationDemo annoDemo = (VwAnnotationDemo)VwJsonUtils.fromJson( strJson, VwAnnotationDemo.class );

    System.out.println("done");

  }
}
