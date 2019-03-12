package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

public class ChooChoo {
    private DcMotor contMvt;
    private int toggle = 0;
    private static double MOTOR_POWER = 0.5;
    public ChooChoo(DcMotor c) {
        contMvt = c;

        stop();
    }

    public void controls(Gamepad gp) {
        if(gp.x) {
            toggle = Math.abs(toggle-1);
            spin(toggle);
        }
    }

    public void spin(int t) {
        if (t==1) contMvt.setPower(MOTOR_POWER);
        else if (t==0) contMvt.setPower(0);
    }

    public void stop() {
        contMvt.setPower(0);
    }
}
