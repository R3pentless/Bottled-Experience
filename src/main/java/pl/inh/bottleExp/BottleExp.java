package pl.inh.bottleExp;

import java.util.logging.Logger;
import org.bukkit.plugin.java.JavaPlugin;
import pl.inh.bottleExp.listeners.PlayerInteractListener;
import pl.inh.bottleExp.listeners.PlayerRightClickListener;

public class BottleExp extends JavaPlugin {
  Logger logger;

  @Override
  public void onEnable() {
    logger = getLogger();
    
    getServer().getPluginManager().registerEvents(new PlayerInteractListener(), this);
    getServer().getPluginManager().registerEvents(new PlayerRightClickListener(), this);

    logger.info("enabled");
  }

  @Override
  public void onDisable() {
    logger.info("disabled");
  }

}
