package co.edu.icesi.viajes.icesiviajes.repository;

import co.edu.icesi.viajes.icesiviajes.domain.TipoDestino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TipoDestinoRepository extends JpaRepository<TipoDestino, Long> {

    public List<TipoDestino> findByCodigo(String codigo);
    public List<TipoDestino> findByCodigoAndEstadoIgnoreCase(String codigo, String estado);

    @Query("select tp from TipoDestino tp where tp.codigo = ?1")
    public List<TipoDestino> consultaPorCodigo(String codigo);

    @Query("select td from TipoDestino td order by td.nombre")
    public List<TipoDestino> findAllOrdered();

    @Query("SELECT td, COUNT(td) AS total_sales " +
            "FROM Cliente c " +
            "JOIN Plan p ON c.idClie = p.idPlan " +
            "JOIN DetallePlan dp ON dp.idPlan = p.idPlan " +
            "JOIN Destino d ON d.idDest = dp.idDest " +
            "JOIN TipoDestino td ON d.idTide = td.idTide " +
            "GROUP BY td.idTide " +
            "ORDER BY total_sales DESC")
    public List<Object[]> orderByPopularity();





}
