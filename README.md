# News App using MVVM, Kotlin, Coroutine, Flows, Koin, Unit Test

In this repository I tried to create an Android project using Advanced technologies like MVVM design pattern, Kotlin (Koin, Coroutine, Flows) etc. The purpose of creating this repository to use in technical test/interview and personal usage for the best Android app development practice.

### App Details:

![newsScreen](https://user-images.githubusercontent.com/11981999/184511606-46f6e8d5-4e9e-45f2-ba04-d74442626f35.png)
![Screenshot 2022-08-13 at 22 59 01](https://user-images.githubusercontent.com/11981999/184512044-bb0fd270-8b87-4e45-a5c6-d44f1eafda39.png)
![Screenshot 2022-08-13 at 22 40 57](https://user-images.githubusercontent.com/11981999/184511633-5042d6ec-44f7-4120-8577-973606a884a8.png)
![Screenshot 2022-08-13 at 22 41 32](https://user-images.githubusercontent.com/11981999/184511648-658c1d5c-96aa-4186-acf1-9d9cd7229482.png)

### Used Technologies

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
- Navigation : Nav graph used for using multiple fragment in a single activities. In this project MainActivity contains multiple fragment like SearchNewsFragment, NewsFragment etc.
![Screenshot 2022-08-13 at 22 37 46](https://user-images.githubusercontent.com/11981999/184511562-6c92506f-dec3-43c3-a042-fd7489ce3f43.png)

- Kotlin Flow : In coroutines, a flow is a type that can emit multiple values sequentially, as opposed to suspend functions that return only a single value. (https://developer.android.com/kotlin/flow)
- Retrofit : (https://square.github.io/retrofit/)

### Unit Test
For unit test I used Junit, where I tried two ways plain Unit test and Android instrumented unit test. For saving favorite news I used instrumented unit test for following test which Empty list check, Saved favorite list size test, news item already saved or not. Here is the test case result:

![Screenshot 2022-08-13 at 22 54 37](https://user-images.githubusercontent.com/11981999/184511947-3c0fe405-5ac3-4be8-a7ff-6925cc1f90bf.png)


#### API Specification
For this repository I have used a public news api. News Data: structured, relevant, real-time Search multi-language worldwide news articles published online with NewsCatcher's News API. Here is the link: https://newscatcherapi.com/

<img width="605" alt="Screenshot 2022-08-13 at 22 49 18" src="https://user-images.githubusercontent.com/11981999/184511836-3e0e156d-0de2-4a2b-9d32-d2a52a4303dd.png">
