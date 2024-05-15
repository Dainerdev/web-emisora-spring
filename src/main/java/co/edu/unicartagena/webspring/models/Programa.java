
package co.edu.unicartagena.webspring.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Table(name = "programa")
@Data
public class Programa implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Id
    private int id;
    @NotEmpty
    private String nombre;
    @NotEmpty
    private String genero;
    @NotEmpty
    private int consorcio;
    
}
