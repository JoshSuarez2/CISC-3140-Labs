function compile() {
    javac Lab2Java.java
}

function run() {
    java Lab2Java < $1
}

function compile_and_run() {
    echo -n "File: "
    read -r file
    compile
    run $file
}