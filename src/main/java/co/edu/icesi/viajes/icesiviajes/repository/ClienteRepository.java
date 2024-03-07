package co.edu.icesi.viajes.icesiviajes.repository;

import co.edu.icesi.viajes.icesiviajes.domain.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("select cl from Cliente cl where cl.estado = ?1 order by cl.idClie")
    public List<Cliente> findClienteByEstado(String estado);

    public List<Cliente> findClienteByCorreoIgnoreCase(String correo);

    @Query("SELECT c FROM Cliente c WHERE CAST(c.idClie AS string) LIKE ?1")
    public List<Cliente> findClienteByIdClie(String id);

    @Query("select c from Cliente c where lower(c.nombre) like lower(?1)")
    public List<Cliente> findClienteByNombre(String nombre);


    public List<Cliente> findClienteByFechaNacimientoBetween(Date fechaInicio, Date fechaFin);

    public Page<Cliente> findClienteByIdClie(Long id, Pageable pageable);

    @Query("select c from Cliente c where c.primerApellido = ?1 and c.segundoApellido = ?2")
    public List<Cliente> findClienteByLastNames(String firstLastName, String secondLastName);


    public List<Cliente> findClienteByNumeroIdentificacion(String numeroIdentificacion);

    public long countByEstado(String estado);
}
