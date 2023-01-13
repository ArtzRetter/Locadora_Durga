package durga.locadora.dto;
import lombok.*;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class MovieDto {
    private UUID movieId;
    private String movieTitle;
    private String movieGenre;
    private int stock;
}
