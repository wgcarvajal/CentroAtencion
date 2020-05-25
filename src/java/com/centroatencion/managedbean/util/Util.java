/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.managedbean.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Wilson Carvajal
 */
public class Util {
    
    public static String formatText(String value)
    {
        value = value.trim();
        value = value.substring(0, 1).toUpperCase() + value.substring(1).toLowerCase();
        return value;
        
    }
    
    public static String formatDate(Date date)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }
    
    public static String getAnio(Date date)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
        return dateFormat.format(date);
    }
    
}
