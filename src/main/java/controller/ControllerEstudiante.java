package controller;
import View.ConsoleView;
import da.EstudiantesDao;
import models.ConexionModel;
import models.ModelEstudiante;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;


public class ControllerEstudiante {

    private ConexionModel conexionModel;

    private ConsoleView conexionView;
    private EstudiantesDao estudiantesDao;

    public ControllerEstudiante(ConsoleView conexionView) {
        this.conexionView = conexionView;
        Connection connection = conexionModel.getConnection();
        this.estudiantesDao = new EstudiantesDao(connection);
    }

    public void agregarEstudiantes(String nombre, String identificacion, String email, String estado, String fechaNacimiento) {
        ModelEstudiante datos = new ModelEstudiante(nombre, identificacion, email, estado, fechaNacimiento);

        try {
            estudiantesDao.agregarEstudiantes(datos);
            conexionView.mostrarMensaje("Datos insertados");

        } catch (SQLException e) {
            conexionView.mostrarError("Fallo" + e.getMessage());

        }
    }

    public void modificarEstudiantes( String nombre, String identificacion, String email, String estado, String fechaNacimiento, String id) {
        ModelEstudiante datos = new ModelEstudiante(nombre, identificacion, email, estado, fechaNacimiento);
        datos.setId(id);

        try {
            estudiantesDao.modificarEstudiantes(datos);
            conexionView.mostrarMensaje("Datos actualizados");

        } catch (SQLException e) {
            conexionView.mostrarError("Fallo" + e.getMessage());

        }
    }

    public void eliminarEstudiantes(String id) {
        try {
            estudiantesDao.eliminarEstudiantes(id);
            conexionView.mostrarMensaje("Estudiante eliminado correctamente");
        } catch (SQLException e) {
            conexionView.mostrarError("Fallo al eliminar: " + e.getMessage());
        }
    }

    public void obtenerEstudiantes() {

        try {
            ArrayList<ModelEstudiante> modelEstudiantes = estudiantesDao.obtenerEstudiantes();

            for (ModelEstudiante item : modelEstudiantes)
                conexionView.mostrarMensaje
                        ("id:" + item.getId() +
                                " | nombre:" + item.getNombre() +
                                " | identificacion:" + item.getIdentificacion() +
                                " | email:" + item.getEmail()
                                + " | estado:" + item.getEstado()
                                + " | fechaNacimiento:" + item.getFechaNacimiento());

        } catch (SQLException e) {
            conexionView.mostrarError("Fallo" + e.getMessage());

        }
    }
}


