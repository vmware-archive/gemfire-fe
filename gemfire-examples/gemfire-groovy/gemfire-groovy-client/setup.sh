#!/bin/bash

upload() {
    curl -X POST -w "\n" -H "Content-Type: text/plain" --data-binary @src/test/groovy/$1 http://localhost:8180/script/?name=$1
}

curl -X POST -w "\n" -d "id=nyse&name=NYSE" http://localhost:8180/issuer
curl -X POST -w "\n" -d "id=emc&description=EMC&issuerId=nyse&price=12.34" http://localhost:8180/security
curl -X POST -w "\n" -d "id=vmw&description=VMware&issuerId=nyse&price=23.45" http://localhost:8180/security
curl -X POST -w "\n" -d "id=piv&description=Pivotal&issuerId=nyse&price=100.00" http://localhost:8180/security
curl -X POST -w "\n" -d "id=acct1&name=Account1&balance=100000.00" http://localhost:8180/account
curl -X POST -w "\n" -d "id=acct2&name=Account1&balance=100000.00" http://localhost:8180/account
curl -X POST -w "\n" -d "id=acct3&name=Account1&balance=100000.00" http://localhost:8180/account

upload "io/pivotal/bds/gemfire/groovy/ApplicationContextSupport.groovy"
upload "io/pivotal/bds/gemfire/groovy/TradeProcessor.groovy"
upload "io/pivotal/bds/gemfire/groovy/trade.groovy"
