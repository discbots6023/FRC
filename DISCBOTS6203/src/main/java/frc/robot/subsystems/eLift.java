/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.*;

/**
 * The DriveTrain subsystem incorporates the sensors and actuators attached to
 * the robots chassis. These include four drive motors, a left and right encoder
 * and a gyro.
 */
public class eLift extends Subsystem {
  private final SpeedController m_liftMotor
      = new SpeedControllerGroup(new Spark(RobotMap.LIFT1), new Spark(RobotMap.LIFT2));
   
 //  private final Encoder m_leftEncoder = new Encoder(RobotMap.DRIVETRAIN_LEFT_CHANNELA, RobotMap.DRIVETRAIN_LEFT_CHANNELB);
  //private final Encoder m_rightEncoder = new Encoder(RobotMap.DRIVETRAIN_RIGHT_CHANNELA, RobotMap.DRIVETRAIN_RIGHT_CHANNELB);
 
  /**
   * Create a new drive train subsystem.
   */
 
  public eLift() {
    super();

    // Encoders may measure differently in the real world and in
    // simulation. In this example the robot moves 0.042 barleycorns
    // per tick in the real world, but the simulated encoders
    // simulate 360 tick encoders. This if statement allows for the
    // real robot to handle this difference in devices.
   
  }

  /**
   * When no other command is running let the operator drive around using the
   * PS3 joystick.
   */
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new LiftWithJoystick());
  }

  /**
   * The log method puts interesting information to the SmartDashboard.
   */
  public void log() {
    //SmartDashboard.putNumber("Left Distance", m_leftEncoder.getDistance());
    //SmartDashboard.putNumber("Right Distance", m_rightEncoder.getDistance());
    //SmartDashboard.putNumber("Left Speed", m_leftEncoder.getRate());
    //SmartDashboard.putNumber("Right Speed", m_rightEncoder.getRate());
    
  }

  /**
   * Operate Lift.
   *
   * @param left Speed in range [-1,1]
   * @param right Speed in range [-1,1]
   */
  public void move(double power) {
    SmartDashboard.putNumber("Lift Power", power);
    
    //m_drive.tankDrive(left, right);
    m_liftMotor.set(-power);
  }

  
  /**
   * Reset the robots sensors to the zero states.
   */
  

  /**
   * Get the average distance of the encoders since the last reset.
   *
   * @return The distance driven (average of left and right encoders).
   */
  

  
}
