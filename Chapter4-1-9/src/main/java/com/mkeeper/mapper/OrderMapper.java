

package com.mkeeper.mapper;

import com.mkeeper.entity.Order;
import org.apache.ibatis.annotations.Mapper;

public interface OrderMapper {
    
    void createIfNotExistsTable();
    
    void truncateTable();
    
    Long insert(Order model);
    
    void delete(Long orderId);
    
    void dropTable();
}
