package localmslee.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import localmslee.PaymentApplication;
import localmslee.domain.AdvancePayment;
import localmslee.domain.FinalPayment;
import lombok.Data;

@Entity
@Table(name = "Payment_table")
@Data
//<<< DDD / Aggregate Root
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String customerId;

    private String driverId;

    private String paymentStatus;

    private Date paymentDt;

    private Integer charge;

    @PostPersist
    public void onPostPersist() {
        AdvancePayment advancePayment = new AdvancePayment(this);
        advancePayment.publishAfterCommit();

        FinalPayment finalPayment = new FinalPayment(this);
        finalPayment.publishAfterCommit();
    }

    @PreUpdate
    public void onPreUpdate() {}

    public static PaymentRepository repository() {
        PaymentRepository paymentRepository = PaymentApplication.applicationContext.getBean(
            PaymentRepository.class
        );
        return paymentRepository;
    }
}
//>>> DDD / Aggregate Root
