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
	private JoystickButton creep = new JoystickButton(2);
	
	
	
	public OI() {
	}
	
	public Joystick getJoyLeft() {
		return joyLeft;
	}
	public Joystick getJoyRight() {
		return joyRight;
	}
	if(!creep)
		TankDrive();
	if(creep){
		TankDriveCreep(true, 0.5);
		TankDriveCreep(false, 0.5);
	}
}


