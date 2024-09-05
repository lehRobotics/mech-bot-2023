package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;



public class CameraControl extends SubsystemBase{
    public CameraControl() {}

    Double yval = 0.0;
    Double xval = 0.0;

    public void CameraSet(int POVval) {
        if (POVval == 0 || POVval == 180) 
        {   

            if (POVval == 0) {
            
                if (yval > 0) {
                    yval -= 0.01;
                }

            } else {

                if (yval < 1.0) {
                    yval += 0.01;
                }
            }

            RobotContainer.Y_SERVO.set(yval);
            RobotContainer.X_SERVO.set(0.5);
            //Up or Down is active; move the camera servos in direction.
        } else if (POVval == 90 || POVval == 270)
        {

            if (POVval == 90) {
            
                xval = 0.3;

            } else {

                xval = 0.7;
            }

            RobotContainer.X_SERVO.set(xval);
        } else if (POVval == -1) {
            xval = 0.5;

            RobotContainer.X_SERVO.set(xval);
        }
    }

    public void CameraReset() {
        yval = 0.2;
        RobotContainer.Y_SERVO.set(yval);
    }
}
