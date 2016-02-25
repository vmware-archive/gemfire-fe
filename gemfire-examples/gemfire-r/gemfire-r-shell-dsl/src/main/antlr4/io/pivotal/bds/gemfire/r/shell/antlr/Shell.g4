grammar Shell;

cmd: query | execute | svm | gp | trainModel | dtrainModel | predict | print | ls | rm | vector | matrix | fft ;

query: queryId EQUALS QUERY LPAREN queryString RPAREN ;
execute: EXECUTE LPAREN queryId (COMMA queryArg)* RPAREN ;
svm: modelId EQUALS SVM LPAREN cpVar COMMA cnVar COMMA kVar RPAREN ;
gp: modelId EQUALS GP LPAREN kernelId COMMA lambdaVar RPAREN ;
trainModel: trainId EQUALS TRAIN LPAREN modelId COMMA matrixId COMMA vectorId RPAREN ;
dtrainModel: trainId EQUALS DTRAIN LPAREN modelId COMMA regionName COMMA sizeVar COMMA yFieldName (COMMA xFieldName)+ RPAREN ;
predict: PREDICT LPAREN modelId COMMA (vectorId|number) RPAREN ;
vector: vectorId EQUALS VECTOR LPAREN queryId COMMA fieldName (COMMA queryArgs)? RPAREN ;
matrix: matrixId EQUALS MATRIX LPAREN queryId COMMA fieldNames (COMMA queryArgs)? RPAREN ;
print: PRINT var ;
ls: LS ;
rm: RM var ; 
fft: matrixId EQUALS FFT LPAREN fftInputId COMMA fftDir COMMA fftNorm RPAREN ;

kernel: kernelId EQUALS mercerkernel ;

mercerkernel
    : gaussKernel 
    | laplaceKernel 
    | linearKernel 
    | pearsonKernel 
    | polyKernel 
    | hypertangentKernel 
    | thinplatesplineKernel 
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
GP: 'gp';
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
