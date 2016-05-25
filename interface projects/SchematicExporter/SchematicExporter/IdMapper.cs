using System;
using System.Collections.Generic;
using System.IO;
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

            if (!Directory.Exists("data/"))
                Directory.CreateDirectory("data/");

            Utils.RequireFile("data/items.txt");

            using (var s = new StreamReader("data/items.txt"))
                while (!s.EndOfStream)
                {
                    var line = s.ReadLine();

                    if (line == null) continue;

                    var l = line.Split(',');
                    var id = int.Parse(l[0]);
                    var itemName = l[1];
                    var package = l[2];

                    switch (package)
                    {
                        case "ClassBlocks":
                            _items.Add(id, new Item(itemName, ClassBlocks));
                            break;
                        case "ClassItems":
                            _items.Add(id, new Item(itemName, ClassItems));
                            break;
                        case "ClassPswm":
                            _items.Add(id, new Item(itemName, ClassPswm));
                            break;
                        case "ClassPswmItems":
                            _items.Add(id, new Item(itemName, ClassPswmItems));
                            break;
                    }
                }
        }

        /// <summary>
        /// Populates the blocks dictionary
        /// </summary>
        private void PopulateBlocks()
        {
            _blocks.Clear();

            if (!Directory.Exists("data/"))
                Directory.CreateDirectory("data/");

            Utils.RequireFile("data/blocks.txt");

            using (var s = new StreamReader("data/blocks.txt"))
                while (!s.EndOfStream)
                {
                    var line = s.ReadLine();

                    if (line == null) continue;

                    var l = line.Split(',');
                    var id = int.Parse(l[0]);
                    var blockName = l[1];
                    var package = l[2];

                    switch (package)
                    {
                        case "ClassBlocks":
                            _blocks.Add(id, new Block(blockName, ClassBlocks));
                            break;
                        case "ClassItems":
                            _blocks.Add(id, new Block(blockName, ClassItems));
                            break;
                        case "ClassPswm":
                            _blocks.Add(id, new Block(blockName, ClassPswm));
                            break;
                        case "ClassPswmItems":
                            _blocks.Add(id, new Block(blockName, ClassPswmItems));
                            break;
                    }
                }
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
