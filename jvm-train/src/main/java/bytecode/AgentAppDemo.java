package bytecode;

import java.lang.instrument.Instrumentation;

public class AgentAppDemo {
    public static void premain(String agentOps, Instrumentation inst) {
        System.out.println("============enter premain============");
        System.out.println(agentOps);
        inst.addTransformer(new AgentTransformer());
    }
}
