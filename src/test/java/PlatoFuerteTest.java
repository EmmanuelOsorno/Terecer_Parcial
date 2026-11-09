import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlatoFuerteTest {

    //instanciar un plato fuerte para la prueba
    PlatoFuerte platoFuerte=new PlatoFuerte("abc","Lomo asado","Lomo de cerdo asado acompaññado con papas hervidas",35000,30,400,TipoPreparacion.ASADO,true);

    //prueba de datos correctos, para los atributos especificos de plato fuerte
    @Test
    void platoFuerteDatosCorectos(){
        assertEquals(400,platoFuerte.getPesoGramos());
        assertEquals(TipoPreparacion.ASADO,platoFuerte.getTipoPreparacion());
        assertTrue(platoFuerte.isControlCocion());
    }

    //
    @Test
    void culpliarCondicionesCalidad(){
        assertTrue(platoFuerte.condicionesCalidad());
    }

    //
    @Test
    void noPermitiPreciosNegativos(){
        assertTrue(platoFuerte.getPrecioBase()>0);
    }

    //
    @Test
    void noPermitirPrecioNegativo(){ //con assertThrows
        assertThrows(IllegalArgumentException.class,()->{new PlatoFuerte("abc","Lomo asado","Lomo de cerdo asado acompaññado con papas hervidas",-35000,30,400,TipoPreparacion.ASADO,true);});
    }

    //
    @Test
    void noPermitirPesoNegativo(){ //con assertThrows
        assertThrows(IllegalArgumentException.class,()->{new PlatoFuerte("abc","Lomo asado","Lomo de cerdo asado acompaññado con papas hervidas",35000,30,-400,TipoPreparacion.ASADO,true);});
    }
}