public class NullState implements ICalculatorState {


    private StatefullCalculator calculator;

    public NullState(StatefullCalculator calc){
        this.calculator = calc;
    }

    @Override
    public void number(int num) {
        switch (num){
            case 0:
                calculator.ui.setScreen("0");
                break;
            case 10:
                calculator.ui.setScreen(calculator.ui.getScreen() + ".");
                calculator.setState(calculator.getAppendState());
                break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                calculator.ui.setScreen(calculator.ui.getScreen() +""+ num );
                calculator.setState(calculator.getAppendState());
                break;

        }

    }

    @Override
    public void operator(char op) {
    }
}
