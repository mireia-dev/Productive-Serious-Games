
package modelo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import entidades.MedallasplantRetos;
import entidades.Retos;


@Component(value = "gestionMedallasAlm")
public class MedallasAlmImpl implements MedallasAlm {
    @PersistenceContext(name = "PSG_conCalculo")
    EntityManager em; 
    
    /*
    @Transactional()
    @Override
    public List<MedallasusuRetos> recuperarMedallas() {
        Query query = em.createNamedQuery("MedallasusuRetos.filtrado");
        List<MedallasusuRetos> lista = query.getResultList();
        return lista; 
          
    }
    */
    
    @Transactional
    @Override
    public List<Retos> obtenerMedallasAlm(List<String> nombre_centro,
            String nombre_medalla, //almacén
            List<String> nombre_reto,           
            String valorMin,
            String valorMax,
            java.sql.Date fechaMin,
            java.sql.Date fechaMax,           
            String puntos){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PSG_medallasusu_1");
        EntityManager em = emf.createEntityManager();
        
        String jpql="select r from retos r join r.medallasplant_retos m join m.medallas_almacen a where ";
        jpql+="a.fecha_inicio=:fecha_inicio and a.fecha_final=:fecha_final";
        
        /*if(nombre_centro!=null && !nombre_centro.equals("")){
            jpql+=" and a.almacen='"+nombre_centro+"'";
        }*/
        if(nombre_centro!=null && !nombre_centro.equals("")){
            String valores="("+nombre_reto;
            for(int i=1;i<nombre_centro.size();i++){
                valores+=","+nombre_centro.get(i);
            }
            valores+=")";
            jpql+=" r.nombre_centro in "+valores;
        }
        
        if(nombre_medalla!=null && !nombre_medalla.equals("")){
            jpql+=" and a.nombre='"+nombre_medalla+"'";
        }
        /*if(nombre_reto!=null && !nombre_reto.equals("")){
            jpql+=" and r.nombre_reto='"+nombre_reto+"'";
        }*/
        
        if(nombre_reto!=null && !nombre_reto.equals("")){
            String valores="("+nombre_reto;
            for(int i=1;i<nombre_reto.size();i++){
                valores+=","+nombre_reto.get(i);
            }
            valores+=")";
            jpql+=" r.nombre_reto in "+valores;
        }
        
        if(valorMin!=null && !valorMin.equals("")){
            jpql+=" and m.valor_min="+valorMin;
        }
        if(valorMax!=null && !valorMax.equals("")){
            jpql+=" and m.valor_max="+valorMax;
        }
        if(puntos!=null && !puntos.equals("")){
            jpql+=" and a.puntos='"+puntos+"'";
        }
        Query q=em.createQuery(jpql);
        q.setParameter("fecha_inicio", fechaMin, TemporalType.DATE);
        q.setParameter("fecha_final", fechaMin, TemporalType.DATE);
        List<Retos> retos=(List<Retos>)q.getResultList();
        em.close();
        emf.close();
        return retos;    
    }
    
    @Transactional
    @Override
    public boolean agregarMedallasAlm(MedallasplantRetos medplant) {   
        em.persist(medplant);
        return true;
    }
    
    @Transactional
    @Override
    public boolean eliminarMedallasAlm(MedallasplantRetos medplant){    
        EntityTransaction tx=em.getTransaction();
        tx.begin();
        em.merge(medplant); 
        em.remove(medplant);
        tx.commit();
        em.close();
        return true;
    }
    
    @Transactional
    @Override
    public void modificarMedallasAlm(MedallasplantRetos medplant){
        em.persist(medplant);
    }
}

