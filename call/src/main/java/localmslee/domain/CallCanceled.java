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
    private String customer;
    private String status;
    private Date callDt;

    public CallCanceled(Call aggregate) {
        super(aggregate);
    }

    public CallCanceled() {
        super();
    }
}
//>>> DDD / Domain Event
