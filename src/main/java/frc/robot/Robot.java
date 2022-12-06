package frc.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;


public class Robot extends TimedRobot {
  
  private Joystick m_stick;

  private Compressor comp;
  private DoubleSolenoid solenoid;
  
  @Override
  public void robotInit() {
    
    //Joystick
    m_stick = new Joystick(0);

    //Pneumatics
    comp = new Compressor(100, PneumaticsModuleType.CTREPCM);
    solenoid = new DoubleSolenoid(101, PneumaticsModuleType.CTREPCM, 0, 1);
  }

  @Override 
  public void teleopPeriodic() {

    if (m_stick.getRawButton(1)) { 
      solenoid.set(DoubleSolenoid.Value.kForward);
    }
    else if (m_stick.getRawButton(2)) {
      solenoid.set(DoubleSolenoid.Value.kReverse);
    }
    else {
      solenoid.set(DoubleSolenoid.Value.kOff);
    }

    if (m_stick.getRawButton(3)) {
      comp.enableDigital();
    }
    else if (m_stick.getRawButton(4)) {
      comp.disable();
    }
  }
}