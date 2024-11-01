package View;
import controller.ControllerCurso;
import java.io.BufferedReader;
import java.io.IOException;

public class ViewCurso {

    private static void imprimirMenu(){
        System.out.println("1- Registrar Curso.\n2- Listar Cursos.\n3- Modificar Curso.\n4- Eliminar Curso.\n S- Volver");

    }

    public static void seleccionarOpc(BufferedReader br, ControllerCurso controller) throws IOException {
        String eleccion = "0";
        do {
           imprimirMenu();
            eleccion = br.readLine().trim(); // Agregamos trim()
            switch (eleccion.toUpperCase()) { // Usamos toUpperCase() para manejar tanto "S" como "s"
                case "1":
                    System.out.println("Ingrese el nombre: ");
                    String nombre = br.readLine();
                    System.out.println("Ingrese la descripcion: ");
                    String descripcion = br.readLine();
                    System.out.println("Ingrese el estado: ");
                    String estado = br.readLine();
                    controller.agregarCursos(nombre,descripcion,estado);
                    break;
                case "2":
                  controller.obtenerCursos();
                    break;
                case "3":
                    System.out.println("Ingrese el id: ");
                    String id = br.readLine();
                    System.out.println("Ingrese el nombre: ");
                    String nombreMod = br.readLine();
                    System.out.println("Ingrese la descripcion: ");
                    String descripcionMod = br.readLine();
                    System.out.println("Ingrese el estado: ");
                    String estadoMod = br.readLine();

                    controller.modificarCursos(nombreMod,descripcionMod,estadoMod,id);

                    break;
                case "4":
                    System.out.println("Ingrese el id: ");
                    String idEliminar = br.readLine();
                    controller.eliminarCurso(idEliminar);
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


