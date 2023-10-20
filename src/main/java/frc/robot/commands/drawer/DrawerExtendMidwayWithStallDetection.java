
package frc.robot.commands.drawer;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Drawer;

/**
 *
 */
/*public*/ class DrawerExtendMidwayWithStallDetection extends CommandBase {

	private Drawer drawer;

	public DrawerExtendMidwayWithStallDetection(Drawer drawer) {	
		this.drawer = drawer;
		addRequirements(drawer);
	}

	// Called just before this Command runs the first time
	@Override
	public void initialize() {
		System.out.println("DrawerExtendMidwayWithStallDetection initialize");
		drawer.extendMidway();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	public void execute() {
		// nothing
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	public boolean isFinished() {
		return !drawer.tripleCheckMove() || drawer.tripleCheckIfStalled();
	}

	// Called once after isFinished returns true
	@Override
	public void end(boolean interrupted) {
		System.out.println("DrawerExtendMidwayWithStallDetection: end");
		drawer.stop(); // adjust if needed
	}
}
