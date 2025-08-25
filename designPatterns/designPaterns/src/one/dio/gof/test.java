package one.dio.gof;

import one.dio.gof.facede.facede;
import one.dio.gof.singleton.singletonEager;
import one.dio.gof.singleton.singletonHolder;
import one.dio.gof.singleton.singletonLazy;
import one.dio.gof.strategy.comportamento;
import one.dio.gof.strategy.comportamentoAgressivo;
import one.dio.gof.strategy.comportamentoDefensivo;
import one.dio.gof.strategy.comportamentoNormal;
import one.dio.gof.strategy.robo;

public class test {
    public static void main(String[] args) {

        //singleton 

        singletonLazy lazy = singletonLazy.getInstancia();
        System.out.println(lazy);
        lazy = singletonLazy.getInstancia();
        System.out.println(lazy);

        singletonEager eager = singletonEager.getInstancia();
        System.out.println(eager);
        eager = singletonEager.getInstancia();
        System.out.println(eager);

        singletonHolder holder = singletonHolder.getInstancia();
        System.out.println(holder);
        holder = singletonHolder.getInstancia();
        System.out.println(holder);

        //strategy

        comportamento defensivo = new comportamentoDefensivo();
        comportamento agressivo = new comportamentoAgressivo();
        comportamento normal = new comportamentoNormal();

        robo robo = new robo();
        robo.setComportamento(defensivo);
        robo.mover();

        robo.setComportamento(agressivo);
        robo.mover();

        robo.setComportamento(normal);
        robo.mover();

        //Facede

        facede facede = new facede();
        facede.migrarCliente("João", "12345-678");

    }
}
