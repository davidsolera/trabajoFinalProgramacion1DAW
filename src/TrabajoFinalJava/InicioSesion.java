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
import static TrabajoFinalJava.ValidarUsuario.verificado;
import static TrabajoFinalJava.ValidarUsuario.usuarioLog;
import static TrabajoFinalJava.ValidarUsuario.descargasUsuarioLog;
import static TrabajoFinalJava.ValidarUsuario.subidasUsuarioLog;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author solera
 */
public class InicioSesion {
    //************************INICIO****INTERFAZ**************************************************************************
Herramientas hr = new Herramientas();         
FormularioRegistro reg = new FormularioRegistro();
FormularioAccesoFtp inicioFtp = new FormularioAccesoFtp();

    public void inicioSesion(){	

        //************************INICIO****INTERFAZ**************************************************************************

        JFrame principal = new JFrame ("GESTOR DESCARGAS");
        //Colores
        

        Color nuevoColor = new Color(167, 220, 231);

        principal.getContentPane().setBackground(nuevoColor);


        JLabel tituloPrincipal = new JLabel ("GESTOR DESCARGAS");
        JLabel tituloVentana = new JLabel ("INICIO SESION");
        //Recojo la fuente que se esta utilizando actualmente.
        Font auxFont=tituloPrincipal.getFont();

        //Aplico la fuente actual, y al final le doy el tamaño del texto...
        tituloPrincipal.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 30));
        tituloVentana.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 30));
        //tituloVentana.setAlignmentY(0);

        JButton enviar = new JButton ("INICIAR SESION");
        JButton irRegistro = new JButton ("Registrarse");
        JButton salir = new JButton ("Salir");
        JLabel nom = new JLabel ("Introduce tu nombre.");
        JLabel pass = new JLabel ("Introduce tu password.");
       
        JLabel fecha = new JLabel (hr.fechaInterfaz());

        JTextField nomIn = new JTextField("");
        JPasswordField passIn = new JPasswordField("");
        JPasswordField pass2In = new JPasswordField("");
        JTextField error = new JTextField("El usuario o la contraseña es incorrecta, vuelve a intentarlo o pulse el boton REGISTRARSE.");


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



        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 0.1; // La fila 0 debe estirarse, le ponemos un 1.0
        gbc.fill = GridBagConstraints.HORIZONTAL ;
        principal.add (nom,gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 0.1; // La fila 0 debe estirarse, le ponemos un 1.0
        gbc.fill = GridBagConstraints.HORIZONTAL ;
        principal.add (nomIn,gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 0.1; // La fila 0 debe estirarse, le ponemos un 1.0
        gbc.fill = GridBagConstraints.HORIZONTAL ;
        principal.add (pass,gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 0.1; // La fila 0 debe estirarse, le ponemos un 1.0
        gbc.fill = GridBagConstraints.HORIZONTAL ;
        principal.add (passIn,gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 0.1; // La fila 0 debe estirarse, le ponemos un 1.0
        gbc.fill = GridBagConstraints.HORIZONTAL ;
        principal.add (error,gbc);
        
        
        
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 0.1; // La fila 0 debe estirarse, le ponemos un 1.0
        gbc.fill = GridBagConstraints.HORIZONTAL ;
        principal.add (enviar,gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 0.1; // La fila 0 debe estirarse, le ponemos un 1.0
        gbc.fill = GridBagConstraints.HORIZONTAL ;
        principal.add (irRegistro,gbc);


        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 0.1; // La fila 0 debe estirarse, le ponemos un 1.0
        gbc.fill = GridBagConstraints.HORIZONTAL ;
        principal.add (salir,gbc);


        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 0.1; // La fila 0 debe estirarse, le ponemos un 1.0
        gbc.fill = GridBagConstraints.CENTER ;
        principal.add (fecha,gbc);

        error.setVisible(false);
        
        //Hace visible el panel
        principal.setVisible(true);
        principal.setSize(650, 350);
        principal.setLocationRelativeTo(null); 
        principal.setResizable(false);
        //principal.pack();
        
        //obtener ip del ordenador local     
        try {
            String ip=InetAddress.getLocalHost().getHostAddress();
            System.out.println("La ip es: "+ip);
        } catch (UnknownHostException ex) {
            Logger.getLogger(InicioSesion.class.getName()).log(Level.SEVERE, null, ex);
        }


        try{
            enviar.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){

                            if(!"".equals(nomIn.getText())&&!"".equals(passIn.getText())){
                                String nombre = nomIn.getText();
                                String password = passIn.getText();
                                ValidarUsuario valUser = new ValidarUsuario(nombre, password);
                                hr.muestra(nombre);
                                hr.muestra(password);

                                valUser.start();

                               while(valUser.isAlive()){
                                   System.out.println("aun esta validando...");

                               }

                                if(verificado==1){

                                   inicioFtp.inicioFtp();
                                   principal.setVisible(false);
                                   hr.muestra("El usuario es correcto, puede continuar");
                                   hr.muestra("El usuario actual es: "+usuarioLog);
                                   hr.muestra("El usuario actual tiene un total de: "+descargasUsuarioLog+" descargas por utilizar");
                                   hr.muestra("El usuario actual tiene un total de: "+subidasUsuarioLog+" subidas por utilizar");

                                }else{
                                   hr.muestra("El usuario no existe o la contraseña es incorrecta...");
                                   error.setVisible(true);

                                }

                        }else{
                                nomIn.setText("No puede estar vacio");
                                passIn.setText("No puede estar vacio");
                            }

                    }

            });
            }catch(Exception e){}

    try{
        irRegistro.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){

                    reg.registro();
                    principal.setVisible(false);
                }

        });
        }catch(Exception e){}

   try{
        salir.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){

                        System.exit(0);

                }

        });
        }catch(Exception e){}

    }
}
