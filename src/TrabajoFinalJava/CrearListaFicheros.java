/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoFinalJava;


import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

/**
 *
 * @author solera
 */
public class CrearListaFicheros extends Thread{
        static ArrayList<String> arrayArchivos = new ArrayList<String>();
        
        @Override
        public void run(){
           
        String ftpSsrver = "127.0.0.1"; 
        String ftpUser = "solera";
        String ftpPass = "solera";
        
        
        
        FTPClient cFtp = new FTPClient();
        
        try{
            
            cFtp.connect(ftpSsrver);
            boolean login = cFtp.login(ftpUser, ftpPass);
            System.out.print("conexion ftp para ver ficheros establecida");
            
           cFtp.enterLocalPassiveMode();
            
           
            
            String []archivos = cFtp.listNames();
            FTPFile[] detalles = cFtp.listFiles();
            
            /*
            for(int i=0;i<archivos.length;i++ ){
                System.out.println(archivos[i]);
                
            }
           */
           
            archivos = cFtp.listNames();
           
            
            for(int i=0;i<archivos.length;i++ ){
                
                arrayArchivos.add(archivos[i]);
               // System.out.println("Mostrando arrayArchivos.get(i)"+arrayArchivos.get(i));
            }
            /*
            for(int i=0;i<detalles.length;i++ ){
                System.out.println(detalles[i].toString());
                
            }
            */
            cFtp.logout();
            cFtp.disconnect();
            System.out.println("Conexion Finalizada, buenas tardes.");
        } catch(IOException ioe){ System.out.println("error"+ioe.toString()); }
            
            
        }
        
        
    }