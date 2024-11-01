package View;
import controller.ControllerProfesor;

import java.io.BufferedReader;
import java.io.IOException;

public class ViewProfesor {

    private static void imprimirMenu(){
        System.out.println("1- Registrar Profesor.\n2- Listar Profesor.\n3- Modificar Profesor.\n4- Eliminar Profesor.\n S- Volver");

    }

    public static void seleccionarOpc(BufferedReader br, ControllerProfesor controller) throws IOException {
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
                    System.out.println("Ingrese la Departamento: ");
                    String departamento = br.readLine();
                    controller.agregarProfesores(nombre, identificacion, email, estado, departamento);
                    break;
                case "2":
                    controller.obtenerProfesores();
                    break;
                case "3":
                    System.out.println("Ingrese el id: ");
                    String id = br.readLine();
                    System.out.println("Ingrese el nombre: ");
                    String nombreMod = br.readLine();
                    System.out.println("Ingrese la identificaion: ");
                    String identificacionMod = br.readLine();
                    System.out.println("Ingrese el Email: ");
                    String emailMod = br.readLine();
                    System.out.println("Ingrese el estado: ");
                    String estadoMod = br.readLine();
                    System.out.println("Ingrese la Departamento: ");
                    String departamentoMod = br.readLine();

                    controller.modificarProfesores( nombreMod,identificacionMod, emailMod, estadoMod, departamentoMod, id);

                    break;
                case "4":
                    System.out.println("Ingrese el id: ");
                    String idEliminar = br.readLine();
                    controller.eliminarProfesores(idEliminar);
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
