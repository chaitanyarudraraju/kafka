import java.nio.ByteBuffer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import java.util.Map;

public class CompanyDeserializer implements Deserializer<Company>{
        private String encoding = "UTF8";
        @Override
        public void configure(Map<String, ?> configs, boolean isKey) {
            //Nothing to configure
        }
@Override
    public Company deserialize(String topic, byte[] data) {

        try {
            if (data == null){
                System.out.println("Null recieved at deserialize");
                return null;
            }

            ByteBuffer buffer = ByteBuffer.wrap(data);
            int sizeOfEmployeeName = buffer.getInt();
            byte[] employeeNameBytes = new byte[sizeOfEmployeeName];
            buffer.get(employeeNameBytes);
            String deserializedEmployeeName = new String(employeeNameBytes, encoding);

            int sizeOfEmployerName = buffer.getInt();
            byte[] employerNameBytes = new byte[sizeOfEmployerName];
            buffer.get(employerNameBytes);
            String deserializedEmployerName = new String(employerNameBytes, encoding);

            int sizeOfNoOfHours = buffer.getInt();
            byte[] NoOfHoursBytes = new byte[sizeOfNoOfHours];
            buffer.get(NoOfHoursBytes);
            String deserializedNoOfHours = new String(NoOfHoursBytes, encoding);

            int sizeOfSalary = buffer.getInt();
            byte[] SalaryBytes = new byte[sizeOfSalary];
            buffer.get(SalaryBytes);
            String deserializedSalary = new String(SalaryBytes, encoding);


            return new Company(deserializedEmployerName,deserializedEmployeeName,deserializedNoOfHours,deserializedSalary);

        } catch (Exception e) {
            throw new SerializationException("Error when deserialize byte[] ");
        }
    }

    @Override
    public void close() {
        // nothing to do
    }
}

