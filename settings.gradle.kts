rootProject.name = "creative-parent"

includePrefixed("api")
includePrefixed("server")
includePrefixed("reader-minecraft")

fun includePrefixed(name: String) {
    include("creative-$name")
    project(":creative-$name").projectDir = file(name)
}