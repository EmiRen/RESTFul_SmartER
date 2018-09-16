/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restws;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author RenJie
 */
@Entity
@Table(name = "USAGE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usage.findAll", query = "SELECT u FROM Usage u")
    , @NamedQuery(name = "Usage.findByUsageid", query = "SELECT u FROM Usage u WHERE u.usageid = :usageid")
    , @NamedQuery(name = "Usage.findByDate", query = "SELECT u FROM Usage u WHERE u.date = :date")
    , @NamedQuery(name = "Usage.findByUsagehour", query = "SELECT u FROM Usage u WHERE u.usagehour = :usagehour")
    , @NamedQuery(name = "Usage.findByTemperature", query = "SELECT u FROM Usage u WHERE u.temperature = :temperature")
    , @NamedQuery(name = "Usage.findByFridgeusage", query = "SELECT u FROM Usage u WHERE u.fridgeusage = :fridgeusage")
    , @NamedQuery(name = "Usage.findByAirconusage", query = "SELECT u FROM Usage u WHERE u.airconusage = :airconusage")
    , @NamedQuery(name = "Usage.findByWashusage", query = "SELECT u FROM Usage u WHERE u.washusage = :washusage")
    , @NamedQuery(name = "Usage.findByResid", query = "SELECT u FROM Usage u WHERE u.resid.resid = :resid")
    , @NamedQuery(name = "Usage.findBySurnameANDDate", query = "SELECT u FROM Usage u WHERE UPPER(u.resid.surname) = UPPER(:surname) AND u.date = :date")})

public class Usage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "USAGEID")
    private Integer usageid;
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "USAGEHOUR")
    private Integer usagehour;
    @Column(name = "TEMPERATURE")
    private Double temperature;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "FRIDGEUSAGE")
    private Double fridgeusage;
    @Column(name = "AIRCONUSAGE")
    private Double airconusage;
    @Column(name = "WASHUSAGE")
    private Double washusage;
    @JoinColumn(name = "RESID", referencedColumnName = "RESID")
    @ManyToOne
    private Resident resid;

    public Usage() {
    }

    public Usage(Integer usageid) {
        this.usageid = usageid;
    }

    public Integer getUsageid() {
        return usageid;
    }

    public void setUsageid(Integer usageid) {
        this.usageid = usageid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getUsagehour() {
        return usagehour;
    }

    public void setUsagehour(Integer usagehour) {
        this.usagehour = usagehour;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getFridgeusage() {
        return fridgeusage;
    }

    public void setFridgeusage(Double fridgeusage) {
        this.fridgeusage = fridgeusage;
    }

    public Double getAirconusage() {
        return airconusage;
    }

    public void setAirconusage(Double airconusage) {
        this.airconusage = airconusage;
    }

    public Double getWashusage() {
        return washusage;
    }

    public void setWashusage(Double washusage) {
        this.washusage = washusage;
    }

    public Resident getResid() {
        return resid;
    }

    public void setResid(Resident resid) {
        this.resid = resid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usageid != null ? usageid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usage)) {
            return false;
        }
        Usage other = (Usage) object;
        if ((this.usageid == null && other.usageid != null) || (this.usageid != null && !this.usageid.equals(other.usageid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "restws.Usage[ usageid=" + usageid + " ]";
    }
    
}
