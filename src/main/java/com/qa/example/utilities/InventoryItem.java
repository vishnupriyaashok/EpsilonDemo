package com.qa.example.utilities;

public class InventoryItem {
	
	private String inventoryItemName;
    private String inventoryItemDesc;
    private String inventoryItemPrice;
    private String inventoryItemImage;

	
	public InventoryItem(String inventoryItemName, String inventoryItemDesc, String inventoryItemPrice,
			String inventoryItemImage) {
		this.inventoryItemName = inventoryItemName;
		this.inventoryItemDesc = inventoryItemDesc;
		this.inventoryItemPrice = inventoryItemPrice;
		this.inventoryItemImage = inventoryItemImage;
	}
	public String getInventoryItemName() {
		return inventoryItemName;
	}
	public void setInventoryItemName(String inventoryItemName) {
		this.inventoryItemName = inventoryItemName;
	}
	public String getInventoryItemDesc() {
		return inventoryItemDesc;
	}
	public void setInventoryItemDesc(String inventoryItemDesc) {
		this.inventoryItemDesc = inventoryItemDesc;
	}
	public String getInventoryItemPrice() {
		return inventoryItemPrice;
	}
	public void setInventoryItemPrice(String inventoryItemPrice) {
		this.inventoryItemPrice = inventoryItemPrice;
	}
	public String getInventoryItemImage() {
		return inventoryItemImage;
	}
	public void setInventoryItemImage(String inventoryItemImage) {
		this.inventoryItemImage = inventoryItemImage;
	}

}
