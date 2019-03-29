import java.util.Vector;

public class SolvedState implements ICalculatorState {

    private StatefullCalculator calculator;

    public SolvedState(StatefullCalculator calc){
        this.calculator = calc;
    }

    @Override
    public void number(int num) {
        calculator.hist = new Vector<>();
        calculator.displayHist();
        switch (num){
            case 0:
                calculator.ui.setScreen("0");
                calculator.setState(calculator.getNullState());
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
                calculator.ui.setScreen(""+ num );
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
                calculator.hist.get(0).op=op+"";
                calculator.displayHist();
                calculator.setState(calculator.nullState);
                break;
            case '=':
                double result = 0;
                if(calculator.lastCmd.op.equals("+")){
                    result = calculator.hist.get(0).num + calculator.lastCmd.num;
                } else if(calculator.lastCmd.op.equals("-")){
                    result = calculator.hist.get(0).num - calculator.lastCmd.num;
                }


                calculator.ui.setScreen(result+"");
                calculator.ui.setHistory("");

                calculator.hist = new Vector<CalcCommand>();
                if (result < 0){
                    calculator.hist.add(new CalcCommand(result, "-"));
                } else{
                    calculator.hist.add(new CalcCommand(result, "+"));
                }
                break;
        }

    }
}
