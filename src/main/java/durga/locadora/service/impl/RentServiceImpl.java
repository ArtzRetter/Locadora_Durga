package durga.locadora.service.impl;

import durga.locadora.dto.CustomerDto;
import durga.locadora.dto.MovieDto;
import durga.locadora.dto.Rent;
import durga.locadora.exceptions.SoldOutException;
import durga.locadora.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class RentServiceImpl implements RentService {

    @Autowired
    private CustomerServiceImpl customerServiceImpl;
    @Autowired
    private MovieServiceImpl movieServiceImpl;

    private ArrayList<Rent> rentList = new ArrayList<>();

    @Override
    public ArrayList<Rent> createRent(String customerRentId, List<UUID> movieRentId) throws SoldOutException {
        List<MovieDto> movieList = movieServiceImpl.getMovieList();
        List<CustomerDto> customerList = customerServiceImpl.getCustomer();
        List<MovieDto> rentMovieList = new ArrayList<>();

        createRent(
                customerRentId,
                movieRentId,
                movieList,
                customerList,
                rentMovieList
        );

        return rentList;
    }

    private void createRent(
            String customerRentId,
            List<UUID> movieRentId,
            List<MovieDto> movieList,
            List<CustomerDto> customerList,
            List<MovieDto> rentMovieList
    ) {
        for (CustomerDto customers: customerList){
            if (customers.getId().equals(customerRentId));{

                updateStock(
                        movieRentId,
                        movieList,
                        rentMovieList
                );

                rentList.add(
                        Rent.builder()
                                .rentId(UUID.randomUUID())
                                .customer(customers)
                                .moviesList(rentMovieList)
                                .build()
                );
            }
        }
    }

    private void updateStock(List<UUID> movieRentId, List<MovieDto> movieList, List<MovieDto> rentMovieList) {
        for (MovieDto movies: movieList){
            for (UUID movieId: movieRentId){
                if (movies.getMovieId().equals(movieId)){
                        if (movies.getStock() > 0){
                            movies.setStock(movies.getStock()-1);
                            rentMovieList.add(movies);
                        }
                }
            }
        }
    }

    ;

    @Override
    public ArrayList<Rent> getRentList(){
        return rentList;
    }

    @Override
    public void deleteRent(String customerRentId){
        for (Rent rent:rentList){
            if (rent.getRentId().equals(UUID.fromString(customerRentId))){
                rentList.remove(rent);
            }
        }
    }

    @Override
    public ArrayList<Rent> updateRent(Rent updateRent){
        for (int h=0; h < rentList.size(); h++){
            if (rentList.get(h).getRentId().equals(updateRent.getRentId())){
                rentList.set(h,updateRent);
            }
        }
    return rentList;
    }

    public ArrayList<Rent> devolutionRent (Rent DevolutionRentId){

        List<MovieDto> movieList = movieServiceImpl.getMovieList();

        for (int l=0; l < rentList.size(); l++){
            if (rentList.get(l).getRentId().equals(DevolutionRentId.getRentId())){
                movieList.get(l).setStock(movieList.get(l).getStock()+1);

            }
        }
    return rentList;
    }
}
