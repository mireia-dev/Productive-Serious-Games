/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managed;

import beans.beanRetos;
import calculoRetos.listadoOperarioRetos;
import java.util.HashMap;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Mireia
 */
@ManagedBean
@SessionScoped
public class GestionCalculo {

    private listadoOperarioRetos listaOpRetos;
    private HashMap<String,List<beanRetos>> hRetos;
    private List<beanRetos> listaRetoUs;
            
    public GestionCalculo() {
    }

    public GestionCalculo(listadoOperarioRetos listaOpRetos, HashMap<String, List<beanRetos>> hRetos, List<beanRetos> listaRetoUs) {
        this.listaOpRetos = listaOpRetos;
        this.hRetos = hRetos;
        this.listaRetoUs = listaRetoUs;
    }

    public listadoOperarioRetos getListaOpRetos() {
        return listaOpRetos;
    }

    public void setListaOpRetos(listadoOperarioRetos listaOpRetos) {
        this.listaOpRetos = listaOpRetos;
    }

    public HashMap<String, List<beanRetos>> gethRetos() {
        return hRetos;
    }

    public void sethRetos(HashMap<String, List<beanRetos>> hRetos) {
        this.hRetos = hRetos;
    }

    public List<beanRetos> getListaRetoUs() {
        return listaRetoUs;
    }

    public void setListaRetoUs(List<beanRetos> listaRetoUs) {
        this.listaRetoUs = listaRetoUs;
    }
    public void recuperarHashM(){
        listadoOperarioRetos lor = listaOpRetos;
        this.hRetos = lor.obtenerOperariosRetos();
    }
    public List<beanRetos> recuperarRetos(){
        beanLogin bl = new beanLogin();
        String usuario = bl.getUsuario();
        return hRetos.get(usuario);
    }
}
