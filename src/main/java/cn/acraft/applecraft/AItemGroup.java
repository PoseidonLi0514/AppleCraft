package cn.acraft.applecraft;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class AItemGroup implements ModInitializer {
    @Override
    public void onInitialize() {
    }
    public static final ItemGroup APPLE_GROUP = FabricItemGroupBuilder.create(
            new Identifier("apple_craft", "apple"))
            .icon(() -> new ItemStack(Applecraft.NETHERITE_APPLE))
            .build();
    public static final ItemGroup ABLOCK_GROUP = FabricItemGroupBuilder.create(
            new Identifier("apple_craft", "block"))
            .icon(() -> new ItemStack(Applecraft.SUGAR_ORE))
            .build();
}
