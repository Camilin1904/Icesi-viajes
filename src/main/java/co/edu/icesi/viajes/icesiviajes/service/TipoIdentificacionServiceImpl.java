package co.edu.icesi.viajes.icesiviajes.service;

import co.edu.icesi.viajes.icesiviajes.domain.TipoIdentificacion;
import co.edu.icesi.viajes.icesiviajes.repository.TipoIdentificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Scope("singleton")
@Service
public class TipoIdentificacionServiceImpl implements TipoIdentificacionService{

    @Autowired
    TipoIdentificacionRepository tipoIdentificacionRepository;

    @Override
    public List<TipoIdentificacion> findAll() {
        return tipoIdentificacionRepository.findAll();
    }

    @Override
    public Optional<TipoIdentificacion> findByID(Long aLong) {
        return tipoIdentificacionRepository.findById(aLong);
    }

    @Override
    public TipoIdentificacion save(TipoIdentificacion entity) throws Exception {
        if(findByID(entity.getIdTiid()).isPresent()){
            throw new Exception("Element already exists");
        }
        return tipoIdentificacionRepository.save(entity);
    }

    @Override
    public TipoIdentificacion update(TipoIdentificacion entity) throws Exception {
        if(findByID(entity.getIdTiid()).isEmpty()){
            throw new Exception("Element already exists");
        }
        return tipoIdentificacionRepository.save(entity);
    }

    @Override
    public void delete(TipoIdentificacion entity) throws Exception {
        if(findByID(entity.getIdTiid()).isEmpty()){
            throw new Exception("Element already exists");
        }
        tipoIdentificacionRepository.delete(entity);
    }

    @Override
    public void deleteById(Long aLong) throws Exception {
        if(findByID(aLong).isEmpty()){
            throw new Exception("Element already exists");
        }
        tipoIdentificacionRepository.deleteById(aLong);
    }

    @Override
    public void validate(TipoIdentificacion entity) throws Exception {

    }

    @Override
    public long count() {
        return tipoIdentificacionRepository.count();
    }

    @Override
    public List<TipoIdentificacion> orderedTipoIdentificacion(){
        return tipoIdentificacionRepository.orderedTipoIdentificacion();
    }

    @Override
    public List<TipoIdentificacion> findTipoIdentificacionByCodigoAndEstado(String codigo, String estado) throws Exception{
        if(codigo == null || estado == null){
            throw new Exception("Invalid fields");
        }
        return tipoIdentificacionRepository.findTipoIdentificacionByCodigoAndEstado(codigo,estado);
    }

    @Override
    public long countByEstado(String estado) throws Exception {
        if(estado == null){
            throw new Exception("Invalid field");
        }
        return tipoIdentificacionRepository.countByEstado(estado);
    }
}
