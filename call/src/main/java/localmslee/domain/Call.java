package localmslee.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import localmslee.CallApplication;
import localmslee.domain.CallCompleted;
import localmslee.domain.TaxiCalled;
import localmslee.domain.TaxiCanceled;
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

    private Integer charge;

    @PostPersist
    public void onPostPersist() {
        TaxiCalled taxiCalled = new TaxiCalled(this);
        taxiCalled.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        CallCompleted callCompleted = new CallCompleted(this);
        callCompleted.publishAfterCommit();
    }

    @PreUpdate
    public void onPreUpdate() {}

    @PreRemove
    public void onPreRemove() {
        TaxiCanceled taxiCanceled = new TaxiCanceled(this);
        taxiCanceled.publishAfterCommit();
    }

    public static CallRepository repository() {
        CallRepository callRepository = CallApplication.applicationContext.getBean(
            CallRepository.class
        );
        return callRepository;
    }
}
//>>> DDD / Aggregate Root
