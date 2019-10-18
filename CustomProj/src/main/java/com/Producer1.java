package com;

import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class Producer1 {
    public static void main(String[] args) {

        String topic="person-avro";
        Properties prop= new Properties();
        prop.put("bootstrap.servers","localhost:9092");
        prop.put("key.serializer", StringSerializer.class.getName());
        prop.put("value.serializer", KafkaAvroSerializer.class.getName());
        prop.setProperty("schema.registry.url","http://localhost:8081");


        Person person =  Person.newBuilder()
                .setFirstName("Rahul")
                .setLastName("Kumar")
                .setBirthDate("28-Apr-1995")
                .setAddress("Laholi gaon")
                .setCity("New Delhi")
                .setEmailAddress("rahul@xyz.com").build();
        KafkaProducer<String, Person> kafkaProd= new KafkaProducer<>(prop);
        ProducerRecord<String, Person> prodRecord= new ProducerRecord<>(topic,person);
        kafkaProd.send(prodRecord, new Callback() {
            @Override
            public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                if(e!=null){
                    e.printStackTrace();
                }
                else{
                    System.out.println("Success on writing data on Producer topic");
                    System.out.println(recordMetadata);
                }
            }
        });

        kafkaProd.flush();
        kafkaProd.close();

    }
}
