
package co.edu.unicartagena.webspring.crud;

import co.edu.unicartagena.webspring.models.Productora;
import org.springframework.data.repository.CrudRepository;

public interface IProductoraCrud extends CrudRepository<Productora, Integer>{
    
}
