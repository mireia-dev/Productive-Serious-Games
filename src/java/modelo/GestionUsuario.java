
package modelo;

import entidades.TrUsuarios;

public interface GestionUsuario {
    boolean beanLogin(TrUsuarios log);
    TrUsuarios validarUsuario(String usuIdusuario ,String usuClaveacceso);
}
