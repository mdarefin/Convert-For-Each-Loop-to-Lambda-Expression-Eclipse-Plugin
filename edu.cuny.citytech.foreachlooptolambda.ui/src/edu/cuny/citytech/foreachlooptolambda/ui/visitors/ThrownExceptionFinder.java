package edu.cuny.citytech.foreachlooptolambda.ui.visitors;

import java.beans.Statement;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.ThrowStatement;
import org.eclipse.jdt.core.dom.TryStatement;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class ThrownExceptionFinder extends ASTVisitor {

	//check if any statement is passing get the exception for that Block code 
	public static void processThrownExceptions(Statement statement, BlockScope blockScope) {

	}
	//traverse through the ASTNode and check if the catch block get any exception
	private static boolean tryCatchExcaption(TryStatement tryStatement) {

		return false;
	}
	
	//traverse through the ASTNode and check if the ThrowStatement block get any exception
	private static boolean throwExcaption(ThrowStatement throwStatement) {

		return false;
	}

}
