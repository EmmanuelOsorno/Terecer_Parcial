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

            System.out.println("Elija la opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {




            }

        }
        while (opcion != 0) ;
        scanner.close();
    }
}
