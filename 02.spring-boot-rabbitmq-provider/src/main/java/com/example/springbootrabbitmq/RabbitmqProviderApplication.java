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
 *
 * 首先队列会绑定到交换机上(同时设置routingKey)
 * 发送消息时，通过参数的交换机名称来找到发送到哪个交换机上面，继而通过routingKey参数分发到哪个队列上面
 * 消费者监听队列(队列名)即可
 */
@SpringBootApplication
public class RabbitmqProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqProviderApplication.class, args);
    }

}
