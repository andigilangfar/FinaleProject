package org.finale.database.model;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "nasabah")
public class Nasabah {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer nasabahId;
    private String no_telp;
    private String nama_lengkap;
    private String alamat;
    private String email;
    private Integer saldo;


    public Integer getNasabahId() {
        return nasabahId;
    }

    public void setNasabahId(Integer nasabahId) {
        this.nasabahId = nasabahId;
    }

    public String getNama_lengkap() {
        return nama_lengkap;
    }

    public void setNama_lengkap(String nama_lengkap) {
        this.nama_lengkap = nama_lengkap;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }
}
