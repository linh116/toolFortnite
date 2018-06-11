import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class MainApp {

    public static CurrentOption option = new CurrentOption(Mode.RIFFLE);

    public static void main(String[] args) {
        try {
            // Clear previous logging configurations.zxc
            LogManager.getLogManager().reset();

            // Get the logger for "org.jnativehook" and set the level to off.
            Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
            logger.setLevel(Level.OFF);

            GlobalScreen.registerNativeHook();
            System.out.println("Register Hook Server Success.");
        }
        catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());

            System.exit(1);
        }

        GlobalScreen.addNativeKeyListener(new GlobalKeyListener(option));
        System.out.println("Register GlobalKeyListener Success.");

        GlobalScreen.addNativeMouseListener(new GlobalMouseListener(option));
        System.out.println("Register GlobalMouseListener Success.");
    }

    public static CurrentOption getOption() {
        return option;
    }
}
