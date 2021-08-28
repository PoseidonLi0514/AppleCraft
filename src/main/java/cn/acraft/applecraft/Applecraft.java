package cn.acraft.applecraft;

import cn.acraft.applecraft.ABlock.ABlocks;
import cn.acraft.applecraft.ATool.ATools;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.fabricmc.fabric.api.tools.FabricToolTags;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import org.lwjgl.system.CallbackI;

public class Applecraft implements ModInitializer {
    public static final Item DIAMOND_APPLE = new Item(new Item.Settings()
            .rarity(Rarity.RARE)
            .food((new FoodComponent.Builder())
                    .hunger(10)
                    .saturationModifier(20F)
                    .alwaysEdible()
                    .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 2), 1.0F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200, 1), 1.0F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 3600,0), 1.0F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 3600, 0), 1.0F)
                    .build())
            .group(AItemGroup.APPLE_GROUP)
            .maxCount(64));//钻石苹果

    public static final Item NETHERITE_APPLE = new Item(new Item.Settings()
            .rarity(Rarity.RARE)
            .fireproof()
            .food((new FoodComponent.Builder())
                    .hunger(40)
                    .saturationModifier(20F)
                    .alwaysEdible()
                    .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 36000, 9), 1.0F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 36000, 5), 1.0F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 36000,1), 1.0F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 36000, 3), 1.0F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 36000, 2),1.0F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 36000, 5), 1.0F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 36000, 1),1.0F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 36000, 4), 1.0F)
                    .build())
            .group(AItemGroup.APPLE_GROUP));//下届合金苹果

    public static final gunpowderapple GUNPOWDER_APPLE = new gunpowderapple(new Item.Settings()
            .food(new FoodComponent.Builder()
                    .hunger(4)
                    .saturationModifier(1.2F)
                    .alwaysEdible()
                    .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,1800, 0),0.7F)
                    .build())
            .group(AItemGroup.APPLE_GROUP));//火药苹果

    public static final Item EMERALD_APPLE = new Item(new Item.Settings()
            //.rarity(Rarity.EPIC) 附魔苹果颜色
            .food(new FoodComponent.Builder()
                    .hunger(10)
                    .saturationModifier(5F)
                    .alwaysEdible()
                    .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 3600, 3), 1.0F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 1200, 1), 1.0F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 7200, 0), 1.0F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 7200, 1), 1.0F)
                    .build())
            .group(AItemGroup.APPLE_GROUP));//绿宝石苹果

    public static final Obsidian_Apple OBSIDIAN_APPLE = new Obsidian_Apple(new Item.Settings()
            .food(new FoodComponent.Builder()
                    .hunger(4)
                    .saturationModifier(1.2F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 4800, 1), 0.5F)
                    .build())
            .group(AItemGroup.APPLE_GROUP));//黑曜石苹果

    public static final Enchanted_Diamond_Apple ENCHANTED_DIAMOND_APPLE = new Enchanted_Diamond_Apple(new Item.Settings()
            .rarity(Rarity.EPIC)
            .food(new FoodComponent.Builder()
                    .hunger(40)
                    .saturationModifier(20.0F)
                    .build())
            .group(AItemGroup.APPLE_GROUP));//附魔钻石苹果 开发进度：未写效果

    public static final Item IRON_APPLE = new Item(new Item.Settings()
            .food(new FoodComponent.Builder()
                    .hunger(6)
                    .saturationModifier(6.5F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 600, 0), 0.5F)
                    .build())
            .group(AItemGroup.APPLE_GROUP));


    public static final BlockOre SUGAR_ORE = new BlockOre(FabricBlockSettings.of(Material.STONE).strength(3, 3).lightLevel(0).breakByTool(FabricToolTags.PICKAXES, 2));
    public static final BlockOre APPLE_ORE  = new BlockOre(FabricBlockSettings.of(Material.STONE).strength(3, 3).lightLevel(0).breakByTool(FabricToolTags.PICKAXES, 2).sounds(BlockSoundGroup.STONE));
    //创建矿石 上
    public static final Block SUGAR_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(5, 6).lightLevel(3).breakByTool(FabricToolTags.PICKAXES, 2));
    public static final Diamond_Apple_Block DIAMOND_APPLE_BLOCK = new Diamond_Apple_Block(FabricBlockSettings.of(Material.METAL).strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL).breakByTool(FabricToolTags.PICKAXES, 2));
    //创建方块 上
    public static final Item DIAMOND_STICK =
            new Item(new Item.Settings().group(AItemGroup.APPLE_GROUP));

    public static final Item NETHERITE_STICK = new Item(new Item.Settings().fireproof().group(AItemGroup.APPLE_GROUP));

    private static ConfiguredFeature<?, ?> ORE_SUGAR_OVERWORLD = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                    SUGAR_ORE.getDefaultState(),
                    6)) // vein size
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
                    0, // bottom offset
                    0, // min y level
                    40))) // max y level
            .spreadHorizontally()
            .repeat(9); // number of veins per chunk

    private static ConfiguredFeature<?, ?> ORE_APPLE_OVERWORLD = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                    APPLE_ORE.getDefaultState(),
                    10)) // vein size
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
                    0, // bottom offset
                    0, // min y level
                    100))) // max y level
            .spreadHorizontally()
            .repeat(10); // number of veins per chunk

    //创建工具
    public static final CustomPickaxeItem NETHERITE_APPLE_PICKAXE = new CustomPickaxeItem(Tool_Material.NETHERITE_APPLE,20, 20, new Item.Settings().fireproof().group(AItemGroup.APPLE_GROUP));

    @Override
    public void onInitialize() {
        //注册物品
        Registry.register(Registry.ITEM, new Identifier("apple_craft", "diamond_apple"), DIAMOND_APPLE);
        Registry.register(Registry.ITEM, new Identifier("apple_craft", "netherite_apple"), NETHERITE_APPLE);
        Registry.register(Registry.ITEM, new Identifier("apple_craft", "gunpowder_apple"), GUNPOWDER_APPLE);
        Registry.register(Registry.ITEM, new Identifier("apple_craft", "sugar_ore"), new BlockItem(SUGAR_ORE, new Item.Settings().group(AItemGroup.ABLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("apple_craft", "sugar_block"), new BlockItem(SUGAR_BLOCK, new Item.Settings().group(AItemGroup.ABLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("apple_craft", "emerald_apple_block"), new BlockItem(ABlocks.EMERALD_APPLE_BLOCK, new Item.Settings().group(AItemGroup.ABLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("apple_craft", "diamond_apple_block"), new BlockItem(DIAMOND_APPLE_BLOCK, new Item.Settings().group(AItemGroup.ABLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("apple_craft", "emerald_apple"), EMERALD_APPLE);
        Registry.register(Registry.ITEM, new Identifier("apple_craft", "apple_ore"), new BlockItem(APPLE_ORE, new Item.Settings().group(AItemGroup.ABLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("apple_craft", "obsidian_apple"), OBSIDIAN_APPLE);
        Registry.register(Registry.ITEM, new Identifier("apple_craft", "enchanted_diamond_apple"), ENCHANTED_DIAMOND_APPLE);
        Registry.register(Registry.ITEM, new Identifier("apple_craft", "iron_apple"), IRON_APPLE);
        Registry.register(Registry.BLOCK, new Identifier("apple_craft", "sugar_ore"), SUGAR_ORE);
        Registry.register(Registry.BLOCK, new Identifier("apple_craft", "sugar_block"), SUGAR_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier("apple_craft", "diamond_apple_block"), DIAMOND_APPLE_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier("apple_craft", "emerald_apple_block"), ABlocks.EMERALD_APPLE_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier("apple_craft", "apple_ore"), APPLE_ORE);
        Registry.register(Registry.ITEM, new Identifier("apple_craft", "netherite_apple_pickaxe"), NETHERITE_APPLE_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("apple_craft","netherite_apple_sword"), ATools.NETHERITE_APPLE_SWORD);
        Registry.register(Registry.ITEM, new Identifier("apple_craft", "netherite_apple_axe"), ATools.NETHERITE_APPLE_AXE);
        Registry.register(Registry.ITEM, new Identifier("apple_craft", "netherite_apple_shovel"), ATools.NETHERITE_APPLE_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier("apple_craft", "netherite_stick"), NETHERITE_STICK);
        Registry.register(Registry.ITEM, new Identifier("apple_craft", "diamond_stick"), DIAMOND_STICK);
        //注册矿物
        RegistryKey<ConfiguredFeature<?, ?>> oreSugraOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN,
                new Identifier("apple_craft", "sugar_ore"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreSugraOverworld.getValue(), ORE_SUGAR_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreSugraOverworld);

        RegistryKey<ConfiguredFeature<?, ?>> oreAppleOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN,
                new Identifier("apple_craft", "apple_ore"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreAppleOverworld.getValue(), ORE_APPLE_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreAppleOverworld);
    }
}
