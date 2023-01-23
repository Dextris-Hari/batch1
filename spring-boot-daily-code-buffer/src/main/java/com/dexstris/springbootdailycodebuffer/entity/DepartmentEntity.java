package com.dexstris.springbootdailycodebuffer.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentEntity {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     @NotBlank(message = "please add the adress")
     /*@Length(max = 20,min = 2)
     @Size(max = 2,min = 1)*/
     private String departmentAdress;


}
