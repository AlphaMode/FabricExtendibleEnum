package net.fabricmc.example.mixin.plugin;

import net.fabricmc.example.RuntimeEnumExtender;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.MappingResolver;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

public class FEPlugin implements IMixinConfigPlugin {
    private RuntimeEnumExtender enumExtender = new RuntimeEnumExtender();
    private MappingResolver resolver = FabricLoader.getInstance().getMappingResolver();

    @Override
    public void onLoad(String mixinPackage) {

    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        return true;
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {

    }

    @Override
    public List<String> getMixins() {
        return null;
    }

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
        if(targetClassName.equals(resolver.mapClassName("intermediary","net.minecraft.class_1814"))) {
            enumExtender.processClassWithFlags(true, targetClass, Type.getObjectType(resolver.mapClassName("intermediary","net.minecraft.class_1814").replace('.', '/')));
        }
        //resolver.mapClassName("intermediary","net.minecraft.class_1814"), classNode -> enumExtender.processClassWithFlags(true, classNode, Type.getObjectType(resolver.mapClassName("intermediary","net.minecraft.class_1814").replace('.', '/')))
    }

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {

    }
}
