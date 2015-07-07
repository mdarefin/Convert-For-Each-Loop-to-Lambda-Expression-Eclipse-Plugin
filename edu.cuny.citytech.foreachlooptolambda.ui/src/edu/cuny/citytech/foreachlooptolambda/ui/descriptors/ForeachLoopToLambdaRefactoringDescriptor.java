/**
 * 
 */
package edu.cuny.citytech.foreachlooptolambda.ui.descriptors;

import java.util.Map;

import edu.cuny.citytech.foreachlooptolambda.ui.refactorings.ForeachLoopToLambdaRefactoring;
import edu.cuny.citytech.refactoring.common.Refactoring;
import edu.cuny.citytech.refactoring.common.RefactoringDescriptor;

/**
 * @author raffi
 *
 */
public class ForeachLoopToLambdaRefactoringDescriptor
		extends RefactoringDescriptor {

	public static final String REFACTORING_ID = "edu.cuny.citytech.defaultrefactoring.migrate.skeletal.implementation.to.interface"; //$NON-NLS-1$

	public ForeachLoopToLambdaRefactoringDescriptor(
			String project, String description, String comment,
			@SuppressWarnings("rawtypes") Map arguments) {
		// TODO: May need an API change flag here as well.
		super(REFACTORING_ID, project, description, comment, arguments);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.cuny.citytech.refactoring.common.RefactoringDescriptor#createRefactoring
	 * ()
	 */
	@Override
	protected Refactoring createRefactoring() {
		return new ForeachLoopToLambdaRefactoring();
	}
}
