package localmslee.domain;

import java.time.LocalDate;
import java.util.*;
import localmslee.domain.*;
import localmslee.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class CallCanceled extends AbstractEvent {

    private Long id;
    private String driverId;
    private String driverLocation;
    private String paymentStatus;
    private String callStatus;
    private Date callDt;
    private Integer driverQty;

    public CallCanceled(Driver aggregate) {
        super(aggregate);
    }

    public CallCanceled() {
        super();
    }
}
//>>> DDD / Domain Event
