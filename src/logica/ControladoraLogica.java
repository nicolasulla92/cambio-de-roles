package logica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import persistencia.ControladoraPersistencia;

public class ControladoraLogica {
    
    ControladoraPersistencia ctrlPersis = new ControladoraPersistencia();

    public void guardarUsuario(String nombre, String apellido, String usuar, String contrasenia, String rol) {
        
        Usuario usuario = new Usuario(0, nombre, apellido, usuar, contrasenia, rol);
        ctrlPersis.crearUsuario(usuario);
    }

    public void altaMasiva(String rutaArchivo) {
            Usuario user = new Usuario();
            try {
            // Abre el archivo para lectura utilizando BufferedReader
            BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo));

            // Lee línea por línea e imprime el contenido
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] atributos = linea.split(",");
                user.setNombre(atributos[0]);
                user.setApellido(atributos[1]);
                user.setUsuario(atributos[2]);
                user.setCotrasenia(atributos[3]);
                user.setRol(atributos[4]);
                ctrlPersis.crearUsuario(user);
            }

            // Cierra el BufferedReader después de leer el archivo
            lector.close();

        } catch (IOException e) {
            // Maneja las excepciones de entrada/salida (IOException) aquí
            e.printStackTrace();
        }
        //VisualizacionRED pantalla = new VisualizacionRED();
        //pantalla.setVisible(true);
        //pantalla.setLocationRelativeTo(null);
    
    }

    public ArrayList<Usuario> traerUsuarios() {
        return ctrlPersis.traerUsuarios();
    }

    @SuppressWarnings("empty-statement")
    public String[] validarUsuario(String usuario, String contrasenia) {
        String datos[] = new String[4];
         
        ArrayList<Usuario> listaUsuario = ctrlPersis.traerUsuarios();
        for(Usuario user : listaUsuario){
            System.out.println(user.getUsuario());
            if(user.getUsuario().equals(usuario)){
                if(user.getCotrasenia().equals(contrasenia)){
                   datos[0] = user.getRol();
                   datos[1] = "";
                   datos[2] = "";
                   datos[3] = "";
                   break;
                }else{
                    datos[0] = "";
                    datos[1] = "Contraseña incorrecta";
                    datos[2] = "Error";
                    datos[3] = "Error";
                    break;
                }
            }else{
                datos[0] = "";
                datos[1] = "Usuario no encontrado";
                datos[2] = "Error";
                datos[3] = "Error"; 
            }
        }
        
        return datos;
      }    
}
