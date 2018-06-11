import org.jnativehook.keyboard.NativeKeyEvent;

import javax.swing.text.html.Option;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;

/**
 * A Java Robot example class.
 * <p>
 * Caution: Using the Java Robot class improperly can cause
 * a lot of system problems. I had to reboot my Mac ~10
 * times yesterday while trying to debug this code.
 * <p>
 * I created this class to demonstrate the Java Robot
 * class on a Mac OS X system, though it should run on Linux
 * or Windows as well.
 * <p>
 * On a Mac system, I place the TextEdit text editor in the
 * upper-left corner of the screen, and put a bunch of blank lines
 * in the editor. Then I run this Java Robot example from
 * Eclipse or the Unix command line.
 * <p>
 * It types the three strings shown in the code below into
 * the text editor.
 * <p>
 * Many thanks to the people on the Mac Java-dev mailing list
 * for your help.
 *
 * @author Alvin Alexander, http://devdaily.com
 */
public class RobotTrigger {
    Robot robot = null;
    public static RobotTrigger INST = new RobotTrigger();
    public RobotTrigger() {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public void fireShotGun1(){
        //leftClick();
        type("3");
    }
    public void fireShotGun2(){
        //leftClick();
        type("2");
    }


    private void leftClick() {
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }

    private void type(int i) {
        robot.keyPress(i);
        robot.keyRelease(i);

    }

    public void type(String s) {
        byte[] bytes = s.getBytes();
        for (byte b : bytes) {
            int code = b;
            // keycode only handles [A-Z] (which is ASCII decimal [65-90])
            if (code > 96 && code < 123) code = code - 32;
            //robot.delay(40);
            robot.keyPress(code);
            robot.keyRelease(code);
        }
        if ("2".equals(s)){
            CurrentOption option = MainApp.getOption();
            option.setMode(Mode.SHOTGUN1);
        }
        if ("3".equals(s)){
            CurrentOption option = MainApp.getOption();
            option.setMode(Mode.SHOTGUN2);
        }
    }
}