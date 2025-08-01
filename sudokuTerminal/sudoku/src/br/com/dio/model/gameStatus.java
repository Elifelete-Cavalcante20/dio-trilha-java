package br.com.dio.model;

public enum gameStatus {

    NON_STARTED("nao iniciado"),
    INCOMPLETE("Incompleto"),
    FINISHED("finalizado");

    private String label;
    
    gameStatus(final String label){
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
