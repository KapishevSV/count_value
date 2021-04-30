package ru.kapishev.count_value.counters_crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CounterController {
    private final CounterService counterService;

    @Autowired
    public CounterController(CounterService counterService) {
        this.counterService = counterService;
    }
    //чтение всех записей
    @GetMapping(value = "/counters")
    public ResponseEntity<List<CounterModel>> read() {
        final List<CounterModel> counter = counterService.readAll();

        return counter != null && !counter.isEmpty()
                ? new ResponseEntity<>(counter, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    //чтение одной записи, формат запроса: ?id=n
    @RequestMapping(value = "/counterid", method = RequestMethod.GET)
    public ResponseEntity<CounterModel> read(@RequestParam(name="id", required=false) int id){
        final CounterModel counter = counterService.read(id);

        return counter != null
                ? new ResponseEntity<>(counter, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    //чтение одной записи, формат запроса: ?sn=sn
    @RequestMapping(value = "/countersn", method = RequestMethod.GET)
    public ResponseEntity<CounterModel> readName(@RequestParam(name="sn", required=false) String sn){
        final CounterModel counter = counterService.getByName(sn);

        return counter != null
                ? new ResponseEntity<>(counter, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    //создание новой записи
    @PostMapping(value = "/counter")
    public ResponseEntity<?> create(@RequestBody CounterModel counterModel) {
        counterService.create(counterModel);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    //обновление записи, формат запроса: cat/n
    @PutMapping(value = "/counter/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody CounterModel counterModel) {
        final boolean updated = counterService.update(counterModel, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    //удвление записи, формат запроса: cat/n
    @DeleteMapping(value = "/counter/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = counterService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
