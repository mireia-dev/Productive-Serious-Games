package beans;

public class operarioDias {
    private String idOperario;
    private int dias;
    private Double porcentaje;
//Constructores
    public operarioDias() {
    }

    public operarioDias(String idOperario, int dias) {
        this.idOperario = idOperario;
        this.dias = dias;
    }

    public operarioDias(String idOperario, int dias, Double porcentaje) {
        this.idOperario = idOperario;
        this.dias = dias;
        this.porcentaje = porcentaje;
    }
 
//Get-seters

    public String getIdOperario() {
        return idOperario;
    }

    public void setIdOperario(String idOperario) {
        this.idOperario = idOperario;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public Double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
    }
    
    @Override
    public String toString(){
        return idOperario+" "+String.valueOf(dias)+" "+porcentaje+"%";
    }   
        
    
    
}
