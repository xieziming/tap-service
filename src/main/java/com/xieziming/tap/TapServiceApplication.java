/*
 * Author: Suny Xie
 * Email: inbox@xieziming.com
 * Copyright (c) 2017 xieziming.com All rights reserved.
 */
package com.xieziming.tap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Application configuration file.
 *
 * @author Suny Xie
 */
@SpringBootApplication
@EnableCaching
@EnableTransactionManagement
public class TapServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(TapServiceApplication.class, args);
	}
}
