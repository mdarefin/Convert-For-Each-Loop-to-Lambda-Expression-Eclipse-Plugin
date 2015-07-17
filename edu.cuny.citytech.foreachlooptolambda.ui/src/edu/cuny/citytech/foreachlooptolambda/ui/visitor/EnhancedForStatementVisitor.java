package edu.cuny.citytech.foreachlooptolambda.ui.visitor;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.BreakStatement;
import org.eclipse.jdt.core.dom.ContinueStatement;
import org.eclipse.jdt.core.dom.ReturnStatement;

public class EnhancedForStatementVisitor extends ASTVisitor {
	private boolean encounteredBreakStatement;
	private boolean encounteredContinueStatement;
	private boolean encounteredReturnStatement;
	private int returnCount = 1;

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
	
	@Override
	public boolean visit(ReturnStatement node) {
		if(returnCount > 1)
			this.encounteredReturnStatement = true;
		returnCount++;
		return super.visit(node);
	}

	public boolean containsBreak() {
		return this.encounteredBreakStatement;
	}

	public boolean containsContinue() {
		
		return encounteredContinueStatement;
	}

	public boolean checkMultipleReturn() {
		
		return encounteredReturnStatement;
	}
}