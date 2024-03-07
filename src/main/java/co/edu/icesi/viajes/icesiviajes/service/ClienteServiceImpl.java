package co.edu.icesi.viajes.icesiviajes.service;

import co.edu.icesi.viajes.icesiviajes.domain.Cliente;
import co.edu.icesi.viajes.icesiviajes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Scope("singleton")
@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> findClienteByEstado(String estado) throws Exception{
        if(estado == null){
            throw new Exception("Invalid field");
        }
        return clienteRepository.findClienteByEstado(estado);
    }
    @Override
    public List<Cliente> findClienteByCorreoIgnoreCase(String correo) throws Exception{
        if(correo == null){
            throw new Exception("Invalid field");
        }
        return clienteRepository.findClienteByCorreoIgnoreCase(correo);
    }
    @Override
    public List<Cliente> findClienteByIdClie(String id) throws Exception{
        if(id == null){
            throw new Exception("Invalid field");
        }
        return clienteRepository.findClienteByIdClie(id);
    }
    @Override
    public List<Cliente> findClienteByNombre(String nombre) throws Exception{
        if(nombre == null){
            throw new Exception("Invalid field");
        }
        return clienteRepository.findClienteByNombre(nombre);
    }
    @Override
    public List<Cliente> findClienteByFechaNacimientoBetween(Date fechaInicio, Date fechaFin) throws Exception{
        if(fechaInicio == null || fechaFin == null){
            throw new Exception("Invalid fields");
        }
        return clienteRepository.findClienteByFechaNacimientoBetween(fechaInicio,fechaFin);
    }
    @Override
    public Page<Cliente> findClienteByIdCliePage(Long id, Pageable page) throws Exception{
        if(id == null || page == null){
            throw new Exception("Invalid fields");
        }
        return clienteRepository.findClienteByIdClie(id,page);
    }
    @Override
    public List<Cliente> findClienteByLastNames(String firstLastName, String secondLastName) throws Exception{
        if(firstLastName == null || secondLastName == null){
            throw new Exception("Invalid fields");
        }
        return clienteRepository.findClienteByLastNames(firstLastName,secondLastName);
    }
    @Override
    public List<Cliente> findClienteByNumeroIdentificacion(String numeroIdentificacion) throws Exception{
        if(numeroIdentificacion == null){
            throw new Exception("Invalid field");
        }
        return clienteRepository.findClienteByNumeroIdentificacion(numeroIdentificacion);
    }

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> findByID(Long aLong) {
        return clienteRepository.findById(aLong);
    }

    @Override
    public Cliente save(Cliente entity) throws Exception {
        if(findByID(entity.getIdClie()).isPresent()){
            throw new Exception("Element already exists");
        }
        return clienteRepository.save(entity);
    }

    @Override
    public Cliente update(Cliente entity) throws Exception {
        if(findByID(entity.getIdClie()).isEmpty()){
            throw new Exception("Element does not exists");
        }
        return clienteRepository.save(entity);
    }

    @Override
    public void delete(Cliente entity) throws Exception {
        if(findByID(entity.getIdClie()).isEmpty()){
            throw new Exception("Element does not exists");
        }
        clienteRepository.delete(entity);
    }

    @Override
    public void deleteById(Long aLong) throws Exception {
        if(findByID(aLong).isPresent()){
            throw new Exception("Element does not exists");
        }
        clienteRepository.deleteById(aLong);
    }

    @Override
    public void validate(Cliente entity) throws Exception {

    }

    @Override
    public long count() {
        return clienteRepository.count();
    }

    public long countByEstado(String estado){
        return clienteRepository.countByEstado(estado);
    }
}
