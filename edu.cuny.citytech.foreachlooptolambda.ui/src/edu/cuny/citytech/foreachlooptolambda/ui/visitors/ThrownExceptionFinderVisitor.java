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

import java.util.Stack;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;
import org.eclipse.jdt.internal.compiler.util.SimpleSet;

@SuppressWarnings({"rawtypes", "unchecked"})
public class ThrownExceptionFinderVisitor extends ASTVisitor {
	
	private SimpleSet thrownExceptions;
	private Stack exceptionsStack;
	private SimpleSet caughtExceptions;
	private SimpleSet discouragedExceptions;
	
	/**
	 * Finds the thrown exceptions minus the ones that are already caught in previous statement.
	 * Exception is already caught even if its super type is being caught. Also computes, separately,
	 * a list comprising of (a)those exceptions that have been caught already and (b)those exceptions that are thrown
	 * by the method and whose super type has been caught already. 
	 * @param satement
	 * @param scope
	 */
	public void processThrownExceptions(Statement satement, BlockScope scope) {
		this.thrownExceptions = new SimpleSet();
		this.exceptionsStack = new Stack();
		this.caughtExceptions = new SimpleSet();
		this.discouragedExceptions = new SimpleSet();
	//	satement.traverse(this, scope);
	//	removeCaughtExceptions(satement, true /*remove unchecked exceptions this time*/);
	}

	
}