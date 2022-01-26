/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemagestionfull.dao;

import com.mycompany.sistemagestionfull.models.Vehiculo;
import com.mysql.cj.util.StringUtils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bastian
 */
public class ClienteDao {
    //Variables para conenctar a la base de datos
        public Connection conectarbd(){
        String basededatos = "java";
        String usuario = "root";
        String password = "";
        String hosting = "localhost";
        String port = "3306";
        String drivers = "com.mysql.jdbc.Driver";
        String conexionUrl = "jdbc:mysql://" + hosting + ":" + port + "/" + basededatos + "?useSSL=false";
        
        Connection conexion = null;
        //Captura de errores para la testear la correcta conexion a la base de datos
        try {
            Class.forName(drivers);
           conexion =  DriverManager.getConnection(conexionUrl,usuario,password);
           
        } catch (Exception ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexion;
    }
        //Funcion agregar un nuevo vehiculo enviandole como paramatreos el objeto vehiculo para asi acceder a sus constructores
    public void conectar(Vehiculo vehiculo){
        try {
            Connection conexion = conectarbd();
           String sql = "INSERT INTO `clientes` (`id`, `nombre`, `apellido`, `telefono`, `email`) VALUES (NULL, '" + vehiculo.getNombre()+"', '" + vehiculo.getApellido() + " ', '"+ vehiculo.getTelefono() +"', '"+ vehiculo.getEmail() + "');";
           Statement stmt = conexion.createStatement(); 
           stmt.execute(sql);
        } catch (Exception ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }
    //Funcion para listar los vehculos registrados en la base de datos
        public List<Vehiculo> listar(){
        List<Vehiculo> listacliente = new ArrayList<>();
        try {
           Connection conexion = conectarbd();
           String sql = "SELECT * FROM `clientes`;";
           Statement stmt = conexion.createStatement(); 
           //executeQUery se diferencia de execute ya que esta devuelve todos los datos de la tabla 
           ResultSet resultado = stmt.executeQuery(sql); 
           while (resultado.next()){
           Vehiculo vehiculo = new Vehiculo();
           vehiculo.setId(resultado.getString("Id"));   
           vehiculo.setNombre(resultado.getString("Nombre"));   
           vehiculo.setApellido(resultado.getString("Apellido"));
           vehiculo.setTelefono(resultado.getString("Telefono"));   
           vehiculo.setEmail(resultado.getString("Email")); 
           listacliente.add(vehiculo);

            }
           
        } catch (Exception ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listacliente;
 
    }
        //Funcion para eliminar un vehiculo eniandole el id corespondiente como parametr
        public void Eliminar(String id){
        try {
           Connection conexion = conectarbd();
           String sql = "DELETE FROM `clientes` WHERE `clientes`.`id` = "+ id;
           Statement stmt = conexion.createStatement(); 
           stmt.execute(sql);
        } catch (Exception ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }
        public void Modificar(Vehiculo vehiculo){
        try {
           Connection conexion = conectarbd();
           String sql = "UPDATE `clientes` SET `nombre` = '"+ vehiculo.getNombre() + "', `apellido` = '"+ vehiculo.getApellido()+ "', `telefono` = '"+ vehiculo.getTelefono() + "', `email` = ' " + vehiculo.getEmail() + "' WHERE `clientes`.`id` = " + vehiculo.getid();
           Statement stmt = conexion.createStatement(); 
           stmt.execute(sql);
        } catch (Exception ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }

    public void guardar(Vehiculo Vehiculo) {
        //Libreria StringUtils para corroborar que el campo este vacio.
        if(StringUtils.isEmptyOrWhitespaceOnly(Vehiculo.getid())){
         conectar(Vehiculo);
         Vehiculo.setId("");
        }
        else{
        Modificar(Vehiculo);
        Vehiculo.setId("");
        }
    }
        
}
