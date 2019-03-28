public class AppendState implements ICalculatorState {

    private StatefullCalculator calculator;

    public AppendState(StatefullCalculator calc){
        this.calculator = calc;
    }

    @Override
    public void number(int num) {
        switch (num){
            case 0:
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
                break;
            case 10:
                double screen = calculator.ui.getScreen();
                if (screen%1==0){ //there is a . already
                    return;
                }

                calculator.ui.setScreen(calculator.ui.getScreen() + ".");
                calculator.setState(calculator.getAppendState());
                break;

        }
    }

    @Override
    public void operator(char op) {

    }
}
