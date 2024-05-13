
package co.edu.unicartagena.webspring.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

@Entity
@Table(name = "emisora")
@Data
public class Emisora implements Serializable{

    private static final long SerialVersionUID = 1L;
    @Id
    private int id;
    private String nombre;
    private double frecuencia;
    private String transmision;
    
}
