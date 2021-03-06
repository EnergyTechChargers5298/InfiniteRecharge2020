/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Lift;

public class LiftReach extends CommandBase {
  /**
   * Creates a new ReachForBar.
   */

  // Holds the Intake Subsystem
  private Lift lift;

  public LiftReach(Lift lift) {
    // Passes the Intake Subsystem into Field
    this.lift = lift;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(this.lift);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // Moves Motors to Intake the Balls
    lift.robotReach();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // Runs Only Once
    return true;
  }
}
