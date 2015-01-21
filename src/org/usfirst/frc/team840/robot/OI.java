package org.usfirst.frc.team840.robot;

import org.usfirst.frc.team840.robot.subsystems.DrivetrainTank;
import org.usfirst.frc.team840.robot.commands.TankDrive;
import org.usfirst.frc.team840.robot.commands.TankDriveCreep;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	private Joystick joyLeft = new Joystick(0);
	private Joystick joyRight = new Joystick(1);
	
	public Joystick getJoyLeft() {
		return joyLeft;
	}
	public Joystick getJoyRight() {
		return joyRight;
	}
	
	public OI() {
		JoystickButton triggerRight = new JoystickButton(joyRight, 1);
		JoystickButton left2 = new JoystickButton(joyLeft, 2);
		JoystickButton triggerLeft = new JoystickButton(joyLeft, 1);
		JoystickButton right2 = new JoystickButton(joyRight, 2);
		
		triggerLeft.whileHeld(new TankDriveCreep(RobotMap.CREEP_SPEED));
		triggerRight.whileHeld(new TankDriveCreep(RobotMap.CREEP_SPEED));
	}
}
