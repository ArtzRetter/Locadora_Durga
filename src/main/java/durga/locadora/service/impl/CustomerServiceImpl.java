package durga.locadora.service.impl;

import durga.locadora.dto.CustomerDto;
import durga.locadora.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    private ArrayList<CustomerDto> customerList = new ArrayList<CustomerDto>();

    @Override
    public ArrayList<CustomerDto> createCustomer(String name, String cpf) {
        customerList.add(
                CustomerDto.builder()
                        .id(UUID.randomUUID())
                        .name(name)
                        .cpf(cpf)
                        .build()
        );
        return customerList;
    }

    @Override
    public ArrayList<CustomerDto> getCustomer() {
        return customerList;
    }

    @Override
    public void deleteList(String customerId){
        for (CustomerDto customer:customerList){
            if (customer.getId().equals(UUID.fromString(customerId))){
                customerList.remove(customer);
            }
        }
    };

    @Override
    public ArrayList<CustomerDto> updateProfile(CustomerDto updateCustomer){
        for (int i=0; i < customerList.size(); i++){
            if (customerList.get(i).getId().equals(updateCustomer.getId())){
                customerList.set(i,updateCustomer);
            }
        }
    return customerList;
    };

}
