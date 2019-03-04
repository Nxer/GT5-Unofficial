package gtPlusPlus.xmod.thaumcraft.aspect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import gregtech.api.enums.TC_Aspects;
import gregtech.api.util.GT_LanguageManager;
import gregtech.common.GT_ThaumcraftCompat;
import gtPlusPlus.api.objects.Logger;
import net.minecraft.util.ResourceLocation;

public class GTPP_AspectCompat {
	
	public static volatile Method m = null;
	
	private static HashMap<String, TC_Aspect_Wrapper> mAspectCache = new LinkedHashMap<String, TC_Aspect_Wrapper>();
	

	public static TC_Aspect_Wrapper ASPECT_BALANCE;
	public static TC_Aspect_Wrapper ASPECT_LUST;
	public static TC_Aspect_Wrapper ASPECT_STARBOUND;
	public static TC_Aspect_Wrapper ASPECT_TOXIC;
	public static TC_Aspect_Wrapper ASPECT_HEAVEN;
	
	
/*	TC_Aspects.AER.mAspect = Aspect.AIR;
	TC_Aspects.ALIENIS.mAspect = Aspect.ELDRITCH;
	TC_Aspects.AQUA.mAspect = Aspect.WATER;
	TC_Aspects.ARBOR.mAspect = Aspect.TREE;
	TC_Aspects.AURAM.mAspect = Aspect.AURA;
	TC_Aspects.BESTIA.mAspect = Aspect.BEAST;
	TC_Aspects.COGNITIO.mAspect = Aspect.MIND;
	TC_Aspects.CORPUS.mAspect = Aspect.FLESH;
	TC_Aspects.EXANIMIS.mAspect = Aspect.UNDEAD;
	TC_Aspects.FABRICO.mAspect = Aspect.CRAFT;
	TC_Aspects.FAMES.mAspect = Aspect.HUNGER;
	TC_Aspects.GELUM.mAspect = Aspect.COLD;
	TC_Aspects.GRANUM.mAspect = Aspect.PLANT;
	TC_Aspects.HERBA.mAspect = Aspect.PLANT;
	TC_Aspects.HUMANUS.mAspect = Aspect.MAN;
	TC_Aspects.IGNIS.mAspect = Aspect.FIRE;
	TC_Aspects.INSTRUMENTUM.mAspect = Aspect.TOOL;
	TC_Aspects.ITER.mAspect = Aspect.TRAVEL;
	TC_Aspects.LIMUS.mAspect = Aspect.SLIME;
	TC_Aspects.LUCRUM.mAspect = Aspect.GREED;
	TC_Aspects.LUX.mAspect = Aspect.LIGHT;
	TC_Aspects.MACHINA.mAspect = Aspect.MECHANISM;
	TC_Aspects.MESSIS.mAspect = Aspect.CROP;
	TC_Aspects.METALLUM.mAspect = Aspect.METAL;
	TC_Aspects.METO.mAspect = Aspect.HARVEST;
	TC_Aspects.MORTUUS.mAspect = Aspect.DEATH;
	TC_Aspects.MOTUS.mAspect = Aspect.MOTION;
	TC_Aspects.ORDO.mAspect = Aspect.ORDER;
	TC_Aspects.PANNUS.mAspect = Aspect.CLOTH;
	TC_Aspects.PERDITIO.mAspect = Aspect.ENTROPY;
	TC_Aspects.PERFODIO.mAspect = Aspect.MINE;
	TC_Aspects.PERMUTATIO.mAspect = Aspect.EXCHANGE;
	TC_Aspects.POTENTIA.mAspect = Aspect.ENERGY;
	TC_Aspects.PRAECANTATIO.mAspect = Aspect.MAGIC;
	TC_Aspects.SANO.mAspect = Aspect.HEAL;
	TC_Aspects.SENSUS.mAspect = Aspect.SENSES;
	TC_Aspects.SPIRITUS.mAspect = Aspect.SOUL;
	TC_Aspects.TELUM.mAspect = Aspect.WEAPON;
	TC_Aspects.TERRA.mAspect = Aspect.EARTH;
	TC_Aspects.TEMPESTAS.mAspect = Aspect.WEATHER;
	TC_Aspects.TENEBRAE.mAspect = Aspect.DARKNESS;
	TC_Aspects.TUTAMEN.mAspect = Aspect.ARMOR;
	TC_Aspects.VACUOS.mAspect = Aspect.VOID;
	TC_Aspects.VENENUM.mAspect = Aspect.POISON;
	TC_Aspects.VICTUS.mAspect = Aspect.LIFE;
	TC_Aspects.VINCULUM.mAspect = Aspect.TRAP;
	TC_Aspects.VITIUM.mAspect = Aspect.TAINT;
	TC_Aspects.VITREUS.mAspect = Aspect.CRYSTAL;
	TC_Aspects.VOLATUS.mAspect = Aspect.FLIGHT;*/	
	
	
	public GTPP_AspectCompat() {
		
		
		// Generate all existing Aspects as TC_Aspects
		LinkedHashMap<String, Object> h = TC_Aspect_Wrapper.getVanillaAspectList();
		for (String g : h.keySet()) {
			Object aBaseAspect = h.get(g);
			if (aBaseAspect != null && TC_Aspect_Wrapper.isObjectAnAspect(aBaseAspect)) {
				TC_Aspect_Wrapper aS = TC_Aspect_Wrapper.getAspect(g);
				if (aS != null) {
					mAspectCache.put(g, aS);
					continue;
				}
			}
		}
		
		
		
		
		// Custom Aspects
		ASPECT_BALANCE = 
				new TC_Aspect_Wrapper(
						"Purity",
						15647411,
						new TC_Aspect_Wrapper[]{
								get(TC_Aspects.GELUM),
								get(TC_Aspects.IGNIS)
								},
				new ResourceLocation("gregtech:textures/aspects/" + TC_Aspects.RADIO.name() + ".png"),
				false,
				1);
		ASPECT_LUST = 
				new TC_Aspect_Wrapper(
						"Vengeance",
						15647411,
						new TC_Aspect_Wrapper[]{
								get(TC_Aspects.CORPUS),
								get(TC_Aspects.ORDO)
								},
				new ResourceLocation("gregtech:textures/aspects/" + TC_Aspects.NEBRISUM.name() + ".png"),
				false,
				1);
		
		
		
		
		/*GTPP_Aspects.CUSTOM_2.mAspect = new Aspect("custom2", 15658622, new Aspect[]{Aspect.MAGIC, Aspect.SLIME},
				new ResourceLocation("gregtech:textures/aspects/" + TC_Aspects.RADIO.name() + ".png"), 1);
		GTPP_Aspects.CUSTOM_3.mAspect = new Aspect("custom3", 12644078, new Aspect[]{Aspect.ENERGY, Aspect.ARMOR},
				new ResourceLocation("gregtech:textures/aspects/" + TC_Aspects.RADIO.name() + ".png"), 1);
		GTPP_Aspects.CUSTOM_4.mAspect = new Aspect("custom4", 12632256, new Aspect[]{Aspect.METAL, Aspect.POISON},
				new ResourceLocation("gregtech:textures/aspects/" + TC_Aspects.RADIO.name() + ".png"), 1);
		GTPP_Aspects.CUSTOM_5.mAspect = new Aspect("custom4", 12648384, new Aspect[]{Aspect.LIGHT, Aspect.SOUL},
				new ResourceLocation("gregtech:textures/aspects/" + TC_Aspects.RADIO.name() + ".png"), 1);*/
		GT_LanguageManager.addStringLocalization("tc.aspect.Purity", "Balance");
		GT_LanguageManager.addStringLocalization("tc.aspect.Vengeance", "Lust");
		GT_LanguageManager.addStringLocalization("tc.aspect.custom3", "Starbound");
		GT_LanguageManager.addStringLocalization("tc.aspect.custom4", "Toxic");
		GT_LanguageManager.addStringLocalization("tc.aspect.custom5", "Heaven");
	}
	
	private TC_Aspect_Wrapper get(TC_Aspects aGtObjects) {
		try {
			return TC_Aspect_Wrapper.generate(aGtObjects.mAspect);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static synchronized final TC_AspectList_Wrapper getTC_AspectList_Wrapper(final List<GTPP_AspectStack> aAspects) {
		TC_AspectList_Wrapper o = null;
		try {
			if (m == null || (m != null && !m.isAccessible())) {
				m = GT_ThaumcraftCompat.class.getDeclaredMethod("getTC_AspectList_Wrapper", List.class);
				m.setAccessible(true);				
			}
			if (m != null) {
				o = (TC_AspectList_Wrapper) m.invoke(null, aAspects);				
			}
		}
		catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}		
		if (o == null) {
			Logger.REFLECTION("[Aspect] Did not retrieve valid aspect list from reflective invocation.");
		}
		return o;
	}

	
}