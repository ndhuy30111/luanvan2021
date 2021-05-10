package com.stu.luanvan.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserModel{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "10000000")
    private Integer id;
    @Column(name = "username")
    private String userName;
    @Column(name="name")
    private String name;
    @Column(name = "password")
    private String password;
    @Column( name = "is_enabled")
    private boolean isEnabled;
    @Column(name = "create_date")
    @CreatedDate
    private Date create_date;
    @Column(name = "update_date")
    @LastModifiedDate
    private Date lastModifiedDate;
}
