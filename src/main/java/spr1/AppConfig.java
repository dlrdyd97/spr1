package spr1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spr1.discount.DiscountPolicy;
import spr1.discount.FixDiscountPolicy;
import spr1.discount.RateDiscountPolicy;
import spr1.member.MemberService;
import spr1.member.MemberServiceImpl;
import spr1.member.MemoryMemberRepository;
import spr1.order.OrderService;
import spr1.order.OrderServiceImpl;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public static MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
