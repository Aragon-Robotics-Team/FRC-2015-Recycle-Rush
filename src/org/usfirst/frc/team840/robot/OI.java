package org.usfirst.frc.team840.robot;

import org.usfirst.frc.team840.robot.commands.*;

import edu.art.frc.lib.util.Gamepad;
import edu.art.frc.lib.util.GamepadButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */

public class OI {
	
	//Allows player to control with single gamepad
	private boolean devMode = true;
	
	//Initialize gamepad 
	private Gamepad driverPad = new Gamepad(0);
	private Gamepad operatorPad = new Gamepad(1);
	
	public Gamepad getGamepad() {
		return driverPad;
	}
	
	//Set all the buttons and their tasks
	public OI() {
		GamepadButton leftStick = new GamepadButton(driverPad, "LEFT_JOYSTICK"); //For driver controller
		GamepadButton rightStick = new GamepadButton(driverPad, "RIGHT_JOYSTICK");
		GamepadButton x = new GamepadButton(driverPad, "X");
		GamepadButton b = new GamepadButton(driverPad, "B");
		GamepadButton y = new GamepadButton(driverPad, "Y");
		GamepadButton a = new GamepadButton(driverPad, "A");
		GamepadButton leftBumper = new GamepadButton(driverPad, "LEFT_BUMPER");
		GamepadButton rightBumper = new GamepadButton(driverPad, "RIGHT_BUMPER");
		GamepadButton start = new GamepadButton(driverPad, "START");
		
		GamepadButton a2 = new GamepadButton(operatorPad, "A"); //For operator controller
		GamepadButton b2 = new GamepadButton(operatorPad, "B");
		GamepadButton leftBumper2 = new GamepadButton(operatorPad, "LEFT_BUMPER");
		GamepadButton rightBumper2 = new GamepadButton(operatorPad, "RIGHT_BUMPER");
		GamepadButton start2 = new GamepadButton(operatorPad, "START");
		
		
		if(devMode) {
			leftStick.toggleWhenActive(new ArcadeDriveCreep()); //Developer mode
			rightStick.toggleWhenActive(new ArcadeDriveCreep());
			
			a.whenPressed(new SetLiftBottomEncoder());
			b.whenPressed(new SetLiftLoadToteEncoder());
			x.whenPressed(new SlideIn());
			y.whenPressed(new SlideOut());
			
			leftBumper.whileHeld(new RollOut());
			rightBumper.whileHeld(new RollIn());
			
			start.whenPressed(new ZeroLiftEncoder());
		}
		else {
			leftStick.toggleWhenActive(new ArcadeDriveCreep()); //Driver controller
			rightStick.toggleWhenActive(new ArcadeDriveCreep());
			
			leftBumper.whileHeld(new RollOut());
			rightBumper.whileHeld(new RollIn());
		
			a2.whenPressed(new SetLiftBottomEncoder()); //Operator controller
			b2.whenPressed(new SetLiftLoadToteEncoder());
			leftBumper2.whenPressed(new SlideIn());
			rightBumper2.whenPressed(new SlideOut());
			
			start2.whenPressed(new ZeroLiftEncoder());
		}
	}
}
