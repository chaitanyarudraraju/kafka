
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.*;

public class Synproducer
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
        KafkaProducer<String,String> sync_producer= new KafkaProducer<String,String>(properties);
        ProducerRecord<String,String> record= new ProducerRecord<>("kafka","synchronousproducer");
        //sending data
        try {
            sync_producer.send(record).get();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        sync_producer.flush();
        sync_producer.close();

    }
}
