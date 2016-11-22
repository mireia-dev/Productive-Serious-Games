package beans;

public class operarioHoras {
    private String idOperario;
    private Double horas;
//Constructores
    public operarioHoras() {
    }
    
    public operarioHoras(String idOperario, Double horasExtra) {
        this.idOperario = idOperario;
        this.horas = horasExtra;
    }

//Get-seters

    public String getIdOperario() {
        return idOperario;
    }

    public void setIdOperario(String idOperario) {
        this.idOperario = idOperario;
    }

    public Double getHorasExtra() {
        return horas;
    }

    public void setHorasExtra(Double horasExtra) {
        this.horas = horasExtra;
    }
    
    @Override
    public String toString(){
        return idOperario+" "+String.valueOf(horas);
    }   
        
    
    
}
