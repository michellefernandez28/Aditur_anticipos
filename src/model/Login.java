/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Login {

    // user data and password
    private final String usuarioCorrecto = "Admin01";
    private String contraseñaCorrecta = "Admin@1234";

    public boolean validarLogin(String usuario, String contraseña){

        // remove spaces at the beginning and end
        usuario = usuario.trim();
        contraseña = contraseña.trim();

        // validate empty fields
        if(usuario.isEmpty() || contraseña.isEmpty()){
            return false;
        }

        // Compare the data with the username and password
        return usuario.equals(usuarioCorrecto) && contraseña.equals(contraseñaCorrecta);

    }

}