// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * A command to run the intake subsystem.
 */
public class IntakeInCommand extends Command {
  private final IntakeSubsystem intake;
  private final double power = -0.80;

  /**
   * Creates a new IntakeInCommand.
   *
   * @param subsystem The intake subsystem this command will run on.
   */
  public IntakeInCommand(IntakeSubsystem subsystem) {
    intake = subsystem;
    
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    intake.intakeMotor(power);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // Stop the intake motor when the command is released/interrupted
    intake.intakeMotor(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false; // Return true if it should end automatically, false if run-while-held
  }
}