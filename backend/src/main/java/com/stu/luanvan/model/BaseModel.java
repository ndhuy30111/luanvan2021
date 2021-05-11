package com.stu.luanvan.model;

import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;
    @CreatedBy
    @OneToOne
    @JoinColumn(name="create_by")
    private UserModel createBy;
    @OneToOne
    @LastModifiedBy
    @JoinColumn(name="update_by")
    private UserModel lastModifiedBy;
    @Column(name = "create_date")
    @CreatedDate
    private Date create_date;
    @Column(name = "update_date")
    @LastModifiedDate
    private Date lastModifiedDate;
}
