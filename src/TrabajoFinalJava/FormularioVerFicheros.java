/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoFinalJava;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import static TrabajoFinalJava.CrearListaFicheros.arrayArchivos;
import java.awt.Rectangle;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
/**
 *
 * @author solera
 */
public class FormularioVerFicheros extends Thread{
    static ArrayList<String> arrayArchivos = new ArrayList<String>();
    	public void run(){	
            
		//************************INICIO****INTERFAZ**************************************************************************
            
		JFrame principal = new JFrame ("GESTOR DESCARGAS");
                //Colores
 
              
                Color nuevoColor = new Color(167, 220, 231);
                
                principal.getContentPane().setBackground(nuevoColor);


		JLabel tituloPrincipal = new JLabel ("GESTOR DESCARGAS");
                JLabel tituloVentana = new JLabel ("VER FICHEROS");
                JTextArea  cajaFicheros = new  JTextArea(12,20);
               
                JButton mostrar = new JButton("MOSTRAR FICHEROS");
                JButton atras = new JButton("ATRAS");
                JButton salir = new JButton("SALIR");
                
                
               
              
                
              
                
               cajaFicheros.setEditable(false);
                
                
		//Recojo la fuente que se esta utilizando actualmente.
		Font auxFont=tituloPrincipal.getFont();

		//Aplico la fuente actual, y al final le doy el tamaño del texto...
		tituloPrincipal.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 30));
		tituloVentana.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 30));
               
                
                
           
           
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
                gbc.weighty = 0.1; 
                gbc.fill = GridBagConstraints.HORIZONTAL ;
                principal.add (tituloPrincipal,gbc);
                
		gbc.gridx = 1;
		gbc.gridy = 1;
                gbc.gridwidth = 1;
                gbc.gridheight = 1;
                gbc.weighty = 0.1; 
                gbc.fill = GridBagConstraints.NONE ;
                principal.add (tituloVentana,gbc);
                
                gbc.gridx = 0;
		gbc.gridy = 1;
                gbc.gridwidth = 1;
                gbc.gridheight = 1;
                gbc.weighty = 0.1; 
                gbc.fill = GridBagConstraints.HORIZONTAL ;
                principal.add (new JScrollPane(cajaFicheros),gbc);
                
                
                gbc.gridx = 1;
		gbc.gridy = 3;
                gbc.gridwidth = 1;
                gbc.gridheight = 1;
                gbc.weighty = 0.1; 
                gbc.fill = GridBagConstraints.NONE ;
                principal.add (mostrar,gbc);
                
                gbc.gridx = 0;
		gbc.gridy = 4;
                gbc.gridwidth = 1;
                gbc.gridheight = 1;
                gbc.weighty = 0.1; 
                gbc.fill = GridBagConstraints.NONE ;
                principal.add (atras,gbc);
                
                gbc.gridx = 1;
		gbc.gridy = 4;
                gbc.gridwidth = 1;
                gbc.gridheight = 1;
                gbc.weighty = 0.1; 
                gbc.fill = GridBagConstraints.NONE ;
                principal.add (salir,gbc);
                
              
                
                
                
                
                //cajaFicheros.setEditable(false);
                
                
		//Hace visible el panel
		principal.setVisible(true);
		principal.setSize(650, 350);
		principal.setLocationRelativeTo(null); 
		principal.setResizable(false);
		//principal.pack();
		
                
                
                
    

        
                mostrar.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){
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

                               

                                archivos = cFtp.listNames();


                                for(int i=0;i<archivos.length;i++ ){
                                    /*
                                    cajaFicheros.selectAll();
                                    cajaFicheros.replaceSelection("");
                                    */
                                    arrayArchivos.add(archivos[i].toString());
                                    System.out.println(arrayArchivos.get(i));
                                    cajaFicheros.append(System.getProperty("line.separator"));
                                    cajaFicheros.append(arrayArchivos.get(i));
                                    
                                    
                                }

                               
                               

                                cFtp.logout();
                                cFtp.disconnect();
                                System.out.println("Conexion Finalizada, buenas tardes.");
                            } catch(IOException ioe){ System.out.println("error"+ioe.toString()); }


                        }

                });
          
          
        
        
           try{
                salir.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){

                                System.exit(0);

                        }

                });
                }catch(Exception e){}
           
            
		 try{
                    atras.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e){

                                FormularioAccesoFtp accesoFtp = new FormularioAccesoFtp();
                                accesoFtp.inicioFtp();
                                principal.setVisible(false);

                            }

                    });
                    }catch(Exception e){}
                 
                 
               
                 
                 
                 
                 
    }
    
    
    
    
    
}
