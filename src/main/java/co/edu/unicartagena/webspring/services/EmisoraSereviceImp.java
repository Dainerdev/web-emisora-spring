
package co.edu.unicartagena.webspring.services;

import java.util.List;
import co.edu.unicartagena.webspring.crud.IEmisoraCrud;
import co.edu.unicartagena.webspring.models.Emisora;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmisoraSereviceImp implements IEmisoraService{
    
    @Autowired
    IEmisoraCrud crudEmisora;
    
    @Transactional(readOnly = true)
    @Override
    public List<Emisora> listarEmisoras() {
        return (List<Emisora>) crudEmisora.findAll();
    }

    @Transactional
    @Override
    public void guardar(Emisora emi) {
        crudEmisora.save(emi);
    }

    @Transactional
    @Override
    public void eliminiar(Emisora emi) {
        crudEmisora.delete(emi);
    }

    @Transactional(readOnly = true)
    @Override
    public Emisora buscar(Emisora emi) {
        return crudEmisora.findById(emi.getId()).orElse(null);
    }
    
}
