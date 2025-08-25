package one.dio.gof.singleton;

public class singletonHolder {

    private static class instanceHolder{
     public static singletonHolder instancia = new singletonHolder(); 
    }
    
    private singletonHolder(){
        super();
    }

    public static singletonHolder getInstancia(){
        return instanceHolder.instancia;
    }
}
