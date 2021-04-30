package ru.kapishev.count_value.counters_crud;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CounterServiceImpl implements CounterService {
    private final CounterRepository counterRepository;

    public CounterServiceImpl(CounterRepository countersRepository) {
        this.counterRepository = countersRepository;
    }

    @Override
    public List<CounterModel> readAll(){
        return counterRepository.findAll();
    }

    @Override
    public CounterModel read(int id){
        return counterRepository.getOne(id);
    }

    @Override
    public void create(CounterModel countersModel){
        counterRepository.save(countersModel);
    }

    @Override
    public boolean update(CounterModel counterModel, int id) {
        if (counterRepository.existsById(id)) {
            counterModel.setId(id);
            counterRepository.save(counterModel);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if (counterRepository.existsById(id)) {
            counterRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public CounterModel getByName(String sn) {
        return counterRepository.findByName(sn);
    }
}
