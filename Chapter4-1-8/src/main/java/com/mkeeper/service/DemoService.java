/*
 * Copyright 2016-2018 shardingsphere.io.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

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
