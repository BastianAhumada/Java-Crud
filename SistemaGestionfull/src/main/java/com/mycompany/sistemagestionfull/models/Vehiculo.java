/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemagestionfull.models;

/**
 *
 * @author bastian
 */
public class Vehiculo {
    private String id;
    private String Nombre;
    private String Apellido;
    private String Telefono;
    private String Email;
    
    public void Vehiculo(String id, String Patente, String Modelo, String Valor , String Email){
    this.Nombre = Patente;
    this.Apellido = Modelo;
    this.Telefono = Valor;
    this.Email = Email;
    
    }
    public String getid(){
    return this.id;
    }
    public String setId(String id){
       return this.id = id;
    }
    
    public String getNombre(){
     return this.Nombre;
    }
    public String setNombre(String Patente){
    return this.Nombre = Patente;
    }
    public String getApellido(){
    return this.Apellido;
    }
    public String setApellido(String Modelo){
    return this.Apellido = Modelo;
    }
    public String getTelefono(){
    return this.Telefono;
    }
    public String setTelefono(String Telefono){
    return this.Telefono = Telefono;
    }
    public String getEmail(){
    return this.Email;
    }
    public String setEmail(String Email){
    return this.Email = Email;
    }
    public String getDatos(){
    return this.Nombre + " " + this.Apellido + " " + this.Telefono + " " + this.Email ;
    }
}
