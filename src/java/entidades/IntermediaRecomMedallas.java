/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mañana
 */
@Entity
@Table(name = "intermedia_recom_medallas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IntermediaRecomMedallas.findAll", query = "SELECT i FROM IntermediaRecomMedallas i"),
    @NamedQuery(name = "IntermediaRecomMedallas.findByIdRecompMedallas", query = "SELECT i FROM IntermediaRecomMedallas i WHERE i.idRecompMedallas = :idRecompMedallas"),
    @NamedQuery(name = "IntermediaRecomMedallas.findByFechaInicio", query = "SELECT i FROM IntermediaRecomMedallas i WHERE i.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "IntermediaRecomMedallas.findByFechaFin", query = "SELECT i FROM IntermediaRecomMedallas i WHERE i.fechaFin = :fechaFin")})
public class IntermediaRecomMedallas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRecompMedallas")
    private Integer idRecompMedallas;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @JoinColumn(name = "idMedallas", referencedColumnName = "idmedallas")
    @ManyToOne
    private MedallasUsuario idMedallas;
    @JoinColumn(name = "idrecompensas", referencedColumnName = "idrecompensas")
    @ManyToOne
    private Recompensas idrecompensas;

    public IntermediaRecomMedallas() {
    }

    public IntermediaRecomMedallas(Integer idRecompMedallas) {
        this.idRecompMedallas = idRecompMedallas;
    }

    public Integer getIdRecompMedallas() {
        return idRecompMedallas;
    }

    public void setIdRecompMedallas(Integer idRecompMedallas) {
        this.idRecompMedallas = idRecompMedallas;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public MedallasUsuario getIdMedallas() {
        return idMedallas;
    }

    public void setIdMedallas(MedallasUsuario idMedallas) {
        this.idMedallas = idMedallas;
    }

    public Recompensas getIdrecompensas() {
        return idrecompensas;
    }

    public void setIdrecompensas(Recompensas idrecompensas) {
        this.idrecompensas = idrecompensas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRecompMedallas != null ? idRecompMedallas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IntermediaRecomMedallas)) {
            return false;
        }
        IntermediaRecomMedallas other = (IntermediaRecomMedallas) object;
        if ((this.idRecompMedallas == null && other.idRecompMedallas != null) || (this.idRecompMedallas != null && !this.idRecompMedallas.equals(other.idRecompMedallas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.IntermediaRecomMedallas[ idRecompMedallas=" + idRecompMedallas + " ]";
    }
    
}
