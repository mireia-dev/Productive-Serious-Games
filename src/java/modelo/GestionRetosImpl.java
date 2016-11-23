package modelo;


import entidades.Retos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.transaction.Transactional;
import org.springframework.stereotype.Component;
 
@Component(value="gestion")

public class GestionRetosImpl implements GestionRetos{
    
    @PersistenceContext(name="PSG_conCalculoPU")//PONEMOS ___PU
    EntityManager em;
    
     public GestionRetosImpl() {
    }
     
    @Transactional()   //esos paréntesis son necesarios?
    @Override
    public boolean altaRetos(Retos r){//Lo dejamos así porque llamamos a la entidad de persistencia para dar de alta un reto con todos sus atributos
        em.persist(r);                //  
        return true;                  // 
    }
    


    @Override
    public List<Retos> ListadoRetos( ) { //antes obtenerRetos
        Query q=em.createNamedQuery("Retos.findAll"); //Lista entera de retos con //q.setParameter("Retos.findByIdretos", Retos); 
        // No se podría meter aquí dentro en filtro????
        List<Retos> listado = (List<Retos>) q.getResultList();
        return listado;
        
    }
    
    //Aquí obtener retos con filtros como Hugo cambiando los parámetros. Menos lo últimoreturn retos; } que está exactamente igual...
    
    @Transactional
    @Override   
    public List<Retos> ListadoRetos(String nombre_reto, //antes obtenerRetos
            String nivel_max,
            String nivel_min,
            java.sql.Date fecha_inicio,
            java.sql.Date fecha_final,
            String url_logo){ 
               EntityManagerFactory emf = Persistence.createEntityManagerFactory(" ");
        EntityManager em = emf.createEntityManager();
        
        String jpql="select r from retos where ";
        jpql+="r.fechaInicio=:fechaInicio and r.fechaFinal=:fechaFinal"; 
        
        if(nombre_reto!=null && !nombre_reto.equals("")){
            String valores="("+nombre_reto;
            for(int i=1;i<nombre_reto.size();i++){//NO ENTIENDO
                valores+=","+nombre_reto.get(i);
            }
            valores+=")";
            jpql+=" r.nombre_reto in "+valores;
        }
        
        if(nivel_min!=null && !nivel_min.equals("")){
            jpql+=" and r.nivel_min="+nivel_min;
        }
        if(nivel_max!=null && !nivel_max.equals("")){
            jpql+=" and r.nivel_max="+nivel_max;
        }
       
        Query q=em.createQuery(jpql);
        q.setParameter("fecha_inicio", fecha_inicio, TemporalType.DATE);
        q.setParameter("fecha_final", fecha_final, TemporalType.DATE);
        List<Retos> retos=(List<Retos>)q.getResultList();
        em.close();
        emf.close();
        return retos;          
    }
    
    
    
    
    
    @Transactional()
    @Override
    public String eliminarReto(){
        String sql = "DELETE FROM Retos r WHERE r.nombre_reto.nombre_reto = :r.nombre_reto.nombre_reto";//No sé si está bien, como nombreReto en la tabla retos es FK q conecta con nombre reto en la tabla nombreRetos por eso lo hago
        Query q=em.createQuery(sql);
//        int filasEliminadas = q.executeUpdate();
//        
//        if (filasEliminadas == 0) {
//            return false;
//        } else {
//            em.close();
//            return true;
//        }
        return "";
    }
    
     @Transactional()
     @Override
    public String modificarReto(Retos r){ 
        em.persist(r);
        return "";
    }
}