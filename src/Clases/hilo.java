package Clases;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import static serverfd.guiServer.taTextoServidor;


public class hilo extends Thread{
    private Socket socket;
    private ServerSocket socketServer = null;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    public static Usuarios users = new Usuarios();

    public hilo() {
        
//         try {
//            oos = new ObjectOutputStream(socket.getOutputStream());
//            ois = new ObjectInputStream(socket.getInputStream());
//        } catch (IOException ex) {
//             System.err.println("Error en constructor de hilo en clase hilo");
//        }
    }
    
    public void desconnectar() {
        try {
            socket.close();
        } catch (IOException ex) {
            System.err.println("Error en metodo desconectar de la clase hilo");
        }
    }
    
    @Override
    public void run() {
        //Usuarios users = new Usuarios();
        users.getLista().add(new Usuario("admin", "admin", "admin"));
        ServerSocket socketServer = null;
        try{
            socketServer = new ServerSocket(9689);
            taTextoServidor.append("\nServer Arriba! Esperando clientes...");
            while(true){
                socket = socketServer.accept();
                taTextoServidor.append("\nSe conecto un cliente!");
                //oos = new ObjectOutputStream(socket.getOutputStream());
                //escribir("OOS");
                //ois = new ObjectInputStream(socket.getInputStream());
                //escribir("OIS");
                
                users.getLista().add(new Usuario(socket));
                users.getLista().get(users.getLista().size()-1).start();
            }
        }catch(Exception e){
            System.err.println("Error en run de clase hilo");
        }
        
        
        
//        String accion = "";
//        try {
//            accion = ois.readUTF();
//            
//            if(accion.equals("hola")){
//                
//                //System.out.println("El cliente con idSesion "+this.idSessio+" saluda");
//                oos.writeUTF("adios");
//            }
//        } catch (IOException ex) {
//            
//        }
//        desconnectar();
    }
    
    public void escribir(String texto){
        taTextoServidor.append("\n"+texto);
    }
}
