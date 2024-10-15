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

rootProject.name = "TestModularityApp"
include(":app")
include(":core_data")
include(":module-injector")
include(":core_database")

include(":core_network")

include(":search_feature_api")
include(":search_feature_impl")
include(":auth_feature_api")
include(":auth_feature_impl")
include(":core_utils")
include(":full_vacancy_feature_api")
include(":full_vacancy_feature_impl")
include(":favorite_feature_api")
include(":favorite_feature_impl")
include(":profile_feature_api")
include(":profile_feature_impl")
include(":responses_feature_api")
include(":responses_feature_impl")
include(":messages_feature_api")
include(":messages_feature_impl")
