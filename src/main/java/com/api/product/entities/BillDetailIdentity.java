package com.api.product.entities;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class BillDetailIdentity implements Serializable {
    private Long productId;
    private Long billId;
}
