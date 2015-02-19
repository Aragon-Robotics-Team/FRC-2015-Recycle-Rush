package org.usfirst.frc.team840.robot;

import org.usfirst.frc.team840.robot.commands.*;

import edu.art.frc.lib.util.Gamepad;
import edu.art.frc.lib.util.GamepadButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
@SuppressWarnings("unused")
public class OI {
	
	//Gamepad for the main driver. This controller should have control over the drivetrain and rollers, as well as robot wide overrides.
	private Gamepad driverPad = new Gamepad(0);	
	//Gamepad for the secondary driver. This controller should have control over the lift and pneumatics.
	private Gamepad operatorPad = new Gamepad(1);
	
	public Gamepad getDriverPad() {
		return driverPad;
	}
	
	public Gamepad getOperatorPad() {
		return operatorPad;
	}
	
	public OI() {
		GamepadButton leftBumperDriver = new GamepadButton(driverPad, "LEFT_BUMPER");
		GamepadButton rightBumperDriver = new GamepadButton(driverPad, "RIGHT_BUMPER");
		GamepadButton leftTriggerDriver = new GamepadButton(driverPad, "LEFT_TRIGGER");
		GamepadButton rightTriggerDriver = new GamepadButton(driverPad, "RIGHT_TRIGGER");
		GamepadButton leftStickDriver = new GamepadButton(driverPad, "LEFT_JOYSTICK");
		GamepadButton rightStickDriver = new GamepadButton(driverPad, "RIGHT_JOYSTICK");
		
		GamepadButton aOperator = new GamepadButton(operatorPad, "A");
		GamepadButton bOperator = new GamepadButton(operatorPad, "B");
		GamepadButton yOperator = new GamepadButton(operatorPad, "Y");
		GamepadButton leftBumperOperator = new GamepadButton(operatorPad, "LEFT_BUMPER");
		GamepadButton leftTriggerOperator = new GamepadButton(operatorPad, "LEFT_TRIGGER");
		GamepadButton leftStickOperator = new GamepadButton(operatorPad, "LEFT_JOYSTICK");
		GamepadButton startOperator = new GamepadButton(operatorPad, "START");
		
		//Driver controls
		leftStickDriver.toggleWhenActive(new ArcadeDriveCreep());
		
		leftBumperDriver.whileHeld(new RollIn());
		rightBumperDriver.whileHeld(new RollOut());
		leftTriggerDriver.whileHeld(new RollTurnClockwise());
		rightTriggerDriver.whileHeld(new RollTurnCounterClockwise());
	
		//Operator controls
		leftStickOperator.whileHeld(new LiftManualEncoder());
		
		aOperator.whenPressed(new SetLiftBottomEncoder());
		bOperator.whenPressed(new SetLiftLoadToteEncoder());
		yOperator.whenPressed(new SetLiftScorePlatformEncoder());
		
		leftBumperOperator.whenPressed(new SlideIn());
		leftTriggerOperator.whenPressed(new SlideOut());
		
		startOperator.whenPressed(new ZeroLiftEncoder());
	}
}
