package pl.inh.bottleExp.listeners;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import net.kyori.adventure.text.Component;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerInteractListener implements Listener {
  @EventHandler
  public void onPlayerInteract(PlayerInteractEvent e) {
    if (!(e.getAction() == Action.RIGHT_CLICK_AIR ||
        e.getAction() == Action.RIGHT_CLICK_BLOCK &&
        Objects.equals(e.getItem(), Material.GLASS_BOTTLE))) {
      return;
    }

    e.setCancelled(true);

    Player p = e.getPlayer();
    float playerExp = p.getExp();




    if (p.getInventory().firstEmpty() != -1) {
      ItemStack item = new ItemStack(Material.EXPERIENCE_BOTTLE, 1);
      ItemMeta meta = item.getItemMeta();

      meta.setDisplayName("§bBottled Exp");
      meta.setLore(Collections.singletonList("§7This bottle contains §b" + playerExp + "§7 exp"));

      item.setItemMeta(meta);

      p.getInventory().addItem(item);

      p.setExp(0);
    }
  }

}
