import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class GlobalKeyListener implements NativeKeyListener {
    private CurrentOption option;
    private RobotTrigger robot = new RobotTrigger();

    public void nativeKeyPressed(NativeKeyEvent e) {

        System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));

        if (e.getKeyCode() == NativeKeyEvent.VC_2){
            try {
                Thread.sleep(800);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }

            option.setMode(Mode.SHOTGUN1);
            System.out.println("Set mode shotgun1");
        }

        if(e.getKeyCode() == NativeKeyEvent.VC_1
                || e.getKeyCode() == NativeKeyEvent.VC_3
                || e.getKeyCode() == NativeKeyEvent.VC_4
                || e.getKeyCode() == NativeKeyEvent.VC_5
                || e.getKeyCode() == NativeKeyEvent.VC_6
                || e.getKeyCode() == NativeKeyEvent.VC_F12
                || e.getKeyCode() == NativeKeyEvent.VC_F2
                || e.getKeyCode() == NativeKeyEvent.VC_F3
                || e.getKeyCode() == NativeKeyEvent.VC_F4
                || e.getKeyCode() == NativeKeyEvent.VC_F5
                || e.getKeyCode() == NativeKeyEvent.VC_C
                || e.getKeyCode() == NativeKeyEvent.VC_V
                || e.getKeyCode() == NativeKeyEvent.VC_Q
                || e.getKeyCode() == NativeKeyEvent.VC_F
                || e.getKeyCode() == NativeKeyEvent.VC_B
                || e.getKeyCode() == NativeKeyEvent.VC_BACKQUOTE){
            option.setMode(Mode.RIFFLE);
            System.out.println("Set mode Riffle");
        }

        if (e.getKeyCode() == NativeKeyEvent.VC_P) {
            try {
                GlobalScreen.unregisterNativeHook();
            } catch (NativeHookException e1) {
                e1.printStackTrace();
            }
        }
    }

    public void nativeKeyReleased(NativeKeyEvent e) {
        System.out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
    }

    public void nativeKeyTyped(NativeKeyEvent e) {
        System.out.println("Key Typed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
    }

    public GlobalKeyListener(CurrentOption option) {
        this.option = option;
    }
}
