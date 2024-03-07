package co.edu.icesi.viajes.icesiviajes.repository;

import co.edu.icesi.viajes.icesiviajes.domain.Destino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DestinoRepository extends JpaRepository<Destino, Long> {

    public List<Destino> findDestinoByCodigoAndEstado(String codigo, String estado);

    public List<Destino> findDestinoByIdTide(Long idTiDe);

    @Query("select d, td from Destino d join TipoDestino td on d.idTide = td.idTide where d.estado = ?1 ")
    public List<Destino> findAllByEstado(String estado);

    public long countByIdTide(Long idTide);

}
