package co.edu.icesi.viajes.icesiviajes.service;

import co.edu.icesi.viajes.icesiviajes.domain.Destino;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DestinoTest{

    @Autowired
    private DestinoService destinoService;

    @Test
    void debeRetornarPlayaDelCarmen() throws Exception{
        for(Destino c : destinoService.findDestinoByCodigoAndEstado("D001","A")){
            System.out.println(c.getNombre());
        }
    }

    @Test
    void debeRetornarCataratasdeIguazu() throws Exception{
        for(Destino c : destinoService.findDestinoByIdTide((long)9)){
            System.out.println(c.getNombre());
        }
    }

    @Test
    void debeRetornarActivos() throws Exception{
        for(Destino c : destinoService.findAllByEstado("A")){
            System.out.println(c.getNombre());
        }
    }

    @Test
    void countByIdTideTest(){
        assert destinoService.countByIdTide((long)2) == 1;
    }
}
