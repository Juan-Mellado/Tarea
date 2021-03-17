package testClases;

import page.Index;

public class Iniciar {

    Index index;
    public void inicio(String usuario, String key){
        index = new Index();
        index.inicio(usuario,key);

    }

}
