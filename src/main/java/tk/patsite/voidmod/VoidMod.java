package tk.patsite.voidmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.DimensionRenderingRegistry;
import net.minecraft.client.render.DimensionEffects;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.Nullable;

public class VoidMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.

	public static final String MODID = "voidmod";

	public static final Logger LOGGER = LogManager.getLogger("voidmod");

	public static final Identifier VOID_WORLD_IDENTIFIER = new Identifier("voidmod", "void");

	private static final class VoidWorldDimensionEffects extends DimensionEffects {
		public VoidWorldDimensionEffects() {
			super(Float.NaN, false, DimensionEffects.SkyType.NONE, false, false);
		}
		@Override public Vec3d adjustFogColor(Vec3d color, float sunHeight) {
			return color.multiply(0.15f);
		}
		@Override public boolean useThickFog(int camX, int camY) {
			return false;
		}
		@Override public float[] getFogColorOverride(float skyAngle, float tickDelta) {
			return null;
		}
	}

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.


		DimensionRenderingRegistry.registerDimensionEffects(VOID_WORLD_IDENTIFIER, new VoidWorldDimensionEffects());
	}
}
