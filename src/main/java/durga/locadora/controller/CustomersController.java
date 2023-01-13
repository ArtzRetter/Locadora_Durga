package durga.locadora.controller;

import durga.locadora.dto.CustomerDto;
import durga.locadora.service.CustomerService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@RequestMapping("/customer")
public class CustomersController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(value = "/create")
    public ResponseEntity<?> createCustomer(
            @RequestParam(name = "name", required = true) String customerName,
            @RequestParam(name = "cpf", required = true) String cpf
    ){
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.createCustomer(customerName,cpf));
    }
    @GetMapping(value = "/list")
    public ResponseEntity<?> customerList(){
        return ResponseEntity.status(HttpStatus.OK).body(customerService.getCustomer());
    };
    @DeleteMapping(value = "/delete")
    public ResponseEntity deleteCustomerList(
            @RequestParam(name = "customerId", required = true) String customerId
    ){
        customerService.deleteList(customerId);
        return ResponseEntity.status(HttpStatus.OK).body("usuario deletado");
    }

    @PutMapping(value = "/update")
    public ResponseEntity updateProfile(
            @NonNull
            @RequestBody CustomerDto updateProfile
            ){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(customerService.updateProfile(updateProfile));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("você precisa preencher todos os campos");
        }
    };
}
