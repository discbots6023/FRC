/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.*;
//import frc.robot.commands.HatchArmDeploy;
//import frc.robot.commands.HatchArmRetract;
//import frc.robot.commands.LiftWithJoystick;
//import frc.robot.commands.SetLiftSetpoint;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  private final Joystick m_drive_joystick = new Joystick(RobotMap.OI_DRIVER_CONTROLLER);
  public final Joystick m_joystick = new Joystick(RobotMap.OI_ATTACHMENTS_CONTROLLER);
  public final XboxController m_xjoystick = new XboxController(RobotMap.OI_ATTACHMENTS_CONTROLLER);
  

  /**
   * Construct the OI and all of the buttons on it.
   */
  public OI() {
    // Put Some buttons on the SmartDashboard
    
    
    SmartDashboard.putData("Back Climber Deploy", new BackDeploy());
    SmartDashboard.putData("Back Climber Retract", new BackRetract());
    SmartDashboard.putData("Front Climber Deploy", new FrontDeploy());
    SmartDashboard.putData("Front Climber Retract", new FrontRetract());
    SmartDashboard.putData("Pivot Retract", new PivotRetract());
    SmartDashboard.putData("Pivot Deploy", new PivotDeploy());
    SmartDashboard.putData("Lift With Joystick", new LiftWithJoystick());
    
    // Gamepad 1 Buttons
    
    final JoystickButton rtrigger = new JoystickButton(m_drive_joystick, 5);
    final JoystickButton rbumper = new JoystickButton(m_drive_joystick, 6);    
    
    // Gamepad 2 Buttons
    
    final JoystickButton buttona = new JoystickButton(m_joystick, 1);
    final JoystickButton buttony = new JoystickButton(m_joystick, 4);
    final JoystickButton Bbuttony = new JoystickButton(m_joystick, 2);
    final JoystickButton Xbutonny= new JoystickButton(m_joystick, 3);

    final JoystickButton lbumper = new JoystickButton(m_joystick, 5);
    final JoystickButton buttonsta = new JoystickButton(m_joystick, 8);
    final JoystickButton buttonrb = new JoystickButton(m_joystick, 6);
    
    

    final JoystickButton dpadUp = new JoystickButton(m_joystick, 7);
    final JoystickButton dpadDown = new JoystickButton(m_joystick, 13);
    final JoystickButton l2 = new JoystickButton(m_joystick, 9);
    final JoystickButton r2 = new JoystickButton(m_joystick, 10);
    final JoystickButton l1 = new JoystickButton(m_joystick, 11);
    final JoystickButton r1 = new JoystickButton(m_joystick, 12);

    // Connect the buttons to commands
    
    buttony.whenPressed(new BackDeploy());
    lbumper.whenPressed(new BackRetract());
    rbumper.whenPressed(new Shoot());
    Xbutonny.whenPressed(new FrontRetract());
    Bbuttony.whenPressed(new FrontDeploy());
    buttonrb.whenPressed(new PivotDeploy());
    buttonsta.whenPressed(new PivotRetract());

    

    
  }

  public Joystick getJoystick() {
    return m_drive_joystick;
  }
}
