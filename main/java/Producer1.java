
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.*;

public class Producer1
{
    public static void main(String args[])
    {
        //creating properties
        String bootstrapServers="127.0.0.1:9092";
        Properties properties=new Properties();

        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"CompanySerializer");
        //creating producer
        KafkaProducer first_producer= new KafkaProducer(properties);
        //Company kmc=new Company("KMC", "Chaitanya","160","40000");

        ProducerRecord<String,Company> record= new ProducerRecord<String,Company>("coding",new Company("KMC", "Chaitanya","160","40000"));
        System.out.println(record.value().toString());
        //Print object properties
       // System.out.println(topic.getEmployerName()+topic.getNoOfHours());
        //sending data
        first_producer.send(record);
       // System.out.println(record.toString());
        first_producer.flush();
        first_producer.close();

    }
}
