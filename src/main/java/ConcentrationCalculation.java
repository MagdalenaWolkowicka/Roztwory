import java.util.InputMismatchException;
import java.util.Scanner;

public class ConcentrationCalculation {

    private double amountOfSubstance;
    private double amountOfSolvent;
    private double solutionConcentration;
    private double amountOfSolution;

    private void getAmountOfSolventAndSubstance() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Podaj ilość substancji w gramach: ");
            amountOfSubstance = scanner.nextDouble();
            System.out.println("Podaj ilość rozpuszczalnika w gramach: ");
            amountOfSolvent = scanner.nextDouble();
        } catch (InputMismatchException e) {
        }
    }

    private boolean checkIfTheDataIsCorrect() {
        if (amountOfSolvent > 0 && amountOfSubstance > 0 && amountOfSolvent > amountOfSubstance) {
            return true;
        }
        System.out.println("Błędne dane, spróbuj jeszcze raz\n");
        return false;
    }


    public double calculateConcentration(double amountOfSolvent, double amountOfSubstance) {
        amountOfSolution = amountOfSolvent + amountOfSubstance;
        solutionConcentration = (amountOfSubstance * 100) / amountOfSolution;

        solutionConcentration = Math.round(solutionConcentration * 100);
        solutionConcentration = solutionConcentration / 100;

        amountOfSolution = Math.round(amountOfSolution * 100);
        amountOfSolution = amountOfSolution / 100;

        return solutionConcentration;
    }

    public void showConcentration() {
        getAmountOfSolventAndSubstance();
        if (checkIfTheDataIsCorrect()) {
            solutionConcentration = calculateConcentration(amountOfSolvent, amountOfSubstance);
            System.out.println("Powstanie " + amountOfSolution + " g roztworu o stężeniu " + solutionConcentration + " %.\n");
        }
    }
}

