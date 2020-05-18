package com.counter.service;

import com.counter.model.Counter;

import java.util.List;

public interface CounterService {

    void addCounter(Counter toAdd);
    void incrementCounter(String name);
    int getCounterValue(String name);
    void deleteCounter(String name);
    int getAbsoluteCounterValue();
    List<String> getAllCounterNames();
}
