/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoFinalJava;

import static TrabajoFinalJava.ValidarUsuario.descargasUsuarioLog;
import static TrabajoFinalJava.ValidarUsuario.stmt;
import static TrabajoFinalJava.ValidarUsuario.subidasUsuarioLog;
import static TrabajoFinalJava.ValidarUsuario.usuarioLog;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

/**
 *
 * @author solera
 */
public class SubirFicheros extends Thread{
       FormularioVerFicheros verFicheros = new FormularioVerFicheros();
      
       
       private String nombreFichero;
       private String nombrePc;
       String ftpSsrver = "127.0.0.1"; 
       String ftpUser = "solera";
       String ftpPass = "solera";
       
       FTPClient cFtp = new FTPClient();
       
        @Override
        public void run(){
                   
            
        //************************INICIO****INTERFAZ**************************************************************************

                    JFrame principal = new JFrame ("GESTOR DESCARGAS");
                    //Colores


                    Color nuevoColor = new Color(167, 220, 231);

                    principal.getContentPane().setBackground(nuevoColor);


                    JLabel tituloPrincipal = new JLabel ("GESTOR DESCARGAS");
                    JLabel tituloVentana = new JLabel ("SUBIDA FICHERO FTP");
                    //Recojo la fuente que se esta utilizando actualmente.
                    Font auxFont=tituloPrincipal.getFont();

                    //Aplico la fuente actual, y al final le doy el tamaño del texto...
                    tituloPrincipal.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 30));
                    tituloVentana.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 30));
                    //tituloVentana.setAlignmentY(0);

                    JLabel nombreArchivo = new JLabel("INTRODUCE EL NOMBRE DEL FICHERO A SUBIR.");
                    JTextField nombreArchivoIn = new JTextField();
                    JButton subida = new JButton ("SUBIDA FICHERO.");
                    JButton atras = new JButton("ATRAS");
                    
                    JButton salir = new JButton ("Salir");


                    GridBagLayout gridbag = new GridBagLayout();
                    GridBagConstraints gbc = new GridBagConstraints();

                    //Asignamos la constante EXIT_ON_CLOSE, cierra la ventana al pulsar la X.
                    principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    //Asignamos al JFrame el Layout que usaremos, GridBagLayout
                    principal.setLayout (gridbag);
                    //a�adir botones al layout

                    gbc.gridx = 1;
                    gbc.gridy = 0;
                    gbc.gridwidth = 1;
                    gbc.gridheight = 1;
                    gbc.weighty = 0.1; // La fila 0 debe estirarse, le ponemos un 1.0
                    gbc.fill = GridBagConstraints.HORIZONTAL ;
                    principal.add (tituloPrincipal,gbc);


                    gbc.gridx = 1;
                    gbc.gridy = 1;
                    gbc.gridwidth = 1;
                    gbc.gridheight = 1;
                    gbc.weighty = 0.1; // La fila 0 debe estirarse, le ponemos un 1.0
                    gbc.fill = GridBagConstraints.NONE ;
                    principal.add (tituloVentana,gbc);
                    
                    gbc.gridx = 1;
                    gbc.gridy = 2;
                    gbc.gridwidth = 1;
                    gbc.gridheight = 1;
                    gbc.weighty = 0.0; 
                    gbc.fill = GridBagConstraints.HORIZONTAL ;
                    principal.add (nombreArchivo,gbc);
                    
                    gbc.gridx = 1;
                    gbc.gridy = 3;
                    gbc.gridwidth = 1;
                    gbc.gridheight = 1;
                    gbc.weighty = 0.0; 
                    gbc.fill = GridBagConstraints.HORIZONTAL ;
                    principal.add (nombreArchivoIn,gbc);
                    
                    
                    gbc.gridx = 1;
                    gbc.gridy = 4;
                    gbc.gridwidth = 1;
                    gbc.gridheight = 1;
                    gbc.weighty = 0.0; 
                    gbc.fill = GridBagConstraints.NONE ;
                    principal.add (subida,gbc);
                    
                    gbc.gridx = 0;
                    gbc.gridy = 5;
                    gbc.gridwidth = 1;
                    gbc.gridheight = 1;
                    gbc.weighty = 0.1; 
                    gbc.fill = GridBagConstraints.NONE ;
                    principal.add (atras,gbc);
                    
                    gbc.gridx = 1;
                    gbc.gridy = 5;
                    gbc.gridwidth = 1;
                    gbc.gridheight = 1;
                    gbc.weighty = 0.1; // La fila 0 debe estirarse, le ponemos un 1.0
                    gbc.fill = GridBagConstraints.HORIZONTAL ;
                    principal.add (salir,gbc);
                    
                    
                    //Hace visible el panel
                    principal.setVisible(true);
                    principal.setSize(650, 350);
                    principal.setLocationRelativeTo(null); 
                    principal.setResizable(false);
                    //principal.pack();
                    
            
            subida.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    
                    
                        if(subidasUsuarioLog<=4){
                            try{
                                cFtp.connect(ftpSsrver);
                                boolean login = cFtp.login(ftpUser, ftpPass);
                                System.out.print("conexion establecida");

                                cFtp.enterLocalPassiveMode();

                                nombreFichero= nombreArchivoIn.getText();
                                nombrePc= nombreArchivoIn.getText();

                                File localFile = new File(nombreFichero);
                                long tamFichero = localFile.length();
                                
                                System.out.println("Tamaño del fichero= " + tamFichero);
                               
                                if(tamFichero>1000000){
                                    System.out.println("El fichero es muy grande......");
                                }else{
                                    
                                    if(localFile.exists()){
                                        String nombreRemoto = nombreFichero;
                                        InputStream imputStream = new FileInputStream(localFile);

                                        System.out.println("");
                                        System.out.println("Subiendo....");
                                        
                                        boolean done = cFtp.storeFile(nombreRemoto, imputStream);

                                        imputStream.close();
                                        
                                        if(done){
                                            System.out.println("Subido correctamente");
                                             nombreArchivoIn.setBackground(Color.green);
                                        }
                                        
                                        subidasUsuarioLog=subidasUsuarioLog+1;
                                        System.out.println(subidasUsuarioLog);

                                        //modificamos las subidas totales del usuario en la BBDD
                                        Connection conn;

                                        try{
                                            try{
                                               Class.forName("com.mysql.jdbc.Driver");
                                            } catch (Exception y){
                                               y.printStackTrace();
                                            }


                                            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/midb","root", "");
                                            System.out.println("Conn OK!");

                                            stmt=conn.createStatement();			



                                            stmt.executeUpdate("UPDATE usuarios SET subidas = '"+subidasUsuarioLog+"' WHERE usuario = '"+usuarioLog+"';");


                                            System.out.print("Subidas modificadas correctamente.");

                                            conn.close();
                                        }catch(Exception i){System.out.println(e);}
                                        
                                        
                                    }else{
                                        System.out.print("El fichero no existe");
                                         nombreArchivoIn.setText("El fichero no existe...");
                                    }
                                }
                                    
                                    
                            }catch(IOException r){
                                r.printStackTrace(); 
                            }

                    }else{
                            System.out.println("No te quedan subidas... por favor comuniquese con el administrador del servidor. Gracias.");
                            
                            nombreArchivoIn.setText("No te quedan subidas. Contacta con el administrador.");
                        
                        
                        }


                }
            
             });
            
            atras.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e){

                                FormularioAccesoFtp accesoFtp = new FormularioAccesoFtp();
                                accesoFtp.inicioFtp();
                                principal.setVisible(false);

                            }

                    });
            
                
              salir.addActionListener(new ActionListener(){
                  public void actionPerformed(ActionEvent e){
                  
                      System.exit(1000);
                  
                  }
                  
             });
            
        }
      
   
        
        
        
    }