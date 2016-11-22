package beans;

public class beanRetos {
    private int IDreto;
    private double puntuacionOp;
    private double porcentaje;

    public beanRetos(int IDreto, double puntuacionOp, double porcentaje) {
        this.IDreto = IDreto;
        this.puntuacionOp = puntuacionOp;
        this.porcentaje = porcentaje;
    }

    public beanRetos(int IDreto, double puntuacionOp) {
        this.IDreto = IDreto;
        this.puntuacionOp = puntuacionOp;
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
    
    @Override
    public String toString(){
        return IDreto+" "+puntuacionOp+" "+porcentaje;
    }
    
    
}
