package com.stu.luanvan.model.product;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.github.slugify.Slugify;
import com.stu.luanvan.locales.MessageLocales;
import com.stu.luanvan.locales.PatternLocales;
import com.stu.luanvan.model.BaseModel;
import com.stu.luanvan.model.category.CategoryModel;
import com.stu.luanvan.model.detailsproduct.DetailsProductModel;
import com.stu.luanvan.model.file.FileModel;
import com.stu.luanvan.model.invoicedetails.InvoiceDetailsModel;
import com.stu.luanvan.model.BaseViews;
import com.stu.luanvan.model.review.ReviewModel;
import com.stu.luanvan.request.ProductRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Collection;

@Entity
@Table(name ="product")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel extends BaseModel {

    @Column(columnDefinition = "NVARCHAR(50) NOT NULL UNIQUE COMMENT 'Tên của sản phẩm' ")
    @NotBlank(message = MessageLocales.NAME_NOTBLANK)
    @Pattern(regexp = PatternLocales.NAME_PATTERN, message = MessageLocales.NAME_PATTERN)
    @JsonView(BaseViews.Public.class)
    private String name;

    @Column(columnDefinition = "Bigint(19) default 1000000 COMMENT 'Giá tiền sản phẩm không được bé hơn 0 và mặc định là 1000000'")
    @Min(value= 0 ,message = "Số tiền không được < 0")
    @JsonView(BaseViews.Public.class)
    private Long price;

    @Column(columnDefinition = "bit default 0 COMMENT 'Sản phẩm được bán chạy hay không, Nếu có là 1 hoặc không là 0'")
    @JsonView(BaseViews.Public.class)
    private boolean hot;

    @Column(columnDefinition = "bit default 1 COMMENT 'Sản phẩm mới được bán, 1 là hàng mới hoặc 0 là hàng không còn mới'")
    @JsonView(BaseViews.Public.class)
    private boolean fresh;

    @Column(columnDefinition ="tinyint(1) default 0 COMMENT 'Đánh giá sản phẩm theo mức độ từ số 0 đến số 5 tính theo điểm sao ' " )
    @Min(value = 0,message = "Không có đánh giá mức thấp hơn 0")
    @Max(value = 5,message = "Không có đánh giá mức hơn")
    @JsonView(BaseViews.Public.class)
    private Integer rateLevel;

    @Column(columnDefinition = "TEXT COMMENT 'Nội dung chính của sản phẩm để giới thiệu' ")
    @JsonView(BaseViews.Public.class)
    private String info;

    @Column(columnDefinition = "NVARCHAR(255) COMMENT 'Nội dung ngắn của sản phẩm để giới thiệu nhanh'")
    @JsonView(BaseViews.Public.class)
    private String info_small;

    @OneToOne
    @JoinColumn
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "url")
    @JsonIdentityReference(alwaysAsId = true)
    private FileModel image;

    @Column(length = 60,unique = true,nullable = false)
    @JsonView(BaseViews.Public.class)
    private String url;

    @Column(columnDefinition = "tinyint(1) default 1 COMMENT 'Trạng thái của Sản phẩm'")
    @JsonView(BaseViews.Public.class)
    private Integer status;

    @OneToMany(mappedBy = "product")
    @JsonView(BaseViews.Internal.class)
    private Collection<InvoiceDetailsModel> invoicedetals;

    @OneToMany(mappedBy = "product")
    private Collection<DetailsProductModel> detailsProduct;

    @ManyToMany(mappedBy = "product")
    @JsonView(BaseViews.Public.class)
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class,property="name")
    @JsonIdentityReference(alwaysAsId = true)
    private Collection<CategoryModel> category;

    @OneToMany(mappedBy = "product")
    @JsonView(BaseViews.Public.class)
    private Collection<ReviewModel> review;

    public void setName( String name) {
        this.name = name.trim();
        this.url = new Slugify().slugify(this.name);
    }
    //Hàm tính điểm rate
    public void rateLevels(Integer rate){
        this.rateLevel=(this.rateLevel+ rate)/2;
    }


    public ProductModel( String name, Long price, String info, String info_small, FileModel image) {
        setName(name);
        this.price = price;
        this.info = info;
        this.info_small = info_small;
        this.image = image;
    }

    public void edit(ProductRequest pr){

        if(StringUtils.isEmpty(pr.getName())){
            setName(pr.getName());
        }

        if(pr.getPrice()>1000000){
            this.price = pr.getPrice();
        }

        if(StringUtils.isEmpty(pr.getInfo())){
            this.info = pr.getInfo();
        }

        if(StringUtils.isEmpty(pr.getInfo_small())){
            this.info_small = pr.getInfo_small();
        }
    }
}
