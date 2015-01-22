package org.usfirst.frc.team840.robot;

import org.usfirst.frc.team840.robot.commands.TankDriveCreep;
import org.usfirst.frc.team840.robot.subsystems.Accelerometer;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	private Joystick joyLeft = new Joystick(0);
	private Joystick joyRight = new Joystick(1);
	private SmartDashboard sd = new SmartDashboard;
	
	public Joystick getJoyLeft() {
		return joyLeft;
	}
	
	public Joystick getJoyRight() {
		return joyRight;
	}
	
	public OI() {
		JoystickButton triggerRight = new JoystickButton(joyRight, 1);
		JoystickButton triggerLeft = new JoystickButton(joyLeft, 1);
		
		triggerLeft.whileHeld(new TankDriveCreep(RobotMap.CREEP_SPEED));
		triggerRight.whileHeld(new TankDriveCreep(RobotMap.CREEP_SPEED));
		sd.putData(Accelerometer);
	}
}
