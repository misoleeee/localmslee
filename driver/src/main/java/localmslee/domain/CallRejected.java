package localmslee.domain;

import java.time.LocalDate;
import java.util.*;
import localmslee.domain.*;
import localmslee.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class CallRejected extends AbstractEvent {

    private Long id;
    private String driverId;
    private String driverLocation;
    private String paymentStatus;
    private String callStatus;
    private Date callDt;
    private Integer driverQty;
    private String customerId;

    public CallRejected(Driver aggregate) {
        super(aggregate);
    }

    public CallRejected() {
        super();
    }
}
//>>> DDD / Domain Event
