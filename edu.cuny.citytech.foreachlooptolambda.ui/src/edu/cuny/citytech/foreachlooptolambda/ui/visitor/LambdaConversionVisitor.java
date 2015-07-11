package edu.cuny.citytech.foreachlooptolambda.ui.visitor;

import org.eclipse.jdt.core.dom.*;
import org.eclipse.jdt.core.IMethod;



 public class LambdaConversionVisitor extends ASTVisitor {
 	private IMethod mainMeth;
 	private int numCalls = 0;
 	private int numNodes = 0;
 	
 	public LambdaConversionVisitor (){
 		super();
 	}
 	
 	//---
 	//This returns the number of nodes that was encountered by
 	//this visitor
 	//---
 	public int getNumberOfNodes(){
 		return this.numNodes;
 	}
 	
 	//---
 	//This returns the number of method invocations
 	//counted by this visitor
 	//----
 	public int getNumberOfMethodCalls(){
 		return this.numCalls;
 	}
 	

 
 	public void preVisit(ASTNode node) {
 		super.preVisit(node);
 	}	
 	public void postVisit(ASTNode node) {
 		this.numNodes++;
 		super.postVisit(node);
 	}
 	public boolean visitNode(ASTNode node) {
 		return true;
 	}
 	
 	// ======================================================
 	
 	
 	public boolean visit(AnonymousClassDeclaration node) {
 		return visitNode(node);
 	}
 	public boolean visit(ArrayAccess node) {
 		return visitNode(node);
 	}
 	public boolean visit(ArrayCreation node) {
 		return visitNode(node);
 	}
 	public boolean visit(ArrayInitializer node) {
 		return visitNode(node);
 	}
 	public boolean visit(ArrayType node) {
 		return visitNode(node);
 	}
 	public boolean visit(Assignment node) {
 		return visitNode(node);
 	}
 	public boolean visit(CastExpression node) {
 		return visitNode(node);
 	}
 	public boolean visit(CatchClause node) {
 		return visitNode(node);
 	}
 	public boolean visit(ClassInstanceCreation node) {
 		return visitNode(node);
 	}
 	public boolean visit(CompilationUnit node) {
 		return visitNode(node);
 	}
 	public boolean visit(ConditionalExpression node) {
 		return visitNode(node);
 	}
 	//---
 	//We are going to count constructors as 
 	//methods thus we need to increment numCalls
 	//---
 	public boolean visit(ConstructorInvocation node) {
 		this.numCalls++;
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
 		this.numCalls++;
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
 		this.numCalls++;
 		return visitNode(node);
 	}
 	public boolean visit(SuperFieldAccess node) {
 		return visitNode(node);
 	}
 	//---
 	//super.X() counts as well
 	//---
 	public boolean visit(SuperMethodInvocation node) {
 		this.numCalls++;
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
 	
 	public boolean visit(AnnotationTypeDeclaration node) {
 		return false; // 1.5
 	}
 	public boolean visit(AnnotationTypeMemberDeclaration node) {
 		return false; // 1.5 
 	}
 	public boolean visit(WildcardType node) {
 		return false; // Java2 1.5
 	}
 	public boolean visit(SingleMemberAnnotation node) {
 		return false; // Java2 1.5
 	}
 	public boolean visit(ParameterizedType node) {
 		return false;
 	}
 	public boolean visit(EnhancedForStatement node) {
 		return false; // 1.5
 	}
 	public boolean visit(MarkerAnnotation node) {
 		return false; // 1.5
 	}
 	public boolean visit(NormalAnnotation node) {
 		return false; // 1.5
 	}
 	public boolean visit(TypeParameter node) {
 		return false; // 1.5
 	}
 	public boolean visit(MemberValuePair node) {
 		return false; // 1.5
 	}
 	public boolean visit(EnumConstantDeclaration node) {
 		return false; // 1.5
 	}
 	public boolean visit(EnumDeclaration node) {
 		return false; // 1.5
 	}

 	// There are corresponding endVisit methods
 		
 }