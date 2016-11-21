package calculoRetos;

import beans.beanRetos;
import java.util.HashMap;
import java.util.List;

public class ejemplo {

    public static void main(String[] args) {
        listadoOperarioRetos lor = new listadoOperarioRetos();
        HashMap<String, List<beanRetos>> listado= lor.obtenerOperariosRetos();

        String operE = "TOL-055";
        
        List<beanRetos> retosOper = listado.get(operE);
        
        retosOper.forEach( x-> System.out.println("IDreto: "+x.getIDreto()+", "+x.getPorcentaje()+"%"));
    }
    
}
