package InventoryService;

import InventoryModel.Inventory;

import java.util.ArrayList;

public interface InventoryServiceInterface {
    public abstract ArrayList<Inventory> addInventory(Inventory inventory, ArrayList<Inventory> inventoryArrayList);
    public abstract ArrayList<Inventory> editInventory(ArrayList<Inventory> inventoryArrayList);
    public abstract ArrayList<Inventory> deleteInventory(ArrayList<Inventory> inventoryArrayList);
    public abstract ArrayList<Inventory> viewInventory(ArrayList<Inventory> inventoryArrayList);
}
