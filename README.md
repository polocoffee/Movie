# 🎬 Movie App

A modern Android Movie application built with **Jetpack Compose** following the **MVI (Model–View–Intent)** architecture. The app fetches movie data from **The Movie Database (TMDB)** API and provides a clean, responsive UI with smooth navigation and offline caching.

---

## ✨ Features

### 🏠 Home Screen

* Bottom Navigation with two tabs:

  * 🔥 Popular Movies
  * 🎥 Upcoming Movies
* Infinite scrolling support *(optional if implemented)*
* Pull-to-refresh *(optional if implemented)*
* Movie cards with:

  * Poster
  * Title
  * Rating
  * Release Date

### 🎬 Movie Detail Screen

Tap any movie from the Home Screen to view its details.

The Detail Screen displays:

* 🖼️ Backdrop Image
* 🎞️ Poster Image
* 🎬 Movie Title
* ⭐ Rating Bar
* 🌐 Original Language
* 📅 Release Date
* ⭐ Vote Average
* 📝 Movie Overview

---

# 📱 Screens

## Home

* Popular Movies
* Upcoming Movies

## Detail

Displays complete movie information.

---

# 🏗️ Architecture

This project follows the **MVI (Model–View–Intent)** architecture.

```
Presentation
│
├── Screen
├── ViewModel
├── UiState
├── Intent
└── Components

Domain
│
├── Repository
├── Model
└── UseCase

Data
│
├── Remote
│   ├── Api
│   ├── DTO
│   └── Mapper
│
├── Local
│   ├── Room
│   ├── Dao
│   └── Entity
│
└── RepositoryImpl
```

---

# 🛠 Tech Stack

* Kotlin
* Jetpack Compose
* Navigation Compose
* Dagger Hilt
* Retrofit2
* Room Database
* Paging 3
* Coil
* Coroutines
* Flow / StateFlow
* Material 3

---

# 📦 Libraries

| Library            | Purpose                  |
| ------------------ | ------------------------ |
| Jetpack Compose    | Modern Android UI        |
| Navigation Compose | Screen Navigation        |
| Dagger Hilt        | Dependency Injection     |
| Retrofit2          | REST API                 |
| Room Database      | Local Storage            |
| Coil               | Image Loading            |
| Paging 3           | Efficient pagination and infinite scrolling |
| Kotlin Coroutines  | Asynchronous Programming |
| StateFlow          | Reactive UI State        |


---

# 🌐 API

Movie data is provided by:

**The Movie Database (TMDB)**

> https://api.themoviedb.org

---

# 📂 Project Structure

```
app
│
├── data
│   ├── local
│   │   ├── dao
│   │   ├── database
│   │   └── entity
│   │
│   ├── remote
│   │   ├── api
│   │   ├── dto
│   │   └── response
│   │
│   ├── mapper
│   └── repository
│
├── domain
│   ├── model
│   ├── repository
│   └── usecase
│
├── presentation
│   ├── home
│   │   ├── popular
│   │   ├── upcoming
│   │   ├── intent
│   │   ├── state
│   │   └── viewmodel
│   │
│   ├── detail
│   │   ├── intent
│   │   ├── state
│   │   └── viewmodel
│   │
│   ├── navigation
│   └── components
│
├── di
└── utils
```

---

# 🚀 Getting Started

### Clone the project

```bash
git clone https://github.com/yourusername/movie-app.git
```

### Open in Android Studio

Open the project using the latest version of Android Studio.

### Add your TMDB API Key

Create a `local.properties` file and add:

```properties
TMDB_API_KEY=YOUR_API_KEY
```

### Build & Run

```bash
Run ▶️
```

---

# 📸 Screenshots

<div align="center">

| Home Screen (Light Theme)                       | Detail Screen (Light Theme)                   |
| ----------------------------------------------- | --------------------------------------------- |
| <img width="1280" height="2856" alt="Screenshot_20260911_131420" src="https://github.com/user-attachments/assets/30a46d69-708a-41d6-9082-3fcd1b95d486"/> | <img width="1280" height="2856" alt="Screenshot_20260911_131534" src="https://github.com/user-attachments/assets/0666909c-407d-4216-aee1-a34ed12e69b8" /> |

| Home Screen (Dark Theme)                          | Detail Screen (Dark Theme)                            |
| ------------------------------------------------- | ----------------------------------------------------- |
| <img width="1280" height="2856" alt="Screenshot_20260911_131452" src="https://github.com/user-attachments/assets/342ded84-21de-4e8f-885c-c7ccfcbc0eb4" />
| <img width="1280" height="2856" alt="Screenshot_20260911_131509" src="https://github.com/user-attachments/assets/dea275fa-074e-4277-8cbf-2aeb4f0e2380" />|

</div>


---

# 📌 Future Improvements

* Dark Mode
* Pagination
* Offline Support
* Similar Movies
* Genre Filter

---

# 👨‍💻 Author

**Bank Lannister**

Android Developer | Kotlin | Jetpack Compose

---

## ⭐ If you like this project

If you found this project helpful, please consider giving it a ⭐ on GitHub!
