package co.edu.icesi.viajes.icesiviajes.service;

import co.edu.icesi.viajes.icesiviajes.domain.TipoDestino;
import co.edu.icesi.viajes.icesiviajes.repository.TipoDestinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Scope("singleton")
@Service
public class TipoDestinoServiceImpl implements TipoDestinoService{

    @Autowired
    private TipoDestinoRepository tipoDestinoRepository;

    @Override
    public List<TipoDestino> findAll() {

        return tipoDestinoRepository.findAll();
    }

    @Override
    public Optional<TipoDestino> findByID(Long id) {
        return tipoDestinoRepository.findById(id);
    }

    @Override
    public TipoDestino save(TipoDestino entity) throws Exception {
        if(findByID(entity.getIdTide()).isPresent()){
            throw new Exception("Element already exists");
        }
        return tipoDestinoRepository.save(entity);
    }

    @Override
    public TipoDestino update(TipoDestino entity) throws Exception {
        if(findByID(entity.getIdTide()).isEmpty()){
            throw new Exception("Element does not exists");
        }
        return tipoDestinoRepository.save(entity);
    }

    @Override
    public void delete(TipoDestino entity) throws Exception {
        if(findByID(entity.getIdTide()).isEmpty()){
            throw new Exception("Element does not exists");
        }
        tipoDestinoRepository.delete(entity);
    }

    @Override
    public void deleteById(Long id) throws Exception {
        if(findByID(id).isEmpty()){
            throw new Exception("Element does not exists");
        }
        tipoDestinoRepository.deleteById(id);
    }

    @Override
    public void validate(TipoDestino entity) throws Exception {

    }

    @Override
    public long count() {
        return tipoDestinoRepository.count();
    }

    @Override
    public List<TipoDestino> findByCodigo(String codigo) throws Exception{
        if(codigo == null){
            throw new Exception("Invalid field");
        }
        return tipoDestinoRepository.findByCodigo(codigo);
    }

    @Override
    public List<TipoDestino> findByCodigoAndEstadoIgnoreCase(String codigo, String estado) throws Exception{
        if(codigo == null || estado == null){
            throw new Exception("Invalid field");
        }
        return tipoDestinoRepository.findByCodigoAndEstadoIgnoreCase(codigo,estado);
    }

    @Override
    public List<Object[]> orderByPopularity(){
        return tipoDestinoRepository.orderByPopularity();
    }
}
