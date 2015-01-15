package org.usfirst.frc.team840.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team840.robot.commands.RotateNegative;
import org.usfirst.frc.team840.robot.commands.RotatePositive;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	private Joystick joy0 = new Joystick(0);
	private Joystick joy1 = new Joystick(1);
	
	public OI() {
		JoystickButton trigger0 = new JoystickButton(joy0, 1);
		JoystickButton trigger1 = new JoystickButton(joy1, 1);
		
		trigger0.whenPressed(new RotatePositive());	//Both of these should function the same in this case, as the command kills when the button is lifted
		trigger1.whileHeld(new RotateNegative());	
	}
}

