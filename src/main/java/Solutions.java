import java.util.Scanner;

public class Solutions {

    private boolean exit = false;

    ConcentrationCalculation concentrationCalculation = new ConcentrationCalculation();
    MixingSolutions mixingSolutions = new MixingSolutions();
    SolutionDilution solutionDilution = new SolutionDilution();

    public void start() {
        System.out.println("~~~~~~~~~~~~~~~~~~");
        System.out.println("~~~~ Roztwory ~~~~");
        System.out.println("~~~~~~~~~~~~~~~~~~");
        System.out.println("");
        Menu menu = new Menu();
        while (!exit) {
            menu.showMenu();
            actionMenu();
        }
    }

    private void actionMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWybierz opcję:");
        String option = scanner.next();
        switch (option) {
            case "1":
                concentrationCalculation.showConcentration();
                break;
            case "2":
                mixingSolutions.showFinalConcentrationAndAmountOfSolution();
                break;
            case "3":
                solutionDilution.showAmountOfStockSolutionAndWater();
                break;
            case "0":
                exit = true;
                break;
            default:
                System.out.println("Błędny wybór\n");
        }
    }
}
