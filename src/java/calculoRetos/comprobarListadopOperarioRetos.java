package calculoRetos;

import beans.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import entidades.Retos;
import entidades.TrUsuarios;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class comprobarListadopOperarioRetos {

    public static void main(String[] args) {
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("P_S_GPU");
        EntityManager em = emf.createEntityManager();

        Query q = em.createNamedQuery("Retos.findAll");
        List<Retos> listaRetos = q.getResultList();
        for(Retos rts:listaRetos){
            System.out.println("++"+rts.getNombreReto().getNombreReto());
        }
        
        obtenerListados ol = new obtenerListados();
        List<TrUsuarios> listaCompleta = ol.getListaCompletaOperarios();
        List<operarioMov> listaMovimientos = ol.getListaMovimientos();
            HashMap<String,Integer> hlistaMovimientos = new HashMap<>();
            for(operarioMov mov:listaMovimientos){
                hlistaMovimientos.put(mov.getIdOperario(), mov.getMovimientos());
            }
            System.out.println("Tamaño HlistaMovimientos: "+hlistaMovimientos.size());
        List<operarioDias> listaCompromiso = ol.getListaCompromiso();
            HashMap<String,operarioDias> hlistaCompromiso = new HashMap<>();
            for(operarioDias dias:listaCompromiso){
                hlistaCompromiso.put(dias.getIdOperario(), dias);
            }
            System.out.println("Tamaño HlistaCompromiso: "+hlistaCompromiso.size());
        List<operarioHoras> listaHorasExtra = ol.getListaHorasExtra();
            HashMap<String,Double> hlistaHorasExtra = new HashMap<>();
            for(operarioHoras oh:listaHorasExtra){
                hlistaHorasExtra.put(oh.getIdOperario(), oh.getHorasExtra());
            }
            System.out.println("Tamaño HlistaMovimientos: "+hlistaMovimientos.size());
        List<operarioDesvios> listaDesvios = ol.getDesvios();
            HashMap<String,operarioDesvios> hlistaDesvios = new HashMap<>();
            for(operarioDesvios od:listaDesvios){
                hlistaDesvios.put(od.getIdOperario(), od);
            }
            System.out.println("Tamaño HlistaDesvios: "+hlistaDesvios.size());
        //Hashmap a rellenar
        HashMap<String,List<beanRetos>> hlistaOpRetos = new HashMap<>();
        //List<beanRetos> retosOpe = new ArrayList<>();
        /*for(TrUsuarios uaux:listaCompleta){
            hlistaOpRetos.put(uaux.getUsuIdusuario(), retosOpe);
        }*/
        //System.out.println(hlistaOpRetos.keySet().toString());
        
        for(TrUsuarios tru:listaCompleta){
            List<beanRetos> retosOpe = new ArrayList<>();
            //hlistaOpRetos.put(tru.getUsuIdusuario(), retosOpe);
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
                    retosOpe.add(new beanRetos(rt.getIdretos(), puntuacionOp, porcentaje));
                    //break;
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
                    retosOpe.add(new beanRetos(rt.getIdretos(), puntuacionOp, porcentaje));
                    //break;
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
                    retosOpe.add(new beanRetos(rt.getIdretos(), horasextra, porcentaje));
                    //break;
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
                    retosOpe.add(new beanRetos(rt.getIdretos(), puntuacionOp, porcentaje));
                }
            }
            hlistaOpRetos.put(tru.getUsuIdusuario(), retosOpe);
            //retosOpe.clear();
            //System.out.println(retosOpe.toString());
        }
        System.out.println("tamaño listaOperariosRetos :"+hlistaOpRetos.keySet().size());
        List<beanRetos> bretos = hlistaOpRetos.get("TOL-036");
        System.out.println("tamaño listadoretos op[1]: "+bretos.size()+" "+hlistaOpRetos.containsKey("TOL-036"));
        
        for(Map.Entry<String,List<beanRetos>> linea:hlistaOpRetos.entrySet()){
            List<beanRetos> bret = linea.getValue();
            String oper = linea.getKey();
            //System.out.println(bret.size());
            for(beanRetos br:bret){
                if((br.getIDreto() == 1 || br.getIDreto() == 3) && br.getPuntuacionOp()>0){
                    System.out.println(oper+" ID: "+br.getIDreto()+" Puntuación:"
                        +br.getPuntuacionOp()+" Porcentaje:"+br.getPorcentaje()); 
                }
                
            }
        }
        /*
        for(Map.Entry<String,List<beanRetos>> linea:hlistaOpRetos.entrySet()){
            List<beanRetos> bret = linea.getValue();
            String oper = linea.getKey();
            //System.out.println(bret.size());
            for(beanRetos br:bret){
                System.out.println(oper+" ID: "+br.getIDreto()+" Puntuación:"
                        +br.getPuntuacionOp()+" Porcentaje:"+br.getPorcentaje());
            }
        }*/
        /*Set<String> llaves = hlistaOpRetos.keySet();
        for(String ll:llaves){
            System.out.println("**"+ll);
        }*/
    }
    
}
