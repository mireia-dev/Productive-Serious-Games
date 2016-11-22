package beans;

import java.util.List;

public class medallaRetos {
    private int idMedalla;
    private List<Integer> idRetos;

    public medallaRetos(int idMedalla, List<Integer> idRetos) {
        this.idMedalla = idMedalla;
        this.idRetos = idRetos;
    }

    public int getIdMedalla() {
        return idMedalla;
    }

    public void setIdMedalla(int idMedalla) {
        this.idMedalla = idMedalla;
    }

    public List<Integer> getIdRetos() {
        return idRetos;
    }

    public void setIdRetos(List<Integer> idRetos) {
        this.idRetos = idRetos;
    }
    
    
}
