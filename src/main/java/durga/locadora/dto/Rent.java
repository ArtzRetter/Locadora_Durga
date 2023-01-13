package durga.locadora.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Rent {
    private UUID rentId;
    private LocalDateTime devolution;
    private CustomerDto customer;
    private List<MovieDto> moviesList;
}
