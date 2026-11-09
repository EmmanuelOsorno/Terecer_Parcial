import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EntregaTest {

    //instanciamos una entrega rapidoExpress para probar los test
    Entrega entregaPrueba=new RapidoExpress();

    @Test
    void verificarImplementacionInterface(){
        assertInstanceOf(Entrega.class, entregaPrueba);
    }

    @Test
    void verificarEntregaNoSeaNull(){
        assertNotNull(entregaPrueba);
    }

    @Test
    //ejemplo con 4km
    void verificarMetodoCalcularCostoEntregaGenereUnNumeroMayorQueCero(){ //ese nombre tan largo jajaj
        assertTrue(entregaPrueba.calcularCostoEntrega(4)>0);
    }

    @Test
    //ejemplo con 8 km
    void verificarAceptarEntregaSeaBooleano(){
        assertTrue(entregaPrueba.aceptarEntrega(8)==true||entregaPrueba.aceptarEntrega(4)==false);
    }

    @Test
    //ejemplo con 1 km
    void verificarMetodoCalcularCostoEntregaNoGenereUnNumeroMenorQueCero(){
        assertFalse(entregaPrueba.calcularCostoEntrega(1)<0);
    }
}
