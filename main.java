import java.util.InputMismatchException;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        while (true) {

            try {
                Russia russia = new Russia();

                russia.introduction();
                russia.rules();

                System.out.println("\n\n");

                russia.display_info();
                Russia_Actions();
            }
            catch (ArithmeticException e) {
                System.out.println("You can't divide by zero!");
            }
            catch (InputMismatchException e) {
                System.out.println("Please, enter a number!");
            }
            catch (Exception e) {
                System.out.println("Something went wrong!");
            }
        }
    }

    static void Russia_Actions() {

            Russia r = new Russia();

            Scanner scanner = new Scanner(System.in);

            while(true) {

                r.if_game_completed();

                System.out.println("\n\tYou have several things to do:");
                System.out.println("\t1 - ATTACK UKRAINE");
                System.out.println("\t2 - SHOW CONQUERED TERRITORIES");
                System.out.println("\t3 - INCREASE ARMIES POPULATION");
                System.out.println("\t4 - ASK YOUR ALLIED COUNTRIES FOR HELP");
                System.out.println("\t5 - STRENGTHEN THE ECONOMY");
                System.out.println("\t6 - COLLECT PROFIT FROM INVESTMENTS");

                if (r.army < 100000.0 && r.economy < 100000) {
                    System.out.println("\t8 - TRY TO CONCLUDE A TRUCE");
                }
                System.out.println("\t9 - EXIT THE GAME");

                System.out.print("\t");
                int choice = scanner.nextInt();

                if (choice == 1) {
                    r.attack_Ukraine();
                    r.display_info();
                }
                else if (choice == 2) {
                    System.out.print("\n\n\tYou have Conquered: ");
                    r.show_conquered_territories();
                }
                else if (choice == 3) {
                    r.increase_armies_population();
                    r.display_info();
                }
                else if (choice == 4) {
                    r.ask_allied_countries_for_help();
                    r.display_info();
                }
                else if (choice == 5) {
                    r.strengthen_economy();
                    r.display_info();
                }
                else if (choice == 6) {
                    r.collect_profit_for_economy();
                    r.display_info();
                }
                else if (choice == 7 && r.army < 100000.0 && r.economy < 100000) {
                    r.conclude_a_truce();
                }
                else if (choice == 8) {
                    break;
                }
                else {
                    System.out.println("\n\tWRONG INPUT!");
                }
            }
    }
}