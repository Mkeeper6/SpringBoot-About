package com.mkeeper.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * CREATE TABLE `t_user` (
 *   `user_id` int(11) NOT NULL AUTO_INCREMENT,
 *   `user_name` varchar(255) NOT NULL,
 *   `password` varchar(255) NOT NULL,
 *   `phone` varchar(255) NOT NULL,
 *   PRIMARY KEY (`user_id`)
 * ) ENGINE=InnoDB AUTO_INCREMENT=1088 DEFAULT CHARSET=utf8;
 */


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer userId;

    private String userName;

    private String password;

    private String phone;
}