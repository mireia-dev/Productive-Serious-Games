package beans;

public class frontRetosPorUsuario {
    private int IDreto;
    private String URLreto;
    private String tipoReto;
    private double porcentaje;

    public frontRetosPorUsuario(int IDreto, String URLreto, String tipoReto, double porcentaje) {
        this.IDreto = IDreto;
        this.URLreto = URLreto;
        this.tipoReto = tipoReto;
        this.porcentaje = porcentaje;
    }

    public int getIDreto() {
        return IDreto;
    }

    public void setIDreto(int IDreto) {
        this.IDreto = IDreto;
    }

    public String getURLreto() {
        return URLreto;
    }

    public void setURLreto(String URLreto) {
        this.URLreto = URLreto;
    }

    public String getTipoReto() {
        return tipoReto;
    }

    public void setTipoReto(String tipoReto) {
        this.tipoReto = tipoReto;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }
    
    
    
}
