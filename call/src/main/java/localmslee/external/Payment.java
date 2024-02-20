package localmslee.external;

import java.util.Date;
import lombok.Data;

@Data
public class Payment {

    private Long id;
    private String customerId;
    private String driverId;
    private String status;
    private Date callDt;
    private Integer charge;
    private String paymentStatus;
}
