package co.edu.icesi.viajes.icesiviajes.service;

import co.edu.icesi.viajes.icesiviajes.domain.TipoIdentificacion;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TipoIdentificacionTest {

    @Autowired
    private TipoIdentificacionService tipoIdentificacionService;

    @Test
    void debeRetornarTodosOrdenados(){
        for(TipoIdentificacion c : tipoIdentificacionService.orderedTipoIdentificacion()){
            System.out.println(c.getNombre());
        }
    }

    @Test
    void deberRetornarCedulaCiudadania() throws Exception{
        for(TipoIdentificacion c : tipoIdentificacionService.findTipoIdentificacionByCodigoAndEstado("CC", "A")){
            System.out.println(c.getNombre());
        }
    }

    @Test
    void debeRetornarNumeroDeActivos() throws Exception{
        System.out.println(tipoIdentificacionService.countByEstado("A"));
    }
}
