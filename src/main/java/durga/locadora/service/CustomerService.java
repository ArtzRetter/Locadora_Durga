package durga.locadora.service;

import durga.locadora.dto.CustomerDto;
import java.util.ArrayList;

public interface CustomerService {

    ArrayList<CustomerDto> createCustomer(String name, String cpf);

    ArrayList<CustomerDto> getCustomer();

    void deleteList (String customerId);

    ArrayList<CustomerDto> updateProfile (CustomerDto updateCustomer);
}
