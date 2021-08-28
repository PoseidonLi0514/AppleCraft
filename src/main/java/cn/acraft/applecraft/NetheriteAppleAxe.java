package cn.acraft.applecraft;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

import java.util.List;

public class NetheriteAppleAxe extends CustomAxeItem{
    public NetheriteAppleAxe(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(new TranslatableText("item.apple_craft.netherite_apple_axe.tooltip"));
    }
}
