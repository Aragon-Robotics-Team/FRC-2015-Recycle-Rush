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
		return getRawAxis(0);
	}
	public double getLeftY() {
		return getRawAxis(1);
	}
	public double getRightX() {
		return getRawAxis(2);
	}
	public double getRightY() {
		return getRawAxis(3);
	}
	
	//Joystick buttons
	public boolean getButtonLeftJoystick() {
		return getRawButton(11);
	}
	public boolean getButtonRightJoystick() {
		return getRawButton(12);
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
	
	//Front of controller
	public boolean getButtonBack() {
		return getRawButton(9);
	}
	public boolean getButtonStart() {
		return getRawButton(10);
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
	public double getDPadX() {
		return getRawAxis(4);
	}
	public boolean getDPadLeft() {
		return getDPadX() < -0.5;
	}
	public boolean getDPadRight() {
		return getDPadX() > 0.5;
	}
}
