package edu.cuny.citytech.foreachlooptolambda.ui.visitors;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.BreakStatement;
import org.eclipse.jdt.core.dom.CatchClause;
import org.eclipse.jdt.core.dom.ContinueStatement;
import org.eclipse.jdt.core.dom.ReturnStatement;
import org.eclipse.jdt.core.dom.ThrowStatement;

public class EnhancedForStatementVisitor extends ASTVisitor {
	private boolean encounteredBreakStatement;
	private boolean encounteredContinueStatement;
	private boolean encounteredReturnStatement;
	private boolean encounteredException;
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
	
	//checking if returnStatement is boolean, not null and has only one return 
	@Override
	public boolean visit(ReturnStatement node) {
		ASTNode expression = node.getExpression();
		returnCount++;
		if(returnCount > 1 && expression != null && expression.equals(ASTNode.BOOLEAN_LITERAL))
			this.encounteredReturnStatement = true;		
		return super.visit(node);
	}
	
	//checking if the expression are part of collection TODO code here	
	
	//checking for exceptions
	public boolean visit(ThrowStatement node) {   
		this.encounteredException = true;
		return super.visit(node);
	}
	//checking for exceptions
	public boolean visit(CatchClause node) {   
		this.encounteredException = true;
		return super.visit(node);
	}


	public boolean containsBreak() {
		// TODO can we add context?
		return this.encounteredBreakStatement;
	}

	public boolean containsContinue() {
		// TODO can we add context?
		return encounteredContinueStatement;
	}

	public boolean containsReturn() {
		// TODO can we add context?
		return encounteredReturnStatement;
	}

	public boolean containsException() {
		// TODO can we add context?
		return encounteredException;
	}
	
	public boolean containsNEFs() {
		// TODO can we add context?
		return encounteredNonEffectivelyFinalVars;
	}
}