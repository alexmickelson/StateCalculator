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
                calculator.ui.setScreen(calculator.ui.getScreen()+ num );
                break;
            case 10:
                String screen = calculator.ui.getScreen();
                if (screen.contains(".")){
                    break;
                }

                calculator.ui.setScreen(calculator.ui.getScreen() + ".");
                calculator.setState(calculator.getAppendState());
                break;

        }
    }

    @Override
    public void operator(char op) {
        switch (op){
            case '+':
            case '-':
                //history first
                calculator.hist.add(new CalcCommand(Double.parseDouble(calculator.ui.getScreen()), op+""));
                calculator.displayHist();
                calculator.setState(calculator.nullState);
                break;
            case '=':
                calculator.hist.add(new CalcCommand(Double.parseDouble(calculator.ui.getScreen()), op+""));
                calculator.calcTotal();
                calculator.setState(calculator.getSolvedState());
                break;
        }
    }
}
