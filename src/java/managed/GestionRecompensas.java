package managed;

import entidades.Recompensas;
import java.util.List;

public interface GestionRecompensas {
    boolean altaRecompensas(Recompensas recom);
    List<Recompensas> obtenerRecompensas();  
}
