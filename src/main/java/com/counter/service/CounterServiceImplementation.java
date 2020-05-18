package com.counter.service;

import com.counter.model.Counter;
import com.counter.repository.CounterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CounterServiceImplementation implements CounterService{

    private CounterRepository counterRepository;

    @Autowired
    public CounterServiceImplementation(CounterRepository counterRepository) {
        this.counterRepository = counterRepository;
    }


    @Override
    public void addCounter(Counter toAdd) {
        counterRepository.save(toAdd);
    }

    @Override
    public void incrementCounter(String name) {
        Counter toIncrement = counterRepository.findByName(name);
        toIncrement.setCurrentValue(toIncrement.getCurrentValue() + 1);
        counterRepository.save(toIncrement);
    }

    @Override
    public int getCounterValue(String name) {
        return counterRepository.findByName(name).getCurrentValue();
    }

    @Override
    public void deleteCounter(String name) {
        counterRepository.deleteByName(name);
    }

    @Override
    public int getAbsoluteCounterValue() {
        return counterRepository.getAbsoluteCounterValueNative();
    }

    @Override
    public List<String> getAllCounterNames() {
        return counterRepository.getAllNamesNative();
    }
}
