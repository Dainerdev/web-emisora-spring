
package co.edu.unicartagena.webspring.services.programa;

import java.util.List;
import co.edu.unicartagena.webspring.crud.IProgramaCrud;
import co.edu.unicartagena.webspring.models.Programa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProgramaServiceImp implements IProgramaService{
    
    @Autowired
    IProgramaCrud crudPrograma;

    @Transactional(readOnly = true)
    @Override
    public List<Programa> listarProgramas() {
        return (List<Programa>) crudPrograma.findAll();
    }

    @Override
    public void guardar(Programa prog) {
        crudPrograma.save(prog);
    }

    @Transactional
    @Override
    public void eliminiar(Programa prog) {
        crudPrograma.delete(prog);
    }

    @Transactional(readOnly = true)
    @Override
    public Programa buscar(Programa prog) {
        return crudPrograma.findById(prog.getId()).orElse(null);
    }
    
}
