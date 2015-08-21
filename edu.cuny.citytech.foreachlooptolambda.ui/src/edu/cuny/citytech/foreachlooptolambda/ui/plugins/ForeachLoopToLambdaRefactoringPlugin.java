package edu.cuny.citytech.foreachlooptolambda.ui.plugins;

import org.osgi.framework.BundleContext;

import edu.cuny.citytech.foreachlooptolambda.ui.descriptors.ForeachLoopToLambdaRefactoringDescriptor;
import edu.cuny.citytech.refactoring.common.ui.RefactoringPlugin;

public class ForeachLoopToLambdaRefactoringPlugin extends RefactoringPlugin {

	private static ForeachLoopToLambdaRefactoringPlugin plugin;

	public static RefactoringPlugin getDefault() {
		return plugin;
	}

	@Override
	public void start(BundleContext context) throws Exception {
		plugin = this;
		super.start(context);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.cuny.citytech.refactoring.common.RefactoringPlugin#getRefactoringId()
	 */
	@Override
	protected String getRefactoringId() {
		return ForeachLoopToLambdaRefactoringDescriptor.REFACTORING_ID;
	}
}