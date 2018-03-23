#!/usr/bin/env bash

set -e
set -o pipefail

baseDir="../src/main/resources/solidity"

generateTargets="
deposit/deposit
"

compileGenerateTargets="
withdraw/DepositProxy
sharednode/SharedMasternode
"


for target in ${generateTargets}; do
    dirName=$(dirname "${target}")
    fileName=$(basename "${target}")

    cd $baseDir
    echo "Generating contract bindings"
    web3j solidity generate \
        ${dirName}/build/${fileName}.bin \
        ${dirName}/build/${fileName}.abi \
        -p com.psdev.pirl.contracts.generated \
        -o ../../java/ > /dev/null

    echo "Complete"

    cd -
done

for target in ${compileGenerateTargets}; do
    dirName=$(dirname "${target}")
    fileName=$(basename "${target}")

    cd $baseDir
    echo "Compiling Solidity file ${target}.sol"

    solc --bin --abi --optimize --overwrite \
            --allow-paths "$(pwd)" \
            ${dirName}/${fileName}.sol -o ${dirName}/build/
    echo "Complete"

    echo "Generating contract bindings"
    web3j solidity generate \
        ${dirName}/build/${fileName}.bin \
        ${dirName}/build/${fileName}.abi \
        -p com.psdev.pirl.contracts.generated \
        -o ../../java/ > /dev/null

    echo "Complete"

    cd -
done
