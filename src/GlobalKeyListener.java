import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.util.Timer;
import java.util.TimerTask;

public class GlobalKeyListener implements NativeKeyListener {
    private CurrentOption option;
    private RobotTrigger robot = new RobotTrigger();

    public static boolean isCanFire() {
        return canFire;
    }

    static boolean canFire = true;
    public void nativeKeyPressed(NativeKeyEvent e) {

        //System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
        if (option.mode == Mode.NONE){
            if (e.getKeyCode() == NativeKeyEvent.VC_O){
                System.out.println("Turn on tool");
                option.setMode(Mode.RIFFLE);
            }else{
                return;
            }
        }

        if (e.getKeyCode() == NativeKeyEvent.VC_2){
            Mode oldMode = option.getMode();
            option.setMode(Mode.SHOTGUN1);
            System.out.println("Set mode shotgun 1");
            if (canFire && oldMode != Mode.SHOTGUN1){
                canFire = false;
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        canFire = true;
                    }
                }, 800);
            }
        }else if (e.getKeyCode() == NativeKeyEvent.VC_3){
            Mode oldMode = option.getMode();
            option.setMode(Mode.SHOTGUN2);
            System.out.println("Set mode shotgun 2");
            if (canFire  && oldMode != Mode.SHOTGUN2){
                canFire = false;
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        option.setMode(Mode.SHOTGUN2);
                        canFire = true;
                    }
                }, 500);
            }


        }else if(e.getKeyCode() == NativeKeyEvent.VC_1
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
        }else if (e.getKeyCode() == NativeKeyEvent.VC_P) {
            option.setMode(Mode.NONE);
            System.out.println("Turn off tool");
            //GlobalScreen.unregisterNativeHook();
        }
    }

    public void nativeKeyReleased(NativeKeyEvent e) {
        //System.out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
    }

    public void nativeKeyTyped(NativeKeyEvent e) {
        //System.out.println("Key Typed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
    }

    public GlobalKeyListener(CurrentOption option) {
        this.option = option;
    }
}
