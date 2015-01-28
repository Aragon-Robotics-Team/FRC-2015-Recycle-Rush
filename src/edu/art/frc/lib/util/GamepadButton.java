package edu.art.frc.lib.util;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/*
 * To be used in conjunction with our Gamepad object. This allows for the creation of Buttons, which are used in commmand based programming.
 */

public class GamepadButton extends JoystickButton {

	public GamepadButton(GenericHID gamepad, String buttonName) {
		super(gamepad, buttonNumber(buttonName));
	}
	
	private static int buttonNumber(String buttonName) {	//TODO If buttons are added to Gamepad.java, add them to the constructor helper as well.
		switch(buttonName) {
		case "A":
			return 2;
		case "B":
			return 3;
		case "X":
			return 1;
		case "Y":
			return 4;
		case "LEFT_BUMPER":
			return 5;
		case "LEFT_TRIGGER":
			return 7;
		case "RIGHT_BUMPER":
			return 6;
		case "RIGHT_TRIGGER":
			return 8;
		default:
			return -1;
		
		}
	}

}
