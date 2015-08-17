package edu.cuny.citytech.foreachlooptolambda.ui.visitors;

import java.util.Arrays;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.BooleanLiteral;
import org.eclipse.jdt.core.dom.BreakStatement;
import org.eclipse.jdt.core.dom.ContinueStatement;
import org.eclipse.jdt.core.dom.EnhancedForStatement;
import org.eclipse.jdt.core.dom.IMethodBinding;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.ReturnStatement;
import org.eclipse.jdt.core.dom.ThrowStatement;
import org.eclipse.jdt.core.dom.TryStatement;

public class EnhancedForStatementVisitor extends ASTVisitor {

	private boolean encounteredBreakStatement;
	private boolean encounteredContinueStatement;
	private boolean encounteredInvalidReturnStatement;
	private boolean encounteredThrownCheckedException;
	private boolean encounteredNonEffectivelyFinalVars;
	private int returnCount = 0;

	/**
	 * The enhanced for statement that will be visited.
	 */
	private EnhancedForStatement enhancedForStatement;

	/**
	 * Create a new visitor.
	 * 
	 * @param enhancedForStatement
	 *            The enhanced for statement that will be visited.
	 */
	public EnhancedForStatementVisitor(EnhancedForStatement enhancedForStatement) {
		this.enhancedForStatement = enhancedForStatement;
	}

	// finding the TryStatement node
	public static ASTNode findTryAncestor(ASTNode node) {
		if (node == null || node instanceof TryStatement) {
			return node;
		}
		return findTryAncestor(node);
	}

	@Override
	public boolean visit(BreakStatement node) {
		this.encounteredBreakStatement = true;
		return super.visit(node);
	}

	@Override
	public boolean visit(ContinueStatement node) {
		this.encounteredContinueStatement = true;
		return super.visit(node);
	}

	private void handleException(ASTNode nodeContaingException) {

		// gets the top node. If it returns
		// null, there is no other top.
		ASTNode tryStatementParent = (nodeContaingException.getParent()).getParent();
		ASTNode throwStatementParent = tryStatementParent.getParent();

		if (throwStatementParent instanceof TryStatement) {
			System.out.println("this is throwStatementParent");
			this.encounteredThrownCheckedException = false;
		}

		// findTryStatmaent if there is any catch block
		else if (tryStatementParent instanceof TryStatement) {

			System.out.println("this is TryStatement");

			List catchList = Arrays.asList((((TryStatement) tryStatementParent).catchClauses()));
			// checking if there is any catchBlock
			if (catchList.size() >= 1) {
				this.encounteredThrownCheckedException = false;
			}
			System.out.println(catchList.size());
			// checking if there is only try and finally block
			Block finallyBlock = ((TryStatement) tryStatementParent).getFinally();
			if (finallyBlock != null) {
				this.encounteredThrownCheckedException = true;
				System.out.println(finallyBlock.getParent());
			}

		} else {
			this.encounteredThrownCheckedException = true;
		}
	}

	@Override
	public boolean visit(MethodInvocation node) {
		IMethodBinding iMethodBinding = node.resolveMethodBinding();
		ITypeBinding[] exceptionTypes = iMethodBinding.getExceptionTypes();
		// if there are exceptions
		if (exceptionTypes.length >= 1) {
			handleException(node);
		}

		return super.visit(node);
	}

	@Override
	public boolean visit(ThrowStatement node) {
		handleException(node);

		return super.visit(node);
	}

	/**
	 * checking if returnStatement is boolean, not null and has only one return
	 * 
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#visit(org.eclipse.jdt.core.dom.ReturnStatement)
	 */
	@Override
	public boolean visit(ReturnStatement node) {
		// one more return statement encountered.
		returnCount++;

		// examine what is being returned.
		ASTNode expression = node.getExpression();

		// if there is a return statement, it must return a boolean literal.
		if (expression == null || !(expression instanceof BooleanLiteral)) {
			this.encounteredInvalidReturnStatement = true;
		}

		return super.visit(node);
	}

	public boolean containsBreak() {
		return this.encounteredBreakStatement;
	}

	public boolean containsContinue() {
		return encounteredContinueStatement;
	}

	public boolean containsInvalidReturn() {
		return encounteredInvalidReturnStatement;
	}

	public boolean containsMultipleReturn() {
		return returnCount > 1;
	}

	public boolean containsException() {
		return encounteredThrownCheckedException;
	}

	public boolean containsNEFS() {
		return encounteredNonEffectivelyFinalVars;
	}
}