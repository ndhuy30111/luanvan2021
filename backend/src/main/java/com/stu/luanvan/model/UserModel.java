package com.stu.luanvan.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserModel{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @Column(name="numberphone")
    private Integer numberPhone;
    @Column(name="address")
    private String address;
    @Column(name="status")
    private Integer status;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @ToString.Exclude
    private Collection<InvoiceModel> createBill;
    //Khoá ngoại với Role
    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(
                    name="user_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name="role_id",referencedColumnName = "id")
    )
    private Collection<RoleModel> role;


}
