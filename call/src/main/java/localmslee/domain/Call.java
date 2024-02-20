package localmslee.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import localmslee.CallApplication;
import localmslee.domain.CallCanceled;
import localmslee.domain.CallCompleted;
import localmslee.domain.TaxiCalled;
import lombok.Data;

@Entity
@Table(name = "Call_table")
@Data
//<<< DDD / Aggregate Root
public class Call {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String customerId;

    private String status;

    private Date callDt;

    @PostPersist
    public void onPostPersist() {
        TaxiCalled taxiCalled = new TaxiCalled(this);
        taxiCalled.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        CallCanceled callCanceled = new CallCanceled(this);
        callCanceled.publishAfterCommit();

        CallCompleted callCompleted = new CallCompleted(this);
        callCompleted.publishAfterCommit();
    }

    @PreUpdate
    public void onPreUpdate() {}

    @PreRemove
    public void onPreRemove() {}

    public static CallRepository repository() {
        CallRepository callRepository = CallApplication.applicationContext.getBean(
            CallRepository.class
        );
        return callRepository;
    }
}
//>>> DDD / Aggregate Root
