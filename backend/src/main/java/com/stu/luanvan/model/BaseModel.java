package com.stu.luanvan.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "10000000")
    private Integer id;
    @Column(name = "create_by")
    @CreatedBy
    private String createBy;
    @Column(name = "update_by")
    @LastModifiedBy
    private String lastModifiedBy;
    @Column(name = "create_date")
    @CreatedDate
    private Date create_date;
    @Column(name = "update_date")
    @LastModifiedDate
    private Date lastModifiedDate;
}
