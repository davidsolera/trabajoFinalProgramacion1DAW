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
public class ListarUsuarios extends Thread  {
    static int numeroUsuarios;
    int numeroRegistros;
    static ArrayList<Usuarios> usersGeneral = new ArrayList<Usuarios>();
            
    public void run(){
          int i=0;
        Connection conn;

        //creacion array usuarios
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

                String sql = "SELECT * FROM usuarios;";
			
			ResultSet rs = stmt.executeQuery(sql);
			String nombre, apellido, password, usuario, email;
			int nDescargas, nSubidas;
		
			rs.last();
			numeroRegistros = rs.getRow();
			rs.beforeFirst();
			
			Usuarios [] user = new Usuarios[numeroRegistros];
                        
			while(rs.next()){
				
				nombre = rs.getString("nombre");
                                apellido = rs.getString("apellido");
				password = rs.getString("contrasenya");
                                usuario = rs.getString("usuario");
				email = rs.getString("mail");
				nDescargas = rs.getInt("bajadas");
                                nSubidas= rs.getInt("subidas");
                              
				user[i]=new Usuarios(nombre, apellido,  password, usuario, email, nDescargas, nSubidas);
				
                                usersGeneral.add(user[i]);
                                
                                System.out.println(user[i].getNombre()+" "+user[i].getApellidos()+" "+user[i].getEmail()+" "+user[i].getUsuario()+" "+user[i].getPassword());
                                //System.out.println("Mostrado desde ListarUsuarios"+usersGeneral.get(i).getUsuario()+" "+usersGeneral.get(i).getPassword());
                                i++;
			}
                        numeroUsuarios=user.length;
                        
        }catch(Exception e){
                System.out.println(e);
        }	

     }
    
    
    
}
