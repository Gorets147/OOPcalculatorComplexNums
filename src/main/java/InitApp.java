
import controller.CalculatorController;
import model.CalculatorModel;
import model.ComplexNumber;
import model.operations.Addition;
import model.operations.Division;
import model.operations.Multiplication;
import model.operations.Subtraction;
import view.CalculatorView;
import view.ConsoleViewFactory;

import java.io.FileInputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class InitApp {

    private final static Logger LOGGER =  Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    static {
        try(FileInputStream in = new FileInputStream("D:\\Fortune Dungeon\\OOPCalcComplexNumber\\src\\main\\resources\\ logging.properties")){
            LogManager.getLogManager().readConfiguration(in);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    void init() {
        LOGGER.info("START APP ");
        CalculatorModel model = new CalculatorModel();
        LOGGER.info("init model ");
        CalculatorController controller = new CalculatorController();
        LOGGER.info("init controller ");
        CalculatorView calculatorView = new CalculatorView(new ConsoleViewFactory());
        LOGGER.info("Init view");
        controller.registerOperation("+", new Addition());
        controller.registerOperation("-", new Subtraction());
        controller.registerOperation("*", new Multiplication());
        controller.registerOperation("/", new Division());

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Введите символ соответствующего выражения из списка : \n").trimToSize();
        stringBuilder.append("+ Сложение.\n - Вычитание.\n * Умножение.\n / Деление.\n Введите симВол : ");
        System.out.println(stringBuilder);
        String operation = calculatorView.getInput();
        LOGGER.info("User enter parameter is " + operation + " in operation");
        System.out.println("Введите реальное число А : \n");
        double realComplexA = Double.parseDouble(calculatorView.getInput().trim());
        System.out.println("Введите мнимое число А : \n");
        double imaginaryComplexA = Double.parseDouble(calculatorView.getInput().trim());
        ComplexNumber a = new ComplexNumber(realComplexA,imaginaryComplexA);
        System.out.println("Введите реальное число B : \n");
        double realComplexB = Double.parseDouble(calculatorView.getInput().trim());
        System.out.println("Введите мнимое число B : \n");
        double imaginaryComplexB = Double.parseDouble(calculatorView.getInput().trim());
        ComplexNumber b = new ComplexNumber(realComplexB,imaginaryComplexB);
        ComplexNumber result = controller.performOperation(operation, a, b);
        model.setResult(result);
        calculatorView.displayResult(model.getResult());
    }
}