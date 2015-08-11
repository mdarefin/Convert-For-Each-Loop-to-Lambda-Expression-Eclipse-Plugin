/*******************************************************************************
 * Copyright (c) 2007, 2013 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package edu.cuny.citytech.foreachlooptolambda.ui.visitors;

import java.util.HashSet;
import java.util.Stack;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.TryStatement;
import org.eclipse.jdt.internal.codeassist.ThrownExceptionFinder;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;

public class ThrownExceptionFinderVisitor extends ASTVisitor {

	private HashSet thrownExceptions;
	private Stack exceptionsStack;
	private HashSet caughtExceptions;
	private HashSet discouragedExceptions;

	/**
	 * Finds the thrown exceptions minus the ones that are already caught in
	 * previous statement. Exception is already caught even if its super type is
	 * being caught. Also computes, separately, a list comprising of (a)those
	 * exceptions that have been caught already and (b)those exceptions that are
	 * thrown by the method and whose super type has been caught already.
	 * 
	 * @param satement
	 * @param scope
	 */
	public void processThrownExceptions(Statement statement, BlockScope scope) {
		this.thrownExceptions = new HashSet();
		this.exceptionsStack = new Stack();
		this.caughtExceptions = new HashSet();
		this.discouragedExceptions = new HashSet();
		//statement.traverse(this, scope);
		//emoveCaughtExceptions(tryStatement,true /* remove unchecked exceptions this time */);
	}
	
	/**
	 * Returns all the already caught exceptions in catch blocks, found by the call to
	 * {@link ThrownExceptionFinder#processThrownExceptions(TryStatement, BlockScope)}
	 * @return Returns an array of those exceptions that have been caught already in previous catch or
	 * multi-catch blocks of the same try block. (Exceptions caught in inner try-catches are obtained via
	 * {@link ThrownExceptionFinder#getDiscouragedExceptions()}.
	 */
	public ReferenceBinding[] getAlreadyCaughtExceptions() {
		ReferenceBinding[] allCaughtExceptions = new ReferenceBinding[this.caughtExceptions.size()];
		this.caughtExceptions.toArray(allCaughtExceptions);
		return allCaughtExceptions;
	}
	
	public ReferenceBinding[] getThrownUncaughtExceptions() {
		ReferenceBinding[] result = new ReferenceBinding[this.thrownExceptions.size()];
		this.thrownExceptions.toArray(result);
		return result;
	}

	
	private void acceptException(ReferenceBinding binding) {
		if (binding != null && binding.isValidBinding()) {
			this.thrownExceptions.add(binding);
		}
	}
	
	public boolean visit(Statement statement, BlockScope scope) {
		this.exceptionsStack.push(this.thrownExceptions);
		HashSet exceptionSet = new HashSet();
		this.thrownExceptions = exceptionSet;
		//statement.BLOCK.traverse(this, scope);

		this.thrownExceptions = (HashSet)this.exceptionsStack.pop();

		Object[] values = exceptionSet.toArray();
		for (int i = 0; i < values.length; i++) {
			if (values[i] != null) {
				this.thrownExceptions.add(values[i]);
			}
		}
		
		return false;
	}
	
}