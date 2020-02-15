package frc.robot.commands.wof;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.WOFSubsystem;;

/**
 * A simple command that forwards the WOF with the {@link WOFSubsystem}.  Written explicitly for
 * pedagogical purposes.  Actual code should inline a command this simple with {@link
 * edu.wpi.first.wpilibj2.command.InstantCommand}.
 */
public class ForwardWOF extends CommandBase {
  // The subsystem the command runs on
  private final WOFSubsystem m_wofSubsystem;

  public ForwardWOF(WOFSubsystem subsystem) {
    m_wofSubsystem = subsystem;
    addRequirements(m_wofSubsystem);
  }

  @Override
  public void initialize() {
    m_wofSubsystem.forwardWOF();
  }

  @Override
  public boolean isFinished() {
    return true;
  }
}
