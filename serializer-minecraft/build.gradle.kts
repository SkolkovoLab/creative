plugins {
    id("creative.publishing-conventions")
}

description = "Minecraft: Java Edition vanilla serialization for the creative API"

dependencies {
    api(project(":creative-api"))
    implementation("net.kyori:adventure-text-serializer-legacy:4.24.0")
    implementation("net.kyori:adventure-text-serializer-gson:4.24.0")
}