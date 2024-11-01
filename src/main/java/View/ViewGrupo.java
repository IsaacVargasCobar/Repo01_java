package View;
import controller.ControllerGrupo;
import java.io.BufferedReader;
import java.io.IOException;

public class ViewGrupo {

    private static void imprimirMenu(){
        System.out.println("1- Registrar Grupo.\n2- Listar Grupo.\n3- Modificar Grupo.\n4- Eliminar Grupo.\n S- Volver");

    }

    public static void seleccionarOpc(BufferedReader br, ControllerGrupo controller) throws IOException {
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
                    controller.agregarGrupos(nombre,descripcion,estado);
                    break;
                case "2":
                    controller.obtenerGrupos();
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

                    controller.modificarGrupo(nombreMod,descripcionMod,estadoMod,id);

                    break;
                case "4":
                    System.out.println("Ingrese el id: ");
                    String idEliminar = br.readLine();
                    controller.eliminarGrupo(idEliminar);
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
