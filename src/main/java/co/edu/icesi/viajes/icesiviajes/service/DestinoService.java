package co.edu.icesi.viajes.icesiviajes.service;

import co.edu.icesi.viajes.icesiviajes.domain.Destino;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DestinoService extends GenericService<Destino, Long>{
    public List<Destino> findDestinoByCodigoAndEstado(String codigo, String estado) throws Exception;

    public List<Destino> findDestinoByIdTide(Long idTiDe) throws Exception;

    public List<Destino> findAllByEstado(String estado) throws Exception;

    public long countByIdTide(Long idTide);
}
