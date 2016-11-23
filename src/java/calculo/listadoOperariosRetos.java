package calculo;

import beans.beanRetos;
import beans.operarioDesvios;
import beans.operarioDias;
import beans.operarioHoras;
import beans.operarioMov;
import entidades.Retos;
import entidades.TrUsuarios;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class listadoOperariosRetos {
        
//Método para obtener todos los retos de todos los usuarios
    public HashMap<String,List<beanRetos>> obtenerOperariosRetos(){
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("Psg2PU");
        EntityManager em = emf.createEntityManager();

        Query q = em.createNamedQuery("Retos.findAll");
        List<Retos> listaRetos = q.getResultList();
        
        obtenerTodasListas ol = new obtenerTodasListas();
        List<TrUsuarios> listaCompleta = ol.getListaCompletaOperarios();
        List<operarioMov> listaMovimientos = ol.getListaMovimientos();
            HashMap<String,Integer> hlistaMovimientos = new HashMap<>();
            for(operarioMov mov:listaMovimientos){
                hlistaMovimientos.put(mov.getIdOperario(), mov.getMovimientos());
            }
        List<operarioDias> listaCompromiso = ol.getListaCompromiso();
            HashMap<String,operarioDias> hlistaCompromiso = new HashMap<>();
            for(operarioDias dias:listaCompromiso){
                hlistaCompromiso.put(dias.getIdOperario(), dias);
            }
        List<operarioHoras> listaHorasExtra = ol.getListaHorasExtra();
            HashMap<String,Double> hlistaHorasExtra = new HashMap<>();
            for(operarioHoras oh:listaHorasExtra){
                hlistaHorasExtra.put(oh.getIdOperario(), oh.getHorasExtra());
            }
        List<operarioDesvios> listaDesvios = ol.getDesvios();
            HashMap<String,operarioDesvios> hlistaDesvios = new HashMap<>();
            for(operarioDesvios od:listaDesvios){
                hlistaDesvios.put(od.getIdOperario(), od);
            }
        //Hashmap a rellenar
        HashMap<String,List<beanRetos>> hlistaOpRetos = new HashMap<>();
        
        for(TrUsuarios tru:listaCompleta){
            List<beanRetos> retosOpe = new ArrayList<>();
            int min = 0;
            int max = 0;
            double puntuacionOp = 0;
            double porcentaje = 0;
            
            for(Retos rt:listaRetos){
                //ID 1 3
                if(rt.getNombreReto().getNombreReto().equals("Movimientos") || rt.getNombreReto().getNombreReto().equals("Experiencia")){
                    min = rt.getNivelMin();
                    max = rt.getNivelMax();
                    if(!hlistaMovimientos.containsKey(tru.getUsuIdusuario())){
                        puntuacionOp = 0;
                    }else{
                        puntuacionOp = hlistaMovimientos.get(tru.getUsuIdusuario());                        
                    }
                    porcentaje = 100.0*(puntuacionOp-min)/(max-min);
                    if(porcentaje<0){porcentaje=0;}
                    if(porcentaje>100){porcentaje=100;}
                    retosOpe.add(new beanRetos(rt.getIdretos(), puntuacionOp, porcentaje, rt.getUrlLogo()));
                }
                //ID 2
                if(rt.getNombreReto().getNombreReto().equals("Compromiso")){
                    min = 0;
                    max = 0;
                    operarioDias od = hlistaCompromiso.get(tru.getUsuIdusuario());
                    porcentaje = od.getPorcentaje();
                    if(porcentaje<0){porcentaje=0;}
                    if(porcentaje>100){porcentaje=100;}
                    puntuacionOp = od.getDias();
                    retosOpe.add(new beanRetos(rt.getIdretos(), puntuacionOp, porcentaje, rt.getUrlLogo()));
                }
                //ID 4
                if(rt.getNombreReto().getNombreReto().equals("Horas extra")){
                    double horasextra = 0;
                    porcentaje = 0;
                    if(hlistaHorasExtra.containsKey(tru.getUsuIdusuario())){
                        horasextra = hlistaHorasExtra.get(tru.getUsuIdusuario());
                        porcentaje = 100.0*horasextra/rt.getNivelMax();
                        if(porcentaje<0){porcentaje=0;}
                        if(porcentaje>100){porcentaje=100;}
                    }
                    retosOpe.add(new beanRetos(rt.getIdretos(), horasextra, porcentaje, rt.getUrlLogo()));
                }
                //ID 5
                if(rt.getNombreReto().getNombreReto().equals("Desvíos Temporales")){
                    if(hlistaDesvios.containsKey(tru.getUsuIdusuario())){
                        puntuacionOp = hlistaDesvios.get(tru.getUsuIdusuario()).getDesviosOK();
                        porcentaje = hlistaDesvios.get(tru.getUsuIdusuario()).getPorcentaje();
                        if(porcentaje<0){porcentaje=0;}
                        if(porcentaje>100){porcentaje=100;}
                    }else{
                        puntuacionOp = 0;
                        porcentaje = 0;
                    }
                    retosOpe.add(new beanRetos(rt.getIdretos(), puntuacionOp, porcentaje, rt.getUrlLogo()));
                }
            }
            hlistaOpRetos.put(tru.getUsuIdusuario(), retosOpe);
        }
        return hlistaOpRetos;
    }
}
