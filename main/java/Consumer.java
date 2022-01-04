import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.Properties;


public class Consumer {
    public static void main(String args[])
    {
        //Logger logger= LoggerFactory.getLogger(Consumer.class.getName());
        String bootstrapServers="127.0.0.1:9092";
        String grp_id="seconhvjlhvtffgdtr";
        String topic="coding";
        // creating consumer properties
        Properties properties=new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServers);
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,"CompanyDeserializer");
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG,grp_id);
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");

        //creating consumer
        KafkaConsumer<String,Company> consumer= new KafkaConsumer(properties);
        //subscribing
        consumer.subscribe(Arrays.asList("coding"));
        //polling
        while (true)
        {
            ConsumerRecords<String,Company> records=consumer.poll(Duration.ofMillis(200));
            for(ConsumerRecord<String,Company> record:records)
            {
             //   logger.info("Key"+record.key() +",Value" +record.value());
              //  logger.info("Partition:" +record.partition()+",Offset:"+record.offset());
                Company values=record.value();

                System.out.println(values.toString());
                /*        "Employer-name" + record.value().getEmployerName().toString() +
                                " Employee  Name = " + record.value().getEmployeeName().toString() +
                                " No of Hours= " + record.value().getNoOfHours().toString() + "Salary= " +record.value().getSalary().toString());*/
            }
            //consumer.close();
        }
    }
}
