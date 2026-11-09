import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BebidaTest {

    Bebida bebida=new Bebida("def","Cafe latte","Cafe espresso con leche evaporada y espuma",5000,5,200,8,TipoBebida.FRIA,false);

    @Test
    void cumpleCondicionesCalidad(){
        assertTrue(bebida.condicionesCalidad());
    }

    @Test
    void noPermitirDescripcionNull(){
        assertThrows(IllegalArgumentException.class,()->{ new Bebida("def","Cafe latte",null,5000,5,200,8,TipoBebida.FRIA,false);});
    }

    @Test
    void noPermitiVolumenNegativos(){
        assertTrue(bebida.getVolumenMililitros()>0);
    }

    @Test
    void validarTemperaturaParaBebibaFria(){
        if(bebida.getTipoBebida()==TipoBebida.FRIA){
            assertTrue(bebida.getTemperaturaServicio()>=0&&bebida.getTemperaturaServicio()<=10);
        }
    }

    @Test
    void noPermitirTemperaturaMayorAlLimite(){
        assertThrows(IllegalArgumentException.class,()->{new Bebida("def","Cafe latte","Cafe espresso con leche evaporada y espuma",5000,5,200,12,TipoBebida.FRIA,false);});
    }
}
