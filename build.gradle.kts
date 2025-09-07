plugins {
    kotlin("jvm") apply false
    id("org.jetbrains.dokka")
}

buildscript {
    dependencies {
        classpath("org.jetbrains.dokka:dokka-base:2.0.0")
    }
}

dependencies {
    dokka(project(":childProjectA"))
    dokka(project(":childProjectB"))
}

dokka {
    moduleName.set("Foobar")
    moduleVersion.set(project.version.toString())

    pluginsConfiguration.html {
        homepageLink = "https://foobar.ryantanner.tech"
        footerMessage = "&copy; 2025 Foobar, Inc."
    }

    dokkaPublications.html {
        failOnWarning.set(true)
        suppressObviousFunctions.set(true)
        suppressInheritedMembers.set(true)
        outputDirectory.set(layout.projectDirectory.dir("static/api"))
    }
}
