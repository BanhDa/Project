/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuanbanhdanem.projectgraduationchatserver.utils.config;

import com.tuanbanhdanem.projectgraduationchatserver.utils.Util;
import java.io.FileInputStream;
import java.util.Properties;

/**
 *
 * @author tuantran
 */
public class ConfigMethod {
    
    public static String getStringProperties(String configFile, String key, String defaultProperties) {
        String result = null;
        try (FileInputStream file = new FileInputStream(configFile)){
            Properties pop = new Properties();
            pop.load(file);
            
            result = pop.getProperty(key, defaultProperties);
            
            pop.clear();
            file.close();
        } catch (Exception ex) {
            Util.addErrorLog(ex);
        }
        
        return result;
    }
    
    public static Integer getIntegerProperties(String configFile, String key, String defaultProperties) {
        Integer result = null;
        
        try (FileInputStream file = new FileInputStream(configFile)){
            Properties pop = new Properties();
            pop.load(file);
            
            result = Integer.parseInt( pop.getProperty(key, defaultProperties) );
            
            pop.clear();
            file.close();
        } catch (Exception e) {
            Util.addErrorLog(e);
        }
        
        return result;
    }
}
