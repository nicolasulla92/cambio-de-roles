
package persistencia;

import java.util.ArrayList;
import java.util.List;
import logica.Usuario;

public class ControladoraPersistencia {
    
    UsuarioJpaController jpaUsuario = new UsuarioJpaController();

    public void crearUsuario(Usuario usuario) {
        
        jpaUsuario.create(usuario);
    }

    public ArrayList<Usuario> traerUsuarios() {
        List<Usuario> lista = jpaUsuario.findUsuarioEntities();
        ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>(lista);
        return listaUsuarios;
    }


    
}
