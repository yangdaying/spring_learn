package com.example.demo.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.xml.internal.ws.developer.Serialization;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Serialization
@Table(name = "user_employee",uniqueConstraints ={@UniqueConstraint(columnNames = "name")} )
public class Employee {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "role")
    private String role;

    public Employee(String name,String role){
        this.name = name;
        this.role = role;
    }

}
