package org.ytb.anarchy.anti_illegal.anti_32k;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.ytb.anarchy.anti_illegal.Main;



public class Main32k implements Listener {
	Main plugin;
	public Main32k(Main instance) {
		plugin = instance;
	}
	@EventHandler
	public void HitCheck(EntityDamageByEntityEvent event) {
		System.out.println("Hit Event");
		if(event.getDamager() instanceof Player) {
			Player hitter = (Player) event.getDamager();
			Inventory inv = hitter.getInventory();
			int a = 0;
			if(inv.getSize() == 5) {
				a = 5;
			}
			
			while(a != inv.getSize()) {
				
				if(!(inv.getItem(a).equals(null))) {
					
					int max = inv.getItem(a).getMaxStackSize();
					ItemStack item = inv.getItem(a);
					if(item.getAmount()>max) {
						item.setAmount(max);
						
					}
					for(Enchantment enc : item.getEnchantments().keySet()) {
						if (item.getEnchantmentLevel(enc)>enc.getMaxLevel()) {
							item.removeEnchantment(enc);
							item.addEnchantment(enc, enc.getMaxLevel());
						}
					}
					inv.setItem(a, item);
				}
				a += 1;
				
			
			}
			
		}
	}
	@EventHandler
	public void chestCheck(InventoryOpenEvent event) {
		System.out.println("OpenInventoryEvent");
		Inventory inv = event.getInventory();
		int a = 0;
		System.out.println("Slot Count:" + inv.getSize());
		while(!(a == inv.getSize())) {
			System.out.println("Start Checking");
			
			System.out.println("Checking Item: " + a);
			if(!(inv.getItem(a).equals(null))) {
				
				int max = inv.getItem(a).getMaxStackSize();
				ItemStack item = inv.getItem(a);
				System.out.println("Item Max Stack:" + max + ",Current Amount:" + item.getAmount());
				
				if(item.getAmount()>max) {
					System.out.println("Set Amount To:" + max);
					item.setAmount(max);
					
				}
				for(Enchantment enc : item.getEnchantments().keySet()) {
					if(inv.getSize() != 5) {
						if (item.getEnchantmentLevel(enc)>enc.getMaxLevel()) {
							item.removeEnchantment(enc);
							item.addEnchantment(enc, enc.getMaxLevel());
						}
					}
				}
				inv.setItem(a, item);
				System.out.println("Item Saved!");
				a += 1;
			}
			
		
		}
	}
}
	
	
