package co.edu.icesi.viajes.icesiviajes.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import co.edu.icesi.viajes.icesiviajes.domain.Cliente;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;


@SpringBootTest
public class ClienteTest {

    @Autowired
    private ClienteService clienteService;


    @Test
    void debeRetornarLosNombresDeLosClientesTipoA() throws Exception{
        for(Cliente c : clienteService.findClienteByEstado("A")){
            System.out.println(c.getNombre());
        }
    }

    @Test
    void debeRetornatUnNombreDeUnCliente() throws Exception{
        for(Cliente c : clienteService.findClienteByCorreoIgnoreCase("maRia@EXample.com")){
            System.out.println(c.getNombre());
        }
    }

    @Test
    void debeRetornarClienteConID1() throws Exception{
        System.out.println(clienteService.findClienteByIdClie("1").get(0).getNombre());
    }

    @Test
    void debeRetornarElIDDeLosJuan() throws Exception{
        for(Cliente c : clienteService.findClienteByNombre("Juan")){
            System.out.println(c.getIdClie());
        }
    }

    @Test
    void debeRetornarClientesNacidosEntre80y90() throws Exception{
        for(Cliente c : clienteService.findClienteByFechaNacimientoBetween(Date.from(LocalDate.parse("1980-01-01").atStartOfDay(ZoneId.systemDefault()).toInstant()), Date.from(LocalDate.parse("1990-12-31").atStartOfDay(ZoneId.systemDefault()).toInstant()))){
            System.out.println(c.getIdClie());
        }
    }

    @Test
    void debeRetornarPage() throws Exception{
        System.out.println(clienteService.findClienteByIdCliePage((long)1, PageRequest.of(2,3)));
    }

    @Test
    void debeRetornarJuan() throws Exception{
        for(Cliente c : clienteService.findClienteByLastNames("Pérez","Gómez")){
            System.out.println(c.getNombre());
        }
    }

    @Test
    void debeRetornarMaria() throws Exception{
        for(Cliente c : clienteService.findClienteByNumeroIdentificacion("987654321")){
            System.out.println(c.getNombre());
        }
    }

    @Test
    void testCountByEstado(){
        assert clienteService.countByEstado("A") == 2;
    }

}
