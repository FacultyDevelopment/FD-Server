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
        
        ServerSocket socketServer = null;
        try{
            socketServer = new ServerSocket(9689);
            taTextoServidor.append("\nServer Arriba! Esperando clientes...");
            while(true){
                socket = socketServer.accept();
                taTextoServidor.append("\nSe conecto un cliente!");
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
}
