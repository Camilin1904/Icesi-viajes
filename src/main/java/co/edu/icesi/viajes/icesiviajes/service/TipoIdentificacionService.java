package co.edu.icesi.viajes.icesiviajes.service;

import co.edu.icesi.viajes.icesiviajes.domain.TipoIdentificacion;

import java.util.List;

public interface TipoIdentificacionService extends GenericService<TipoIdentificacion, Long>{

        public List<TipoIdentificacion> orderedTipoIdentificacion();

        public List<TipoIdentificacion> findTipoIdentificacionByCodigoAndEstado(String codigo, String estado) throws Exception;

        public long countByEstado(String estado) throws Exception;
}
