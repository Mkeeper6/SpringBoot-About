

package com.mkeeper.mapper;

import com.mkeeper.entity.OrderItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface OrderItemMapper {
    
    void createIfNotExistsTable();
    
    void truncateTable();
    
    Long insert(OrderItem model);
    
    void delete(Long orderItemId);
    
    List<OrderItem> selectAll();
    
    void dropTable();
}
