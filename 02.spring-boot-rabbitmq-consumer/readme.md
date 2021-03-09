详见 https://blog.csdn.net/qq_35387940/article/details/100514134

首先队列会绑定到交换机上(同时设置routingKey)，发送消息时，通过参数的交换机名称来找到发送到哪个交换机上面，继而通过routingKey参数分发到哪个队列上面，消费者监听队列(队列名)即可

消费者接收消息时不想消息确认的话，直接用@RabbitListener(queues = "队列名")和@RabbitHandler处理返回信息即可

否则的话需要通过实现ChannelAwareMessageListener(监听器)重写onMessage方法来处理数据，同时可以进行消息确认，并将其注入到配置类当中(监听容器)
