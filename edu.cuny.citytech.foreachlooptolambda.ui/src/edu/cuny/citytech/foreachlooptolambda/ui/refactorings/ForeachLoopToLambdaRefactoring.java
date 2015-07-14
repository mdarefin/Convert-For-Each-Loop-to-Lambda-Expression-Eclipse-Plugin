package edu.cuny.citytech.foreachlooptolambda.ui.refactorings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.NullChange;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;

import edu.cuny.citytech.foreachlooptolambda.ui.messages.Messages;
import edu.cuny.citytech.refactoring.common.Refactoring;

/**
 * The activator class controls the plug-in life cycle
 * 
 * @author <a href="mailto:rkhatchadourian@citytech.cuny.edu">Raffi
 *         Khatchadourian</a>
 */
public class ForeachLoopToLambdaRefactoring extends
		Refactoring {

	/**
	 * The methods to refactor.
	 */
	private Set<IMethod> methods;

	/**
	 * Creates a new refactoring with the given methods to refactor.
	 * 
	 * @param methods
	 *            The methods to refactor.
	 */
	public ForeachLoopToLambdaRefactoring(
			IMethod... methods) {
		this.methods = new HashSet<IMethod>(Arrays.asList(methods));
	}

	/**
	 * Default ctor.
	 */
	public ForeachLoopToLambdaRefactoring() {
	}

	@Override
	public String getName() {
		//TODO: Please rename.
		return Messages.ForEachLoopToLambdaRefactoring_Name;
	}

	@Override
	public RefactoringStatus checkInitialConditions(IProgressMonitor pm)
			throws CoreException, OperationCanceledException {
		// TODO Empty for now.
		final RefactoringStatus status = new RefactoringStatus();
		return status;
	}
///////////////////////////////////////////////////////////////////////////////
	//adding the CompilationUnit to AST parser
	private static CompilationUnit parse(ICompilationUnit unit) {
	    ASTParser parser = ASTParser.newParser(AST.JLS3);
	    parser.setKind(ASTParser.K_COMPILATION_UNIT);
	    parser.setSource(unit);
	    parser.setResolveBindings(true);
	    return (CompilationUnit) parser.createAST(null); // parse
	  }
///////////////////////////////////////////////////////////////////////////////
	@Override
	public RefactoringStatus checkFinalConditions(IProgressMonitor pm)
			throws CoreException, OperationCanceledException {
		final RefactoringStatus status = new RefactoringStatus();
		
		for (IMethod iMethod : methods) {
			// TODO Md: do your stuff here.
			
			ICompilationUnit iCompilationUnit = iMethod.getCompilationUnit();
			parse(iCompilationUnit);
//			 System.out.println("Method name " + iMethod.getElementName());
//		     System.out.println("Signature " + iMethod.getSignature());
//		     System.out.println("Return Type " + iMethod.getReturnType());
		}
		return status;
	}

	@Override
	public Change createChange(IProgressMonitor pm) throws CoreException,
			OperationCanceledException {

		try {
			pm.beginTask(
					Messages.ForEachLoopToLambdaRefactoring_CreatingChange,
					1);

			return new NullChange(getName());
		} finally {
			pm.done();
		}
	}
}