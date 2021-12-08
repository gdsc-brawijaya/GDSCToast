
[![](https://jitpack.io/v/KylixEza/GDSCToast.svg)](https://jitpack.io/#KylixEza/GDSCToast)

# GDSCToast
Custom Toast Library by Google Developer Student Club University of Brawijaya

## Prerequisites

- For gradle version below 7

  Add this in your root `build.gradle` file (project scope)

```gradle
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```
- For gradle version 7 or latest
  
  Add this in your root `setting.gradle` file 
```gradle
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

## Dependency

Add this to your module's `build.gradle` file :

```gradle
dependencies {
	...
	implementation 'com.github.KylixEza:GDSCToast:version'
}
```
you can check the version on jitpack badge above or on release tag
