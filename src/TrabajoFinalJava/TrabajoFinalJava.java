/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author solera
 */
package TrabajoFinalJava;
public class TrabajoFinalJava {
    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        InicioSesion login = new InicioSesion();
        ListarUsuarios listarUsr = new ListarUsuarios();
        listarUsr.start();
        login.inicioSesion();
        
        
        
    }
    
}
