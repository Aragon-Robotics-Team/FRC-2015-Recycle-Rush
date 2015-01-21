package org.usfirst.frc.team840.robot;

import org.usfirst.frc.team840.robot.subsystems.DrivetrainTank;
import org.usfirst.frc.team840.robot.commands.TankDrive;
import org.usfirst.frc.team840.robot.commands.TankDriveCreep;
import org.usfirst.frc.team840.robot.commands.TankDriveStraight;

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
	private JoystickButton triggerLeft = new JoystickButton(joyLeft, 1);
	private JoystickButton triggerRight = new JoystickButton(joyRight, 1);
	private JoystickButton left2 = new JoystickButton(joyLeft, 2);
	private JoystickButton right2 = new JoystickButton(joyRight, 2);
	
	public OI() {
		triggerLeft.whileHeld(new TankDriveCreep(true, RobotMap.CREEP_SPEED));
		triggerRight.whileHeld(new TankDriveCreep(false, RobotMap.CREEP_SPEED));
		left2.whileHeld(new TankDriveStraight());
		right2.whileHeld(new TankDriveStraight());
		
	}
	
	public Joystick getJoyLeft() {
		return joyLeft;
	}
	public Joystick getJoyRight() {
		return joyRight;
	}
}
