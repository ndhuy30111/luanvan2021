package com.stu.luanvan.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Email;
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

    @Column(columnDefinition = "VARCHAR(50) NOT NULL COMMENT 'Tên của khách hàng' ")
    @Pattern(regexp = "^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s\\W|_]+$", message = "Tên người dùng không hợp lệ")
    private String name;

    @Column(columnDefinition = "VARCHAR(50) NOT NULL COMMENT 'email'")
    @Email
    private String email;

    @Column
    @JsonBackReference
    private String password;

    @Column
    private boolean isEnabled;

    @Column
    @CreatedDate
    private Date createDate;

    @Column
    @LastModifiedDate
    private Date lastmodifiedDate;

    @Column(columnDefinition = "VARCHAR(13) NULL COMMENT 'Số điện thoại khách hàng' ")
    @Pattern(regexp = "(84|0[3|5|7|8|9])+([0-9]{8})\\b")
    private Integer numberPhone;

    @Column(columnDefinition = "VARCHAR(200) NULL COMMENT 'địa chỉ hiện tại'")
    private String address;

    @Column
    private String accessToken;

    @Column(columnDefinition = "tinyint(1) default 0 COMMENT 'Trạng thái của khách hàng'")
    private Integer status;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @ToString.Exclude
    private Collection<InvoiceModel> createBill;
    @OneToMany(mappedBy = "user")
    private Collection<RateModel> rate;

    @OneToMany(mappedBy = "user")
    private Collection<ReviewModel> review;
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

    public void setPassword(String password) {
        var bry = new BCryptPasswordEncoder();
        this.password = bry.encode(password) ;
    }
}
