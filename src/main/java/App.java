import java.util.Scanner;

public class App {

    public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in);

        Restaurante restaurante = new Restaurante("Sabor y Tradicion", 001002003, "Calle 15, Armenia(Quindío)");
        int opcion;
        do {
            System.out.println("===========================");
            System.out.println("=====Sabor & Tardicion=====");
            System.out.println("===========================");

            System.out.println("1. Registrar producto");
            System.out.println("2. Registrar cliente");
            System.out.println("3. Consultar productos disponibles");
            System.out.println("4. Consultar rechazados por calidad");
            System.out.println("5. Registrar pedido");
            System.out.println("6. Gestionar servicio a domicilio");
            System.out.println("7. Confirmar pedido");
            System.out.println("8. Consultar  y actualizar pedidos de un cliente");
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
                    break;

                case 2:
                    // Registrar cliente
                    break;

                case 3:
                    // Consultar productos disponibles
                    break;

                case 4:
                    // Consultar rechazados por calidad
                    break;

                case 5:
                    // Registrar pedido
                    break;

                case 6:
                    // Gestionar servicio a domicilio
                    break;

                case 7:
                    // Confirmar pedido
                    break;

                case 8:
                    // Consultar y actualizar pedidos de un cliente
                    break;

                case 9:
                    // Consultar estado del pedido
                    break;

                case 10:
                    // Consultar ingresos del restaurante
                    break;

                case 11:
                    // Consultar producto más vendido
                    break;

                case 12:
                    // Consultar categoría con mayores ingresos
                    break;

                case 0:
                    System.out.println("Gracias por utilizar Sabor & Tradicion.");
                    break;

                default:
                    System.out.println("Opcion no valida. Intente nuevamente.");
                    break;
            }




        }
        while (opcion != 0) ;
        scanner.close();
    }
}
