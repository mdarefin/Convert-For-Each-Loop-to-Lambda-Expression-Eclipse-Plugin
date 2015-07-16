package edu.cuny.citytech.foreachlooptolambda.ui.contributions;

import java.util.Map;

import org.eclipse.ltk.core.refactoring.RefactoringDescriptor;

import edu.cuny.citytech.foreachlooptolambda.ui.descriptors.ForeachLoopToLambdaRefactoringDescriptor;
import edu.cuny.citytech.refactoring.common.core.RefactoringContribution;


public class ForeachLoopToLambdaRefactoringContribution
		extends RefactoringContribution {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ltk.core.refactoring.RefactoringContribution#createDescriptor
	 * (java.lang.String, java.lang.String, java.lang.String, java.lang.String,
	 * java.util.Map, int)
	 */
	@Override
	public RefactoringDescriptor createDescriptor(String id, String project,
			String description, String comment,
			@SuppressWarnings("rawtypes") Map arguments, int flags)
			throws IllegalArgumentException {
		return new ForeachLoopToLambdaRefactoringDescriptor(
				project, description, comment, arguments);
	}
}
