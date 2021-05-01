import java.util.InputMismatchException;
import java.util.Scanner;

public class MixingSolutions {

    private double amountOfSolution1;
    private double concentrationOfTheSolution1;
    private double amountOfSolution2;
    private double concentrationOfTheSolution2;
    private double finalSolutionConcentration;
    private double amountOfSubstanceInSolution1;
    private double amountOfSubstanceInSolution2;
    private double totalAmountOfSubstance;
    private double totalAmountOfSolution;
    private double amountOfSubstanceInSolution;

    private void getConcentrationsAndAmountsOfSolutions() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Podaj ilość roztworu 1 w gramach");
            amountOfSolution1 = scanner.nextDouble();
            System.out.println("Podaj stężenie procentowe roztworu 1");
            concentrationOfTheSolution1 = scanner.nextDouble();
            System.out.println("Podaj ilość roztworu 2 w gramach");
            amountOfSolution2 = scanner.nextDouble();
            System.out.println("Podaj stężenie procentowe roztworu 2");
            concentrationOfTheSolution2 = scanner.nextDouble();
        } catch (InputMismatchException e) {
        }
    }

    private boolean checkIfTheDataIsCorrect() {
        if (amountOfSolution1 > 0 && amountOfSolution2 > 0 && concentrationOfTheSolution1 > 0
                && concentrationOfTheSolution2 > 0 && concentrationOfTheSolution1 <= 100
                && concentrationOfTheSolution2 <= 100) {
            return true;
        }
        System.out.println("Błędne dane, spróbuj jeszcze raz.\n");
        return false;
    }

    private double calculateAmountOfSubstanceInSolution(double amountOfSolution, double concentrationOfTheSolution) {
        amountOfSubstanceInSolution = amountOfSolution * concentrationOfTheSolution / 100;
        return amountOfSubstanceInSolution;
    }

    private double calculateFinalConcentrationAndAmountOfSolution() {
        amountOfSubstanceInSolution1 = calculateAmountOfSubstanceInSolution(amountOfSolution1, concentrationOfTheSolution1);
        amountOfSubstanceInSolution2 = calculateAmountOfSubstanceInSolution(amountOfSolution2, concentrationOfTheSolution2);

        totalAmountOfSubstance = amountOfSubstanceInSolution1 + amountOfSubstanceInSolution2;
        totalAmountOfSolution = amountOfSolution1 + amountOfSolution2;

        finalSolutionConcentration = totalAmountOfSubstance * 100 / totalAmountOfSolution;
        finalSolutionConcentration = Math.round(finalSolutionConcentration * 100);
        finalSolutionConcentration = finalSolutionConcentration / 100;

        return finalSolutionConcentration;
    }

    public void showFinalConcentrationAndAmountOfSolution() {
        getConcentrationsAndAmountsOfSolutions();
        if (checkIfTheDataIsCorrect()) {
            finalSolutionConcentration = calculateFinalConcentrationAndAmountOfSolution();
            System.out.println("Powstanie " + totalAmountOfSolution + " g roztworu o stężeniu " + finalSolutionConcentration + " %\n");
        }
    }
}
