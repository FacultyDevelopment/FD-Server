/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverfd;

import Clases.Conector;
import static serverfd.guiServer.taTextoServidor;

/**
 *
 * @author wcarrasco
 */
public class ServerFD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        guiServer g = new guiServer();
        g.setLocationRelativeTo(null);
        g.setVisible(true);
        //Conector c = new Conector(taTextoServidor);
        //c.start();
    }
    
}
