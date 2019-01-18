package org.usfirst.frc.team2374.robot.commands;

import org.usfirst.frc.team2374.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ElevatorTeleop extends Command {

	public ElevatorTeleop() {
		requires (Robot.getDrivetrain());
	}
	
	@Override
	public void initialize() {
		
	}
	
	@Override
	protected void execute() {
				
		// To be determined
		
	}
	
	@Override
	protected void interrupted() {
		end();
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}
	
	@Override
	protected void end() {
		Robot.getDrivetrain().move(0, 0);
	}
	
}
