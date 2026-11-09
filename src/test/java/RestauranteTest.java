import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RestauranteTest {

    Restaurante restaurante=new Restaurante("Sabor y Tradicion", 1230421789, "Armenia(Quindío)");
    Postre postrePruebaUno=new Postre("codigoPostrePrueba","Macarons", "postre hecho con arrina de almendra, clara de huevo y azucar, con relleno cremoso",8000,20,80,20,false);
    //otro postre para el test de mismo codigo
    Postre postrePruebaDos=new Postre("codigoPostrePrueba","Merengon","postre con base de merengue crujiente cubierto con crema y frutas",8000,15,120,6,true);

    @Test
    void verificarRegistrarProductoCorrectamente(){
        assertTrue(restaurante.registrarProducto(postrePruebaUno));
    }

    @Test
    void verificarFalseRegistarProductoConMismoCodigo(){
        //registramos el primer postre para la prueba
        restaurante.registrarProducto(postrePruebaUno);
        //al intentar registrar el segundo postre debe dar falso (tiene el mismo codigo que el postre uno)
        assertFalse(restaurante.registrarProducto(postrePruebaDos));
    }

    @Test
    void noPermitirNIT_Cero(){ //con assertThrows
        assertThrows(IllegalArgumentException.class,()->{new Restaurante("Sabor y Tradicion", 0, "Armenia(Quindío)");});
    }

    @Test
    void verificarCuandoNoHayProductoMasVendido(){
        //al no tener ningun pedido confirmado. no se tiene el producto más vendido (debe dar null)
        assertNull(restaurante.obtenerProductoMasVendido());
    }

    @Test
    void verificarDireccionCorrecta(){
        assertEquals("Armenia(Quindío)", restaurante.getDireccion());
    }

}
