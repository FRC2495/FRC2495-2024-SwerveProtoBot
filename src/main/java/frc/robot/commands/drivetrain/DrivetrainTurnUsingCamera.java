
package frc.robot.commands.drivetrain;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import frc.robot.subsystems.SwerveDrivetrain;
import frc.robot.interfaces.ICamera;
import frc.robot.RobotContainer;

/**
 *
 */
public class DrivetrainTurnUsingCamera extends Command {

	private SwerveDrivetrain drivetrain;
	private ICamera camera;
	public static final double JOYSTICK_AXIS_THRESHOLD = 0.15;

	public DrivetrainTurnUsingCamera(SwerveDrivetrain drivetrain, ICamera camera) {
		this.drivetrain = drivetrain;
		this.camera = camera;
		

		addRequirements(drivetrain);
		addRequirements(camera);
	}

	// Called just before this Command runs the first time
	@Override
	public void initialize() {
		System.out.println("DrivetrainTurnUsingCamera: initialize");
		
	}


	// Called repeatedly when this Command is scheduled to run
	@Override
	public void execute() {

				drivetrain.drive(
					-0,
					-0,
					-camera.getAngleToTurnToCompositeTarget()/90.00,
					true, true);
	}

	// Make this return true when this Command no longer needs to run execute()
	/*@Override
	public boolean isFinished() {
		return !drivetrain.tripleCheckTurnAngleUsingPidController();
	}*/

	// Called once after isFinished returns true
	@Override
	public void end(boolean interrupted) {
		System.out.println("DrivetrainTurnUsingCamera: end");
		drivetrain.stop();
	}
}
