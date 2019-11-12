/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author moham
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        HugeInteger h1 = new HugeInteger("192968");
        HugeInteger h2 = new HugeInteger("11");
        
        
        System.out.println(h1.divide(h2));
        System.out.println(""+(192068/11));
        System.out.println(h2.toString());
    }
    
}
