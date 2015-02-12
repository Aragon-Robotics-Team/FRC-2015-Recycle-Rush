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
	
	private Gamepad gamepad = new Gamepad(0);
	private Gamepad gamepad2 = new Gamepad(1);
	
	public Gamepad getGamepad() {
		return gamepad;
	}
	
	public OI() {
		GamepadButton leftStick = new GamepadButton(gamepad, "LEFT_JOYSTICK");
		GamepadButton rightStick = new GamepadButton(gamepad, "RIGHT_JOYSTICK");
		GamepadButton x = new GamepadButton(gamepad, "X");
		GamepadButton b = new GamepadButton(gamepad, "B");
		GamepadButton y = new GamepadButton(gamepad, "Y");
		GamepadButton a = new GamepadButton(gamepad, "A");
		GamepadButton leftTrigger = new GamepadButton(gamepad, "LEFT_TRIGGER");
		GamepadButton rightTrigger = new GamepadButton(gamepad, "RIGHT_TRIGGER");
		GamepadButton leftBumper = new gamepadButton(gamepad, "LEFT_BUMPER");
		GamepadButton rightBumper = new gamepadButton(gamepad, "RIGHT_BUMPER");
		
		GamepadButton a2 = new GamepadButton(gamepad2, "A");
		GamepadButton b2 = new GamepadButton(gamepad2, "B");
		GamepadButton leftBumper2 = new gamepadButton(gamepad, "LEFT_BUMPER");
		GamepadButton rightBumper2 = new gamepadButton(gamepad, "RIGHT_BUMPER");
		GamepadButton start2 = new gamepadButton(gamepad, "START");
		
		if(devMode) {
			leftStick.toggleWhenActive(new ArcadeDriveCreep());
			rightStick.toggleWhenActive(new ArcadeDriveCreep());
			
			a.whenPressed(new SetLiftBottomEncoder());
			b.whenPressed(new SetLiftLoadToteEncoder());
			x.whenPressed(new SlideIn());
			y.whenPressed(new SlideOut());
			
			leftBumper.whenPressed(new RollOut());
			rightBumper.whenPressed(new RollIn());
		}	
		else {
			leftStick.toggleWhenActive(new ArcadeDriveCreep());
			rightStick.toggleWhenActive(new ArcadeDriveCreep());
			
			a.whileHeld(new RollIn());
			b.whileHeld(new RollOut());
		
			a2.whenPressed(new SetLiftBottomEncoder());
			b2.whenPressed(new SetLiftLoadToteEncoder());
			leftBumper2.whenPressed(new SlideIn());
			rightBumper2.whenPressed(new SlideOut());
			start.whenPressed(new Calibration());
		}
	}
}
