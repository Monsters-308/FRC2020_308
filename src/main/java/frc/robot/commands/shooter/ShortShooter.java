package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.ShooterSubsystem;;

/**
 * A simple command that runs the shooter in reverse with the {@link ShooterSubsystem}.  Written explicitly for
 * pedagogical purposes.  Actual code should inline a command this simple with {@link
 * edu.wpi.first.wpilibj2.command.InstantCommand}.
 */
public class ShortShooter extends CommandBase {
  // The subsystem the command runs on
  private final ShooterSubsystem m_shooterSubsystem;

  public ShortShooter(ShooterSubsystem subsystem) {
    m_shooterSubsystem = subsystem;
    addRequirements(m_shooterSubsystem);
  }

  @Override
  public void initialize() {
    m_shooterSubsystem.shortShooter();
  }

  @Override
  public void execute(){
  }


  @Override
  public boolean isFinished() {
    if((double)m_shooterSubsystem.getShooterVelocity() > Constants.ShooterConstants.kShortShotRPM && (double)m_shooterSubsystem.getShooterVelocity() < Constants.ShooterConstants.kShortShotRPM+500){
      return true;
    }else{
      return false;
    }
  }
}
