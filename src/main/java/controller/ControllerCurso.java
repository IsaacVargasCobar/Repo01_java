package controller;
import View.ConsoleView;
import da.CursosDao;
import models.ConexionModel;
import models.ModelCurso;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControllerCurso {

    private ConexionModel conexionModel;

    private ConsoleView conexionView;
    private CursosDao cursoDao;

    public ControllerCurso(ConsoleView conexionView) {
        this.conexionView = conexionView;
        Connection connection = conexionModel.getConnection();
        this.cursoDao = new CursosDao(connection);
    }

    public void agregarCursos(String nombre , String descripcion , String estado){
        ModelCurso datos = new ModelCurso(nombre,descripcion,estado);

        try{
            cursoDao.agregarCurso(datos);
            conexionView.mostrarMensaje("Datos insertados");

        }catch (SQLException e){
            conexionView.mostrarError("Fallo" + e.getMessage());

        }
    }

    public void modificarCursos(String nombre , String descripcion , String estado, String id){
        ModelCurso datos = new ModelCurso(nombre,descripcion,estado);
        datos.setId(id);

        try{
            cursoDao.modificarCurso(datos);
            conexionView.mostrarMensaje("Datos actualizados");

        }catch (SQLException e){
            conexionView.mostrarError("Fallo" + e.getMessage());

        }
    }

    public void eliminarCurso( String id) {
        try {
            cursoDao.eliminarCurso(id);
            conexionView.mostrarMensaje("Curso eliminado correctamente");
        } catch (SQLException e) {
            conexionView.mostrarError("Fallo al eliminar: " + e.getMessage());
        }
    }

    public void obtenerCursos(){

        try{
            ArrayList<ModelCurso> modelCursos = cursoDao.obtenerCursos();

            for (ModelCurso item : modelCursos)
            conexionView.mostrarMensaje
                    ("id: " + item.getId() +
                    " | nombre: "+ item.getNombre() +
                    " | descripcion: "+ item.getDescripcion() +
                            " | estado: "+ item.getEstado());

        }catch (SQLException e){
            conexionView.mostrarError("Fallo" + e.getMessage());

        }
    }



}