/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuanbanhdanem.projectgraduationchatserver.utils.dateformat;

import java.util.Date;

/**
 *
 * @author tuan
 */
public class DateFormat {
    private static final int JavaDate_StartYear = 1900;
    
    private static String Zero = "0";
    
    public static String format_yyyyMMddHHmmssSSS( long d) {
        return format_yyyyMMddHHmmssSSS( new Date(d) );
    }
    
    public static String format_yyyyMMddHHmmssSSS( Date d ){
        if( d == null ) return null;
        StringBuilder buidler = new StringBuilder()
                .append( d.getYear() + JavaDate_StartYear )
                .append( format2DNumber( d.getMonth() + 1) ) 
                .append( format2DNumber( d.getDate() ) )
                .append( format2DNumber( d.getHours() ) )
                .append( format2DNumber( d.getMinutes() ) )
                .append( format2DNumber( d.getSeconds() ) )
                .append( getMillisecond( d ) );
        return buidler.toString();
    }
    
    private static String getMillisecond( Date d ){
        int n = (int) ( d.getTime() % 1000 );
        n = n < 0 ? n + 1000 : n;
        return format3DNumber( n );
    }
    
    private static String format2DNumber(int n) {
        return n > 9 ? String.valueOf(n) : (Zero + n);
    }
    
    private static String format3DNumber(int n) {
        return n < 10 ? String.valueOf(Zero + Zero + n) : (n < 100) ? String.valueOf(Zero + n) : String.valueOf(n);
    }

    
}
