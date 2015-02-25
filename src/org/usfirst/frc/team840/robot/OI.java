package org.usfirst.frc.team840.robot;

import org.usfirst.frc.team840.robot.commands.*;
import org.usfirst.frc.team840.robot.commands.driving.ArcadeDriveCreep;
import org.usfirst.frc.team840.robot.commands.lift.LiftManual;
import org.usfirst.frc.team840.robot.commands.lift.ZeroLiftEncoder;
import org.usfirst.frc.team840.robot.commands.lift.presets.SetLiftBottom;
import org.usfirst.frc.team840.robot.commands.lift.presets.SetLiftLoadTote;
import org.usfirst.frc.team840.robot.commands.lift.presets.SetLiftScorePlatform;
import org.usfirst.frc.team840.robot.commands.sliders.SlideIn;
import org.usfirst.frc.team840.robot.commands.sliders.SlideOut;

import edu.art.frc.lib.util.Gamepad;
import edu.art.frc.lib.util.GamepadButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
@SuppressWarnings("unused")
public class OI {
	
	private Gamepad driverPad = new Gamepad(0);	//Gamepad for the main driver. This controller should have control over the drivetrain and rollers, as well as robot wide overrides.
	private Gamepad operatorPad = new Gamepad(1);	//Gamepad for the secondary driver. This controller should have control over the lift and pneumatics.
	
	public Gamepad getDriverPad() {
		return driverPad;
	}
	
	public Gamepad getOperatorPad() {
		return operatorPad;
	}
	
	public OI() {
		GamepadButton aDriver = new GamepadButton(driverPad, "A");
		GamepadButton bDriver = new GamepadButton(driverPad, "B");
		GamepadButton yDriver = new GamepadButton(driverPad, "Y");
		GamepadButton xDriver = new GamepadButton(driverPad, "X");
		GamepadButton leftBumperDriver = new GamepadButton(driverPad, "LEFT_BUMPER");
		GamepadButton rightBumperDriver = new GamepadButton(driverPad, "RIGHT_BUMPER");
		GamepadButton leftTriggerDriver = new GamepadButton(driverPad, "LEFT_TRIGGER");
		GamepadButton rightTriggerDriver = new GamepadButton(driverPad, "RIGHT_TRIGGER");
		GamepadButton leftStickDriver = new GamepadButton(driverPad, "LEFT_JOYSTICK");
		GamepadButton rightStickDriver = new GamepadButton(driverPad, "RIGHT_JOYSTICK");
		GamepadButton startDriver = new GamepadButton(driverPad, "START");
		
		GamepadButton aOperator = new GamepadButton(operatorPad, "A");
		GamepadButton bOperator = new GamepadButton(operatorPad, "B");
		GamepadButton xOperator = new GamepadButton(operatorPad, "X");
		GamepadButton yOperator = new GamepadButton(operatorPad, "Y");
		GamepadButton leftBumperOperator = new GamepadButton(operatorPad, "LEFT_BUMPER");
		GamepadButton rightBumperOperator = new GamepadButton(operatorPad, "RIGHT_BUMPER");
		GamepadButton leftTriggerOperator = new GamepadButton(operatorPad, "LEFT_TRIGGER");
		GamepadButton rightTriggerOperator = new GamepadButton(operatorPad, "RIGHT_TRIGGER");
		GamepadButton leftStickOperator = new GamepadButton(operatorPad, "LEFT_JOYSTICK");
		GamepadButton rightStickOperator = new GamepadButton(operatorPad, "RIGHT_JOYSTICK");
		GamepadButton startOperator = new GamepadButton(operatorPad, "START");
		
		//Driver controls
		leftStickDriver.toggleWhenActive(new ArcadeDriveCreep());
		
		leftBumperDriver.whileHeld(new RollIn());
		rightBumperDriver.whileHeld(new RollOut());
		leftTriggerDriver.whileHeld(new RollTurnClockwise());
		rightTriggerDriver.whileHeld(new RollTurnClockwise());
	
		//Operator controls
		leftStickOperator.whileHeld(new LiftManual());
		
		aOperator.whenPressed(new SetLiftBottom());
		bOperator.whenPressed(new SetLiftLoadTote());
		yOperator.whenPressed(new SetLiftScorePlatform());
		
		leftBumperOperator.whenPressed(new SlideIn());
		leftTriggerOperator.whenPressed(new SlideOut());
		
		startOperator.whenPressed(new ZeroLiftEncoder());
	}
}
