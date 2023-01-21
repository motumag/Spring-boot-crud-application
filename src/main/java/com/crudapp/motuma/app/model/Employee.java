package com.crudapp.motuma.app.model;

import lombok.Data;
import javax.persistence.*;
//This is an empty which is needed to create a table called employees in sql server db
//You shoud not have to forget all this three annotations specially.
//@Data, @Entity and Table.
//Note! spring.jpa.hibernate.ddl-auto=update  if you make this seeting none, your table can't be created.
@Data
@Entity
@Table(name="employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private  long id;
    @Column(name="first_name", nullable = false) //first name could'nt be an empty
    private String  firtName;
    @Column(name="last_name")
    private  String lastName;
    @Column(name="email")
    private  String email;
}
