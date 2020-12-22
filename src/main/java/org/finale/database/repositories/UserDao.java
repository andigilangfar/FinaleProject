package org.finale.database.repositories;

import org.finale.database.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class UserDao {
    private EntityManager entityManager;
    private EntityTransaction entityTransaction;

    public UserDao(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.entityTransaction = this.entityManager.getTransaction();
    }

    public int addUser(User user){
        entityManager.persist(user);
        return user.getNasabahId();
    }

    public int login(User user){
//        HashMap<String, String> login = new HashMap<String, String>();
//        login.put("username",user.getUsername());
//        login.put("password",user.getPassword());
//        entityManager.find(User.class,login);
        String select = "SELECT userId FROM User WHERE username=:username and password=:password";
        Query query = entityManager.createQuery(select);
        query.setParameter("username", user.getUsername());
        query.setParameter("password", user.getPassword());
//        System.out.println("isi login: "+query.getResultList().get(0));
        if (query.getResultList().size()!=0){
            System.out.println("masuk 1");
            return (int)query.getResultList().get(0);
        } else {
            System.out.println("masuk 2");
            return query.getResultList().size();
        }
//        int res =query.getResultList().size();
//        if (res==1){
//            User user1 = entityManager.find(User.class,user.getUsername());
//            user1.setIsLoggedIn("true");
//            entityManager.merge(user1);
//        }

    }
    public int checkUser(User user){
        String select = "SELECT userId FROM User WHERE username=:username";
        Query query = entityManager.createQuery(select);
        query.setParameter("username", user.getUsername());
        if (query.getResultList().size()!=0){
            System.out.println("masuk 12");
            return (int)query.getResultList().get(0);
        } else {
            System.out.println("masuk 22");
            return query.getResultList().size();
        }
    }

    //    public int checkUserSaldo(User user){
    public int checkUserSaldo(String username){
        String select = "SELECT nasabahId FROM User WHERE username=:username AND isLoggedIn=:isLoggedIn";
        Query query = entityManager.createQuery(select);
        query.setParameter("username", username);
        query.setParameter("isLoggedIn", "true");
        if (query.getResultList().size()!=0){
            System.out.println("masuk 12");
            return (int)query.getResultList().get(0);
        } else {
            System.out.println("masuk 22");
            return query.getResultList().size();
        }
    }
    public int updateStatusLogin(User user,String status){
        User user1 = entityManager.find(User.class,user.getUserId());
        user1.setIsLoggedIn(status);
        entityManager.merge(user1);
        return 1;
    }
}
