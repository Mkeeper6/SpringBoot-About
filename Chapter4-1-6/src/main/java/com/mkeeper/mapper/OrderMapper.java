

package com.mkeeper.mapper;

import com.mkeeper.entity.Order;

public interface OrderMapper {
    
    void createIfNotExistsTable();
    
    void truncateTable();
    
    Long insert(Order model);
    
    void delete(Long orderId);
    
    void dropTable();
}
