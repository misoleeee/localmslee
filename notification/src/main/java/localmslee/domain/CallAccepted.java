package localmslee.domain;

import java.util.*;
import localmslee.domain.*;
import localmslee.infra.AbstractEvent;
import lombok.*;

@Data
@ToString
public class CallAccepted extends AbstractEvent {

    private Long id;
    private String driverId;
    private String driverLocation;
    private String paymentStatus;
    private String callStatus;
    private Date callDt;
    private Integer driverQty;
}
