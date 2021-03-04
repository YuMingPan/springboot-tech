package com.example.springbootrabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * rabbitmq 安装：
 *
 * <p>1.下载安装Erlang并配置环境变量
 * <p>2.下载安装RabbitMQ(官网下载)，接着安装RabbitMQ-Plugins
 * <p>3.一旦安装了Erlang和RabbitMQ，就可以将RabbitMQ节点作为Windows服务启动(任务管理器的服务菜单中可查看)
 * RabbitMQ服务将自动启动(即Plugins安装完rabbitmq的安装到此结束)
 * <p>4.访问地址 http://127.0.0.1:15672 默认账号密码 guest，程序访问时配置文件中RabbitMQ端口号设为5672
 * <p>5.大致可参考这篇文章 https://www.cnblogs.com/saryli/p/9729591.html
 */
@SpringBootApplication
public class SpringBootRabbitmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRabbitmqApplication.class, args);
    }

}
