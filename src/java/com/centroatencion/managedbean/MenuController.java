/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.managedbean;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Wilson Carvajal
 */
@ManagedBean(name="menuController")
@SessionScoped
public class MenuController implements Serializable{
    
    
    public String returnMenu(String nombreUsuario)
    {
        if(nombreUsuario.equals("admin"))
        {
            return "../admin/menu.xhtml";
        }
        else{
            return "../user/menu.xhtml";
        }
    }
}
