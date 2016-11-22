package calculoRetos;

import beans.operarioDesvios;
import beans.operarioDias;
import beans.operarioHoras;
import beans.operarioMov;
import beans.operarioURL;
import entidades.HandDesviosTiempos2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import entidades.TrUsuarios;
/*
Listados:
-Operarios+URL de foto
-Movimientos
-HorasExtra
-Desvios
-Compromiso
-Listado completo de operarios, todos los campos
*/


public class obtenerListados {
    private List<TrUsuarios> listaCompleta;
            
    public List<TrUsuarios> getListaCompletaOperarios(){
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("P_S_GPU");
        EntityManager em = emf.createEntityManager();
        Query q = em.createNamedQuery("TrUsuarios.findAll");
        List<TrUsuarios> listado = q.getResultList();
        
    //Cerrar conexión
        em.close();
        emf.close();
        this.listaCompleta = listado;
        return listado;
    }
    public List<operarioURL> getListaOperariosURLfoto(){
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("P_S_GPU");
        EntityManager em = emf.createEntityManager();
        Query q = em.createNamedQuery("TrUsuarios.findAll");
        List listado = q.getResultList();
        
        List<operarioURL> listadoOp = new ArrayList<>();
        
        for(Object usu:listado){
            entidades.TrUsuarios tru = (entidades.TrUsuarios) usu;
            listadoOp.add(new operarioURL(tru.getUsuIdusuario(), tru.getUrlfotoUsuario()));
        }
            
    //Cerrar conexión
        em.close();
        emf.close();

        return listadoOp;
    }
    
    public List<operarioMov> getListaMovimientos(){
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("P_S_GPU");
        EntityManager em = emf.createEntityManager();
    //utilizando otra query que agrupa por operario
        Query q = em.createQuery("SELECT h, COUNT(h) FROM HandTiempos h WHERE h.tipoTiempo.id = :A GROUP BY h.operario");
        q.setParameter("A","A");
        List<Object[]> listado = q.getResultList();

        List<operarioMov> rankingMov = new ArrayList<>();
    //pasamos de LISTADO de objetos a list<operarioMov>    
        for(Object[] ob:listado){
            entidades.HandTiempos us = (entidades.HandTiempos) ob[0];
            operarioMov om = new operarioMov(us.getOperario().getUsuIdusuario(), Integer.parseInt(ob[1].toString()));
            rankingMov.add(om);
        }
    //Ordenación por lambda     
        rankingMov.sort((operarioMov o1, operarioMov o2) ->  o2.getMovimientos()-o1.getMovimientos());
            
    //Cerrar conexión
        em.close();
        emf.close();
        
        return rankingMov;
    }
    
    public List<operarioHoras> getListaHorasExtra(){
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("P_S_GPU");
        EntityManager em = emf.createEntityManager();

        Query q = em.createQuery("SELECT h FROM HandHrealOper h WHERE h.horasExtraCliente > 0 OR h.horasExtraKn > 0");
        List listado = q.getResultList();
          
        List<operarioHoras> rankingHorasExtra = new ArrayList<>();
        HashMap<String, Double> aux = new HashMap<>();
        
        for(int i=0; i<listado.size(); i++){
            entidades.HandHrealOper ope = (entidades.HandHrealOper) listado.get(i);
            operarioHoras ohe = new operarioHoras(ope.getTrUsuarios().getUsuIdusuario(), 
                    ope.getHorasExtraCliente().doubleValue()+ope.getHorasExtraKn().doubleValue());
            if(aux.containsKey(ohe.getIdOperario())){
                aux.replace(ohe.getIdOperario(), aux.get(ohe.getIdOperario())+ohe.getHorasExtra() );
            }else{
                aux.put(ohe.getIdOperario(), ohe.getHorasExtra());
            }
        }
       
        for(Map.Entry<String,Double> x:aux.entrySet()){
            operarioHoras op = new operarioHoras(x.getKey(), x.getValue());
            rankingHorasExtra.add(op);
        } 
        
    //ordenación
        rankingHorasExtra.sort((operarioHoras o1, operarioHoras o2) -> 
                (int) ((o2.getHorasExtra()*100)-(100*o1.getHorasExtra())));
            
    //Cerrar conexión
        em.close();
        emf.close();
        
        return rankingHorasExtra;
    }
    
    public List<operarioDesvios> getDesvios(){
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("P_S_GPU");
        EntityManager em = emf.createEntityManager();
        Query q = em.createNamedQuery("HandDesviosTiempos2.findAll");
        List listado = q.getResultList();
        
        List<operarioDesvios> aux1 = new ArrayList<>();
        List<String> operarios = new ArrayList<>();
        List<operarioDesvios> rankingDesvios = new ArrayList<>();
        
        for (Object l : listado) {
            HandDesviosTiempos2 vdes = (HandDesviosTiempos2) l;
            operarioDesvios bod = new operarioDesvios(vdes.getOperario(), vdes.getTiempoTotal(), vdes.getTiempoMedio());
            aux1.add(bod);
            if(!operarios.contains(vdes.getOperario())){
                operarios.add(vdes.getOperario());
            }
        }
        
        for(String op:operarios){
            int ok = 0;
            int total = 0;
            for(operarioDesvios b:aux1){
                if(op.equals(b.getIdOperario())){
                    total++;
                    if(b.getDesviosOK()<=b.getDesviosTotal()){
                        ok++;                                                
                    }
                }
            }
            operarioDesvios opDes = new operarioDesvios(op, ok, total);
            opDes.setPorcentaje(100*(double)ok/(double)total);
            rankingDesvios.add(opDes);
        }
        rankingDesvios.sort((operarioDesvios c1, operarioDesvios c2) -> (int) ((1000*c2.getPorcentaje())-(1000*c1.getPorcentaje())));

    //Cerrar conexión
        em.close();
        emf.close();
        
        return rankingDesvios;
    }
    
    public List<operarioDias> getListaCompromiso(){
        //Es necesario obtener la lista completa de operarios
        obtenerListados objaux = new obtenerListados();
        List<TrUsuarios> listaCompletaAux = objaux.getListaCompletaOperarios();
        
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("P_S_GPU");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT h FROM HandHrealOper h WHERE (h.trabajado = '0' AND h.motivoId.id >2)");
        List listado = q.getResultList();
        
        HashMap<String,Integer> aux = new HashMap<>();
        for(int i=0; i<listado.size(); i++){
            entidades.HandHrealOper ope = (entidades.HandHrealOper) listado.get(i);
            if(aux.containsKey(ope.getTrUsuarios().getUsuIdusuario())){
                aux.replace(ope.getTrUsuarios().getUsuIdusuario(), 
                    aux.get(ope.getTrUsuarios().getUsuIdusuario())+1);
            }else{
                aux.put(ope.getTrUsuarios().getUsuIdusuario(), 1);
            }
        }
        
        List<operarioDias> diasTrabajados = new ArrayList<>();
        for(Map.Entry<String,Integer> x:aux.entrySet()){
            //22 días laborables en Septiembre
            operarioDias op = new operarioDias(x.getKey(),  22-x.getValue());
            diasTrabajados.add(op);
        }
        
        //ordenación lista
        diasTrabajados.sort((operarioDias o1, operarioDias o2) ->  o2.getDias()-o1.getDias());
        
        //creación lista completa
        List<operarioDias> listaCompromisoCompleta = new ArrayList<>();
        
        for(TrUsuarios tru:listaCompletaAux){
            listaCompromisoCompleta.add(new operarioDias(tru.getUsuIdusuario(), 22, 100.0));
        }
        for(operarioDias op:diasTrabajados){
            for(operarioDias opc:listaCompromisoCompleta){
                if(opc.getIdOperario().equals(op.getIdOperario())){
                    opc.setDias(op.getDias());
                    opc.setPorcentaje(100.0*op.getDias()/22.0);
                    break;
                }
            }
        }

    //Cerrar conexión
        em.close();
        emf.close();
        
        return listaCompromisoCompleta;
    }
}
