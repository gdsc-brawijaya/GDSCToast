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
  
  Add this in your root `setting.gradle` file :
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

Each function start with 'make...' like ```makeNormalToast``` always returns a `Toast` object, so you can customize your own Toast. But if you just want to show the toast without any customization, you can use function that start with 'show...' like `showNormalToast`

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

- To configure any toast (1.2.0)
``` kotlin
GDSCToast.configOn(this@MainActivity)
    .setText("Write your message here")
    .setDuration(Toast.LENGTH_LONG)
    .setShowLogo(false)
    .setToastShape(ToastShape.RECTANGLE)
    .setToastType(ToastType.WARNING)
    .showToast()
```

- To configure any toast using lambda expression (1.2.1)
```kotlin
GDSCToast.showAnyToast(this@MainActivity) {
    it.apply {
	text = "Hello this is from 1.2.1 ver"
	duration = Toast.LENGTH_LONG
	showLogo = false
	toastShape = ToastShape.RECTANGLE
	toastType = ToastType.ERROR
    }
}
```

| Method | Parameter | Usage | Attribute Default Value |
| ------ | :---------: | ----- | :-------------------: | 
| ``` configOn ``` | ```Context``` | Allow you to access configuration of GDSCToast | No default value because it's mandatory |
| ```setText``` | ```String``` | To set message that will shown from toast | ```""``` |
| ```setToastType``` | ```ToastType``` | To set type of toast | ```ToastType.NORMAL``` |
| ```setShowLogo``` | ```Boolean``` | To set visibility of GDSC logo  | ```true``` |
| ```setDuration``` | ```Int```| To set duration of toast | ```Toast.LENGTH_SHORT``` |
| ```setToastShape``` | ```ToastShape``` | To set shape of toast | ```ToastShape.ROUNDED``` |
| ```makeToast``` | - | To create the toast => returns toast object | - |
| ```showToast``` | - | To show the toast | - |

## Preview

| Shape | Preview |
| ----- | ------- |
| ToastShape.ROUNDED | <img width="100%" height="100%" src="https://user-images.githubusercontent.com/58837451/146627030-c249eb22-d5b2-4b67-816c-80f4381456c7.png" /> |
| ToastShape.RECTANGLE | <img width="100%" height="100%" src="https://user-images.githubusercontent.com/58837451/148328151-57bca1c0-4a84-4e36-b108-1df504ea7aca.png" /> |

## Contributing

Please fork this repository and contribute back using.

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
