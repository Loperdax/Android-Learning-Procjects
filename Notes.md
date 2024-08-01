<a name="top"></a>
# Advanced Android Learning Repository - Notes
Welcome to **Android Advanced Learning Repository Notes**! 
This document provides detailed code snippets, explanations and additional information to
help you understand and implement various advanced Android development concepts.
## Table of Contents
1. [RecyclerView](#recyclerview)
2. [Room Database](#room-database)
3. [Retrofit](#retrofit)
4. [Navigation](#navigation)
5. [Coroutines](#coroutines)
6. [Hilt](#hilt)
7. [ViewModel](#viewmodel)
8. [LiveData](#livedata)
9. [DataStore](#datastore)

<a name="recyclerview"></a>
## RecyclerView  🔃

A RecyclerView is a flexible view for displaying a large dataset in a limited window by recycling and reusing views.

### Steps to Implement a RecyclerView

1. Create Item Layout : [See Example](https://github.com/Loperdax/Android-Learning-Procjects/blob/master/app/src/main/res/layout/simple_item.xml)
2. Add RecyclerView to Layout : [See Example](https://github.com/Loperdax/Android-Learning-Procjects/blob/master/app/src/main/res/layout/activity_user_list.xml)
3. Create Data Model : [See Example](https://github.com/Loperdax/Android-Learning-Procjects/blob/master/app/src/main/java/com/app/learn/recycle/UsersModel.kt)
4. Create Adapter with DiffUtil : [See Example](https://github.com/Loperdax/Android-Learning-Procjects/blob/master/app/src/main/java/com/app/learn/recycle/UserAdapter.kt)
5. Set Adapter and LayoutManager : [See Example](https://github.com/Loperdax/Android-Learning-Procjects/blob/master/app/src/main/java/com/app/learn/recycle/UserListActivity.kt#L26)
6. Submit List Data to Adapter : [See Example](https://github.com/Loperdax/Android-Learning-Procjects/blob/master/app/src/main/java/com/app/learn/recycle/UserListActivity.kt#L23)

[back to top🔼](#top)

<a name="room-database"></a>
## Room Database 🏠

Room is an abstraction layer over SQLite that provides a more robust and manageable way to work with databases in Android.

### Steps to Room Database

1. Create Entity class : [See Example](https://github.com/Loperdax/Android-Learning-Procjects/blob/master/app/src/main/java/com/app/learn/roomDb/db/UserEntity.kt)
2. Define Data Access Object (DAO) : [See Example](https://github.com/Loperdax/Android-Learning-Procjects/blob/master/app/src/main/java/com/app/learn/roomDb/db/UserDao.kt)
3. Create the Database class : [See Example](https://github.com/Loperdax/Android-Learning-Procjects/blob/master/app/src/main/java/com/app/learn/roomDb/db/UserDatabase.kt)
4. Initialize the database in your Activity  : [See Example](https://github.com/Loperdax/Android-Learning-Procjects/blob/master/app/src/main/java/com/app/learn/roomDb/RoomActivity.kt#L23)
5. Perform database operations : [See Example Get Data](https://github.com/Loperdax/Android-Learning-Procjects/blob/master/app/src/main/java/com/app/learn/roomDb/AddUserActivity.kt#L39) [See Example Set Data](https://github.com/Loperdax/Android-Learning-Procjects/blob/master/app/src/main/java/com/app/learn/roomDb/RoomActivity.kt#L60)

[back to top🔼](#top)

<a name="retrofit"></a>
## Retrofit 🌐

Retrofit is a type-safe HTTP client for Android and Java, which makes it easy to consume RESTful web

### Steps to Implement Retrofit

1. Create Data Classes for Request and Response : [See Example Request](https://github.com/Loperdax/Android-Learning-Procjects/blob/master/app/src/main/java/com/app/learn/retrofit/requests/RequestUserRegister.kt)  [See Example Response](https://github.com/Loperdax/Android-Learning-Procjects/blob/master/app/src/main/java/com/app/learn/retrofit/responses/ResponseMovie.kt)
2. Create Retrofit Client : [See Example](https://github.com/Loperdax/Android-Learning-Procjects/blob/master/app/src/main/java/com/app/learn/retrofit/server/ApiClient.kt)
3. Create Service Interface : [See Example](https://github.com/Loperdax/Android-Learning-Procjects/blob/master/app/src/main/java/com/app/learn/retrofit/server/ApiService.kt)
4. Use the Service : [See Example](https://github.com/Loperdax/Android-Learning-Procjects/blob/master/app/src/main/java/com/app/learn/retrofit/RetrofitActivity.kt#L39)

[back to top🔼](#top)

<a name="navigation"></a>
## Navigation ⤴

Android Jetpack's Navigation component helps you implement navigation, from simple button clicks to more complex patterns, such as app bars and navigation drawers.

### Steps to Implement Navigation

1. Create Fragments : [See Example](https://github.com/Loperdax/Android-Learning-Procjects/tree/master/app/src/main/java/com/app/learn/navigation/project1/fragments) [See Example Fragment Layout](https://github.com/Loperdax/Android-Learning-Procjects/blob/master/app/src/main/res/layout/fragment_home.xml)
2. Create Navigation Folder and Graph : [See Example](https://github.com/Loperdax/Android-Learning-Procjects/tree/master/app/src/main/res/navigation)
3. Set Up Navigation Host in Layout : [See Example](https://github.com/Loperdax/Android-Learning-Procjects/blob/master/app/src/main/res/layout/activity_navigation.xml#L18)
4. Implement Navigation in Activity or Fragment : [See Example](https://github.com/Loperdax/Android-Learning-Procjects/blob/master/app/src/main/java/com/app/learn/navigation/project1/fragments/HomeFragment.kt#L25)
5. Also Can Use BottomNav : [See Example](https://github.com/Loperdax/Android-Learning-Procjects/tree/master/app/src/main/java/com/app/learn/navigation/project2)

[back to top🔼](#top)

<a name="coroutines"></a>
## Coroutines 🧵

Coroutines are used for asynchronous programming in Kotlin, enabling efficient handling of concurrent tasks. Below are some key coroutine constructs and their explanations.

### Coroutine Scope and Dispatchers

1. [See Example](https://github.com/Loperdax/Android-Learning-Procjects/blob/master/app/src/main/java/com/app/learn/coroutines/CoroutinesActivity.kt)

[back to top🔼](#top)

<a name="hilt"></a>
## Hilt 💉

Hilt is a dependency injection library for Android that reduces the boilerplate of manual dependency injection. It is built on top of Dagger and provides a more streamlined approach to dependency injection.

### Steps to Implement Hilt

1. Create Application Class and Annotate with @HiltAndroidApp : [See Example](https://github.com/Loperdax/Android-Learning-Procjects/blob/master/app/src/main/java/com/app/learn/MyApplication.kt#L6)
2. Define Modules to Provide Dependencies : [See Example ApiModule](https://github.com/Loperdax/Android-Learning-Procjects/blob/master/app/src/main/java/com/app/learn/hilt/retrofit/module/ApiModule.kt) [See Example RoomDbModule](https://github.com/Loperdax/Android-Learning-Procjects/blob/master/app/src/main/java/com/app/learn/hilt/room/modules/DbModule.kt)
3. Use @AndroidEntryPoint for Activity : [See Example](https://github.com/Loperdax/Android-Learning-Procjects/blob/master/app/src/main/java/com/app/learn/hilt/retrofit/HiltRetrofitActivity.kt#L17)
4. Inject Dependencies into Activities/Fragments using @Inject : [See Example](https://github.com/Loperdax/Android-Learning-Procjects/blob/master/app/src/main/java/com/app/learn/hilt/retrofit/HiltRetrofitActivity.kt#L22)

✔ It is better to use a repository for the interface between data delivery modules and activity or fragment. [See Example Retrofit](https://github.com/Loperdax/Android-Learning-Procjects/blob/master/app/src/main/java/com/app/learn/hilt/retrofit/repository/ApiRepository.kt)  [See Example RoomDB](https://github.com/Loperdax/Android-Learning-Procjects/blob/master/app/src/main/java/com/app/learn/hilt/room/repository/DbRepository.kt)

[back to top🔼](#top)

<a name="viewmodel"></a>
## ViewModel 🖼

ViewModel is a component designed to store and manage UI-related data in a lifecycle-conscious way. It allows data to survive configuration changes such as screen rotations.

### Steps to Implement ViewModel

1. Create a ViewModel Class : [See Example](https://github.com/Loperdax/Android-Learning-Procjects/blob/master/app/src/main/java/com/app/learn/viewmodel/MainViewModel.kt)
2. Initialize ViewModel in Activity or Fragment : [See Example](https://github.com/Loperdax/Android-Learning-Procjects/blob/master/app/src/main/java/com/app/learn/viewmodel/ViewModelActivity.kt#13)
3. Change Data in ViewModel : [See Example](https://github.com/Loperdax/Android-Learning-Procjects/blob/master/app/src/main/java/com/app/learn/viewmodel/ViewModelActivity.kt#32)

[back to top🔼](#top)

<a name="livedata"></a>
## LiveData 🧬

LiveData is a lifecycle-aware data holder that allows you to build data-driven UIs with automatic updates to the UI when data changes. It is used in conjunction with ViewModel to manage UI-related data.

### Steps to Implement LiveData

1. Add LiveData to ViewModel : [See Example](https://github.com/Loperdax/Android-Learning-Procjects/blob/master/app/src/main/java/com/app/learn/livedata/MainViewModel.kt)
2. Observe LiveData in Activity or Fragment : [See Example](https://github.com/Loperdax/Android-Learning-Procjects/blob/master/app/src/main/java/com/app/learn/livedata/ActivityLiveData.kt#L43)
3. Update LiveData from ViewModel : [See Example Internet Checker](https://github.com/Loperdax/Android-Learning-Procjects/blob/master/app/src/main/java/com/app/learn/livedata/InternetChecker.kt)
4. Use LiveData with MutableLiveData : [See Example](https://github.com/Loperdax/Android-Learning-Procjects/blob/master/app/src/main/java/com/app/learn/livedata/db/NoteDao.kt#L17)

[back to top🔼](#top)

<a name="datastore"></a>
## DataStore 🏪

DataStore is a modern data storage solution in Android, offering a more efficient and scalable alternative to SharedPreferences.

### Steps to Implement DataStore

1. Initialize DataStore in Activity or Fragment: [See Example](https://github.com/Loperdax/Android-Learning-Procjects/blob/master/app/src/main/java/com/app/learn/datastore/ActivityDataStore.kt#L22)
2. Build Keys and use Them to Save and Get Data : [See Example](https://github.com/Loperdax/Android-Learning-Procjects/blob/master/app/src/main/java/com/app/learn/datastore/ActivityDataStore.kt#L49)
3. Use DataStore In Coroutines : [See Example](https://github.com/Loperdax/Android-Learning-Procjects/blob/master/app/src/main/java/com/app/learn/datastore/ActivityDataStore.kt#L37)

[back to top🔼](#top)
