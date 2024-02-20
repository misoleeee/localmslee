package localmslee.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import localmslee.config.kafka.KafkaProcessor;
import localmslee.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    DriverRepository driverRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}


    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='TaxiCalled'"
    )
    public void TaxiCalled_CallAccepted(
        @Payload Driver driver
    ) {
        Driver event = driver;
        System.out.println("\n\n==================================================");
        System.out.println("##### listener IncreaseStock : " + driver + " / EventInfo : " + event + "\n\n");

        driverRepository.save(driver);
        System.out.println("\n\n==================================================");
        System.out.println("##### save Repository Information : " + driverRepository.findById(driver.getId()));

        // driver.setPrdStatus("결제완료");
        CallAccepted callAccepted = new CallAccepted(driver);
        callAccepted.publishAfterCommit();
    }
}
//>>> Clean Arch / Inbound Adaptor
