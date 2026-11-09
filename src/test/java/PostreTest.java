import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PostreTest {

    Postre postre=new Postre("ghi","Tiramisu", "Postre en capas con fafe, queso mascarpone y cacao",8000,15,100,6,true);

    //prueba de datos correctos, para los atributos heredados de Producto
    @Test
    void verifiacrPostreDatosCorrectos() {
        assertEquals("ghi", postre.getCodigo());
        assertEquals("Tiramisu", postre.getNombre());
        assertEquals("Postre en capas con fafe, queso mascarpone y cacao", postre.getDescripcion());
        assertEquals(8000,postre.getPrecioBase());
        assertEquals(15,postre.getTiempoEstimadoPreparacion());
    }

    @Test
    void verificarCondicionesCalidad(){
        assertTrue(postre.condicionesCalidad());
    }

    @Test
    void verificarCumpleTemperaturaAlmacenamiento(){
        if(postre.isRefrigeracion()==true){
            assertTrue(postre.getTemperaturaAlmacenamiento()>=0&&postre.getTemperaturaAlmacenamiento()<=6);
        }
    }

    @Test
    void noPermitirTemperaturaMayorAlLimite(){
        assertThrows(IllegalArgumentException.class,()->{new Postre("ghi","Tiramisu", "Postre en capas con fafe, queso mascarpone y cacao",8000,15,100,8,true);});
    }

    @Test
    void noPermitirTiempoPeparacionNegativo(){
        assertThrows(IllegalArgumentException.class,()->{ new Postre("ghi","Tiramisu", "Postre en capas con fafe, queso mascarpone y cacao",8000,-15,100,6,true);});
    }
}
