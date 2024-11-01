package View;
import controller.ControllerEstudiante;
import java.io.BufferedReader;
import java.io.IOException;

public class ViewEstudiante {

    private static void imprimirMenu(){
        System.out.println("1- Registrar Estudiante.\n2- Listar Estudiante.\n3- Modificar Estudiante.\n4- Eliminar Estudiante.\n S- Volver");

    }

    public static void seleccionarOpc(BufferedReader br, ControllerEstudiante controller) throws IOException {
        String eleccion = "0";
        do {
            imprimirMenu();
            eleccion = br.readLine().trim(); // Agregamos trim()
            switch (eleccion.toUpperCase()) { // Usamos toUpperCase() para manejar tanto "S" como "s"
                case "1":
                    System.out.println("Ingrese el nombre: ");
                    String nombre = br.readLine();
                    System.out.println("Ingrese la identificaion: ");
                    String identificacion = br.readLine();
                    System.out.println("Ingrese el email: ");
                    String email = br.readLine();
                    System.out.println("Ingrese el estado: ");
                    String estado = br.readLine();
                    System.out.println("Ingrese la Fecha Nacimiento: ");
                    String fechaNacimiento = br.readLine();
                    controller.agregarEstudiantes(nombre, identificacion, email, estado, fechaNacimiento);
                    break;
                case "2":
                    controller.obtenerEstudiantes();
                    break;
                case "3":
                    System.out.println("Ingrese el id: ");
                    String idMod = br.readLine();
                    System.out.println("Ingrese el nombre: ");
                    String nombreMod = br.readLine();
                    System.out.println("Ingrese la identificaion: ");
                    String identificacionMod = br.readLine();
                    System.out.println("Ingrese el Email: ");
                    String emailMod = br.readLine();
                    System.out.println("Ingrese el estado: ");
                    String estadoMod = br.readLine();
                    System.out.println("Ingrese la Fecha Nacimiento: ");
                    String fechaNacimientoMod = br.readLine();

                    controller.modificarEstudiantes( nombreMod,identificacionMod, emailMod, estadoMod, fechaNacimientoMod, idMod);

                    break;
                case "4":
                    System.out.println("Ingrese el id: ");
                    String idEliminar = br.readLine();
                    controller.eliminarEstudiantes(idEliminar);
                    break;
                case "S":
                    System.out.println("Gracias por su preferencia. ");
                    break;
                default:
                    System.out.println("Ingrese una opcion valida  ");
                    break;
            }
        } while (!eleccion.equalsIgnoreCase("S"));

    }


}
