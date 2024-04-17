package spr1;

import spr1.discount.DiscountPolicy;
import spr1.discount.FixDiscountPolicy;
import spr1.discount.RateDiscountPolicy;
import spr1.member.MemberService;
import spr1.member.MemberServiceImpl;
import spr1.member.MemoryMemberRepository;
import spr1.order.OrderService;
import spr1.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private static MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }

}
