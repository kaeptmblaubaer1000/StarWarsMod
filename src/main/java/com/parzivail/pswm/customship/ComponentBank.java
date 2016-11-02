package com.parzivail.pswm.customship;

/**
 * Created by colby on 10/30/2016.
 */
public class ComponentBank
{
	public static final DSublightEngine[] sublightEngines = new DSublightEngine[] {
			new DSublightEngine("4L4 Fusial Thrust Engine", ManufacturerBank.INCOM, 260, 5, 50, 625),
			new DSublightEngine("5i.2 High-Powered Ion Drive Afterburner", ManufacturerBank.INCOM, 550, 6, 60, 750),
			new DSublightEngine("E-16/x Ion Engine", ManufacturerBank.INCOM, 1200, 15, 60, 325),
			new DSublightEngine("Heavy Turbine Engines", ManufacturerBank.TWINSTAR, 360, 3, 80, 125),
			new DSublightEngine("J-77 Event Horizon Thrust Engine", ManufacturerBank.NOVALDEX, 650, 8, 80, 400),
			new DSublightEngine("P-s4 Twin Ion Engine", ManufacturerBank.SFS, 600, 7, 70, 550),
			new DSublightEngine("P-s5.6 Twin Ion Engine", ManufacturerBank.SFS, 625, 7, 75, 525),
			new DSublightEngine("R200 Ion Jet Engines", ManufacturerBank.KOENSAYR, 500, 6, 60, 1000),
			new DSublightEngine("Turbine Engines", ManufacturerBank.TWINSTAR, 75, 3, 45, 125),
			new DSublightEngine("Turbine Engines", "Rey", 110, 4, 40, 140),
			new DSublightEngine("WhisperThrust Baffled Sublight Drive", ManufacturerBank.RENDILI, 245, 3, 45, 500)
	};

	public static final DPowerPlant[] powerPlants = new DPowerPlant[] {
			new DPowerPlant("03-R Cryogenic Power Cell", ManufacturerBank.THIODYNE, 500, 105),
			new DPowerPlant("Bpr-99 Fusion Reactor", ManufacturerBank.MPS, 500, 205),
			new DPowerPlant("DXR-4 reactor", ManufacturerBank.MANDALMOTORS, 100, 25),
			new DPowerPlant("I-a2b Solar Ionization Reactor", ManufacturerBank.SFS, 300, 50),
			new DPowerPlant("I-s3a Solar Ionization Reactor", ManufacturerBank.SFS, 400, 60),
			new DPowerPlant("Modified Class-4T3 Power Generator", ManufacturerBank.EKSOAN, 500, 90),
			new DPowerPlant("O2K Cryogenic Power Cell", ManufacturerBank.VINOP, 200, 40),
			new DPowerPlant("O4-Z Cryogenic Power Generator", ManufacturerBank.NOVALDEX, 500, 100)
	};

	public static final DShield[] shields = new DShield[] {
			new DShield("\"Defender\" Deflector Shield Projector", ManufacturerBank.CHEPAT, 100, 110, 100),
			new DShield("Armor Hull Plating", ManufacturerBank.INCOM, 0, 25, 210),
			new DShield("Light Deflector Shield Projector", ManufacturerBank.CHEPAT, 80, 75, 80),
			new DShield("Z-9 Deflector Shield Projector", ManufacturerBank.SIRPLEX, 110, 120, 105)
	};

	public static final DTargetingComputer[] targetingComputers = new DTargetingComputer[] {
			new DTargetingComputer("ANs-5d \"Lock Track\" Full-Spectrum Transceiver", ManufacturerBank.FABRITECH, 10, 100),
			new DTargetingComputer("K-64 Targeting System", ManufacturerBank.NEUROSAAV, 5, 50),
			new DTargetingComputer("SI 5g7 \"Quickscan\" Imaging System", ManufacturerBank.FABRITECH, 12, 125),
			new DTargetingComputer("T-s9a Targeting Computer", ManufacturerBank.SFS, 8, 75),
			new DTargetingComputer("T-s8 Targeting Computer", ManufacturerBank.SFS, 5, 50),
			new DTargetingComputer("T-s7b Targeting Computer", ManufacturerBank.SFS, 10, 100)
	};

	public static final DEnergyWeapon[] energyWeapons = new DEnergyWeapon[] {
			new DEnergyWeapon("Ap/11 Laser Cannon", ManufacturerBank.CORELLIANENGCORP, 50, 500),
			new DEnergyWeapon("Ax-20 Blaster Cannon", ManufacturerBank.SOROSUUB, 30, 45),
			new DEnergyWeapon("IX4 Laser Cannon", ManufacturerBank.TAIMBAK, 60, 580),
			new DEnergyWeapon("KX9 Laser Cannon", ManufacturerBank.TAIMBAK, 70, 650),
			new DEnergyWeapon("L-s1 Laser Cannon", ManufacturerBank.SFS, 65, 600),
			new DEnergyWeapon("L-s9.3 Laser Cannon", ManufacturerBank.SFS, 70, 650),
			new DEnergyWeapon("Mk 1e/W Heavy Laser Cannon", ManufacturerBank.INCOM, 80, 500)
	};

	public static final DPhysicalWeapon[] physicalWeapons = new DPhysicalWeapon[] {
			new DPhysicalWeapon("Cluster Missiles", ManufacturerBank.ARMATEK, 75, SPhysicalWeapon.Type.MISSILE),
			new DPhysicalWeapon("Flex Tube Proton Torpedos ", ManufacturerBank.ARAKYD, 75, SPhysicalWeapon.Type.TORPEDO),
			new DPhysicalWeapon("MG7 Proton Torpedos", ManufacturerBank.KRUPX, 100, SPhysicalWeapon.Type.TORPEDO),
			new DPhysicalWeapon("Mo/Dk Energy Harpoon", ManufacturerBank.UBRIKKIAN, 75, SPhysicalWeapon.Type.HARPOON),
			new DPhysicalWeapon("T-s5 Proton Torpedos", ManufacturerBank.SFS, 100, SPhysicalWeapon.Type.TORPEDO),
			new DPhysicalWeapon("VL-61/79 proton bombs", ManufacturerBank.SFS, 50, SPhysicalWeapon.Type.BOMB)
	};

	public static final DHyperdrive[] hyperdrives = new DHyperdrive[] {
			new DHyperdrive("SSP05 Hyperdrive Generator", ManufacturerBank.ISUSIM, 0.5f, 1200),
			new DHyperdrive("GBk-785 Hyperdrive Motivator", ManufacturerBank.INCOM, 1, 600),
			new DHyperdrive("R300-H Hyperdrive Motivator", ManufacturerBank.KOENSAYR, 1, 600),
			new DHyperdrive("MKI Hyperdrive Motivator", ManufacturerBank.INCOM, 2, 300),
			new DHyperdrive("StarBurn 4", ManufacturerBank.SUWANTEK, 3, 200),
			new DHyperdrive("R75-L Hyperdrive Motivator", ManufacturerBank.KOENSAYR, 4, 125),
	};

	public static final DStealthTech[] stealthTech = new DStealthTech[] {
			new DStealthTech("Cloaking Revver", ManufacturerBank.MERRSONN, 10, 175, false, true),
			new DStealthTech("CC-Y Antiradar Defense Unit", ManufacturerBank.FORBESTECHCO, 10, 75, true, false),
			new DStealthTech("Personal Concealment System, Mark VI", ManufacturerBank.CYRICEPT, 20, 175, false, true),
			new DStealthTech("Sensor Deflector Net", ManufacturerBank.ADVANCEDMICROMATERIALS, 20, 75, true, false),
			new DStealthTech("NOVA System", ManufacturerBank.SANTHESIENAR, 30, 250, false, false)
	};
}
