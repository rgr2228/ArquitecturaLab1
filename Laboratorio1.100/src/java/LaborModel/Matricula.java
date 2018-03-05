/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LaborModel;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Santiago
 */
@Entity
@Table(name = "matricula")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Matricula.findAll", query = "SELECT m FROM Matricula m")
    , @NamedQuery(name = "Matricula.findById", query = "SELECT m FROM Matricula m WHERE m.id = :id")
    , @NamedQuery(name = "Matricula.findByIdStudent", query = "SELECT m FROM Matricula m WHERE m.idStudent = :idStudent")
    , @NamedQuery(name = "Matricula.findByCodeSubject", query = "SELECT m FROM Matricula m WHERE m.codeSubject = :codeSubject")})
public class Matricula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codeSubject")
    private Integer codeSubject;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idStudent")
    private Integer idStudent;

    public Matricula() {
    }

    public Matricula(Integer id, Integer codeSubject, Integer idStudent) {
        this.id = id;
        this.codeSubject = codeSubject;
        this.idStudent = idStudent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCodeSubject() {
        return codeSubject;
    }

    public void setCodeSubject(Integer codeSubject) {
        this.codeSubject = codeSubject;
    }

    public Integer getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Integer idStudent) {
        this.idStudent = idStudent;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matricula)) {
            return false;
        }
        Matricula other = (Matricula) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LaborModel.Matricula[ id=" + id + " ]";
    }
    
}
