package com.stu.luanvan.model;

import com.github.slugify.Slugify;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Collection;

@Entity
@Table(name ="product")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel extends BaseModel{
    @Column(columnDefinition = "NVARCHAR(50) NOT NULL UNIQUE COMMENT 'Tên của sản phẩm' ")
    @NotBlank(message = "Bạn không được để trống name")
    private String name;
    @Column(columnDefinition = "Bigint(19) default 1000000 COMMENT 'Giá tiền sản phẩm không được bé hơn 0 và mặc định là 1000000'")
    @Min(value= 0 ,message = "Số tiền không được < 0")
    private Long price;
    @Column(columnDefinition = "bit default 0 COMMENT 'Sản phẩm được bán chạy hay không, Nếu có là 1 hoặc không là 0'")
    private boolean hot;
    @Column(columnDefinition = "bit default 1 COMMENT 'Sản phẩm mới được bán, 1 là hàng mới hoặc 0 là hàng không còn mới'")
    private boolean fresh;
    @Column(columnDefinition ="tinyint(1) default 0 COMMENT 'Đánh giá sản phẩm theo mức độ từ số 0 đến số 5 tính theo điểm sao ' " )
    @Min(value = 0,message = "Không có đánh giá mức thấp hơn 0")
    @Max(value = 5,message = "Không có đánh giá mức hơn")
    private Integer rateLevel;
    @Column(columnDefinition = "TEXT COMMENT 'Nội dung chính của sản phẩm để giới thiệu' ")
    private String info;
    @Column(columnDefinition = "NVARCHAR(255) COMMENT 'Nội dung ngắn của sản phẩm để giới thiệu nhanh'")
    private String info_small;
    @Column(length = 60,unique = true,nullable = false)
    private String url;
    @Column(columnDefinition = "tinyint(1) default 1 COMMENT 'Trạng thái của Sản phẩm'")
    private Integer status;
    @OneToMany(mappedBy = "product")
    private Collection<InvoiceDetailsModel> invoicedetals;
    public void setName(String name) {
        this.name = name;
        this.url = new Slugify().slugify(this.name);
    }
    //Hàm tính điểm rate
    public void rateLevels(Integer rate){
        this.rateLevel=(this.rateLevel+ rate)/2;
    }

}
