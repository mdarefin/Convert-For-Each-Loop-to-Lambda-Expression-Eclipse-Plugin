/**
 * 
 */
package edu.cuny.citytech.foreachlooptolambda.ui.messages;

import org.eclipse.osgi.util.NLS;

/**
 * @author raffi
 *
 */
public class Messages extends NLS {
	private static final String BUNDLE_NAME = "edu.cuny.citytech.defaultrefactoring.ui.messages.messages"; //$NON-NLS-1$

	public static String ForEachLoopToLambdaRefactoring_MethodsNotSpecified;
	public static String ForEachLoopToLambdaRefactoring_Name;
	public static String ForEachLoopToLambdaRefactoring_CheckingPreconditions;
	public static String ForEachLoopToLambdaRefactoring_CompilingSource;
	public static String ForEachLoopToLambdaRefactoring_CreatingChange;
	public static String ForEachLoopToLambdaRefactoring_CUContainsCompileErrors;
	public static String ForEachLoopToLambdaRefactoring_MethodDoesNotExist;
	public static String ForEachLoopToLambdaRefactoring_PreconditionFailed;
	public static String ForEachLoopToLambdaRefactoring_RefactoringNotPossible;
	public static String ForEachLoopToLambdaRefactoring_WrongType;
	public static String ForEachLoopToLambdaRefactoring_CantChangeMethod;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
		super();
	}
}
