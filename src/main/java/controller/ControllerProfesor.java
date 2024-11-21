package controller;
import View.ConsoleView;
import da.ProfesoresDao;
import models.ConexionModel;
import models.ModelProfesor;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;


public class ControllerProfesor {

    private ConexionModel conexionModel;
    private ConsoleView conexionView;
    private ProfesoresDao profesoresDao;

    public ControllerProfesor(ConsoleView conexionView) {
        this.conexionView = conexionView;
        Connection connection = conexionModel.getConnection();
        this.profesoresDao = new ProfesoresDao(connection);
    }

    public void agregarProfesores(String nombre, String identificacion, String email, String estado, String fechaNacimiento) {
        ModelProfesor datos = new ModelProfesor(nombre, identificacion, email, estado, fechaNacimiento);

        try {
            profesoresDao.agregarProfesores(datos);
            conexionView.mostrarMensaje("Datos insertados");

        } catch (SQLException e) {
            conexionView.mostrarError("Fallo" + e.getMessage());

        }
    }

    public void modificarProfesores( String nombre, String identificacion, String email, String estado, String fechaNacimiento, String id) {
        ModelProfesor datos = new ModelProfesor(nombre, identificacion, email, estado, fechaNacimiento);
        datos.setId(id);

        try {
            profesoresDao.modificarProfesores(datos);
            conexionView.mostrarMensaje("Datos actualizados");

        } catch (SQLException e) {
            conexionView.mostrarError("Fallo" + e.getMessage());

        }
    }

    public void eliminarProfesores(String id) {
        try {
            profesoresDao.eliminarProfesores(id);
            conexionView.mostrarMensaje("Profesor eliminado correctamente");
        } catch (SQLException e) {
            conexionView.mostrarError("Fallo al eliminar: " + e.getMessage());
        }
    }

    public void obtenerProfesores() {

        try {
            ArrayList<ModelProfesor> modelProfesores = profesoresDao.obtenerProfesores();

            for (ModelProfesor item : modelProfesores)
                conexionView.mostrarMensaje
                        ("id:" + item.getId() +
                                " | nombre:" + item.getNombre() +
                                " | identificacion:" + item.getIdentificacion() +
                                " | email:" + item.getEmail()
                                + " | estado:" + item.getEstado()
                                + " | departamento:" + item.getDepartamento());

        } catch (SQLException e) {
            conexionView.mostrarError("Fallo" + e.getMessage());

        }
    }
}


