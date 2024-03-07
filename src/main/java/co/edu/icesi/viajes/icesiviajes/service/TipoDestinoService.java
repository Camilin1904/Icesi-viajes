package co.edu.icesi.viajes.icesiviajes.service;

import co.edu.icesi.viajes.icesiviajes.domain.TipoDestino;

import java.util.List;

public interface TipoDestinoService extends co.edu.icesi.viajes.icesiviajes.service.GenericService<TipoDestino, Long> {
    public List<TipoDestino> findByCodigo(String codigo) throws Exception;
    public List<TipoDestino> findByCodigoAndEstadoIgnoreCase(String codigo, String estado) throws Exception;
    public List<Object[]> orderByPopularity();
}
