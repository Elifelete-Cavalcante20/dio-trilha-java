package one.dio.gof.strategy;

public class comportamentoDefensivo implements comportamento{

    @Override
    public void mover() {
        System.out.println("Movendo-se defensivamente...");
    }

}
