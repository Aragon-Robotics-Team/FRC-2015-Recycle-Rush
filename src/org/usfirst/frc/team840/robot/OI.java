package org.usfirst.frc.team840.robot;

import org.usfirst.frc.team840.robot.commands.ArcadeDriveCreep;

import edu.art.frc.lib.util.Gamepad;
import edu.art.frc.lib.util.GamepadButton;



/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	private Gamepad gamepad = new Gamepad(0);
	
	public Gamepad getGamepad() {
		return gamepad;
	}
	
	public OI() {
		GamepadButton leftStick = new GamepadButton(gamepad, "LEFT_JOYSTICK");
		GamepadButton rightStick = new GamepadButton(gamepad, "RIGHT_JOYSTICK");
		
		leftStick.toggleWhenActive(new ArcadeDriveCreep());
		rightStick.toggleWhenActive(new ArcadeDriveCreep());
	}
}
