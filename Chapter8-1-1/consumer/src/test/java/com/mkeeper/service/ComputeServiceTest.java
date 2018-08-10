package com.mkeeper.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ComputeServiceTest {

    @Autowired
    ComputeService computeService;

    @Test
    public void add() {
        Assert.assertEquals(new Integer(3), computeService.add(1, 2));
    }
}