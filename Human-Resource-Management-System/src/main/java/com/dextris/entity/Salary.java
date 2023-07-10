package com.dextris.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Salary {
    @Id

    private String employeeName;
    private Double amount;
    private Date date;
    private String month;
}
