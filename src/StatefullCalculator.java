import java.util.Vector;

public class StatefullCalculator{
    protected ICalculatorPanel ui;
    public ICalculatorState nullState;
    public ICalculatorState appendState;
    public ICalculatorState solvedState;

    public ICalculatorState state;

    public Vector<CalcCommand> hist;

    public StatefullCalculator(ICalculatorPanel UI){
        UI.setCalcEngine(this);
        this.ui = UI;
        hist = new Vector<CalcCommand>();
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
        ui.setScreen("");
        state = nullState;
    }

    public void displayHist(){
        String h="";
        for( var cmd : hist){
            h += cmd.num +" "+cmd.op+" ";
        }
        ui.setHistory(h);
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
