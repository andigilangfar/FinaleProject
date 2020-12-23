package com.example.dummy_bpjs.controller;

import com.example.dummy_bpjs.model.Bpjs;
import com.example.dummy_bpjs.repository.BpjsRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    BpjsRepositories bpjsRepositories;

    @GetMapping("/bpjs")
    public ResponseEntity<List<Bpjs>> getBpjs(@RequestParam(required = false)String args){
        List<Bpjs> allbpjs = new ArrayList<Bpjs>();
        bpjsRepositories.findAll().forEach(allbpjs::add);
        if(allbpjs.isEmpty()){
            return new ResponseEntity<>(allbpjs, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(allbpjs, HttpStatus.OK);
    }

    @PostMapping("/addBpjs")
    public ResponseEntity<Bpjs> createBpjs(@RequestBody Bpjs bpjs){
        Bpjs addBpjs = bpjsRepositories.save(bpjs);
        return new ResponseEntity<>(addBpjs, HttpStatus.CREATED);
    }
}
