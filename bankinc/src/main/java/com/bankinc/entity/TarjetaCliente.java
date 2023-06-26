package com.bankinc.entity;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marco Antonio Rebollo Lopez
 */
@Entity
@Table(name = "tarjetacliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TarjetaCliente.findAll", query = "SELECT t FROM TarjetaCliente t"),
    @NamedQuery(name = "TarjetaCliente.findByIdproducto", query = "SELECT t FROM TarjetaCliente t WHERE t.idproducto = :idproducto"),
    @NamedQuery(name = "TarjetaCliente.findByNombresTitular", query = "SELECT t FROM TarjetaCliente t WHERE t.nombresTitular = :nombresTitular"),
    @NamedQuery(name = "TarjetaCliente.findByApellidosTitular", query = "SELECT t FROM TarjetaCliente t WHERE t.apellidosTitular = :apellidosTitular"),
    @NamedQuery(name = "TarjetaCliente.findByFechaVencimiento", query = "SELECT t FROM TarjetaCliente t WHERE t.fechaVencimiento = :fechaVencimiento"),
    @NamedQuery(name = "TarjetaCliente.findByMovimientoPermitido", query = "SELECT t FROM TarjetaCliente t WHERE t.movimientoPermitido = :movimientoPermitido"),
    @NamedQuery(name = "TarjetaCliente.findByNumeroTarjeta", query = "SELECT t FROM TarjetaCliente t WHERE t.numeroTarjeta = :numeroTarjeta"),
    @NamedQuery(name = "TarjetaCliente.findByActivacionTarjeta", query = "SELECT t FROM TarjetaCliente t WHERE t.activacionTarjeta = :activacionTarjeta"),
    @NamedQuery(name = "TarjetaCliente.findBySaldoTarjeta", query = "SELECT t FROM TarjetaCliente t WHERE t.saldoTarjeta = :saldoTarjeta"),
    @NamedQuery(name = "TarjetaCliente.findBySaldoRecarga", query = "SELECT t FROM TarjetaCliente t WHERE t.saldoRecarga = :saldoRecarga")})
public class TarjetaCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    
    @Column(name = "idproducto")
    private Long idproducto;
    
    @Column(name = "nombresTitular")
    private String nombresTitular;
    
    @Column(name = "apellidosTitular")
    private String apellidosTitular;
    
    @Column(name = "fechaVencimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;
    
    @Column(name = "movimientoPermitido")
    private String movimientoPermitido;
    
    @Column(name = "numeroTarjeta")
    private Integer numeroTarjeta;
    
    @Column(name = "activacionTarjeta")
    private String activacionTarjeta;
    
    @Column(name = "saldoTarjeta")
    private Integer saldoTarjeta;
    
    @Column(name = "saldoRecarga")
    private Integer saldoRecarga;

    public TarjetaCliente() {
    }

    public TarjetaCliente(Long idproducto) {
        this.idproducto = idproducto;
    }

    public Long getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Long idproducto) {
        this.idproducto = idproducto;
    }

    public String getNombresTitular() {
        return nombresTitular;
    }

    public void setNombresTitular(String nombresTitular) {
        this.nombresTitular = nombresTitular;
    }

    public String getApellidosTitular() {
        return apellidosTitular;
    }

    public void setApellidosTitular(String apellidosTitular) {
        this.apellidosTitular = apellidosTitular;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getMovimientoPermitido() {
        return movimientoPermitido;
    }

    public void setMovimientoPermitido(String movimientoPermitido) {
        this.movimientoPermitido = movimientoPermitido;
    }

    public Integer getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(Integer numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getActivacionTarjeta() {
        return activacionTarjeta;
    }

    public void setActivacionTarjeta(String activacionTarjeta) {
        this.activacionTarjeta = activacionTarjeta;
    }

    public Integer getSaldoTarjeta() {
        return saldoTarjeta;
    }

    public void setSaldoTarjeta(Integer saldoTarjeta) {
        this.saldoTarjeta = saldoTarjeta;
    }

    public Integer getSaldoRecarga() {
        return saldoRecarga;
    }

    public void setSaldoRecarga(Integer saldoRecarga) {
        this.saldoRecarga = saldoRecarga;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproducto != null ? idproducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TarjetaCliente)) {
            return false;
        }
        TarjetaCliente other = (TarjetaCliente) object;
        if ((this.idproducto == null && other.idproducto != null) || (this.idproducto != null && !this.idproducto.equals(other.idproducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.guides.springboot2.springboot2jpacrudexample.entities.TarjetaCliente[ idproducto=" + idproducto + " ]";
    }
    
}
