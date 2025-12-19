plugins {
    id("creative.java-conventions")
    `maven-publish`
    signing
}


publishing {
    repositories {
        maven {
            name = "cherry"
            url = uri("https://repo.cherry.pizza/repository/creative/")
            credentials {
                username = findProperty("CHERRYPIZZA_REPO_USR")?.toString()
                password = findProperty("CHERRYPIZZA_REPO_PSW")?.toString()
            }
        }
    }
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
            pom {
                name.set("${project.group}:${project.name}")
                description.set(project.description)
                url.set("https://github.com/unnamed/creative")
                packaging = "jar"
                licenses {
                    license {
                        name.set("MIT License")
                        url.set("https://opensource.org/license/mit/")
                    }
                }
                developers {
                    developer {
                        id.set("yusshu")
                        name.set("Andre Roldan")
                        email.set("yusshu@unnamed.team")
                    }
                }
                scm {
                    connection.set("scm:git:git://github.com/unnamed/creative.git")
                    developerConnection.set("scm:git:ssh://github.com:unnamed/creative.git")
                    url.set("https://github.com/unnamed/creative")
                }
            }
        }
    }
}

//signing {
//    sign(publishing.publications["maven"])
//}