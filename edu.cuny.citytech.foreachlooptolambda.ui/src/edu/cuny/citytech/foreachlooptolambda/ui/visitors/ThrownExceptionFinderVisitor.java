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
import org.eclipse.jdt.core.dom.IMethodBinding;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.ThrowStatement;
import org.eclipse.jdt.core.dom.TypeDeclaration;

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
	public void processThrownExceptions(Statement statement) {
		this.thrownExceptions = new HashSet<Statement>();
		this.exceptionsStack = new Stack<HashSet<?>>();
		this.caughtExceptions = new HashSet<Statement>();
		this.discouragedExceptions = new HashSet<Statement>();
		// statement.traverse(this, scope);
		// removeCaughtExceptions(tryStatement,true /* remove unchecked
		// exceptions this time */);
	}

	private void acceptException(ITypeBinding binding) {
		if (binding != null) {
			this.thrownExceptions.add(binding);
		}
	}

	public void endVisit(ThrowStatement throwStatement) {
		acceptException((ITypeBinding) throwStatement);
		super.endVisit(throwStatement);
	}

	private void endVisitMethodInvocation(IMethodBinding methodBinding) {
		ITypeBinding[] thrownExceptionBindings = methodBinding.getExceptionTypes();
		int length = thrownExceptionBindings == null ? 0 : thrownExceptionBindings.length;
		for (int i = 0; i < length; i++) {
			acceptException(thrownExceptionBindings[i]);
		}
	}

	public ITypeBinding[] getAlreadyCaughtExceptions() {
		ITypeBinding[] allCaughtExceptions = new ITypeBinding[this.caughtExceptions.size()];
		// copying all the elements from hashSet to array
		this.caughtExceptions.toArray(allCaughtExceptions);
		return allCaughtExceptions;// returning the populated array
	}

	public ITypeBinding[] getThrownUncaughtExceptions() {
		ITypeBinding[] result = new ITypeBinding[this.thrownExceptions.size()];
		this.thrownExceptions.toArray(result);// copying all the elements from hashSet to array
		return result;// returning the populated array
	}

	public boolean visit(Statement statement) {
		this.exceptionsStack.push(this.thrownExceptions);
		HashSet<Statement> exceptionSet = new HashSet<Statement>();
		this.thrownExceptions = exceptionSet;

		this.thrownExceptions = (HashSet) this.exceptionsStack.pop();

		Object[] values = exceptionSet.toArray();
		for (int i = 0; i < values.length; i++) {
			if (values[i] != null) {
				this.thrownExceptions.add(values[i]);
			}
		}

		return false;
	}

}