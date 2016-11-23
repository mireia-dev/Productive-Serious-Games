package calculo;

import beans.beanRetos;
import java.util.HashMap;
import java.util.List;


public class frontListaOperariosRetos {
//método para recuperar del listado completo operario-retos el listado de un solo operario
    public List<beanRetos> obtenerOperariosRetos(String operario){
        listadoOperariosRetos lor = new listadoOperariosRetos();
        HashMap<String, List<beanRetos>> listado = lor.obtenerOperariosRetos();
        List<beanRetos> lOperario = listado.get(operario);
        return lOperario;
    }
}
