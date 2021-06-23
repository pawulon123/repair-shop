package com.wsiiz.repairshop.accounting.domain.invoice;

import com.wsiiz.repairshop.customers.domain.Customer;
import com.wsiiz.repairshop.customers.domain.CustomerChangedEvent;
import com.wsiiz.repairshop.foundation.domain.AbstractService;
import com.wsiiz.repairshop.shareStore.StatusInvoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class InvoiceService implements AbstractService<Invoice>, ApplicationListener<CustomerChangedEvent> {
    @Autowired
    InvoiceRepository invoiceRepository;

    @Override
    public Invoice add(Invoice entity) {
        return invoiceRepository.save(entity);
    }

    @Override
    public void onApplicationEvent(CustomerChangedEvent event) {
        invoiceRepository.findByStatusAndCustomerId(StatusInvoice.PROFORMA, event.getCustomer().getId())
                .ifPresent(invoice -> {
                    String newAddress = buildAddress(event.getCustomer());
                    invoice.setCustomerAddress(newAddress);
                    if (!invoice.getCustomerAddress().equals(newAddress)) {
                        invoice.setCustomerAddress(newAddress);
                        invoiceRepository.save(invoice);
                    }
                });
    }

    private String buildAddress(Customer customer) {

        return customer.fullName() + (customer.getStationingAddress() == null ? " ":
                (customer.getStationingAddress().getPostalCode() + " "
                + customer.getStationingAddress().getCity() + "\n"
                + customer.getStationingAddress().getStreet() + " "
                + customer.getStationingAddress().getNumberBuilding()));
    }

}
