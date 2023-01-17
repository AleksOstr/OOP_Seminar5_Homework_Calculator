import controller.ComplexController;
import controller.FractionController;
import model.ComplexCalc;
import model.FractionCalc;
import view.CalcView;

public class Main {
    public static void main(String[] args) {
        FractionCalc fractionCalc = new FractionCalc();
        ComplexCalc complexCalc = new ComplexCalc();
        FractionController fracController = new FractionController(fractionCalc);
        ComplexController compController = new ComplexController(complexCalc);
        CalcView view = new CalcView(compController, fracController);
        view.run();
    }
}
