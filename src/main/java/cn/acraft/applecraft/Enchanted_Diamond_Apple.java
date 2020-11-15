package cn.acraft.applecraft;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

import java.util.List;

public class Enchanted_Diamond_Apple extends Item {

    public Enchanted_Diamond_Apple(Settings settings) {
        super(settings);
    }
    public boolean hasGlint(ItemStack stack)
    {
        return true;
    }
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(new TranslatableText("item.apple_craft.enchanted_diamond_apple.tooltip"));
    }
}
