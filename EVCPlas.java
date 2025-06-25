import java.util.Scanner;

public class EVCPLAS {
    // Qodobada guud ee barnaamijka
    static int correctPIN =3480;
    static int balance = 150;
    static int bankBalance = 250;
    static String bankAccount = "920919";
    static String[] transactions = new String[5];
    // Kaydinta wareejinadii u danbeeyey
    static int transactionIndex = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Hubinta koodhka EVC
        System.out.print("Fadlan geli koodhka: ");
        String code = input.nextLine();
        if (!code.equals("*770#")) {
            System.out.println("Koodhka waa khalad.");
            return;
        }

        // Hubinta PIN
        System.out.print("Geli PIN-kaaga: ");
        int enteredPIN = input.nextInt();
        if (enteredPIN != correctPIN) {
            System.out.println("PIN-ka waa khalad.");
            return;
        }

        boolean running = true;
        while (running) {
            // Menu-ga ugu weyn
            System.out.println("\n------ EVCPlus ------");
            System.out.println("1. Itus Haraaga");
            System.out.println("2. Kaarka Hadalka");
            System.out.println("3. Bixi Biil");
            System.out.println("4. U Wareeji EVCPlus");
            System.out.println("5. Warbixin Kooban");
            System.out.println("6. Salaam Bank");
            System.out.println("7. Maareynta");
            System.out.println("8. Tijaabi Arrays & Swap");
            System.out.println("0. Bixid");
            System.out.print("Fadlan dooro: ");

            int option = input.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Haraagaaga waa: $" + balance);
                    break;
                case 2:
                    rechargeAirtime(input);
                    break;
                case 3:
                    payBill(input);
                    break;
                case 4:
                    sendMoney(input);
                    break;
                case 5:
                    showTransactions();
                    break;
                case 6:
                    salaamBank(input);
                    break;
                case 7:
                    manageMenu(input);
                    break;
                case 8:
                    testArrayAndSwap(input);
                    break;
                case 0:
                    running = false;
                    System.out.println("Mahadsanid! Barnaamijku wuu xirmay.");
                    break;
                default:
                    System.out.println("Fadlan dooro 0 ilaa 8.");
            }
        }
    }

    // Function: Shubo kaarka hadalka
    static void rechargeAirtime(Scanner input) {
        System.out.print("Geli lambarka aad ku shubayso: ");
        String number = input.next();
        System.out.print("Geli Lacagta: ");
        int amount = input.nextInt();

        if (amount > 0 && amount <= balance) {
            balance -= amount;
            saveTransaction("Kaarka hadalka: $" + amount + " numberka: " + number);
            System.out.println("Si guul leh ayaad ugu shubtay. Haraaga cusub: $" + balance);
        } else {
            System.out.println("Lacag khaldan ama haraaga kuguma filna.");
        }
    }

    // Function: Bixi Biil
    static void payBill(Scanner input) {
        System.out.print("Geli lambarka shirkadda: ");
        String company = input.next();
        System.out.print("Geli Lacagta: ");
        int amount = input.nextInt();

        if (amount > 0 && amount <= balance) {
            balance -= amount;
            saveTransaction("Biil: $" + amount + " shirkadda: " + company);
            System.out.println("Biilka waa la bixiyay. Haraaga cusub: $" + balance);
        } else {
            System.out.println("Lacag khaldan ama haraag kuguma filna.");
        }
    }

    // Function: U wareeji lacag qof kale
    static void sendMoney(Scanner input) {
        System.out.print("Geli lambarka qofka: ");
        String recipient = input.next();
        System.out.print("Geli Lacagta: ");
        int amount = input.nextInt();
        if (amount > 0 && amount <= balance) {
            System.out.print("Ma hubtaa? (1 = Haa): ");
            if (input.nextInt() == 1) {
                balance -= amount;
                saveTransaction("U wareejin: $" + amount + " numberka: " + recipient);
                System.out.println("Lacagta waa la wareejiyay. Haraaga cusub: $" + balance);
            }
        } else {
            System.out.println("Lacag khaldan ama haraag kuguma filna.");
        }
    }

    // Function: Kaydi warbixinada ugu dambeysay (array)
    static void saveTransaction(String info) {
        transactions[transactionIndex % transactions.length] = info;
        transactionIndex++;
    }

    // Function: Daabac warbixinta u dambaysay
    static void showTransactions() {
        System.out.println("Warbixinada u dambeysay:");
        for (int i = 0; i < transactions.length; i++) {
            if (transactions[i] != null) {
                System.out.println("- " + transactions[i]);
            }
        }
    }

    // Function: Salaam Bank
    static void salaamBank(Scanner input) {
        boolean bankRunning = true;
        while (bankRunning) {
            System.out.println("\n------ Salaam Bank ------");
            System.out.println("1. Itus Haraaga");
            System.out.println("2. Lacag Dhigasho");
            System.out.println("3. Lacag Qaadasho");
            System.out.println("4. Ka Wareeji EVCPlus");
            System.out.println("0. Ka Bax");
            System.out.print("Fadlan dooro: ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Haraaga bankiga: $" + bankBalance);
                    break;
                case 2:
                    System.out.print("Geli lacagta: ");
                    int deposit = input.nextInt();
                    if (deposit > 0 && deposit <= balance) {
                        balance -= deposit;
                        bankBalance += deposit;
                        saveTransaction("Lacag dhigasho: $" + deposit);
                        System.out.println("Guul. Bank: $" + bankBalance + ", EVCPlus: $" + balance);
                    }
                    break;
                case 3:
                    System.out.print("Geli lacagta: ");
                    int withdraw = input.nextInt();
                    if (withdraw > 0 && withdraw <= bankBalance) {
                        bankBalance -= withdraw;
                        balance += withdraw;
                        saveTransaction("Lacag laga qaaday: $" + withdraw);
                        System.out.println("Guul. Bank: $" + bankBalance + ", EVCPlus: $" + balance);
                    }
                    break;
                case 4:
                    System.out.print("Geli account number: ");
                    String acc = input.next();
                    System.out.print("Geli lacagta: ");
                    int amt = input.nextInt();
                    if (amt > 0 && amt <= balance) {
                        System.out.print("Ma hubtaa? (1 = Haa): ");
                        if (input.nextInt() == 1) {
                            balance -= amt;
                            saveTransaction("U wareejin: $" + amt + " --> " + acc);
                            System.out.println("Lacag wareejinay. EVCPlus: $" + balance);
                        }
                    }
                    break;
                case 0:
                    bankRunning = false;
                    System.out.println("Waxaad ka baxday Salaam Bank.");
                    break;
            }
        }
    }

    // Function: Maareynta (bedel PIN, luqad iwm)
    static void manageMenu(Scanner input) {
        boolean managing = true;
        while (managing) {
            System.out.println("\n------ Maareynta ------");
            System.out.println("1. Bedel PIN-ka");
            System.out.println("2. Bedel Luqada");
            System.out.println("3. Wargelin Mobile lumay");
            System.out.println("4. Lacag Xirasho");
            System.out.println("5. U celi lacag qaldantay");
            System.out.println("0. Ka bax");
            System.out.print("Dooro: ");

            int opt = input.nextInt();
            switch (opt) {
                case 1:
                    System.out.print("Geli PIN cusub: ");
                    correctPIN = input.nextInt();
                    System.out.println("PIN-ka waa la bedelay.");
                    break;
                case 2:
                    System.out.println("Luqadaha lama taageerin waqtigan.");
                    break;
                case 3:
                    System.out.println("La xiriir adeeg bixiyaha si aad uga warbixiso telefoon lumay.");
                    break;
                case 4:
                    System.out.println("Lacagta si ku meel gaar ah waa la xiray.");
                    break;
                case 5:
                    System.out.println("La xiriir adeeg bixiyaha si aad u hesho lacag qaldantay.");
                    break;
                case 0:
                    managing = false;
                    System.out.println("Waxaad ka baxday Maareynta.");
                    break;
                default:
                    System.out.println("Fadlan dooro (0 ilaa 5).\n");
            }
        }
    }

    // Function: Tijaabi array iyo swap
    static void testArrayAndSwap(Scanner input) {
        System.out.println("\n--- Tijaabo Array & Swap ---");
        int[] arr = new int[5];
        System.out.println("Geli 5 number: ");
        for (int i = 0; i < 5; i++) {
            arr[i] = input.nextInt();
        }

        // Swap u dhaxaysa [0] iyo [4]
        int temp = arr[0];
        arr[0] = arr[4];
        arr[4] = temp;

        // Daabac array cusub
        System.out.println("Kadib isweydaarsi:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}


