import java.util.Scanner;

public class Russia {
    String president;
    String general;

    int happiness_scale;

    double population;
    double army;
    double armored_vehicles;
    double military_aircraft;
    double economy;
    double troops_quantity;
    double profit_for_economy;

    boolean lugansk_conquered;
    boolean donetsk_conquered;
    boolean zaporozhye_conquered;
    boolean xerson_conquered;
    boolean sumi_conquered;
    boolean chernigov_conquered;
    boolean kiev_conquered;
    boolean discussed;
    boolean attacked;
    boolean rules_and_intro_read;

    String[] conquered_territories;

    Russia() {
        president = "Vladimir Putin";
        general = "Sergey Shoygu";
        happiness_scale = 100;
        population = 150000000;
        army = 1000000;
        armored_vehicles = 50;
        military_aircraft = 20;
        economy = 30000000.0;
        troops_quantity = 0.0;
        profit_for_economy = 0.0;

        lugansk_conquered = false;
        donetsk_conquered = false;
        zaporozhye_conquered = false;
        xerson_conquered = false;
        sumi_conquered = false;
        discussed = false;
        attacked = false;
        rules_and_intro_read = false;

        chernigov_conquered = false;
        kiev_conquered = false;

        conquered_territories = new String[]{"", "", "", "", ""};
    }

    public void display_info() {
        System.out.println("\tRussia's president: " + president);
        System.out.println("\tRussia's general: " + general);
        System.out.println("\tRussia's Population: " + population + " people");
        System.out.println("\tRussia's Army Quantity: " + army);
        System.out.println("\tRussia's Armored Vehicles Quantity: " + armored_vehicles);
        System.out.println("\tRussia's Military Aircraft Quantity: " + military_aircraft);
        System.out.println("\tRussia's Economy: " + economy + "$");
        System.out.println("\tRussia's Happiness Scale: " +happiness_scale);
        System.out.println("\tRussia's Economy Profit: " +profit_for_economy);
        System.out.println("\tTroops: " + troops_quantity);
    }

    public void show_conquered_territories() {
        for (String conquered_territory : conquered_territories) {
            System.out.print("" + conquered_territory+ ", ");
        }
    }

    public void attack_Ukraine() {

            if (!sumi_conquered) {

                System.out.println("\n\tWhich city you will attack?");
                System.out.println("\t1 - Lugansk");
                System.out.println("\t2 - Donetsk");
                System.out.println("\t3 - Zaporozhye");
                System.out.println("\t4 - Xerson");
                System.out.println("\t5 - Sumi");
                System.out.println("\t6 - DISCUSS STRATEGY WITH THE GENERAL AND PRESIDENT");

                success_or_failure();

            }
            else if (sumi_conquered && !chernigov_conquered) {
                System.out.println("\n\tWhich city you will attack?");
                System.out.println("\t1 - Lugansk");
                System.out.println("\t2 - Donetsk");
                System.out.println("\t3 - Zaporozhye");
                System.out.println("\t4 - Xerson");
                System.out.println("\t5 - Chernigov");
                System.out.println("\t6 - DISCUSS STRATEGY WITH THE GENERAL AND PRESIDENT");

                success_or_failure();
            }
            else if (chernigov_conquered && !kiev_conquered) {
                System.out.println("\n\tWhich city you will attack?");
                System.out.println("\t1 - Lugansk");
                System.out.println("\t2 - Donetsk");
                System.out.println("\t3 - Zaporozhye");
                System.out.println("\t4 - Xerson");
                System.out.println("\t5 - Kyiv");
                System.out.println("\t6 - DISCUSS STRATEGY WITH THE GENERAL AND PRESIDENT");

                success_or_failure();
            }
    }

    public void troops() {
        Scanner scanner = new Scanner(System.in);

        if (!sumi_conquered) {
            System.out.println("\n\tTo Conquer These Territories You Will Need At Least 200.000 Troops!");
        }
        else if(sumi_conquered && !chernigov_conquered) {
            System.out.println("\n\tTo Conquer Chernigov You Will Need At Least 4.500.000 Troops!");
        }
        else if(chernigov_conquered && !kiev_conquered) {
            System.out.println("\n\tTo Conquer Kyiv You Will Need At Least 10.000.000 Troops!");
        }

        System.out.println("\n\tHow many troops you want to send to the battlefield?: ");
        System.out.print("\t");

        troops_quantity = scanner.nextInt();
    }

    public void conquer() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\tWhat kind of combat unit you want to send?");
        System.out.println("\t1 - ARMORED VEHICLES (1 vehicle = 200 troops)");
        System.out.println("\t2 - MILITARY AIRCRAFT (1 aircraft = 1000 troops)");
        System.out.println("\t3 - BOTH OF THEM");

        System.out.print("\t");
        int type_of_unit = scanner.nextInt();

        double vehicles_quantity;
        double aircrafts_quantity;

        if (type_of_unit == 1) {
            System.out.println("\n\tHow many vehicles you want to send?: ");

            System.out.print("\t");
            vehicles_quantity = scanner.nextInt();

            if (vehicles_quantity < armored_vehicles) {

                System.out.println("\tYou have send " + vehicles_quantity + " armored vehicles");

                armored_vehicles = armored_vehicles - vehicles_quantity;
                army = army - troops_quantity;
                troops_quantity = (vehicles_quantity * 200) + troops_quantity;
            }
            else {
                System.out.println("\n\tWrong Input Or You Have Typed More Than You Can!");
            }
        } else if (type_of_unit == 2) {
            System.out.println("\n\tHow many aircrafts you want to send?: ");

            System.out.print("\t");
            aircrafts_quantity = scanner.nextInt();

            if (aircrafts_quantity < military_aircraft) {

                System.out.println("\tYou have send " + aircrafts_quantity + " military aircrafts");

                army = army - troops_quantity;
                military_aircraft = military_aircraft - aircrafts_quantity;
                troops_quantity = (aircrafts_quantity * 1000) + troops_quantity;
            }
            else {
                System.out.println("\n\tWrong Input Or You Have Typed More Than You Can!");
            }
        } else if (type_of_unit == 3) {
            System.out.println("\n\tHow many vehicles you want to send?: ");

            System.out.print("\t");
            vehicles_quantity = scanner.nextInt();

            if (vehicles_quantity < armored_vehicles) {
                System.out.println("\tYou have send " + vehicles_quantity + " armored vehicles");
                System.out.println("\n\tHow many aircrafts you want to send?: ");

                System.out.print("\t");
                aircrafts_quantity = scanner.nextInt();

                if (aircrafts_quantity < military_aircraft) {
                    System.out.println("\tYou have send " + aircrafts_quantity + " military aircrafts");

                    military_aircraft = military_aircraft - aircrafts_quantity;
                    armored_vehicles = armored_vehicles - vehicles_quantity;
                    army = army - troops_quantity;
                    troops_quantity = ((vehicles_quantity * 200) + troops_quantity) + ((aircrafts_quantity * 1000) + troops_quantity);
                }
            }
            else {
                System.out.println("\n\tWrong Input Or You Have Typed More Than You Can!");
            }
        } else {
            System.out.println("\n\tWrong Input!");
        }
        //scanner.close();
    }

    public void success_or_failure() {

        Scanner scanner = new Scanner(System.in);

        if (!sumi_conquered) {

            System.out.print("\t");
            int choice = scanner.nextInt();

            if (choice == 1 && !lugansk_conquered) {

                troops();

                if (troops_quantity < army) {

                    conquer();

                    if (troops_quantity >= 200000) {
                        System.out.println("\n\tYou have successfully conquered Lugansk!\n\n");
                        lugansk_conquered = true;
                        attacked = true;
                        conquered_territories[0] = "Lugansk";
                    } else {
                        System.out.println("\n\tYou couldn't conquer Lugansk. All of your troops are dead!\n\n");
                    }
                } else {
                    System.out.println("\n\tYou have typed more than you have in army!");
                }
            }
            else if (choice == 2 && !donetsk_conquered) {
                troops();

                if (troops_quantity < army) {

                    conquer();

                    if (troops_quantity >= 200000) {
                        System.out.println("\n\tYou have successfully conquered Donetsk!\n\n");
                        donetsk_conquered = true;
                        attacked = true;
                        conquered_territories[1] = "Donetsk";
                    } else {
                        System.out.println("\n\tYou couldn't conquer Donetsk. All of your troops are dead!\n\n");
                    }
                } else {
                    System.out.println("\n\tYou have typed more than you have in army!");
                }
            }
            else if (choice == 3 && !zaporozhye_conquered) {
                troops();

                if (troops_quantity < army) {

                    conquer();

                    if (troops_quantity >= 200000) {
                        System.out.println("\n\tYou have successfully conquered Zaporozhye!\n\n");
                        zaporozhye_conquered = true;
                        attacked = true;
                        conquered_territories[2] = "Zaporozhye";
                    } else {
                        System.out.println("\n\tYou couldn't conquer Zaporozhye. All of your troops are dead!\n\n");
                    }
                } else {
                    System.out.println("\n\tYou have typed more than you have in army!");
                }
            }
            else if (choice == 4 && !xerson_conquered) {
                troops();

                if (troops_quantity < army) {

                    conquer();

                    if (troops_quantity >= 200000) {
                        System.out.println("\n\tYou have successfully conquered Xerson!\n\n");
                        xerson_conquered = true;
                        attacked = true;
                        conquered_territories[3] = "Xerson";
                    } else {
                        System.out.println("\n\tYou couldn't conquer Xerson. All of your troops are dead!\n\n");
                    }
                } else {
                    System.out.println("\n\tYou have typed more than you have in army!");
                }
            }
            else if (choice == 5 && !sumi_conquered) {
                troops();

                if (troops_quantity < army) {

                    conquer();

                    if (troops_quantity >= 200000) {
                        System.out.println("\n\tYou have successfully conquered Sumi!\n\n");
                        sumi_conquered = true;
                        attacked = true;
                        conquered_territories[4] = "Sumi";
                    } else {
                        System.out.println("\n\tYou couldn't conquer Sumi. All of your troops are dead!\n\n");
                    }
                } else {
                    System.out.println("\n\tYou have typed more than you have in army!");
                }
            }
            else if (choice == 6 && !discussed) {
                System.out.println("\n\tThe Best Strategy Is To Start From Sumi, Then Capture Chernigov And Enter Kyiv");
                System.out.println("\n\tYou Will Need To Increase The Strength Of Your Army To Win The War!");

                discussed = true;
            }
            else {
                System.out.println("\n\tWrong Input Or You Have Already Conquered This Territory Or You Have Already Discussed!");
            }
        }
        else if (sumi_conquered && !chernigov_conquered) {
            System.out.print("\t");
            int choice = scanner.nextInt();

            if (choice == 1 && !lugansk_conquered) {

                troops();

                if (troops_quantity < army) {

                    conquer();

                    if (troops_quantity >= 200000) {
                        System.out.println("\n\tYou have successfully conquered Lugansk!\n\n");
                        lugansk_conquered = true;
                    } else {
                        System.out.println("\n\tYou couldn't conquer Lugansk. All of your troops are dead!\n\n");
                    }
                } else {
                    System.out.println("\n\tYou have typed more than you have in army!");
                }
            }
            else if (choice == 2 && !donetsk_conquered) {
                troops();

                if (troops_quantity < army) {

                    conquer();

                    if (troops_quantity >= 200000) {
                        System.out.println("\n\tYou have successfully conquered Donetsk!\n\n");
                        donetsk_conquered = true;
                    } else {
                        System.out.println("\n\tYou couldn't conquer Donetsk. All of your troops are dead!\n\n");
                    }
                } else {
                    System.out.println("\n\tYou have typed more than you have in army!");
                }
            }
            else if (choice == 3 && !zaporozhye_conquered) {
                troops();

                if (troops_quantity < army) {

                    conquer();

                    if (troops_quantity >= 200000) {
                        System.out.println("\n\tYou have successfully conquered Zaporozhye!\n\n");
                        zaporozhye_conquered = true;
                    } else {
                        System.out.println("\n\tYou couldn't conquer Zaporozhye. All of your troops are dead!\n\n");
                    }
                } else {
                    System.out.println("\n\tYou have typed more than you have in army!");
                }
            }
            else if (choice == 4 && !xerson_conquered) {
                troops();

                if (troops_quantity < army) {

                    conquer();

                    if (troops_quantity >= 200000) {
                        System.out.println("\n\tYou have successfully conquered Xerson!\n\n");
                        xerson_conquered = true;
                    } else {
                        System.out.println("\n\tYou couldn't conquer Xerson. All of your troops are dead!\n\n");
                    }
                } else {
                    System.out.println("\n\tYou have typed more than you have in army!");
                }
            }
            else if (choice == 5 && !chernigov_conquered) {
                troops();

                if (troops_quantity < army) {

                    conquer();

                    if (troops_quantity >= 4500000) {
                        System.out.println("\n\tYou have successfully conquered Chernigov!\n\n");
                        chernigov_conquered = true;
                    } else {
                        System.out.println("\n\tYou couldn't conquer Chernigov. All of your troops are dead!\n\n");
                    }
                } else {
                    System.out.println("\n\tYou have typed more than you have in army!");
                }
            }
            else if (choice == 6 && !discussed) {
                System.out.println("\n\tThe Best Strategy Is To Start From Sumi, Then Capture Chernigov And Enter Kyiv");
                System.out.println("\n\tYou Will Need To Increase The Strength Of Your Army To Win The War!");

                discussed = true;
            }
            else {
                System.out.println("\n\tWrong Input Or You Have Already Conquered This Territory Or You Have Already Discussed!");
            }
        }
        else if (chernigov_conquered && !kiev_conquered) {
            System.out.print("\t");
            int choice = scanner.nextInt();

            if (choice == 1 && !lugansk_conquered) {

                troops();

                if (troops_quantity < army) {

                    conquer();

                    if (troops_quantity >= 200000) {
                        System.out.println("\n\tYou have successfully conquered Lugansk!\n\n");
                        lugansk_conquered = true;
                    } else {
                        System.out.println("\n\tYou couldn't conquer Lugansk. All of your troops are dead!\n\n");
                    }
                } else {
                    System.out.println("\n\tYou have typed more than you have in army!");
                }
            }
            else if (choice == 2 && !donetsk_conquered) {
                troops();

                if (troops_quantity < army) {

                    conquer();

                    if (troops_quantity >= 200000) {
                        System.out.println("\n\tYou have successfully conquered Donetsk!\n\n");
                        donetsk_conquered = true;
                    } else {
                        System.out.println("\n\tYou couldn't conquer Donetsk. All of your troops are dead!\n\n");
                    }
                } else {
                    System.out.println("\n\tYou have typed more than you have in army!");
                }
            }
            else if (choice == 3 && !zaporozhye_conquered) {
                troops();

                if (troops_quantity < army) {

                    conquer();

                    if (troops_quantity >= 200000) {
                        System.out.println("\n\tYou have successfully conquered Zaporozhye!\n\n");
                        zaporozhye_conquered = true;
                    } else {
                        System.out.println("\n\tYou couldn't conquer Zaporozhye. All of your troops are dead!\n\n");
                    }
                } else {
                    System.out.println("\n\tYou have typed more than you have in army!");
                }
            }
            else if (choice == 4 && !xerson_conquered) {
                troops();

                if (troops_quantity < army) {

                    conquer();

                    if (troops_quantity >= 200000) {
                        System.out.println("\n\tYou have successfully conquered Xerson!\n\n");
                        xerson_conquered = true;
                    } else {
                        System.out.println("\n\tYou couldn't conquer Xerson. All of your troops are dead!\n\n");
                    }
                } else {
                    System.out.println("\n\tYou have typed more than you have in army!");
                }
            }
            else if (choice == 5 && !kiev_conquered) {
                troops();

                if (troops_quantity < army) {

                    conquer();

                    if (troops_quantity >= 10000000) {
                        System.out.println("\n\tYou have successfully conquered Kyiv!\n\n");
                        kiev_conquered = true;
                    } else {
                        System.out.println("\n\tYou couldn't conquer Kyiv. All of your troops are dead!\n\n");
                    }
                } else {
                    System.out.println("\n\tYou have typed more than you have in army!");
                }
            }
            else if (choice == 6 && !discussed) {
                System.out.println("\n\tThe Best Strategy Is To Start From Sumi, Then Capture Chernigov And Enter Kyiv");
                System.out.println("\n\tYou Will Need To Increase The Strength Of Your Army To Win The War!");

                discussed = true;
            }
            else {
                System.out.println("\n\tWrong Input Or You Have Already Conquered This Territory Or You Have Already Discussed!");
            }
        }
    }

    public void increase_armies_population() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\n\tTo Increase Armies Population, You Have To Declare A General Mobilization");
        System.out.println("\tBut Be Careful, When You Declare A Mobilization, Scale Of Happiness In Your Country Will Decrease To 25 Points!");
        System.out.println("\tYour Current Scale Of Happiness: " +happiness_scale);
        System.out.println("\n\tFrom 1 Mobilization You Can Recruit 500.000 Troops");
        System.out.println("\tEnter Quantity Of Mobilizations You Want To Declare: ");

        System.out.print("\t");
        int quantity = scanner.nextInt();

        happiness_scale = happiness_scale - (quantity * 25);
        army = army + (quantity * 500000);

        if (happiness_scale <= 0) {
            System.out.println("\n\tHappiness Scale Dropped Below Zero!");
            System.out.println("\n\n\t\t\t\tGAME OVER!");
            System.exit(0);
        }

    }

    public void ask_allied_countries_for_help() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n\tAllied Countries Doesn't Want To Help You For Free.");
            System.out.println("\tYou Can Only Buy Vehicles Or Aircrafts Or Hire Troops.");
            System.out.println("\tYour Balance Is: " +economy+ "$");
            System.out.println("\t1 Aircraft = 250.000$ (PRESS 1 TO BUY)");
            System.out.println("\t1 Armored Vehicle = 50.000$ (PRESS 2 TO BUY)");
            System.out.println("\t1 Troop = 250$ (PRESS 3 TO BUY)");
            System.out.println("\n\tPRESS 4 TO GO BACK");

            System.out.print("\t");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("\n\tEnter Quantity: ");
                System.out.print("\t");
                int quantity = scanner.nextInt();

                if(quantity * 250000 <= economy) {
                    System.out.println("\n\tYou Have Successfully Bought Aircrafts!");
                    economy = economy - (quantity * 250000);
                    military_aircraft = military_aircraft + quantity;
                }
                else {
                    System.out.println("\n\tYou Don't Have Enough Money!");
                }
            }
            else if (choice == 2) {
                System.out.println("\n\tEnter Quantity: ");
                System.out.print("\t");
                int quantity = scanner.nextInt();

                if(quantity * 50000 <= economy) {
                    System.out.println("\n\tYou Have Successfully Bought Armored Vehicles!");
                    economy = economy - (quantity * 50000);
                    armored_vehicles = armored_vehicles + quantity;
                }
                else {
                    System.out.println("\n\tYou Don't Have Enough Money!");
                }
            }
            else if (choice == 3) {
                System.out.println("\n\tEnter Quantity: ");
                System.out.print("\t");
                int quantity = scanner.nextInt();

                if(quantity * 250 <= economy) {
                    System.out.println("\n\tYou Have Successfully Hired Troops!");
                    economy = economy - (quantity * 250);
                    army = army + quantity;
                }
                else {
                    System.out.println("\n\tYou Don't Have Enough Money!");
                }
            }
            else if (choice == 4) {
                break;
            }
            else {
                System.out.println("\tWrong Input!");
            }
        }
    }

    public void strengthen_economy() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n\tTo Improve Your Economy You Should Invest In Different Countries");
            System.out.println("\tHere Is The List Of Countries: ");
            System.out.println("\n\t(PRESS 1) USA - 15.000.000$. Profit: 3.500.000$");
            System.out.println("\t(PRESS 2) Switzerland - 7.500.000$. Profit: 1.750.000$");
            System.out.println("\t(PRESS 3) Australia - 3.750.000$. Profit: 875.000$");
            System.out.println("\t(PRESS 4) GO BACK");

            System.out.print("\t");
            int choice = scanner.nextInt();

            if (choice == 1 && economy >= 15000000) {
                System.out.println("\n\tYou Have Successfully Invested In USA");
                profit_for_economy = profit_for_economy + 3500000;
                economy = economy - 15000000;
                System.out.println("\tYour Total Profit For A Month: " +profit_for_economy);
            }
            else if (choice == 2 && economy >= 7500000) {
                System.out.println("\n\tYou Have Successfully Invested In Switzerland");
                profit_for_economy = profit_for_economy + 1750000;
                System.out.println("\tYour Total Profit For A Month: " +profit_for_economy);
            }
            else if (choice == 3 && economy >= 3750000) {
                System.out.println("\n\tYou Have Successfully Invested In Switzerland");
                profit_for_economy = profit_for_economy + 875000;
                System.out.println("\tYour Total Profit For A Month: " +profit_for_economy);
            }
            else if (choice == 4) {
                break;
            }
            else {
                System.out.println("\n\tYour Money Is Insufficient Or Wrong Input!");
            }
        }
    }

    public void collect_profit_for_economy() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\tYour Daily Profit: " +profit_for_economy);
        System.out.print("\n\tPRESS 1 TO COLLECT: ");
        int collect = scanner.nextInt();

        if (collect == 1) {
            System.out.println("\n\tYou Have Successfully Collected Monthly Profit!");
            economy = economy + profit_for_economy;
        }
        else {
            System.out.println("\n\tWrong Input!");
        }
    }

    public void conclude_a_truce() {
        if (economy < 3000000 && army < 1000000) {
            System.out.println("\n\tUkraine Declined Your Offer!");
        }
        else {
            System.out.println("\n\tUkraine Accepted Your Offer!");
            System.out.println("\t\t\t\t\tWAR HAS BEEN ENDED!");
            System.exit(0);
        }
    }

    public void if_game_completed() {
        if (kiev_conquered) {
            System.out.println("\n\n\t\t\t\tYOU HAVE CONQUERED UKRAINE!");
            System.exit(0);
        }
    }

    public void introduction() {
        System.out.println("\n\tThis game is going to check your strategy and communicative skills!");
        System.out.println("\tYou Should Conquer Ukraine Playing For Russia!");
    }

    public void rules() {
        System.out.println("\n\n\n\tYou Should Conquer Ukraine");
        System.out.println("\tIf Scale Happiness Dropes Below 0, You Will Loose");
        System.out.println("\tTo Win The Game You Should Conquer Kyiv");
        rules_and_intro_read = true;
    }
}


