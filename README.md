[![platform](https://img.shields.io/badge/platform-Android-green.svg)](https://www.android.com)
[![License](https://img.shields.io/badge/license-MIT-EA4235.svg)](https://www.apache.org/licenses/LICENSE-2.0.html)
[![jitpack](https://jitpack.io/v/KylixEza/GDSCToast.svg)](https://jitpack.io/#KylixEza/GDSCToast)

<div align="center">
<img width="35%" height = "35%" src="https://user-images.githubusercontent.com/58837451/145612684-b9a271e7-1b93-4f88-8904-d5c443991cda.png" />
</div>

# GDSCToast
Custom Toast Library by Google Developer Student Club University of Brawijaya

## Prerequisites

- For old version of gradle (before arctic fox update)

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

## Usage

Each function start with 'make...' like ```makeNomralToast``` always returns a `Toast` object, so you can customize your own Toast. But if you just want to show the toast without any customization, you can use function that start with 'show...' like `showNormalToast`

- To display a normal Toast:

```kotlin
GDSCToast.makeNormalToast(this@MainActivity, "This is a normal toast", Toast.LENGTH_LONG, true).show()
GDSCToast.showNormalToast(this@MainActivity, "This is a normal toast", Toast.LENGTH_LONG, true)
```

- To display a success Toast:

``` kotlin
GDSCToast.makeSuccessToast(this@MainActivity, "This is a success toast", Toast.LENGTH_LONG, true).show()
GDSCToast.showSuccessToast(this@MainActivity, "This is a success toast", Toast.LENGTH_LONG, true)
```
- To display an error Toast:

``` kotlin 
GDSCToast.makeErrorToast(this@MainActivity, "This is an error toast", Toast.LENGTH_LONG, true).show()
GDSCToast.showErrorToast(this@MainActivity, "This is an error toast", Toast.LENGTH_LONG, true)
```

- To display an warning Toast:

``` kotlin
GDSCToast.makeWarningToast(this@MainActivity, "This is a warning toast", Toast.LENGTH_LONG, true).show()
GDSCToast.showWarningToast(this@MainActivity, "This is a warning toast", Toast.LENGTH_LONG, true)
```
- To display an info Toast:

``` kotlin
GDSCToast.makeInfoToast(this@MainActivity, "This is an info toast", Toast.LENGTH_LONG, true).show()
GDSCToast.showInfoToast(this@MainActivity, "This is an info toast", Toast.LENGTH_LONG, true)
```
## Preview

<div align="center">
<img width="100%" height = "100%" src="https://user-images.githubusercontent.com/58837451/145605982-a3a86a62-b720-4b5e-911f-54c311e3f9f6.png" />
</div>


## Contributing

Please fork this repository and contribute back using
[pull requests](https://github.com/Shashank02051997/FancyToast-Android/pulls).

Any contributions, large or small, major features, bug fixes, are welcomed and appreciated
but will be thoroughly reviewed .

## Contact
<a href="https://linkedin.com/in/kylix-eza-saputra-1bb1b7192" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/linked-in-alt.svg" alt="kylix-eza-saputra-1bb1b7192" height="30" width="40" /></a>
<a href="https://instagram.com/k_ylix" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/instagram.svg" alt="k_ylix" height="30" width="40" /></a>
<a href="https://discord.gg/#Kylix3272" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/discord.svg" alt="#Kylix3272" height="30" width="40" /></a>
</p>


<p>
Don't forget to ⭐this repository to motivates me to share more open source library
</p>
