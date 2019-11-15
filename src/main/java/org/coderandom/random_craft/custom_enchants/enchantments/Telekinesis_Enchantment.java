package org.coderandom.random_craft.custom_enchants.enchantments;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.coderandom.random_craft.RandomCraft;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;
import org.coderandom.random_craft.custom_enchants.CustomWrapper;
import org.coderandom.random_craft.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Telekinesis_Enchantment extends CustomWrapper {
    private static List<UUID> worldBuffer;
    private static List<Double> xBuffer;
    private static List<Double> yBuffer;
    private static List<Double> zBuffer;

    public Telekinesis_Enchantment() {
        super("telekinesis", EnchantmentTarget.TOOL, EnchantmentTarget.WEAPON, EnchantmentTarget.BOW, EnchantmentTarget.CROSSBOW);
        CustomEnchants.register(this);
        worldBuffer = new ArrayList<>();
        xBuffer = new ArrayList<>();
        yBuffer = new ArrayList<>();
        zBuffer = new ArrayList<>();
    }

    @Override
    public String getName() {
        return  "Telekinesis";
    }

    private void addToBuffer(Location location) {
        boolean isReverse = false;
        worldBuffer.add(location.getWorld().getUID());

        for (int i = 0; i <= 3; i++) {
            if (isReverse) {
                xBuffer.add(location.getX() + i);
                yBuffer.add(location.getY() + i);
                zBuffer.add(location.getZ() + i);
            } else {
                xBuffer.add(location.getX() - i);
                yBuffer.add(location.getY() - i);
                zBuffer.add(location.getZ() - i);
            }

            if (i == 3 && !isReverse) {
                isReverse = true;
                i = -1;
            }
        }

        new BukkitRunnable(){
            @Override
            public void run() {
                worldBuffer.remove(location.getWorld().getUID());
                boolean isReverse = false;

                for (int i = 0; i <= 3; i++) {
                    if (isReverse) {
                        xBuffer.remove(location.getX() + i);
                        yBuffer.remove(location.getY() + i);
                        zBuffer.remove(location.getZ() + i);
                    } else {
                        xBuffer.remove(location.getX() - i);
                        yBuffer.remove(location.getY() - i);
                        zBuffer.remove(location.getZ() - i);
                    }

                    if (i == 3 && !isReverse) {
                        isReverse = true;
                        i = -1;
                    }
                }
            }
        }.runTaskLaterAsynchronously(RandomCraft.getInstance(), 100);
    }

    @EventHandler
    public void event(BlockBreakEvent event) {
        if (!event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.AIR) && !event.getBlock().getType().equals(Material.SPAWNER)) {
            ItemStack tool = event.getPlayer().getInventory().getItemInMainHand();

            if (CustomEnchants.canUseEnchant(tool, this)) {

                if (event.isDropItems()) {
                    Player player = event.getPlayer();
                    event.setDropItems(false);

                    if (CustomEnchants.hasEnchantment(tool, SILK_TOUCH)) {
                        event.setExpToDrop(0);

                        if (Utils.emptySlots(player) > 0) {
                            player.getInventory().addItem(new ItemStack(event.getBlock().getType()));
                        } else {
                            player.getWorld().dropItemNaturally(player.getLocation(), new ItemStack(event.getBlock().getType()));
                        }
                        return;
                    }


                    if (event.getExpToDrop() > 0) {
                        if (CustomEnchants.hasMending(player)) {
                            ExperienceOrb orb = (ExperienceOrb) player.getWorld().spawnEntity(player.getLocation(), EntityType.EXPERIENCE_ORB);
                            orb.setExperience(event.getExpToDrop());
                        } else {
                            player.giveExp(event.getExpToDrop());
                        }
                        event.setExpToDrop(0);
                        player.getWorld().playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                    }
                    event.getBlock().getDrops().forEach(drop -> {
                        if (Utils.emptySlots(player) > 0) {
                            player.getInventory().addItem(drop);
                        } else {
                            player.getWorld().dropItemNaturally(player.getLocation(), drop);
                        }
                    });
                }
            }
        }
    }

    @EventHandler
    public void event(EntityDeathEvent event) {
        if (event.getEntity().getKiller() != null) {
            Player player = event.getEntity().getKiller();

            if (!event.getEntity().getKiller().getInventory().getItemInMainHand().getType().equals(Material.AIR)) {
                ItemStack tool = player.getInventory().getItemInMainHand();

                if (CustomEnchants.hasEnchantment(tool, this)) {
                    if (event.getDrops().size() > 0) {

                        if (event.getDroppedExp() > 0) {
                            if (CustomEnchants.hasMending(player)) {
                                ExperienceOrb orb = (ExperienceOrb) player.getWorld().spawnEntity(player.getLocation(), EntityType.EXPERIENCE_ORB);
                                orb.setExperience(event.getDroppedExp());
                            } else {
                                player.giveExp(event.getDroppedExp());
                            }
                            event.setDroppedExp(0);
                            player.getWorld().playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                        }

                        event.getDrops().forEach(drop -> {
                            if (Utils.emptySlots(player) > 0) {
                                player.getInventory().addItem(drop);
                            } else {
                                player.getWorld().dropItemNaturally(player.getLocation(), drop);
                            }
                        });
                    }
                    addToBuffer(event.getEntity().getLocation());
                }
            }
        }
    }

    @EventHandler
    public void event(ItemSpawnEvent event) {
        Location location = event.getLocation();
        double x = location.getX();
        double y = location.getY();
        double z = location.getZ();

        if (xBuffer.contains(x) && yBuffer.contains(y) && zBuffer.contains(z) && worldBuffer.contains(location.getWorld().getUID())) {
            event.setCancelled(true);
        }
    }
}
