package pl.inh.bottleExp.listeners;

import java.util.List;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerRightClickListener implements Listener {

  @EventHandler
  public void onPlayerRightClick(PlayerInteractEvent e) {
    Player p = e.getPlayer();
    if(!(e.getAction() == Action.RIGHT_CLICK_BLOCK ||
        e.getAction() == Action.RIGHT_CLICK_AIR &&
            e.getItem().getType() == Material.EXPERIENCE_BOTTLE &&
            e.getItem().getItemMeta().hasLore())) {
      return;
    }

    ItemMeta meta = e.getItem().getItemMeta();

    List<String> lore = meta.getLore();
    for (String l : lore) {
      if (l.contains("This bottle")) {
        Integer.parseInt(l);
      }
    }

    e.getItem().setAmount(e.getItem().getAmount() - 1);

  }

}
