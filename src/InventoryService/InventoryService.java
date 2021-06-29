package InventoryService;
import InventoryModel.Inventory;
import java.util.ArrayList;
import java.util.Scanner;

public class InventoryService implements InventoryServiceInterface{
    Scanner scanner = new Scanner(System.in);

    // 'addInventory' add the inventory to Inventory list.
    @Override
    public ArrayList<Inventory> addInventory(Inventory inventory, ArrayList<Inventory> inventoryArrayList) {
        System.out.println("Enter Inventory name: ");
        String inventoryName = scanner.next();
        System.out.println("Enter weight: ");
        double weight = scanner.nextDouble();
        System.out.println("Enter price: ");
        double price = scanner.nextDouble();

        inventory.setName(inventoryName);
        inventory.setWeight(weight);
        inventory.setPrice(price);

        inventoryArrayList.add(inventory);
        return null;
    }

    // 'editInventory' edit the inventory from Inventory list.
    @Override
    public ArrayList<Inventory> editInventory(ArrayList<Inventory> inventoryArrayList) {
        System.out.println("Enter Inventory name : ");
        String inventoryName = scanner.next();
        for (int i = 0; i < inventoryArrayList.size(); i++) {
            if (inventoryArrayList.get(i).getName().equals(inventoryName)) {
                System.out.println("Enter weight: ");
                double weight = scanner.nextDouble();
                System.out.println("Enter price: ");
                double price = scanner.nextDouble();

                inventoryArrayList.get(i).setWeight(weight);
                inventoryArrayList.get(i).setPrice(price);
                break;
            }
        }
        return null;
    }

    // 'deleteInventory' delete the inventory from Inventory list.
    @Override
    public ArrayList<Inventory> deleteInventory(ArrayList<Inventory> inventoryArrayList) {
        System.out.println("Enter Inventory name : ");
        String inventoryName = scanner.next();
        for (int i = 0; i < inventoryArrayList.size(); i++) {
            if (inventoryArrayList.get(i).getName().equals(inventoryName)) {
                inventoryArrayList.remove(i);
                break;
            }
        }
                return null;
    }

    // 'viewInventory' view the inventory from Inventory list.
    @Override
    public ArrayList<Inventory> viewInventory(ArrayList<Inventory> inventoryArrayList) {
        for (Inventory i : inventoryArrayList) {
            System.out.println(i.getName() + " " + i.getPrice() + " " + i.getWeight());
        }
        return null;
    }
}
