package durga.locadora.dto;

import lombok.*;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class CustomerDto {

    private UUID id;

    private String name;

    private String cpf;
}
