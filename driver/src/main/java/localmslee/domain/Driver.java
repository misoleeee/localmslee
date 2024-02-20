package localmslee.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import localmslee.DriverApplication;
import localmslee.domain.CallAccepted;
import localmslee.domain.CallCanceled;
import localmslee.domain.CallRejected;
import localmslee.domain.TaxiDepartured;
import lombok.Data;

@Entity
@Table(name = "Driver_table")
@Data
//<<< DDD / Aggregate Root
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String driverId;

    private String driverLocation;

    private String paymentStatus;

    private String callStatus;

    private Date callDt;

    private Integer driverQty;

    @PostPersist
    public void onPostPersist() {
        CallAccepted callAccepted = new CallAccepted(this);
        callAccepted.publishAfterCommit();

        TaxiDepartured taxiDepartured = new TaxiDepartured(this);
        taxiDepartured.publishAfterCommit();
    }

    @PreRemove
    public void onPreRemove() {
        CallRejected callRejected = new CallRejected(this);
        callRejected.publishAfterCommit();

        CallCanceled callCanceled = new CallCanceled(this);
        callCanceled.publishAfterCommit();
    }

    public static DriverRepository repository() {
        DriverRepository driverRepository = DriverApplication.applicationContext.getBean(
            DriverRepository.class
        );
        return driverRepository;
    }
}
//>>> DDD / Aggregate Root
