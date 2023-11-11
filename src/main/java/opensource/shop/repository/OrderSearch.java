package opensource.shop.repository;

import lombok.Getter;
import lombok.Setter;
import opensource.shop.domain.OrderStatus;

@Getter @Setter
public class OrderSearch {

    private String memberName;
    private OrderStatus orderStatus;
}
