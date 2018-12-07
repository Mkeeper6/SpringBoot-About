package com.mkeeper.entity;

import lombok.Builder;
import lombok.Data;


/**
 * CREATE TABLE `t_user` (
 * 	`user_id` INT ( 11 ) NOT NULL AUTO_INCREMENT,
 * 	`user_name` VARCHAR ( 255 ) NOT NULL,
 * 	`password` VARCHAR ( 255 ) NOT NULL,
 * 	`phone` VARCHAR ( 20 ) NOT NULL,
 * PRIMARY KEY ( `user_id` )
 * ) ENGINE = INNODB AUTO_INCREMENT = 1018 DEFAULT CHARSET = utf8;
 */
@Data
@Builder
public class User {
    private Integer userId;
    private String userName;
    private String password;
    private String phone;

}
