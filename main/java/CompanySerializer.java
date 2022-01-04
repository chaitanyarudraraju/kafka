import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;
import org.omg.CORBA.Object;

import java.nio.ByteBuffer;
import java.util.Map;

public class CompanySerializer implements Serializer<Company> {
    private String encoding = "UTF8";

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {/*Nothing to configure*/}

    @Override
    public byte[] serialize(String topic, Company company) {
        int sizeOfEmployerName;
        int sizeOfEmployeeName;
        int sizeNoOfHours;
        int sizeOfSalary;
        byte[] serializedEmployerName;
        byte[] serializedEmployeeName;
        byte[] serializedNoOfHours;
        byte[] serializedSalary;

        try {
            if (company == null)
                return null;
            serializedEmployerName = company.getEmployerName().getBytes(encoding);
            sizeOfEmployerName = serializedEmployerName.length;

            serializedEmployeeName = company.getEmployeeName().getBytes(encoding);
            sizeOfEmployeeName = serializedEmployeeName.length;

            serializedSalary = company.getSalary().getBytes(encoding);
            sizeOfSalary = serializedSalary.length;

            serializedNoOfHours = company.getNoOfHours().getBytes(encoding);
            sizeNoOfHours = serializedNoOfHours.length;


            ByteBuffer buffer = ByteBuffer.allocate(4 + 4 + sizeOfEmployerName + 4 + sizeOfEmployeeName + 4 + sizeOfSalary + 4 + sizeNoOfHours);

            buffer.putInt(sizeOfEmployerName);
            buffer.put(serializedEmployerName);
            buffer.putInt(sizeOfEmployeeName);
            buffer.put(serializedEmployeeName);
            buffer.putInt(sizeNoOfHours);
            buffer.put(serializedNoOfHours);
            buffer.putInt(sizeOfSalary);
            buffer.put(serializedSalary);

            return buffer.array();
        } catch (Exception e) {
            throw new SerializationException("Error while seriliazing ");
        }
    }
    @Override
    public void close()
    {//nothing to do
    }
    }





