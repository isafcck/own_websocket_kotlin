@echo off
set GRADLE_HOME=%~dp0\gradle
set PATH=%GRADLE_HOME%\bin;%PATH%
java -Duser.home=%GRADLE_USER_HOME% -cp "%GRADLE_HOME%\lib\*" org.gradle.wrapper.GradleWrapperMain %*

