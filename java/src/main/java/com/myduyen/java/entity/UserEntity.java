package com.myduyen.java.entity;


import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "user")
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")

    private Integer age;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Collection<PhoneEntity> phone;
}
