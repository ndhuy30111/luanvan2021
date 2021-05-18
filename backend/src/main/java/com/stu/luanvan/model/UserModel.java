package com.stu.luanvan.model;

import com.fasterxml.jackson.annotation.*;
import com.stu.luanvan.model.json.Views;
import com.stu.luanvan.request.UserRequest;
import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "userName")
public class UserModel{
    @Id
    @GeneratedValue
    @JsonView(Views.Internal.class)
    private Integer id;
    @Column(name = "username",columnDefinition = "VARCHAR(50) NOT NULL",unique = true)
    @Pattern(regexp = "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,48}[a-zA-Z0-9]$",message = "Tài khoản không hợp lệ")
    @JsonView(Views.Public.class)
    private String userName;

    @Column(columnDefinition = "VARCHAR(50) NOT NULL COMMENT 'Tên của khách hàng' ")
    @Pattern(regexp = "^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s\\W|_]+$", message = "Tên người dùng không hợp lệ")
    @JsonView(Views.Public.class)
    private String name;

    @Column(columnDefinition = "VARCHAR(50) NOT NULL COMMENT 'email'")
    @Email
    @JsonView(Views.Public.class)
    private String email;

    @Column
    @JsonIgnore
    private String password;

    @Column
    @JsonView(Views.Public.class)
    private boolean isEnabled;

    @Column(columnDefinition = "VARCHAR(13) default 0  COMMENT 'Số điện thoại khách hàng' ")
    @Pattern(regexp = "(84|0[3|5|7|8|9])+([0-9]{8})\\b")
    @JsonView(Views.Public.class)
    private String numberPhone;

    @Column(columnDefinition = "VARCHAR(200) NULL COMMENT 'địa chỉ hiện tại'")
    @JsonView(Views.Public.class)
    private String address;

    @Column
    private String accessToken;

    @Column(columnDefinition = "tinyint(1) default 0 COMMENT 'Trạng thái của khách hàng'")
    private Integer status;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<InvoiceModel> createBill;


    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<ReviewModel> review ;

    //Khoá ngoại với Role
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(
                    name="user_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name="role_id",referencedColumnName = "id")
    )
    @JsonView(Views.Internal.class)
    private Collection<RoleModel> role;

    public void setPassword(String password) {
        var bry = new BCryptPasswordEncoder();
        this.password = bry.encode(password) ;
    }

    public UserModel(UserRequest userRequest) {
        this.userName = userRequest.getUserName();
        this.name = userRequest.getName();
        this.email = userRequest.getEmail();
        setPassword(userRequest.getPassword());
    }
}
