/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoFinalJava;

/**
 *
 * @author solera
 */
public class Usuarios {
    
    private String nombre;
    private String apellido;
    private String usuario;
    private String password;
    private String email;
    private int nDescargas;
    private int nSubidas;
    
      public Usuarios( ){
       
    }
    public Usuarios(String nombre, String apellido, String password, String usuario, String email, int bajadas, int subidas ){
        
        this.nombre=nombre;
        this.apellido=apellido;
        this.password=password;
        this.usuario=usuario;
        this.password=password;
        this.email=email;
        this.nDescargas=bajadas;
        this.nSubidas=subidas;
    }

    
    //gets sets********************************************************************
    
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellido;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellido = apellidos;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getnDescargas() {
        return nDescargas;
    }

    public void setnDescargas(int nDescargas) {
        this.nDescargas = nDescargas;
    }

    public int getnSubidas() {
        return nSubidas;
    }

    public void setnSubidas(int nSubidas) {
        this.nSubidas = nSubidas;
    }
    
    
    
}
