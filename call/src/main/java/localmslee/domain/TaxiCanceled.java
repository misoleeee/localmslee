package localmslee.domain;

import java.time.LocalDate;
import java.util.*;
import localmslee.domain.*;
import localmslee.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class TaxiCanceled extends AbstractEvent {

    private Long id;
    private String status;
    private Date callDt;
    private String customerId;
    private Integer charge;

    public TaxiCanceled(Call aggregate) {
        super(aggregate);
    }

    public TaxiCanceled() {
        super();
    }
}
//>>> DDD / Domain Event
