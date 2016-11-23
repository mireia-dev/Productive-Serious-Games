package beans;

import java.util.List;

public class medRetosPuntos {
    private List<Integer> idRetos;
    private int puntos;

    public medRetosPuntos(List<Integer> idRetos, int puntos) {
        this.idRetos = idRetos;
        this.puntos = puntos;
    }

    public List<Integer> getIdRetos() {
        return idRetos;
    }

    public void setIdRetos(List<Integer> idRetos) {
        this.idRetos = idRetos;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    
    

    
    
}
