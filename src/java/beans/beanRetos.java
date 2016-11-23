package beans;

public class beanRetos {
    private int IDreto;
    private double puntuacionOp;
    private double porcentaje;
    private String URL;

    public beanRetos(int IDreto, double puntuacionOp, double porcentaje, String URL) {
        this.IDreto = IDreto;
        this.puntuacionOp = puntuacionOp;
        this.porcentaje = porcentaje;
        this.URL = URL;
    }
    
    public beanRetos(int IDreto, double puntuacionOp, double porcentaje) {
        this.IDreto = IDreto;
        this.puntuacionOp = puntuacionOp;
        this.porcentaje = porcentaje;
    }

    public int getIDreto() {
        return IDreto;
    }

    public void setIDreto(int IDreto) {
        this.IDreto = IDreto;
    }

    public double getPuntuacionOp() {
        return puntuacionOp;
    }

    public void setPuntuacionOp(double puntuacionOp) {
        this.puntuacionOp = puntuacionOp;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
        
    @Override
    public String toString(){
        return IDreto+" "+puntuacionOp+" "+porcentaje;
    }
    
    
}
