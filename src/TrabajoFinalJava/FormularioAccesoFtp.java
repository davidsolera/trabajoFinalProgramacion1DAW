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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import static TrabajoFinalJava.ValidarUsuario.descargasUsuarioLog;
import static TrabajoFinalJava.ValidarUsuario.subidasUsuarioLog;
import static TrabajoFinalJava.ValidarUsuario.usuarioLog;
import static TrabajoFinalJava.ValidarUsuario.verificado;
/**
 *
 * @author solera
 */
public class FormularioAccesoFtp {
    
    FormularioVerFicheros verArchivos = new FormularioVerFicheros();
    CrearListaFicheros listaFicheros = new CrearListaFicheros();
    

    
    public void inicioFtp(){
        
        
         //************************INICIO****INTERFAZ**************************************************************************

                    JFrame principal = new JFrame ("GESTOR DESCARGAS");
                    //Colores


                    Color nuevoColor = new Color(167, 220, 231);

                    principal.getContentPane().setBackground(nuevoColor);


                    JLabel tituloPrincipal = new JLabel ("GESTOR DESCARGAS");
                    JLabel tituloVentana = new JLabel ("FTP");
                    //Recojo la fuente que se esta utilizando actualmente.
                    Font auxFont=tituloPrincipal.getFont();

                    //Aplico la fuente actual, y al final le doy el tamaño del texto...
                    tituloPrincipal.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 30));
                    tituloVentana.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 30));
                    //tituloVentana.setAlignmentY(0);

                    JButton verFicheros = new JButton ("VER FICHEROS");
                    JButton descarga = new JButton ("DESCARGAR FICHEROS");
                    JButton subida = new JButton ("SUBIR FICHEROS");
                    JButton cerrarSesion = new JButton ("Cerrar Sesion.");
                    JButton salir = new JButton ("Salir");
                    JLabel descargas = new JLabel();
                    JLabel subidas = new JLabel();
                    JLabel usuarioActual = new JLabel();
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
                    
                    gbc.gridx = 0;
                    gbc.gridy = 0;
                    gbc.gridwidth = 1;
                    gbc.gridheight = 0;
                    gbc.weighty = 0.0; 
                    gbc.fill = GridBagConstraints.NONE ;
                    principal.add (usuarioActual,gbc);

                    gbc.gridx = 2;
                    gbc.gridy = 0;
                    gbc.gridwidth = 0;
                    gbc.gridheight = 0;
                    gbc.weighty = 0.0; 
                    gbc.fill = GridBagConstraints.NONE ;
                    principal.add (descargas,gbc);
                    
                    

                    gbc.gridx = 1;
                    gbc.gridy = 1;
                    gbc.gridwidth = 1;
                    gbc.gridheight = 1;
                    gbc.weighty = 0.1; // La fila 0 debe estirarse, le ponemos un 1.0
                    gbc.fill = GridBagConstraints.NONE ;
                    principal.add (tituloVentana,gbc);
                    
                    gbc.gridx = 2;
                    gbc.gridy = 1;
                    gbc.gridwidth = 1;
                    gbc.gridheight = 1;
                    gbc.weighty = 0.0; 
                    gbc.fill = GridBagConstraints.NONE ;
                    principal.add (subidas,gbc);
                    
                    
                    
                    gbc.gridx = 0;
                    gbc.gridy = 3;
                    gbc.gridwidth = 1;
                    gbc.gridheight = 1;
                    gbc.weighty = 0.0; 
                    gbc.fill = GridBagConstraints.NONE ;
                    principal.add (verFicheros,gbc);
                    
                     gbc.gridx = 1;
                    gbc.gridy = 3;
                    gbc.gridwidth = 1;
                    gbc.gridheight = 1;
                    gbc.weighty = 0.0; 
                    gbc.fill = GridBagConstraints.NONE ;
                    principal.add (descarga,gbc);
                    
                    gbc.gridx = 2;
                    gbc.gridy = 3;
                    gbc.gridwidth = 1;
                    gbc.gridheight = 1;
                    gbc.weighty = 0.0;
                    gbc.fill = GridBagConstraints.NONE ;
                    principal.add (subida,gbc);
                    
                    gbc.gridx = 1;
                    gbc.gridy = 4;
                    gbc.gridwidth = 1;
                    gbc.gridheight = 1;
                    gbc.weighty = 0.0;
                    gbc.fill = GridBagConstraints.SOUTH ;
                    principal.add (cerrarSesion,gbc);
                    
                    
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
                    
                    
                    usuarioActual.setText("El usuario actual es: "+usuarioLog);
                    descargas.setText("Te quedan "+descargasUsuarioLog+" descargas.");
                    subidas.setText("Te quedan "+subidasUsuarioLog +" subidas.");
        
        try{
            
        verFicheros.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    
                   
                    verArchivos.start();
                    
                    principal.setVisible(false);
                }

        });
        }catch(Exception e){}
                    
        descarga.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                 
                 DescargaFichero descarga = new DescargaFichero();
                    descarga.start();
                      principal.setVisible(false);
                }
            
            
        });
        
         cerrarSesion.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                 
                 DescargaFichero descarga = new DescargaFichero();
                 
                    InicioSesion inicio = new InicioSesion();
                    verificado=0;
                    inicio.inicioSesion();
                    principal.setVisible(false);
                }
            
            
        });
        
    }
    
    
    
    
    
    
    
    
}
