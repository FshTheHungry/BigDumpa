// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DumpSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * A command to run the dump subsystem.
 */
public class DumpCommand extends Command {
  private final DumpSubsystem dump;
  private final double holdingPower = -0.6;

  /**
   * Creates a new DumpCommand.
   *
   * @param subsystem The dump subsystem this command will run on.
   */
  public DumpCommand(DumpSubsystem subsystem) {
    dump = subsystem;
    
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(dump);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    dump.dumpMotor(holdingPower);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // Stop the dump motor when the command is released/interrupted
    dump.dumpMotor(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false; // Return true if it should end automatically, false if run-while-held
  }
}