// Generated from io/pivotal/bds/gemfire/r/shell/antlr/Shell.g4 by ANTLR 4.5.2
package io.pivotal.bds.gemfire.r.shell.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ShellParser}.
 */
public interface ShellListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ShellParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(ShellParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(ShellParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#query}.
	 * @param ctx the parse tree
	 */
	void enterQuery(ShellParser.QueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#query}.
	 * @param ctx the parse tree
	 */
	void exitQuery(ShellParser.QueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#execute}.
	 * @param ctx the parse tree
	 */
	void enterExecute(ShellParser.ExecuteContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#execute}.
	 * @param ctx the parse tree
	 */
	void exitExecute(ShellParser.ExecuteContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#svm}.
	 * @param ctx the parse tree
	 */
	void enterSvm(ShellParser.SvmContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#svm}.
	 * @param ctx the parse tree
	 */
	void exitSvm(ShellParser.SvmContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#gp}.
	 * @param ctx the parse tree
	 */
	void enterGp(ShellParser.GpContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#gp}.
	 * @param ctx the parse tree
	 */
	void exitGp(ShellParser.GpContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#predict}.
	 * @param ctx the parse tree
	 */
	void enterPredict(ShellParser.PredictContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#predict}.
	 * @param ctx the parse tree
	 */
	void exitPredict(ShellParser.PredictContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#evaluate}.
	 * @param ctx the parse tree
	 */
	void enterEvaluate(ShellParser.EvaluateContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#evaluate}.
	 * @param ctx the parse tree
	 */
	void exitEvaluate(ShellParser.EvaluateContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#vector}.
	 * @param ctx the parse tree
	 */
	void enterVector(ShellParser.VectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#vector}.
	 * @param ctx the parse tree
	 */
	void exitVector(ShellParser.VectorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#matrix}.
	 * @param ctx the parse tree
	 */
	void enterMatrix(ShellParser.MatrixContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#matrix}.
	 * @param ctx the parse tree
	 */
	void exitMatrix(ShellParser.MatrixContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(ShellParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(ShellParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#ls}.
	 * @param ctx the parse tree
	 */
	void enterLs(ShellParser.LsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#ls}.
	 * @param ctx the parse tree
	 */
	void exitLs(ShellParser.LsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#rm}.
	 * @param ctx the parse tree
	 */
	void enterRm(ShellParser.RmContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#rm}.
	 * @param ctx the parse tree
	 */
	void exitRm(ShellParser.RmContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#queryArg}.
	 * @param ctx the parse tree
	 */
	void enterQueryArg(ShellParser.QueryArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#queryArg}.
	 * @param ctx the parse tree
	 */
	void exitQueryArg(ShellParser.QueryArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#queryArgs}.
	 * @param ctx the parse tree
	 */
	void enterQueryArgs(ShellParser.QueryArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#queryArgs}.
	 * @param ctx the parse tree
	 */
	void exitQueryArgs(ShellParser.QueryArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#fieldNames}.
	 * @param ctx the parse tree
	 */
	void enterFieldNames(ShellParser.FieldNamesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#fieldNames}.
	 * @param ctx the parse tree
	 */
	void exitFieldNames(ShellParser.FieldNamesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#cpVar}.
	 * @param ctx the parse tree
	 */
	void enterCpVar(ShellParser.CpVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#cpVar}.
	 * @param ctx the parse tree
	 */
	void exitCpVar(ShellParser.CpVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#cnVar}.
	 * @param ctx the parse tree
	 */
	void enterCnVar(ShellParser.CnVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#cnVar}.
	 * @param ctx the parse tree
	 */
	void exitCnVar(ShellParser.CnVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#kVar}.
	 * @param ctx the parse tree
	 */
	void enterKVar(ShellParser.KVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#kVar}.
	 * @param ctx the parse tree
	 */
	void exitKVar(ShellParser.KVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#lambdaVar}.
	 * @param ctx the parse tree
	 */
	void enterLambdaVar(ShellParser.LambdaVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#lambdaVar}.
	 * @param ctx the parse tree
	 */
	void exitLambdaVar(ShellParser.LambdaVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(ShellParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(ShellParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#evaluateId}.
	 * @param ctx the parse tree
	 */
	void enterEvaluateId(ShellParser.EvaluateIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#evaluateId}.
	 * @param ctx the parse tree
	 */
	void exitEvaluateId(ShellParser.EvaluateIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#fieldName}.
	 * @param ctx the parse tree
	 */
	void enterFieldName(ShellParser.FieldNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#fieldName}.
	 * @param ctx the parse tree
	 */
	void exitFieldName(ShellParser.FieldNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#modelId}.
	 * @param ctx the parse tree
	 */
	void enterModelId(ShellParser.ModelIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#modelId}.
	 * @param ctx the parse tree
	 */
	void exitModelId(ShellParser.ModelIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#queryId}.
	 * @param ctx the parse tree
	 */
	void enterQueryId(ShellParser.QueryIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#queryId}.
	 * @param ctx the parse tree
	 */
	void exitQueryId(ShellParser.QueryIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#regionName}.
	 * @param ctx the parse tree
	 */
	void enterRegionName(ShellParser.RegionNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#regionName}.
	 * @param ctx the parse tree
	 */
	void exitRegionName(ShellParser.RegionNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#matrixId}.
	 * @param ctx the parse tree
	 */
	void enterMatrixId(ShellParser.MatrixIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#matrixId}.
	 * @param ctx the parse tree
	 */
	void exitMatrixId(ShellParser.MatrixIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#vectorId}.
	 * @param ctx the parse tree
	 */
	void enterVectorId(ShellParser.VectorIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#vectorId}.
	 * @param ctx the parse tree
	 */
	void exitVectorId(ShellParser.VectorIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#kernelId}.
	 * @param ctx the parse tree
	 */
	void enterKernelId(ShellParser.KernelIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#kernelId}.
	 * @param ctx the parse tree
	 */
	void exitKernelId(ShellParser.KernelIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#queryString}.
	 * @param ctx the parse tree
	 */
	void enterQueryString(ShellParser.QueryStringContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#queryString}.
	 * @param ctx the parse tree
	 */
	void exitQueryString(ShellParser.QueryStringContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(ShellParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(ShellParser.NumberContext ctx);
}