import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RapidoExpressTest {

    RapidoExpress rapidoExpress=new RapidoExpress();

    @Test
    //valor base=5000
    //"return getValorBase()+(1500*distancia);"
    //ejemplo con 4 km
    //el costo de entrega debe ser de 11000
    void calcularCostoEntregaCorrectamente(){
        assertEquals(11000,rapidoExpress.calcularCostoEntrega(4));
    }

    @Test
    //"if (distancia <= 12)"
    //ejemplo con 10km
    void verificarAceptarEntregaConDistanciaDentroDelRango(){
       assertTrue(rapidoExpress.aceptarEntrega(10)==true);
    }

    @Test
    //"if (distancia <= 12)"
    //ejemplo con 15km
    void verificarFalseConDistanciaFueraDelRango(){
    //"assertFalse(rapidoExpress.aceptarEntrega(15)==true);" es verdad(true) que esa condicion sera falsa (no se aceptara la entrega)
        assertFalse(rapidoExpress.aceptarEntrega(15)==true);
    }

    @Test
    //"return "RapidoExpress";"
    //se espera un "RapidoExpress"
    void verificarToString(){
        assertEquals("RapidoExpress", rapidoExpress.toString());
    }

    //verificar que implemente la interface Entrega
    @Test
    //assertInstanceOf para identificar si el objeto rapidoExpress implement al interface Entrega
    void verificarImplementacionInterface(){
        assertInstanceOf(Entrega.class,rapidoExpress);
    }
}
