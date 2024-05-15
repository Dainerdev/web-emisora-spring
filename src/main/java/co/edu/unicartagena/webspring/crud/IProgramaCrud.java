
package co.edu.unicartagena.webspring.crud;

import co.edu.unicartagena.webspring.models.Programa;
import org.springframework.data.repository.CrudRepository;

public interface IProgramaCrud extends CrudRepository<Programa, Integer>{
    
}
