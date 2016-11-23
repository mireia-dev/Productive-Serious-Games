
package managed;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import modelo.GestionRetos;
import entidades.Retos;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import modelo.MedallasUsu;


@ManagedBean
@SessionScoped
public class gestionRetos implements Serializable{
    //  private String nombre_reto;
   private List<String> nombre_reto;
   private String nivel_min;
   private String nivel_max;
   private java.sql.Date fecha_inicio;
   private java.sql.Date fecha_fin;
   private String url_logo; //atención en impl no he puesto la url logo
    
   
   //esto es lo que teníamos nosotras, lo anterior desglosado como lo hace Hugo
   private Retos reto;   
   private List<Retos> listadoRetos;

   
    @ManagedProperty("#{gestion}")
    GestionRetos gestion;
    
    
   //De nuevo, para qué poner todos los atributos ya están en la persistencia, en la entidad retos? Lo haremos como tiene Hugo a continuación y comentado  
//Es por el filtro de búsqueda para poder así coger sólo un atributo?
//Si no te cogería el reto con todos sus atributos, y si sólo pusieras la fecha para buscar, al no rellenar el resto te pondría null, null y buscaría retos con fecha y el resto null?
    
//    public gestionRetos(GestionRetos gestion) { 
//        //this.gestion = gestion;
//    }

    public gestionRetos() {
         
    }

 
 //estos 2 Retos reto, List<Retos> listadoRetos, no los pondría porque creo q es redundante, pero bueno

    public gestionRetos(List<String> nombre_reto, String nivel_min, String nivel_max, Date fecha_inicio, Date fecha_fin, String url_logo, Retos reto, List<Retos> listadoRetos, GestionRetos gestion) {
        this.nombre_reto = nombre_reto;
        this.nivel_min = nivel_min;
        this.nivel_max = nivel_max;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.url_logo = url_logo;
        this.reto = reto;
        this.listadoRetos = listadoRetos;
        this.gestion = gestion;
    }
    
    //setter y getter de cada, mas abajo están los que hicimos nosotras

    public List<String> getNombre_reto() {
        return nombre_reto;
    }

    public void setNombre_reto(List<String> nombre_reto) {
        this.nombre_reto = nombre_reto;
    }

    public String getNivel_min() {
        return nivel_min;
    }

    public void setNivel_min(String nivel_min) {
        this.nivel_min = nivel_min;
    }

    public String getNivel_max() {
        return nivel_max;
    }

    public void setNivel_max(String nivel_max) {
        this.nivel_max = nivel_max;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getUrl_logo() {
        return url_logo;
    }

    public void setUrl_logo(String url_logo) {
        this.url_logo = url_logo;
    }
    
    
    
    //a partir de aqui lo que teníamos nosotras
    
    public Retos getReto() {
        return reto;
    }

    public void setReto(Retos reto) {
        this.reto = reto;
    }
    
    public List<Retos> getListadoRetos() {
//        listadoRetos = gestion.ListadoRetos( );//antes obtener
        return listadoRetos;//
    }

    public void setRetos(List retos) {
        this.listadoRetos = retos;
    }

    public GestionRetos getGestion() {
        return gestion;
    }

   
    public void setGestion(GestionRetos gestion) {
        this.gestion = gestion;
    }
  
    public String altaRetos(){
        gestion.altaRetos(reto);
        return "";//ponemos el nombre de la vista en que se cargaría
    }
//    public gestionRetos() {
//    }
    public String modificarReto(){
        gestion.modificarReto(reto);  
       return ""; 
    }
    public String eliminarReto(){ 
        gestion.eliminarReto(reto);//
        return "";
    }
}

