clear 

mvn dependency:copy-dependencies
export CLASPATH=""
for file in `ls target/dependency`; do export CLASSPATH=$CLASSPATH:target/dependency/$file; done
export CLASSPATH=$CLASSPATH:target/classes
java -cp $CLASSPATH -Dactivejdbc.log com.unrc.app.Inmo
