package managed;

import modelo.MedallasAlm;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import entidades.MedallasplantRetos;
import entidades.Retos;


@ManagedBean(name = "gestionMedallaAlm")
@SessionScoped
public class gestionMedallaAlm implements Serializable{
    
   private List<String> nombre_centro;
   private String nombre_medalla;
   private List<String> nombre_reto;
   private String valorMin;
   private String valorMax;
   private java.sql.Date fechaMin;
   private java.sql.Date fechaMax;
   private String puntos;

    private MedallasplantRetos medallasplantreto;
    private List<Retos> listadoMedallasAlm = null;
    
    @ManagedProperty("#{gestionmedplant}")
    MedallasAlm medallasalm;
   
    public gestionMedallaAlm() {
    }

    public gestionMedallaAlm(List<String> nombre_centro, String nombre_medalla, List<String> nombre_reto, String valorMin, String valorMax, Date fechaMin, Date fechaMax, String puntos, MedallasplantRetos medallasplantreto, MedallasAlm medallasalm) {
        this.nombre_centro = nombre_centro;
        this.nombre_medalla = nombre_medalla;
        this.nombre_reto = nombre_reto;
        this.valorMin = valorMin;
        this.valorMax = valorMax;
        this.fechaMin = fechaMin;
        this.fechaMax = fechaMax;
        this.puntos = puntos;
        this.medallasplantreto = medallasplantreto;
        this.medallasalm = medallasalm;
    }

    public List<String> getNombre_centro() {
        return nombre_centro;
    }

    public void setNombre_centro(List<String> nombre_centro) {
        this.nombre_centro = nombre_centro;
    }

    public String getNombre_medalla() {
        return nombre_medalla;
    }

    public void setNombre_medalla(String nombre_medalla) {
        this.nombre_medalla = nombre_medalla;
    }

    public List<String> getNombre_reto() {
        return nombre_reto;
    }

    public void setNombre_reto(List<String> nombre_reto) {
        this.nombre_reto = nombre_reto;
    }

    public String getValorMin() {
        return valorMin;
    }

    public void setValorMin(String valorMin) {
        this.valorMin = valorMin;
    }

    public String getValorMax() {
        return valorMax;
    }

    public void setValorMax(String valorMax) {
        this.valorMax = valorMax;
    }

    public Date getFechaMin() {
        return fechaMin;
    }

    public void setFechaMin(Date fechaMin) {
        this.fechaMin = fechaMin;
    }

    public Date getFechaMax() {
        return fechaMax;
    }

    public void setFechaMax(Date fechaMax) {
        this.fechaMax = fechaMax;
    }

    public String getPuntos() {
        return puntos;
    }

    public void setPuntos(String puntos) {
        this.puntos = puntos;
    }

    public MedallasplantRetos getMedallasplantreto() {
        return medallasplantreto;
    }

    public void setMedallasplantreto(MedallasplantRetos medallasplantreto) {
        this.medallasplantreto = medallasplantreto;
    }

    public List<Retos> getListadoMedallasAlm() {
        return listadoMedallasAlm;
    }

    public void setListadoMedallasAlm(List<Retos> listadoMedallasAlm) {
        this.listadoMedallasAlm = listadoMedallasAlm;
    }

    public MedallasAlm getMedallasalm() {
        return medallasalm;
    }

    public void setMedallasalm(MedallasAlm medallasalm) {
        this.medallasalm = medallasalm;
    }

    
    
    
    //Métodos que vienen del interfaz
    
    public String obtenerMedallasAlm(){
        medallasalm.obtenerMedallasAlm(nombre_centro, nombre_medalla, nombre_reto, valorMin, valorMax, fechaMin, fechaMax, puntos);
        return "";
    }
    public String agregarMedallasAlm(){
        medallasalm.agregarMedallasAlm(medallasplantreto);
        return "";
    }
    
    public String modificarMedallasAlm(){
        medallasalm.modificarMedallasAlm(medallasplantreto);
        return "";
    }

    public String eliminarMedallasAlm(){
        medallasalm.eliminarMedallasAlm(medallasplantreto);
        return "";
    }
}
