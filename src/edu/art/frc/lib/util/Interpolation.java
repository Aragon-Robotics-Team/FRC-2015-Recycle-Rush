package edu.art.frc.lib.util;

/*
 * A class for interpolation functions. I plan to add more (slerp, nlerp, etc) as needed, but for now just basic lerp will do.
 */
public abstract class Interpolation {
	
	public static double lerp(double current, double target, double percent) {
		return current + percent * (target - current);
	}
	
	//TODO Add Brandon's algorithm if the above does not work.

}
