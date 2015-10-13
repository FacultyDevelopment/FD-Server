package Clases;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import static serverfd.guiServer.taTextoServidor;
import static Clases.hilo.users;

public class Usuario extends Thread implements Serializable {

    private String correo;
    private String password;
    private String nombre;
    private Socket socket;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private String preguntaCliente;
    private String respuestaServer;

    public Usuario() {
    }

    public Usuario(Socket socket) {
        this.socket = socket;
    }

    public Usuario(String correo, String password, String nombre) {
        this.correo = correo;
        this.password = password;
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "Correo: " + correo + "Password: " + password + "\n";
    }

    @Override
    public void run() {

        try {
            oos = new ObjectOutputStream(socket.getOutputStream());
            //escribir("OOS");
            ois = new ObjectInputStream(socket.getInputStream());
            //escribir("OIS");

//            oos.writeUTF("Bienvenido al servidor de faculty");
//            oos.flush();
//            escribir("bienvenida enviada");
//            escribir(ois.readUTF());
//            escribir(ois.readUTF());
            escribir("Esperando login...");
            boolean loguin = false;
            escribir("Usuarios: ");
            for (int i = 0; i < users.getLista().size(); i++) {
                System.out.println(users.getLista().get(i).toString());
            }
            while (loguin == false) {
                String usuario, pass;
                escribir("...");
                usuario = ois.readUTF();
                escribir("Usuario para loguin: "+usuario);
                
                pass = ois.readUTF();
                escribir("pass para loguin: "+pass);
                
                for (int i = 0; i < users.getLista().size(); i++) {
                    
                    if (users.getLista().get(i).getCorreo().contentEquals(usuario)) {
                        if (users.getLista().get(i).getPassword().contentEquals(pass)) {
                            escribir("entra");
                            oos.writeUTF("Bienvenido " + users.getLista().get(i).getNombre());
                            oos.flush();
                            loguin = true;
                        } else {
                            escribir("No entra");
                            oos.writeUTF("Usuario o contraseña incorrectas");
                            oos.flush();
                            break;
                        }
                    } else {
                        escribir("No entra");
                        oos.writeUTF("Usuario o contraseña incorrectas");
                        oos.flush();
                        break;
                    }
                    System.out.println("for");
                }
                System.out.println("salio del for");
            }
            System.out.println("salio");
            while (loguin) {
                
            }
        } catch (Exception e) {

        }

    }

    public void escribir(String texto) {
        taTextoServidor.append("\n" + texto);
    }

}
