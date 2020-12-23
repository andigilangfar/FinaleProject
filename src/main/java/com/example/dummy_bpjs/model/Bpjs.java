package com.example.dummy_bpjs.model;

import javax.persistence.*;

@Entity
@Table (name = "bpjs")
public class Bpjs {

    @Id
    @GeneratedValue
    @Column (name = "idBpjs")
    private Integer idBpjs;

    @Column(name = "noBpjs")
    private Integer noBpjs;

    @Column(name = "namaPelanggan")
    private String namaPelanggan;

    @Column(name = "totalTagihan")
    private Integer totalTagihan;

    @Column(name = "statusPembayaran")
    private String statusPembayaran;

    public Integer getIdBpjs() {
        return idBpjs;
    }

    public void setIdBpjs(Integer idBpjs) {
        this.idBpjs = idBpjs;
    }

    public Integer getNoBpjs() {
        return noBpjs;
    }

    public void setNoBpjs(Integer noBpjs) {
        this.noBpjs = noBpjs;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }

    public Integer getTotalTagihan() {
        return totalTagihan;
    }

    public void setTotalTagihan(Integer totalTagihan) {
        this.totalTagihan = totalTagihan;
    }

    public String getStatusPembayaran() {
        return statusPembayaran;
    }

    public void setStatusPembayaran(String statusPembayaran) {
        this.statusPembayaran = statusPembayaran;
    }
}
