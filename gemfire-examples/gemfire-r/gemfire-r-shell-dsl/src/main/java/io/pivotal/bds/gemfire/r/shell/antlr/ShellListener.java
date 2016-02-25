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
	 * Enter a parse tree produced by {@link ShellParser#trainModel}.
	 * @param ctx the parse tree
	 */
	void enterTrainModel(ShellParser.TrainModelContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#trainModel}.
	 * @param ctx the parse tree
	 */
	void exitTrainModel(ShellParser.TrainModelContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#dtrainModel}.
	 * @param ctx the parse tree
	 */
	void enterDtrainModel(ShellParser.DtrainModelContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#dtrainModel}.
	 * @param ctx the parse tree
	 */
	void exitDtrainModel(ShellParser.DtrainModelContext ctx);
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
	 * Enter a parse tree produced by {@link ShellParser#fft}.
	 * @param ctx the parse tree
	 */
	void enterFft(ShellParser.FftContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#fft}.
	 * @param ctx the parse tree
	 */
	void exitFft(ShellParser.FftContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#kernel}.
	 * @param ctx the parse tree
	 */
	void enterKernel(ShellParser.KernelContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#kernel}.
	 * @param ctx the parse tree
	 */
	void exitKernel(ShellParser.KernelContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#mercerkernel}.
	 * @param ctx the parse tree
	 */
	void enterMercerkernel(ShellParser.MercerkernelContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#mercerkernel}.
	 * @param ctx the parse tree
	 */
	void exitMercerkernel(ShellParser.MercerkernelContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#gaussKernel}.
	 * @param ctx the parse tree
	 */
	void enterGaussKernel(ShellParser.GaussKernelContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#gaussKernel}.
	 * @param ctx the parse tree
	 */
	void exitGaussKernel(ShellParser.GaussKernelContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#laplaceKernel}.
	 * @param ctx the parse tree
	 */
	void enterLaplaceKernel(ShellParser.LaplaceKernelContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#laplaceKernel}.
	 * @param ctx the parse tree
	 */
	void exitLaplaceKernel(ShellParser.LaplaceKernelContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#linearKernel}.
	 * @param ctx the parse tree
	 */
	void enterLinearKernel(ShellParser.LinearKernelContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#linearKernel}.
	 * @param ctx the parse tree
	 */
	void exitLinearKernel(ShellParser.LinearKernelContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#pearsonKernel}.
	 * @param ctx the parse tree
	 */
	void enterPearsonKernel(ShellParser.PearsonKernelContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#pearsonKernel}.
	 * @param ctx the parse tree
	 */
	void exitPearsonKernel(ShellParser.PearsonKernelContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#polyKernel}.
	 * @param ctx the parse tree
	 */
	void enterPolyKernel(ShellParser.PolyKernelContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#polyKernel}.
	 * @param ctx the parse tree
	 */
	void exitPolyKernel(ShellParser.PolyKernelContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#hypertangentKernel}.
	 * @param ctx the parse tree
	 */
	void enterHypertangentKernel(ShellParser.HypertangentKernelContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#hypertangentKernel}.
	 * @param ctx the parse tree
	 */
	void exitHypertangentKernel(ShellParser.HypertangentKernelContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#thinplatesplineKernel}.
	 * @param ctx the parse tree
	 */
	void enterThinplatesplineKernel(ShellParser.ThinplatesplineKernelContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#thinplatesplineKernel}.
	 * @param ctx the parse tree
	 */
	void exitThinplatesplineKernel(ShellParser.ThinplatesplineKernelContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#sparsegaussKernel}.
	 * @param ctx the parse tree
	 */
	void enterSparsegaussKernel(ShellParser.SparsegaussKernelContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#sparsegaussKernel}.
	 * @param ctx the parse tree
	 */
	void exitSparsegaussKernel(ShellParser.SparsegaussKernelContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#sparselaplaceKernel}.
	 * @param ctx the parse tree
	 */
	void enterSparselaplaceKernel(ShellParser.SparselaplaceKernelContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#sparselaplaceKernel}.
	 * @param ctx the parse tree
	 */
	void exitSparselaplaceKernel(ShellParser.SparselaplaceKernelContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#sparselinearKernel}.
	 * @param ctx the parse tree
	 */
	void enterSparselinearKernel(ShellParser.SparselinearKernelContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#sparselinearKernel}.
	 * @param ctx the parse tree
	 */
	void exitSparselinearKernel(ShellParser.SparselinearKernelContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#sparsepolyKernel}.
	 * @param ctx the parse tree
	 */
	void enterSparsepolyKernel(ShellParser.SparsepolyKernelContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#sparsepolyKernel}.
	 * @param ctx the parse tree
	 */
	void exitSparsepolyKernel(ShellParser.SparsepolyKernelContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#sparsehypertangentKernel}.
	 * @param ctx the parse tree
	 */
	void enterSparsehypertangentKernel(ShellParser.SparsehypertangentKernelContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#sparsehypertangentKernel}.
	 * @param ctx the parse tree
	 */
	void exitSparsehypertangentKernel(ShellParser.SparsehypertangentKernelContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#sparsethinplatesplineKernel}.
	 * @param ctx the parse tree
	 */
	void enterSparsethinplatesplineKernel(ShellParser.SparsethinplatesplineKernelContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#sparsethinplatesplineKernel}.
	 * @param ctx the parse tree
	 */
	void exitSparsethinplatesplineKernel(ShellParser.SparsethinplatesplineKernelContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#binarysparsegaussKernel}.
	 * @param ctx the parse tree
	 */
	void enterBinarysparsegaussKernel(ShellParser.BinarysparsegaussKernelContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#binarysparsegaussKernel}.
	 * @param ctx the parse tree
	 */
	void exitBinarysparsegaussKernel(ShellParser.BinarysparsegaussKernelContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#binarysparselaplaceKernel}.
	 * @param ctx the parse tree
	 */
	void enterBinarysparselaplaceKernel(ShellParser.BinarysparselaplaceKernelContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#binarysparselaplaceKernel}.
	 * @param ctx the parse tree
	 */
	void exitBinarysparselaplaceKernel(ShellParser.BinarysparselaplaceKernelContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#binarysparselinearKernel}.
	 * @param ctx the parse tree
	 */
	void enterBinarysparselinearKernel(ShellParser.BinarysparselinearKernelContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#binarysparselinearKernel}.
	 * @param ctx the parse tree
	 */
	void exitBinarysparselinearKernel(ShellParser.BinarysparselinearKernelContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#binarysparsepolyKernel}.
	 * @param ctx the parse tree
	 */
	void enterBinarysparsepolyKernel(ShellParser.BinarysparsepolyKernelContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#binarysparsepolyKernel}.
	 * @param ctx the parse tree
	 */
	void exitBinarysparsepolyKernel(ShellParser.BinarysparsepolyKernelContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#binarysparsehypertangentKernel}.
	 * @param ctx the parse tree
	 */
	void enterBinarysparsehypertangentKernel(ShellParser.BinarysparsehypertangentKernelContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#binarysparsehypertangentKernel}.
	 * @param ctx the parse tree
	 */
	void exitBinarysparsehypertangentKernel(ShellParser.BinarysparsehypertangentKernelContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#binarysparsethinplatesplineKernel}.
	 * @param ctx the parse tree
	 */
	void enterBinarysparsethinplatesplineKernel(ShellParser.BinarysparsethinplatesplineKernelContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#binarysparsethinplatesplineKernel}.
	 * @param ctx the parse tree
	 */
	void exitBinarysparsethinplatesplineKernel(ShellParser.BinarysparsethinplatesplineKernelContext ctx);
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
	 * Enter a parse tree produced by {@link ShellParser#sigmaVar}.
	 * @param ctx the parse tree
	 */
	void enterSigmaVar(ShellParser.SigmaVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#sigmaVar}.
	 * @param ctx the parse tree
	 */
	void exitSigmaVar(ShellParser.SigmaVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#omegaVar}.
	 * @param ctx the parse tree
	 */
	void enterOmegaVar(ShellParser.OmegaVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#omegaVar}.
	 * @param ctx the parse tree
	 */
	void exitOmegaVar(ShellParser.OmegaVarContext ctx);
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
	 * Enter a parse tree produced by {@link ShellParser#degreeVar}.
	 * @param ctx the parse tree
	 */
	void enterDegreeVar(ShellParser.DegreeVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#degreeVar}.
	 * @param ctx the parse tree
	 */
	void exitDegreeVar(ShellParser.DegreeVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#scaleVar}.
	 * @param ctx the parse tree
	 */
	void enterScaleVar(ShellParser.ScaleVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#scaleVar}.
	 * @param ctx the parse tree
	 */
	void exitScaleVar(ShellParser.ScaleVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#offsetVar}.
	 * @param ctx the parse tree
	 */
	void enterOffsetVar(ShellParser.OffsetVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#offsetVar}.
	 * @param ctx the parse tree
	 */
	void exitOffsetVar(ShellParser.OffsetVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#xFieldName}.
	 * @param ctx the parse tree
	 */
	void enterXFieldName(ShellParser.XFieldNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#xFieldName}.
	 * @param ctx the parse tree
	 */
	void exitXFieldName(ShellParser.XFieldNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#yFieldName}.
	 * @param ctx the parse tree
	 */
	void enterYFieldName(ShellParser.YFieldNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#yFieldName}.
	 * @param ctx the parse tree
	 */
	void exitYFieldName(ShellParser.YFieldNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#sizeVar}.
	 * @param ctx the parse tree
	 */
	void enterSizeVar(ShellParser.SizeVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#sizeVar}.
	 * @param ctx the parse tree
	 */
	void exitSizeVar(ShellParser.SizeVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#trainId}.
	 * @param ctx the parse tree
	 */
	void enterTrainId(ShellParser.TrainIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#trainId}.
	 * @param ctx the parse tree
	 */
	void exitTrainId(ShellParser.TrainIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#fftInputId}.
	 * @param ctx the parse tree
	 */
	void enterFftInputId(ShellParser.FftInputIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#fftInputId}.
	 * @param ctx the parse tree
	 */
	void exitFftInputId(ShellParser.FftInputIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#fftDir}.
	 * @param ctx the parse tree
	 */
	void enterFftDir(ShellParser.FftDirContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#fftDir}.
	 * @param ctx the parse tree
	 */
	void exitFftDir(ShellParser.FftDirContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShellParser#fftNorm}.
	 * @param ctx the parse tree
	 */
	void enterFftNorm(ShellParser.FftNormContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShellParser#fftNorm}.
	 * @param ctx the parse tree
	 */
	void exitFftNorm(ShellParser.FftNormContext ctx);
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