package localmslee.domain;

import java.util.*;
import localmslee.domain.*;
import localmslee.infra.AbstractEvent;
import lombok.*;

@Data
@ToString
public class AdvancePayment extends AbstractEvent {

    private Long id;
    private String customerId;
    private String driverId;
    private String status;
    private Date callDt;
    private Integer charge;
    private String paymentStatus;
}
