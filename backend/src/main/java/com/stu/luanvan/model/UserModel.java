package com.stu.luanvan.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
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
    @Column(name = "username",columnDefinition = "VARCHAR(50) NOT NULL",unique = true)
    @Pattern(regexp = "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,48}[a-zA-Z0-9]$",message = "Tài khoản không hợp lệ")
    private String userName;
    @Column
    private String name;
    @Column
    private String password;
    @Column
    private boolean isEnabled;
    @Column
    @CreatedDate
    private Date createDate;
    @Column
    @LastModifiedDate
    private Date lastmodifiedDate;
    @Column
    private Integer numberPhone;
    @Column
    private String address;
    @Column
    private String accessToken;
    @Column
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
