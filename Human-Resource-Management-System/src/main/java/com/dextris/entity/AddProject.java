package com.dextris.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AddProject {
    @Id
    private String employeeName;
    private String projectName;
    private String clientName;
    private String developingFlatform;
    private String dataBaseTechnology;
    private String projectDescribtion;


}
