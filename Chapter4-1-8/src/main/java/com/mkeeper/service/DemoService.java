package com.mkeeper.service;

import com.mkeeper.entity.Order;
import com.mkeeper.entity.OrderItem;
import com.mkeeper.mapper.OrderItemMapper;
import com.mkeeper.mapper.OrderMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DemoService {
    @Resource
    private OrderMapper orderMapper;

    @Resource
    private OrderItemMapper orderItemMapper;

    public void demo() {
        for (int i = 1; i <= 10; i++) {
            Order order = new Order();
            order.setUserId(1);
            order.setOrderId(51 + i);
            order.setStatus("INSERT_TEST");
            orderMapper.insert(order);
            long orderId = order.getOrderId();

            OrderItem item = new OrderItem();
            item.setOrderItemId(51 + i);
            item.setOrderId(orderId);
            item.setUserId(1);
            orderItemMapper.insert(item);
        }

        for (int i = 1; i <= 10; i++) {
            Order order = new Order();
            order.setUserId(2);
            order.setOrderId(100 + i);
            order.setStatus("INSERT_TEST");
            orderMapper.insert(order);
            long orderId = order.getOrderId();

            OrderItem item = new OrderItem();
            item.setOrderItemId(100 + i);
            item.setOrderId(orderId);
            item.setUserId(2);
            orderItemMapper.insert(item);
        }

        System.out.println(orderItemMapper.selectAll().size());
    }
}
