/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuanbanhdanem.projectgraduationchatserver.utils.config;

/**
 *
 * @author tuantran
 */
public class ServerConfig {
    public static String SERVER_HOST = "localhost";
    public static int SERVER_PORT = 9119;
    public static int LOG_RUNNER_NUMBER = 5;    
    public static String LOG_FILE = "logger.log";
    public static String LOG_PATTERN = "[%p] %m%n";
    
    public static void initConfig(String configFile) {
        SERVER_PORT = ConfigMethod.getIntegerProperties(configFile, "SERVER_PORT", "9000");

        LOG_RUNNER_NUMBER = ConfigMethod.getIntegerProperties(configFile, "LOG_RUNNER_NUMBER", "5");
        LOG_FILE = ConfigMethod.getStringProperties(configFile, "LOG_FILE", "logger.log");
        LOG_PATTERN = ConfigMethod.getStringProperties(configFile, "LOG_PATTERN", "[%p] %m%n");
    }
}
