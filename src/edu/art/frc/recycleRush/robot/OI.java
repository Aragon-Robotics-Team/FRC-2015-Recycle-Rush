package edu.art.frc.recycleRush.robot;

import edu.art.frc.lib.util.Gamepad;
import edu.art.frc.recycleRush.robot.commands.TankDriveCreep;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	private Joystick joyLeft = new Joystick(0);
	private Joystick joyRight = new Joystick(1);
	private Gamepad gamepad = new Gamepad(2);
	
	public Joystick getJoyLeft() {
		return joyLeft;
	}
	public Joystick getJoyRight() {
		return joyRight;
	}
	public Gamepad getGamepad() {
		return gamepad;
	}
	
	public OI() {
		JoystickButton triggerRight = new JoystickButton(joyRight, 1);
		JoystickButton triggerLeft = new JoystickButton(joyLeft, 1);
		JoystickButton left2 = new JoystickButton(joyLeft, 2);
		JoystickButton right2 = new JoystickButton(joyRight, 2);		
		
		triggerLeft.whileHeld(new TankDriveCreep(RobotMap.CREEP_SPEED));
		triggerRight.whileHeld(new TankDriveCreep(RobotMap.CREEP_SPEED));
		left2.whileHeld(new TankDriveCreep(RobotMap.CREEP_SPEED_ULTRA));
		right2.whileHeld(new TankDriveCreep(RobotMap.CREEP_SPEED_ULTRA));
	}
}
