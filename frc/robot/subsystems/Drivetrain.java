package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.commands.DrivetrainTeleop;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivetrain extends Subsystem {

	private TalonSRX frontLeft;
	private TalonSRX frontRight;
	private TalonSRX backLeft;
	private TalonSRX backRight;
	
	public Drivetrain() {
		frontLeft = new TalonSRX(RobotMap.TALON_DRIVE_FRONT_LEFT);
		frontRight = new TalonSRX(RobotMap.TALON_DRIVE_FRONT_RIGHT);
		backLeft = new TalonSRX(RobotMap.TALON_DRIVE_BACK_LEFT);
		backRight = new TalonSRX(RobotMap.TALON_DRIVE_BACK_RIGHT);
		
		backLeft.follow(frontLeft);
		backRight.follow(frontRight);
	}
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new DrivetrainTeleop());
	}
	
	public void move(double leftValue, double rightValue) {
		leftValue = limit(leftValue) * -1;
		rightValue = limit(rightValue) * -1;
		
		frontLeft.set(ControlMode.PercentOutput, leftValue);
		frontRight.set(ControlMode.PercentOutput, rightValue * -1);
	}

	private double limit(double num) {
		return Math.max(Math.min(num, 1.0), -1.0);	
	}
	
}
