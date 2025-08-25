package one.dio.gof.facede;

import one.dio.gof.subsistema1Crm.crmService;
import one.dio.gof.subsistema2Cep.cepApi;

public class facede {
    public void migrarCliente(String nome, String cep) {
        String cidade = cepApi.getInstancia().recuperarCidade(cep);
        String estado = cepApi.getInstancia().recuperarEstado(cep);

        crmService.gravarCliente(nome, cep, cidade, estado);
    }
}
