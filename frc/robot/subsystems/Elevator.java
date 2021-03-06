package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.commands.DrivetrainTeleop;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Elevator extends Subsystem {

	private TalonSRX elevator;
	
	public Elevator() {
		elevator = new TalonSRX(RobotMap.ELEVATOR);
	}
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new DrivetrainTeleop());
	}
	
	public void move(double speed, int direction) {
		elevator.set(ControlMode.PercentOutput, speed * direction);
	}
	
}
