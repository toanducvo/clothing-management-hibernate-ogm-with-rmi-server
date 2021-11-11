package app;

import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager == null) {
            System.setProperty("java.security.policy", "rmi/policy.policy");
            System.setSecurityManager(new SecurityManager());
        }

        try {
            LocateRegistry.createRegistry(9988);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
