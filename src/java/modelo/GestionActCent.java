
package modelo;

import entidades.TipoActividad;
import entidades.HandPlantas;
import java.util.List;

public interface GestionActCent{
    boolean persist (Object object);
   List<TipoActividad> listarActividades();
    List<HandPlantas> listarCentros();

    
    
}
