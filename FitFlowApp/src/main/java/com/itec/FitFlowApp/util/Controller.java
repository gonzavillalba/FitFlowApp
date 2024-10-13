package com.itec.FitFlowApp.util;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface Controller <R, Q>{
    ResponseEntity<R> create(Q q);
    ResponseEntity<List<R>> findAll();
    ResponseEntity<R> findById(String id);
    ResponseEntity<R> update(Q q);
    ResponseEntity<Void> delete(String id);

}
