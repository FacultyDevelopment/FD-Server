/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverfd;

import Clases.Conector;

/**
 *
 * @author wcarrasco
 */
public class ServerFD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conector c = new Conector();
        c.start();
    }
    
}
