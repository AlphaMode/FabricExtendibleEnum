package net.fabricmc.example;

import com.chocohead.mm.api.ClassTinkerers;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.example.mixin.RarAcc;
import net.fabricmc.example.mixin.RarityMixin;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.MappingResolver;
import net.minecraft.util.Formatting;
import net.minecraft.util.Rarity;
import org.apache.logging.log4j.LogManager;
import org.objectweb.asm.Type;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ExampleMod implements ModInitializer {

	@Override
	public void onInitialize() {
		//RarAcc.invokeCreate("GREEM", Formatting.DARK_GREEN);
	}
}
