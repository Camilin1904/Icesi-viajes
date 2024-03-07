package co.edu.icesi.viajes.icesiviajes.service;
import co.edu.icesi.viajes.icesiviajes.domain.TipoDestino;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@SpringBootTest
public class TipoDestinoTest {

    @Autowired
    private TipoDestinoService tipoDestinoService;
    private TipoDestino[] t = new TipoDestino[10];

    void setUp() throws Exception{

        for(int i=0; i<t.length; i++){
            t[i] = new TipoDestino();
            t[i].setCodigo(i+"");
            t[i].setDescripcion(i+i+"");
            t[i].setEstado(i+"");
            t[i].setNombre(i+"");
            t[i].setFechaCreacion(Date.valueOf(LocalDate.EPOCH));
            t[i].setIdTide((long) (i+i+i+i+i+i+i+i+i+i+i+i));
            t[i].setUsuCreador(i+i+i+i+i+"");

            tipoDestinoService.save(t[i]);
        }

    }


    void dismantle() throws Exception{
        for(TipoDestino n:t){
            tipoDestinoService.delete(n);
        }
    }

    @Test
    void debeRetornarListaDeTipoDestino(){
        List<TipoDestino> listaTipoDestino = tipoDestinoService.findAll();
        for (TipoDestino n : listaTipoDestino){
            System.out.println(n.getCodigo() + " - " + n.getNombre());
        }
    }

    @Test
    void findByIDTest()throws Exception{
        setUp();
        boolean[] res = new boolean[10];
        for(int i=0; i<res.length; i++){
            res[i] = Objects.equals(tipoDestinoService.findByID((long) 12 * i).get().getIdTide(), t[i].getIdTide());
        }
        dismantle();
        for(boolean n : res) assert n;
    }

    @Test
    void saveTest() throws Exception{
        TipoDestino t1 = new TipoDestino();
        t1.setIdTide((long)55);
        t1.setCodigo("345");
        t1.setDescripcion("a");
        t1.setEstado("q");
        t1.setFechaCreacion(Date.valueOf(LocalDate.EPOCH));
        t1.setNombre("ma cago en todo");
        t1.setUsuCreador("o");
        tipoDestinoService.save(t1);
        boolean res = Objects.equals(tipoDestinoService.findByID((long) 55).get().getIdTide(), t1.getIdTide());
        tipoDestinoService.delete(t1);
        assert res;
    }


    @Test
    void updateTest() throws Exception {
        setUp();
        t[0].setFechaCreacion(Date.valueOf(LocalDate.now()));
        tipoDestinoService.update(t[0]);
        boolean res = tipoDestinoService.findByID((long)0).get().getFechaCreacion().toString().startsWith(t[0].getFechaCreacion().toString());
        dismantle();
        assert res;
    }

    @Test
    void deleteTest()throws Exception{
        int org = tipoDestinoService.findAll().size();
        setUp();
        dismantle();
        assert tipoDestinoService.findAll().size()==org;
    }

    @Test
    void deleteByIDTets()throws Exception{
        setUp();
        tipoDestinoService.deleteById((long)0);
        assert tipoDestinoService.findByID((long)0).equals(Optional.empty());
        dismantle();
    }


    @Test
    void validateTest(){
        assert true;
    }

    @Test
    void countTest() throws Exception{
        setUp();
        int act = tipoDestinoService.findAll().size();
        assert act == tipoDestinoService.count();
        dismantle();
    }

    @Test
    void debeRetornarListaTipoDestinoPorCodigo() throws Exception{
        List<TipoDestino> lstTipoDestino = tipoDestinoService.findByCodigo("PLAYA");
        for(TipoDestino n: lstTipoDestino){
            System.out.println(n.getCodigo() + " - " + n.getNombre());
        }
    }

    @Test
    void debeRetornarListaTipoDestinoPorCodigoYEstado() throws Exception{
        List<TipoDestino> lstTipoDestino = tipoDestinoService.findByCodigoAndEstadoIgnoreCase("PLAYA","A");
        for(TipoDestino n: lstTipoDestino){
            System.out.println(n.getCodigo() + " - " + n.getNombre());
        }
    }

    @Test
    void debeRetornarTipoDestinoPopulares(){
        List<Object[]> lstTipoDestino = tipoDestinoService.orderByPopularity();
        for(Object[] n: lstTipoDestino){
            System.out.println(n[0].toString() + " - " + n[1].toString());
        }
    }


}
