public interface ICalculatorPanel {
    boolean setCalcEngine(StatefullCalculator calculator);
    boolean setHistory(String history);
    String getScreen();
    boolean setScreen(String screen);
}
