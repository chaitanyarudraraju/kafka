
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.*;

public class Asyncproducer
{
    public static void main(String args[])
    {
        //creating properties
        String bootstrapServers="127.0.0.1:9092";
        Properties properties=new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        //creating producer
        KafkaProducer<String,String> async_producer= new KafkaProducer<String,String>(properties);


        ProducerRecord<String,String> record= new ProducerRecord<>("kafka","Asynchronousproducer");
        //sending data
        async_producer.send(record, new Callback() {
            @Override
            public void onCompletion(RecordMetadata recordMetadata, Exception e) {

            }
        });

        async_producer.flush();
        async_producer.close();

    }
}
