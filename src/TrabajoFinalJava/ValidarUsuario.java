/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoFinalJava;

import static TrabajoFinalJava.ListarUsuarios.numeroUsuarios;
import static TrabajoFinalJava.ListarUsuarios.usersGeneral;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author solera
 */
public class ValidarUsuario extends Thread {
    String nombre="";
    String password="";
    static Statement  stmt;
    static int verificado=0;
    ListarUsuarios listarUsers = new ListarUsuarios();
   
    Herramientas hr = new Herramientas();     
    
    public ValidarUsuario(){
        
        
    }
    
    public ValidarUsuario(String nom, String pass){
        this.nombre=nom;
        this.password=pass;
    }
    
    
    
     public void run(){
        listarUsers.start();
        while(listarUsers.isAlive()){
            System.out.println("Obteniendo listado de usuarios...");
            
        }
        
        
        System.out.println(usersGeneral.get(0));
        for(int i=0;i<usersGeneral.size();i++){
                //System.out.println("Mostrado desde ValidarUsuarios "+usersGeneral.get(i).getUsuario()+" "+usersGeneral.get(i).getPassword());
                
             if(usersGeneral.get(i).getUsuario().equals(nombre)&&usersGeneral.get(i).getPassword().equals(password)){
                 verificado=1;
                 System.out.println(verificado);
             }
                
             
         }
       
     }
    
}
