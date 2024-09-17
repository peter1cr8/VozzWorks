package com.vozzware.util.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/*
============================================================================================

    Source File Name: Transaction.java

    Author:           petervosburgh
    
    Date Generated:   5/30/24

    Time Generated:   1:37 PM

============================================================================================
*/


@Retention( RetentionPolicy.RUNTIME )
public @interface VwJsonProperty
{
  String prop();
}
