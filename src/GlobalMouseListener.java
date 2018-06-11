import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;


public class GlobalMouseListener implements NativeMouseInputListener {
    private CurrentOption option;
    RobotTrigger robot = RobotTrigger.INST;
    public void nativeMouseClicked(NativeMouseEvent e) {
        //System.out.println("Mouse Clicked: " + e.getClickCount());
    }

    public void nativeMousePressed(NativeMouseEvent e) {
        if (option.mode == Mode.SHOTGUN1 && e.getButton() == 1){
            robot.fireShotGun1();
        }else if (option.mode == Mode.SHOTGUN2 && e.getButton() == 1){
            robot.fireShotGun2();
        }

        //System.out.println("Mouse Pressed: " + e.getButton());
    }

    public void nativeMouseReleased(NativeMouseEvent e) {
        //System.out.println("Mouse Released: " + e.getButton());
    }

    public void nativeMouseMoved(NativeMouseEvent e) {
        //System.out.println("Mouse Moved: " + e.getX() + ", " + e.getY());
    }

    public void nativeMouseDragged(NativeMouseEvent e) {
        //System.out.println("Mouse Dragged: " + e.getX() + ", " + e.getY());
    }

    public GlobalMouseListener(CurrentOption option) {
        this.option = option;
    }
}
