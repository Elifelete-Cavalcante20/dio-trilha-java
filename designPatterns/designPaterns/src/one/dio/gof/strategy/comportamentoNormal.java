package one.dio.gof.strategy;

public class comportamentoNormal implements comportamento{

    @Override
    public void mover() {
        System.out.println("Movendo-se normalmente...");
    }

}
