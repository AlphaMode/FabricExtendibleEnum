package net.alphamode.test.enums;

import com.chocohead.mm.api.ClassTinkerers;
import net.alphamode.enums.EnumUtil;
import org.objectweb.asm.Type;

public class ER implements Runnable {
    @Override
    public void run() {
        ClassTinkerers.addTransformation("net.alphamode.test.enums.MyEnum", classNode -> EnumUtil.enumExtender.processClassWithFlags(classNode, Type.getObjectType("net/alphamode/test/enums/MyEnum")));
    }
}
