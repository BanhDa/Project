/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuanbanhdanem.projectgraduationchatserver.utils.logger;

import com.tuanbanhdanem.projectgraduationchatserver.utils.Util;
import com.tuanbanhdanem.projectgraduationchatserver.utils.config.ServerConfig;
import java.util.Date;
import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
/**
 *
 * @author tuantran
 */
public class DailyLogger {
    private static final Logger LOGGER = Logger.getRootLogger();
    
    static {
        PatternLayout layout = new PatternLayout();
        String conversionPattern = ServerConfig.LOG_PATTERN;
        layout.setConversionPattern(conversionPattern);
 
        // creates daily rolling file appender
        DailyRollingFileAppender rollingAppender = new DailyRollingFileAppender();
        rollingAppender.setFile( ServerConfig.LOG_FILE );
        rollingAppender.setDatePattern("'.'yyyy-MM-dd");
        rollingAppender.setLayout(layout);
        rollingAppender.activateOptions();
 
        // configures the root logger
        Logger rootLogger = Logger.getRootLogger();
//        rootLogger.setLevel(Level.ERROR);
        rootLogger.setLevel(Level.ALL);
        rootLogger.addAppender(rollingAppender);    
    }
    
    public static String createMessageLog(Date time, String str) {
        StringBuilder builder = new StringBuilder();
        builder.append(time.toString());
        builder.append(" ");
        builder.append(str);
        
        return builder.toString();
    }
    
    public static void debug(Date time, String str) {
        String debugLog = createMessageLog(time, str);
        LOGGER.debug(debugLog);
    }
    
    public static void error(Throwable t) {
        LOGGER.error("At " + Util.getGMTTime().toString(), t);
    }
    
    public static void info(String info) {
        LOGGER.info(info);
    }
}
