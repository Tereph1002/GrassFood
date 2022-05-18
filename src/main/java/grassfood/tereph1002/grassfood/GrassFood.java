package grassfood.tereph1002.grassfood;

import org.bukkit.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;

public final class GrassFood extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        getLogger().info(ChatColor.GREEN + "GrassFoodが有効になりました");
    }

    @Override
    public void onDisable() {
        getLogger().warning(ChatColor.YELLOW + "GrassFoodが無効になりました");
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        try {
            if (event.getBlock().getType() == Material.GRASS_BLOCK) {
                event.getBlockPlaced().setType(Material.DIRT);
                Random rand = new Random();
                if(rand.nextInt(500) == 5) {
                    event.getPlayer().sendMessage(ChatColor.GREEN + "虫ｳﾒｪwwwwww");
                    event.getPlayer().setFoodLevel(event.getPlayer().getFoodLevel() + 3);
                } else {
                    event.getPlayer().sendMessage(ChatColor.GREEN + "草ｳﾒｪwwwwww");
                    event.getPlayer().setFoodLevel(event.getPlayer().getFoodLevel() + 1);
                }
                Location playerLocate = event.getPlayer().getLocation();
                playerLocate.getWorld().playSound(playerLocate, Sound.BLOCK_ROOTED_DIRT_PLACE, 1, 1);
            }
        } catch(NullPointerException e) {
            return;
        }
    }
}
