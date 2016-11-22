
package modelo;

import entidades.TrUsuarios;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Component;

@Component (value="gestionUsuario")
public class GestionUsuarioimpl implements GestionUsuario,Serializable{
    
    @PersistenceContext(name = "P_S_GPU")
    EntityManager em;

    public GestionUsuarioimpl() {
       
    }
    
    @Override
    public boolean beanLogin(TrUsuarios usu){
        em.persist(usu);
        return true;   
    }
    @Override
    public TrUsuarios validarUsuario(String usuIdusuario ,String usuClaveacceso){
        
        Query q=em.createNamedQuery("TrUsuarios.login");
        q.setParameter("usuIdusuario",usuIdusuario);
        q.setParameter("usuClaveacceso",usuClaveacceso);
        TrUsuarios result=(TrUsuarios) q.getSingleResult();
        return result;
      
    }

    @Override
    public String toString() {
        return "GestionUsuarioimpl{" + "em=" + em + '}';
    }
    
    public String dameUsuario(){
        return "Un usuario";
    }
    
    //***********************************************    
    
  }
