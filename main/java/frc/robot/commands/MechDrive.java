package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.RobotContainer;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class MechDrive extends CommandBase {
    public MechDrive() {
        addRequirements(RobotContainer.DRIVE_TRAIN);
    }

    public void initialize() {

        RobotContainer.DRIVE_TRAIN.FRMset(0);
        RobotContainer.DRIVE_TRAIN.FLMset(0);
        RobotContainer.DRIVE_TRAIN.BRMset(0);
        RobotContainer.DRIVE_TRAIN.BLMset(0);

    }

    
    double FRMgoal = 0.0;
    double FLMgoal = 0.0;
    double BRMgoal = 0.0;
    double BRMgoal = 0.0;
    public void execute() {
        double driverAxisX = RobotContainer.CONTROLLER_JOYSTICK.getRawAxis(0);
        double driverAxisY = RobotContainer.CONTROLLER_JOYSTICK.getRawAxis(1);
        double driverAxisZ = RobotContainer.CONTROLLER_JOYSTICK.getRawAxis(2);

        if ((driverAxisY+driverAxisX+driverAxisZ) > FRMgoal) {
            System.out.print("Increase Speed Goal");
        } else {
            System.out.print("Decrease Speed Goal");
        }
        
        RobotContainer.DRIVE_TRAIN.FRMset((driverAxisY+driverAxisX+driverAxisZ)/Constants.robotConstants.MOVE_SPEED);
        RobotContainer.DRIVE_TRAIN.FLMset((driverAxisY-driverAxisX-driverAxisZ)/Constants.robotConstants.MOVE_SPEED);
        RobotContainer.DRIVE_TRAIN.BRMset((driverAxisY-driverAxisX+driverAxisZ)/Constants.robotConstants.MOVE_SPEED);
        RobotContainer.DRIVE_TRAIN.BLMset((driverAxisY+driverAxisX-driverAxisZ)/Constants.robotConstants.MOVE_SPEED);
    }

    public void end(boolean interrupted) {
        initialize();
    }

    public boolean isFinished() {
        return false;
    }
}
