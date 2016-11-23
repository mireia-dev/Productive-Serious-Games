package modelo;


import entidades.Retos;
import entidades.NombreRetos;
import java.util.List;

public interface GestionRetos {
    
    List<Retos> ObtenerRetos(String nombre_reto,  
            String nivel_max,
            String nivel_min,
            java.sql.Date fecha_inicio,
            java.sql.Date fecha_final,
            String url_logo); //antes ponia obeterRetos y vacío, ahroa ponemos como Hugo todos los parámetros de la entidad
    
    boolean altaRetos(Retos r);
    String eliminarReto(Retos r); //sabemos que es mejor boolean pero nos daba error en las otras capas
    String modificarReto(Retos r);    
    
}
