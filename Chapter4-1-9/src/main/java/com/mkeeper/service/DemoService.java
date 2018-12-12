package com.mkeeper.service;

import com.mkeeper.mapper.OrderMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DemoService {
    @Resource
    private OrderMapper orderMapper;

    public void demo() {
        /*for (int i = 1; i <= 10; i++) {
            Order order = new Order();
            order.setUserId(1);
            order.setOrderId(51 + i);
            order.setStatus("INSERT_TEST");
            orderMapper.insert(order);
        }*/

        System.out.println(orderMapper.findById(52));
    }
}
