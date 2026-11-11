import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EntregaSeguraTest {

    EntregaSegura entregaSegura=new EntregaSegura();

    @Test
    //valor base=7000
    //double costo=getValorBase()+(1000*distancia)
    //if(distancia>5){costo+=3000;}
    //ejemplo con 7km
    //el costo de entrega deb ser de 17000
    void calcularCostoEntregaCorrectamente(){
        assertEquals(17000,entregaSegura.calcularCostoEntrega(7));
    }

    @Test
    //valor base=7000
    //double costo=getValorBase()+(1000*distancia)
    //if(distancia>5){costo+=3000;}
    //ejemplo con 4km
    //el costo de entrega deb ser de 11000
    void calcularCostoEntregaSinExcederLos5Km(){
        assertEquals(11000,entregaSegura.calcularCostoEntrega(4));
    }

    @Test
    //"if (distancia <= 20)"
    //ejemplo con 19km
    void verificarAceptarEntregaConDistanciaDentroDelRango(){
        assertTrue(entregaSegura.aceptarEntrega(19)==true);
    }

    @Test
    //"if (distancia <= 20)"
    //ejemplo con 21km
    void verificarAceptarEntregaFalseConDistanciaFueraDelRango(){
    //"assertFalse(entregaSegura.aceptarEntrega(21)==true);" es verdad(true) que esa condicion sera falsa (no se aceptara la entrega)
        assertFalse(entregaSegura.aceptarEntrega(21)==true);
    }

    //verificar que implemente la interface Entrega
    @Test
    //assertInstanceOf para identificar si el objeto entregaSegura implementa la interface Entrega
    void verificarImplementacionInterface(){
        assertInstanceOf(Entrega.class,entregaSegura);
    }
}
