package com;

import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Collections;
import java.util.Properties;

public class Consumer1 {
    public static void main(String[] args) {
        String topic="person-avro";
        String groupName="person-avro-consumer";
        Properties prop= new Properties();
        prop.put("bootstrap.servers","localhost:9092");
        prop.put("group.id",groupName);
        prop.setProperty("enable.auto.commit","false");
        prop.setProperty("auto.offset.reset","none");
        prop.put("key.deserializer", StringDeserializer.class.getName());
        prop.put("value.deserializer", KafkaAvroDeserializer.class.getName());
        prop.setProperty("schema.registry.url","http://localhost:8081");
        prop.setProperty("specific.avro.reader","true");

        KafkaConsumer<String,Person> kafkaCons =new KafkaConsumer<>(prop);
        kafkaCons.subscribe(Collections.singleton(topic));

        while(true){
            ConsumerRecords<String,Person> consumerRecords= kafkaCons.poll(500);
            for (ConsumerRecord<String,Person> record: consumerRecords){
                Person p= record.value();
                System.out.println(p);
            }
        kafkaCons.commitSync();
        }


    }
}
