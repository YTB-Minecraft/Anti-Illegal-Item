package org.ytb.anarchy.anti_illegal;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class givekit implements CommandExecutor {


	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
			

			Enchantment ench = Enchantment.getByName("sharpness");
			ItemMeta meta = item.getItemMeta();
			item.addUnsafeEnchantment(ench, 32767);
			ench = Enchantment.getByName("unbreaking");
			item.addUnsafeEnchantment(ench, 32767);
			ench = Enchantment.getByName("knockback");
			item.addUnsafeEnchantment(ench, 10);
			ench = Enchantment.getByName("fire_aspect");
			item.addUnsafeEnchantment(ench, 32767);
			ench = Enchantment.getByName("looting");
			item.addUnsafeEnchantment(ench, 10);
			ench = Enchantment.getByName("sweeping");
			item.addUnsafeEnchantment(ench, 3);
			ench = Enchantment.getByName("vanishing_curse");
			item.addUnsafeEnchantment(ench, 1);
			ench = Enchantment.getByName("mending");
			item.addUnsafeEnchantment(ench, 1);
			item.setAmount(64);
			meta.setDisplayName("YTB's Stacked 32k");
			item.setItemMeta(meta);
			((Player) sender).getInventory().addItem(item);
			return true;
		}
		return false;
	}
}
