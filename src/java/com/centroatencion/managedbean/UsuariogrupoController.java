package com.centroatencion.managedbean;

import com.centroatencion.entities.Usuariogrupo;
import com.centroatencion.managedbean.util.JsfUtil;
import com.centroatencion.managedbean.util.PaginationHelper;
import com.centroatencion.facade.UsuariogrupoFacade;

import java.io.Serializable;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@Named("usuariogrupoController")
@SessionScoped
public class UsuariogrupoController implements Serializable {

    private Usuariogrupo current;
    private DataModel items = null;
    @EJB
    private com.centroatencion.facade.UsuariogrupoFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public UsuariogrupoController() {
    }

    public Usuariogrupo getSelected() {
        if (current == null) {
            current = new Usuariogrupo();
            current.setUsuariogrupoPK(new com.centroatencion.entities.UsuariogrupoPK());
            selectedItemIndex = -1;
        }
        return current;
    }

    private UsuariogrupoFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (Usuariogrupo) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Usuariogrupo();
        current.setUsuariogrupoPK(new com.centroatencion.entities.UsuariogrupoPK());
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            current.getUsuariogrupoPK().setGrupoId(current.getGrupo().getGrupoid());
            current.getUsuariogrupoPK().setUsuarioId(current.getUsuario().getUsuId());
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("UsuariogrupoCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Usuariogrupo) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            current.getUsuariogrupoPK().setGrupoId(current.getGrupo().getGrupoid());
            current.getUsuariogrupoPK().setUsuarioId(current.getUsuario().getUsuId());
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("UsuariogrupoUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Usuariogrupo) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("UsuariogrupoDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public Usuariogrupo getUsuariogrupo(com.centroatencion.entities.UsuariogrupoPK id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = Usuariogrupo.class)
    public static class UsuariogrupoControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            UsuariogrupoController controller = (UsuariogrupoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "usuariogrupoController");
            return controller.getUsuariogrupo(getKey(value));
        }

        com.centroatencion.entities.UsuariogrupoPK getKey(String value) {
            com.centroatencion.entities.UsuariogrupoPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new com.centroatencion.entities.UsuariogrupoPK();
            key.setGrupoId(values[0]);
            key.setUsuarioId(Long.parseLong(values[1]));
            return key;
        }

        String getStringKey(com.centroatencion.entities.UsuariogrupoPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getGrupoId());
            sb.append(SEPARATOR);
            sb.append(value.getUsuarioId());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Usuariogrupo) {
                Usuariogrupo o = (Usuariogrupo) object;
                return getStringKey(o.getUsuariogrupoPK());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Usuariogrupo.class.getName());
            }
        }

    }

}
