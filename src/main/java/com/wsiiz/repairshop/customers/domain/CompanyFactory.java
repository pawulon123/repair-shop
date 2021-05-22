package com.wsiiz.repairshop.customers.domain;

import com.wsiiz.repairshop.foundation.domain.AbstractFactory;
import org.springframework.stereotype.Component;

@Component()
public class CompanyFactory implements AbstractFactory<Company> {
    @Override
    public Company create() {
        return new Company();
    }
}
