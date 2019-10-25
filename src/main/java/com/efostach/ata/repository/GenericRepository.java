package com.efostach.ata.repository;

import java.io.FileNotFoundException;
import java.util.List;

public interface GenericRepository<T,ID> {

    T getById(ID id) throws FileNotFoundException;

    List<T> getAll() throws FileNotFoundException;

    T create(T t) throws Exception;

    T update(T t);
}
