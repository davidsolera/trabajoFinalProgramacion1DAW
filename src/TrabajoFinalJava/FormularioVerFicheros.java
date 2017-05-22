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

/**
 *
 * @author solera
 */
public class FormularioVerFicheros {
    
    	public void verFicheros(){	
            
		//************************INICIO****INTERFAZ**************************************************************************
            
		JFrame principal = new JFrame ("GESTOR DESCARGAS");
                //Colores
 
              
                Color nuevoColor = new Color(167, 220, 231);
                
                principal.getContentPane().setBackground(nuevoColor);


		JLabel tituloPrincipal = new JLabel ("GESTOR DESCARGAS");
                JLabel tituloVentana = new JLabel ("MOSTRAR FICHERO");
		//Recojo la fuente que se esta utilizando actualmente.
		Font auxFont=tituloPrincipal.getFont();

		//Aplico la fuente actual, y al final le doy el tamaño del texto...
		tituloPrincipal.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 30));
		tituloVentana.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 30));
                //tituloVentana.setAlignmentY(0);
               
           
                
                
           
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
		
                
                
		//Hace visible el panel
		principal.setVisible(true);
		principal.setSize(650, 350);
		principal.setLocationRelativeTo(null); 
		principal.setResizable(false);
		//principal.pack();
		
                        
           /*
           try{
			salir.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
                                    
					System.exit(0);
					
				}

			});
			}catch(Exception e){}
            */
		
    }
    
    
    
    
    
}
