package co.com.bancolombia.model.animales;


import lombok.*;


@Data
@Builder (toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor

public class Animales {
    private String idanimal;
    private int numPatas;
    private Character genero;
    private String especie;
    private String habitad;
    private boolean domestico;

}
