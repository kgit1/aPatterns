package x.someGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class SomeonesGame {
/* ___________________________________________________
\/ | */
private int limitDigit; // Загадываемое чисто должно иметь вот столько цыфр
private ArrayList<Integer> valueGame; // Значения, которые нужно отгадать игроку
private ArrayList<Integer> valuePlayer; // Значения, которые ввел игрок
private int limitMoves; // Число допустимых ходов
private Scanner scanner; // Сканер

public boolean modePvP = false;

SomeonesGame(int limit, int moves) {    // Экземпляр для игры против искуственного интеллекта
    this.limitMoves = moves;
    this.limitDigit = limit;
    this.scanner    = new Scanner(System.in);

    valueGame       = new ArrayList<>();
    valuePlayer     = new ArrayList<>();

    for (int i = 0; i < limitDigit; i++)
        valueGame.add((int)(Math.random() * 10));
}

public void setValuePlayer(int count) throws IncorrectValueException{

    valuePlayer = new ArrayList<>();

    if (((count / Math.pow(10, limitDigit - 1)) < 1) ||
        ((count / Math.pow(10, limitDigit - 1)) > 10))
        throw new IncorrectValueException();

    for (int i = limitDigit - 1; i >= 0; i--){
        valuePlayer.add(count % 10);
        count /= 10;
    }
    Collections.reverse(valuePlayer);
}
public void setValueGame(int count) throws IncorrectValueException{

    valueGame = new ArrayList<>();

    if (((count / Math.pow(10, limitDigit - 1)) < 1) ||
        ((count / Math.pow(10, limitDigit - 1)) > 10))
        throw new IncorrectValueException();

    for (int i = limitDigit - 1; i >= 0; i--){
        valueGame.add(count % 10);
        count /= 10;
    }
    Collections.reverse(valueGame);
}
public int[] countBullsAndCows(){
    int[] count = new int[2];
    for (int indexI = 0; indexI < valuePlayer.size(); indexI++){
        for (int indexJ = 0; indexJ < valueGame.size(); indexJ++){
            boolean indexEqualIndex = indexI == indexJ;
            boolean valueEqualValue = valuePlayer.get(indexI).intValue() == valueGame.get(indexJ).intValue();
            if(indexEqualIndex){
                count[0] = valueEqualValue ? count[0] + 1 : count[0];
            }else
                count[1] = valueEqualValue ? count[1] + 1 : count[1];
        }
    }
    return count;
}
public void setLimitDigit(int limit){
    this.limitDigit = limit;
}
public void setlimitMoves(int limit){
    this.limitMoves = limit;
}
@Override
public String toString(){
    return "This class implements logic for game \"Bulls and Cow\" ";
}
public ArrayList<Integer> getValueGame(){
    return valueGame;
}
public ArrayList<Integer> getValuePlayer(){
    return valuePlayer;
}
public class IncorrectValueException extends Throwable{
    IncorrectValueException() {
        super("The value is not correct, try again.");
    }
}
public int getLimitDigit(){
    return limitDigit;
}
public int getLimitMoves(){
    return limitMoves;
}
}
