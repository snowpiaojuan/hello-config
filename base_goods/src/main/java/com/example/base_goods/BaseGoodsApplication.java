package com.example.base_goods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author vicky
 * @date 2019/5/27
 * ServletComponentScan 用来扫描@WebServlet、@WebFilter、@WebListener，让Servlet、Filter、Listener自动注册
 */
@ServletComponentScan
@SpringBootApplication
@MapperScan(basePackages = {"com.example.base_common.mapper"})
public class BaseGoodsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseGoodsApplication.class, args);
    }

}
