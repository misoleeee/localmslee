package localmslee.external;

import java.util.Date;
import lombok.Data;

@Data
public class Driver {

    private Long id;
    private String driverId;
    private String status;
    private Date callDt;
    private Integer driverQty;
    private String customerId;
    private Integer charge;
    private String paymentStatus;
}
