package ru.kapishev.count_value.counters_crud;

import java.util.List;

public interface CounterService {
    List<CounterModel> readAll();

    CounterModel read(int id);

    void create(CounterModel counterModel);

    boolean update(CounterModel counterModel, int id);

    boolean delete(int id);

    CounterModel getByName(String sn);
}
