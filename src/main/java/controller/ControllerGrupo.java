package controller;

import View.ConsoleView;
import da.GruposDao;
import models.ConexionModel;
import models.ModelGrupo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControllerGrupo {

    private ConexionModel conexionModel;

    private ConsoleView conexionView;
    private GruposDao gruposDao;

    public  ControllerGrupo(ConsoleView conexionView) {
        this.conexionView = conexionView;
        Connection connection = conexionModel.getConnection();
        this.gruposDao = new GruposDao(connection);
    }

    public void agregarGrupos(String nombre , String descripcion , String estado){
        ModelGrupo datos = new ModelGrupo(nombre,descripcion,estado);

        try{
            gruposDao.agregarGrupo(datos);
            conexionView.mostrarMensaje("Datos insertados");

        }catch (SQLException e){
            conexionView.mostrarError("Fallo" + e.getMessage());

        }
    }

    public void modificarGrupo(String nombre , String descripcion , String estado, String id){
        ModelGrupo datos = new ModelGrupo(nombre,descripcion,estado);
        datos.setId(id);

        try{
             gruposDao.modificarGrupo(datos);
            conexionView.mostrarMensaje("Datos actualizados");

        }catch (SQLException e){
            conexionView.mostrarError("Fallo" + e.getMessage());

        }
    }

    public void eliminarGrupo( String id) {

        try {
             gruposDao.eliminarGrupo(id);
            conexionView.mostrarMensaje("Curso eliminado correctamente");
        } catch (SQLException e) {
            conexionView.mostrarError("Fallo al eliminar: " + e.getMessage());
        }
    }

    public void obtenerGrupos(){

        try{
            ArrayList<ModelGrupo> modelGrupos =  gruposDao.obtenerGrupo();

            for (ModelGrupo item : modelGrupos)
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