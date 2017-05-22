/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoFinalJava;

import static TrabajoFinalJava.ValidarUsuario.stmt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author solera
 */
public class Registro extends Thread  {
    String nombre, apellido, correo, usuario, pass;
    static int verificarReg;        
    
    public Registro( String nombre, String apellido, String correo, String usuario, String pass){
        
        this.nombre=nombre;
        this.apellido=apellido;
        this.correo=correo;
        this.usuario=usuario;
        this.pass=pass;
           
    }
    
    
    public void run(){
     
        Connection conn;

        try{
                try{
                   Class.forName("com.mysql.jdbc.Driver");
                   System.out.print("conectado");
                } catch (Exception e){
                   e.printStackTrace();
                }
                conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/midb","root", "");
                System.out.println("Conn OK!");

                stmt=conn.createStatement();			

               
                String sql = "INSERT INTO `usuarios` (`nombre`, `apellido`, `mail`, `usuario`, `contrasenya`) VALUES ('"+ nombre + "', '"+apellido+ "', '"+correo+"', '"+usuario +"', '"+pass+"');";
                stmt.executeUpdate(sql);

                System.out.print("Insertado Correctamente");
                
                verificarReg=1;

        }
        catch(Exception e){
                System.out.println(e);
        }	


     }
    
    
    
}
