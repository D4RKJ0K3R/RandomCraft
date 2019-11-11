package org.coderandom.random_craft.skulls;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.coderandom.random_craft.RandomCraft;

public class SkullsManager implements Listener {

    public SkullsManager() {
        RandomCraft.add(this);
    }

    public static ItemStack newSkull(EntityType type) {
        ItemStack skull;

        switch (type) {
            case ENDERMITE:
                skull = newSkull("5a1a0831aa03afb4212adcbb24e5dfaa7f476a1173fce259ef75a85855", "Endermite");
                break;
            case RABBIT:
                skull = newSkull("ffecc6b5e6ea5ced74c46e7627be3f0826327fba26386c6cc7863372e9bc", "Rabbit Head");
                break;
            case ZOMBIE:
                return new ItemStack(Material.ZOMBIE_HEAD);
            case WITHER_SKELETON:
                return new ItemStack(Material.WITHER_SKELETON_SKULL);
            case CREEPER:
                return new ItemStack(Material.CREEPER_HEAD);
            case SKELETON:
                return new ItemStack(Material.SKELETON_SKULL);
            case SNOWMAN:
                skull = new ItemStack(Material.PUMPKIN);
                ItemMeta meta = skull.getItemMeta();
                meta.setDisplayName("Snow Golem Head");
                skull.setItemMeta(meta);
                return skull;
            case IRON_GOLEM:
                skull = newSkull("b69d0d4711153a089c5567a749b27879c769d3bdcea6fda9d6f66e93dd8c4512", "Iron Golem Head");
                break;
            case BAT:
                skull = newSkull("9e99deef919db66ac2bd28d6302756ccd57c7f8b12b9dca8f41c3e0a04ac1cc", "Bat Head");
                break;
            case CAT:
                skull = newSkull("e4b45cbaa19fe3d68c856cd3846c03b5f59de81a480eec921ab4fa3cd81317", "Cat Head");
                break;
            case CHICKEN:
                skull = newSkull("1638469a599ceef7207537603248a9ab11ff591fd378bea4735b346a7fae893", "Chicken Head");
                break;
            case COD:
                skull = newSkull("7892d7dd6aadf35f86da27fb63da4edda211df96d2829f691462a4fb1cab0", "Cod Head");
                break;
            case COW:
                skull = newSkull("5d6c6eda942f7f5f71c3161c7306f4aed307d82895f9d2b07ab4525718edc5", "Cow Head");
                break;
            case FOX:
                skull = newSkull("d8954a42e69e0881ae6d24d4281459c144a0d5a968aed35d6d3d73a3c65d26a", "Fox Head");
                break;
            case HORSE:
                skull = newSkull("42eb967ab94fdd41a6325f1277d6dc019226e5cf34977eee69597fafcf5e", "Horse Head");
                break;
            case MUSHROOM_COW:
                skull = newSkull("d0bc61b9757a7b83e03cd2507a2157913c2cf016e7c096a4d6cf1fe1b8db", "Mooshroom Cow Head");
                break;
            case OCELOT:
                skull = newSkull("5657cd5c2989ff97570fec4ddcdc6926a68a3393250c1be1f0b114a1db1", "Ocelot Head");
                break;
            case PARROT:
                skull = newSkull("a4ba8d66fecb1992e94b8687d6ab4a5320ab7594ac194a2615ed4df818edbc3", "Parrot Head");
                break;
            case PIG:
                skull = newSkull("621668ef7cb79dd9c22ce3d1f3f4cb6e2559893b6df4a469514e667c16aa4", "Pig Head");
                break;
            case SALMON:
                skull = newSkull("8aeb21a25e46806ce8537fbd6668281cf176ceafe95af90e94a5fd84924878", "Salmon Head");
                break;
            case SHEEP:
                skull = newSkull("f31f9ccc6b3e32ecf13b8a11ac29cd33d18c95fc73db8a66c5d657ccb8be70", "Sheep Head");
                break;
            case SQUID:
                skull = newSkull("01433be242366af126da434b8735df1eb5b3cb2cede39145974e9c483607bac", "Squid Head");
                break;
            case TROPICAL_FISH:
                skull = newSkull("d6dd5e6addb56acbc694ea4ba5923b1b25688178feffa72290299e2505c97281", "Tropical Fish Head");
                break;
            case TURTLE:
                skull = newSkull("0a4050e7aacc4539202658fdc339dd182d7e322f9fbcc4d5f99b5718a", "Turtle Head");
                break;
            case VILLAGER:
                int random = RandomCraft.getRandom(0, 10);

                switch (random) {
                    case 0:
                        skull = newSkull("59718464dab049c0648a7160c6e34f3752237cc19a19cc72d0401b517f6c24", "Villager Head");
                        break;
                    case 1:
                        skull = newSkull("e62b938d77569811c50a5dea451cb35ace98effa528de6126d73d09040985b", "Villager Magician Head");
                        break;
                    case 2:
                        skull = newSkull("fe65516d81ac963dbc2485138dddcf943d7f7211e37efecd5a5fb8f5ad4920", "Villager Professor Head");
                        break;
                    case 3:
                        skull = newSkull("29251e18657e7304eaceac5f8d446d248ea46af2eab145f8185cece779f1648", "Villager King Head");
                        break;
                    case 4:
                        skull = newSkull("c9627be62ced7141139d3f155790a5d4356eb7b9ee95e504b3322974cbc515ea", "Villager Miner Head");
                        break;
                    case 5:
                        skull = newSkull("938acff3711433f6e33dfde45e8040b9b56d3436c5c8b4c70f44ebba35d60bcd", "Villager Baker Head");
                        break;
                    default:
                        skull = newSkull("822d8e751c8f2fd4c8942c44bdb2f5ca4d8ae8e575ed3eb34c18a86e93b", "Villager Head");
                        break;
                }
                break;
            case WANDERING_TRADER:
                skull = newSkull("5f1379a82290d7abe1efaabbc70710ff2ec02dd34ade386bc00c930c461cf932", "Wandering Trader Head");
                break;
            case PUFFERFISH:
                skull = newSkull("17152876bc3a96dd2a2299245edb3beef647c8a56ac8853a687c3e7b5d8bb", "Puffer Fish Head");
                break;
            case DOLPHIN:
                skull = newSkull("8e9688b950d880b55b7aa2cfcd76e5a0fa94aac6d16f78e833f7443ea29fed3", "Dolphin Head");
                break;
            case LLAMA:
                skull = newSkull("c2b1ecff77ffe3b503c30a548eb23a1a08fa26fd67cdff389855d74921368", "Llama Head");
                break;
            case PANDA:
                skull = newSkull("df00858926cd8cdf3f1cf71e210cde5daf8708320547bd6df5795859c68d9b3f", "Panda Head");
                break;
            case TRADER_LLAMA:
                skull = newSkull("8424780b3c5c5351cf49fb5bf41fcb289491df6c430683c84d7846188db4f84d", "Trader Llama Head");
                break;
            case WOLF:
                skull = newSkull("69d1d3113ec43ac2961dd59f28175fb4718873c6c448dfca8722317d67", "Wolf Head");
                break;
            case CAVE_SPIDER:
                skull = newSkull("41645dfd77d09923107b3496e94eeb5c30329f97efc96ed76e226e98224", "Cave Spider Head");
                break;
            case ENDERMAN:
                skull = newSkull("7a59bb0a7a32965b3d90d8eafa899d1835f424509eadd4e6b709ada50b9cf", "Enderman Head");
                break;
            case SPIDER:
                skull = newSkull("cd541541daaff50896cd258bdbdd4cf80c3ba816735726078bfe393927e57f1", "Spider Head");
                break;
            case PIG_ZOMBIE:
                skull = newSkull("74e9c6e98582ffd8ff8feb3322cd1849c43fb16b158abb11ca7b42eda7743eb", "Zombie Pigman Head");
                break;
            case BLAZE:
                skull = newSkull("b78ef2e4cf2c41a2d14bfde9caff10219f5b1bf5b35a49eb51c6467882cb5f0", "Blaze Head");
                break;
            case DROWNED:
                skull = newSkull("c3f7ccf61dbc3f9fe9a6333cde0c0e14399eb2eea71d34cf223b3ace22051", "Drowned Head");
                break;
            case ELDER_GUARDIAN:
                skull = newSkull("1c797482a14bfcb877257cb2cff1b6e6a8b8413336ffb4c29a6139278b436b", "Elder Guardian Head");
                break;
            case EVOKER:
                skull = newSkull("d954135dc82213978db478778ae1213591b93d228d36dd54f1ea1da48e7cba6", "Evoker Head");
                break;
            case GHAST:
                skull = newSkull("8b6a72138d69fbbd2fea3fa251cabd87152e4f1c97e5f986bf685571db3cc0", "Ghast Head");
                break;
            case GUARDIAN:
                skull = newSkull("a0bf34a71e7715b6ba52d5dd1bae5cb85f773dc9b0d457b4bfc5f9dd3cc7c94", "Guardian Head");
                break;
            case HUSK:
                skull = newSkull("d674c63c8db5f4ca628d69a3b1f8a36e29d8fd775e1a6bdb6cabb4be4db121", "Husk Head");
                break;
            case MAGMA_CUBE:
                skull = newSkull("38957d5023c937c4c41aa2412d43410bda23cf79a9f6ab36b76fef2d7c429", "Magma Cube Head");
                break;
            case PHANTOM:
                skull = newSkull("746830da5f83a3aaed838a99156ad781a789cfcf13e25beef7f54a86e4fa4", "Phantom Head");
                break;
            case PILLAGER:
                skull = newSkull("4aee6bb37cbfc92b0d86db5ada4790c64ff4468d68b84942fde04405e8ef5333", "Pillager Head");
                break;
            case RAVAGER:
                skull = newSkull("cd20bf52ec390a0799299184fc678bf84cf732bb1bd78fd1c4b441858f0235a8", "Ravager Head");
                break;
            case SHULKER:
                skull = newSkull("b1d3534d21fe8499262de87affbeac4d25ffde35c8bdca069e61e1787ff2f", "Shulker Head");
                break;
            case SLIME:
                skull = newSkull("895aeec6b842ada8669f846d65bc49762597824ab944f22f45bf3bbb941abe6c", "Slime Head");
                break;
            case STRAY:
                skull = newSkull("2c5097916bc0565d30601c0eebfeb287277a34e867b4ea43c63819d53e89ede7", "Stray Head");
                break;
            case VEX:
                skull = newSkull("c2ec5a516617ff1573cd2f9d5f3969f56d5575c4ff4efefabd2a18dc7ab98cd", "Vex Head");
                break;
            case VINDICATOR:
                skull = newSkull("4f6fb89d1c631bd7e79fe185ba1a6705425f5c31a5ff626521e395d4a6f7e2", "Vindicator Head");
                break;
            case WITCH:
                skull = newSkull("20e13d18474fc94ed55aeb7069566e4687d773dac16f4c3f8722fc95bf9f2dfa", "Witch Head");
                break;
            case ZOMBIE_VILLAGER:
                skull = newSkull("c45c11e0327035649ca0600ef938900e25fd1e38017422bc9740e4cda2cba892", "Zombie Villager Head");
                break;
            case ENDER_DRAGON:
                return skull = new ItemStack(Material.DRAGON_HEAD);
            default:
                return null;
        }

        return skull;
    }

    @EventHandler
    private void onEntityKilled(EntityDeathEvent event) {
        int playerHeadChance = RandomCraft.getConfiguration().getInt("Player Head Drop Chance");
        int mobHeadChance = RandomCraft.getConfiguration().getInt("Mob Head Drop Chance");
        int random = RandomCraft.getRandom(0, 100);

        LivingEntity entity = event.getEntity();

        if (entity.getKiller() != null) {
            ItemStack head = null;

            if (entity instanceof Player) {
                if (random <= playerHeadChance) {
                    head = new ItemStack(Material.PLAYER_HEAD);
                    SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
                    skullMeta.setOwningPlayer(Bukkit.getOfflinePlayer(entity.getUniqueId()));
                    head.setItemMeta(skullMeta);
                }
            } else if (random <= mobHeadChance) {
                head = newSkull(entity.getType());
            }

            if (head != null) {
                event.getDrops().add(head);
            }


        }
    }

    private static ItemStack newSkull(String urlID, String name) {
        return RandomCraft.getNms().getSkull(urlID, name);
    }
}
