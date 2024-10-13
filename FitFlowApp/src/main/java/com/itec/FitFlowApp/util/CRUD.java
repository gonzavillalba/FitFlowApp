package com.itec.FitFlowApp.util;

import java.util.List;

public interface CRUD <R, Q>{
    R create(Q q);
    List<R>findAll();
    R findById(String id);
    R update(Q q);
    void delete(String id);

}
