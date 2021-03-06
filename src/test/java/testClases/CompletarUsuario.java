package testClases;
import Utils.ReadProperties;
import page.CrearUsuario;
import page.Index;
public class CompletarUsuario {
    //Crea un nuevo usuario con las propiedades entregadas
    public void datosUsuarioNuevo(){
        Index inicio = new Index();
        inicio.cargaIndex();
        inicio.btncreaUsuario();
        CrearUsuario creaUsuario = new CrearUsuario();
        creaUsuario.cargaPagina();
        String nombre= ReadProperties.readFromConfig("propiedades.properties").getProperty("nuevoUsuario");
        String contrasena= ReadProperties.readFromConfig("propiedades.properties").getProperty("nuevoContrasena");
        String nombreCompleto= ReadProperties.readFromConfig("propiedades.properties").getProperty("nuevoNombreCompleto");
        String email= ReadProperties.readFromConfig("propiedades.properties").getProperty("nuevoEmail");
        creaUsuario.crearNuevoUsuario(nombre,contrasena,nombreCompleto,email);
        creaUsuario.botonRegistrarse();
        creaUsuario.mensajeRegistro();
    }
}
