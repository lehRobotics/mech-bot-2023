package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

import frc.robot.subsystems.CameraControl;

public class ControlCamera extends CommandBase{

    public ControlCamera() {
        addRequirements(RobotContainer.CAMERA_CONTROL);
    }

    private void addRequirements(CameraControl cameraControl) {
    }

    public void initialize() {

    }

    public void execute() {
        //Set speeds of servos
        RobotContainer.X_SERVO.setSpeed(Constants.robotConstants.CAM_SPEED);

        final int POVval = RobotContainer.CONTROLLER_JOYSTICK.getPOV();

        boolean ResetCamButton = RobotContainer.CONTROLLER_JOYSTICK.getRawButton(5);

        if (ResetCamButton) {
            RobotContainer.CAMERA_CONTROL.CameraReset();
        }

        RobotContainer.CAMERA_CONTROL.CameraSet(POVval);
    }

    public void end(boolean interrupted) {
        initialize();
    }

    public boolean isFinished() {
        return false;
    }
}
