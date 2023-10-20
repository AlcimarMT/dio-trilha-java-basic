package me.dio.service;

import java.util.List;

public interface CrudService <ID, T>{
/*ID é a identificação número do tipo long que é identificada
como primaryKey na base de dados.*/
    List<T> findall();

    T findById(ID id);

    T create(T entity);

    T update(ID id, T entity);

    void delete(ID id);

}
