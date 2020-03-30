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
		if(event.getDamager() instanceof Player) {
			Player hitter = (Player) event.getDamager();
			Inventory inv = hitter.getInventory();
			int a = 0;
			while(a == inv.getSize()) {
				a += 1;
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
				
			
			}
			
		}
	}
	@EventHandler
	public void chestCheck(InventoryOpenEvent event) {
		Inventory inv = event.getInventory();
		int a = 0;
		while(a == inv.getSize()) {
			a += 1;
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
			
		
		}
	}
}
	
	
