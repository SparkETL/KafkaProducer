package com;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.fluttercode.datafactory.impl.DataFactory;

import java.util.Properties;

public class Main {

    public static void main(String[] args) {

        String topicName= "prabhuTopicDF";
        //String key= "key2";
       // String value= "w2ow";

        Properties prop = new Properties();
        prop.put("bootstrap.servers","localhost:9092");
        prop.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        prop.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");


        DataFactory df = new DataFactory();

        for (int i = 0; i < 100; i++) {
            String line =
                    df.getFirstName() + "="+ df.getLastName()
                    + "=" +
                    df.getAddress();
            df.getBirthDate();
            df.getEmailAddress();
                  //flag
                    //create time
                    //update time
            //System.out.println(df.getFirstName());

            String key = Integer.toString(i);
            String value=line;
            Producer<String, String> prod= new KafkaProducer<>(prop);
            ProducerRecord<String,String> record= new ProducerRecord<>(topicName,key,value);
            prod.send(record);
            prod.close();
        }
    }
}