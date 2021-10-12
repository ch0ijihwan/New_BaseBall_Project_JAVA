package model;

import java.util.Arrays;

public class DtoInputNumbers {
    private static final int NUMBER_LENGTH = 3;
    private int[] inputNumbers;
    public DtoInputNumbers(String [] tokens){
        this.inputNumbers = Arrays.stream(tokens).mapToInt(Integer::parseInt).toArray();
        validateNumbers(inputNumbers);
    }
    public int[] getInputNumbers(){
        return inputNumbers;
    }


    private void validateNumbers(int[] inputValue) {
        if (inputValue.length != NUMBER_LENGTH) {
            throw new IllegalArgumentException("입력값이 3자리가 아닙니다.");
        }
        if (Arrays.stream(inputValue).distinct().count() != inputValue.length) {
            throw new IllegalArgumentException("중복되는 수가 있습니다.");
        }
    }
}


