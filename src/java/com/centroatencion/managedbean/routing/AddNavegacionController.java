/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroatencion.managedbean.routing;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author edwin
 */
@Named("addNavegacionController")
@SessionScoped
public class AddNavegacionController implements Serializable {

    private MenuModel menuNavegacion = new DefaultMenuModel();

    public MenuModel getRuta() {
        return menuNavegacion;
    }
    

    public AddNavegacionController() {
        this.menuNavegacion = new DefaultMenuModel();
        DefaultMenuItem index = new DefaultMenuItem();
        index.setValue("Index");
        this.menuNavegacion.addElement(index);
    }

    public void addHome()
    {
        this.menuNavegacion = new DefaultMenuModel();
        DefaultMenuItem index = new DefaultMenuItem();
        index.setValue("Index");
        this.menuNavegacion.addElement(index);
    }
    
    public void addNotificacions() {
        this.menuNavegacion = new DefaultMenuModel();
        DefaultMenuItem index = new DefaultMenuItem();
        index.setValue("Index");

        DefaultMenuItem notificacion = new DefaultMenuItem();
        notificacion.setValue("Notificaciones");

        this.menuNavegacion.addElement(index);
        this.menuNavegacion.addElement(notificacion);

    }
    
    public void addNotificacion() {
        this.menuNavegacion = new DefaultMenuModel();
        DefaultMenuItem index = new DefaultMenuItem();
        index.setValue("Index");

        DefaultMenuItem notificacions = new DefaultMenuItem();
        notificacions.setValue("Notificaciones");
        
        DefaultMenuItem notificacion = new DefaultMenuItem();
        notificacion.setValue("Notificación");
        
        

        this.menuNavegacion.addElement(index);
        this.menuNavegacion.addElement(notificacions);
        this.menuNavegacion.addElement(notificacion);

    }

    public void addDepartamentos() {
        this.menuNavegacion = new DefaultMenuModel();
        DefaultMenuItem index = new DefaultMenuItem();
        index.setValue("Index");
        index.setAjax(false);
        index.setCommand("#{routingController.goToHome(addNavegacionController)}");
       
        
        DefaultMenuItem gestionTerritorial = new DefaultMenuItem();
        gestionTerritorial.setValue("Gestión territorial");
        
        DefaultMenuItem departamentos = new DefaultMenuItem();
        departamentos.setValue("Departamentos");
        
        this.menuNavegacion.addElement(index);
        this.menuNavegacion.addElement(gestionTerritorial);
        this.menuNavegacion.addElement(departamentos);

    }
    
    public void addDireccionTerritorial() {
        this.menuNavegacion = new DefaultMenuModel();
        DefaultMenuItem index = new DefaultMenuItem();
        index.setValue("Index");
        index.setAjax(false);
        index.setCommand("#{routingController.goToHome(addNavegacionController)}");
       
        
        DefaultMenuItem gestionEntidades = new DefaultMenuItem();
        gestionEntidades.setValue("Gestión entidades");
        
        DefaultMenuItem direccionTerritorial = new DefaultMenuItem();
        direccionTerritorial.setValue("Dirección Territorial");
        
        this.menuNavegacion.addElement(index);
        this.menuNavegacion.addElement(gestionEntidades);
        this.menuNavegacion.addElement(direccionTerritorial);

    }
    
    public void addPersonas() {
        this.menuNavegacion = new DefaultMenuModel();
        DefaultMenuItem index = new DefaultMenuItem();
        index.setValue("Index");
        index.setAjax(false);
        index.setCommand("#{routingController.goToHome(addNavegacionController)}");
       
        
        DefaultMenuItem gestionPersonas = new DefaultMenuItem();
        gestionPersonas.setValue("Gestión Personas");
        
        DefaultMenuItem personas = new DefaultMenuItem();
        personas.setValue("Personas");
        
        this.menuNavegacion.addElement(index);
        this.menuNavegacion.addElement(gestionPersonas);
        this.menuNavegacion.addElement(personas);

    }
    
    public void addOrden() {
        this.menuNavegacion = new DefaultMenuModel();
        DefaultMenuItem index = new DefaultMenuItem();
        index.setValue("Index");
        index.setAjax(false);
        index.setCommand("#{routingController.goToHome(addNavegacionController)}");
       
        
        DefaultMenuItem gestionTerritorial = new DefaultMenuItem();
        gestionTerritorial.setValue("Gestión Animal");
        
        DefaultMenuItem departamentos = new DefaultMenuItem();
        departamentos.setValue("Orden");
        
        this.menuNavegacion.addElement(index);
        this.menuNavegacion.addElement(gestionTerritorial);
        this.menuNavegacion.addElement(departamentos);

    }
    
    public void addMunicipios() {
        this.menuNavegacion = new DefaultMenuModel();
        DefaultMenuItem index = new DefaultMenuItem();
        index.setValue("Index");
        index.setAjax(false);
        index.setCommand("#{routingController.goToHome(addNavegacionController)}");
       
        
        DefaultMenuItem gestionTerritorial = new DefaultMenuItem();
        gestionTerritorial.setValue("Gestión territorial");
        
        DefaultMenuItem departamentos = new DefaultMenuItem();
        departamentos.setValue("Municipios");
        
        this.menuNavegacion.addElement(index);
        this.menuNavegacion.addElement(gestionTerritorial);
        this.menuNavegacion.addElement(departamentos);

    }
    
    public void addEntidades() {
        this.menuNavegacion = new DefaultMenuModel();
        DefaultMenuItem index = new DefaultMenuItem();
        index.setValue("Index");
        index.setAjax(false);
        index.setCommand("#{routingController.goToHome(addNavegacionController)}");
       
        
        DefaultMenuItem gestionEntidades = new DefaultMenuItem();
        gestionEntidades.setValue("Gestión Entidades");
        
        DefaultMenuItem entidades = new DefaultMenuItem();
        entidades.setValue("Entidades");
        
        this.menuNavegacion.addElement(index);
        this.menuNavegacion.addElement(gestionEntidades);
        this.menuNavegacion.addElement(entidades);

    }
    
    public void addEntidad() {
        this.menuNavegacion = new DefaultMenuModel();
        DefaultMenuItem index = new DefaultMenuItem();
        index.setValue("Index");
        index.setAjax(false);
        index.setCommand("#{routingController.goToHome(addNavegacionController)}");
       
        
        DefaultMenuItem gestionEntidades = new DefaultMenuItem();
        gestionEntidades.setValue("Gestión Entidades");
        
        DefaultMenuItem entidades = new DefaultMenuItem();
        entidades.setValue("Entidades");
        entidades.setAjax(false);
        entidades.setCommand("#{routingController.goToEntidades(addNavegacionController)}");
        
        DefaultMenuItem entidad = new DefaultMenuItem();
        entidad.setValue("Entidad");
        
        this.menuNavegacion.addElement(index);
        this.menuNavegacion.addElement(gestionEntidades);
        this.menuNavegacion.addElement(entidades);
        this.menuNavegacion.addElement(entidad);

    }
    
    public void addTipoZonas() {
        this.menuNavegacion = new DefaultMenuModel();
        DefaultMenuItem index = new DefaultMenuItem();
        index.setValue("Index");
        index.setAjax(false);
        index.setCommand("#{routingController.goToHome(addNavegacionController)}");
       
        
        DefaultMenuItem gestionEntidades = new DefaultMenuItem();
        gestionEntidades.setValue("Gestión Entidades");
        
        DefaultMenuItem tipozonas = new DefaultMenuItem();
        tipozonas.setValue("zonas");
        
        this.menuNavegacion.addElement(index);
        this.menuNavegacion.addElement(gestionEntidades);
        this.menuNavegacion.addElement(tipozonas);

    }
    
    public void addFamilias() {
        this.menuNavegacion = new DefaultMenuModel();
        DefaultMenuItem index = new DefaultMenuItem();
        index.setValue("Index");
        index.setAjax(false);
        index.setCommand("#{routingController.goToHome(addNavegacionController)}");
       
        
        DefaultMenuItem gestionTerritorial = new DefaultMenuItem();
        gestionTerritorial.setValue("Gestión animal");
        
        DefaultMenuItem departamentos = new DefaultMenuItem();
        departamentos.setValue("familias");
        
        this.menuNavegacion.addElement(index);
        this.menuNavegacion.addElement(gestionTerritorial);
        this.menuNavegacion.addElement(departamentos);

    }
    
    public void addVeredas() {
        this.menuNavegacion = new DefaultMenuModel();
        DefaultMenuItem index = new DefaultMenuItem();
        index.setValue("Index");
        index.setAjax(false);
        index.setCommand("#{routingController.goToHome(addNavegacionController)}");
       
        
        DefaultMenuItem gestionTerritorial = new DefaultMenuItem();
        gestionTerritorial.setValue("Gestión territorial");
        
        DefaultMenuItem departamentos = new DefaultMenuItem();
        departamentos.setValue("Veredas");
        
        this.menuNavegacion.addElement(index);
        this.menuNavegacion.addElement(gestionTerritorial);
        this.menuNavegacion.addElement(departamentos);

    }
    
    public void addAnimal() {
        this.menuNavegacion = new DefaultMenuModel();
        DefaultMenuItem index = new DefaultMenuItem();
        index.setValue("Index");
        index.setAjax(false);
        index.setCommand("#{routingController.goToHome(addNavegacionController)}");
       
        
        DefaultMenuItem gestionTerritorial = new DefaultMenuItem();
        gestionTerritorial.setValue("Gestión animal");
        
        DefaultMenuItem departamentos = new DefaultMenuItem();
        departamentos.setValue("animales");
        
        this.menuNavegacion.addElement(index);
        this.menuNavegacion.addElement(gestionTerritorial);
        this.menuNavegacion.addElement(departamentos);

    }
    
    public void addGrupoTaxonomico() {
        this.menuNavegacion = new DefaultMenuModel();
        DefaultMenuItem index = new DefaultMenuItem();
        index.setValue("Index");
        index.setAjax(false);
        index.setCommand("#{routingController.goToHome(addNavegacionController)}");
       
        
        DefaultMenuItem gestionTerritorial = new DefaultMenuItem();
        gestionTerritorial.setValue("Gestión animal");
        
        DefaultMenuItem departamentos = new DefaultMenuItem();
        departamentos.setValue("Grupo taxonomico");
        
        this.menuNavegacion.addElement(index);
        this.menuNavegacion.addElement(gestionTerritorial);
        this.menuNavegacion.addElement(departamentos);

    }
    
    public void addEspecies() {
        this.menuNavegacion = new DefaultMenuModel();
        DefaultMenuItem index = new DefaultMenuItem();
        index.setValue("Index");
        index.setAjax(false);
        index.setCommand("#{routingController.goToHome(addNavegacionController)}");
       
        
        DefaultMenuItem gestionTerritorial = new DefaultMenuItem();
        gestionTerritorial.setValue("Gestión animal");
        
        DefaultMenuItem departamentos = new DefaultMenuItem();
        departamentos.setValue("Especies");
        
        this.menuNavegacion.addElement(index);
        this.menuNavegacion.addElement(gestionTerritorial);
        this.menuNavegacion.addElement(departamentos);

    }
    
    public void addIngresos() {
        this.menuNavegacion = new DefaultMenuModel();
        DefaultMenuItem index = new DefaultMenuItem();
        index.setValue("Index");
        index.setAjax(false);
        index.setCommand("#{routingController.goToHome(addNavegacionController)}");
       
        
        DefaultMenuItem ingresos = new DefaultMenuItem();
        ingresos.setValue("Ingresos");
        this.menuNavegacion.addElement(index);
        this.menuNavegacion.addElement(ingresos);

    }

    public void addGestionarPlcTu() {
        this.menuNavegacion = new DefaultMenuModel();
        DefaultMenuItem index = new DefaultMenuItem();
        index.setValue("Index");
        DefaultMenuItem gestionDispositivos = new DefaultMenuItem();
        gestionDispositivos.setValue("Gestión de dispositivos");

        DefaultMenuItem dispositivoPLC_TU = new DefaultMenuItem();
        dispositivoPLC_TU.setValue("Dispositivos PLC_TU");

        DefaultMenuItem registroPLC_TU = new DefaultMenuItem();
        registroPLC_TU.setValue("Gestionar PLC_TU");

        this.menuNavegacion.addElement(index);
        this.menuNavegacion.addElement(gestionDispositivos);
        this.menuNavegacion.addElement(dispositivoPLC_TU);
        this.menuNavegacion.addElement(registroPLC_TU);

    }

    public void addRegistrarPlcMc() {
        this.menuNavegacion = new DefaultMenuModel();
        DefaultMenuItem index = new DefaultMenuItem();
        index.setValue("Index");
        DefaultMenuItem gestionDispositivos = new DefaultMenuItem();
        gestionDispositivos.setValue("Gestión de dispositivos");

        DefaultMenuItem dispositivoPLC_MC = new DefaultMenuItem();
        dispositivoPLC_MC.setValue("Dispositivos PLC_MC");

        DefaultMenuItem registroPLC_MC = new DefaultMenuItem();
        registroPLC_MC.setValue("Registrar PLC_MC");

        this.menuNavegacion.addElement(index);
        this.menuNavegacion.addElement(gestionDispositivos);
        this.menuNavegacion.addElement(dispositivoPLC_MC);
        this.menuNavegacion.addElement(registroPLC_MC);

    }

    public void addGestionarPlcMc() {
        this.menuNavegacion = new DefaultMenuModel();
        DefaultMenuItem index = new DefaultMenuItem();
        index.setValue("Index");
        DefaultMenuItem gestionDispositivos = new DefaultMenuItem();
        gestionDispositivos.setValue("Gestión de dispositivos");

        DefaultMenuItem dispositivoPLC_MC = new DefaultMenuItem();
        dispositivoPLC_MC.setValue("Dispositivos PLC_MC");

        DefaultMenuItem registroPLC_MC = new DefaultMenuItem();
        registroPLC_MC.setValue("Gestionar PLC_MC");

        this.menuNavegacion.addElement(index);
        this.menuNavegacion.addElement(gestionDispositivos);
        this.menuNavegacion.addElement(dispositivoPLC_MC);
        this.menuNavegacion.addElement(registroPLC_MC);

    }

    public void addRegistrarPlcMms() {
        this.menuNavegacion = new DefaultMenuModel();
        DefaultMenuItem index = new DefaultMenuItem();
        index.setValue("Index");
        DefaultMenuItem gestionDispositivos = new DefaultMenuItem();
        gestionDispositivos.setValue("Gestión de dispositivos");

        DefaultMenuItem dispositivoPLC_MMS = new DefaultMenuItem();
        dispositivoPLC_MMS.setValue("Dispositivos PLC_MMS");

        DefaultMenuItem registroPLC_MMS = new DefaultMenuItem();
        registroPLC_MMS.setValue("Registrar PLC_MMS");

        this.menuNavegacion.addElement(index);
        this.menuNavegacion.addElement(gestionDispositivos);
        this.menuNavegacion.addElement(dispositivoPLC_MMS);
        this.menuNavegacion.addElement(registroPLC_MMS);

    }

    public void addGestionarPlcMms() {
        this.menuNavegacion = new DefaultMenuModel();
        DefaultMenuItem index = new DefaultMenuItem();
        index.setValue("Index");
        DefaultMenuItem gestionDispositivos = new DefaultMenuItem();
        gestionDispositivos.setValue("Gestión de dispositivos");

        DefaultMenuItem dispositivoPLC_MMS = new DefaultMenuItem();
        dispositivoPLC_MMS.setValue("Dispositivos PLC_MMS");

        DefaultMenuItem registroPLC_MMS = new DefaultMenuItem();
        registroPLC_MMS.setValue("Gestionar PLC_MMS");

        this.menuNavegacion.addElement(index);
        this.menuNavegacion.addElement(gestionDispositivos);
        this.menuNavegacion.addElement(dispositivoPLC_MMS);
        this.menuNavegacion.addElement(registroPLC_MMS);

    }

    public void addGestionAmarreCliente() {
        this.menuNavegacion = new DefaultMenuModel();
        DefaultMenuItem index = new DefaultMenuItem();
        index.setValue("Index");
        DefaultMenuItem gestionAmarre = new DefaultMenuItem();
        gestionAmarre.setValue("Gestión de amarres");

        DefaultMenuItem porCliente = new DefaultMenuItem();
        porCliente.setValue("Por cliente");

        this.menuNavegacion.addElement(index);
        this.menuNavegacion.addElement(gestionAmarre);
        this.menuNavegacion.addElement(porCliente);

    }

    public void addGestionAmarreTrafo() {
        this.menuNavegacion = new DefaultMenuModel();
        DefaultMenuItem index = new DefaultMenuItem();
        index.setValue("Index");
        DefaultMenuItem gestionAmarre = new DefaultMenuItem();
        gestionAmarre.setValue("Gestión de amarres");

        DefaultMenuItem porTrafo = new DefaultMenuItem();
        porTrafo.setValue("Por trafo");

        this.menuNavegacion.addElement(index);
        this.menuNavegacion.addElement(gestionAmarre);
        this.menuNavegacion.addElement(porTrafo);

    }

    public void addGestionConsumoCliente() {
        this.menuNavegacion = new DefaultMenuModel();
        DefaultMenuItem index = new DefaultMenuItem();
        index.setValue("Index");
        DefaultMenuItem gestionConsumo = new DefaultMenuItem();
        gestionConsumo.setValue("Gestión de consumo");

        DefaultMenuItem porCliente = new DefaultMenuItem();
        porCliente.setValue("Consumo por cliente");

        this.menuNavegacion.addElement(index);
        this.menuNavegacion.addElement(gestionConsumo);
        this.menuNavegacion.addElement(porCliente);

    }

    public void addGestionConsumoMacro() {
        this.menuNavegacion = new DefaultMenuModel();
        DefaultMenuItem index = new DefaultMenuItem();
        index.setValue("Index");
        DefaultMenuItem gestionConsumo = new DefaultMenuItem();
        gestionConsumo.setValue("Gestión de consumo");

        DefaultMenuItem porMacro = new DefaultMenuItem();
        porMacro.setValue("Consumo por macromedidor");

        this.menuNavegacion.addElement(index);
        this.menuNavegacion.addElement(gestionConsumo);
        this.menuNavegacion.addElement(porMacro);

    }

    public void addVincularProductoPlcTu() {
        this.menuNavegacion = new DefaultMenuModel();
        DefaultMenuItem index = new DefaultMenuItem();
        index.setValue("Index");
        DefaultMenuItem gestionDispositivos = new DefaultMenuItem();
        gestionDispositivos.setValue("Gestión de dispositivos");

        DefaultMenuItem vincular = new DefaultMenuItem();
        vincular.setValue("Vincular");

        DefaultMenuItem productoPlcTu = new DefaultMenuItem();
        productoPlcTu.setValue("Vincular producto a PLC_TU");

        this.menuNavegacion.addElement(index);
        this.menuNavegacion.addElement(gestionDispositivos);
        this.menuNavegacion.addElement(vincular);
        this.menuNavegacion.addElement(productoPlcTu);
    }

    public void addVincularPlcMmsTrafo() {
        this.menuNavegacion = new DefaultMenuModel();
        DefaultMenuItem index = new DefaultMenuItem();
        index.setValue("Index");
        DefaultMenuItem gestionDispositivos = new DefaultMenuItem();
        gestionDispositivos.setValue("Gestión de dispositivos");

        DefaultMenuItem vincular = new DefaultMenuItem();
        vincular.setValue("Vincular");

        DefaultMenuItem PlcMmsTrafo = new DefaultMenuItem();
        PlcMmsTrafo.setValue("Vincular PLC_MMS a Trafo");

        this.menuNavegacion.addElement(index);
        this.menuNavegacion.addElement(gestionDispositivos);
        this.menuNavegacion.addElement(vincular);
        this.menuNavegacion.addElement(PlcMmsTrafo);
    }

    public void addVincularPlcMcProductos() {
        this.menuNavegacion = new DefaultMenuModel();
        DefaultMenuItem index = new DefaultMenuItem();
        index.setValue("Index");
        DefaultMenuItem gestionDispositivos = new DefaultMenuItem();
        gestionDispositivos.setValue("Gestión de dispositivos");

        DefaultMenuItem vincular = new DefaultMenuItem();
        vincular.setValue("Vincular");

        DefaultMenuItem PlcMcProdcutos = new DefaultMenuItem();
        PlcMcProdcutos.setValue("Vincular PLC_MC a varios productos");

        this.menuNavegacion.addElement(index);
        this.menuNavegacion.addElement(gestionDispositivos);
        this.menuNavegacion.addElement(vincular);
        this.menuNavegacion.addElement(PlcMcProdcutos);
    }

    public void addGestionSolicitudEstadoClientes() {
        this.menuNavegacion = new DefaultMenuModel();
        DefaultMenuItem index = new DefaultMenuItem();
        index.setValue("Index");
        DefaultMenuItem gestionSolicitudes = new DefaultMenuItem();
        gestionSolicitudes.setValue("Gestión solicitudes");

        DefaultMenuItem solicitud = new DefaultMenuItem();
        solicitud.setValue("Estado de amarre clientes en un trafo");

        this.menuNavegacion.addElement(index);
        this.menuNavegacion.addElement(gestionSolicitudes);
        this.menuNavegacion.addElement(solicitud);
    }

    public void addGestionSolicitudEstadoCliente() {
        this.menuNavegacion = new DefaultMenuModel();
        DefaultMenuItem index = new DefaultMenuItem();
        index.setValue("Index");
        DefaultMenuItem gestionSolicitudes = new DefaultMenuItem();
        gestionSolicitudes.setValue("Gestión solicitudes");

        DefaultMenuItem solicitud = new DefaultMenuItem();
        solicitud.setValue("Estado de amarre y consumo de un cliente");

        this.menuNavegacion.addElement(index);
        this.menuNavegacion.addElement(gestionSolicitudes);
        this.menuNavegacion.addElement(solicitud);
    }

    public void addGestionSolicitudSupension() {
        this.menuNavegacion = new DefaultMenuModel();
        DefaultMenuItem index = new DefaultMenuItem();
        index.setValue("Index");
        DefaultMenuItem gestionSolicitudes = new DefaultMenuItem();
        gestionSolicitudes.setValue("Gestión solicitudes");

        DefaultMenuItem solicitud = new DefaultMenuItem();
        solicitud.setValue("Suspención de servicio a cliente");

        this.menuNavegacion.addElement(index);
        this.menuNavegacion.addElement(gestionSolicitudes);
        this.menuNavegacion.addElement(solicitud);
    }

    public void addGestionSolicitudReconexion() {
        this.menuNavegacion = new DefaultMenuModel();
        DefaultMenuItem index = new DefaultMenuItem();
        index.setValue("Index");
        DefaultMenuItem gestionSolicitudes = new DefaultMenuItem();
        gestionSolicitudes.setValue("Gestión solicitudes");

        DefaultMenuItem solicitud = new DefaultMenuItem();
        solicitud.setValue("Reconexión de servicio a cliente");

        this.menuNavegacion.addElement(index);
        this.menuNavegacion.addElement(gestionSolicitudes);
        this.menuNavegacion.addElement(solicitud);
    }
    public void addGestionSolicitudConfiguracion() {
        this.menuNavegacion = new DefaultMenuModel();
        DefaultMenuItem index = new DefaultMenuItem();
        index.setValue("Index");
        DefaultMenuItem gestionSolicitudes = new DefaultMenuItem();
        gestionSolicitudes.setValue("Gestión solicitudes");

        DefaultMenuItem solicitud = new DefaultMenuItem();
        solicitud.setValue("Configuración de parametros");

        this.menuNavegacion.addElement(index);
        this.menuNavegacion.addElement(gestionSolicitudes);
        this.menuNavegacion.addElement(solicitud);
    }
    
    public void addGestionUbicacion() {
        this.menuNavegacion = new DefaultMenuModel();
        DefaultMenuItem index = new DefaultMenuItem();
        index.setValue("Index");
        DefaultMenuItem gestionUbicacion = new DefaultMenuItem();
        gestionUbicacion.setValue("Ubicación trafos y clientes");
        DefaultMenuItem gestion = new DefaultMenuItem();
        gestion.setValue("Trafos y clientes");

        this.menuNavegacion.addElement(index);
        this.menuNavegacion.addElement(gestionUbicacion);
        this.menuNavegacion.addElement(gestion);
    }
    
    public void addGestionGeomarre() {
        this.menuNavegacion = new DefaultMenuModel();
        DefaultMenuItem index = new DefaultMenuItem();
        index.setValue("Index");
        DefaultMenuItem gestionUbicacion = new DefaultMenuItem();
        gestionUbicacion.setValue("Ubicación trafos y clientes");
        DefaultMenuItem gestion = new DefaultMenuItem();
        gestion.setValue("Geoamarre");

        this.menuNavegacion.addElement(index);
        this.menuNavegacion.addElement(gestionUbicacion);
        this.menuNavegacion.addElement(gestion);
    }
}
