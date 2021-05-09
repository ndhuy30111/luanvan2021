package com.myduyen.java.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "phone")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PhoneEntity {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "phone")
    private Integer phoneNumber;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private UserEntity user;
}
