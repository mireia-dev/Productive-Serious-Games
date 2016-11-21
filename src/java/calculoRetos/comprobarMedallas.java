package calculoRetos;

import beans.*;
import java.util.HashMap;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import entidades.MedallasUsuario;
import entidades.MedallasusuRetos;
import entidades.TrUsuarios;
import java.util.ArrayList;
import java.util.Map;

public class comprobarMedallas {

    public static void main(String[] args) {
    //Carga lista operarios-retos con información
        listadoOperarioRetos lor = new listadoOperarioRetos();
        HashMap<String, List<beanRetos>> hlistaOpRet = lor.obtenerOperariosRetos();
    //carga listado completo operarios
        obtenerListados ol = new obtenerListados();
        List<TrUsuarios> listaCompletaOp = ol.getListaCompletaOperarios();
    //Carga lista de medallas
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("P_S_GPU");
        EntityManager em = emf.createEntityManager();
        Query q = em.createNamedQuery("MedallasUsuario.findAll");
        List<MedallasUsuario> listaMedallasUsu = q.getResultList();
        System.out.println("tamaño listaMedallas: "+listaMedallasUsu.size());
    //Carga lista relación medallas-retos
        Query q2 = em.createNamedQuery("MedallasusuRetos.findAll");
        List<MedallasusuRetos> listaRetosMedallas = q2.getResultList();
        System.out.println("tamaño listaRetosMedallas: "+listaRetosMedallas.size());  
        
    //listado medallasRetos
        HashMap<Integer,List<Integer>> hlistaMedallasRetos = new HashMap<>();
        for(MedallasusuRetos mur:listaRetosMedallas){
            int idmed = mur.getIdmedallas().getIdmedallas();
            if(hlistaMedallasRetos.containsKey(idmed)){
                List<Integer> aux = hlistaMedallasRetos.get(idmed);
                aux.add(mur.getIdretos().getIdretos());
                hlistaMedallasRetos.replace(idmed, aux);
            }else{
                List<Integer> aux = new ArrayList<>();
                aux.add(mur.getIdretos().getIdretos());
                hlistaMedallasRetos.put(idmed, aux);
            }
        }
            System.out.println("ListaMedallasRetos size: "+hlistaMedallasRetos.size());
            List<Integer> aux3 = hlistaMedallasRetos.get(1);
            List<Integer> aux4 = hlistaMedallasRetos.get(2);
            System.out.println(aux3.toString()+aux4.toString());
        /*    
        for( hlistaMedallasRetos.entrySet()){
            
        }*/
    }
    
}
