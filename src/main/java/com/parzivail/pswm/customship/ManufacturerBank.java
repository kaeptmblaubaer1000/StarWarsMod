package com.parzivail.pswm.customship;

import com.parzivail.pswm.Resources;
import net.minecraft.util.ResourceLocation;

import java.util.HashMap;

/**
 * Created by colby on 10/30/2016.
 */
public class ManufacturerBank
{
	public static final String INCOM = "Incom Corporation";
	public static final String TWINSTAR = "Twinstar";
	public static final String NOVALDEX = "Novaldex";
	public static final String SFS = "Sienar Fleet Systems";
	public static final String KOENSAYR = "Koensayr Manufacturing";
	public static final String RENDILI = "Rendili StarDrive";
	public static final String THIODYNE = "Thiodyne";
	public static final String MPS = "MPS";
	public static final String MANDALMOTORS = "MandalMotors";
	public static final String EKSOAN = "Eksoan";
	public static final String VINOP = "Vinop";
	public static final String CHEPAT = "Chepat";
	public static final String SIRPLEX = "Sirplex";
	public static final String FABRITECH = "Fabritech";
	public static final String NEUROSAAV = "Neuro-Saav Corporation";
	public static final String CORELLIANENGCORP = "Corellian Engineering Corporation";
	public static final String SOROSUUB = "Sorosuub";
	public static final String TAIMBAK = "Taim & Bak";
	public static final String ARMATEK = "ArmaTek";
	public static final String ARAKYD = "Arakyd";
	public static final String KRUPX = "Krupx";
	public static final String UBRIKKIAN = "Ubrikkian Industries";
	public static final String ISUSIM = "Isu-Sim";
	public static final String SUWANTEK = "Suwantek Systems";
	public static final String MERRSONN = "Merr-Sonn Munitions, Inc.";
	public static final String FORBESTECHCO = "Forbes Technology Corporation";
	public static final String CYRICEPT = "Cyricept";
	public static final String ADVANCEDMICROMATERIALS = "Advanced Micromaterials, Inc.";
	public static final String SANTHESIENAR = "Santhe/Sienar Technologies";

	public static final HashMap<String, ResourceLocation> LOGOS = new HashMap<>();

	static
	{
		LOGOS.put(ADVANCEDMICROMATERIALS, new ResourceLocation(Resources.MODID, "textures/logos/advancedmicromaterials.png")); //need
		LOGOS.put(ARAKYD, new ResourceLocation(Resources.MODID, "textures/logos/arakyd.png"));
		LOGOS.put(ARMATEK, new ResourceLocation(Resources.MODID, "textures/logos/armatek.png"));
		LOGOS.put(CHEPAT, new ResourceLocation(Resources.MODID, "textures/logos/chepat.png"));
		LOGOS.put(CORELLIANENGCORP, new ResourceLocation(Resources.MODID, "textures/logos/corellianeng.png"));
		LOGOS.put(CYRICEPT, new ResourceLocation(Resources.MODID, "textures/logos/cyricept.png")); //need
		LOGOS.put(EKSOAN, new ResourceLocation(Resources.MODID, "textures/logos/eksoan.png"));
		LOGOS.put(FABRITECH, new ResourceLocation(Resources.MODID, "textures/logos/fabritech.png"));
		LOGOS.put(FORBESTECHCO, new ResourceLocation(Resources.MODID, "textures/logos/forbestechcho.png")); //need
		LOGOS.put(INCOM, new ResourceLocation(Resources.MODID, "textures/logos/incom.png"));
		LOGOS.put(ISUSIM, new ResourceLocation(Resources.MODID, "textures/logos/isusim.png"));
		LOGOS.put(KOENSAYR, new ResourceLocation(Resources.MODID, "textures/logos/koensayr.png"));
		LOGOS.put(KRUPX, new ResourceLocation(Resources.MODID, "textures/logos/krupx.png"));
		LOGOS.put(MANDALMOTORS, new ResourceLocation(Resources.MODID, "textures/logos/mandalmotors.png"));
		LOGOS.put(MERRSONN, new ResourceLocation(Resources.MODID, "textures/logos/merrsonn.png"));
		LOGOS.put(MPS, new ResourceLocation(Resources.MODID, "textures/logos/mps.png"));
		LOGOS.put(NEUROSAAV, new ResourceLocation(Resources.MODID, "textures/logos/neurosaav.png"));
		LOGOS.put(NOVALDEX, new ResourceLocation(Resources.MODID, "textures/logos/novaldex.png"));
		LOGOS.put(RENDILI, new ResourceLocation(Resources.MODID, "textures/logos/rendili.png"));
		LOGOS.put(SANTHESIENAR, new ResourceLocation(Resources.MODID, "textures/logos/santhesienar.png"));
		LOGOS.put(SFS, new ResourceLocation(Resources.MODID, "textures/logos/sienarfleetsystems.png"));
		LOGOS.put(SIRPLEX, new ResourceLocation(Resources.MODID, "textures/logos/sirplex.png"));
		LOGOS.put(SOROSUUB, new ResourceLocation(Resources.MODID, "textures/logos/sorosuub.png"));
		LOGOS.put(SUWANTEK, new ResourceLocation(Resources.MODID, "textures/logos/suwantek.png"));
		LOGOS.put(TAIMBAK, new ResourceLocation(Resources.MODID, "textures/logos/taimbak.png"));
		LOGOS.put(THIODYNE, new ResourceLocation(Resources.MODID, "textures/logos/thiodyne.png"));
		LOGOS.put(TWINSTAR, new ResourceLocation(Resources.MODID, "textures/logos/twinstar.png"));
		LOGOS.put(UBRIKKIAN, new ResourceLocation(Resources.MODID, "textures/logos/ubrikkian.png"));
		LOGOS.put(VINOP, new ResourceLocation(Resources.MODID, "textures/logos/vinop.png"));
		LOGOS.put("Rey", new ResourceLocation(Resources.MODID, "textures/logos/rey.png"));
	}
}
