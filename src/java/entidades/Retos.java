/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mañana
 */
@Entity
@Table(name = "retos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Retos.findAll", query = "SELECT r FROM Retos r"),
    @NamedQuery(name = "Retos.findByIdretos", query = "SELECT r FROM Retos r WHERE r.idretos = :idretos"),
    @NamedQuery(name = "Retos.findByPltCc", query = "SELECT r FROM Retos r WHERE r.pltCc = :pltCc"),
    @NamedQuery(name = "Retos.findByDescripcion", query = "SELECT r FROM Retos r WHERE r.descripcion = :descripcion"),
    @NamedQuery(name = "Retos.findByNivelMin", query = "SELECT r FROM Retos r WHERE r.nivelMin = :nivelMin"),
    @NamedQuery(name = "Retos.findByNivelMax", query = "SELECT r FROM Retos r WHERE r.nivelMax = :nivelMax"),
    @NamedQuery(name = "Retos.findByFechaInicio", query = "SELECT r FROM Retos r WHERE r.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Retos.findByFechaFinal", query = "SELECT r FROM Retos r WHERE r.fechaFinal = :fechaFinal"),
    @NamedQuery(name = "Retos.findByRetoParaUsuario", query = "SELECT r FROM Retos r WHERE r.retoParaUsuario = :retoParaUsuario"),
    @NamedQuery(name = "Retos.findByUrlLogo", query = "SELECT r FROM Retos r WHERE r.urlLogo = :urlLogo")})
public class Retos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idretos")
    private Integer idretos;
    @Basic(optional = false)
    @Column(name = "PLT_CC")
    private String pltCc;
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "nivel_min")
    private int nivelMin;
    @Basic(optional = false)
    @Column(name = "nivel_max")
    private int nivelMax;
    @Basic(optional = false)
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @Column(name = "fecha_final")
    @Temporal(TemporalType.DATE)
    private Date fechaFinal;
    @Column(name = "reto_para_usuario")
    private Boolean retoParaUsuario;
    @Column(name = "url_logo")
    private String urlLogo;
    @OneToMany(mappedBy = "idretos")
    private Collection<MedallasusuRetos> medallasusuRetosCollection;
    @OneToMany(mappedBy = "idretos")
    private Collection<MedallasplantRetos> medallasplantRetosCollection;
    @JoinColumn(name = "nombre_reto", referencedColumnName = "nombre_reto")
    @ManyToOne(optional = false)
    private NombreRetos nombreReto;

    public Retos() {
    }

    public Retos(Integer idretos) {
        this.idretos = idretos;
    }

    public Retos(Integer idretos, String pltCc, int nivelMin, int nivelMax, Date fechaInicio, Date fechaFinal) {
        this.idretos = idretos;
        this.pltCc = pltCc;
        this.nivelMin = nivelMin;
        this.nivelMax = nivelMax;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
    }

    public Integer getIdretos() {
        return idretos;
    }

    public void setIdretos(Integer idretos) {
        this.idretos = idretos;
    }

    public String getPltCc() {
        return pltCc;
    }

    public void setPltCc(String pltCc) {
        this.pltCc = pltCc;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNivelMin() {
        return nivelMin;
    }

    public void setNivelMin(int nivelMin) {
        this.nivelMin = nivelMin;
    }

    public int getNivelMax() {
        return nivelMax;
    }

    public void setNivelMax(int nivelMax) {
        this.nivelMax = nivelMax;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Boolean getRetoParaUsuario() {
        return retoParaUsuario;
    }

    public void setRetoParaUsuario(Boolean retoParaUsuario) {
        this.retoParaUsuario = retoParaUsuario;
    }

    public String getUrlLogo() {
        return urlLogo;
    }

    public void setUrlLogo(String urlLogo) {
        this.urlLogo = urlLogo;
    }

    @XmlTransient
    public Collection<MedallasusuRetos> getMedallasusuRetosCollection() {
        return medallasusuRetosCollection;
    }

    public void setMedallasusuRetosCollection(Collection<MedallasusuRetos> medallasusuRetosCollection) {
        this.medallasusuRetosCollection = medallasusuRetosCollection;
    }

    @XmlTransient
    public Collection<MedallasplantRetos> getMedallasplantRetosCollection() {
        return medallasplantRetosCollection;
    }

    public void setMedallasplantRetosCollection(Collection<MedallasplantRetos> medallasplantRetosCollection) {
        this.medallasplantRetosCollection = medallasplantRetosCollection;
    }

    public NombreRetos getNombreReto() {
        return nombreReto;
    }

    public void setNombreReto(NombreRetos nombreReto) {
        this.nombreReto = nombreReto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idretos != null ? idretos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Retos)) {
            return false;
        }
        Retos other = (Retos) object;
        if ((this.idretos == null && other.idretos != null) || (this.idretos != null && !this.idretos.equals(other.idretos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Retos[ idretos=" + idretos + " ]";
    }
    
}
