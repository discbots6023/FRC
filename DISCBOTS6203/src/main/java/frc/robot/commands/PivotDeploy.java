/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class PivotDeploy extends Command {
	/**
	 * Add your docs here.
	 */
	public PivotDeploy() {
		super();
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		//requires(Robot.m_ePivot);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
	  //Robot.m_drivetrain.drive(Robot.m_oi.getJoystick());
	 // Robot.m_ePivot.Deploy();
	}
  
	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
	  return true; // Runs until interrupted
	}
  
	// Called once after isFinished returns true
	@Override
	protected void end() {
	 
	}
}
