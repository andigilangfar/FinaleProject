package org.finale.database.repositories;

import org.finale.database.model.Nasabah;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class NasabahDao {
    private EntityManager entityManager;
    private EntityTransaction entityTransaction;

    public NasabahDao(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.entityTransaction = this.entityManager.getTransaction();
    }

    public int addNasabah(Nasabah nasabah){
        entityManager.persist(nasabah);
        return nasabah.getNasabahId();
    }

    public int checkSaldoId(Nasabah nasabah){
        String select = "SELECT saldo FROM Nasabah WHERE nasabahId=:nasabahId";
        Query query = entityManager.createQuery(select);
        query.setParameter("nasabahId", nasabah.getNasabahId());
        if (query.getResultList().size()!=0){
            System.out.println("masuk cek saldo 12");
            return (int)query.getResultList().get(0);
        } else {
            System.out.println("masuk cek saldo 22");
            return query.getResultList().size();
        }
    }
}