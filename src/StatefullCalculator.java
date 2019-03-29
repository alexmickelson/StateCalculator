import java.util.Vector;

public class StatefullCalculator{
    protected ICalculatorPanel ui;
    public ICalculatorState nullState;
    public ICalculatorState appendState;
    public ICalculatorState solvedState;
    public CalcCommand lastCmd;

    public ICalculatorState state;

    public Vector<CalcCommand> hist;

    public StatefullCalculator(ICalculatorPanel UI){
        UI.setCalcEngine(this);
        this.ui = UI;
        hist = new Vector<CalcCommand>();

        nullState = new NullState(this);
        appendState = new AppendState(this);
        solvedState = new SolvedState(this);

        state = nullState;
    }

    public void number(int num) {
        state.number(num);
    }

    public void operator(char op) {
        state.operator(op);
    }

    public void clear(){
        ui.setHistory("");
        ui.setScreen("0");
        hist = new Vector<CalcCommand>();
        state = nullState;
    }

    public void displayHist(){
        String h="";
        for( var cmd : hist){
            h += cmd;
        }
        ui.setHistory("");
        ui.setScreen("0");
        ui.setHistory(h);
    }

    public void calcTotal(){
        double total = hist.get(0).num;
        String op = hist.get(0).op;


        for(int i = 1; i<hist.size(); i++)
        {
            if(op.equals("+")){
                total += hist.get(i).num;
            } else if (op.equals("-")){
                total -= hist.get(i).num;
            }
            op = hist.get(i).op;
        }
        ui.setScreen(total+"");
        ui.setHistory("");
        if(hist.size()>1){
            lastCmd = new CalcCommand( hist.get(hist.size()-1).num,  hist.get(hist.size()-2).op);
        } else {
            lastCmd = new CalcCommand(0, "");
        }

        hist = new Vector<CalcCommand>();
        if (total < 0){
            hist.add(new CalcCommand(total, "-"));
        } else{
            hist.add(new CalcCommand(total, "+"));
        }
    }

    public void setState(ICalculatorState newState){
        state=newState;
    }

    public ICalculatorState getNullState(){
        return nullState;
    }

    public ICalculatorState getAppendState(){
        return appendState;
    }

    public ICalculatorState getSolvedState(){
        return solvedState;
    }

}
