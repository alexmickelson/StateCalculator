public interface ICalculatorPanel {
    boolean setCalcEngine(StatefullCalculator calculator);
    boolean setHistory(String history);
    double getScreen();
    boolean setScreen(String screen);
}
