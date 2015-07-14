package edu.cuny.citytech.foreachlooptolambda.ui.visitor;

import org.eclipse.jdt.core.dom.*;

 public class LambdaConversionVisitor extends ASTVisitor {
	 
 	public boolean visitNode(ASTNode node) {
 		return true;
 	}
 	
 	public void postVisit(ASTNode node){
 		super.postVisit(node);
 	}
 	
 	public boolean visit(ConstructorInvocation node) {
 		return visitNode(node);
 	}

 	public boolean visit(ExpressionStatement node) {
 		return visitNode(node);
 	}
 	public boolean visit(FieldAccess node) {
 		return visitNode(node);
 	}
 	public boolean visit(FieldDeclaration node) {
 		return visitNode(node);
 	}
 	public boolean visit(InfixExpression node) {
 		return visitNode(node);
 	}
 	public boolean visit(Initializer node) {
 		return visitNode(node);
 	}
 	public boolean visit(MethodDeclaration node) {
 		return visitNode(node);
 	}
 	
 	//---
 	//This node is of type MethodInvocation thus
 	//this is one method call for this class file
 	//---
 	public boolean visit(MethodInvocation node) {
 		return visitNode(node);
 	}
 	public boolean visit(ParenthesizedExpression node) {
 		return visitNode(node);
 	}
 	public boolean visit(PostfixExpression node) {
 		return visitNode(node);
 	}
 	public boolean visit(PrefixExpression node) {
 		return visitNode(node);
 	}
 	public boolean visit(QualifiedName node) {
 		return visitNode(node);
 	}
 	public boolean visit(QualifiedType node) {
 		return visitNode(node);
 	}
 	public boolean visit(ReturnStatement node) {
 		return visitNode(node);
 	}
 	public boolean visit(SimpleName node) {
 		return visitNode(node);
 	}
 	public boolean visit(SimpleType node) {
 		return visitNode(node);
 	}
 	public boolean visit(SingleVariableDeclaration node) {
 		return visitNode(node);
 	}
 	//---
 	//Yup we're counting calls to super() as well
 	//---
 	public boolean visit(SuperConstructorInvocation node) {
 		return visitNode(node);
 	}
 	public boolean visit(SuperFieldAccess node) {
 		return visitNode(node);
 	}
 	//---
 	//super.X() counts as well
 	//---
 	public boolean visit(SuperMethodInvocation node) {
 		return visitNode(node);
 	}
 	public boolean visit(ThisExpression node) {
 		return visitNode(node);
 	}
 	public boolean visit(TypeDeclaration node) {
 		return visitNode(node);
 	}
 	public boolean visit(TypeDeclarationStatement node) {
 		return visitNode(node);
 	}
 	public boolean visit(TypeLiteral node) {
 		return visitNode(node);
 	}
 	public boolean visit(VariableDeclarationExpression node) {
 		return visitNode(node);
 	}
 	public boolean visit(VariableDeclarationStatement node) {
 		return visitNode(node);
 	}
 	public boolean visit(VariableDeclarationFragment node) {
 		return visitNode(node);
 	}

 	public boolean visit(AssertStatement node) {
 		return true; // recursive eval
 	}
 	public boolean visit(WhileStatement node) {
 		return true;
 	}
 	public boolean visit(SwitchStatement node) {
 		return true;
 	}
 	public boolean visit(Block node) {
 		return true; // recursive
 	}
 	public boolean visit(LabeledStatement node) {
 		return true; // recursive
 	}
 	public boolean visit(SwitchCase node) {
 		return true;
 	}
 	public boolean visit(IfStatement node) {
 		return true;
 	}
 	public boolean visit(ForStatement node) {
 		return true;
 	}
 	public boolean visit(DoStatement node) {
 		return true;
 	}
 	public boolean visit(ThrowStatement node) {
 		return true;
 	}
 	public boolean visit(SynchronizedStatement node) {
 		return true;
 	}
 	public boolean visit(TryStatement node) {
 		return true;
 	}
 	public boolean visit(InstanceofExpression node) {
 		return true;
 	}
 	
 	public boolean visit(StringLiteral node) {
 		return false; 	
 	}
 	public boolean visit(PrimitiveType node) {
 		return false; 
 	}
 	public boolean visit(NullLiteral node) {
 		return false;
 	}
 	public boolean visit(NumberLiteral node) {
 		return false;
 	}
 	public boolean visit(PackageDeclaration node) {
 		return false;
 	}
 	public boolean visit(BlockComment node) {
 		return false; 
 	}
 	public boolean visit(ImportDeclaration node) {
 		return false;
 	}
 	public boolean visit(EmptyStatement node) {
 		return false;
 	}
 	public boolean visit(TagElement node) {
 		return false; // comments; don't care
 	}
 	public boolean visit(TextElement node) {
 		return false; // comments; don't care
 	}
 	public boolean visit(BooleanLiteral node) {
 		return false;
 	}
 	public boolean visit(BreakStatement node) {
 		return false;
 	}
 	public boolean visit(ContinueStatement node) {
 		return false;
 	}
 	public boolean visit(Modifier node) {
 		return false;
 	}
 	public boolean visit(Javadoc node) {
 		return false;
 	}
 	public boolean visit(CharacterLiteral node) {
 		return false;
 	}
 	public boolean visit(LineComment node) {
 		return false;
 	}
 	public boolean visit(MethodRef node) {
 		return false; // comments
 	}
 	public boolean visit(MethodRefParameter node) {
 		return false; // comments
 	}
 	public boolean visit(MemberRef node) {
 		return false; // comments
 	}
 	
 }