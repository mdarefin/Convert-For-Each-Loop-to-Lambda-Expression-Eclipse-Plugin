package edu.cuny.citytech.foreachlooptolambda.ui.visitor;

import org.eclipse.jdt.core.dom.*;

 public class LambdaConversionVisitor extends ASTVisitor {

	//visiting for-each loop 
	public boolean visit(EnhancedForStatement node) {
		System.out.println(node);
		return super.visit(node);
	}
 }