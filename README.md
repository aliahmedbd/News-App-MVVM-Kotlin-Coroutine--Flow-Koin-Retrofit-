# News App - Android Clean Architeture (MVVM, Kotlin, Coroutine, Flow, Koin, Retrofit)

This is one of my public repository where I tried to create the clean architecture for Android development. The purpose of the project is to build a template Android project, where the necessary things are added properly. As well as I can use this repository as technical task/interview and project template.

### Here is some screenshots:

<img src="https://github.com/aliahmedbd/News-App-MVVM-Kotlin-Coroutine--Flow-Koin-Retrofit-/blob/main/news_screen.PNG" alt="" data-canonical-src="https://github.com/aliahmedbd/News-App-MVVM-Kotlin-Coroutine--Flow-Koin-Retrofit-/blob/main/news_screen.PNG" width="200" height="400" />  <img src="https://github.com/aliahmedbd/News-App-MVVM-Kotlin-Coroutine--Flow-Koin-Retrofit-/blob/main/screen_navigation.PNG" alt="" data-canonical-src="https://github.com/aliahmedbd/News-App-MVVM-Kotlin-Coroutine--Flow-Koin-Retrofit-/blob/main/screen_navigation.PNG" width="200" height="400" /> <img src="https://github.com/aliahmedbd/News-App-MVVM-Kotlin-Coroutine--Flow-Koin-Retrofit-/blob/main/screen_details.PNG" alt="" data-canonical-src="https://github.com/aliahmedbd/News-App-MVVM-Kotlin-Coroutine--Flow-Koin-Retrofit-/blob/main/screen_details.PNG" width="200" height="400" /> 

Here is the public API I have used: https://newsapi.org/

I tried to build this application following these terms. which are:

- performance
- readability
- maintainability
- testability
- scalability
- simplicity


The tools I have used to gain the Android Clean Architecture are:

- MVVM :  MVVM architecure is followed for the code boilerplate. Where View, ViewModel, Repisitory are clearly used for maintailed the SOLID principle. (https://www.geeksforgeeks.org/mvvm-model-view-viewmodel-architecture-pattern-in-android/)
- Kotlin (https://kotlinlang.org/)
- Coroutine : To reduce the main thread task we can divide the task in many thread asychronously using the Kotlin Coroutine using lifecycle scope. (https://developer.android.com/kotlin/coroutines)
- Koin : KOIN is a ligh weight dependency injection which is written in pure Kotlin. Its really easy to learn and there is no generated code will be in KOIN used Android project. (https://insert-koin.io/)
- NavigationUI : https://developer.android.com/guide/navigation/navigation-ui
- Kotlin Flow : In coroutines, a flow is a type that can emit multiple values sequentially, as opposed to suspend functions that return only a single value. (https://developer.android.com/kotlin/flow)
- Retrofit : (https://square.github.io/retrofit/)
