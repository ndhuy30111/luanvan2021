package com.stu.luanvan.request;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.stu.luanvan.model.RoleModel;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    @NotBlank(message = "Bạn không được bỏ trống userName")
    @Pattern(regexp = "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,48}[a-zA-Z0-9]$",message = "Tài khoản không hợp lệ")
    private String userName;
    @NotBlank(message = "Bạn không được bỏ trống name")
    @Pattern(regexp = "^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s\\W|_]+$", message = "Tên người dùng không hợp lệ")
    private String name;
    @Email(message = "Không phải email")
    @NotBlank(message = "Bạn không được bỏ trống email")
    private String email;
    @NotBlank(message = "Bạn không được bỏ trống password")
    private String password;
}
