package durga.locadora.controller;

import durga.locadora.dto.CustomerDto;
import durga.locadora.dto.MovieDto;
import durga.locadora.dto.Rent;
import durga.locadora.exceptions.SoldOutException;
import durga.locadora.service.RentService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/rent")
public class RentController {

    @Autowired
    private RentService rentService;

    @PostMapping(value = "/create")
    public ResponseEntity<?> renting(
            @RequestParam(name = "customer",required = true) String customerRentId,
            @RequestParam(name = "movie", required = true) List<UUID> movieRentId
            ) throws SoldOutException {
        return ResponseEntity.status(HttpStatus.CREATED).body(rentService.createRent(customerRentId,movieRentId));
    }

    @GetMapping(value = "/list")
    public ResponseEntity<?> rentList(){return ResponseEntity.status(HttpStatus.OK).body(rentService.getRentList());
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<?> deleteRent(
            @RequestParam(name = "customerRenId", required = true) String customerRentId
    ){
        rentService.deleteRent(customerRentId);
        return ResponseEntity.status(HttpStatus.OK).body("Aluguel deletado");
    }

    @PutMapping(value = "/update")
    public ResponseEntity updateRent(
            @NonNull
            @RequestBody Rent updateRent){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(rentService.updateRent(updateRent));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Você precisa preencher todos os campos");
        }
    }
}
