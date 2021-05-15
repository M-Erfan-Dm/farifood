package ir.ac.kntu.menu.main;

import ir.ac.kntu.db.CustomersDB;
import ir.ac.kntu.menu.Menu;
import ir.ac.kntu.menu.courier.CouriersMenu;
import ir.ac.kntu.menu.customer.CustomersMenu;
import ir.ac.kntu.utils.ScannerWrapper;

public class MainMenu extends Menu {


    private final CouriersMenu couriersMenu;

    private final CustomersMenu customersMenu;

    public MainMenu(CouriersMenu couriersMenu,CustomersMenu customersMenu) {
        this.couriersMenu = couriersMenu;
        this.customersMenu = customersMenu;
    }

    @Override
    public void show() {
        MainMenuOption mainMenuOption = printMenuOptions();
        while (mainMenuOption != MainMenuOption.BACK) {
            if (mainMenuOption != null) {
                switch (mainMenuOption) {
                    case ORDERS:
                        break;
                    case COURIERS:
                        couriersMenu.show();
                        break;
                    case RESTAURANTS:
                        break;
                    case CUSTOMERS:
                        customersMenu.show();
                        break;
                    case SETTINGS:
                        break;
                }

            }
            mainMenuOption = printMenuOptions();
        }
    }

    private MainMenuOption getOption() {
        int choice = Integer.parseInt(ScannerWrapper.nextLine()) - 1;
        MainMenuOption[] mainMenuOptions = MainMenuOption.values();
        if (choice >= 0 && choice < mainMenuOptions.length) {
            return mainMenuOptions[choice];
        }
        return null;
    }

    private MainMenuOption printMenuOptions() {
        System.out.println("----------Main Menu----------");
        System.out.println("\n1.Orders\n" +
                "2.Couriers\n" +
                "3.Restaurants\n" +
                "4.Customers\n" +
                "5.Settings\n" +
                "6.Back\n");

        System.out.print("Enter your choice : ");
        return getOption();
    }

}
