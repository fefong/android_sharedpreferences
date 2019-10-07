Android/Java: Shared Preferences
================================

Example Android/Java:  Shared Preferences;

- [Android/Java: Shared Preferences](#androidjava-shared-preferences)
  - [Constants](#constants)
  - [Save Shared Preference](#save-shared-preference)
  - [Get Shared Preference](#get-shared-preference)
  - [Delete Shared Preference](#delete-shared-preference)
  - [Screenshots](#screenshots)
- [Some links for more in depth learning](#some-links-for-more-in-depth-learning)



## Constants

Declare variables constants.

:warning: It is recommended to use constant variables to declare as **KEYs**.

```java
private SharedPreferences sharedPreferences;
private SharedPreferences.Editor editorSharedPreferences;
private String KEY="KEY";
```

Initialize the variables.

```java
@Override
protected void onCreate(Bundle savedInstanceState) {
    // TODO

    sharedPreferences = getSharedPreferences(KEY, Context.MODE_PRIVATE);

    editorSharedPreferences = sharedPreferences.edit();
}
```
## Save Shared Preference

```java
editorSharedPreferences.putString(KEY,"TEXT");

editorSharedPreferences.apply();
```

## Get Shared Preference

```java
if (sharedPreferences.contains(KEY)) {
    String text = sharedPreferences.getString(KEY, "");
    // TODO
}
```
## Delete Shared Preference

```java
editorSharedPreferences.remove(KEY);
editorSharedPreferences.commit();
```
## Screenshots

![Image Shared Preferences](https://user-images.githubusercontent.com/26600374/66279590-b6b4a880-e888-11e9-807c-298b32b25b16.jpg)


See implementation: [code](app/src/main/java/com/example/android_sharedpreferences/MainActivity.java)

# Some links for more in depth learning

* [JAVA](https://github.com/search?q=fefong%2Fjava)
  * [IF/Else](https://github.com/fefong/java_ifElse)
  * [Variables](https://github.com/fefong/java_variables)
* [ANDROID](https://github.com/search?q=fefong%2Fandroid)
