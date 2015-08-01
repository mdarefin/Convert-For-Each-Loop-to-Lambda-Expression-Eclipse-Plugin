package edu.cuny.citytech.foreachlooptolambda.ui.visitors;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.BooleanLiteral;
import org.eclipse.jdt.core.dom.BreakStatement;
import org.eclipse.jdt.core.dom.ContinueStatement;
import org.eclipse.jdt.core.dom.ReturnStatement;

public class EnhancedForStatementVisitor extends ASTVisitor {
	private boolean encounteredBreakStatement;
	private boolean encounteredContinueStatement;
	private boolean encounteredInvalidReturnStatement;
	private boolean encounteredThrownCheckedException;
	private boolean encounteredNonEffectivelyFinalVars;
	private int returnCount = 0;

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
		// checkException();
		return encounteredThrownCheckedException;
	}

	public boolean containsNEFs() {
		return encounteredNonEffectivelyFinalVars;
	}
	
}