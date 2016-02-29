grammar Shell;

cmd
    : query 
    | execute 
    | svm
    | fld
    | randomForestClassification
    | decisionTree
    | qda
    | lda
    | rda
    | gaussianProcess 
    | regressionTree 
    | randomForestRegression 
    | ridgeRegression 
    | svr 
    | kernel 
    | trainModel 
    | dtrainModel 
    | predict 
    | print 
    | ls 
    | rm 
    | vector 
    | matrix 
    | fft ;

rda: modelId EQUALS RDA LPAREN alphaVar COMMA tolVar (COMMA prioriVar)+ RPAREN ;
lda: modelId EQUALS LDA LPAREN tolVar (COMMA prioriVar)+ RPAREN ;
qda: modelId EQUALS QDA LPAREN tolVar (COMMA prioriVar)+ RPAREN ;
fld: modelId EQUALS FLD LPAREN lVar COMMA tolVar RPAREN ;
randomForestClassification: modelId EQUALS RANDOMFOREST_CLASSIFICATION LPAREN ntreesVar COMMA mtryVar RPAREN ;
decisionTree: modelId EQUALS DECISIONTREE LPAREN jVar COMMA dtreeSplitRuleVar RPAREN ;
svm: modelId EQUALS SVM LPAREN cpVar COMMA cnVar COMMA kVar RPAREN ;

gaussianProcess: modelId EQUALS GAUSSIANPROCESS LPAREN kernelId COMMA lambdaVar RPAREN ;
regressionTree: modelId EQUALS REGRESSIONTREE LPAREN jVar RPAREN ;
randomForestRegression: modelId EQUALS RANDOMFORESTREGRESSION LPAREN tVar COMMA mVar COMMA sVar RPAREN ;
ridgeRegression: modelId EQUALS RIDGEREGRESSION LPAREN lambdaVar RPAREN ;
svr: modelId EQUALS SVR LPAREN kernelId COMMA epsVar COMMA cVar COMMA tolVar RPAREN ;

knn: modelId EQUALS KNN LPAREN kernelId COMMA epsVar COMMA cVar COMMA tolVar RPAREN ;

query: queryId EQUALS QUERY LPAREN queryString RPAREN ;
execute: EXECUTE LPAREN queryId (COMMA queryArg)* RPAREN ;

trainModel: trainId EQUALS TRAIN LPAREN modelId COMMA matrixId COMMA vectorId RPAREN ;
dtrainModel: trainId EQUALS DTRAIN LPAREN modelId COMMA regionName COMMA sizeVar COMMA yFieldName (COMMA xFieldName)+ RPAREN ;
predict: PREDICT LPAREN modelId COMMA (vectorId|number) RPAREN ;

vector: vectorId EQUALS VECTOR LPAREN queryId COMMA fieldName (COMMA queryArgs)? RPAREN ;
matrix: matrixId EQUALS MATRIX LPAREN queryId COMMA fieldNames (COMMA queryArgs)? RPAREN ;

fft: matrixId EQUALS FFT LPAREN fftInputId COMMA fftDir COMMA fftNorm RPAREN ;

print: PRINT var ;
ls: LS ;
rm: RM var ; 

dtreeSplitRuleVar: DECISIONTREE_CLASSIFICATIONERROR | ENTROPY | GINI ;

kernel: kernelId EQUALS mercerkernel ;

mercerkernel
    : gaussKernel 
    | laplaceKernel 
    | linearKernel 
    | pearsonKernel 
    | polyKernel 
    | hypertangentKernel 
    | thinplatesplineKernel
    | hellingerKernel 
    | sparsegaussKernel 
    | sparselaplaceKernel
    | sparselinearKernel
    | sparsepolyKernel
    | sparsehypertangentKernel
    | sparsethinplatesplineKernel
    | binarysparsegaussKernel
    | binarysparselaplaceKernel
    | binarysparselinearKernel
    | binarysparsepolyKernel
    | binarysparsehypertangentKernel
    | binarysparsethinplatesplineKernel
    ; 
    
gaussKernel: kernelId EQUALS GAUSSIANKERNEL LPAREN sigmaVar RPAREN ;
laplaceKernel: kernelId EQUALS LAPLACEKERNEL LPAREN sigmaVar RPAREN ;
linearKernel: kernelId EQUALS LINEARKERNEL ;
pearsonKernel: kernelId EQUALS PEARSONKERNEL LPAREN sigmaVar COMMA omegaVar RPAREN ;
polyKernel: kernelId EQUALS POLYNOMIALKERNEL LPAREN degreeVar COMMA scaleVar COMMA offsetVar RPAREN ;
hypertangentKernel: kernelId EQUALS HYPERBOLICTANGENTKERNEL LPAREN scaleVar COMMA offsetVar RPAREN ;
thinplatesplineKernel: kernelId EQUALS THINPLATEPLINEKERNEL LPAREN sigmaVar RPAREN ;
hellingerKernel: kernelId EQUALS HELLINGERKERNEL ;

sparsegaussKernel: kernelId EQUALS SPARSEGAUSSIANKERNEL LPAREN sigmaVar RPAREN ;
sparselaplaceKernel: kernelId EQUALS SPARSELAPLACEKERNEL LPAREN sigmaVar RPAREN ;
sparselinearKernel: kernelId EQUALS SPARSELINEARKERNEL ;
sparsepolyKernel: kernelId EQUALS SPARSEPOLYNOMIALKERNEL LPAREN degreeVar COMMA scaleVar COMMA offsetVar RPAREN ;
sparsehypertangentKernel: kernelId EQUALS SPARSEHYPERBOLICTANGENTKERNEL LPAREN scaleVar COMMA offsetVar RPAREN ;
sparsethinplatesplineKernel: kernelId EQUALS SPARSETHINPLATEPLINEKERNEL LPAREN sigmaVar RPAREN ;

binarysparsegaussKernel: kernelId EQUALS BINARYSPARSEGAUSSIANKERNEL LPAREN sigmaVar RPAREN ;
binarysparselaplaceKernel: kernelId EQUALS BINARYSPARSELAPLACEKERNEL LPAREN sigmaVar RPAREN ;
binarysparselinearKernel: kernelId EQUALS BINARYSPARSELINEARKERNEL ;
binarysparsepolyKernel: kernelId EQUALS BINARYSPARSEPOLYNOMIALKERNEL LPAREN degreeVar COMMA scaleVar COMMA offsetVar RPAREN ;
binarysparsehypertangentKernel: kernelId EQUALS BINARYSPARSEHYPERBOLICTANGENTKERNEL LPAREN scaleVar COMMA offsetVar RPAREN ;
binarysparsethinplatesplineKernel: kernelId EQUALS BINARYSPARSETHINPLATEPLINEKERNEL LPAREN sigmaVar RPAREN ;

tVar: NUMBER ;
mVar: NUMBER ;
sVar: NUMBER ;
jVar: NUMBER ;
alphaVar: NUMBER ;
prioriVar: NUMBER ;
lVar: NUMBER ;
mtryVar: NUMBER ;
ntreesVar: NUMBER ;
maxNodesVar: NUMBER ;
nodeSizeVar: NUMBER ;

tolVar: NUMBER ;
epsVar: NUMBER ;
cVar: NUMBER ;
cpVar: NUMBER ;
cnVar: NUMBER ;
kVar: NUMBER ;
sigmaVar: NUMBER ;
omegaVar: NUMBER ;
lambdaVar: NUMBER ;
degreeVar: NUMBER ;
scaleVar: NUMBER ;
offsetVar: NUMBER ;

xFieldName: IDENTIFIER ;
yFieldName: IDENTIFIER ;
sizeVar: NUMBER ;
trainId: IDENTIFIER ;
fftInputId: IDENTIFIER ;
fftDir: FORWARD | INVERSE ;
fftNorm: STANDARD | UNITARY ;
queryArg: QUOTEDSTRING | NUMBER ;
queryArgs: LBRACKET queryArg (COMMA queryArg)* RBRACKET ;
fieldNames: LBRACKET fieldName (COMMA fieldName)* RBRACKET ;
var: IDENTIFIER ;
fieldName: IDENTIFIER ;
modelId: IDENTIFIER ;
queryId: IDENTIFIER ;
regionName: IDENTIFIER ;
matrixId: IDENTIFIER ;
vectorId: IDENTIFIER ;
kernelId: IDENTIFIER ;
queryString : QUOTEDSTRING ;
number: NUMBER;

GAUSSIANKERNEL: 'gausskernel';
LAPLACEKERNEL: 'laplacekernel';
LINEARKERNEL: 'linearkernel';
PEARSONKERNEL: 'pearsonkernel';
POLYNOMIALKERNEL: 'polykernel';
HYPERBOLICTANGENTKERNEL: 'hypertangentkernel';
THINPLATEPLINEKERNEL: 'thinplatesplinekernel';
HELLINGERKERNEL: 'hellingerkernel';

SPARSEGAUSSIANKERNEL: 'sparsegausskernel';
SPARSELAPLACEKERNEL: 'sparselaplacekernel';
SPARSELINEARKERNEL: 'sparselinearkernel';
SPARSEPOLYNOMIALKERNEL: 'sparsepolykernel';
SPARSEHYPERBOLICTANGENTKERNEL: 'sparsehypertangentkernel';
SPARSETHINPLATEPLINEKERNEL: 'sparsethinplatesplinekernel';

BINARYSPARSEGAUSSIANKERNEL: 'binarysparsegausskernel';
BINARYSPARSELAPLACEKERNEL: 'binarysparselaplacekernel';
BINARYSPARSELINEARKERNEL: 'binarysparselinearkernel';
BINARYSPARSEPOLYNOMIALKERNEL: 'binarysparsepolykernel';
BINARYSPARSEHYPERBOLICTANGENTKERNEL: 'binarysparsehypertangentkernel';
BINARYSPARSETHINPLATEPLINEKERNEL: 'binarysparsethinplatesplinekernel';

RBF_NETWORK: 'rbfnet';
RANDOMFOREST_CLASSIFICATION: 'rforestc';
FLD: 'fld';
QDA: 'qda';
LDA: 'lda';
RDA: 'rda';
LOGISTIC_REGRESSION: 'lregress';
NAIVE_BAYES: 'nbayes';
NEUTRAL_NETWORK: 'neuralnet';
KNN: 'knn';
DECISIONTREE_CLASSIFICATIONERROR: 'classerror';
DECISIONTREE: 'dtree';

GAUSSIANPROCESS: 'gp';
REGRESSIONTREE: 'rtree';
RANDOMFORESTREGRESSION: 'rforestr';
RIDGEREGRESSION: 'ridger';
SVR: 'svr';

ENTROPY: 'entropy';
GINI: 'gini';
DTRAIN: 'dtrain';
TRAIN: 'train' ;
FFT: 'fft' ;
FORWARD: 'forward';
INVERSE: 'inverse';
STANDARD: 'standard';
UNITARY: 'unitary';
MATRIX: 'matrix';
VECTOR: 'vect';
QUERYARGS: 'queryArgs';
MODEL: 'model';
FIELDS: 'fields';
REGION: 'region';
RM: 'rm';
LS: 'ls';
PRINT: 'print';
PREDICT: 'predict';
K: 'k';
LAMBDA: 'lambda';
SVM: 'svm';
CP: 'cp';
CN: 'cn';
QUERY: 'query';
EXECUTE: 'execute';

LBRACKET: '[' ;
RBRACKET: ']' ;
LPAREN : '(' ;
RPAREN : ')' ;
LBRACE : '{' ;
RBRACE : '}' ;
DBLQUOTES : '"' ;
COMMA : ',' ;
EQUALS : '=' ;
IDENTIFIER : [a-zA-Z][a-zA-Z0-9_.]* ;
DIGIT: [0-9] ;
NUMBER: DIGIT+ ('.' DIGIT+)? ;
QUOTEDSTRING : DBLQUOTES (~["])+? DBLQUOTES ;
WS :  [ \t\r\n\u000C]+ -> skip ;
