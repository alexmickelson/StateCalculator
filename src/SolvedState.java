public class SolvedState implements ICalculatorState {

    private StatefullCalculator calculator;

    public SolvedState(StatefullCalculator calc){
        this.calculator = calc;
    }

    @Override
    public void number(int num) {

    }

    @Override
    public void operator(char op) {

    }
}
