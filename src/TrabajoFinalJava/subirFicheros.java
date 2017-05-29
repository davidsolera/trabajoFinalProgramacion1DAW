/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoFinalJava;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

/**
 *
 * @author solera
 */
public class subirFicheros extends Thread{
        
        @Override
        public void run(){
           
             // Creando nuestro objeto ClienteFTP
        FTPClient client = new FTPClient();
 
        // Datos para conectar al servidor FTP
        String ftpServer = "127.0.0.1"; 
        String userFtp = "solera";
        String ftpPass = "solera";
 
        try {
            // Conactando al servidor
            client.connect(ftpServer);
 
            // Logueado un usuario (true = pudo conectarse, false = no pudo
            // conectarse)
            boolean login = client.login(userFtp, ftpPass);
 
            //client.setFileType(ftpServer.BINARY_FILE_TYPE, FTP.BINARY_FILE_TYPE);
           // client.setFileTransferMode(ftpServer.BINARY_FILE_TYPE);
            client.enterLocalPassiveMode();
 
            String filename = "miarchivo.txt";
 
            FileInputStream fis = new FileInputStream(filename);
 
            // Guardando el archivo en el servidor
            client.storeFile(filename, fis);
 
            // Cerrando sesión
            client.logout();
 
            // Desconectandose con el servidor
            client.disconnect();
 
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }   


        }

        
    }