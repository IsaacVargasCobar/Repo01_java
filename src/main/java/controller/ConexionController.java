package controller;

import View.ConsoleView;
import models.ConexionModel;

import java.sql.Connection;
import java.sql.SQLException;

public class ConexionController {

   private ConsoleView vista;

   public ConexionController(ConsoleView vista){
       this.vista = vista;
   }

   public void abrirConexion(){
       Connection connection = ConexionModel.getConnection();

       if (connection != null) {
           try{
               connection.close();
               vista.mostrarMensaje("Conexion Establecida");
           }catch (SQLException e){
               vista.mostrarError("Conexion Presenta errores" + e.getMessage());

           }
       }else {

       }
   }


}
