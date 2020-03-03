package frc.robot.commands.hopper;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.HopperSubsystem;;

/**
 * A simple command that runs the intake forward with the {@link HopperSubsystem}.  Written explicitly for
 * pedagogical purposes.  Actual code should inline a command this simple with {@link
 * edu.wpi.first.wpilibj2.command.InstantCommand}.
 */
public class PulseHopper extends CommandBase {
  // The subsystem the command runs on
  private final HopperSubsystem m_hopperSubsystem;
  // private double m_getFPGATimestamp;
  private double m_onTime;
  private double m_offTime;
  private Timer m_timer;

  public PulseHopper(HopperSubsystem subsystem) {
    m_onTime = 1.0; // default ontime to 1 second
    m_offTime = 0.25; // default offtime to .25 seconds
    m_hopperSubsystem = subsystem;
    m_timer = new Timer();
    addRequirements(m_hopperSubsystem);
  }

  public PulseHopper(HopperSubsystem subsystem, double onTime, double offTime) {
    m_onTime = onTime;
    m_offTime = offTime;
    m_hopperSubsystem = subsystem;
    m_timer.reset();
    addRequirements(m_hopperSubsystem);
  }

  @Override
  public void initialize() {
    // m_getFPGATimestamp = Timer.getFPGATimestamp();
    m_timer.reset();
    m_timer.start();
  }

  @Override
  public void end(boolean interrupted) {
    m_timer.stop();
  }
  
  @Override
  public void execute() {
    if(!m_timer.hasPeriodPassed(m_onTime)){
      m_hopperSubsystem.forwardHopper();
    }else if(!m_timer.hasPeriodPassed(m_onTime+m_offTime)){
      m_hopperSubsystem.stopHopper();
    }else{
      m_timer.reset();
    }
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
