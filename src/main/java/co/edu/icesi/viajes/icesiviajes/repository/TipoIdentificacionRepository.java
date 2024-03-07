package co.edu.icesi.viajes.icesiviajes.repository;

import co.edu.icesi.viajes.icesiviajes.domain.TipoIdentificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TipoIdentificacionRepository extends JpaRepository<TipoIdentificacion, Long> {

    @Query("select ti from TipoIdentificacion ti order by ti.nombre desc")
    public List<TipoIdentificacion> orderedTipoIdentificacion();

    public List<TipoIdentificacion> findTipoIdentificacionByCodigoAndEstado(String codigo, String estado);

    public long countByEstado(String estado);
}
