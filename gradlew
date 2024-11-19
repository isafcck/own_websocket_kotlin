#!/bin/sh
export GRADLE_HOME=$(pwd)/gradle
export PATH=$GRADLE_HOME/bin:$PATH
exec java -Duser.home=$GRADLE_USER_HOME -cp "$GRADLE_HOME/lib/*" org.gradle.wrapper.GradleWrapperMain "$@"

