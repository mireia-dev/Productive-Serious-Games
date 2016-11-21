/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mañana
 */
@Entity
@Table(name = "nombre_retos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NombreRetos.findAll", query = "SELECT n FROM NombreRetos n"),
    @NamedQuery(name = "NombreRetos.findByNombreReto", query = "SELECT n FROM NombreRetos n WHERE n.nombreReto = :nombreReto")})
public class NombreRetos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nombre_reto")
    private String nombreReto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nombreReto")
    private Collection<Retos> retosCollection;

    public NombreRetos() {
    }

    public NombreRetos(String nombreReto) {
        this.nombreReto = nombreReto;
    }

    public String getNombreReto() {
        return nombreReto;
    }

    public void setNombreReto(String nombreReto) {
        this.nombreReto = nombreReto;
    }

    @XmlTransient
    public Collection<Retos> getRetosCollection() {
        return retosCollection;
    }

    public void setRetosCollection(Collection<Retos> retosCollection) {
        this.retosCollection = retosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombreReto != null ? nombreReto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NombreRetos)) {
            return false;
        }
        NombreRetos other = (NombreRetos) object;
        if ((this.nombreReto == null && other.nombreReto != null) || (this.nombreReto != null && !this.nombreReto.equals(other.nombreReto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.NombreRetos[ nombreReto=" + nombreReto + " ]";
    }
    
}
