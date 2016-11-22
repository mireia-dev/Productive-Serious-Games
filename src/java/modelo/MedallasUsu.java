
package modelo;


import java.util.List;
import entidades.MedallasusuRetos;
import entidades.Retos;



public interface MedallasUsu {
    List<Retos> obtenerMedallasUsu(String nombre_medalla,
            List<String> nombre_reto, 
            String valorMin,
            String valorMax,
            java.sql.Date fecha_inicio, //Las fechas sobre las que hay que operar son las de la tabla "retos"
            java.sql.Date fecha_final,
            String puntos);
    
    
    public boolean agregarMedallasUsu(MedallasusuRetos medret);
    public boolean eliminarMedallasUsu(MedallasusuRetos medret);
    public void modificarMedallasUsu(MedallasusuRetos medret);
    
}
