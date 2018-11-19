

package com.mkeeper.mapper;

import com.mkeeper.entity.OrderItem;

import java.util.List;


public interface OrderItemMapper {
    
    void createIfNotExistsTable();
    
    void truncateTable();
    
    Long insert(OrderItem model);
    
    void delete(Long orderItemId);
    
    List<OrderItem> selectAll();
    
    void dropTable();
}
