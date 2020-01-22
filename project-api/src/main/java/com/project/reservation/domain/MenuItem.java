package com.project.reservation.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity // 테이블에 대응하는 클래스
@Getter
@NoArgsConstructor
public class MenuItem {

    @Id // primary key
    @GeneratedValue // primary key 생성 방식
    private Long id;

    private Long restaurantId;
    private String name;

    public MenuItem(String name) {
        this.name = name;
    }
}
