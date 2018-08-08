package com.mkeeper.service.impl;

import com.mkeeper.service.ComputeService;

public class ComputeServiceImpl implements ComputeService {

    @Override
    public Integer add(int a, int b) {
        return a + b;
    }
}
