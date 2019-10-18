package com;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

public class Consumer {
    public static void main(String[] args) {

        String topicName= "prabhuTopicDF";
        String groupName= "PrabhuGroup";
        //String key= "key1";
        //String value= "ashley";

        //  value.deserializer = class org.apache.kafka.common.serialization.StringDeserializer

        Properties prop = new Properties();
        prop.put("bootstrap.servers","localhost:9092");
        prop.put("group.id",groupName);
        prop.put("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        prop.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String,String> consumer= new KafkaConsumer<>(prop);
        consumer.subscribe(Arrays.asList(topicName));



        while (true){
            ConsumerRecords<String,String> records= consumer.poll(100);
            for (ConsumerRecord<String,String> record: records){
                System.out.println("Record pairs: "+ record.key()+" => " +record.value());
            }

        }

    }
}
