package com.sparta.jpaquiz.entity;

import com.sparta.jpaquiz.dto.OrderDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "P_ORDER")
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderNumber;

    private LocalDateTime createdAt;

    private String status;

    /**
     * TODO 2(Entity 생성자 기본값 설정): @PrePersist를 사용해 createdAt, status 필드에 기본값을 설정합니다.
     * <hr/>
     * Entity 가 생성되는 시점에 createdAt, status 를 설정해주세요!<br/><br/>
     * 조건: createdAt은 현재시간(LocalDateTime.now()) 으로 설정<br/>
     * 조건: status 는 "PENDING" 으로 설정<br/>
     *
     * @return @PrePersist 어노테이션을 사용하여 객체가 생성되는 시점에 필드에 값을 추가합니다.
     */

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.status = "PENDING";
    }


     // TODO 5: Entity 가 Dto 에 의존하는 '의존성 역전 원칙 위반'을 수정

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

}

