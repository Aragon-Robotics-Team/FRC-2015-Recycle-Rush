package org.usfirst.frc.team840.robot;

import org.usfirst.frc.team840.robot.commands.*;

import edu.art.frc.lib.util.Gamepad;
import edu.art.frc.lib.util.GamepadButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	private boolean devMode = false;
	
	private Gamepad driverPad = new Gamepad(0);
	private Gamepad operatorPad = new Gamepad(1);
	
	public Gamepad getGamepad() {
		return driverPad;
	}
	
	public OI() {
		GamepadButton leftStick = new GamepadButton(driverPad, "LEFT_JOYSTICK");
		GamepadButton rightStick = new GamepadButton(driverPad, "RIGHT_JOYSTICK");
		GamepadButton x = new GamepadButton(driverPad, "X");
		GamepadButton b = new GamepadButton(driverPad, "B");
		GamepadButton y = new GamepadButton(driverPad, "Y");
		GamepadButton a = new GamepadButton(driverPad, "A");
		GamepadButton leftTrigger = new GamepadButton(driverPad, "LEFT_TRIGGER");
		GamepadButton rightTrigger = new GamepadButton(driverPad, "RIGHT_TRIGGER");
		GamepadButton leftBumper = new gamepadButton(driverPad, "LEFT_BUMPER");
		GamepadButton rightBumper = new gamepadButton(driverPad, "RIGHT_BUMPER");
		GamepadButton start = new gamepadButton(driverPad, "START");
		
		GamepadButton a2 = new GamepadButton(operatorPad, "A");
		GamepadButton b2 = new GamepadButton(operatorPad, "B");
		GamepadButton leftBumper2 = new gamepadButton(operatorPad, "LEFT_BUMPER");
		GamepadButton rightBumper2 = new gamepadButton(operatorPad, "RIGHT_BUMPER");
		GamepadButton start2 = new gamepadButton(operatorPad, "START");
		
		if(devMode) {
			leftStick.toggleWhenActive(new ArcadeDriveCreep());
			rightStick.toggleWhenActive(new ArcadeDriveCreep());
			
			a.whenPressed(new SetLiftBottomEncoder());
			b.whenPressed(new SetLiftLoadToteEncoder());
			x.whenPressed(new SlideIn());
			y.whenPressed(new SlideOut());
			
			leftBumper.whileHeld(new RollOut());
			rightBumper.whileHeld(new RollIn());
			
			start.whenPressed(new Calibration());
		} else {
			leftStick.toggleWhenActive(new ArcadeDriveCreep());
			rightStick.toggleWhenActive(new ArcadeDriveCreep());
			
			leftBumper.whileHeld(new RollOut());
			rightBumper.whileHeld(new RollIn());
		
			a2.whenPressed(new SetLiftBottomEncoder());
			b2.whenPressed(new SetLiftLoadToteEncoder());
			leftBumper2.whenPressed(new SlideIn());
			rightBumper2.whenPressed(new SlideOut());
			
			start2.whenPressed(new Calibration());
		}
	}
}
