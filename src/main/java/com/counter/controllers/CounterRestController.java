package com.counter.controllers;

import com.counter.model.Counter;
import com.counter.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rest")
public class CounterRestController {

    private CounterService counterService;

    @Autowired
    public CounterRestController(CounterService counterService) {
        this.counterService = counterService;
    }

    @PostMapping("/add-counter/{name}")
    public ResponseEntity<Counter> addCounter(@PathVariable("name") String name) {
        Counter toAdd = new Counter(name);
        try {
            counterService.addCounter(toAdd);
            return ResponseEntity.ok().body(toAdd);
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    @PutMapping("/increment/{name}")
    public void incrementCounter(@PathVariable("name") String name) {
        counterService.incrementCounter(name);
    }

    @GetMapping("/get-value/{name}")
    public int getCounterValue(@PathVariable("name") String name) {
        return counterService.getCounterValue(name);
    }

    @DeleteMapping("/delete/{name}")
    public void deleteCounter(@PathVariable("name") String name) {
        counterService.deleteCounter(name);
    }

    @GetMapping("/get-absolute")
    public int getAbsoluteCounterValue() {
        return counterService.getAbsoluteCounterValue();
    }

    @GetMapping("/get-all-names")
    public List<String> getAllCounterNames() {
        return counterService.getAllCounterNames();
    }
}
