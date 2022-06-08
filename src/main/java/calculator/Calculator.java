package calculator;

public class Calculator {

    private double total;

    public Calculator() {

        this.total = 0;
    }

    public double getTotal() {

        return this.total;
    }

    public void add(double numberToAdd) {

        this.total += numberToAdd;
    }

    public void subtract(double numberToSubtract) {

        this.total -= numberToSubtract;
    }

    public void multiplyBy(double numberToMultiplyBy) {

        this.total *= numberToMultiplyBy;
    }

    public void divideBy(double numberToDivideBy) throws DivideByZeroException {

        if(numberToDivideBy == 0) {
            throw new DivideByZeroException("Cannot divide by 0!");
        }

        this.total /= numberToDivideBy;
    }
}
