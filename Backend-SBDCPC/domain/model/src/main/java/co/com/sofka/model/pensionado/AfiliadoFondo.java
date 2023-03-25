package co.com.sofka.model.pensionado;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class AfiliadoFondo {
    private Integer identificacion;
    private Integer idFondo;
}
