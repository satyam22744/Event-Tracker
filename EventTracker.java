import java.util.ArrayList;
import java.util.Scanner;

public class EventTracker {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Vendor> vendors = new ArrayList<>();

        System.out.print("Enter total budget for the event: ");
        double totalBudget = sc.nextDouble();

        while (true) {
            System.out.println("\n--- Event Budget & Vendor Menu ---");
            System.out.println("1. Add Vendor");
            System.out.println("2. Pay Vendor");
            System.out.println("3. View Budget & Vendors");
            System.out.println("4. Update Total Budget");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clear newline

            if (choice == 1) {
                System.out.print("Vendor name: ");
                String name = sc.nextLine();

                System.out.print("Service (e.g., Food, Sound, Decor): ");
                String service = sc.nextLine();

                System.out.print("Total bill amount: ");
                double bill = sc.nextDouble();

                System.out.print("Advance paid (enter 0 if none): ");
                double advance = sc.nextDouble();

                if (advance > bill) {
                    System.out.println("Advance cannot be more than the total bill!");
                } else {
                    vendors.add(new Vendor(name, service, bill, advance));
                    System.out.println("Vendor added.");
                }

            } else if (choice == 2) {
                if (vendors.isEmpty()) {
                    System.out.println("No vendors added yet.");
                    continue;
                }

                for (int i = 0; i < vendors.size(); i++) {
                    Vendor v = vendors.get(i);
                    System.out.println((i + 1) + ". " + v.name + " (Balance: " + v.getBalance() + ")");
                }

                System.out.print("Select vendor number: ");
                int index = sc.nextInt() - 1;

                if (index < 0 || index >= vendors.size()) {
                    System.out.println("Invalid vendor number.");
                    continue;
                }

                Vendor selected = vendors.get(index);
                System.out.print("Enter amount to pay: ");
                double pay = sc.nextDouble();

                if (pay <= 0 || pay > selected.getBalance()) {
                    System.out.println("Invalid amount. Balance due is " + selected.getBalance());
                } else {
                    selected.paidAmount += pay;
                    System.out.println("Payment updated! Remaining balance: " + selected.getBalance());
                }

            } else if (choice == 3) {
                double totalSpent = 0;
                double totalPaid = 0;

                System.out.println("\n--- Vendor List ---");
                if (vendors.isEmpty()) {
                    System.out.println("No vendors yet.");
                } else {
                    for (int i = 0; i < vendors.size(); i++) {
                        Vendor v = vendors.get(i);
                        totalSpent += v.totalBill;
                        totalPaid += v.paidAmount;

                        String status = (v.getBalance() == 0) ? "Paid" : "Pending";
                        System.out.println((i + 1) + ". " + v.name + " (" + v.service + ") | Bill: " + v.totalBill
                                + " | Paid: " + v.paidAmount + " | Due: " + v.getBalance() + " [" + status + "]");
                    }
                }

                System.out.println("\n--- Budget Summary ---");
                System.out.println("Total Budget : " + totalBudget);
                System.out.println("Total Bills  : " + totalSpent);
                System.out.println("Total Paid   : " + totalPaid);
                System.out.println("Budget Left  : " + (totalBudget - totalSpent));

                if (totalSpent > totalBudget) {
                    System.out.println("Warning: You are over budget!");
                }

            } else if (choice == 4) {
                System.out.print("Enter new total budget: ");
                totalBudget = sc.nextDouble();
                System.out.println("Budget updated.");

            } else if (choice == 5) {
                System.out.println("Exiting...");
                break;

            } else {
                System.out.println("Invalid choice, try again.");
            }
        }

        sc.close();
    }
}

class Vendor {
    String name;
    String service;
    double totalBill;
    double paidAmount;

    Vendor(String name, String service, double totalBill, double paidAmount) {
        this.name = name;
        this.service = service;
        this.totalBill = totalBill;
        this.paidAmount = paidAmount;
    }

    double getBalance() {
        return totalBill - paidAmount;
    }
}