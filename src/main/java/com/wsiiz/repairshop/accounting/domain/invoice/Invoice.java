package com.wsiiz.repairshop.accounting.domain.invoice;

import com.wsiiz.repairshop.foundation.domain.BaseEntity;
import com.wsiiz.repairshop.shareStore.StatusInvoice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Invoice extends BaseEntity {

    Long customerId;
    String CustomerAddress;
    @Enumerated(value = EnumType.STRING)
    StatusInvoice status;

}
