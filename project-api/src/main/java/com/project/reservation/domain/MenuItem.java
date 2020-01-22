package com.project.reservation.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity // 테이블에 대응하는 클래스
public class MenuItem {

    @Id // primary key
    @GeneratedValue // primary key 생성 방식
    private Long id;

    private Long restaurantId;
    private String name;

    public MenuItem() {
    }

    public MenuItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
