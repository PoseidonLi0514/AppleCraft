package cn.acraft.applecraft.ATool;

import cn.acraft.applecraft.AItemGroup;
import cn.acraft.applecraft.Applecraft;
import cn.acraft.applecraft.NetheriteAppleAxe;
import cn.acraft.applecraft.Tool_Material;
import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import org.lwjgl.system.CallbackI;


public class ATools implements ModInitializer {
    public static final SwordItem NETHERITE_APPLE_SWORD = new SwordItem(Tool_Material.NETHERITE_APPLE,30, 20, new Item.Settings().fireproof().group(AItemGroup.APPLE_GROUP));
    public static final NetheriteAppleAxe NETHERITE_APPLE_AXE = new NetheriteAppleAxe(Tool_Material.NETHERITE_APPLE, 15, 5, new Item.Settings().fireproof().group(AItemGroup.APPLE_GROUP));
    public static final ShovelItem NETHERITE_APPLE_SHOVEL = new ShovelItem(Tool_Material.NETHERITE_APPLE, 2, 3, new Item.Settings().fireproof().group(AItemGroup.APPLE_GROUP));
    public void onInitialize() {
    }
}
