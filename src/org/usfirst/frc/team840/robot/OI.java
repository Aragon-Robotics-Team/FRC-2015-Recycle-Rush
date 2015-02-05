package org.usfirst.frc.team840.robot;

//import org.usfirst.frc.team840.robot.commands.ArcadeDriveCreep;
import org.usfirst.frc.team840.robot.commands.*;

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
		
		GamepadButton x = new GamepadButton(gamepad, "X");
		GamepadButton b = new GamepadButton(gamepad, "B");
		GamepadButton y = new GamepadButton(gamepad, "Y");
		GamepadButton a = new GamepadButton(gamepad, "A");
		
		GamepadButton leftBumper = new GamepadButton(gamepad, "LEFT_BUMPER");
		GamepadButton rightBumper = new GamepadButton(gamepad, "RIGHT_BUMPER");
		
		leftStick.toggleWhenActive(new ArcadeDriveCreep());
		rightStick.toggleWhenActive(new ArcadeDriveCreep());
		
		x.whenPressed(new SlideIn());
		b.whenPressed(new SlideOut());
		y.whenPressed(new SetLift(9001));
		a.whenPressed(new SetLift(0));
		
		leftBumper.whileHeld(new SetLift(Robot.stacker.getPosition() - 1));
		rightBumper.whileHeld(new SetLift(Robot.stacker.getPosition() + 1));
	}
}
