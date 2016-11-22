package managed;

import modelo.MedallasUsu;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import entidades.MedallasusuRetos;
import entidades.Retos;


@ManagedBean (name= "gestionMedallas")
@SessionScoped
public class gestionMedalla implements Serializable{
  
   private String nombre_medalla;
   private List<String> nombre_reto;
   private String valorMin;
   private String valorMax;
   private java.sql.Date fechaMin;
   private java.sql.Date fechaMax;
   private String puntos;
    
   private MedallasusuRetos medallasreto;
   private List<Retos> listadoMedallas = null;
   
   @ManagedProperty("#{gestionmed}")
   private MedallasUsu medallasusu;
   
    public gestionMedalla(){    
    }

    public gestionMedalla(String nombre_medalla, List<String> nombre_reto, String valorMin, String valorMax, Date fechaMin, Date fechaMax, String puntos, MedallasusuRetos medallasreto, MedallasUsu medallasusu) {
        this.nombre_medalla = nombre_medalla;
        this.nombre_reto = nombre_reto;
        this.valorMin = valorMin;
        this.valorMax = valorMax;
        this.fechaMin = fechaMin;
        this.fechaMax = fechaMax;
        this.puntos = puntos;
        this.medallasreto = medallasreto;
        this.medallasusu = medallasusu;
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

    public MedallasusuRetos getMedallasreto() {
        return medallasreto;
    }

    public void setMedallasreto(MedallasusuRetos medallasreto) {
        this.medallasreto = medallasreto;
    }

    public List<Retos> getListadoMedallas() {
        return listadoMedallas;
    }

    public void setListadoMedallas(List<Retos> listadoMedallas) {
        this.listadoMedallas = listadoMedallas;
    }

    public MedallasUsu getMedallasusu() {
        return medallasusu;
    }

    public void setMedallasusu(MedallasUsu medallasusu) {
        this.medallasusu = medallasusu;
    }

      
    
    //Métodos que vienen del interfaz
    
    public String obtenerMedallasUsu(){
        medallasusu.obtenerMedallasUsu(nombre_medalla, nombre_reto, valorMin, valorMax, fechaMin, fechaMin, puntos);
        return "";
    }
    
    public String agregarMedallasUsu(){
        medallasusu.agregarMedallasUsu(medallasreto);
        return "";
    }
    
    public String modificarMedallasUsu(){
        medallasusu.modificarMedallasUsu(medallasreto);
        return "";
    }

    public String eliminarMedallasUsu(){
        medallasusu.eliminarMedallasUsu(medallasreto);
        return "";
    }
    
}

