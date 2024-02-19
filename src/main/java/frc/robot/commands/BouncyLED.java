// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.LED;

public class BouncyLED extends Command {
  
  LED s_led;



  Color color;
  /** Creates a new LEDTest. */
  public BouncyLED(LED s_led, Color color) {
    this.s_led = s_led;
    this.color = color;



    addRequirements(s_led);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    s_led.ledOff();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    s_led.ledBounce(color);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
