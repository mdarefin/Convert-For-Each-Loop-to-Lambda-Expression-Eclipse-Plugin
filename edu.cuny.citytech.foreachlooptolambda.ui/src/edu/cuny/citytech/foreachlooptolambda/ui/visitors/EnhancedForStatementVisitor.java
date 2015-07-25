package edu.cuny.citytech.foreachlooptolambda.ui.visitors;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.BreakStatement;
import org.eclipse.jdt.core.dom.CatchClause;
import org.eclipse.jdt.core.dom.ContinueStatement;
import org.eclipse.jdt.core.dom.EnhancedForStatement;
import org.eclipse.jdt.core.dom.ReturnStatement;
import org.eclipse.jdt.core.dom.ThrowStatement;

public class EnhancedForStatementVisitor extends ASTVisitor {
	private boolean encounteredBreakStatement;
	private boolean encounteredContinueStatement;
	private boolean encounteredInvalidReturnStatement;
	private boolean encounteredException;
	private boolean encounteredNonEffectivelyFinalVars;
	private boolean encounteredEmbeddedLoop;
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
		
		returnCount++;
		ASTNode expression = node.getExpression();
		if(expression != null && expression.getNodeType() == ASTNode.BOOLEAN_LITERAL){
				this.encounteredInvalidReturnStatement = true; 
		}	
		return super.visit(node);
	}
	
	//checking if there is any embedded EnhancedForLoop
	@Override
	public boolean visit(EnhancedForStatement node) {
		if(contains(node.getBody())){
			return encounteredEmbeddedLoop = true;
		}
		
		return super.visit(node);
	}
	
	//this method check if the EnhancedForLoop method body contain any embedded loop
		public static boolean contains(ASTNode node){
			return (node instanceof EnhancedForStatement);
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

	public boolean containsInvalidReturn() {
		// TODO can we add context?
		return encounteredInvalidReturnStatement;
	}

	public boolean containsMultipleReturn() {
		return returnCount > 1;
	}

	public boolean containsException() {
		// TODO can we add context?
		return encounteredException;
	}
	
	public boolean containsNEFs() {
		// TODO can we add context?
		return encounteredNonEffectivelyFinalVars;
	}
	
	public boolean containsEmbeddedForLoop() {
		// TODO can we add context?
		return encounteredEmbeddedLoop;
	}
	
}