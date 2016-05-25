using System.Collections.Generic;
using System.Linq;

namespace SchematicExporter
{
    internal class IdMapper
    {
        public static IdMapper Instance = new IdMapper();

        public const string ClassBlocks = "Blocks";
        public const string ClassItems = "Items";
        public const string ClassPswm = "StarWarsMod";
        public const string ClassPswmItems = "StarWarsItems";
        public const string PkgMobs = "com.parzivail.pswm.mobs";
        public const string PkgTrooper = "com.parzivail.pswm.mobs.trooper";
        public const string PkgVehic = "com.parzivail.pswm.vehicles";

        /// <summary>
        /// The ID to Block dictionary
        /// </summary>
        private readonly Dictionary<int, Block> _blocks = new Dictionary<int, Block>();
        /// <summary>
        /// The ID to Items dictionary
        /// </summary>
        private readonly Dictionary<int, Item> _items = new Dictionary<int, Item>();
        /// <summary>
        /// The Entity to Association dictionary
        /// </summary>
        private readonly Dictionary<Entity, Item> _entityAssociations = new Dictionary<Entity, Item>();

        public IdMapper()
        {
            PopulateBlocks();
            PopulateItems();
            PopulateEntities();

            // TODO: make IDs pull from file and not hard-coded
        }

        /// <summary>
        /// Populates the entityAssociations dictionary
        /// </summary>
        private void PopulateEntities()
        {
            _entityAssociations.Clear();
            _entityAssociations.Add(new Entity("MobSandtrooper", PkgTrooper), GetItemFromName("sandtrooperHelmet"));
            _entityAssociations.Add(new Entity("MobStormtrooper", PkgTrooper), GetItemFromName("stormtrooperHelmet"));
            _entityAssociations.Add(new Entity("MobScouttrooper", PkgTrooper), GetItemFromName("scoutTrooperHelmet"));
            _entityAssociations.Add(new Entity("MobSnowtrooper", PkgTrooper), GetItemFromName("snowtrooperHelmet"));
            _entityAssociations.Add(new Entity("MobAtatPilot", PkgTrooper), GetItemFromName("atatPilotHelmet"));
            _entityAssociations.Add(new Entity("MobTiePilot", PkgTrooper), GetItemFromName("tiePilotHelmet"));
            _entityAssociations.Add(new Entity("MobEndorRebel", PkgTrooper), GetItemFromName("endorHelmet"));
            _entityAssociations.Add(new Entity("MobHothRebel", PkgTrooper), GetItemFromName("hothHelmet"));
            _entityAssociations.Add(new Entity("MobRebelPilot", PkgTrooper), GetItemFromName("rebelPilotHelmet"));
            _entityAssociations.Add(new Entity("MobBountyhunter", PkgTrooper), GetItemFromName("bobaHelmet"));
            _entityAssociations.Add(new Entity("MobWookiee", PkgMobs), GetItemFromName("bowcaster"));
            _entityAssociations.Add(new Entity("MobTusken", PkgMobs), GetItemFromName("gaffiStick"));
            _entityAssociations.Add(new Entity("MobJawa", PkgMobs), GetItemFromName("droidCaller"));
            _entityAssociations.Add(new Entity("MobEwok", PkgMobs), GetItemFromName("leaves"));
            _entityAssociations.Add(new Entity("MobTauntaun", PkgMobs), GetItemFromName("saddle"));
            _entityAssociations.Add(new Entity("MobBantha", PkgMobs), GetItemFromName("banthaHorn"));
            _entityAssociations.Add(new Entity("MobWampa", PkgMobs), GetItemFromName("stone")); // what for wampa?
            _entityAssociations.Add(new Entity("MobGamorrean", PkgMobs), GetItemFromName("gamorreanAx"));
            _entityAssociations.Add(new Entity("MobDewback", PkgMobs), GetItemFromName("dewbackRibs"));
            _entityAssociations.Add(new Entity("MobTatooineCommoner", PkgMobs), GetItemFromName("hyperdriveEarth"));
            _entityAssociations.Add(new Entity("MobBith", PkgMobs), GetItemFromName("recordCantina"));
            _entityAssociations.Add(new Entity("MobDroidAstromech", PkgMobs), GetItemFromName("spawnAstromech"));
            _entityAssociations.Add(new Entity("MobDroidAstromechImperial", PkgMobs), GetItemFromName("spawnAstromechImperial"));
            _entityAssociations.Add(new Entity("MobDroidAstromechImperial2", PkgMobs), GetItemFromName("spawnAstromechImperial2"));
            _entityAssociations.Add(new Entity("MobDroidAstromech2", PkgMobs), GetItemFromName("spawnAstromech2"));
            _entityAssociations.Add(new Entity("MobDroidAstromechBb8", PkgMobs), GetItemFromName("spawnAstromechBb8"));
            _entityAssociations.Add(new Entity("MobDroidProtocol", PkgMobs), GetItemFromName("spawnProtocol"));
            _entityAssociations.Add(new Entity("MobDroidProtocol2", PkgMobs), GetItemFromName("spawnProtocol2"));
            _entityAssociations.Add(new Entity("MobDroidProbe", PkgMobs), GetItemFromName("spawnProbe"));
            _entityAssociations.Add(new Entity("MobDroidGNK", PkgMobs), GetItemFromName("spawnGonk"));
            _entityAssociations.Add(new Entity("MobDroidSurgical", PkgMobs), GetItemFromName("spawnSurgical"));
            _entityAssociations.Add(new Entity("MobDroidMouse", PkgMobs), GetItemFromName("spawnSurgical"));
            _entityAssociations.Add(new Entity("VehicHothSpeederBike", PkgVehic), GetItemFromName("spawnHothSpeederBike"));
            _entityAssociations.Add(new Entity("VehicTIE", PkgVehic), GetItemFromName("spawnTIE"));
            _entityAssociations.Add(new Entity("VehicTIEInterceptor", PkgVehic), GetItemFromName("spawnTIEInterceptor"));
            _entityAssociations.Add(new Entity("VehicXWing", PkgVehic), GetItemFromName("spawnXWing"));
            _entityAssociations.Add(new Entity("VehicAWing", PkgVehic), GetItemFromName("spawnAWing"));
            _entityAssociations.Add(new Entity("VehicATST", PkgVehic), GetItemFromName("spawnAtst"));
            _entityAssociations.Add(new Entity("VehicSnowspeeder", PkgVehic), GetItemFromName("spawnSnowspeeder"));
            _entityAssociations.Add(new Entity("VehicSkyhopper", PkgVehic), GetItemFromName("spawnSkyhopper"));
            _entityAssociations.Add(new Entity("VehicSpeederBike", PkgVehic), GetItemFromName("spawnSpeederBike"));
            _entityAssociations.Add(new Entity("VehicLandspeeder", PkgVehic), GetItemFromName("spawnLandspeeder"));
            _entityAssociations.Add(new Entity("VehicJakkuSpeeder", PkgVehic), GetItemFromName("spawnJakkuSpeeder"));
        }

        /// <summary>
        /// Populates the items dictionary
        /// </summary>
        private void PopulateItems()
        {
            _items.Clear();
            _items.Add(1, new Item("stone", ClassItems));
            _items.Add(2, new Item("grass", ClassItems));
            _items.Add(3, new Item("dirt", ClassItems));
            _items.Add(4, new Item("cobblestone", ClassItems));
            _items.Add(5, new Item("planks", ClassItems));
            _items.Add(6, new Item("sapling", ClassItems));
            _items.Add(7, new Item("bedrock", ClassItems));
            _items.Add(8, new Item("flowing_water", ClassItems));
            _items.Add(9, new Item("water", ClassItems));
            _items.Add(10, new Item("flowing_lava", ClassItems));
            _items.Add(11, new Item("lava", ClassItems));
            _items.Add(12, new Item("sand", ClassItems));
            _items.Add(13, new Item("gravel", ClassItems));
            _items.Add(14, new Item("gold_ore", ClassItems));
            _items.Add(15, new Item("iron_ore", ClassItems));
            _items.Add(16, new Item("coal_ore", ClassItems));
            _items.Add(17, new Item("log", ClassItems));
            _items.Add(18, new Item("leaves", ClassItems));
            _items.Add(19, new Item("sponge", ClassItems));
            _items.Add(20, new Item("glass", ClassItems));
            _items.Add(21, new Item("lapis_ore", ClassItems));
            _items.Add(22, new Item("lapis_block", ClassItems));
            _items.Add(23, new Item("dispenser", ClassItems));
            _items.Add(24, new Item("sandstone", ClassItems));
            _items.Add(25, new Item("noteblock", ClassItems));
            _items.Add(27, new Item("golden_rail", ClassItems));
            _items.Add(28, new Item("detector_rail", ClassItems));
            _items.Add(29, new Item("sticky_piston", ClassItems));
            _items.Add(30, new Item("web", ClassItems));
            _items.Add(31, new Item("tallgrass", ClassItems));
            _items.Add(32, new Item("deadbush", ClassItems));
            _items.Add(33, new Item("piston", ClassItems));
            _items.Add(35, new Item("wool", ClassItems));
            _items.Add(37, new Item("yellow_flower", ClassItems));
            _items.Add(38, new Item("red_flower", ClassItems));
            _items.Add(39, new Item("brown_mushroom", ClassItems));
            _items.Add(40, new Item("red_mushroom", ClassItems));
            _items.Add(41, new Item("gold_block", ClassItems));
            _items.Add(42, new Item("iron_block", ClassItems));
            _items.Add(43, new Item("double_stone_slab", ClassItems));
            _items.Add(44, new Item("stone_slab", ClassItems));
            _items.Add(45, new Item("brick_block", ClassItems));
            _items.Add(46, new Item("tnt", ClassItems));
            _items.Add(47, new Item("bookshelf", ClassItems));
            _items.Add(48, new Item("mossy_cobblestone", ClassItems));
            _items.Add(49, new Item("obsidian", ClassItems));
            _items.Add(50, new Item("torch", ClassItems));
            _items.Add(51, new Item("fire", ClassItems));
            _items.Add(52, new Item("mob_spawner", ClassItems));
            _items.Add(53, new Item("oak_stairs", ClassItems));
            _items.Add(54, new Item("chest", ClassItems));
            _items.Add(56, new Item("diamond_ore", ClassItems));
            _items.Add(57, new Item("diamond_block", ClassItems));
            _items.Add(58, new Item("crafting_table", ClassItems));
            _items.Add(60, new Item("farmland", ClassItems));
            _items.Add(61, new Item("furnace", ClassItems));
            _items.Add(62, new Item("lit_furnace", ClassItems));
            _items.Add(65, new Item("ladder", ClassItems));
            _items.Add(66, new Item("rail", ClassItems));
            _items.Add(67, new Item("stone_stairs", ClassItems));
            _items.Add(69, new Item("lever", ClassItems));
            _items.Add(70, new Item("stone_pressure_plate", ClassItems));
            _items.Add(72, new Item("wooden_pressure_plate", ClassItems));
            _items.Add(73, new Item("redstone_ore", ClassItems));
            _items.Add(76, new Item("redstone_torch", ClassItems));
            _items.Add(77, new Item("stone_button", ClassItems));
            _items.Add(78, new Item("snow_layer", ClassItems));
            _items.Add(79, new Item("ice", ClassItems));
            _items.Add(80, new Item("snow", ClassItems));
            _items.Add(81, new Item("cactus", ClassItems));
            _items.Add(82, new Item("clay", ClassItems));
            _items.Add(84, new Item("jukebox", ClassItems));
            _items.Add(85, new Item("fence", ClassItems));
            _items.Add(86, new Item("pumpkin", ClassItems));
            _items.Add(87, new Item("netherrack", ClassItems));
            _items.Add(88, new Item("soul_sand", ClassItems));
            _items.Add(89, new Item("glowstone", ClassItems));
            _items.Add(90, new Item("portal", ClassItems));
            _items.Add(91, new Item("lit_pumpkin", ClassItems));
            _items.Add(95, new Item("stained_glass", ClassItems));
            _items.Add(96, new Item("trapdoor", ClassItems));
            _items.Add(97, new Item("monster_egg", ClassItems));
            _items.Add(98, new Item("stonebrick", ClassItems));
            _items.Add(99, new Item("brown_mushroom_block", ClassItems));
            _items.Add(100, new Item("red_mushroom_block", ClassItems));
            _items.Add(101, new Item("iron_bars", ClassItems));
            _items.Add(102, new Item("glass_pane", ClassItems));
            _items.Add(103, new Item("melon_block", ClassItems));
            _items.Add(106, new Item("vine", ClassItems));
            _items.Add(107, new Item("fence_gate", ClassItems));
            _items.Add(108, new Item("brick_stairs", ClassItems));
            _items.Add(109, new Item("stone_brick_stairs", ClassItems));
            _items.Add(110, new Item("mycelium", ClassItems));
            _items.Add(111, new Item("waterlily", ClassItems));
            _items.Add(112, new Item("nether_brick", ClassItems));
            _items.Add(113, new Item("nether_brick_fence", ClassItems));
            _items.Add(114, new Item("nether_brick_stairs", ClassItems));
            _items.Add(116, new Item("enchanting_table", ClassItems));
            _items.Add(119, new Item("end_portal", ClassItems));
            _items.Add(120, new Item("end_portal_frame", ClassItems));
            _items.Add(121, new Item("end_stone", ClassItems));
            _items.Add(122, new Item("dragon_egg", ClassItems));
            _items.Add(123, new Item("redstone_lamp", ClassItems));
            _items.Add(125, new Item("double_wooden_slab", ClassItems));
            _items.Add(126, new Item("wooden_slab", ClassItems));
            _items.Add(127, new Item("cocoa", ClassItems));
            _items.Add(128, new Item("sandstone_stairs", ClassItems));
            _items.Add(129, new Item("emerald_ore", ClassItems));
            _items.Add(130, new Item("ender_chest", ClassItems));
            _items.Add(131, new Item("tripwire_hook", ClassItems));
            _items.Add(133, new Item("emerald_block", ClassItems));
            _items.Add(134, new Item("spruce_stairs", ClassItems));
            _items.Add(135, new Item("birch_stairs", ClassItems));
            _items.Add(136, new Item("jungle_stairs", ClassItems));
            _items.Add(137, new Item("command_block", ClassItems));
            _items.Add(138, new Item("beacon", ClassItems));
            _items.Add(139, new Item("cobblestone_wall", ClassItems));
            _items.Add(141, new Item("carrots", ClassItems));
            _items.Add(142, new Item("potatoes", ClassItems));
            _items.Add(143, new Item("wooden_button", ClassItems));
            _items.Add(145, new Item("anvil", ClassItems));
            _items.Add(146, new Item("trapped_chest", ClassItems));
            _items.Add(147, new Item("light_weighted_pressure_plate", ClassItems));
            _items.Add(148, new Item("heavy_weighted_pressure_plate", ClassItems));
            _items.Add(151, new Item("daylight_detector", ClassItems));
            _items.Add(152, new Item("redstone_block", ClassItems));
            _items.Add(153, new Item("quartz_ore", ClassItems));
            _items.Add(154, new Item("hopper", ClassItems));
            _items.Add(155, new Item("quartz_block", ClassItems));
            _items.Add(156, new Item("quartz_stairs", ClassItems));
            _items.Add(157, new Item("activator_rail", ClassItems));
            _items.Add(158, new Item("dropper", ClassItems));
            _items.Add(159, new Item("stained_hardened_clay", ClassItems));
            _items.Add(160, new Item("stained_glass_pane", ClassItems));
            _items.Add(161, new Item("leaves2", ClassItems));
            _items.Add(162, new Item("log2", ClassItems));
            _items.Add(163, new Item("acacia_stairs", ClassItems));
            _items.Add(164, new Item("dark_oak_stairs", ClassItems));
            _items.Add(165, new Item("moistureVaporator", ClassPswm));
            _items.Add(166, new Item("chromiumOre", ClassPswm));
            _items.Add(167, new Item("titaniumOre", ClassPswm));
            _items.Add(168, new Item("titaniumChromiumBlock", ClassPswm));
            _items.Add(169, new Item("endorBaseWall", ClassPswm));
            _items.Add(170, new Item("hay_block", ClassItems));
            _items.Add(171, new Item("carpet", ClassItems));
            _items.Add(172, new Item("hardened_clay", ClassItems));
            _items.Add(173, new Item("coal_block", ClassItems));
            _items.Add(174, new Item("packed_ice", ClassItems));
            _items.Add(175, new Item("double_plant", ClassItems));
            _items.Add(178, new Item("endorBaseWallStairs", ClassPswm));
            _items.Add(179, new Item("tatooineSand", ClassPswm));
            _items.Add(180, new Item("table", ClassPswm));
            _items.Add(181, new Item("spaceLamp", ClassPswm));
            _items.Add(182, new Item("tatooineSandstone", ClassPswm));
            _items.Add(183, new Item("dagobahMud", ClassPswm));
            _items.Add(185, new Item("mudTable", ClassPswm));
            _items.Add(186, new Item("mudStairs", ClassPswm));
            _items.Add(187, new Item("hangingCauldron", ClassPswm));
            _items.Add(188, new Item("hangingBucket", ClassPswm));
            _items.Add(189, new Item("basket", ClassPswm));
            _items.Add(190, new Item("deathStarBlock", ClassPswm));
            _items.Add(191, new Item("deathStarLight", ClassPswm));
            _items.Add(192, new Item("deathStarGlass", ClassPswm));
            _items.Add(194, new Item("deathStarDoor", ClassPswm));
            _items.Add(196, new Item("fieldEmitter", ClassPswm));
            _items.Add(197, new Item("holoTable", ClassPswm));
            _items.Add(255, new Item("Tabula_TabulaRasa", "Tabula"));
            _items.Add(256, new Item("iron_shovel", ClassItems));
            _items.Add(257, new Item("iron_pickaxe", ClassItems));
            _items.Add(258, new Item("iron_axe", ClassItems));
            _items.Add(259, new Item("flint_and_steel", ClassItems));
            _items.Add(260, new Item("apple", ClassItems));
            _items.Add(261, new Item("bow", ClassItems));
            _items.Add(262, new Item("arrow", ClassItems));
            _items.Add(263, new Item("coal", ClassItems));
            _items.Add(264, new Item("diamond", ClassItems));
            _items.Add(265, new Item("iron_ingot", ClassItems));
            _items.Add(266, new Item("gold_ingot", ClassItems));
            _items.Add(267, new Item("iron_sword", ClassItems));
            _items.Add(268, new Item("wooden_sword", ClassItems));
            _items.Add(269, new Item("wooden_shovel", ClassItems));
            _items.Add(270, new Item("wooden_pickaxe", ClassItems));
            _items.Add(271, new Item("wooden_axe", ClassItems));
            _items.Add(272, new Item("stone_sword", ClassItems));
            _items.Add(273, new Item("stone_shovel", ClassItems));
            _items.Add(274, new Item("stone_pickaxe", ClassItems));
            _items.Add(275, new Item("stone_axe", ClassItems));
            _items.Add(276, new Item("diamond_sword", ClassItems));
            _items.Add(277, new Item("diamond_shovel", ClassItems));
            _items.Add(278, new Item("diamond_pickaxe", ClassItems));
            _items.Add(279, new Item("diamond_axe", ClassItems));
            _items.Add(280, new Item("stick", ClassItems));
            _items.Add(281, new Item("bowl", ClassItems));
            _items.Add(282, new Item("mushroom_stew", ClassItems));
            _items.Add(283, new Item("golden_sword", ClassItems));
            _items.Add(284, new Item("golden_shovel", ClassItems));
            _items.Add(285, new Item("golden_pickaxe", ClassItems));
            _items.Add(286, new Item("golden_axe", ClassItems));
            _items.Add(287, new Item("string", ClassItems));
            _items.Add(288, new Item("feather", ClassItems));
            _items.Add(289, new Item("gunpowder", ClassItems));
            _items.Add(290, new Item("wooden_hoe", ClassItems));
            _items.Add(291, new Item("stone_hoe", ClassItems));
            _items.Add(292, new Item("iron_hoe", ClassItems));
            _items.Add(293, new Item("diamond_hoe", ClassItems));
            _items.Add(294, new Item("golden_hoe", ClassItems));
            _items.Add(295, new Item("wheat_seeds", ClassItems));
            _items.Add(296, new Item("wheat", ClassItems));
            _items.Add(297, new Item("bread", ClassItems));
            _items.Add(298, new Item("leather_helmet", ClassItems));
            _items.Add(299, new Item("leather_chestplate", ClassItems));
            _items.Add(300, new Item("leather_leggings", ClassItems));
            _items.Add(301, new Item("leather_boots", ClassItems));
            _items.Add(302, new Item("chainmail_helmet", ClassItems));
            _items.Add(303, new Item("chainmail_chestplate", ClassItems));
            _items.Add(304, new Item("chainmail_leggings", ClassItems));
            _items.Add(305, new Item("chainmail_boots", ClassItems));
            _items.Add(306, new Item("iron_helmet", ClassItems));
            _items.Add(307, new Item("iron_chestplate", ClassItems));
            _items.Add(308, new Item("iron_leggings", ClassItems));
            _items.Add(309, new Item("iron_boots", ClassItems));
            _items.Add(310, new Item("diamond_helmet", ClassItems));
            _items.Add(311, new Item("diamond_chestplate", ClassItems));
            _items.Add(312, new Item("diamond_leggings", ClassItems));
            _items.Add(313, new Item("diamond_boots", ClassItems));
            _items.Add(314, new Item("golden_helmet", ClassItems));
            _items.Add(315, new Item("golden_chestplate", ClassItems));
            _items.Add(316, new Item("golden_leggings", ClassItems));
            _items.Add(317, new Item("golden_boots", ClassItems));
            _items.Add(318, new Item("flint", ClassItems));
            _items.Add(319, new Item("porkchop", ClassItems));
            _items.Add(320, new Item("cooked_porkchop", ClassItems));
            _items.Add(321, new Item("painting", ClassItems));
            _items.Add(322, new Item("golden_apple", ClassItems));
            _items.Add(323, new Item("sign", ClassItems));
            _items.Add(324, new Item("wooden_door", ClassItems));
            _items.Add(325, new Item("bucket", ClassItems));
            _items.Add(326, new Item("water_bucket", ClassItems));
            _items.Add(327, new Item("lava_bucket", ClassItems));
            _items.Add(328, new Item("minecart", ClassItems));
            _items.Add(329, new Item("saddle", ClassItems));
            _items.Add(330, new Item("iron_door", ClassItems));
            _items.Add(331, new Item("redstone", ClassItems));
            _items.Add(332, new Item("snowball", ClassItems));
            _items.Add(333, new Item("boat", ClassItems));
            _items.Add(334, new Item("leather", ClassItems));
            _items.Add(335, new Item("milk_bucket", ClassItems));
            _items.Add(336, new Item("brick", ClassItems));
            _items.Add(337, new Item("clay_ball", ClassItems));
            _items.Add(338, new Item("reeds", ClassItems));
            _items.Add(339, new Item("paper", ClassItems));
            _items.Add(340, new Item("book", ClassItems));
            _items.Add(341, new Item("slime_ball", ClassItems));
            _items.Add(342, new Item("chest_minecart", ClassItems));
            _items.Add(343, new Item("furnace_minecart", ClassItems));
            _items.Add(344, new Item("egg", ClassItems));
            _items.Add(345, new Item("compass", ClassItems));
            _items.Add(346, new Item("fishing_rod", ClassItems));
            _items.Add(347, new Item("clock", ClassItems));
            _items.Add(348, new Item("glowstone_dust", ClassItems));
            _items.Add(349, new Item("fish", ClassItems));
            _items.Add(350, new Item("cooked_fished", ClassItems));
            _items.Add(351, new Item("dye", ClassItems));
            _items.Add(352, new Item("bone", ClassItems));
            _items.Add(353, new Item("sugar", ClassItems));
            _items.Add(354, new Item("cake", ClassItems));
            _items.Add(355, new Item("bed", ClassItems));
            _items.Add(356, new Item("repeater", ClassItems));
            _items.Add(357, new Item("cookie", ClassItems));
            _items.Add(358, new Item("filled_map", ClassItems));
            _items.Add(359, new Item("shears", ClassItems));
            _items.Add(360, new Item("melon", ClassItems));
            _items.Add(361, new Item("pumpkin_seeds", ClassItems));
            _items.Add(362, new Item("melon_seeds", ClassItems));
            _items.Add(363, new Item("beef", ClassItems));
            _items.Add(364, new Item("cooked_beef", ClassItems));
            _items.Add(365, new Item("chicken", ClassItems));
            _items.Add(366, new Item("cooked_chicken", ClassItems));
            _items.Add(367, new Item("rotten_flesh", ClassItems));
            _items.Add(368, new Item("ender_pearl", ClassItems));
            _items.Add(369, new Item("blaze_rod", ClassItems));
            _items.Add(370, new Item("ghast_tear", ClassItems));
            _items.Add(371, new Item("gold_nugget", ClassItems));
            _items.Add(372, new Item("nether_wart", ClassItems));
            _items.Add(373, new Item("potion", ClassItems));
            _items.Add(374, new Item("glass_bottle", ClassItems));
            _items.Add(375, new Item("spider_eye", ClassItems));
            _items.Add(376, new Item("fermented_spider_eye", ClassItems));
            _items.Add(377, new Item("blaze_powder", ClassItems));
            _items.Add(378, new Item("magma_cream", ClassItems));
            _items.Add(379, new Item("brewing_stand", ClassItems));
            _items.Add(380, new Item("cauldron", ClassItems));
            _items.Add(381, new Item("ender_eye", ClassItems));
            _items.Add(382, new Item("speckled_melon", ClassItems));
            _items.Add(383, new Item("spawn_egg", ClassItems));
            _items.Add(384, new Item("experience_bottle", ClassItems));
            _items.Add(385, new Item("fire_charge", ClassItems));
            _items.Add(386, new Item("writable_book", ClassItems));
            _items.Add(387, new Item("written_book", ClassItems));
            _items.Add(388, new Item("emerald", ClassItems));
            _items.Add(389, new Item("item_frame", ClassItems));
            _items.Add(390, new Item("flower_pot", ClassItems));
            _items.Add(391, new Item("carrot", ClassItems));
            _items.Add(392, new Item("potato", ClassItems));
            _items.Add(393, new Item("baked_potato", ClassItems));
            _items.Add(394, new Item("poisonous_potato", ClassItems));
            _items.Add(395, new Item("map", ClassItems));
            _items.Add(396, new Item("golden_carrot", ClassItems));
            _items.Add(397, new Item("skull", ClassItems));
            _items.Add(398, new Item("carrot_on_a_stick", ClassItems));
            _items.Add(399, new Item("nether_star", ClassItems));
            _items.Add(400, new Item("pumpkin_pie", ClassItems));
            _items.Add(401, new Item("fireworks", ClassItems));
            _items.Add(402, new Item("firework_charge", ClassItems));
            _items.Add(403, new Item("enchanted_book", ClassItems));
            _items.Add(404, new Item("comparator", ClassItems));
            _items.Add(405, new Item("netherbrick", ClassItems));
            _items.Add(406, new Item("quartz", ClassItems));
            _items.Add(407, new Item("tnt_minecart", ClassItems));
            _items.Add(408, new Item("hopper_minecart", ClassItems));
            _items.Add(409, new Item("bactaTank", ClassPswm));
            _items.Add(417, new Item("iron_horse_armor", ClassItems));
            _items.Add(418, new Item("golden_horse_armor", ClassItems));
            _items.Add(419, new Item("diamond_horse_armor", ClassItems));
            _items.Add(420, new Item("lead", ClassItems));
            _items.Add(421, new Item("name_tag", ClassItems));
            _items.Add(422, new Item("command_block_minecart", ClassItems));
            _items.Add(423, new Item("blockBeneOre", ClassPswmItems));
            _items.Add(424, new Item("blockExoniumOre", ClassPswmItems));
            _items.Add(425, new Item("blockKeleriumOre", ClassPswmItems));
            _items.Add(426, new Item("blockIoniteOre", ClassPswmItems));
            _items.Add(427, new Item("blockCortosisOre", ClassPswmItems));
            _items.Add(428, new Item("blockHeliciteOre", ClassPswmItems));
            _items.Add(429, new Item("blockRubindumOre", ClassPswmItems));
            _items.Add(430, new Item("blockDolomiteOre", ClassPswmItems));
            _items.Add(431, new Item("blockTempleStone", ClassPswmItems));
            _items.Add(432, new Item("blockTempleStoneSlab", ClassPswmItems));
            _items.Add(433, new Item("blockTempleStoneLit", ClassPswmItems));
            _items.Add(434, new Item("blockTempleStoneSlabLit", ClassPswmItems));
            _items.Add(435, new Item("ancientJediStatue", ClassPswmItems));
            _items.Add(436, new Item("blockTempleStoneStairsBrick", ClassPswmItems));
            _items.Add(437, new Item("blockTempleStoneStairsSlabTopDark", ClassPswmItems));
            _items.Add(438, new Item("blockTempleStoneStairs", ClassPswmItems));
            _items.Add(439, new Item("blockTempleStoneStairsStabTop", ClassPswmItems));
            _items.Add(440, new Item("blockTempleStoneStairsFancy", ClassPswmItems));
            _items.Add(2256, new Item("record_13", ClassItems));
            _items.Add(2257, new Item("record_cat", ClassItems));
            _items.Add(2258, new Item("record_ITEMS", ClassItems));
            _items.Add(2259, new Item("record_chirp", ClassItems));
            _items.Add(2260, new Item("record_far", ClassItems));
            _items.Add(2261, new Item("record_mall", ClassItems));
            _items.Add(2262, new Item("record_mellohi", ClassItems));
            _items.Add(2263, new Item("record_stal", ClassItems));
            _items.Add(2264, new Item("record_strad", ClassItems));
            _items.Add(2265, new Item("record_ward", ClassItems));
            _items.Add(2266, new Item("record_11", ClassItems));
            _items.Add(2267, new Item("record_wait", ClassItems));
            _items.Add(4096, new Item("gaffiStick", ClassPswmItems));
            _items.Add(4098, new Item("blasterRifle", ClassPswmItems));
            _items.Add(4099, new Item("hiltMetalCompound", ClassPswmItems));
            _items.Add(4100, new Item("hiltMetalAlloy", ClassPswmItems));
            _items.Add(4101, new Item("plasmaEmitter", ClassPswmItems));
            _items.Add(4102, new Item("containmentField", ClassPswmItems));
            _items.Add(4103, new Item("lightsaberCrystal", ClassPswmItems));
            _items.Add(4105, new Item("banthaHorn", ClassPswmItems));
            _items.Add(4109, new Item("endorChest", ClassPswmItems));
            _items.Add(4110, new Item("endorHelmet", ClassPswmItems));
            _items.Add(4111, new Item("endorBoots", ClassPswmItems));
            _items.Add(4112, new Item("endorLegs", ClassPswmItems));
            _items.Add(4113, new Item("ewokSpear", ClassPswmItems));
            _items.Add(4114, new Item("chromiumDust", ClassPswmItems));
            _items.Add(4115, new Item("titaniumChromiumDust", ClassPswmItems));
            _items.Add(4116, new Item("titaniumChromiumIngot", ClassPswmItems));
            _items.Add(4117, new Item("titaniumDust", ClassPswmItems));
            _items.Add(4118, new Item("hyperdriveEngine", ClassPswmItems));
            _items.Add(4119, new Item("hyperdriveMotivator", ClassPswmItems));
            _items.Add(4120, new Item("hyperdriveTatooine", ClassPswmItems));
            _items.Add(4121, new Item("hyperdriveEarth", ClassPswmItems));
            _items.Add(4122, new Item("spawnSpeederBike", ClassPswmItems));
            _items.Add(4123, new Item("hyperdriveHoth", ClassPswmItems));
            _items.Add(4124, new Item("hyperdriveKashyyyk", ClassPswmItems));
            _items.Add(4125, new Item("spawnLandspeeder", ClassPswmItems));
            _items.Add(4126, new Item("hyperdriveYavinFour", ClassPswmItems));
            _items.Add(4127, new Item("hyperdriveEndor", ClassPswmItems));
            _items.Add(4128, new Item("rebelPilotLegs", ClassPswmItems));
            _items.Add(4129, new Item("rebelPilotChest", ClassPswmItems));
            _items.Add(4130, new Item("rebelPilotHelmet", ClassPswmItems));
            _items.Add(4131, new Item("rebelPilotBoots", ClassPswmItems));
            _items.Add(4132, new Item("blasterPistol", ClassPswmItems));
            _items.Add(4134, new Item("stormtrooperLegs", ClassPswmItems));
            _items.Add(4135, new Item("stormtrooperHelmet", ClassPswmItems));
            _items.Add(4136, new Item("stormtrooperBoots", ClassPswmItems));
            _items.Add(4137, new Item("stormtrooperChest", ClassPswmItems));
            _items.Add(4138, new Item("tiePilotBoots", ClassPswmItems));
            _items.Add(4139, new Item("tiePilotHelmet", ClassPswmItems));
            _items.Add(4140, new Item("tiePilotChest", ClassPswmItems));
            _items.Add(4141, new Item("tiePilotLegs", ClassPswmItems));
            _items.Add(4142, new Item("hothLegs", ClassPswmItems));
            _items.Add(4143, new Item("hothHelmet", ClassPswmItems));
            _items.Add(4144, new Item("hothChest", ClassPswmItems));
            _items.Add(4145, new Item("hothBoots", ClassPswmItems));
            _items.Add(4146, new Item("droidCaller", ClassPswmItems));
            _items.Add(4147, new Item("spawnAstromech", ClassPswmItems));
            _items.Add(4148, new Item("spawnProtocol", ClassPswmItems));
            _items.Add(4149, new Item("spawnGonk", ClassPswmItems));
            _items.Add(4150, new Item("bobaBoots", ClassPswmItems));
            _items.Add(4151, new Item("sandtrooperChest", ClassPswmItems));
            _items.Add(4152, new Item("sandtrooperLegs", ClassPswmItems));
            _items.Add(4153, new Item("sandtrooperBoots", ClassPswmItems));
            _items.Add(4154, new Item("bobaLegs", ClassPswmItems));
            _items.Add(4155, new Item("bobaChest", ClassPswmItems));
            _items.Add(4156, new Item("bobaJetpackChest", ClassPswmItems));
            _items.Add(4157, new Item("bobaHelmet", ClassPswmItems));
            _items.Add(4158, new Item("sandtrooperHelmet", ClassPswmItems));
            _items.Add(4159, new Item("bobaJetpack", ClassPswmItems));
            _items.Add(4160, new Item("gamorreanAx", ClassPswmItems));
            _items.Add(4161, new Item("bowcaster", ClassPswmItems));
            _items.Add(4162, new Item("blasterHeavy", ClassPswmItems));
            _items.Add(4163, new Item("scoutTrooperBoots", ClassPswmItems));
            _items.Add(4164, new Item("scoutTrooperLegs", ClassPswmItems));
            _items.Add(4165, new Item("scoutTrooperHelmet", ClassPswmItems));
            _items.Add(4166, new Item("scoutTrooperChest", ClassPswmItems));
            _items.Add(4167, new Item("snowtrooperHelmet", ClassPswmItems));
            _items.Add(4168, new Item("snowtrooperBoots", ClassPswmItems));
            _items.Add(4169, new Item("snowtrooperLegs", ClassPswmItems));
            _items.Add(4170, new Item("snowtrooperChest", ClassPswmItems));
            _items.Add(4171, new Item("debugLootGen", ClassPswmItems));
            _items.Add(4172, new Item("imperialCredit", ClassPswmItems));
            _items.Add(4173, new Item("banthaChop", ClassPswmItems));
            _items.Add(4174, new Item("waterDroplet", ClassPswmItems));
            _items.Add(4176, new Item("leiasBuns", ClassPswmItems));
            _items.Add(4177, new Item("atatPilotChest", ClassPswmItems));
            _items.Add(4178, new Item("atatPilotHelmet", ClassPswmItems));
            _items.Add(4179, new Item("atatPilotBoots", ClassPswmItems));
            _items.Add(4180, new Item("atatPilotLegs", ClassPswmItems));
            _items.Add(4182, new Item("banthaMilk", ClassPswmItems));
            _items.Add(4183, new Item("spawnHothSpeederBike", ClassPswmItems));
            _items.Add(4184, new Item("recordTheme", ClassPswmItems));
            _items.Add(4185, new Item("recordThrone", ClassPswmItems));
            _items.Add(4186, new Item("recordBinary", ClassPswmItems));
            _items.Add(4187, new Item("recordImperial", ClassPswmItems));
            _items.Add(4188, new Item("recordCantina", ClassPswmItems));
            _items.Add(4189, new Item("spawnSurgical", ClassPswmItems));
            _items.Add(4190, new Item("banthaChopCooked", ClassPswmItems));
            _items.Add(4192, new Item("spawnAstromech2", ClassPswmItems));
            _items.Add(4193, new Item("spawnProbe", ClassPswmItems));
            _items.Add(4194, new Item("spawnMouse", ClassPswmItems));
            _items.Add(4195, new Item("spawnProtocol2", ClassPswmItems));
            _items.Add(4197, new Item("gorrnar", ClassPswmItems));
            _items.Add(4198, new Item("banthaPlatter", ClassPswmItems));
            _items.Add(4199, new Item("chasuka", ClassPswmItems));
            _items.Add(4200, new Item("canron", ClassPswmItems));
            _items.Add(4201, new Item("dewbackRibs", ClassPswmItems));
            _items.Add(4202, new Item("acidBeets", ClassPswmItems));
            _items.Add(4203, new Item("binoculars", ClassPswmItems));
            _items.Add(4206, new Item("binocularsHoth", ClassPswmItems));
            _items.Add(4207, new Item("droidHacker", ClassPswmItems));
            _items.Add(4208, new Item("fleetHelmet", ClassPswmItems));
            _items.Add(4209, new Item("fleetChest", ClassPswmItems));
            _items.Add(4210, new Item("fleetBoots", ClassPswmItems));
            _items.Add(4211, new Item("fleetLegs", ClassPswmItems));
            _items.Add(4212, new Item("stormtrooperNewBoots", ClassPswmItems));
            _items.Add(4213, new Item("goldImperialCredit", ClassPswmItems));
            _items.Add(4214, new Item("stormtrooperNewHelmet", ClassPswmItems));
            _items.Add(4215, new Item("stormtrooperNewLegs", ClassPswmItems));
            _items.Add(4217, new Item("silverImperialCredit", ClassPswmItems));
            _items.Add(4218, new Item("stormtrooperNewChest", ClassPswmItems));
            _items.Add(4221, new Item("sequelBlasterRifle", ClassPswmItems));
            _items.Add(4222, new Item("spawnJakkuSpeeder", ClassPswmItems));
            _items.Add(4224, new Item("spawnTIE", ClassPswmItems));
            _items.Add(4225, new Item("sequelBlasterPistol", ClassPswmItems));
            _items.Add(4226, new Item("spawnTIEInterceptor", ClassPswmItems));
            _items.Add(4228, new Item("spawnAWing", ClassPswmItems));
            _items.Add(4230, new Item("customItem", ClassPswmItems));
            _items.Add(4231, new Item("spawnXWing", ClassPswmItems));
            _items.Add(4232, new Item("spawnAstromechBb8", ClassPswmItems));
            _items.Add(4233, new Item("spawnAstromechImperial", ClassPswmItems));
            _items.Add(4234, new Item("spawnAstromechImperial2", ClassPswmItems));
            _items.Add(4235, new Item("stormtrooperSilverNewBoots", ClassPswmItems));
            _items.Add(4236, new Item("stormtrooperSilverNewHelmet", ClassPswmItems));
            _items.Add(4237, new Item("stormtrooperSilverNewLegs", ClassPswmItems));
            _items.Add(4238, new Item("stormtrooperSilverNewChest", ClassPswmItems));
            _items.Add(4239, new Item("hyperdriveIlum", ClassPswmItems));
            _items.Add(4240, new Item("hyperdriveDagobah", ClassPswmItems));
            _items.Add(4241, new Item("newJediRobes", ClassPswmItems));
            _items.Add(4353, new Item("spawnDsTurret", ClassPswmItems));
            _items.Add(4354, new Item("vibroLance", ClassPswmItems));
            _items.Add(4355, new Item("gamorreanAx3", ClassPswmItems));
            _items.Add(4356, new Item("gamorreanAx2", ClassPswmItems));
            _items.Add(4357, new Item("questContainer", ClassPswmItems));
            _items.Add(4358, new Item("spawnSkyhopper", ClassPswmItems));
            _items.Add(4359, new Item("spawnSnowspeeder", ClassPswmItems));
            _items.Add(4360, new Item("spawnAtst", ClassPswmItems));
            _items.Add(4362, new Item("lightsaberNew9", ClassPswmItems));
            _items.Add(4363, new Item("lightsaberNew8", ClassPswmItems));
            _items.Add(4364, new Item("lightsaberNew7", ClassPswmItems));
            _items.Add(4365, new Item("lightsaberNew6", ClassPswmItems));
            _items.Add(4366, new Item("lightsaberNew5", ClassPswmItems));
            _items.Add(4367, new Item("lightsaberNew10", ClassPswmItems));
            _items.Add(4368, new Item("lightsaberNew4", ClassPswmItems));
            _items.Add(4369, new Item("lightsaberNew3", ClassPswmItems));
            _items.Add(4370, new Item("lightsaberNew2", ClassPswmItems));
            _items.Add(4371, new Item("lightsaberNew1", ClassPswmItems));
            _items.Add(4372, new Item("lightsaberNew0", ClassPswmItems));
            _items.Add(4373, new Item("lightsaberNew11", ClassPswmItems));
            _items.Add(4374, new Item("lightsaberNew12", ClassPswmItems));
            _items.Add(4375, new Item("lightsaberNew13", ClassPswmItems));
            _items.Add(4376, new Item("lightsaberNew14", ClassPswmItems));
            _items.Add(4377, new Item("lightsaberNew15", ClassPswmItems));
            _items.Add(4378, new Item("hyperdriveMustafar", ClassPswmItems));
            _items.Add(4379, new Item("idScanner", ClassPswmItems));
            _items.Add(4380, new Item("ingotCortosis", ClassPswmItems));
            _items.Add(4381, new Item("ingotBene", ClassPswmItems));
            _items.Add(4382, new Item("ingotDolomite", ClassPswmItems));
            _items.Add(4383, new Item("ingotExonium", ClassPswmItems));
            _items.Add(4384, new Item("ingotIonite", ClassPswmItems));
            _items.Add(4385, new Item("ingotRubindum", ClassPswmItems));
            _items.Add(4386, new Item("ingotHelicite", ClassPswmItems));
            _items.Add(4387, new Item("ingotKelerium", ClassPswmItems));
        }

        /// <summary>
        /// Populates the blocks dictionary
        /// </summary>
        private void PopulateBlocks()
        {
            _blocks.Clear();
            _blocks.Add(0, new Block("air", ClassBlocks));
            _blocks.Add(1, new Block("stone", ClassBlocks));
            _blocks.Add(2, new Block("grass", ClassBlocks));
            _blocks.Add(3, new Block("dirt", ClassBlocks));
            _blocks.Add(4, new Block("cobblestone", ClassBlocks));
            _blocks.Add(5, new Block("planks", ClassBlocks));
            _blocks.Add(6, new Block("sapling", ClassBlocks));
            _blocks.Add(7, new Block("bedrock", ClassBlocks));
            _blocks.Add(8, new Block("flowing_water", ClassBlocks));
            _blocks.Add(9, new Block("water", ClassBlocks));
            _blocks.Add(10, new Block("flowing_lava", ClassBlocks));
            _blocks.Add(11, new Block("lava", ClassBlocks));
            _blocks.Add(12, new Block("sand", ClassBlocks));
            _blocks.Add(13, new Block("gravel", ClassBlocks));
            _blocks.Add(14, new Block("gold_ore", ClassBlocks));
            _blocks.Add(15, new Block("iron_ore", ClassBlocks));
            _blocks.Add(16, new Block("coal_ore", ClassBlocks));
            _blocks.Add(17, new Block("log", ClassBlocks));
            _blocks.Add(18, new Block("leaves", ClassBlocks));
            _blocks.Add(19, new Block("sponge", ClassBlocks));
            _blocks.Add(20, new Block("glass", ClassBlocks));
            _blocks.Add(21, new Block("lapis_ore", ClassBlocks));
            _blocks.Add(22, new Block("lapis_block", ClassBlocks));
            _blocks.Add(23, new Block("dispenser", ClassBlocks));
            _blocks.Add(24, new Block("sandstone", ClassBlocks));
            _blocks.Add(25, new Block("noteblock", ClassBlocks));
            _blocks.Add(26, new Block("bed", ClassBlocks));
            _blocks.Add(27, new Block("golden_rail", ClassBlocks));
            _blocks.Add(28, new Block("detector_rail", ClassBlocks));
            _blocks.Add(29, new Block("sticky_piston", ClassBlocks));
            _blocks.Add(30, new Block("web", ClassBlocks));
            _blocks.Add(31, new Block("tallgrass", ClassBlocks));
            _blocks.Add(32, new Block("deadbush", ClassBlocks));
            _blocks.Add(33, new Block("piston", ClassBlocks));
            _blocks.Add(34, new Block("piston_head", ClassBlocks));
            _blocks.Add(35, new Block("wool", ClassBlocks));
            _blocks.Add(36, new Block("piston_extension", ClassBlocks));
            _blocks.Add(37, new Block("yellow_flower", ClassBlocks));
            _blocks.Add(38, new Block("red_flower", ClassBlocks));
            _blocks.Add(39, new Block("brown_mushroom", ClassBlocks));
            _blocks.Add(40, new Block("red_mushroom", ClassBlocks));
            _blocks.Add(41, new Block("gold_block", ClassBlocks));
            _blocks.Add(42, new Block("iron_block", ClassBlocks));
            _blocks.Add(43, new Block("double_stone_slab", ClassBlocks));
            _blocks.Add(44, new Block("stone_slab", ClassBlocks));
            _blocks.Add(45, new Block("brick_block", ClassBlocks));
            _blocks.Add(46, new Block("tnt", ClassBlocks));
            _blocks.Add(47, new Block("bookshelf", ClassBlocks));
            _blocks.Add(48, new Block("mossy_cobblestone", ClassBlocks));
            _blocks.Add(49, new Block("obsidian", ClassBlocks));
            _blocks.Add(50, new Block("torch", ClassBlocks));
            _blocks.Add(51, new Block("fire", ClassBlocks));
            _blocks.Add(52, new Block("mob_spawner", ClassBlocks));
            _blocks.Add(53, new Block("oak_stairs", ClassBlocks));
            _blocks.Add(54, new Block("chest", ClassBlocks));
            _blocks.Add(55, new Block("redstone_wire", ClassBlocks));
            _blocks.Add(56, new Block("diamond_ore", ClassBlocks));
            _blocks.Add(57, new Block("diamond_block", ClassBlocks));
            _blocks.Add(58, new Block("crafting_table", ClassBlocks));
            _blocks.Add(59, new Block("wheat", ClassBlocks));
            _blocks.Add(60, new Block("farmland", ClassBlocks));
            _blocks.Add(61, new Block("furnace", ClassBlocks));
            _blocks.Add(62, new Block("lit_furnace", ClassBlocks));
            _blocks.Add(63, new Block("standing_sign", ClassBlocks));
            _blocks.Add(64, new Block("wooden_door", ClassBlocks));
            _blocks.Add(65, new Block("ladder", ClassBlocks));
            _blocks.Add(66, new Block("rail", ClassBlocks));
            _blocks.Add(67, new Block("stone_stairs", ClassBlocks));
            _blocks.Add(68, new Block("wall_sign", ClassBlocks));
            _blocks.Add(69, new Block("lever", ClassBlocks));
            _blocks.Add(70, new Block("stone_pressure_plate", ClassBlocks));
            _blocks.Add(71, new Block("iron_door", ClassBlocks));
            _blocks.Add(72, new Block("wooden_pressure_plate", ClassBlocks));
            _blocks.Add(73, new Block("redstone_ore", ClassBlocks));
            _blocks.Add(74, new Block("lit_redstone_ore", ClassBlocks));
            _blocks.Add(75, new Block("unlit_redstone_torch", ClassBlocks));
            _blocks.Add(76, new Block("redstone_torch", ClassBlocks));
            _blocks.Add(77, new Block("stone_button", ClassBlocks));
            _blocks.Add(78, new Block("snow_layer", ClassBlocks));
            _blocks.Add(79, new Block("ice", ClassBlocks));
            _blocks.Add(80, new Block("snow", ClassBlocks));
            _blocks.Add(81, new Block("cactus", ClassBlocks));
            _blocks.Add(82, new Block("clay", ClassBlocks));
            _blocks.Add(83, new Block("reeds", ClassBlocks));
            _blocks.Add(84, new Block("jukebox", ClassBlocks));
            _blocks.Add(85, new Block("fence", ClassBlocks));
            _blocks.Add(86, new Block("pumpkin", ClassBlocks));
            _blocks.Add(87, new Block("netherrack", ClassBlocks));
            _blocks.Add(88, new Block("soul_sand", ClassBlocks));
            _blocks.Add(89, new Block("glowstone", ClassBlocks));
            _blocks.Add(90, new Block("portal", ClassBlocks));
            _blocks.Add(91, new Block("lit_pumpkin", ClassBlocks));
            _blocks.Add(92, new Block("cake", ClassBlocks));
            _blocks.Add(93, new Block("unpowered_repeater", ClassBlocks));
            _blocks.Add(94, new Block("powered_repeater", ClassBlocks));
            _blocks.Add(95, new Block("stained_glass", ClassBlocks));
            _blocks.Add(96, new Block("trapdoor", ClassBlocks));
            _blocks.Add(97, new Block("monster_egg", ClassBlocks));
            _blocks.Add(98, new Block("stonebrick", ClassBlocks));
            _blocks.Add(99, new Block("brown_mushroom_block", ClassBlocks));
            _blocks.Add(100, new Block("red_mushroom_block", ClassBlocks));
            _blocks.Add(101, new Block("iron_bars", ClassBlocks));
            _blocks.Add(102, new Block("glass_pane", ClassBlocks));
            _blocks.Add(103, new Block("melon_block", ClassBlocks));
            _blocks.Add(104, new Block("pumpkin_stem", ClassBlocks));
            _blocks.Add(105, new Block("melon_stem", ClassBlocks));
            _blocks.Add(106, new Block("vine", ClassBlocks));
            _blocks.Add(107, new Block("fence_gate", ClassBlocks));
            _blocks.Add(108, new Block("brick_stairs", ClassBlocks));
            _blocks.Add(109, new Block("stone_brick_stairs", ClassBlocks));
            _blocks.Add(110, new Block("mycelium", ClassBlocks));
            _blocks.Add(111, new Block("waterlily", ClassBlocks));
            _blocks.Add(112, new Block("nether_brick", ClassBlocks));
            _blocks.Add(113, new Block("nether_brick_fence", ClassBlocks));
            _blocks.Add(114, new Block("nether_brick_stairs", ClassBlocks));
            _blocks.Add(115, new Block("nether_wart", ClassBlocks));
            _blocks.Add(116, new Block("enchanting_table", ClassBlocks));
            _blocks.Add(117, new Block("brewing_stand", ClassBlocks));
            _blocks.Add(118, new Block("cauldron", ClassBlocks));
            _blocks.Add(119, new Block("end_portal", ClassBlocks));
            _blocks.Add(120, new Block("end_portal_frame", ClassBlocks));
            _blocks.Add(121, new Block("end_stone", ClassBlocks));
            _blocks.Add(122, new Block("dragon_egg", ClassBlocks));
            _blocks.Add(123, new Block("redstone_lamp", ClassBlocks));
            _blocks.Add(124, new Block("lit_redstone_lamp", ClassBlocks));
            _blocks.Add(125, new Block("double_wooden_slab", ClassBlocks));
            _blocks.Add(126, new Block("wooden_slab", ClassBlocks));
            _blocks.Add(127, new Block("cocoa", ClassBlocks));
            _blocks.Add(128, new Block("sandstone_stairs", ClassBlocks));
            _blocks.Add(129, new Block("emerald_ore", ClassBlocks));
            _blocks.Add(130, new Block("ender_chest", ClassBlocks));
            _blocks.Add(131, new Block("tripwire_hook", ClassBlocks));
            _blocks.Add(132, new Block("tripwire", ClassBlocks));
            _blocks.Add(133, new Block("emerald_block", ClassBlocks));
            _blocks.Add(134, new Block("spruce_stairs", ClassBlocks));
            _blocks.Add(135, new Block("birch_stairs", ClassBlocks));
            _blocks.Add(136, new Block("jungle_stairs", ClassBlocks));
            _blocks.Add(137, new Block("command_block", ClassBlocks));
            _blocks.Add(138, new Block("beacon", ClassBlocks));
            _blocks.Add(139, new Block("cobblestone_wall", ClassBlocks));
            _blocks.Add(140, new Block("flower_pot", ClassBlocks));
            _blocks.Add(141, new Block("carrots", ClassBlocks));
            _blocks.Add(142, new Block("potatoes", ClassBlocks));
            _blocks.Add(143, new Block("wooden_button", ClassBlocks));
            _blocks.Add(144, new Block("skull", ClassBlocks));
            _blocks.Add(145, new Block("anvil", ClassBlocks));
            _blocks.Add(146, new Block("trapped_chest", ClassBlocks));
            _blocks.Add(147, new Block("light_weighted_pressure_plate", ClassBlocks));
            _blocks.Add(148, new Block("heavy_weighted_pressure_plate", ClassBlocks));
            _blocks.Add(149, new Block("unpowered_comparator", ClassBlocks));
            _blocks.Add(150, new Block("powered_comparator", ClassBlocks));
            _blocks.Add(151, new Block("daylight_detector", ClassBlocks));
            _blocks.Add(152, new Block("redstone_block", ClassBlocks));
            _blocks.Add(153, new Block("quartz_ore", ClassBlocks));
            _blocks.Add(154, new Block("hopper", ClassBlocks));
            _blocks.Add(155, new Block("quartz_block", ClassBlocks));
            _blocks.Add(156, new Block("quartz_stairs", ClassBlocks));
            _blocks.Add(157, new Block("activator_rail", ClassBlocks));
            _blocks.Add(158, new Block("dropper", ClassBlocks));
            _blocks.Add(159, new Block("stained_hardened_clay", ClassBlocks));
            _blocks.Add(160, new Block("stained_glass_pane", ClassBlocks));
            _blocks.Add(161, new Block("leaves2", ClassBlocks));
            _blocks.Add(162, new Block("log2", ClassBlocks));
            _blocks.Add(163, new Block("acacia_stairs", ClassBlocks));
            _blocks.Add(164, new Block("dark_oak_stairs", ClassBlocks));
            _blocks.Add(165, new Block("moistureVaporator", ClassPswm));
            _blocks.Add(166, new Block("chromiumOre", ClassPswm));
            _blocks.Add(167, new Block("titaniumOre", ClassPswm));
            _blocks.Add(168, new Block("titaniumChromiumBlock", ClassPswm));
            _blocks.Add(169, new Block("endorBaseWall", ClassPswm));
            _blocks.Add(170, new Block("hay_block", ClassBlocks));
            _blocks.Add(171, new Block("carpet", ClassBlocks));
            _blocks.Add(172, new Block("hardened_clay", ClassBlocks));
            _blocks.Add(173, new Block("coal_block", ClassBlocks));
            _blocks.Add(174, new Block("packed_ice", ClassBlocks));
            _blocks.Add(175, new Block("double_plant", ClassBlocks));
            _blocks.Add(178, new Block("endorBaseWallStairs", ClassPswm));
            _blocks.Add(179, new Block("tatooineSand", ClassPswm));
            _blocks.Add(180, new Block("table", ClassPswm));
            _blocks.Add(181, new Block("spaceLamp", ClassPswm));
            _blocks.Add(182, new Block("tatooineSandstone", ClassPswm));
            _blocks.Add(183, new Block("dagobahMud", ClassPswm));
            _blocks.Add(185, new Block("mudTable", ClassPswm));
            _blocks.Add(186, new Block("mudStairs", ClassPswm));
            _blocks.Add(187, new Block("hangingCauldron", ClassPswm));
            _blocks.Add(188, new Block("hangingBucket", ClassPswm));
            _blocks.Add(189, new Block("basket", ClassPswm));
            _blocks.Add(190, new Block("deathStarBlock", ClassPswm));
            _blocks.Add(191, new Block("deathStarLight", ClassPswm));
            _blocks.Add(192, new Block("deathStarGlass", ClassPswm));
            _blocks.Add(194, new Block("deathStarDoor", ClassPswm));
            _blocks.Add(196, new Block("fieldEmitter", ClassPswm));
            _blocks.Add(197, new Block("holoTable", ClassPswm));
            _blocks.Add(409, new Block("bactaTank", ClassPswm));
            _blocks.Add(423, new Block("blockBeneOre", ClassPswm));
            _blocks.Add(424, new Block("blockExoniumOre", ClassPswm));
            _blocks.Add(425, new Block("blockKeleriumOre", ClassPswm));
            _blocks.Add(426, new Block("blockIoniteOre", ClassPswm));
            _blocks.Add(427, new Block("blockCortosisOre", ClassPswm));
            _blocks.Add(428, new Block("blockHeliciteOre", ClassPswm));
            _blocks.Add(429, new Block("blockRubindumOre", ClassPswm));
            _blocks.Add(430, new Block("blockDolomiteOre", ClassPswm));
            _blocks.Add(431, new Block("blockTempleStone", ClassPswm));
            _blocks.Add(432, new Block("blockTempleStoneSlab", ClassPswm));
            _blocks.Add(433, new Block("blockTempleStoneLit", ClassPswm));
            _blocks.Add(434, new Block("blockTempleStoneSlabLit", ClassPswm));
            _blocks.Add(435, new Block("ancientJediStatue", ClassPswm));
            _blocks.Add(436, new Block("blockTempleStoneStairsBrick", ClassPswm));
            _blocks.Add(437, new Block("blockTempleStoneStairsSlabTopDark", ClassPswm));
            _blocks.Add(438, new Block("blockTempleStoneStairs", ClassPswm));
            _blocks.Add(439, new Block("blockTempleStoneStairsStabTop", ClassPswm));
            _blocks.Add(440, new Block("blockTempleStoneStairsFancy", ClassPswm));
        }

        /// <summary>
        /// Does an ID to Block conversion
        /// </summary>
        /// <param name="id">The ID to look up</param>
        /// <returns>The block it found, or Air if no block found</returns>
        public Block GetBlockFromId(int id)
        {
            if (!_blocks.ContainsKey(id))
                return _blocks[0];
            return _blocks[id];
        }

        /// <summary>
        /// Does a Name to Block conversion
        /// </summary>
        /// <param name="name">The name to look up</param>
        /// <returns>The block it found, or null otherwise</returns>
        public Block GetBlockFromName(string name)
        {
            return _blocks.FirstOrDefault(x => x.Value.GetName() == name).Value;
        }

        /// <summary>
        /// Does an ID to Item conversion
        /// </summary>
        /// <param name="id">The ID to look up</param>
        /// <returns>If the item it found. If the ID is a block too, it returns that instead. Null if nothing found</returns>
        public Item GetItemFromId(int id)
        {
            if (_blocks.ContainsKey(id)) // because items are blocks too and vice versa
                return GetBlockFromId(id).ToItem();
            if (!_items.ContainsKey(id))
                return _items[0];
            return _items[id];
        }

        /// <summary>
        /// Does a Name to Entity conversion
        /// </summary>
        /// <param name="name">The name to loop up</param>
        /// <returns>The entity if found, or null otherwise</returns>
        public Entity GetEntityFromName(string name)
        {
            return _entityAssociations.FirstOrDefault(x => x.Key.GetName() == name).Key;
        }

        /// <summary>
        /// Does an Item to Entity conversion
        /// </summary>
        /// <param name="item">The item to loop up</param>
        /// <returns>The entity if found, or null otherwise</returns>
        public Entity GetEntityFromAssociation(Item item)
        {
            return _entityAssociations.FirstOrDefault(x => x.Value.GetName() == item.GetName()).Key;
        }

        /// <summary>
        /// Does a Name to Item conversion
        /// </summary>
        /// <param name="name">The name to look up</param>
        /// <returns>The item it found, or null otherwise</returns>
        public Item GetItemFromName(string name)
        {
            return _items.FirstOrDefault(x => x.Value.GetName() == name).Value;
        }

        /// <summary>
        /// Does an item Name to ID conversion
        /// </summary>
        /// <param name="itemName">The name to look up</param>
        /// <returns>The ID it found, or null otherwise</returns>
        public int GetIdFromItem(string itemName)
        {
            return _items.FirstOrDefault(x => x.Value.GetName() == itemName).Key;
        }

        /// <summary>
        /// Does a block Name to ID conversion
        /// </summary>
        /// <param name="blockName">The name to look up</param>
        /// <returns>The ID it found, or null otherwise</returns>
        public int GetIdFromBlock(string blockName)
        {
            return _blocks.FirstOrDefault(x => x.Value.GetName() == blockName).Key;
        }
    }
}
