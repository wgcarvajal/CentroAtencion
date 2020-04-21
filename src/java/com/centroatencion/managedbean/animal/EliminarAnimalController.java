/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.managedbean.animal;

import com.centroatencion.entities.Animal;
import com.centroatencion.facade.AnimalFacade;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.PrimeFaces;



@ManagedBean(name="eliminarAnimalController")
@ViewScoped
public class EliminarAnimalController implements Serializable{
    
    private Animal animalSeleccionado;
    private AnimalController animalController;
    @EJB
    private AnimalFacade animalEJB; 
    
    public EliminarAnimalController() 
    {
    }
    
    public void ventanaEliminarAnimal(Animal animalSeleccionado, AnimalController animalController)
    { 
        this.animalSeleccionado=animalSeleccionado;
        this.animalController=animalController;
        PrimeFaces pf = PrimeFaces.current();  
        pf.executeScript("PF('eliminarAnimal').show()");
    }
    
    public void eliminarAnimal()
    {
        PrimeFaces pf = PrimeFaces.current(); 
        if(this.animalSeleccionado!=null)
        {
            if(this.animalSeleccionado.getIngresoList().isEmpty())
            {
                this.animalEJB.remove(animalSeleccionado);
                animalController.updateListaAnimales();
                pf.executeScript("PF('eliminarAnimal').hide()");  
                pf.executeScript("PF('eliminacionCorrecta').show()");
            }
            else
            {
                pf.executeScript("PF('eliminarAnimal').hide()");
                pf.executeScript("PF('noSePuedeEliminar').show()");
            }
        }
    }
}
