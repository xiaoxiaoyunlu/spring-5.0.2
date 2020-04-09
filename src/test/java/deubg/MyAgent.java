package deubg;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;

/**
 * @ClassName MyAgent
 * @Description TODO
 * @Author USER
 * @Date 2020/3/27 14:48
 * @Company
 **/
public class MyAgent {

	static private Instrumentation inst = null;

	public static void premain(String agentArgs, Instrumentation _inst){
		inst = _inst;

		ClassFileTransformer trans = new MyClassFileTransformer();

		System.out.println("Add a MyClassFileTransformer to the JVM");

		inst.addTransformer(trans);
	}
}
