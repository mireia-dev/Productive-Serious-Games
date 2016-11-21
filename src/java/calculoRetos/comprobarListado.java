/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculoRetos;

import beans.operarioDesvios;
import beans.operarioDias;
import beans.operarioHoras;
import beans.operarioURL;
import java.util.List;

public class comprobarListado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        obtenerListados lm = new obtenerListados();
        List<beans.operarioMov> listaMov = lm.getListaMovimientos();
        System.out.println("movimientos: "+listaMov.size());
        listaMov.forEach( mov -> System.out.println(mov.toString()));
        List<operarioDesvios> listades= lm.getDesvios();
        System.out.println("desvios: "+listades.size());
        listades.forEach( des -> System.out.println(des.toString()));
        List<entidades.TrUsuarios> listacompleta = lm.getListaCompletaOperarios();
        System.out.println("completa "+listacompleta.size());
        List<operarioDias> listaCompromiso = lm.getListaCompromiso();
        System.out.println("compromiso "+listaCompromiso.size());
        listaCompromiso.forEach(x -> System.out.println(x.toString()));
        List<operarioHoras> listaHE = lm.getListaHorasExtra();
        System.out.println("horas extra: "+listaHE.size());
        listaHE.forEach(h -> System.out.println(h.toString()));
        List<operarioURL> listaURL = lm.getListaOperariosURLfoto();
        System.out.println("URL :"+listaURL.size());
    }
    
}
