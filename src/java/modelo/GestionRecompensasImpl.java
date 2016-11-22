package modelo;

import entidades.Recompensas; 
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component(value="gestionRecomp")
public class GestionRecompensasImpl implements GestionRecompensas{
    @PersistenceContext(name="P_S_GPU")
    EntityManager em;
    
    @Transactional()   
    @Override
    public boolean altaRecompensas(Recompensas recom){
        em.persist(recom);
        return true;
    }
     
    @Override
    public List<Recompensas> obtenerRecompensas() {
        String sql="Select r from Recompensas recom";
        Query q=em.createQuery(sql);
        return q.getResultList();
        
    }
    
    @Override
    public List<Recompensas> eliminarRecompensas() {
        String sql = "DELETE FROM Retos r WHERE r.idrecompensas = :idrecompensas";
        Query q=em.createQuery(sql);
        return q.getResultList();      
    }

}