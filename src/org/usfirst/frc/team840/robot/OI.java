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
	private boolean devMode = false;
	
	//Initialize gamepad 
	private Gamepad driverPad = new Gamepad(0);
	private Gamepad operatorPad = new Gamepad(1);
	
	public Gamepad getDriverPad() {
		return driverPad;
	}
	
	public Gamepad getOperatorPad() {
		return operatorPad;
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
		GamepadButton leftTrigger = new GamepadButton(driverPad, "LEFT_TRIGGER");
		GamepadButton rightTrigger = new GamepadButton(driverPad, "RIGHT_TRIGGER");
		GamepadButton start = new GamepadButton(driverPad, "START");
		
		GamepadButton a2 = new GamepadButton(operatorPad, "A"); //For operator controller
		GamepadButton b2 = new GamepadButton(operatorPad, "B");
		GamepadButton x2 = new GamepadButton(operatorPad, "X");
		GamepadButton y2 = new GamepadButton(operatorPad, "Y");
		GamepadButton leftBumper2 = new GamepadButton(operatorPad, "LEFT_BUMPER");
		GamepadButton rightBumper2 = new GamepadButton(operatorPad, "RIGHT_BUMPER");
		GamepadButton leftTrigger2 = new GamepadButton(operatorPad, "LEFT_TRIGGER");
		GamepadButton rightTrigger2 = new GamepadButton(operatorPad, "RIGHT_TRIGGER");
		GamepadButton start2 = new GamepadButton(operatorPad, "START");
		
		
		if(devMode) {	//This must be redone
			leftStick.toggleWhenActive(new ArcadeDriveCreep());
			rightStick.toggleWhenActive(new ArcadeDriveCreep());
			
			a.whenPressed(new SetLiftBottomEncoder());
			b.whenPressed(new SetLiftLoadToteEncoder());
			
			leftTrigger.whenPressed(new SetLiftScorePlatformEncoder());
			
			leftBumper.whileHeld(new RollIn());
			rightBumper.whileHeld(new RollOut());
			leftTrigger.whenPressed(new SlideIn());
			rightTrigger.whenPressed(new SlideOut());
			
			start.whenPressed(new ZeroLiftEncoder());
		}
		else {
			leftStick.toggleWhenActive(new ArcadeDriveCreep()); //Driver controller
			rightStick.toggleWhenActive(new ArcadeDriveCreep());
			
			leftBumper.whileHeld(new RollIn());
			rightBumper.whileHeld(new RollOut());
			y.whileHeld(new RollTurnClockwise());
			x.whileHeld(new RollTurnCounterClockwise());
		
			a2.whenPressed(new SetLiftBottomEncoder()); //Operator controller
			b2.whenPressed(new SetLiftLoadToteEncoder());
			y2.whenPressed(new SetLiftScorePlatformEncoder());
			
			rightTrigger2.whileHeld(new LiftManualEncoder());
			
			leftBumper2.whenPressed(new SlideIn());
			rightBumper2.whenPressed(new SlideOut());
			
			start2.whenPressed(new ZeroLiftEncoder());
		}
	}
}
