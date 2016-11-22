
package modelo;

import java.util.List;
import entidades.MedallasplantRetos;
import entidades.Retos;


public interface MedallasAlm {
    List<Retos> obtenerMedallasAlm(List<String> nombre_centro,
            String nombre_medalla, //almacén
            List<String> nombre_reto,           
            String valorMin,
            String valorMax,
            java.sql.Date fechaMin,
            java.sql.Date fechaMax,           
            String puntos);
    
    public boolean agregarMedallasAlm(MedallasplantRetos medplant);
    public boolean eliminarMedallasAlm(MedallasplantRetos medplant);
    public void modificarMedallasAlm(MedallasplantRetos medplant);
}
