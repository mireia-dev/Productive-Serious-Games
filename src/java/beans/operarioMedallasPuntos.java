package beans;

import java.util.List;

public class operarioMedallasPuntos {
    private String IDoperario;
    private List<Integer> listaMedallas;
    private int puntuación;

    public operarioMedallasPuntos(String IDoperario, List<Integer> listaMedallas, int puntuación) {
        this.IDoperario = IDoperario;
        this.listaMedallas = listaMedallas;
        this.puntuación = puntuación;
    }

    public String getIDoperario() {
        return IDoperario;
    }

    public void setIDoperario(String IDoperario) {
        this.IDoperario = IDoperario;
    }

    public List<Integer> getListaMedallas() {
        return listaMedallas;
    }

    public void setListaMedallas(List<Integer> listaMedallas) {
        this.listaMedallas = listaMedallas;
    }

    public int getPuntuación() {
        return puntuación;
    }

    public void setPuntuación(int puntuación) {
        this.puntuación = puntuación;
    }
        
    @Override
    public String toString(){
        return IDoperario+" "+listaMedallas+" "+puntuación;
    }
}
