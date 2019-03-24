package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class MecanumAuto {
    static final double     COUNTS_PER_MOTOR_REV    = 1440 ;
    static final double     DRIVE_GEAR_REDUCTION    = 1.0 ;
    static final double     WHEEL_DIAMETER_INCHES   = 4.0 ;
    static final double     BOT_CIRCUMFERENCE = (17.5 * Math.PI);
    static final double     DEGREES_PER_INCH = 360 / (BOT_CIRCUMFERENCE);
    public DcMotor rightTop;
    public DcMotor rightBottom;
    public DcMotor leftTop;
    public DcMotor leftBottom;
    public MecanumAuto(DcMotor TR, DcMotor BR, DcMotor TL, DcMotor BL){
        this.rightBottom = BR;
        this.leftBottom = BL;
        this.rightTop = TR;
        this.leftTop = TL;
        rightBottom.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftBottom.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftTop.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightTop.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void motorDrive(DcMotor motor, double ticks, double power, Telemetry telemetry) {
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor.setTargetPosition((int)(ticks));
        motor.setPower(power);
    }

    public void drive(double distance_in_inches, double power, Telemetry telemetry) {
        
    }

    public void tokyoDrift() {

    }

    public void turnTo() {

    }

    public double calculatedTicks(int distance) {
        return distance * Math.sqrt(2);
    }

    public void resetEncoders(){
        rightTop.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightBottom.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftTop.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftBottom.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }
    public void jigglypuff(){
        while (rightTop.isBusy() || rightBottom.isBusy() || leftBottom.isBusy() || leftTop.isBusy()) {

        }
    }
}
