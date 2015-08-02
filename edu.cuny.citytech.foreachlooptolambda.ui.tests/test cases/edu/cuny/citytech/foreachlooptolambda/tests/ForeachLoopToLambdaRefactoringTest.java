/**
 * 
 */
package edu.cuny.citytech.foreachlooptolambda.tests;

import edu.cuny.citytech.refactoring.common.test.RefactoringTest;

/**
 * @author <a href="mailto:rkhatchadourian@citytech.cuny.edu">Raffi
 *         Khatchadourian</a>
 *
 */
@SuppressWarnings("restriction")
public class ForeachLoopToLambdaRefactoringTest extends RefactoringTest {


	public ForeachLoopToLambdaRefactoringTest(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testConstructor() throws Exception {
		helperFail(new String[] { "A" }, new String[][] { new String[0] });
	}

	public void testAnnotatedMethod() throws Exception {
		helperFail(new String[] { "m" }, new String[][] { new String[0] });
	}

	public void testStaticMethod() throws Exception {
		helperFail(new String[] { "m" }, new String[][] { new String[0] });
	}
	
}
