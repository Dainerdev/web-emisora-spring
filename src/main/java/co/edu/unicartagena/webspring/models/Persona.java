
package co.edu.unicartagena.webspring.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Table(name = "persona")
@Data
public class Persona implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Id
    private int id;
    @NotEmpty
    private String cedula;
    @NotEmpty
    private String nombre;
    @NotEmpty
    private String produccion;
    @NotEmpty
    private int productora;
    @NotEmpty
    private int programa;
    @NotEmpty
    private int progResumen;
    @NotEmpty
    private String rol;
    
}
