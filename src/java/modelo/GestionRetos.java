package modelo;


import entidades.Retos;
import java.util.List;

public interface GestionRetos {
    boolean altaRetos(Retos r);
    List<Retos> obtenerRetos();
    void eliminarReto();
    void modificarReto(Retos r);    
    
}
