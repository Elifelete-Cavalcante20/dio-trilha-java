package one.dio.gof.strategy;

public class comportamentoAgressivo implements comportamento{

    @Override
    public void mover() {
        System.out.println("Movendo-se agressivamente...");
    }

}
