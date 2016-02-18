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
	 * Enter a parse tree produced by {@link ShellParser#kernels}.
	 * @param ctx the parse tree
	 */
	void enterKernels(ShellParser.KernelsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#kernels}.
	 * @param ctx the parse tree
	 */
	void exitKernels(ShellParser.KernelsContext ctx);
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
	 * Enter a parse tree produced by {@link ShellParser#evaluateVar}.
	 * @param ctx the parse tree
	 */
	void enterEvaluateVar(ShellParser.EvaluateVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#evaluateVar}.
	 * @param ctx the parse tree
	 */
	void exitEvaluateVar(ShellParser.EvaluateVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#fieldVar}.
	 * @param ctx the parse tree
	 */
	void enterFieldVar(ShellParser.FieldVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#fieldVar}.
	 * @param ctx the parse tree
	 */
	void exitFieldVar(ShellParser.FieldVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#modelVar}.
	 * @param ctx the parse tree
	 */
	void enterModelVar(ShellParser.ModelVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#modelVar}.
	 * @param ctx the parse tree
	 */
	void exitModelVar(ShellParser.ModelVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#queryVar}.
	 * @param ctx the parse tree
	 */
	void enterQueryVar(ShellParser.QueryVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#queryVar}.
	 * @param ctx the parse tree
	 */
	void exitQueryVar(ShellParser.QueryVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#regionVar}.
	 * @param ctx the parse tree
	 */
	void enterRegionVar(ShellParser.RegionVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#regionVar}.
	 * @param ctx the parse tree
	 */
	void exitRegionVar(ShellParser.RegionVarContext ctx);
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
}