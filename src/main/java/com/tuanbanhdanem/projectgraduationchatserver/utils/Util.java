/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuanbanhdanem.projectgraduationchatserver.utils;

import com.tuanbanhdanem.projectgraduationchatserver.utils.logger.DailyLogger;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 * @author tuantran
 */
public class Util {
    public static void addDebugLog(String str) {
        Date time = new Date();
        DailyLogger.debug(time, str);
    }
    
    public static void addErrorLog(Exception ex ) {
        DailyLogger.error(ex);
    }
    
    public static void addInfoLog(String info) {
        DailyLogger.info(info);
    }
    
    public static Date getGMTTime() {
        return convertToGMT();
    }
    
    public static Date convertToGMT() {
        TimeZone tz = TimeZone.getDefault();
        long time = System.currentTimeMillis() - tz.getRawOffset();
        Date d = new Date(time);
        return d;
    }
}
