import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {

    Cliente cliente=new Cliente("0421","Tobi Ferchito Mejia", 321456,"tobiFerchito@gamil.com", "Calle 15 con carrera 5 (Barrio Llanitos");

    @Test
    void CorreoCorrecto(){
        assertEquals("tobiFerchito@gamil.com",cliente.getCorreo());
    }

    @Test
    void correoContieneArroba (){
        assertTrue(cliente.getCorreo().contains("@"));
    }

    @Test
    void NoPermitirCorreoSinArroba (){
        assertThrows(IllegalArgumentException.class,()->{new Cliente("0421","Tobi Ferchito Mejia", 321456,"tobiFerchito.gamil.com", "Calle 15 con carrera 5 (Barrio Llanitos");});
    }

    @Test
    void ComprobarDatosCorrectos(){
        assertEquals("0421",cliente.getNumeroDocumento());
        assertEquals("Tobi Ferchito Mejia",cliente.getNombreCompleto());
        assertEquals(321456,cliente.getTelefono());
        assertEquals("tobiFerchito@gamil.com",cliente.getCorreo());
        assertEquals("Calle 15 con carrera 5 (Barrio Llanitos",cliente.getDireccionResidencia());
    }

    //la canitdad de digitos de telefono es inventada para la prueba :(
    @Test
    void NoPermitirTelefonoConMenosDe6Digitos(){
        assertThrows(IllegalArgumentException.class,()->{new Cliente("0421","Tobi Ferchito Mejia", 321,"tobiFerchito.gamil.com", "Calle 15 con carrera 5 (Barrio Llanitos");});

    }

}
