package durga.locadora.service;

import durga.locadora.dto.CustomerDto;
import durga.locadora.dto.MovieDto;
import durga.locadora.dto.Rent;
import durga.locadora.exceptions.SoldOutException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface RentService {
    ArrayList<Rent> createRent (String customerRentId, List<UUID> movieRentId) throws SoldOutException;

    ArrayList<Rent> getRentList();

    void deleteRent (String customerRentId);

    ArrayList updateRent(Rent updateRent);

}
