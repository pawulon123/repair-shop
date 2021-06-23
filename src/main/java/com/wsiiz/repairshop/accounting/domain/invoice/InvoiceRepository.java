package com.wsiiz.repairshop.accounting.domain.invoice;

import com.wsiiz.repairshop.shareStore.StatusInvoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    Optional<Invoice> findByStatusAndCustomerId(StatusInvoice status, Long customerId);

}
