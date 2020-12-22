package com.example.projectfinalefix.model;

import java.time.LocalDate;

public class RegisterRequest {

    private String username;
    private String password;
    private String nama_lengkap;
    private String alamat;
    private String email;
    private String no_telp;

//    public RegisterRequest(String username, String password, LocalDate tglLahir, String namaLengkap, String alamat, String email, String notelp) {
//        this.username = username;
//        this.password = password;
//        this.tglLahir = tglLahir;
//        this.namaLengkap = namaLengkap;
//        this.alamat = alamat;
//        this.email = email;
//        this.notelp = notelp;
//    }


    public RegisterRequest(String username, String password, String nama_lengkap, String alamat, String email, String no_telp) {
        this.username = username;
        this.password = password;
        this.nama_lengkap = nama_lengkap;
        this.alamat = alamat;
        this.email = email;
        this.no_telp = no_telp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }
}
