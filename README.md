# BreakingBad-android
Android application usign Kotlin language that displays the list of Breaking Bad Characters using a publicly available 
REST API on the web. Clicking on a character opens a simple detail screen with more information about the character.

![](breaking-bad.gif)


## Architecture
Clean Architecture with MVVM using Repository Pattern.
The project is using packages presentation, domain and data.

- The Presentation package is using MVVM with live data.
- The Domain package has all the Use Cases & Repositories.
- The Data package is using the Repository Pattern to get data from Remote and/or from Cache.


## Language
- Kotlin


## Libraries 
- Android Architecture Components: 
	- Navigation
	- ViewModel
	- LiveData
	- Room
- Kotlin Coroutines
- Dagger-Android
- Epoxy
- OkHttp
- Retrofit
- Moshi
- Espresso
- Mockito
- JUnit4


## Author 

* **Jaiber Yepes** - [jaibercom](https://github.com/jaibercom)




