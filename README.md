## Projects
* Assignment1TTTCommon : Contains the UI agnostic ttt game logic.  Both of the following projects depend on this project.  Because of an issue with gradel, you must build Assignment1TTTCommon which generates a jar before running the Assignment1TTTAndroid project.  Assignment1TTTJava has a correct gradle dependency.
* Assignment1TTTAndroid : The android project.  Not setup to build an .apk file, you have to load this in androidstudio in order to run.
* Assignment1TTTJava : The applet project.  Running 'gradle fatJar' generates a runnable jar: 

## Scripts
* build.sh : run to build the Assignment1TTTCommon and Assignment1TTTJava projects.  Required before running the Assignment1TTTAndroid from androidstudio.
* playTTT.sh : starts the runnable jar created by Assignment1TTTJava.  Play some TTT.
