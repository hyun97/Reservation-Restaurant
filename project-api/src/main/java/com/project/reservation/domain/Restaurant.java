package com.project.reservation.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Restaurant {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String address;

    @Transient // 사용되지 않는 임시
    @JsonInclude(JsonInclude.Include.NON_NULL) // null 일 경우 표시하지 않음
    private List<MenuItem> menuItems;


    public String getInformation() {
        return name + " in " + "Seoul";
    }

    public void updateInformation(String name, String address) {
        this.name = name;
        this.address = address;
    }

}
