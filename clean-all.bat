pushd nics-common
call mvn clean
popd

pushd nics-tools
call mvn clean
popd

pushd em-api
call mvn clean
popd

pushd nics-assembly
call mvn clean
popd

pushd nics-core-processor
call mvn clean
popd

pushd iweb-modules
call mvn clean
popd

pushd nics-web
call mvn clean
popd

pushd nics-monitoring
call mvn clean
popd






