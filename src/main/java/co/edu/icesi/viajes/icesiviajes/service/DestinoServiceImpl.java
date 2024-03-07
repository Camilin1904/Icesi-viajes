package co.edu.icesi.viajes.icesiviajes.service;

import co.edu.icesi.viajes.icesiviajes.domain.Destino;
import co.edu.icesi.viajes.icesiviajes.repository.DestinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Scope("singleton")
@Service
public class DestinoServiceImpl implements DestinoService{

    @Autowired
    DestinoRepository destinoRepository;

    @Override
    public List<Destino> findDestinoByCodigoAndEstado(String codigo, String estado) throws Exception{
        if(estado == null || codigo == null){
            throw new Exception("Invalid fields");
        }
        return destinoRepository.findDestinoByCodigoAndEstado(codigo,estado);
    }

    @Override
    public List<Destino> findDestinoByIdTide(Long idTiDe) throws Exception {
        if(idTiDe == null){
            throw new Exception("Invalid field");
        }
        return destinoRepository.findDestinoByIdTide(idTiDe);
    }

    @Override
    public List<Destino> findAllByEstado(String estado) throws Exception {
        if(estado == null){
            throw new Exception("Invalid field");
        }
        return destinoRepository.findAllByEstado(estado);
    }

    @Override
    public List<Destino> findAll() {
        return destinoRepository.findAll();
    }

    @Override
    public Optional<Destino> findByID(Long aLong) {
        return destinoRepository.findById(aLong);
    }

    @Override
    public Destino save(Destino entity) throws Exception {
        if(findByID(entity.getIdDest()).isPresent()){
            throw new Exception("Element already exists");
        }
        return destinoRepository.save(entity);
    }

    @Override
    public Destino update(Destino entity) throws Exception {
        if(findByID(entity.getIdDest()).isEmpty()){
            throw new Exception("Element already exists");
        }
        return destinoRepository.save(entity);
    }

    @Override
    public void delete(Destino entity) throws Exception {
        if(findByID(entity.getIdDest()).isEmpty()){
            throw new Exception("Element already exists");
        }
        destinoRepository.delete(entity);
    }

    @Override
    public void deleteById(Long aLong) throws Exception {
        if(findByID(aLong).isEmpty()){
            throw new Exception("Element already exists");
        }
        destinoRepository.deleteById(aLong);
    }

    @Override
    public void validate(Destino entity) throws Exception {

    }

    @Override
    public long count() {
        return destinoRepository.count();
    }

    public long countByIdTide(Long idTide){
        return destinoRepository.countByIdTide(idTide);
    }
}
