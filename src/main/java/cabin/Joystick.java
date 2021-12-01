package cabin;

import controls.Button;
import truck.ICentralUnit;

public class Joystick {

    private final JoystickType type;
    private final Button frontLeftButton;
    private final Button frontRightButton;
    private final Button backSwitch;

    public Joystick(ICentralUnit centralUnit, JoystickType type) {
        this.type = type;
        if (type == JoystickType.LEFT) {
            this.frontLeftButton = new Button(centralUnit, ButtonType.LEFT_JOYSTICK_LEFT);
            this.frontRightButton = new Button(centralUnit, ButtonType.LEFT_JOYSTICK_RIGHT);
            this.backSwitch = new Button(centralUnit, ButtonType.LEFT_JOYSTICK_BACK);
        } else {
            this.frontLeftButton = new Button(centralUnit, ButtonType.RIGHT_JOYSTICK_LEFT);
            this.frontRightButton = new Button(centralUnit, ButtonType.RIGHT_JOYSTICK_RIGHT);
            this.backSwitch = new Button(centralUnit, ButtonType.RIGHT_JOYSTICK_BACK);
        }
    }

    public JoystickType getType() {
        return type;
    }

    public Button getFrontLeftButton() {
        return frontLeftButton;
    }

    public Button getFrontRightButton() {
        return frontRightButton;
    }

    public Button getBackSwitch() {
        return backSwitch;
    }

}
