package com.example.sd21102.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Temp {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "ho_ten")
    private String hoTen;

    @Column(name = "ten_lop")
    private String tenLop;

    @Override
    public String toString() {
        return "Temp{" +
                "id=" + id +
                ", hoTen='" + hoTen + '\'' +
                ", tenLop='" + tenLop + '\'' +
                '}';
    }
}
