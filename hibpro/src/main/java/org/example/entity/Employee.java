package org.example.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tbl_employee")
@lombok.Getter
@lombok.Setter
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.ToString
@NamedQueries({@NamedQuery(name = "findByName" ,query = "select info from Employee info where info.name=:name"),
@NamedQuery(name = "findAll" ,query = "select info from Employee info "),
@NamedQuery(name = "updateByName",query = "update  Employee info set info.dob=:dob,info.mobile=:mobile where info.name=:name"),
@NamedQuery(name = "deleteByName" ,query = "delete from Employee info where info.name=:name")})
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "e_name")
    private String name;
    @Column(name = "e_dob")
    private String dob;
    @Column(name = "e_mobile")
    private String mobile;
}
