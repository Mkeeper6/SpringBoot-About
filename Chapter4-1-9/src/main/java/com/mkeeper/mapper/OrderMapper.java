

package com.mkeeper.mapper;

import com.mkeeper.entity.Order;

public interface OrderMapper {
    
    void createIfNotExistsTable();
    
    void truncateTable();
    
    Integer insert(Order model);

    Order findById(Integer orderId);
    
    void delete(Integer orderId);
    
    void dropTable();
}
