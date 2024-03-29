package localmslee.domain;

import java.time.LocalDate;
import java.util.*;
import localmslee.domain.*;
import localmslee.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class FinalPayment extends AbstractEvent {

    private Long id;
    private String customerId;
    private String driverId;
    private String status;
    private Date callDt;
    private Integer charge;
    private String paymentStatus;

    public FinalPayment(Payment aggregate) {
        super(aggregate);
    }

    public FinalPayment() {
        super();
    }
}
//>>> DDD / Domain Event
