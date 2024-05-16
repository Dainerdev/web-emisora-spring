
package co.edu.unicartagena.webspring.services.persona;

import co.edu.unicartagena.webspring.crud.IPersonaCrud;
import co.edu.unicartagena.webspring.models.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonaServiceImp implements IPersonaService{

    @Autowired
    IPersonaCrud crudPersona;

    @Transactional(readOnly = true)
    @Override
    public List<Persona> listarPersonas() {
        return (List<Persona>) crudPersona.findAll();
    }

    @Transactional
    @Override
    public void guardar(Persona per) {
        crudPersona.save(per);
    }

    @Transactional
    @Override
    public void eliminiar(Persona per) {
        crudPersona.delete(per);
    }

    @Transactional(readOnly = true)
    @Override
    public Persona buscar(Persona per) {
        return crudPersona.findById(per.getId()).orElse(null);
    }    
    
}
