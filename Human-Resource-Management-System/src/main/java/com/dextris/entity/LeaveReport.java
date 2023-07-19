package com.dextris.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class LeaveReport {
    @Id
    private String employeeName;
    private Date fromDate;
    private Date toDate;
    private String reasonForLeave;
}
