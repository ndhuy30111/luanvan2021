package com.stu.luanvan.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name="invoice")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceModel extends BaseModel{

    @Column(columnDefinition = "VARCHAR(13) NOT NULL COMMENT 'Số điện thoại khi giao hàng' ")
    @Pattern(regexp = "(84|0[3|5|7|8|9])+([0-9]{8})\\b")
    private String numberPhone;

    @Column(columnDefinition = "VARCHAR(200) NOT NULL")
    private String address;

    @Column(columnDefinition = "tinyint(1) default 0 COMMENT 'Trạng thái của Hoá đơn'")
    private Integer status;

    @Column(columnDefinition = "datetime(6) NULL COMMENT 'Ngày xuất bill'")
    private Date billDate;

    @Column(columnDefinition = "TEXT COMMENT 'Ghi chú của hoá đơn' ")
    private String note;

    @ManyToOne
    @JoinColumn(name = "createbill_by")
    @ToString.Exclude
    private UserModel user;

    @OneToMany(mappedBy = "invoice")
    private Collection<InvoiceDetailsModel> invoicedetals;
}
