package jpashop.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

/*@Entity
@Table(name = "ORDERS")*/
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private Long id;

    /**
     * 객체 설계를 테이블 설계에 맞춘 방식으로 테이블의 외래키를 객체에 그대로 가져오는 문제점이있다.
     * 객체 그래프 탐색이 불가능
     * Member member; 이런식으로 있는게 객체 설계
     * */
    @Column(name = "MEMBER_ID")
    private Long memberId;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
