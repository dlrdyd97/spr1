package spr1.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import spr1.member.*;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        Long member = 1L; // long 는 null값 허용 안됨
        Member member1 = new Member(member, "MemberA", Grade.VIP);
        memberService.join(member1);
        Member findMember = memberService.findMember(1L);
        Order order = orderService.createOrder(member1.getId(), "Table", 10000);
        System.out.println("order = " + order);
        Assertions.assertThat(1L).isEqualTo(member1.getId());
        Assertions.assertThat(1000).isEqualTo(order.getDiscountPrice());
        Assertions.assertThat(9000).isEqualTo(order.calculatePrice());
        Assertions.assertThat(findMember).isEqualTo(member1);
    }

}
