package edu.art.frc.lib.util;

import edu.wpi.first.wpilibj.Joystick;
/*
 * Gamepad class for easier interface with a Logitech gamepad. Names functions in intuitive ways for easy use.
 */

public class Gamepad extends Joystick {

	public Gamepad(int port) {
		super(port);
	}

	
	//4 axes on the dual thumb-sticks
	public double getLeftX() {
		return getRawAxis(1);
	}
	
	public double getLeftY() {
		return getRawAxis(2);
	}
	
	public double getRightX() {
		return getRawAxis(4);
	}
	
	public double getRightY() {
		return getRawAxis(5);
	}
	
	//Face buttons
	public boolean getButtonA() {
		return getRawButton(2);
	}
	
	public boolean getButtonB() {
		return getRawButton(3);
	}

	public boolean getButtonX() {
		return getRawButton(1);
	}

	public boolean getButtonY() {
		return getRawButton(4);
	}
	
	public boolean getButtonBack() {
		return getRawButton(9);
	}
	
	public boolean getButtonStart() {
		return getRawButton(10);
	}
	
	public boolean getButtonLeftJoystick() {
		return getRawButton(11);
	}
	
	public boolean getButtonRightJoystick() {
		return getRawButton(12);
	}
	
	//Back of controller
	public boolean getLeftBumper() {
		return getRawButton(5);
	}
	
	public boolean getLeftTrigger() {
		return getRawButton(7);
	}
	
	public boolean getRightBumper() {
		return getRawButton(6);
	}
	
	public boolean getRightTrigger() {
		return getRawButton(8);
	}
	
	//D-pad
	public int getDPadAngle() {
		return getPOV(0);
	}
	
	public boolean getDPadLeft() {
		if (getDPadAngle() == 180) return true;
		return false;
	}
	public boolean getDPadRight() {
		if (getDPadAngle() == 0) return true;
		return false; 
	}
	public boolean getDPadUp() {
		if (getDPadAngle() == 90) return true;
		return false;
	}
	public boolean getDPadDown() {
		if (getDPadAngle() == 270) return true;
		return false;
	}
}
