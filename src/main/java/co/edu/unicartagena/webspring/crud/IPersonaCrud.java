
package co.edu.unicartagena.webspring.crud;

import co.edu.unicartagena.webspring.models.Persona;
import org.springframework.data.repository.CrudRepository;

public interface IPersonaCrud extends CrudRepository<Persona, Integer>{
    
}
