/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoFinalJava;


import static TrabajoFinalJava.Registro.verificarReg;
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

/**
 *
 * @author solera
 */
public class FormularioRegistro {

    
    public void registro(){
        Herramientas hr = new Herramientas();         
        InicioSesion inicio = new InicioSesion();   
        
      //************************INICIO****INTERFAZ**************************************************************************

                    JFrame principal = new JFrame ("GESTOR DESCARGAS");
                    //Colores


                    Color nuevoColor = new Color(167, 220, 231);

                    principal.getContentPane().setBackground(nuevoColor);


                    JLabel tituloPrincipal = new JLabel ("GESTOR DESCARGAS");
                    JLabel tituloVentana = new JLabel ("REGISTRO");
                    //Recojo la fuente que se esta utilizando actualmente.
                    Font auxFont=tituloPrincipal.getFont();

                    //Aplico la fuente actual, y al final le doy el tamaño del texto...
                    tituloPrincipal.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 30));
                    tituloVentana.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 30));
                    //tituloVentana.setAlignmentY(0);

                    JButton enviar = new JButton ("REGISTRARSE");
                    JButton irInicioSesion = new JButton ("INICIAR SESION");
                    JButton salir = new JButton ("Salir");

                    JLabel nomuser = new JLabel ("Introduce tu nombre de usuario.");
                    JLabel pass = new JLabel ("Introduce tu password.");
                    JLabel pass2 = new JLabel ("Repite tu password.");
                    JLabel nomReal = new JLabel ("Introduce tu nombre real.");
                    JLabel apellidos = new JLabel ("Introduce tus pellidos.");
                    JLabel mail = new JLabel ("Introduce tu correo.");
                    JLabel fechaNac = new JLabel ("Introduce tu fecha de nacimiento.");

                    JLabel fecha = new JLabel (hr.fechaInterfaz());

                    JTextField nomUserIn = new JTextField("Nombre usuario");
                    JPasswordField passIn = new JPasswordField("");
                    JPasswordField pass2In = new JPasswordField("");
                    JTextField nomRealIn = new JTextField("Tu nombre");
                    JTextField apellidosIn = new JTextField("Tus apellidos");
                    JTextField mailIn = new JTextField("correo@servidor.loquesea");
                    JTextField fechaNacIn = new JTextField("dia/mes/año");



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
                    gbc.fill = GridBagConstraints.HORIZONTAL ;
                    principal.add (tituloVentana,gbc);


                    gbc.gridx = 1;
                    gbc.gridy = 1;
                    gbc.gridwidth = 1;
                    gbc.gridheight = 1;
                    gbc.weighty = 0.1; // La fila 0 debe estirarse, le ponemos un 1.0
                    gbc.fill = GridBagConstraints.HORIZONTAL ;
                    principal.add (tituloVentana,gbc);

                    gbc.gridx = 0;
                    gbc.gridy = 2;
                    gbc.gridwidth = 1;
                    gbc.gridheight = 1;
                    gbc.weighty = 0.1; // La fila 0 debe estirarse, le ponemos un 1.0
                    gbc.fill = GridBagConstraints.HORIZONTAL ;
                    principal.add (nomuser,gbc);

                    gbc.gridx = 1;
                    gbc.gridy = 2;
                    gbc.gridwidth = 1;
                    gbc.gridheight = 1;
                    gbc.weighty = 0.1; // La fila 0 debe estirarse, le ponemos un 1.0
                    gbc.fill = GridBagConstraints.HORIZONTAL ;
                    principal.add (nomUserIn,gbc);

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

                    gbc.gridx = 0;
                    gbc.gridy = 4;
                    gbc.gridwidth = 1;
                    gbc.gridheight = 1;
                    gbc.weighty = 0.1; // La fila 0 debe estirarse, le ponemos un 1.0
                    gbc.fill = GridBagConstraints.HORIZONTAL ;
                    principal.add (pass2,gbc);

                    gbc.gridx = 1;
                    gbc.gridy = 4;
                    gbc.gridwidth = 1;
                    gbc.gridheight = 1;
                    gbc.weighty = 0.1; // La fila 0 debe estirarse, le ponemos un 1.0
                    gbc.fill = GridBagConstraints.HORIZONTAL ;
                    principal.add (pass2In,gbc);


                    gbc.gridx = 0;
                    gbc.gridy = 5;
                    gbc.gridwidth = 1;
                    gbc.gridheight = 1;
                    gbc.weighty = 0.1; // La fila 0 debe estirarse, le ponemos un 1.0
                    gbc.fill = GridBagConstraints.HORIZONTAL ;
                    principal.add (nomReal,gbc);

                    gbc.gridx = 1;
                    gbc.gridy = 5;
                    gbc.gridwidth = 1;
                    gbc.gridheight = 1;
                    gbc.weighty = 0.1; // La fila 0 debe estirarse, le ponemos un 1.0
                    gbc.fill = GridBagConstraints.HORIZONTAL ;
                    principal.add (nomRealIn,gbc);

                     gbc.gridx = 0;
                    gbc.gridy = 6;
                    gbc.gridwidth = 1;
                    gbc.gridheight = 1;
                    gbc.weighty = 0.1; // La fila 0 debe estirarse, le ponemos un 1.0
                    gbc.fill = GridBagConstraints.HORIZONTAL ;
                    principal.add (apellidos,gbc);

                    gbc.gridx = 1;
                    gbc.gridy = 6;
                    gbc.gridwidth = 1;
                    gbc.gridheight = 1;
                    gbc.weighty = 0.1; // La fila 0 debe estirarse, le ponemos un 1.0
                    gbc.fill = GridBagConstraints.HORIZONTAL ;
                    principal.add (apellidosIn,gbc);

                      gbc.gridx = 0;
                    gbc.gridy = 7;
                    gbc.gridwidth = 1;
                    gbc.gridheight = 1;
                    gbc.weighty = 0.1; // La fila 0 debe estirarse, le ponemos un 1.0
                    gbc.fill = GridBagConstraints.HORIZONTAL ;
                    principal.add (mail,gbc);

                    gbc.gridx = 1;
                    gbc.gridy = 7;
                    gbc.gridwidth = 1;
                    gbc.gridheight = 1;
                    gbc.weighty = 0.1; // La fila 0 debe estirarse, le ponemos un 1.0
                    gbc.fill = GridBagConstraints.HORIZONTAL ;
                    principal.add (mailIn,gbc);

                      gbc.gridx = 0;
                    gbc.gridy = 8;
                    gbc.gridwidth = 1;
                    gbc.gridheight = 1;
                    gbc.weighty = 0.1; // La fila 0 debe estirarse, le ponemos un 1.0
                    gbc.fill = GridBagConstraints.HORIZONTAL ;
                    principal.add (fechaNac,gbc);

                    gbc.gridx = 1;
                    gbc.gridy = 8;
                    gbc.gridwidth = 1;
                    gbc.gridheight = 1;
                    gbc.weighty = 0.1; // La fila 0 debe estirarse, le ponemos un 1.0
                    gbc.fill = GridBagConstraints.HORIZONTAL ;
                    principal.add (fechaNacIn,gbc);


                    gbc.gridx = 1;
                    gbc.gridy = 9;
                    gbc.gridwidth = 1;
                    gbc.gridheight = 1;
                    gbc.weighty = 0.1; // La fila 0 debe estirarse, le ponemos un 1.0
                    gbc.fill = GridBagConstraints.HORIZONTAL ;
                    principal.add (enviar,gbc);

                    gbc.gridx = 0;
                    gbc.gridy = 9;
                    gbc.gridwidth = 1;
                    gbc.gridheight = 1;
                    gbc.weighty = 0.1; // La fila 0 debe estirarse, le ponemos un 1.0
                    gbc.fill = GridBagConstraints.HORIZONTAL ;
                    principal.add (irInicioSesion,gbc);




                    gbc.gridx = 1;
                    gbc.gridy = 10;
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

                    //Hace visible el panel
                    principal.setVisible(true);
                    principal.setSize(650, 350);
                    principal.setLocationRelativeTo(null); 
                    principal.setResizable(false);
                    //principal.pack();



                    try{
                        irInicioSesion.addActionListener(new ActionListener(){
                                public void actionPerformed(ActionEvent e){
                                    principal.setVisible(false);
                                    inicio.inicioSesion();

                                }

                        });
                        }catch(Exception e){}

                     try{
                        enviar.addActionListener(new ActionListener(){
                                public void actionPerformed(ActionEvent e){
                                   
                                    String nombre = nomRealIn.getText();
                                    String apellido = apellidosIn.getText();
                                    String correo =  mailIn.getText();
                                    String usuario =  nomUserIn.getText();
                                    String pass =  passIn.getText();
                                    String pass2 = pass2In.getText();
                                    
                                     if(passIn.getText().equals(pass2In.getText())){
                                         
                                         Registro reg = new Registro(nombre, apellido, correo, usuario, pass);
                                         
                                         reg.start();
                                         
                                         if(verificarReg==1){
                                             System.out.println("Usuario registrado correctamente.");
                                              
                                             
                                         }
                                         
                                         
                                         
                                         
                                     }
                                    
                                 
                                }

                        });
                        }catch(Exception e){}


    }
  
    
    
}
