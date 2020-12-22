package org.finale.database.service;
import com.google.gson.Gson;
import org.finale.database.model.Nasabah;
import org.finale.database.model.Register;
import org.finale.database.model.User;
import org.finale.database.repositories.NasabahDao;
import org.finale.database.repositories.UserDao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Services {
    private NasabahDao nasabahDao;
    private UserDao userDao;
    private EntityManager entityManagerNasabah;
    private EntityManager entityManagerUser;

    public void connectJPANasabah(){
        this.entityManagerNasabah = Persistence
                .createEntityManagerFactory("ibanking-unit")
                .createEntityManager();
        nasabahDao = new NasabahDao(entityManagerNasabah);
        try {
            entityManagerNasabah.getTransaction().begin();
        } catch (IllegalStateException e) {
            entityManagerNasabah.getTransaction().rollback();
        }
    }

    public void connectJPAUser(){
        this.entityManagerUser = Persistence
                .createEntityManagerFactory("ibanking-unit")
                .createEntityManager();
        userDao = new UserDao(entityManagerUser);
        try {
            entityManagerUser.getTransaction().begin();
        } catch (IllegalStateException e) {
            entityManagerUser.getTransaction().rollback();
        }
    }

    public void commitJPA(EntityManager entity){
        try {
            entity.getTransaction().commit();
            entity.close();
        } catch (IllegalStateException e) {
            entity.getTransaction().rollback();
        }
    }

    public void registerNasabah(String register){
        Register regis = new Gson().fromJson(register, Register.class);
        Nasabah nasabah = new Nasabah();
        nasabah.setNo_telp(regis.getNo_telp());
        nasabah.setNama_lengkap(regis.getNama_lengkap());
        nasabah.setAlamat(regis.getAlamat());
        nasabah.setEmail(regis.getEmail());
        nasabah.setSaldo(100000);

        connectJPANasabah();
        int nasabahId = nasabahDao.addNasabah(nasabah);
        commitJPA(entityManagerNasabah);

        User user = new User();
        user.setUsername(regis.getUsername());
        user.setPassword(regis.getPassword());
        user.setNasabahId(nasabahId);
        user.setIsLoggedIn("false");
        connectJPAUser();
        int UserId = userDao.addUser(user);
        commitJPA(entityManagerUser);
    }

    public int loginUser(String dataUser){
        connectJPAUser();
        User user = new Gson().fromJson(dataUser, User.class);
        int cek =userDao.login(user);
        commitJPA(entityManagerUser);
        System.out.println("Cek: "+cek);
        return cek;
    }

    public int logoutUser(String dataUser){
        connectJPAUser();
        User user = new Gson().fromJson(dataUser, User.class);
        int cek =userDao.checkUser(user);
        commitJPA(entityManagerUser);
        System.out.println("Cek: "+cek);
        return cek;
    }
    public int checkUser(String dataUser){
        connectJPAUser();
//        User user = new Gson().fromJson(dataUser, User.class);
        int cek =userDao.checkUserSaldo(dataUser);
        commitJPA(entityManagerUser);
        System.out.println("Cek: "+cek);
        return cek;
    }


    public void updateStatusLogin(User user,String status){
        connectJPAUser();
//        User user = new Gson().fromJson(dataUser, User.class);
//        System.out.println("cek Username: "+user.getUsername());
        userDao.updateStatusLogin(user,status);
        commitJPA(entityManagerUser);
    }
    public int checkSaldo(Nasabah nasabah){
        connectJPANasabah();
       // int saldoTotal=nasabahDao.checkSaldo(saldo);
        int saldo=nasabahDao.checkSaldoId(nasabah);
        System.out.println("Method Check Saldo: "+saldo);
        commitJPA(entityManagerNasabah);
        return saldo;
    }
//    public int checkSaldo(int saldoId){
//        connectJPANasabah();
//      //  int saldoTotal=nasabahDao.checkSaldo(saldo);
//        Nasabah saldo1 = nasabahDao.checkSaldo(saldoId);
//        int saldoTotal=saldo1.getSaldo();
//        System.out.println("Method Check Saldo: "+saldoTotal);
//        commitJPA(entityManagerSaldo);
//        return saldoTotal;
//    }
}