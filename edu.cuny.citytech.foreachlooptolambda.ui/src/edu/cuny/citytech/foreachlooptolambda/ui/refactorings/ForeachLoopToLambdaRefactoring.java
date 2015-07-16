package edu.cuny.citytech.foreachlooptolambda.ui.refactorings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.internal.corext.refactoring.util.RefactoringASTParser;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.NullChange;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;

import edu.cuny.citytech.foreachlooptolambda.ui.messages.Messages;
import edu.cuny.citytech.foreachlooptolambda.ui.visitor.LambdaConversionVisitor;
import edu.cuny.citytech.refactoring.common.core.Refactoring;


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
	 * Default constructor
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

	@Override
	public RefactoringStatus checkFinalConditions(IProgressMonitor pm)
			throws CoreException, OperationCanceledException {
		final RefactoringStatus status = new RefactoringStatus();
		
		for (IMethod iMethod : methods) {
			// TODO Md: do your stuff here.
			
			ICompilationUnit iCompilationUnit = iMethod.getCompilationUnit();

			// there may be a shared AST already parsed. Let's try to get that
			// one.
			CompilationUnit compilationUnit = RefactoringASTParser.parseWithASTProvider(iCompilationUnit, false,
					new SubProgressMonitor(pm, 1));

			// NOTE: compilationUnit is an AST node where as iCompilationUnit is
			// a JavaElement (part of the Java model that represents a Java
			// project.

			// create the visitor.
			ASTVisitor lambdaVisit = new LambdaConversionVisitor();

			// have the AST node "accept" the visitor.
			compilationUnit.accept(lambdaVisit);
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
