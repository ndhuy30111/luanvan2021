package com.stu.luanvan.model.invoice;

import com.stu.luanvan.locales.MessageLocales;
import com.stu.luanvan.locales.PatternLocales;
import com.stu.luanvan.model.BaseModel;
import com.stu.luanvan.model.invoicedetails.InvoiceDetailsModel;
import com.stu.luanvan.model.user.UserModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name="invoice")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceModel extends BaseModel {


    @Column(columnDefinition = "VARCHAR(13) NOT NULL COMMENT 'Số điện thoại khi giao hàng' ")
    @Pattern(regexp = PatternLocales.ADDRESS_PATTERN,message = MessageLocales.NUMBERPHONE_PATTERN)
    private String numberPhone;

    @Column(columnDefinition = "VARCHAR(200) NOT NULL")
    @Pattern(regexp = PatternLocales.NAME_PATTERN, message = MessageLocales.ADDRESS_NOTBLANK)
    private String address;

    @Column(columnDefinition = "tinyint(1) default 0 COMMENT 'Trạng thái của Hoá đơn'")
    private Integer status = 0;

    @Column(columnDefinition = "datetime(6) NULL COMMENT 'Ngày xuất bill'")
    private Date billDate;

    @Column(columnDefinition = "TEXT COMMENT 'Ghi chú của hoá đơn' ")
    private String note;

    @ManyToOne
    @JoinColumn(name = "createbill_by")
    private UserModel user;

    @OneToMany(mappedBy = "invoice")
    private Collection<InvoiceDetailsModel> invoicedetals;
}
