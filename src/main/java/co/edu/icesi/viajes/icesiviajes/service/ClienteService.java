package co.edu.icesi.viajes.icesiviajes.service;

import co.edu.icesi.viajes.icesiviajes.domain.Cliente;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ClienteService extends GenericService<Cliente, Long>{

    public List<Cliente> findClienteByEstado(String estado) throws Exception;

    public List<Cliente> findClienteByCorreoIgnoreCase(String correo) throws Exception;

    public List<Cliente> findClienteByIdClie(String id) throws Exception;

    public List<Cliente> findClienteByNombre(String nombre) throws Exception;

    public List<Cliente> findClienteByFechaNacimientoBetween(Date fechaInicio, Date fechaFin) throws Exception;

    public Page<Cliente> findClienteByIdCliePage(Long id, Pageable page) throws Exception;

    public List<Cliente> findClienteByLastNames(String firstLastName, String secondLastName) throws Exception;

    public List<Cliente> findClienteByNumeroIdentificacion(String numeroIdentificacion) throws Exception;

    public long countByEstado(String estado);
}
