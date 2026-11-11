import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConsumoRestauranteTest {

    ConsumoRestaurante consumoRestaurante=new ConsumoRestaurante();

    @Test
    void verificarValorBaseCero(){
        assertEquals(0,consumoRestaurante.getValorBase());
    }

    @Test
    //aunque el pedido se registre por error con alguna distancia, si es parr aconsumo en el restaurante el costo de entrga debe ser cero
    //ejemplo: 12 km
    void verificarCostoCeroSinImportarDistancia(){
        assertEquals(0,consumoRestaurante.calcularCostoEntrega(12));
    }

    @Test
    //aunque el pedido se registre por error con alguna distancia, si es parr aconsumo en el restaurante se aceptara el pedido
    //ejemplo: 10 km
    void verificarAceptarTrue(){
        assertTrue(consumoRestaurante.aceptarEntrega(10)==true);
    }

    @Test
    //"return "Consumo en Restaurante";"
    //se espera un "Consumo en Restaurante"
    void verificarToString(){
        assertEquals("Consumo en Restaurante", consumoRestaurante.toString());
    }

    //verificar que implemente la interface Entrega
    @Test
    //assertInstanceOf para identificar si el objeto consumoRestaurante implement al ainterface Entrega
    void verificarImplementacionInterface(){
        assertInstanceOf(Entrega.class,consumoRestaurante);
    }

}
