# This is a configuration file for Fiji mAKE ("fake")
#
# The syntax of a Fakefile is meant to be very simple.
#
# The first rule is the default rule.
#
# All rules are of the form
#
#	target <- prerequisites
#
# before making "target", all prerequisites will be made (i.e. if there
# exists a rule, for an item on the right side, it will be executed before
# the current rule).
#
# Most rules have implicit actions: if the target is a .jar file, the items
# on the right side are packaged into the target, compiling them first, if
# they are .java files.
#
# If the last item on the right side is a .c file, the GNU C++ compiler
# will be invoked to make the target from it.
#
# If an item on the right side is a directory, and a Fakefile or a Makefile
# exists in that directory, "fake" or "make" will be called in that directory.
# The target will be simply copied from that directory after handling all
# dependencies.
#
# There is a special type of rule when "fake" does not know how to produce
# the target from the prerequisites: you can call a program with
#
#	target[program] <- items
#
# This will check if the target is up-to-date, by checking the timestamps of the
# items (if there is no item, the target is deemed _not_ up-to-date). If the target
# is not up-to-date, "fake" will execute the program with all items as parameters.
#
# Variables are defined like this:
#
#	VARIABLE=VALUE
#
# and their values can be accessed with "$VARIABLE" in most places.
#
# You can define variables depending on the platform, the target, and in some
# cases the prerequisite, by adding a tag in parentheses to the name:
#
#	VARIABLE(target)=xyz
#	VARIABLE(platform)=abc

# These variables are special, as they will be interpreted by "fake".

# Do not be verbose
verbose=false

# Usually not necessary
debug=false

# Compile .java files for this Java version
javaVersion=1.5

# Whether to show use of deprecated entities
showDeprecation=false

# If false, skips rebuilds triggered from newer Fakefile or fake.jar
# (see issues 40 & 45)
rebuildIfFakeIsNewer=true

# When building a .jar file, and a .config file of the same name is found in
# this directory, it will be included as "plugins.config".
pluginsConfigDirectory=staged-plugins

# When a prerequisite is a directory, but contains neither Fakefile nor
# Makefile, just ignore it
ignoreMissingFakefiles=true

# When a submodule could not be made, fall back to copying from this directory
precompiledDirectory=precompiled/

buildDir=build/

FIJI_JAVA_HOME(linux)=java/linux/jdk1.6.0_24/jre
FIJI_JAVA_HOME(linux64)=java/linux-amd64/jdk1.6.0_24/jre
FIJI_JAVA_HOME(win32)=java/win32/jdk1.6.0_24/jre
FIJI_JAVA_HOME(win64)=java/win64/jdk1.6.0_24/jre
FIJI_JAVA_HOME(macosx)=java/macosx-java3d
JAVA_HOME=$FIJI_JAVA_HOME
ENVOVERRIDES(JAVA_HOME)=true

# Java 3D
FIJI_JAVA_EXT=$FIJI_JAVA_HOME/lib/ext
FIJI_JAVA_EXT(macosx)=$FIJI_JAVA_HOME/Home/lib/ext
JAVA3D_JARS=$FIJI_JAVA_EXT/j3dcore.jar:$FIJI_JAVA_EXT/j3dutils.jar:$FIJI_JAVA_EXT/vecmath.jar

# tools.jar
TOOLS_JAR=$JAVA_HOME/../lib/tools.jar
TOOLS_JAR(macosx)=/System/Library/Frameworks/JavaVM.framework/Classes/classes.jar

# the main target

SUBMODULE_TARGETS=\
	jars/ij.jar \
	misc/headless.jar \
	plugins/loci_tools.jar \
	jars/VectorString.jar \
	plugins/TrakEM2_.jar \
	plugins/mpicbg_.jar \
	jars/clojure.jar \
	plugins/ij-ImageIO_.jar \
	jars/jacl.jar \
	jars/batik.jar \
	jars/junit-4.5.jar \
	jars/rsyntaxtextarea.jar \
	jars/autocomplete.jar \
	jars/weka.jar \
	jars/jython.jar \
	jars/imglib.jar \
	jars/imglib-algorithms.jar \
	jars/imglib-ij.jar \
	jars/imglib-io.jar \
	jars/mpicbg.jar \
	jars/commons-math.jar \
	jars/javassist.jar \
	jars/jsch-0.1.44.jar \
	jars/imglib-scripting.jar \

PLUGIN_TARGETS=plugins/Jython_Interpreter.jar \
	plugins/Clojure_Interpreter.jar \
	plugins/JRuby_Interpreter.jar \
	plugins/BeanShell_Interpreter.jar \
	plugins/bUnwarpJ_.jar \
	plugins/register_virtual_stack_slices.jar \
	plugins/Siox_Segmentation.jar \
	plugins/registration_3d.jar \
	plugins/IO_.jar \
	plugins/CLI_.jar \
	plugins/Javascript_.jar \
	plugins/LSM_Toolbox.jar \
	plugins/SplineDeformationGenerator_.jar \
	plugins/level_sets.jar \
	plugins/Analyze_Reader_Writer.jar \
	plugins/Color_Histogram.jar \
	plugins/Color_Inspector_3D.jar \
	plugins/Image_5D.jar \
	plugins/M_I_P.jar \
	plugins/Interactive_3D_Surface_Plot.jar \
	plugins/View5D_.jar \
	plugins/Volume_Viewer.jar \
	plugins/IJ_Robot.jar \
	plugins/Fiji_Updater.jar \
	plugins/Daltonize_.jar \
	plugins/Stitching_.jar \
	plugins/LSM_Reader.jar \
	plugins/AnalyzeSkeleton_.jar \
	plugins/Skeletonize3D_.jar \
	plugins/TurboReg_.jar \
	plugins/Feature_Detection.jar \
	plugins/Bug_Submitter.jar \
	plugins/Fiji_Plugins.jar \
	plugins/ToAST_.jar \
	plugins/MTrack2_.jar \
	plugins/Time_Stamper.jar \
        plugins/Series_Labeler.jar \
	plugins/Statistical_Region_Merging.jar \
	plugins/Refresh_Javas.jar \
	plugins/Auto_Threshold.jar \
	plugins/Arrow_.jar \
	plugins/Stack_Manipulation.jar \
	plugins/FlowJ_.jar \
	plugins/PIV_analyser.jar \
	plugins/Record_Screen.jar \
	plugins/Video_Editing.jar \
	plugins/Sync_Win.jar \
	plugins/Gray_Morphology.jar \
	plugins/Colocalisation_Analysis.jar \
	plugins/LocalThickness_.jar \
	plugins/Fiji_Developer.jar \
	plugins/Script_Editor.jar \
	plugins/Manual_Tracking.jar \
	plugins/Calculator_Plus.jar \
	plugins/3D_Objects_Counter.jar \
	plugins/Trainable_Segmentation.jar \
	plugins/IsoData_Classifier.jar \
	plugins/RATS_.jar \
	plugins/Directionality_.jar \
	jars/Fiji.jar \
	plugins/Image_Expression_Parser.jar \
	plugins/Algorithm_Launcher.jar \
	plugins/VIB_.jar \
	plugins/Anisotropic_Diffusion_2D.jar \
	plugins/Simple_Neurite_Tracer.jar \
	plugins/SPIM_Registration.jar \
	plugins/QuickPALM_.jar \
	plugins/TrackMate_.jar \
	plugins/3D_Viewer.jar \
	plugins/CPU_Meter.jar \
	plugins/Graph_Cut.jar \
	plugins/TopoJ_.jar \
	plugins/Differentials_.jar \
	plugins/MosaicJ_.jar \
	plugins/PointPicker_.jar \
	plugins/SheppLogan_.jar \
	plugins/StackReg_.jar \
	plugins/UnwarpJ_.jar \
	plugins/Snakuscule_.jar \
	jars/imagescience.jar \
	plugins/TransformJ_.jar \
	plugins/FeatureJ_.jar \
	plugins/RandomJ_.jar \
	plugins/Linear_Kuwahara.jar \
	plugins/Thread_Killer.jar \
	plugins/Samples_.jar \
	plugins/Lasso_and_Blow_Tool.jar \
	jars/mij.jar \
	jars/wavelets.jar \
	jars/imageware.jar \
	plugins/Extended_Depth_Field.jar \
	plugins/panorama_.jar \
	jars/weave_jy2java.jar \
	plugins/3D_Blob_Segmentation.jar \
	plugins/Kuwahara_Filter.jar \
	plugins/Action_Bar.jar \
	plugins/Multi_Kymograph.jar \
	plugins/Reconstruct_Reader.jar

all <- fiji $SUBMODULE_TARGETS $PLUGIN_TARGETS

# The "run" rule just executes ./fiji (as long as the file "run" does not exist...)
# It has items on the right side, because these would be passed to the executable.

run[] <- all run-fiji
run-fiji[./fiji] <-
DEBUG_ARGS=-agentlib:jdwp=transport=dt_socket,address=8000,server=y,suspend=n
dev[./fiji $DEBUG_ARGS] <-


# JDK

JDK=java/$PLATFORM
JDK(linux64)=java/linux-amd64
JDK(macosx)=java/macosx-java3d

# Call the Jython script to ensure that the JDK is checked out (from Git)
jdk[bin/checkout-jdk.py $JDK] <-

# Prebuilt (needed to unconfuse Fiji Build and analyze-dependencies)
jars/edu_mines_jtk.jar[] <-
jars/jcommon-1.0.12.jar[] <-
jars/jfreechart-1.0.13.jar[] <-
jars/jna.jar[] <-
jars/postgresql-8.2-506.jdbc3.jar[] <-
jars/jai_core.jar[] <-
jars/jai_codec.jar[] <-
jars/batik.jar[] <-

# From submodules
jars/ij.jar <- jars/javac.jar modules/ImageJA/
CLASSPATH(misc/headless.jar)=jars/ij.jar
misc/headless.jar <- jars/javac.jar modules/ImageJA/
CLASSPATH(plugins/mpicbg_.jar)=jars/ij.jar:jars/mpicbg.jar
plugins/mpicbg_.jar <- modules/mpicbg/
CLASSPATH(jars/mpicbg.jar)=jars/ij.jar:jars/Jama-1.0.2.jar
jars/mpicbg.jar <- modules/mpicbg/
CLASSPATH(jars/imglib.jar)=jars/mpicbg.jar
jars/imglib.jar <- modules/imglib/
CLASSPATH(jars/imglib-ij.jar)=jars/ij.jar:jars/imglib.jar:jars/mpicbg.jar
jars/imglib-ij.jar <- modules/imglib/
CLASSPATH(jars/imglib-io.jar)=plugins/loci_tools.jar:jars/imglib.jar:jars/imglib-ij.jar:jars/ij.jar
jars/imglib-io.jar <- modules/imglib/
CLASSPATH(jars/imglib-algorithms.jar)=jars/Jama-1.0.2.jar:jars/imglib.jar:jars/edu_mines_jtk.jar:jars/mpicbg.jar
jars/imglib-algorithms.jar <- modules/imglib/
CLASSPATH(jars/imglib-scripting.jar)=jars/ij.jar:jars/imglib.jar:jars/imglib-io.jars:jars/imglib-algorithms.jar:jars/imglib-ij.jar:plugins/loci_tools.jar:jars/mpicbg.jar:jars/jfreechart-1.0.13.jar:jars/jcommon-1.0.12.jar:$JAVA3D_JARS
jars/imglib-scripting.jar <- modules/imglib/
CLASSPATH(jars/imglib-ops.jar)=jars/imglib.jar
jars/imglib-ops.jar <- modules/imglib/
#CLASSPATH(jars/imglib2.jar)=jars/mpicbg.jar
jars/imglib2.jar <- modules/imglib/
#CLASSPATH(jars/imglib2-ij.jar)=jars/ij.jar:jars/imglib2.jar:jars/mpicbg.jar
CLASSPATH(jars/imglib2-ij.jar)=jars/ij.jar:jars/imglib2.jar:jars/mpicbg.jar
jars/imglib2-ij.jar <- modules/imglib/
CLASSPATH(jars/imglib2-io.jar)=plugins/loci_tools.jar:jars/imglib2.jar
jars/imglib2-io.jar <- modules/imglib/
CLASSPATH(jars/imglib2-algorithms.jar)=jars/Jama-1.0.2.jar:jars/imglib2.jar:jars/edu_mines_jtk.jar
jars/imglib2-algorithms.jar <- modules/imglib/
CLASSPATH(jars/imglib2-scripting.jar)=jars/ij.jar:jars/imglib2.jar:jars/imglib2-io.jars:jars/imglib2-algorithms.jar:jars/imglib2-ij.jar:plugins/loci_tools.jar:jars/mpicbg.jar:jars/jfreechart-1.0.13.jar:jars/jcommon-1.0.12.jar:$JAVA3D_JARS
jars/imglib2-scripting.jar <- modules/imglib/
CLASSPATH(jars/imglib2-ops.jar)=jars/imglib2.jar
jars/imglib2-ops.jar <- modules/imglib/
CLASSPATH(jars/imglib2-ui.jar)=jars/imglib2.jar:jars/imglib2-io.jar:plugins/loci_tools.jar
jars/imglib2-ui.jar <- jars/imglib2-io.jar modules/imglib/
jars/clojure.jar <- fiji modules/clojure/
plugins/loci_tools.jar <- fiji modules/bio-formats/
CLASSPATH(jars/VectorString.jar)=jars/ij.jar:jars/Jama-1.0.2.jar:$JAVA3D_JARS
jars/VectorString.jar <- modules/TrakEM2/
CLASSPATH(plugins/TrakEM2_.jar)=jars/ij.jar:jars/jai_core.jar:jars/jai_codec.jar:jars/VectorString.jar:jars/postgresql-8.2-506.jdbc3.jar:jars/jcommon-1.0.12.jar:jars/jfreechart-1.0.13.jar:jars/edu_mines_jtk.jar:jars/VIB-lib.jar:plugins/VIB_.jar:jars/mpicbg.jar:plugins/loci_tools.jar:plugins/bUnwarpJ_.jar:plugins/level_sets.jar:plugins/Fiji_Plugins.jar:jars/Jama-1.0.2.jar:jars/imglib.jar:jars/imglib-algorithms.jar:jars/imglib-ij.jar:plugins/Simple_Neurite_Tracer.jar:plugins/3D_Viewer.jar:plugins/Lasso_and_Blow_Tool.jar:$JAVA3D_JARS
plugins/TrakEM2_.jar <- modules/TrakEM2/
plugins/ij-ImageIO_.jar <- modules/ij-plugins/
jars/jacl.jar <- fiji modules/tcljava/
jars/batik.jar <- fiji modules/batik/
jars/junit-4.5.jar <- fiji modules/junit/
jars/rsyntaxtextarea.jar <- fiji modules/RSyntaxTextArea/
jars/autocomplete.jar <- fiji modules/AutoComplete/
jars/weka.jar <- fiji jars/Fiji.jar modules/weka/
jars/jython.jar <- fiji modules/jython/
jars/commons-math.jar <- fiji modules/commons-math/
jars/javassist.jar <- modules/javassist/
jars/jsch-0.1.44.jar <- modules/jsch/
jars/ij-core-plugins.jar <- modules/imagej2/
jars/ij-core-tools.jar <- modules/imagej2/
jars/ij-core.jar <- modules/imagej2/
jars/ij-data.jar <- modules/imagej2/
jars/ij-display.jar <- modules/imagej2/
jars/ij-event.jar <- modules/imagej2/
jars/ij-legacy.jar <- modules/imagej2/
jars/ij-module.jar <- modules/imagej2/
jars/ij-object.jar <- modules/imagej2/
jars/ij-platform.jar <- modules/imagej2/
jars/ij-plugin.jar <- modules/imagej2/
jars/ij-tool.jar <- modules/imagej2/
jars/ij-ui.jar <- modules/imagej2/
jars/ij-imagej.jar <- modules/imagej2/
jars/ij-platform-macosx.jar <- modules/imagej2/
jars/ij-plugin-swing.jar <- modules/imagej2/
jars/ij-ui-common-awt.jar <- modules/imagej2/
jars/ij-ui-swing.jar <- modules/imagej2/
jars/ij-util-awt.jar <- modules/imagej2/

# From source
libs[] <- jars/test-fiji.jar jars/zs.jar jars/VIB-lib.jar jars/Jama-1.0.2.jar \
	jars/fiji-scripting.jar jars/fiji-lib.jar jars/jep.jar \
	jars/pal-optimization.jar jars/Updater_Fix.jar plugins/JNI_Example.jar \
	plugins/FFMPEG_IO.jar \

plugins/Record_Screen.jar <- src-plugins/Record_Screen/ src-plugins/Record_Screen/**/*

plugins/Trainable_Segmentation.jar <- src-plugins/Trainable_Segmentation/**/*java src-plugins/Trainable_Segmentation/trainableSegmentation/images/*png src-plugins/Trainable_Segmentation/*

mainClass(jars/Fiji.jar)=fiji.Main
src-plugins/Fiji/icon.png[cp $PRE $TARGET] <- images/icon.png

MAINCLASS(jars/javac.jar)=com.sun.tools.javac.Main

CLASSPATH(jars/fiji-scripting.jar)=jars/ij.jar:jars/jython.jar:jars/Fiji.jar:jars/bsh-2.0b4.jar:jars/js.jar
CLASSPATH(plugins/Refresh_Javas.jar)=jars/ij.jar:jars/fiji-scripting.jar:jars/fake.jar:jars/Fiji.jar
CLASSPATH(plugins/Jython_Interpreter.jar)=jars/ij.jar:jars/fiji-scripting.jar:jars/jython.jar
CLASSPATH(plugins/Clojure_Interpreter.jar)=jars/ij.jar:jars/fiji-scripting.jar:jars/clojure.jar
CLASSPATH(plugins/JRuby_Interpreter.jar)=jars/ij.jar:jars/fiji-scripting.jar:jars/jruby.jar
CLASSPATH(plugins/BeanShell_Interpreter.jar)=jars/ij.jar:jars/fiji-scripting.jar:jars/bsh-2.0b4.jar
CLASSPATH(plugins/Javascript_.jar)=jars/ij.jar:jars/fiji-scripting.jar:jars/js.jar
CLASSPATH(plugins/CLI_.jar)=jars/ij.jar:jars/fiji-scripting.jar
MAINCLASS(plugins/Script_Editor.jar)=fiji.scripting.Script_Editor
CLASSPATH(plugins/Script_Editor.jar)=jars/ij.jar:jars/rsyntaxtextarea.jar:jars/autocomplete.jar:plugins/Clojure_Interpreter.jar:plugins/JRuby_Interpreter.jar:plugins/Javascript_.jar:plugins/Jython_Interpreter.jar:plugins/Refresh_Javas.jar:plugins/BeanShell_Interpreter.jar:plugins/CLI_.jar:jars/fiji-scripting.jar:jars/Fiji.jar:jars/imglib.jar:jars/fiji-lib.jar:jars/fake.jar:$TOOLS_JAR:jars/jfreechart-1.0.13.jar:jars/imglib-ij.jar
NO_COMPILE(plugins/Script_Editor.jar)=src-plugins/Script_Editor/templates/**/*
src-plugins/Script_Editor/icon.png[cp $PRE $TARGET] <- images/icon.png
src-plugins/Script_Editor/var.png[cp $PRE $TARGET] <- images/var.png
src-plugins/Script_Editor/function.png[cp $PRE $TARGET] <- images/function.png

CLASSPATH(jars/zs.jar)=jars/Jama-1.0.2.jar
CLASSPATH(plugins/register_virtual_stack_slices.jar)=jars/ij.jar:plugins/TrakEM2_.jar:jars/mpicbg.jar:plugins/bUnwarpJ_.jar:jars/fiji-lib.jar
CLASSPATH(plugins/registration_3d.jar)=jars/ij.jar:jars/edu_mines_jtk.jar
CLASSPATH(plugins/Siox_Segmentation.jar)=jars/ij.jar:jars/fiji-lib.jar
CLASSPATH(plugins/Image_Expression_Parser.jar)=jars/ij.jar:jars/jep.jar:jars/imglib.jar:jars/junit-4.5.jar:jars/imglib-algorithms.jar:jars/imglib-ij.jar

CLASSPATH(plugins/Algorithm_Launcher.jar)=jars/ij.jar:jars/imglib.jar:jars/imglib-ij.jar
plugins/Algorithm_Launcher.jar <- \
	src-plugins/Algorithm_Launcher/**/*.java \
	src-plugins/Algorithm_Launcher/**/*.config

CLASSPATH(plugins/Directionality_.jar)=jars/ij.jar:jars/jfreechart-1.0.13.jar:jars/jcommon-1.0.12.jar
CLASSPATH(plugins/LSM_Toolbox.jar)=jars/ij.jar:plugins/LSM_Reader.jar
MAINCLASS(plugins/LSM_Toolbox.jar)=org.imagearchive.lsm.toolbox.gui.AboutDialog
MAINCLASS(plugins/Interactive_3D_Surface_Plot.jar)=Interactive_3D_Surface_Plot
CLASSPATH(plugins/Stitching_.jar)=jars/ij.jar:plugins/loci_tools.jar:jars/fiji-lib.jar:jars/imglib.jar:jars/edu_mines_jtk.jar
CLASSPATH(plugins/Fiji_Plugins.jar)=jars/ij.jar:jars/jsch-0.1.44.jar:jars/fiji-lib.jar:jars/VIB-lib.jar
MAINCLASS(plugins/Fiji_Updater.jar)=fiji.updater.Main
CLASSPATH(plugins/TrackMate_.jar)=jars/batik.jar:jars/ij.jar:plugins/3D_Viewer.jar:plugins/loci_tools.jar:jars/fiji-lib.jar:jars/imglib.jar:jars/imglib-ij.jar:jars/imglib-io.jar:jars/imglib-algorithms.jar:jars/jdom.jar:jars/jdom-contrib.jar:jars/jgraphx.jar:jars/jgrapht-jdk1.6.jar:jars/jfreechart-1.0.13.jar:jars/jcommon-1.0.12.jar:jars/Jama-1.0.2.jar
CLASSPATH(plugins/Fiji_Updater.jar)=jars/ij.jar:jars/jsch-0.1.44.jar
CLASSPATH(plugins/IO_.jar)=jars/ij.jar:jars/batik.jar:jars/jpedalSTD.jar:jars/itext-1.3.jar:jars/jzlib-1.0.7.jar
CLASSPATH(plugins/Sync_Win.jar)=jars/ij.jar:plugins/Image_5D.jar
CLASSPATH(plugins/Fiji_Developer.jar)=jars/ij.jar:plugins/Script_Editor.jar:plugins/Fiji_Plugins.jar:jars/rsyntaxtextarea.jar:plugins/3D_Viewer.jar:$JAVA3D_JARS
CLASSPATH(plugins/Trainable_Segmentation.jar)=jars/ij.jar:jars/weka.jar:plugins/Stitching_.jar:jars/fiji-lib.jar:plugins/Anisotropic_Diffusion_2D.jar:jars/Jama-1.0.2.jar:jars/VIB-lib.jar:jars/commons-math.jar:jars/imglib.jar:jars/imglib-ij.jar:jars/imglib-algorithms.jar:$JAVA3D_JARS
CLASSPATH(plugins/VIB_.jar)=jars/ij.jar:$JAVA3D_JARS:jars/VIB-lib.jar:jars/pal-optimization.jar:plugins/3D_Viewer.jar:jars/imglib.jar:jars/fiji-lib.jar
CLASSPATH(jars/VIB-lib.jar)=jars/ij.jar:jars/Jama-1.0.2.jar:jars/junit-4.5.jar:jars/pal-optimization.jar:jars/jzlib-1.0.7.jar:jars/fiji-lib.jar
CLASSPATH(plugins/Simple_Neurite_Tracer.jar)=jars/ij.jar:$JAVA3D_JARS:jars/VIB-lib.jar:plugins/VIB_.jar:jars/pal-optimization.jar:jars/junit-4.5.jar:plugins/3D_Viewer.jar:jars/commons-math.jar:jars/jfreechart-1.0.13.jar:jars/jcommon-1.0.12.jar:jars/batik.jar:plugins/AnalyzeSkeleton_.jar:plugins/Skeletonize3D_.jar
CLASSPATH(plugins/3D_Viewer.jar)=jars/ij.jar:jars/VIB-lib.jar:jars/imglib.jar:jars/Jama-1.0.2.jar:$JAVA3D_JARS
CLASSPATH(jars/jep.jar)=jars/ij.jar:jars/Jama-1.0.2.jar:jars/junit-4.5.jar
CLASSPATH(plugins/SPIM_Registration.jar)=jars/ij.jar:$JAVA3D_JARS:jars/imglib.jar:jars/mpicbg.jar:plugins/3D_Viewer.jar:jars/weka.jar:jars/fiji-lib.jar:plugins/loci_tools.jar:plugins/Fiji_Plugins.jar:jars/VIB-lib.jar:jars/Jama-1.0.2.jar:jars/imglib-algorithms.jar:jars/imglib-ij.jar:jars/imglib-io.jar:jars/jfreechart-1.0.13.jar:jars/jcommon-1.0.12.jar
CLASSPATH(plugins/Bug_Submitter.jar)=jars/ij.jar:plugins/Fiji_Updater.jar
CLASSPATH(plugins/TopoJ_.jar)=jars/ij.jar:jars/Jama-1.0.2.jar
CLASSPATH(jars/imagescience.jar)=jars/ij.jar:plugins/Image_5D.jar
CLASSPATH(plugins/Arrow_.jar)=jars/ij.jar:jars/fiji-lib.jar
CLASSPATH(plugins/TransformJ_.jar)=jars/ij.jar:jars/imagescience.jar
CLASSPATH(plugins/FeatureJ_.jar)=jars/ij.jar:jars/imagescience.jar
CLASSPATH(plugins/RandomJ_.jar)=jars/ij.jar:jars/imagescience.jar
CLASSPATH(plugins/Auto_Threshold.jar)=jars/ij.jar
CLASSPATH(plugins/Colocalisation_Analysis.jar)=jars/ij.jar:jars/imglib.jar:jars/imglib-ij.jar:jars/imglib-algorithms.jar:jars/junit-4.5.jar:jars/itext-1.3.jar
CLASSPATH(plugins/Series_Labeler.jar)=jars/ij.jar
CLASSPATH(plugins/Gray_Morphology.jar)=jars/ij.jar
CLASSPATH(plugins/IsoData_Classifier.jar)=jars/ij.jar
CLASSPATH(plugins/ToAST_.jar)=jars/ij.jar
CLASSPATH(misc/headless.jar)=jars/ij.jar
CLASSPATH(plugins/AnalyzeSkeleton_.jar)=jars/ij.jar
CLASSPATH(plugins/CPU_Meter.jar)=jars/jna.jar:jars/ij.jar
CLASSPATH(plugins/M_I_P.jar)=jars/ij.jar
CLASSPATH(plugins/level_sets.jar)=jars/ij.jar
CLASSPATH(plugins/Anisotropic_Diffusion_2D.jar)=jars/ij.jar
CLASSPATH(plugins/SplineDeformationGenerator_.jar)=jars/ij.jar
CLASSPATH(plugins/Manual_Tracking.jar)=jars/ij.jar
CLASSPATH(plugins/Daltonize_.jar)=jars/ij.jar
CLASSPATH(plugins/IJ_Robot.jar)=jars/ij.jar
CLASSPATH(jars/autocomplete.jar)=jars/rsyntaxtextarea.jar
CLASSPATH(jars/jython.jar)=jars/junit-4.5.jar:jars/jna.jar
CLASSPATH(plugins/Video_Editing.jar)=jars/ij.jar
CLASSPATH(plugins/Statistical_Region_Merging.jar)=jars/ij.jar
CLASSPATH(plugins/PIV_analyser.jar)=jars/ij.jar
CLASSPATH(plugins/Skeletonize3D_.jar)=jars/ij.jar
CLASSPATH(plugins/Color_Inspector_3D.jar)=jars/ij.jar
CLASSPATH(plugins/MTrack2_.jar)=jars/ij.jar
CLASSPATH(plugins/Color_Histogram.jar)=jars/ij.jar
CLASSPATH(plugins/LSM_Reader.jar)=jars/ij.jar
CLASSPATH(plugins/loci_tools.jar)=jars/ij.jar
CLASSPATH(plugins/LocalThickness_.jar)=jars/ij.jar
CLASSPATH(plugins/Volume_Viewer.jar)=jars/ij.jar
CLASSPATH(plugins/Image_5D.jar)=jars/ij.jar
CLASSPATH(jars/batik.jar)=jars/jacl.jar:plugins/loci_tools.jar:jars/jython.jar
CLASSPATH(plugins/Stack_Manipulation.jar)=jars/ij.jar
CLASSPATH(jars/Fiji.jar)=jars/ij.jar
CLASSPATH(plugins/TurboReg_.jar)=jars/ij.jar
CLASSPATH(plugins/RATS_.jar)=jars/ij.jar
CLASSPATH(plugins/Interactive_3D_Surface_Plot.jar)=jars/ij.jar
CLASSPATH(jars/fiji-lib.jar)=jars/ij.jar
CLASSPATH(jars/ij.jar)=jars/javac.jar
CLASSPATH(plugins/Analyze_Reader_Writer.jar)=jars/ij.jar
CLASSPATH(plugins/Calculator_Plus.jar)=jars/ij.jar
CLASSPATH(plugins/bUnwarpJ_.jar)=jars/ij.jar
CLASSPATH(plugins/QuickPALM_.jar)=jars/ij.jar
CLASSPATH(plugins/ij-ImageIO_.jar)=jars/ij.jar:jars/jai_core.jar:jars/jai_codec.jar
CLASSPATH(plugins/FlowJ_.jar)=jars/ij.jar
CLASSPATH(plugins/View5D_.jar)=jars/ij.jar
CLASSPATH(plugins/Time_Stamper.jar)=jars/ij.jar
CLASSPATH(plugins/3D_Objects_Counter.jar)=jars/ij.jar
CLASSPATH(plugins/Snakuscule_.jar)=jars/ij.jar
CLASSPATH(plugins/UnwarpJ_.jar)=jars/ij.jar
CLASSPATH(plugins/Graph_Cut.jar)=jars/ij.jar:jars/imglib.jar:jars/imglib-ij.jar:jars/fiji-lib.jar
CLASSPATH(jars/mij.jar)=jars/ij.jar
CLASSPATH(plugins/Differentials_.jar)=jars/ij.jar
CLASSPATH(plugins/StackReg_.jar)=jars/ij.jar
CLASSPATH(plugins/PointPicker_.jar)=jars/ij.jar
CLASSPATH(plugins/Lasso_and_Blow_Tool.jar)=jars/ij.jar:jars/fiji-lib.jar
CLASSPATH(plugins/Linear_Kuwahara.jar)=jars/ij.jar
CLASSPATH(plugins/Thread_Killer.jar)=jars/ij.jar
CLASSPATH(plugins/MosaicJ_.jar)=jars/ij.jar
CLASSPATH(plugins/SheppLogan_.jar)=jars/ij.jar
CLASSPATH(jars/wavelets.jar)=jars/ij.jar
CLASSPATH(jars/imageware.jar)=jars/ij.jar
CLASSPATH(plugins/Extended_Depth_Field.jar)=jars/ij.jar:jars/imageware.jar:jars/wavelets.jar
CLASSPATH(plugins/panorama_.jar)=jars/ij.jar:jars/mpicbg.jar:/jars/mpicbg_.jar
CLASSPATH(jars/weave_jy2java.jar)=plugins/Refresh_Javas.jar:jars/fiji-scripting.jar:jars/Fiji.jar:jars/ij.jar:plugins/Script_Editor.jar
CLASSPATH(plugins/3D_Blob_Segmentation.jar)=jars/ij.jar:plugins/level_sets.jar:plugins/3D_Viewer.jar:jars/VIB-lib.jar:jars/imglib.jar:$JAVA3D_JARS
CLASSPATH(plugins/Feature_Detection.jar)=jars/ij.jar:jars/imglib-ij.jar:jars/imglib.jar:jars/imglib-algorithms.jar:jars/Jama-1.0.2.jar
LIBS(plugins/JNI_Example.jar)=-lm
CLASSPATH(plugins/JNI_Example.jar)=jars/ij.jar:jars/fiji-lib.jar
CLASSPATH(plugins/Kuwahara_Filter.jar)=jars/ij.jar
CLASSPATH(plugins/Action_Bar.jar)=jars/ij.jar
CLASSPATH(plugins/Multi_Kymograph.jar)=jars/ij.jar
CLASSPATH(plugins/Reconstruct_Reader.jar)=jars/ij.jar:plugins/TrakEM2_.jar

# pre-Java5 generics ;-)

src-plugins/VIB-lib/vib/FloatMatrix.java[src-plugins/VIB-lib/sed.py $PRE $TARGET] <- src-plugins/VIB-lib/vib/FastMatrix.java
src-plugins/VIB-lib/math3d/FloatMatrixN.java[src-plugins/VIB-lib/sed.py $PRE $TARGET] <- src-plugins/VIB-lib/math3d/FastMatrixN.java
src-plugins/VIB-lib/math3d/JacobiFloat.java[src-plugins/VIB-lib/sed.py $PRE $TARGET] <- src-plugins/VIB-lib/math3d/JacobiDouble.java
src-plugins/VIB-lib/math3d/Eigensystem3x3Float.java[src-plugins/VIB-lib/sed.py $PRE $TARGET] <- \
	src-plugins/VIB-lib/math3d/Eigensystem3x3Double.java
src-plugins/VIB-lib/math3d/Eigensystem2x2Float.java[src-plugins/VIB-lib/sed.py $PRE $TARGET] <- \
	src-plugins/VIB-lib/math3d/Eigensystem2x2Double.java

MAINCLASS(jars/test-fiji.jar)=fiji.Tests
CLASSPATH(jars/test-fiji.jar)=jars/junit-4.5.jar

MAINCLASS(jars/Updater_Fix.jar)=fiji.updater.Fix

# This also compiles lib/<platform>/<ffmpeg-library>
CLASSPATH(plugins/FFMPEG_IO.jar)=jars/ij.jar
plugins/FFMPEG_IO.jar[src-plugins/FFMPEG_IO/generate.bsh] <- src-plugins/FFMPEG_IO/**/*

# This compiles and cross-compiles lib/<platform>/<ffmpeg-library>
CLASSPATH(plugins/FFMPEG_IO.jar-cross)=jars/ij.jar
plugins/FFMPEG_IO.jar-cross[src-plugins/FFMPEG_IO/generate.bsh all] <- src-plugins/FFMPEG_IO/**/*

# the default rules

plugins/*.jar <- src-plugins/*/**/*
jars/*.jar <- src-plugins/*/**/*

# Fiji launcher

JAVA_LIB_PATH(linux)=lib/i386/client/libjvm.so
JAVA_LIB_PATH(linux64)=lib/amd64/server/libjvm.so
JAVA_LIB_PATH(win32)=bin/client/jvm.dll
JAVA_LIB_PATH(win64)=bin/server/jvm.dll
JAVA_LIB_PATH(macosx)=

# The variables CFLAGS, LDFLAGS and LIBS will be used for compiling
# C and C++ programs.
COMMONCFLAGS=-Wall -Iincludes
WINOPTS=-mwindows -mno-cygwin -DMINGW32
CFLAGS(win32)=$COMMONCFLAGS $WINOPTS \
	-DJAVA_HOME='"$FIJI_JAVA_HOME_UNEXPANDED(win32)"' -DJAVA_LIB_PATH='"$JAVA_LIB_PATH(win32)"'
CFLAGS(win64)=$COMMONCFLAGS $WINOPTS \
	-DJAVA_HOME='"$FIJI_JAVA_HOME_UNEXPANDED(win64)"' -DJAVA_LIB_PATH='"$JAVA_LIB_PATH(win64)"'

# Include 64-bit architectures only in ./fiji (as opposed to ./fiji-tiger),
# and only on MacOSX
MACOPTS(osx10.3)=-I/System/Library/Frameworks/JavaVM.Framework/Headers -Iincludes \
	-DMACOSX \
	-DJAVA_HOME='"$FIJI_JAVA_HOME_UNEXPANDED(macosx)"' -DJAVA_LIB_PATH='"$JAVA_LIB_PATH(macosx)"'
MACOPTS(osx10.4)=$MACOPTS(osx10.3) -mmacosx-version-min=10.3 -arch i386 -arch ppc
MACOPTS(osx10.5)=$MACOPTS(osx10.3) -mmacosx-version-min=10.4 -arch i386 -arch x86_64
CFLAGS(macosx)=$MACOPTS

CFLAGS(linux)=$COMMONCFLAGS -DIPV6_MAYBE_BROKEN -fno-stack-protector \
	-DJAVA_HOME='"$FIJI_JAVA_HOME_UNEXPANDED(linux)"' -DJAVA_LIB_PATH='"$JAVA_LIB_PATH(linux)"'
CFLAGS(linux64)=$COMMONCFLAGS -DIPV6_MAYBE_BROKEN -fno-stack-protector -rdynamic -g \
	-DJAVA_HOME='"$FIJI_JAVA_HOME_UNEXPANDED(linux64)"' -DJAVA_LIB_PATH='"$JAVA_LIB_PATH(linux64)"'

LDFLAGS(win32)=$LDFLAGS $WINOPTS

CFLAGS(fiji)=$COMMONCFLAGS $MACOPTS
LDFLAGS(fiji)=$LDFLAGS $MACOPTS

LIBS(linux)=-ldl -lpthread
LIBS(linux64)=-ldl -lpthread
LIBS(macosx)=-weak -framework CoreFoundation -framework ApplicationServices \
	-framework JavaVM

fiji <- fiji.c

CFLAGS(fiji-macosx)=$COMMONCFLAGS $MACOPTS(osx10.5)
LDFLAGS(fiji-macosx)=$LDFLAGS $MACOPTS(osx10.5)
fiji-macosx <- fiji.c

CFLAGS(fiji-tiger)=$COMMONCFLAGS $MACOPTS(osx10.4)
LDFLAGS(fiji-tiger)=$LDFLAGS $MACOPTS(osx10.4)
fiji-tiger <- fiji.c

CFLAGS(fiji-panther)=$COMMONCFLAGS $MACOPTS(osx10.3)
LDFLAGS(fiji-panther)=$LDFLAGS $MACOPTS(osx10.3)
fiji-panther <- fiji.c

# Cross-compiling (works only on Linux64 so far)

all-cross[] <- cross-win32 cross-win64 cross-linux cross-macosx cross-tiger
# cross-tiger does not work yet

cross-tiger[bin/cross-compiler.bsh tiger \
	$CFLAGS(fiji-panther) $LIBS(macosx)] <- fiji.c
cross-macosx[bin/cross-compiler.bsh macosx \
	$CFLAGS(fiji-panther) $LIBS(macosx)] <- fiji.c
cross-*[bin/cross-compiler.bsh * $CFLAGS(*) $LDFLAGS(*) $LIBS(*)] <- fiji.c

# Precompiled stuff

LAUNCHER(*)=precompiled/fiji-$PLATFORM
LAUNCHER(win32)=precompiled/fiji-win32.exe
LAUNCHER(win64)=precompiled/fiji-win64.exe
LAUNCHER(osx10.4)=precompiled/fiji-macosx
LAUNCHER(osx10.5)=precompiled/fiji-macosx precompiled/fiji-tiger
precompile-fiji[] <- $LAUNCHER

precompiled/fiji-tiger[bin/copy-file.py $PRE $TARGET] <- fiji-tiger
precompiled/fiji-macosx[bin/copy-file.py $PRE $TARGET] <- fiji-macosx
# this rule only matches precompiled/fiji-$PLATFORM
precompiled/fiji-*[bin/copy-file.py $PRE $TARGET] <- fiji

precompile-fake[] <- precompiled/fake.jar
precompiled/fake.jar <- jars/fake.jar
precompiled/javac.jar <- jars/javac.jar
precompiled/ij.jar <- jars/ij.jar
precompiled/mpicbg.jar <- jars/mpicbg.jar
precompiled/*[bin/copy-file.py $PRE $TARGET] <- *

precompile-submodules[] <- \
	precompiled/ij.jar \
	precompiled/loci_tools.jar \
	precompiled/TrakEM2_.jar \
	precompiled/mpicbg_.jar \
	precompiled/mpicbg.jar \
	precompiled/clojure.jar \
	precompiled/ij-ImageIO_.jar \
	precompiled/jacl.jar \
	precompiled/batik.jar \
	precompiled/junit-4.5.jar \
	precompiled/rsyntaxtextarea.jar \
	precompiled/autocomplete.jar \
	precompiled/weka.jar \
	precompiled/jython.jar \
	precompiled/imglib.jar \
	precompiled/commons-math.jar \
	precompiled/imglib-algorithms.jar \
	precompiled/javassist.jar \
	precompiled/jsch-0.1.44.jar \

precompiled/ij.jar <- jars/ij.jar
precompiled/clojure.jar <- jars/clojure.jar
precompiled/jacl.jar <- jars/jacl.jar
precompiled/batik.jar <- jars/batik.jar
precompiled/junit-4.5.jar <- jars/junit-4.5.jar
precompiled/rsyntaxtextarea.jar <- jars/rsyntaxtextarea.jar
precompiled/autocomplete.jar <- jars/autocomplete.jar
precompiled/weka.jar <- jars/weka.jar
precompiled/jython.jar <- jars/jython.jar
precompiled/imglib.jar <- jars/imglib.jar
precompiled/imglib-algorithms.jar <- jars/imglib-algorithms.jar
precompiled/imglib-ij.jar <- jars/imglib-ij.jar
precompiled/imglib-io.jar <- jars/imglib-io.jar
precompiled/imglib-scripting.jar <- jars/imglib-scripting.jar
precompiled/commons-math.jar <- jars/commons-math.jar
precompiled/javassist.jar <- jars/javassist.jar
precompiled/jsch-0.1.44.jar <- jars/jsch-0.1.44.jar
precompiled/* <- plugins/*

precompile[] <- precompile-fiji precompile-fake precompile-submodules

# precompiled fall back

missingPrecompiledFallBack[./fiji --update update $TARGET] <- \
	jars/Fiji.jar plugins/Fiji_Updater.jar

# Portable application/.app

all-apps[] <- app-macosx app-linux app-linux64 app-win32 app-win64
MACOSX_TIGER_LAUNCHER(macosx)=fiji-tiger
app-*[bin/make-app.py * $PLATFORM] <- all $MACOSX_TIGER_LAUNCHER

app-all[bin/make-app.py all $PLATFORM] <- all
app-nojre[bin/make-app.py nojre $PLATFORM] <- all

all-dmgs[] <- fiji-macosx.dmg
fiji-*.dmg[bin/make-dmg.py] <- app-* Fiji.app \
	resources/install-fiji.jpg
dmg[] <- fiji-macosx.dmg

resources/install-fiji.jpg[./fiji bin/generate-finder-background.py] <- \
	bin/generate-finder-background.py

all-tars[] <- fiji-linux.tar.bz2 fiji-linux64.tar.bz2 \
	fiji-all.tar.bz2 fiji-nojre.tar.bz2
fiji-*.tar.bz2[bin/make-tar.py $TARGET Fiji.app] <- app-* Fiji.app
tar[] <- fiji-$PLATFORM.tar.bz2

all-zips[] <- fiji-linux.zip fiji-linux64.zip fiji-win32.zip fiji-win64.zip \
	fiji-all.zip fiji-nojre.zip
fiji-*.zip[bin/make-zip.py $TARGET Fiji.app] <- app-* Fiji.app
zip[] <- fiji-$PLATFORM.zip

all-isos[] <- fiji-linux.iso fiji-linux64.iso fiji-win32.iso fiji-win64.iso \
	fiji-macosx.iso fiji-all.iso fiji-nojre.iso
fiji-*.iso[genisoimage -J -V Fiji -o $TARGET Fiji.app] <- app-*

all-7zs[] <- fiji-linux.7z fiji-linux64.7z fiji-win32.7z fiji-win64.7z \
	fiji-macosx.7z fiji-all.7z fiji-nojre.7z
fiji-*.7z[bin/make-7z.py $TARGET Fiji.app] <- app-*

# Checks

check[] <- check-launchers check-submodules

LAUNCHERS=$LAUNCHER(linux) $LAUNCHER(linux64) \
	$LAUNCHER(win32) $LAUNCHER(win64) $LAUNCHER(macosx)
check-launchers[bin/up-to-date-check.py fiji.c $LAUNCHERS] <-

check-submodules[] <- check-ij check-TrakEM2 check-mpicbg

check-ij[bin/up-to-date-check.py ImageJA precompiled/ij.jar] <-
check-*[bin/up-to-date-check.py * precompiled/*_.jar] <-

# Fake itself

MAINCLASS(jars/fake.jar)=fiji.build.Fake
jars/fake.jar <- src-plugins/fake/**/*.java
