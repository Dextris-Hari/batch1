package com.dextris.transaction.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor@NoArgsConstructor
public class EmployeeRequestVO {

    private String employeeName;
    private String email;
    private String departmentName;

}
