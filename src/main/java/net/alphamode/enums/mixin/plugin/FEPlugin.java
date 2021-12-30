/*
 * AlphaMode
 * Copyright (c) 2021.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation version 2.1
 * of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */

package net.alphamode.enums.mixin.plugin;

import com.chocohead.mm.api.ClassTinkerers;
import net.alphamode.enums.RuntimeEnumExtender;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.MappingResolver;
import net.fabricmc.loader.entrypoint.minecraft.hooks.EntrypointUtils;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import net.minecraft.util.Formatting;

public class FEPlugin implements IMixinConfigPlugin {
    private final RuntimeEnumExtender enumExtender = new RuntimeEnumExtender();
    private final MappingResolver resolver = FabricLoader.getInstance().getMappingResolver();
    public static final List<String> enums = new ArrayList<>();

    @Override
    public void onLoad(String mixinPackage) {
//        ClassTinkerers.enumBuilder(resolver.mapClassName("intermediary", "net.minecraft.class_1814"), "L" + resolver.mapClassName("intermediary", "net.minecraft.class_124") + ";").addEnum("GREEN", Formatting.DARK_GREEN).build();
//        EntrypointUtils.invoke("enum", Runnable.class, Runnable::run);
    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        return true;
        //return !mixinClassName.startsWith("net.alphamode.enums.mixin") || !FabricLoader.getInstance().isModLoaded("mm");
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
    }

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
        if(targetClass.interfaces.contains("net/alphamode/enums/IExtensibleEnum")) {
            enumExtender.processClassWithFlags(targetClass, Type.getObjectType(targetClassName.replace('.', '/')));
        }
    }
}
