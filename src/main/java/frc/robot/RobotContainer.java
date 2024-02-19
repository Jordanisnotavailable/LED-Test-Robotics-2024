// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.BouncyLED;
import frc.robot.commands.ChaseLED;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.SolidLED;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.LED;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private static final LED s_led = new LED();

  Color blue = new Color(0,0,255);
  Color red = new Color(255, 0, 0);
  Color green = new Color(0,255,0);
  Color yellow = new Color(255,115,0);
  

  private final SolidLED c_greenLED = new SolidLED(s_led, green);
  private final SolidLED c_redLED = new SolidLED(s_led, yellow);
  private final SolidLED c_blueLED = new SolidLED(s_led, blue);
  private final SolidLED c_yellowLED = new SolidLED(s_led, yellow);

  private final BouncyLED c_yellowBouncyLED = new BouncyLED(s_led, yellow);
  private final BouncyLED c_redBouncyLED = new BouncyLED(s_led, red);
  private final BouncyLED c_greenBouncyLED = new BouncyLED(s_led, green);
  private final BouncyLED c_blueBouncyLED = new BouncyLED(s_led, blue);

  private final ChaseLED c_yellowChaseLED = new ChaseLED(s_led, yellow);
  private final ChaseLED c_redChaseLED = new ChaseLED(s_led, red);
  private final ChaseLED c_greenChaseLED = new ChaseLED(s_led, green);
  private final ChaseLED c_blueChaseLED = new ChaseLED(s_led, blue);

  CommandJoystick joystick = new CommandJoystick(0);
 

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    s_led.setDefaultCommand(c_yellowLED);
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    new Trigger(m_exampleSubsystem::exampleCondition)
        .onTrue(new ExampleCommand(m_exampleSubsystem));

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());
    
     joystick.button(4).onTrue(c_blueBouncyLED);
     joystick.button(3).onTrue(c_redChaseLED);
     joystick.button(2).onTrue(c_greenLED);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(m_exampleSubsystem);
  }
}
