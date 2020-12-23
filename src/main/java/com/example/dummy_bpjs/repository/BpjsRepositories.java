package com.example.dummy_bpjs.repository;

import com.example.dummy_bpjs.model.Bpjs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BpjsRepositories extends JpaRepository<Bpjs, Long> {
//    List<Bpjs>findALl();
    @Query("Select b from Bpjs b WHERE b.noBpjs = ?1")
    Optional<Bpjs>findBpjs(Integer noBpjs);
}
