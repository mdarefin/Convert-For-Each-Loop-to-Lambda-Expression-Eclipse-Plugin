package edu.cuny.citytech.foreachlooptolambda.ui.visitors;

import java.beans.Statement;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.EnhancedForStatement;
import org.eclipse.jdt.core.dom.ThrowStatement;
import org.eclipse.jdt.core.dom.TryStatement;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class ThrownExceptionFinderVisitor extends ASTVisitor {

	static EnhancedForStatementVisitor visitor = new EnhancedForStatementVisitor();
	
	//check if any statement is passing get the exception for that Block code 
	public static void processThrownExceptions(Statement statement) { //BlockScope blockScope

	}
	//traverse through the ASTNode and check if the catch block get any exception
	private static boolean tryCatchExcaption(TryStatement tryStatement) {
		
		List<TryStatement> tryStatementList = tryStatement.catchClauses();
		tryStatementList.stream().forEach(s -> System.out.println(s));
		
		return false;
	}
	
	//traverse through the ASTNode and check if the ThrowStatement block get any exception
	private static boolean throwExcaption(ThrowStatement throwStatement) {

		return false;
	}
}
