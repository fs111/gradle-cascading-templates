# gradle-cascading-templates

*WARNING* This is work in progress and can change any time!



## Installation

First install the the jar itself like this:


    git clone https://github.com/fs111/gradle-cascading-templates
    cd gradle-cascading-templates
    gradle install


Copy the gradle init script template into your .gradle directory and change the
path to point to this directory.

    cp installation/init.gradle.example $HOME/.gradle/init.gradle
    sed -i "s@CHECKOUTPATH@$PWD@" $HOME/.gradle/init.gradle


## Usage

Now that the plugin is usable, you can create new cascading projects easily like
this:

    cd ~/code
    gradle createCascadingProject
    > Building > :createCascadingProject
    ??> Project Name: just-for-fun
    ??> Group: [just-for-fun] pe.kel.fun
    ??> Version: [1.0] 

Now you should have a directory called `just-for-fun`, that contains a cascading
ready application. You can assemble a hadoop ready jar and run it:

    cd just-for-fun
    gradle jar
    hadoop jar build/libs/just-for-fun-1.0.jar
    > 13/07/23 17:51:58 INFO fun.Main: hello cascading
