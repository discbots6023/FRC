/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.cameraserver.*;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Lift;
import frc.robot.subsystems.Pivot;
import frc.robot.subsystems.ePivot;


import frc.robot.subsystems.*;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends TimedRobot {
  Command m_autonomousCommand;

  public static DriveTrain m_drivetrain;
  public static Pivot m_pivot;
  public static eLift m_elift;
  public static Shooter m_shooter;
  public static BackClimber m_backclimber;
  public static FrontClimber m_frontclimber;
  public static OI m_oi;
  public static ePivot m_ePivot;

  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  @Override
  public void robotInit() {
    // Initialize all subsystems
    m_drivetrain = new DriveTrain();
    m_pivot = new Pivot();
    m_elift = new eLift();
    m_shooter = new Shooter();
    m_backclimber = new BackClimber();
    m_frontclimber = new FrontClimber();
    m_oi = new OI();
    //m_ePivot = new ePivot();
    CameraServer.getInstance().startAutomaticCapture();

    // instantiate the command used for the autonomous period

    // Show what command your subsystem is running on the SmartDashboard
    SmartDashboard.putData(m_drivetrain);
    SmartDashboard.putData(m_elift);
    SmartDashboard.putData(m_backclimber);
    SmartDashboard.putData(m_frontclimber);
    SmartDashboard.putData(m_shooter);
    //SmartDashboard.putData(m_ePivot);
    m_backclimber.Retract();
    m_frontclimber.Retract();

  }

  @Override
  public void autonomousInit() {
    m_autonomousCommand.start(); // schedule the autonomous command (example)
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
    log();
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    // m_autonomousCommand.cancel(); m_backclimber.Retract();
    m_frontclimber.Retract();
    m_backclimber.Retract();


  }

  /**
   * This function is called periodically during teleoperated mode.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
    log();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }

  /**
   * The log method puts interesting information to the SmartDashboard.
   */
  private void log() {
    m_elift.log();
    m_pivot.log();
    m_drivetrain.log();
    m_shooter.log();
    m_backclimber.log();
    m_frontclimber.log();
    //m_ePivot.log();

  }
}
