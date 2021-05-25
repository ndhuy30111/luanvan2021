package com.stu.luanvan.model.role;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.stu.luanvan.model.json.Views;
import com.stu.luanvan.model.user.UserModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "role")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    @Pattern(regexp = "^[\\p{L} . '-]+$", message = "Tên không hợp lệ")
    @JsonView(Views.Internal.class)
    private String name;

    @ManyToMany(mappedBy = "role")
    @JsonBackReference
    private Collection<UserModel> user;

}
