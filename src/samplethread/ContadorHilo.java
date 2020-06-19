/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samplethread;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *
 * @author david, jahaziel, Gabriel
 */
public class ContadorHilo extends Thread {

    private JTextField txtV;
    private JTextField txtV2;
    private boolean isRun=false;
    
    public ContadorHilo(JTextField txtV,JTextField txtV2) {
        this.txtV=txtV;
        this.txtV2=txtV2;
    }
    
    
    public synchronized void detener(){
        isRun=false;
    }
    
    @Override
    public void run() {
        isRun = true;
        long min = 0;
        while(isRun){            
            try {                
                long s = Long.parseLong(txtV2.getText());
                s++;              
                if (s == 60) {                   
                    s = 0;
                    min++;
                    txtV.setText(String.valueOf(min));
                }
                             
                txtV2.setText(String.valueOf(s));
                Thread.sleep(1000);        
            } catch (InterruptedException ex) {
                Logger.getLogger(ContadorHilo.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
        
        
    }


    
    
}
