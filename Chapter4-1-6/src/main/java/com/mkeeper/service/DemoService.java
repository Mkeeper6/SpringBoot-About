package com.mkeeper.service;

import com.mkeeper.entity.Order;
import com.mkeeper.entity.OrderItem;
import com.mkeeper.entity.Stock;
import com.mkeeper.mapper.OrderItemMapper;
import com.mkeeper.mapper.OrderMapper;
import com.mkeeper.mapper.StockMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DemoService {
    
    @Resource
    private OrderMapper orderMapper;

    @Resource
    private StockMapper stockMapper;
    
    @Resource
    private OrderItemMapper orderItemMapper;
    
    public void demo() {
        for (int i = 1; i <= 10; i++) {

            Stock stock = new Stock();
            stock.setId(i);
            stock.setName("name " + i);
            stockMapper.insert(stock);

            Order order = new Order();
            order.setUserId(51 + i);
            order.setStatus("INSERT_TEST");
            orderMapper.insert(order);
            long orderId = order.getOrderId();

            OrderItem item = new OrderItem();
            item.setOrderId(orderId);
            item.setUserId(51 + i);
            orderItemMapper.insert(item);
        }
        System.out.println(orderItemMapper.selectAll());
    }
}
