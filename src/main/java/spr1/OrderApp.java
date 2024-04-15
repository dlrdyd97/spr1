package spr1;

import spr1.member.Grade;
import spr1.member.Member;
import spr1.member.MemberService;
import spr1.member.MemberServiceImpl;
import spr1.order.Order;
import spr1.order.OrderService;
import spr1.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice = " + order.calculatePrice());
    }

}
