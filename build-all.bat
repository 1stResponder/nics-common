pushd nics-common
call mvn clean install -DskipTests=true
popd

pushd nics-tools
call mvn clean install
popd

pushd em-api
call mvn clean install
popd

pushd nics-assembly
call mvn clean install
popd

pushd nics-core-processor
call mvn clean install
popd

pushd iweb-modules
call mvn clean install
popd

pushd nics-web
call mvn clean install
popd

pushd nics-monitoring
call mvn clean install
popd






