
package co.edu.unicartagena.webspring.services.progresumen;

import co.edu.unicartagena.webspring.crud.IProgResumenCrud;
import co.edu.unicartagena.webspring.models.ProgResumen;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProgResumenServiceImp implements IProgResumenService{

    @Autowired
    IProgResumenCrud crudProgRes;
    
    @Transactional(readOnly = true)
    @Override
    public List<ProgResumen> listarProgResumen() {
        return (List<ProgResumen>) crudProgRes.findAll();
    }

    @Transactional
    @Override
    public void guardar(ProgResumen progres) {
        crudProgRes.save(progres);
    }

    @Transactional
    @Override
    public void eliminar(ProgResumen progres) {
        crudProgRes.delete(progres);
    }

    @Transactional(readOnly = true)
    @Override
    public ProgResumen buscar(ProgResumen progres) {
        return crudProgRes.findById(progres.getId()).orElse(null);
    }    
    
}
