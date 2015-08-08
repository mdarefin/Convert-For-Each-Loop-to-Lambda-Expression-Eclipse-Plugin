package edu.cuny.citytech.foreachlooptolambda.ui.visitors;

import java.beans.Statement;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class ThrownExceptionFinder extends ASTVisitor{
	
	public static void processThrownExceptions(Statement statement, BlockScope blockScope){
		
	}
	
}
