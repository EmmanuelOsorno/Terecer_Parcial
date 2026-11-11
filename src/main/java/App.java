import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in);

        Restaurante restaurante = new Restaurante("Sabor y Tradicion", 1230421789, "Armenia(Quindío)");
        int opcion;
        do {
            System.out.println("===========================");
            System.out.println("=====Sabor & Tradicion=====");
            System.out.println("===========================");
            System.out.println("1. Registrar producto");
            System.out.println("2. Registrar cliente");
            System.out.println("3. Consultar productos disponibles");
            System.out.println("4. Consultar rechazados por calidad");
            System.out.println("5. Registrar pedido");
            System.out.println("6. Gestionar domicilio");
            System.out.println("7. Modificar estado del pedido");
            System.out.println("8. Consultar pedidos de un cliente");
            System.out.println("9. Consultar estado del pedido");
            System.out.println("==========Reportes=======");
            System.out.println("10. Consultar ingresos del restaurante");
            System.out.println("11. Consultar producto más vendido");
            System.out.println("12. Consultar categoria con mayores ingresos");

            System.out.println("0. Salir del menú");
            System.out.println("Elija la opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    // Registrar producto
                    System.out.println("---Registar Producto---");
                    System.out.println("Codigo del producto: ");
                    String codigoProducto=scanner.nextLine();
                    System.out.println("Nombre del producto: ");
                    String nombreProducto=scanner.nextLine();
                    System.out.println("Descripcion del producto: ");
                    String descripcionProducto =scanner.nextLine();
                    System.out.println("Precio base del producto: ");
                    double precioBaseProducto=scanner.nextDouble();
                    System.out.println("Tiempo estimado de preparacion del producto (minutos): ");
                    int tiempoPreparacion=scanner.nextInt();
                    System.out.println("1. Plato fuerte\n2. Bebida\n3. Postre\nSeleccione el tipo del producto: ");
                    int tipoProducto=scanner.nextInt();

                    //creamos el producto como null para luego crearlo segun el tipo de producto
                    Producto producto=null;
                    switch (tipoProducto) {
                        case 1:
                            System.out.println("Peso del Plato fuerte (gramos): ");
                            double pesoGramos = scanner.nextDouble();
                            System.out.println("1. Sí\n2. No\nEl Plato fuerte requiere control de coccion?: ");
                            int controlCoccion = scanner.nextInt();
                            //lo iniciamos en true
                            boolean controlC=true;
                            if(controlCoccion==1){
                                controlC=true;
                            }else if(controlCoccion==2){
                                controlC=false;
                            }

                            System.out.println("1. Asado\n2. Frito\n3. Horneado\n4. A la plancha\nSeleccione el tipo de preparacion: ");
                            int tipoPreparacion = scanner.nextInt();
                            //lo iniciamos en Asado
                            TipoPreparacion tipoPreparacionPlatoFuerte = TipoPreparacion.ASADO;
                            switch (tipoPreparacion) {
                                case 1:
                                    tipoPreparacionPlatoFuerte = TipoPreparacion.ASADO;
                                    break;
                                case 2:
                                    tipoPreparacionPlatoFuerte = TipoPreparacion.FRITO;
                                    break;
                                case 3:
                                    tipoPreparacionPlatoFuerte = TipoPreparacion.HORNEADO;
                                    break;
                                case 4:
                                    tipoPreparacionPlatoFuerte = TipoPreparacion.A_LA_PLANCHA;
                                    break;
                            }
                            producto = new PlatoFuerte(codigoProducto, nombreProducto, descripcionProducto, precioBaseProducto, tiempoPreparacion, pesoGramos, tipoPreparacionPlatoFuerte, controlC);
                            if (producto != null) {
                                if (restaurante.registrarProducto(producto)) {
                                    System.out.println("El plato fuerte fue registrado correctamente");
                                } else {
                                    System.out.println("El plato fuerte no se pudo registrar");
                                }
                            }
                            break;
                        case 2:
                            System.out.println("Volumen (mililitros): ");
                            double volumenMililitros = scanner.nextDouble();
                            System.out.println("Temperatura al momento del servicio (grados): ");
                            double temperatura = scanner.nextDouble();
                            System.out.println("1. Fria\n2. Caliente\nSeleccione el tipo de bebida: ");
                            int tipoBebida = scanner.nextInt();
                            //la iniciamos en fria
                            TipoBebida tipoBebida1 = TipoBebida.FRIA;
                            switch (tipoBebida) {
                                case 1:
                                    tipoBebida1 = TipoBebida.FRIA;
                                    break;
                                case 2:
                                    tipoBebida1 = TipoBebida.CALIENTE;
                                    break;
                            }
                            System.out.println("1. Sí\n2. No\nLa bebida requiere preparacion especial?: ");
                            int preparacionEspecial = scanner.nextInt();
                            //la iniciamos como true
                            boolean preparacionP=true;
                            if(preparacionEspecial==1){
                                preparacionP=true;
                            }else if (preparacionEspecial==2){
                                preparacionP=false;
                            }

                            producto = new Bebida(codigoProducto, nombreProducto, descripcionProducto, precioBaseProducto, tiempoPreparacion, volumenMililitros, temperatura, tipoBebida1, preparacionP);
                            if (producto != null) {
                                if (restaurante.registrarProducto(producto)) {
                                    System.out.println("La bebida fue registrada correctamente");
                                } else {
                                    System.out.println("La bebida no se pudo registrar");
                                }
                            }
                            break;
                        case 3:
                            System.out.println("Peso del postre (gramos): ");
                            double pesoPostre = scanner.nextDouble();
                            System.out.println("Temperatura de almaceniamieto del postre: ");
                            double temperaturaPostre = scanner.nextDouble();
                            System.out.println("1. Sí\n2. No\nEl postre requiere refrigeracion?: ");
                            int refrigeracionPostre = scanner.nextInt();
                            //lo iniciamos como true
                            boolean refrigeracion=true;
                            if(refrigeracionPostre==1){
                                refrigeracion=true;
                            }else if (refrigeracionPostre==2){
                                refrigeracion=false;
                            }

                            producto = new Postre(codigoProducto, nombreProducto, descripcionProducto, precioBaseProducto, tiempoPreparacion, pesoPostre, temperaturaPostre, refrigeracion);
                            if (producto != null) {
                                if (restaurante.registrarProducto(producto)) {
                                    System.out.println("El postre fue registrado correctamente");
                                } else {
                                    System.out.println("El postre no se pudo registrar");
                                }
                            }

                    }
                    break;

                case 2:
                    // Registrar cliente
                    System.out.println("---Registrar Cliente---");
                    System.out.println("Numero de documento: ");
                    String numeroDocumento=scanner.nextLine();
                    System.out.println("Nombre: ");
                    String nombre=scanner.nextLine();
                    System.out.println("telefono: ");
                    int telefono=scanner.nextInt();
                    //limpiar buffer
                    scanner.nextLine();
                    System.out.println("Correo electronico: ");
                    String correo=scanner.nextLine();
                    System.out.println("Direccion de residencia: ");
                    String direccion=scanner.nextLine();

                    Cliente cliente=new Cliente(numeroDocumento,nombre,telefono,correo,direccion);
                    if(restaurante.registrarCliente(cliente)){
                        System.out.println("Cliente registrado correctamente");
                    }else{
                        System.out.println("El cliente no se pudo registrar");
                    }
                    break;

                case 3:
                    // Consultar productos disponibles
                    System.out.println("---Productos Disponibles---");
                    ArrayList<Producto> disponible=restaurante.consultarProductosDisponibles();
                    if(disponible.isEmpty()){
                        System.out.println("No hay productos disponibles");
                    }else{
                        for(Producto productoD:disponible){
                            System.out.println(productoD);
                        }
                    }
                    break;

                case 4:
                    // Consultar rechazados por calidad
                    System.out.println("---Productos rechazados---");
                    ArrayList<Producto> rechazados=restaurante.consultarProductosRechazados();
                    if(rechazados.isEmpty()){
                        System.out.println("No hay productos rechazados");
                    }else{
                        for(Producto productoR:rechazados){
                            System.out.println(productoR);
                        }
                    }
                    break;

                case 5:
                    // Registrar pedido
                    System.out.println("---Registrar Pedido---");
                    System.out.println("Codigo del pedido: ");
                    String codigoPedido=scanner.nextLine();
                    System.out.println("Numero de documento del cliente que realizo el pedido: ");
                    String numeroDocumentoClienteP=scanner.nextLine();

                    //buscar ese cliente
                    Cliente clientePedido=null;
                    for(Cliente clienteP:restaurante.getListaClientes()){
                        if(clienteP.getNumeroDocumento().equalsIgnoreCase(numeroDocumentoClienteP)){
                            clientePedido=clienteP;
                            break;
                        }
                    }

                    if(clientePedido!=null){
                        System.out.println("Distancia del domicilio (kilometros): ");
                        double distanciaPedido=scanner.nextDouble();

                        System.out.println("1. EntregaSegura\n2. RapidoExpress\n3. Consumo en Restaurante\nSeleccione la modalidad del pedido: ");
                        int opcionModalidad=scanner.nextInt();
                        //la iniciamos en consumoRestaurante
                        Entrega entrega=new ConsumoRestaurante();
                        switch (opcionModalidad){
                            case 1:entrega=new EntregaSegura();
                            break;
                            case 2:entrega=new RapidoExpress();
                            break;
                            case 3: entrega=new ConsumoRestaurante();
                            break;
                        }

                        //el estado al crear el pedido siempre se genera como PENDIENTE, porque asi se determino en la clase Pedido
                        EstadoPedido estadoPedido=EstadoPedido.PENDIENTE;

                        //con java.time.LocalDate.now() la fecha del pedido se registra al momento de crearlo
                        Pedido pedido=new Pedido(codigoPedido, java.time.LocalDate.now(),distanciaPedido,clientePedido,entrega, estadoPedido);

                        //agregar productos al pedido
                        int confirmar=1;
                        do {
                            //limpiar buffer
                            scanner.nextLine();
                            System.out.println("Codigo del producto: ");
                            String codigoPoductoP = scanner.nextLine();

                            //buscar ese producto entre los productos disponibles
                            Producto productoPedido = null;
                            for (Producto productoP : restaurante.consultarProductosDisponibles()) {
                                if (productoP.getCodigo().equalsIgnoreCase(codigoPoductoP)) {
                                    productoPedido = productoP;
                                    break;
                                }
                            }

                            if (productoPedido != null) {
                                System.out.println("Cantidad del producto: ");
                                int cantidad = scanner.nextInt();
                                //limpiar buffer
                                scanner.nextLine();

                                detallePedido detallePedido = new detallePedido(cantidad, productoPedido);

                                //agregarl al pedido
                                if (pedido.agregarDetalle(detallePedido)) {
                                    System.out.println("Prodcuto agregado");
                                } else {
                                    System.out.println("El producto no se puedo agregar");
                                }
                            }
                            System.out.println("1. Si\n2. No\nAgregar otro producto?: ");
                            int continuar = scanner.nextInt();
                            scanner.nextLine();
                            confirmar=continuar;

                        }while (confirmar==1);

                        if(restaurante.registrarPedido(pedido)){
                            System.out.println("Pedido registrado correctamente");
                        }else{
                            System.out.println("El pedido no se pudo registrar");
                        }

                    }else{ //si el cliente si es null
                        System.out.println("Cliente no registrado");
                    }
                    break;

                case 6:
                    // Gestionar servicio a domicilio
                    System.out.println("---Gestionar Domicilios---");
                    System.out.println("Codigo del pedido: ");
                    String codigoP=scanner.nextLine();

                    boolean gestionado=restaurante.gestionarDomicilioPedido(codigoP);
                    if(gestionado==true){
                        System.out.println("Domicilio aceptado");
                    }else{
                        System.out.println("Domicilio rechazado");
                    }
                    break;

                case 7:
                    // Confirmar pedido
                    System.out.println("---Modificar estado del Pedido---");
                    System.out.println("Codigo del pedido a modificar: ");
                    String codigoPedidoM=scanner.nextLine();

                   Pedido pedidoModificar=restaurante.buscarPedido(codigoPedidoM);

                   if(pedidoModificar!=null){
                       System.out.println("1. Pendiente\n2. Confirmado\n3. Entregado\n4. Cancelado\nSeleccione el nuevo estado del pedido: ");
                       int opcionEstado=scanner.nextInt();
                       //limpiar buffer
                       scanner.nextLine();

                       EstadoPedido nuevoEstado=null;
                       switch (opcionEstado){
                           case 1:nuevoEstado=EstadoPedido.PENDIENTE;
                           break;
                           case 2:nuevoEstado=EstadoPedido.CONFIRMADO;
                           break;
                           case 3:nuevoEstado=EstadoPedido.ENTREGADO;
                           break;
                           case 4:nuevoEstado=EstadoPedido.CANCELADO;
                           break;
                       }
                       if(nuevoEstado!=null){
                           if(restaurante.modificarEstadoPedido(codigoPedidoM, nuevoEstado)){
                               System.out.println("Estado del Pedido modificado correctamente");
                           }else{
                               System.out.println("No se pudo modificar el estado del Pedido");
                           }
                       }
                   }else{
                       System.out.println("El pedido no fue encontrado");
                   }
                    break;

                case 8:
                    // Consultar y actualizar pedidos de un cliente
                    System.out.println("---Pedidos de un Cliente---");
                    System.out.println("Numero de documento del cliente que realizo el pedido: ");
                    String numeroDocuementoP=scanner.nextLine();

                    ArrayList<Pedido> pedidos=restaurante.consultarPedidosCliente(numeroDocuementoP);
                    if(pedidos.isEmpty()){
                        System.out.println("No hay pedidos asociados a este cliente");
                    }else{
                        for(Pedido pedido:pedidos){
                            System.out.println(pedido);
                        }
                    }
                    break;

                case 9:
                    // Consultar estado del pedido
                    System.out.println("---Estado del Pedido---");
                    System.out.println("Codigo del pedido: ");
                    String codigoEstado=scanner.nextLine();

                    Pedido pedido=restaurante.buscarPedido(codigoEstado);
                    if(pedido!=null){
                        System.out.println("El pedido esta en estado "+pedido.getEstadoPedido());
                    }else {
                        System.out.println("No se encontro este ppedido");
                    }
                    break;

                case 10:
                    // Consultar ingresos del restaurante
                    System.out.println("---Ingresos del Restaurante---");
                    double ingresos=restaurante.calcularIngresosRestaurante();
                    System.out.println("Los ingresos totales del restaurante son de "+ ingresos);
                    break;

                case 11:
                    // Consultar producto más vendido
                    System.out.println("---Producto más Vendido---");
                    Producto productoV= restaurante.obtenerProductoMasVendido();
                    if(productoV!=null){
                        System.out.println("El producto más vendido es: "+productoV.getNombre());
                    }
                    break;

                case 12:
                    // Consultar categoría con mayores ingresos
                    System.out.println("---Categoria con Mayor Ingreso---");
                    String categoriaMayorIngreso=restaurante.determinarCategoriaMayorIngreso();
                    System.out.println(categoriaMayorIngreso);
                    break;

                case 0:
                    System.out.println("Gracias por utilizar el menú de Sabor & Tradicion.");
                    break;

                default:
                    System.out.println("Opcion no valida. Intente nuevamente.");
                    break;
            }
        }while (opcion != 0) ;
        scanner.close();
    }
}
