package localmslee.external;

import java.util.Date;
import lombok.Data;

@Data
public class Driver {

    private Long id;
    private String driverId;
    private String driverLocation;
    private String paymentStatus;
    private String callStatus;
    private Date callDt;
    private Integer driverQty;
    private String customerId;
}
