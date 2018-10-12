package be.pxl.ja.week4.oefening1;

public class NumberSelector {
    private NumberMachine numberMachine;

    public NumberSelector(NumberMachine numberMachine) {
        this.numberMachine = numberMachine;
    }

    public String showEvenNumbers() {
        NumberFilter evenNumbersFilter = n -> (n % 2 == 0);
        return numberMachine.processNumbers(evenNumbersFilter);
    }

    public String showNumbersAbove(int compareValue) {
        NumberFilter aboveNumbersFilter = n -> (n > compareValue);
        return numberMachine.processNumbers(aboveNumbersFilter);
    }

    public String printHexNumbers() {
        return numberMachine.convertNumbers();
    }
}
