package localmslee.domain;

import java.util.*;
import localmslee.domain.*;
import localmslee.infra.AbstractEvent;
import lombok.*;

@Data
@ToString
public class FinalPayment extends AbstractEvent {

    private Long id;
    private String customerId;
    private String driverId;
    private String paymentStatus;
    private Date paymentDt;
}
