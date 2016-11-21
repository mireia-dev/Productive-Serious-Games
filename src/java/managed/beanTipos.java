
package managed;

import entidades.TipoActividad;
import entidades.HandPlantas;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import modelo.GestionActCent;
import modelo.GestionUsuario;

@ManagedBean(name= "tiposact")
@SessionScoped

public class beanTipos implements Serializable {
    
    private ArrayList<String> centro;
    private ArrayList<String> act;
    List<HandPlantas> listCentros;
    List<TipoActividad> listAct; 
    
    @ManagedProperty("#{gestact}")
    private GestionActCent gestion;

    public beanTipos() {
    }

    public ArrayList<String> getCentro() {
        return centro;
    }

    public void setCentro(ArrayList<String> centro) {
        this.centro = centro;
    }

    public ArrayList<String> getAct() {
        return act;
    }

    public void setAct(ArrayList<String> act) {
        this.act = act;
    }
    

    public List<HandPlantas> getListCentros() {
        listCentros = gestion.listarCentros();
        return listCentros;
    }

    public void setListCentros(List<HandPlantas> listCentros) {
        this.listCentros = listCentros;
    }

    public List<TipoActividad> getListAct() {
        return listAct;
    }

    public void setListAct(List<TipoActividad> listAct) {
        this.listAct = listAct;
    }

    public GestionActCent getGestion() {
        return gestion;
    }

    public void setGestion(GestionActCent gestion) {
        this.gestion = gestion;
    }
   
}
