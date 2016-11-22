package managed;

import entidades.TrUsuarios;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.GestionUsuario;
import javax.faces.bean.ManagedProperty;

@ManagedBean (name= "login")
@SessionScoped

public class beanLogin implements Serializable{
    private String rol;
    private String email;
    private String password;
    private String usuario;
    private TrUsuarios user;
   
    
    @ManagedProperty("#{gestion}")
    private GestionUsuario gestion;
    
    public beanLogin() {
    }
    
    public GestionUsuario getGestion() {
        return gestion;
    }

    public void setGestion(GestionUsuario gestion) {
        this.gestion = gestion;
    }
   
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
       
    public TrUsuarios getUser() {
        return user;
    }

    public void setUser(TrUsuarios user) {
        this.user = user;
    }
    
    public String getusuario() {
        return usuario;
    }

    public void setusuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRol() {
        return rol;
    }

    public void setRol_usuario(String rol) {
        this.rol = rol;
    }

    public String validarLogin(){
        this.user=gestion.validarUsuario(usuario,password);
        if (user == null){
            return "index";
        }else{
            rol = user.getRol();
            if(rol.equals("GAMIFICATION_ADMIN") ){
               return "administrado";
           }else{
               return "usuario"; 
            }
        }
        //return "index";
    }    
}
