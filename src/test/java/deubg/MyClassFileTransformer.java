package deubg;

import javassist.*;

import java.io.ByteArrayInputStream;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;
import java.util.Arrays;

/**
 * @ClassName MyClassFileTransformer
 * @Description TODO
 * @Author USER
 * @Date 2020/3/27 14:23
 * @Company
 **/
public class MyClassFileTransformer implements ClassFileTransformer {

	@Override
	public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {

		byte[] transformed = null;
		System.out.println("Transforming: "+className);

		ClassPool pool = ClassPool.getDefault();
		CtClass cl = null;
		try {
			cl = pool.makeClass(new ByteArrayInputStream(classfileBuffer));
			if(!cl.isInterface()){
				CtBehavior[] methods = cl.getDeclaredBehaviors();
				Arrays.stream(methods).forEach(method->{
					if(!method.isEmpty()){
						// 修改method 字节码
						doMethod(method);
					}
				});
				transformed = cl.toBytecode();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(cl!=null){
				cl.detach();
			}
		}
		return transformed;

	}

	private void doMethod(CtBehavior method) throws NotFoundException {
		method.insertBefore("long stime=System.nanoTime()");

		String afterStr = "System.out.println(\"leave \"+method.getName()+\" and time:\"+(System.nanoTime()-stime));";

		method.insertAfter(afterStr);
	}
}
