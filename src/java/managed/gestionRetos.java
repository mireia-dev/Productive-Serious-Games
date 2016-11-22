
package managed;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import modelo.GestionRetos;
import entidades.Retos;
import java.util.List;

//todos los métodos aquí y añade las variables despúes del public class y aquí es donde se pone el List<String>Retos

@ManagedBean
@SessionScoped
public class gestionRetos {
   private Retos reto;
   private List<Retos> listadoRetos;
    
    @ManagedProperty("#{gestion}")
    GestionRetos gestion;
    
    public gestionRetos(GestionRetos gestion) {
        //this.gestion = gestion;
    }

    public gestionRetos() {
        //this.getListadoRetos();
    }

    public Retos getReto() {
        return reto;
    }

    public void setReto(Retos reto) {
        this.reto = reto;
    }
    
    public List<Retos> getListadoRetos() {
        listadoRetos = gestion.obtenerRetos( );
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
  
    public String alta(){
        gestion.altaRetos(reto);
        return "";//ponemos el nombre de la vista en que se cargaría
    }
//    public gestionRetos() {
//    }
    public String modificarReto(){
        gestion.modificarReto(reto); //falta en la vista
       return ""; 
    }
    public String eliminarReto(){//falta en la vista
        gestion.eliminarReto();
        return "";
    }
}

