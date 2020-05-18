package com.counter.repository;

import com.counter.model.Counter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CounterRepository extends CrudRepository<Counter, Long> {

    Counter findByName(String name);

    void deleteByName(String name);

    @Query(value = "SELECT SUM(CURRENT_VALUE) FROM Counter", nativeQuery = true)
    int getAbsoluteCounterValueNative();

    @Query(value = "SELECT NAME FROM Counter ", nativeQuery = true)
    List<String> getAllNamesNative();
}
