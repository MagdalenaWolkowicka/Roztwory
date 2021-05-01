import java.util.InputMismatchException;
import java.util.Scanner;

public class SolutionDilution {

    private double currentConcentration;
    private double finalConcentration;
    private double expectedAmountOfSolution;
    private double amountOfSubstance;
    private double amountOfStockSolution;
    private double amountOfWater;

    private void getCurrentAndFinalConcentrationAndExpectedAmountOfSolution() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Jakim stężeniem procentowym roztworu dysponujesz??");
            currentConcentration = scanner.nextDouble();
            System.out.println("Jakie stężenie procentowe chcesz uzyskać?");
            finalConcentration = scanner.nextDouble();
            System.out.println("Ile gramów roztworu chcesz uzyskać?");
            expectedAmountOfSolution = scanner.nextDouble();
        } catch (InputMismatchException e) {
        }
    }

    private boolean checkIfTheDataIsCorrect() {
        if (currentConcentration > 0 && finalConcentration > 0 && currentConcentration <= 100
                && finalConcentration < 100 && expectedAmountOfSolution > 0
                && currentConcentration > finalConcentration) {
            return true;
        }
        System.out.println("Błędne dane, spróbuj jeszcze raz.\n");
        return false;
    }

    public void calculateAmountOfStockSolutionAndWater() {
        amountOfSubstance = expectedAmountOfSolution * finalConcentration / 100;
        amountOfStockSolution = amountOfSubstance * 100 / currentConcentration;
        amountOfWater = expectedAmountOfSolution - amountOfStockSolution;

        amountOfStockSolution = Math.round(amountOfStockSolution * 100);
        amountOfStockSolution = amountOfStockSolution / 100;

        amountOfWater = Math.round(amountOfWater * 100);
        amountOfWater = amountOfWater / 100;
    }

    public void showAmountOfStockSolutionAndWater() {
        getCurrentAndFinalConcentrationAndExpectedAmountOfSolution();
        if (checkIfTheDataIsCorrect()) {
            calculateAmountOfStockSolutionAndWater();
            System.out.println("Do uzyskania " + expectedAmountOfSolution + " g " + finalConcentration + " % roztworu należy użyć " + amountOfStockSolution + " g " + currentConcentration + " % roztworu " + " i rozcieńczyć " + amountOfWater + " g wody.\n");
        }
    }
}