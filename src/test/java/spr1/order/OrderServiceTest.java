package spr1.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import spr1.member.*;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        long member = 1L;
        Member member1 = new Member(member, "MemberA", Grade.VIP);
        memberService.join(member1);
        Order order = orderService.createOrder(member1.getId(), "Table", 10000);
        System.out.println("order = " + order);
        Assertions.assertThat(1L).isEqualTo(member1.getId());
        Assertions.assertThat(1000).isEqualTo(order.getDiscountPrice());
        Assertions.assertThat(9000).isEqualTo(order.calculatePrice());
    }

}
