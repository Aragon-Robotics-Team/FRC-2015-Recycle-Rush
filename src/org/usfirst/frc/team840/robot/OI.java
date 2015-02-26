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
	
	private Gamepad driverPad = new Gamepad(0);	//Gamepad for the main driver. This controller should have control over the drivetrain and rollers, as well as robot wide overrides.
	private Gamepad operatorPad = new Gamepad(1);	//Gamepad for the secondary driver. This controller should have control over the lift and pneumatics.
	
	public Gamepad getDriverPad() {
		return driverPad;
	}
	
	public Gamepad getOperatorPad() {
		return operatorPad;
	}
	
	public OI() {
		GamepadButton aOperator = new GamepadButton(operatorPad, "A");
		GamepadButton bOperator = new GamepadButton(operatorPad, "B");
		GamepadButton xOperator = new GamepadButton(operatorPad, "X");
		GamepadButton yOperator = new GamepadButton(operatorPad, "Y");
	
		
		aOperator.whenPressed(new DeadTurn(2.0, "left"));
		bOperator.whenPressed(new DeadTurn(2.0, "right"));
		yOperator.whenPressed(new DeadStraight(1.0);
		

	}
}
