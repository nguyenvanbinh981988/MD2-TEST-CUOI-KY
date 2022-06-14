package Running;

import Controler.Controler;

public class Run {
    public static void main(String[] args) {
        Controler controler = new Controler();
        while (true){
            controler.productManageMenu();
        }
    }
}
