package frc.robot.commands.lift;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.LiftSubsystem;;

/**
 * A simple command that stops the Lift with the {@link LiftSubsystem}.  Written explicitly for
 * pedagogical purposes.  Actual code should inline a command this simple with {@link
 * edu.wpi.first.wpilibj2.command.InstantCommand}.
 */
public class ReverseLift extends CommandBase {
  // The subsystem the command runs on
  private final LiftSubsystem m_liftSubsystem;

  public ReverseLift(LiftSubsystem subsystem) {
    m_liftSubsystem = subsystem;
    addRequirements(m_liftSubsystem);
  }

  @Override
  public void initialize() {
    m_liftSubsystem.reverseLift();
  }

  @Override
  public boolean isFinished() {
    return true;
  }
}
