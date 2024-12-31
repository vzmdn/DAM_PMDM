pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "My Application"
include(":spinnerapp")
include(":app")
include(":addapp")
include(":calculadora")
include(":futboldemo")
include(":helloapp")
include(":implicitintent")
include(":mysensors")
include(":permissiondemo")
include(":recyclerviewdemo")
include(":spinnerdemo")
include(":statechange")
include(":sumarapp")
include(":weekdaysapp")
include(":repasoexamen")
include(":pokemonspinner")
include(":pmdm")
include(":examen1av")
include(":viewmodel1")
include(":coroutinedemo")

