import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DetallePedidoTest {

    Producto productoPrueba=new Postre("codigoPostre","tres leches", "Pastel de tres leches",5000,20,150,6,true);
    detallePedido detallePedido =new detallePedido(5, productoPrueba);

    @Test
    //segun las condiciones y los datos que pusimos en prodcutoPrueba, el todal de unidad es de 6000, y fueron 5 unidades, entonces el subtotal es de 30000
    void subtotalCalculadoCorrectamente(){
        assertEquals(30000,detallePedido.calcularSubtotal());
    }

    @Test
    void verificarCantidadPostiva(){
        assertTrue(detallePedido.validarCantidad()==true);
    }

    @Test
    void noPermitirCantidadNegativa(){
        assertThrows(IllegalArgumentException.class,()->{ new detallePedido(-2,productoPrueba);});
    }

    @Test
    void noPermitirCalcularSubtotalConProductoNull(){
        assertThrows(IllegalArgumentException.class,()->{ new detallePedido(5,null);});
    }

    @Test
    //"return cantidad + " unidades de: "+producto.getNombre();"
    //se espera un " 5 unidades de: tres leches"
    void verificarToStringCorrecto(){
        assertEquals("5 unidades de: tres leches", detallePedido.toString());
    }
}
