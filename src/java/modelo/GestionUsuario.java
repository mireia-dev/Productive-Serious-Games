
package modelo;

import entidades.HandPlantas;
import entidades.TrUsuarios;
import java.util.List;


public interface GestionUsuario {
    boolean beanLogin(TrUsuarios log);
    TrUsuarios validarUsuario(String usuIdusuario ,String usuClaveacceso);
}
