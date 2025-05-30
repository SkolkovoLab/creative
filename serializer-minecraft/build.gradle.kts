plugins {
    id("creative.publishing-conventions")
}

description = "Minecraft: Java Edition vanilla serialization for the creative API"

dependencies {
    api(project(":creative-api"))
    api("com.google.code.gson:gson:2.13.1")
    implementation("net.kyori:adventure-text-serializer-legacy:4.21.0")
    implementation("net.kyori:adventure-text-serializer-gson:4.21.0")
}