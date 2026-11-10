import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PedidoTest {

    Cliente clientePrueba=new Cliente("123","sai", 123456,"sai@gamil.com", "Calle 20");
    Entrega entregaPrueba=new EntregaSegura();
    Pedido pedido=new Pedido("pedido001",java.time.LocalDate.now(),10,clientePrueba,entregaPrueba,EstadoPedido.PENDIENTE);

    @Test
    void noPermitirDistanciaNegativa(){
        assertThrows(IllegalArgumentException.class,()->{ new Pedido("pedido001",java.time.LocalDate.now(),-2,clientePrueba,entregaPrueba,EstadoPedido.CONFIRMADO);});
    }

    @Test
    void noPermitirClienteNull(){
        assertThrows(IllegalArgumentException.class,()->{ new Pedido("pedido001",java.time.LocalDate.now(),10,null,entregaPrueba,EstadoPedido.CONFIRMADO);});
    }

    @Test
    void noPermitirCodigoCeros(){
        assertThrows(IllegalArgumentException.class,()->{ new Pedido("00000",java.time.LocalDate.now(),10,clientePrueba,entregaPrueba,EstadoPedido.CONFIRMADO);});
    }

    @Test
    void verificarEstadoPendiente(){
        assertEquals(EstadoPedido.PENDIENTE, pedido.getEstadoPedido());
    }

    @Test
    void verificarCodigoCorrecto(){
        assertEquals("pedido001",pedido.getCodigoPedido());

    }
}
