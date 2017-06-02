/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoFinalJava;

import static TrabajoFinalJava.FormularioVerFicheros.arrayArchivos;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.commons.net.ftp.FTPClient;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import static TrabajoFinalJava.ValidarUsuario.usuarioLog;
import static TrabajoFinalJava.ValidarUsuario.descargasUsuarioLog;
import static TrabajoFinalJava.ValidarUsuario.stmt;
import org.apache.commons.net.ftp.FTPFile;
import static TrabajoFinalJava.CrearListaFicheros.arrayArchivos;
/**
 *
 * @author solera
 */
 public class DescargaFichero extends Thread{
       FormularioVerFicheros verFicheros = new FormularioVerFicheros();
      
       
       private String nombreFichero;
       private String nombrePc;
       String ftpSsrver = "127.0.0.1"; 
       String ftpUser = "solera";
       String ftpPass = "solera";
       
       FTPClient cFtp = new FTPClient();
       
       
       
        public DescargaFichero(){
        
         
       }
       public DescargaFichero(String nombreFichero, String nombrePc){
           this.nombreFichero=nombreFichero;
           this.nombrePc=nombrePc;
       }
        
        @Override
        public void run(){
                   
            
        //************************INICIO****INTERFAZ**************************************************************************

                    JFrame principal = new JFrame ("GESTOR DESCARGAS");
                    //Colores


                    Color nuevoColor = new Color(167, 220, 231);

                    principal.getContentPane().setBackground(nuevoColor);


                    JLabel tituloPrincipal = new JLabel ("GESTOR DESCARGAS");
                    JLabel tituloVentana = new JLabel ("DESCARGA FICHERO FTP");
                    //Recojo la fuente que se esta utilizando actualmente.
                    Font auxFont=tituloPrincipal.getFont();

                    //Aplico la fuente actual, y al final le doy el tamaño del texto...
                    tituloPrincipal.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 30));
                    tituloVentana.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 30));
                    //tituloVentana.setAlignmentY(0);

                    JLabel nombreArchivo = new JLabel("INTRODUCE EL NOMBRE DEL FICHERO A DESCARGAR.");
                    JTextField nombreArchivoIn = new JTextField();
                    JButton descarga = new JButton ("DESCARGA FICHERO.");
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
                    principal.add (descarga,gbc);
                    
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
                    
                    
                  
            
            descarga.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    
                    
                        if(descargasUsuarioLog<=9){
                            try{
                                cFtp.connect(ftpSsrver);
                                boolean login = cFtp.login(ftpUser, ftpPass);
                                System.out.print("conexion establecida");

                                cFtp.enterLocalPassiveMode();

                                nombreFichero= nombreArchivoIn.getText();
                                nombrePc= nombreArchivoIn.getText();

                                
                               
                                   
                               
                               
                                CrearListaFicheros listarFicheros = new CrearListaFicheros();
                                listarFicheros.start();
                                
                                for(int i=0;i<CrearListaFicheros.arrayArchivos.size();i++){
                                   
                                   System.out.println(CrearListaFicheros.arrayArchivos.get(i));
                                   
                               }
                                   
                                
                                
                                
                                
                                if(CrearListaFicheros.arrayArchivos.contains(nombreFichero)){
                                    FTPFile file = cFtp.mlistFile(nombreFichero);
                                    long size = file.getSize();
                                    System.out.println("Tamaño del fichero= " + size);
                                    
                                    if(size>1000000){
                                        System.out.println("El fichero es muy grande......");
                                    }else{

                                            FileOutputStream fos = new FileOutputStream(nombreFichero);
                                            cFtp.retrieveFile(nombreFichero, fos);

                                            System.out.println("");
                                            System.out.println("Archivo recibido");

                                             nombreArchivoIn.setBackground(Color.green);
                                            descargasUsuarioLog=descargasUsuarioLog+1;
                                            System.out.println(descargasUsuarioLog);


                                            //modificamos las descargas totales del usuario en la BBDD
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



                                                stmt.executeUpdate("UPDATE usuarios SET bajadas = '"+descargasUsuarioLog+"' WHERE usuario = '"+usuarioLog+"';");


                                                System.out.print("Descargas modificadas correctamente.");

                                                conn.close();
                                            }catch(Exception i){System.out.println(e);}
                                    }
                                    
                            }else{
                                    System.out.println("El fichero no existe...");
                                     nombreArchivoIn.setText("El fichero no existe");
                                }
                                
                                    

                            }catch(IOException r){
                                r.printStackTrace(); 
                            }

                    }else{
                        System.out.println("No te quedan descargas... por favor comuniquese con el administrador del servidor. Gracias.");
                         nombreArchivoIn.setText("No te quedan descargas... por favor comuniquese con el administrador del servidor. Gracias.");
                        
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