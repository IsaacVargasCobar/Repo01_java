package UI;

import View.*;
import controller.*;

import java.io.InputStreamReader;
import java.io.BufferedReader;
public class Main {
    public static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws Exception {

        System.out.println("Proyecto Conectando MySQL");
        ConsoleView console = new ConsoleView();
        ConexionController controlador = new ConexionController(console);
        controlador.abrirConexion();

        
        String eleccion = "0";
        do {
            System.out.println("1- Gestionar Curso \n 2- Gestionar Estudiante \n 3- Gestionar Profesor \n 4- Gestionar Grupo   \nS- Salir");
            eleccion = leer.readLine().trim(); // Agregamos trim()
            switch (eleccion.toUpperCase()) { // Usamos toUpperCase() para manejar tanto "S" como "s"
                case "1":
                    ControllerCurso controllerCurso = new ControllerCurso(console);
                   ViewCurso.seleccionarOpc(leer, controllerCurso);
                    break;

                case "2":
                    ControllerEstudiante controllerEstudiante = new ControllerEstudiante(console);
                    ViewEstudiante.seleccionarOpc(leer, controllerEstudiante);
                    break;

                case "3":
                    ControllerProfesor controllerProfesor= new ControllerProfesor(console);
                    ViewProfesor.seleccionarOpc(leer, controllerProfesor);
                    break;

                case "4":
                    ControllerGrupo controllerGrupo = new ControllerGrupo(console);
                    ViewGrupo.seleccionarOpc(leer, controllerGrupo);
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