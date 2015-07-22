package edu.cuny.citytech.foreachlooptolambda.ui.visitor;

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
	private boolean encounteredCollection;
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
	
	//check if the node is 
	@Override
	public boolean visit(ReturnStatement node) {
		ASTNode expression = node.getExpression();
		returnCount++;
		if(returnCount > 1 && expression != null && expression.equals(ASTNode.BOOLEAN_LITERAL))
			this.encounteredReturnStatement = true;
		if(expression instanceof java.util.Collection ){
			this.encounteredCollection = true;
		}
		
		return super.visit(node);
	}
	
	//checking for exceptions
	public boolean visit(ThrowStatement node) {   
		this.encounteredException = true;
		return super.visit(node);
	}
	
	public boolean visit(CatchClause node) {   
		this.encounteredException = true;
		return super.visit(node);
	}


	public boolean containsBreak() {
		return this.encounteredBreakStatement;
	}

	public boolean containsContinue() {
		return encounteredContinueStatement;
	}

	public boolean containsReturn() {
		return encounteredReturnStatement;
	}

	public boolean containsException() {
		return encounteredException;
	}
	
	public boolean containsCollection() {
		// TODO Auto-generated method stub
		return encounteredCollection;
	}
}