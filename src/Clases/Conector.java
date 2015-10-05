package Clases;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Conector extends Thread{
    private Socket s;
    private ServerSocket ss;
    private InputStreamReader entradaSocket;
    private DataOutputStream salida;
    private ObjectInputStream entradaa;
    private BufferedReader entrada;
    final int puerto = 9689;
    
    public Conector(){
        try{
            ss = new ServerSocket(puerto);
            //guiServer.taTextoServidor.setText(guiServer.taTextoServidor.getText() + "/nEsperando Cliente...");
            System.out.println("Esperando...");
            s = ss.accept();
            System.out.println("Conectado");
            
            //guiServer.taTextoServidor.setText(guiServer.taTextoServidor.getText() + "/nCliente Conectado!");
            entradaa = new ObjectInputStream(s.getInputStream());
            System.out.println("entradaa");
            salida = new DataOutputStream(s.getOutputStream());
            System.out.println("salida");
            System.out.println(entradaa.readUTF());
            this.salida.writeUTF("----CONECTADO----");
            
        }catch(Exception e){
            System.err.println("Error en la clase Conector!");
            e.printStackTrace();
        }
    }
}
