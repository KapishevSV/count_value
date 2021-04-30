package ru.kapishev.count_value.counters_crud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CounterRepository extends JpaRepository<CounterModel, Integer> {

    @Query("SELECT c FROM CounterModel c WHERE c.sn = :sn")
    CounterModel findByName(@Param("sn") String name);
}
