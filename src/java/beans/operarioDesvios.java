package beans;

public class operarioDesvios {
    private String idOperario;
    private int desviosOK;
    private int desviosTotal;
    private double porcentaje;

    public operarioDesvios() {
    }

    public operarioDesvios(String idOperario, int desviosOK, int desviosTotal) {
        this.idOperario = idOperario;
        this.desviosOK = desviosOK;
        this.desviosTotal = desviosTotal;
        //this.porcentaje = desviosOK/desviosTotal*100;
    }
//get-setters
    public String getIdOperario() {
        return idOperario;
    }

    public void setIdOperario(String idOperario) {
        this.idOperario = idOperario;
    }

    public int getDesviosOK() {
        return desviosOK;
    }

    public void setDesviosOK(int desviosOK) {
        this.desviosOK = desviosOK;
    }

    public int getDesviosTotal() {
        return desviosTotal;
    }

    public void setDesviosTotal(int desviosTotal) {
        this.desviosTotal = desviosTotal;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }
    
    @Override
    public String toString(){
        return idOperario+" "+String.valueOf(desviosOK)+" "+String.valueOf(desviosTotal)+" "+String.valueOf(porcentaje)+"%";
    }
    

    
}
