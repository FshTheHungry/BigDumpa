// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ArmSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * A command to run the arm subsystem.
 */
public class ArmInCommand extends Command {
  private final ArmSubsystem arm;
  private final double holdingPower = 0.10;

  /**
   * Creates a new ArmInCommand.
   *
   * @param subsystem The arm subsystem this command will run on.
   */
  public ArmInCommand(ArmSubsystem subsystem) {
    arm = subsystem;
    
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(arm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    arm.armMotor(holdingPower);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // Stop the arm motor when the command is released/interrupted
    arm.armMotor(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false; // Return true if it should end automatically, false if run-while-held
  }
}