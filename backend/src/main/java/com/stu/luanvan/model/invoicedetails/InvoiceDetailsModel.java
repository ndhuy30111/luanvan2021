package com.stu.luanvan.model.invoicedetails;

import com.stu.luanvan.model.invoice.InvoiceModel;
import com.stu.luanvan.model.key.InvoiceDetailsKey;
import com.stu.luanvan.model.product.ProductModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Table(name="invoice_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceDetailsModel {

    @EmbeddedId
    InvoiceDetailsKey id;
    @Column(name = "name",columnDefinition = "VARCHAR(80) NOT NULL COMMENT 'Tên sản phẩm trong hoá đơn theo đi Quy định thế này ( Tên sản phẩm - Tên màu - Tên size ) '")
    private String name;

    @Column(name="price",columnDefinition = "bigint(19) not null COMMENT 'Giá tiền tại thời điểm được mua' ")
    @Min(value = 0,message = "Giá tiền không thể < 0")
    private Long price;

    @Column(name = "amount",columnDefinition = "int(5) not null COMMENT 'Số lượng sản phẩm được mua và không được bé hơn không' ")
    @Min(value = 1 , message = "Số lượng không được bé ")
    private Integer amount;

    @ManyToOne
    @MapsId("invoiceId")
    @JoinColumn(name="invoice_id")
    private InvoiceModel invoice;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name="product_id")
    private ProductModel product;
}
