package org.usfirst.frc.team840.robot;

import org.usfirst.frc.team840.robot.subsystems.DrivetrainTank;

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
	
	
	
	public OI() {
		SmartDashboard.putNumber("Left motor speed: ",DrivetrainTank.driveMotorLeft.getSpeed());
		SmartDashboard.putNumber("Right motor speed:",DrivetrainTank.driveMotorRight.getSpeed());
	}
	
	public Joystick getJoyLeft() {
		return joyLeft;
	}
	public Joystick getJoyRight() {
		return joyRight;
	}
}

