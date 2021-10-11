package net.fabricmc.example.mixin;

import com.chocohead.mm.api.ClassTinkerers;
import net.fabricmc.example.MyEnum;
import net.fabricmc.example.RuntimeEnumExtender;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.MappingResolver;
import org.objectweb.asm.Type;

import java.util.Arrays;

public class EEEarlyRiser implements Runnable {
    private RuntimeEnumExtender enumExtender = new RuntimeEnumExtender();
    private MappingResolver resolver = FabricLoader.getInstance().getMappingResolver();
    @Override
    public void run() {
        //ClassTinkerers.addTransformation(resolver.mapClassName("intermediary","net.minecraft.class_1814"), classNode -> enumExtender.processClassWithFlags(true, classNode, Type.getObjectType(resolver.mapClassName("intermediary","net.minecraft.class_1814").replace('.', '/'))));
        //ClassTinkerers.addTransformation("net.fabricmc.example.MyEnum", classNode -> enumExtender.processClassWithFlags(true, classNode, Type.getObjectType("net/fabricmc/example/MyEnum")));
//        ClassTinkerers.enumBuilder("net.fabricmc.example.MyEnum").addEnum("FUCK").build();
//        MyEnum FUCK = ClassTinkerers.getEnum(MyEnum.class, "FUCK");
        System.out.println(Arrays.toString(MyEnum.values()));
    }
}
