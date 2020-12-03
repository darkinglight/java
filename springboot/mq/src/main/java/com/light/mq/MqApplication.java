package com.light.mq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MqApplication {

	public static void main(String[] args) throws Exception {
		DefaultMQProducer producer = new DefaultMQProducer("PG-yearActivityUserTagChange");//实际组名
		producer.setToken("PT-455ab059-01ae-4264-9171-1e821fdeaac2");// 实际Token
		producer.setNamesrvAddr("game-operation-group-rocketmq-dev001-bdwg.qiyi.virtual:9876;game-operation-group-rocketmq-dev003-bdwg.qiyi.virtual:9876");// 实际地址，分号分隔
		producer.start();
		Message msg = new Message("gliveUserChatTag" /* Topic */,
				"TagA" /* Tag 用于消费过滤，可不指定*/,
				"ORDER-20170101-XXX", /* Key 用于消息查询，可以不指定*/
				("Hello RocketMQ").getBytes("UTF-8") /* Message body */
		);
		SendResult sendResult = producer.send(msg);
		System.out.printf("%s%n", sendResult);
		//Shut down once the producer instance is not longer in use.
		producer.shutdown();
	}
}
