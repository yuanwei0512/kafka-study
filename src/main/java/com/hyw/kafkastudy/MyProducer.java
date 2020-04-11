package com.hyw.kafkastudy;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.*;
import java.util.concurrent.Future;

/**
 * @Auther: Huangyuanwei
 * @Date: 2019/10/31 18:38
 * @Description:
 */
public class MyProducer {

    private static KafkaProducer<String, String> producer;

    static {

        Properties properties = new Properties();
        properties.put("bootstrap.servers", "39.108.157.26:9092");

        properties.put("key.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");

        producer = new KafkaProducer<>(properties);
    }

    private static void sendMessageSync() throws Exception {

        ProducerRecord<String, String> record = new ProducerRecord<>(
                "hyw-kafka-study", "name", "syddnc"
        );
        RecordMetadata result = producer.send(record).get();

        System.out.println(result.topic());
        System.out.println(result.partition());
        System.out.println(result.offset());

        producer.close();
    }

    private static void sendMessageCallback(){
        ProducerRecord<String, String> record = new ProducerRecord<>(
                "hyw-kafka-study", "name", "syddncddddd"
        );
        producer.send(record, (recordMetadata, e) ->{
            if (e != null) {
                e.printStackTrace();
                return;
            }

            System.out.println(recordMetadata.topic());
            System.out.println(recordMetadata.partition());
            System.out.println(recordMetadata.offset());
            System.out.println("Coming in MyProducerCallback");
        });
        producer.close();
    }

    public static void main(String[] args) throws Exception {
        sendMessageSync();
    }

}
