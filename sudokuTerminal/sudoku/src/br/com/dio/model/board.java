package br.com.dio.model;

import java.util.Collection;
import java.util.List;

import static br.com.dio.model.gameStatus.INCOMPLETE;
import static br.com.dio.model.gameStatus.FINISHED;
import static br.com.dio.model.gameStatus.NON_STARTED;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;


public class board {

    private final List<List<space>> spaces;

    public board(final List<List<space>> spaces){
        this.spaces = spaces;
    }

    public List<List<space>> getSpaces() {
        return spaces;
    }
    
    //verificar o status do game se
    public gameStatus getStatus(){
        if (spaces.stream().flatMap(Collection::stream)
        .noneMatch(s -> !s.isFixed() && nonNull(s.getActual()))) {
            return NON_STARTED;
        }

        return spaces.stream().flatMap(Collection::stream)
        .anyMatch(s -> isNull(s.getActual())) ? INCOMPLETE : FINISHED;
    }

    public boolean hasError(){
        if (getStatus()== NON_STARTED){
            return false;
        }

        return spaces.stream()
    .flatMap(Collection::stream)
    .anyMatch(s -> nonNull(s.getActual()) && !s.getActual().equals(s.getExpected()));
    }


    public boolean changeValue(final int col, final int row, final int value){
        var space = spaces.get(col).get(row);
        if (space.isFixed()){
            return false;
        }

        space.setActual(value);
        return true;
    }

    public  boolean clearValue(final int col, final int row){
        var space = spaces.get(col).get(row);
        if (space.isFixed()){
            return false;
        }

        space.clearSpace();
        return true;
    }

    public void reset(){
        spaces.forEach(c -> c.forEach(space::clearSpace));
    }

    public boolean gameIsFished(){
        return !hasError() && getStatus().equals(FINISHED);
    }
}
