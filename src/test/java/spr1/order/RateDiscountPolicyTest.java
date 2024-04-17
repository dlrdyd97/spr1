package spr1.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import spr1.discount.DiscountPolicy;
import spr1.discount.RateDiscountPolicy;
import spr1.member.Grade;
import spr1.member.Member;

public class RateDiscountPolicyTest {

    DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 할인이 적용되어야 한다.")
    void vip_o(){
        Member member = new Member(1L, "memberA", Grade.VIP);
        int discount = discountPolicy.discount(member, 10000);
        Assertions.assertThat(1000).isEqualTo(discount);
    }

    @Test
    @DisplayName("BASIC는 할인이 적용되면 안된다.")
    void vip_x(){
        Member member = new Member(2L, "memberB", Grade.BASIC);
        int discount = discountPolicy.discount(member, 10000);
        Assertions.assertThat(0).isEqualTo(discount);
    }

}
