package ch.bnc.coding;

import ch.bnc.coding.guice.GuiceHelper;
import ch.bnc.coding.menu.Menu;

public class BNLS {
            
    public static void main(String[] args) {
    	Menu menu = GuiceHelper.getInstanceOf(Menu.class);
        
        while(true) {
        	menu.run();
        }
    }

}
