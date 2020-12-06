package cn.acraft.applecraft;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class Tool_Material implements ToolMaterial {
    @Override
    public int getDurability() {
        return 232333;//耐久
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 20.0F;//马巨额速度
    }

    @Override
    public float getAttackDamage() {
        return 50.0F;//伤害
    }

    @Override
    public int getMiningLevel() {
        return 4;//没写，不知道写啥
    }

    @Override
    public int getEnchantability() {
        return 2;//没写，不知道写啥
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Applecraft.NETHERITE_APPLE);//没写，不知道写啥
    }
}
