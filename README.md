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

| Popular Screen                                  | Upcoming Screen                               |
| ----------------------------------------------- | --------------------------------------------- |
| <img width="1280" height="2856" alt="Screenshot_20260814_145151" src="https://github.com/user-attachments/assets/f1313556-8c41-4656-bf0d-3ac1ea570e78" /> | <img width="1280" height="2856" alt="Screenshot_20260814_145237" src="https://github.com/user-attachments/assets/9b063a10-5a46-474d-86d1-dfaa289ddfef" /> |

| Detail Screen                                     | Home Screen (Light Theme)                             |
| ------------------------------------------------- | ----------------------------------------------------- |
| <img width="1280" height="2856" alt="Screenshot_20260814_145216" src="https://github.com/user-attachments/assets/ab856473-9858-4897-8096-e4857eea1621" /> | <img width="1280" height="2856" alt="Screenshot_20260814_145316" src="https://github.com/user-attachments/assets/987b423d-e378-4c29-b30b-9235b81e174a" /> |

</div>


---

# 📌 Future Improvements

* Dark Mode
* Pagination
* Offline Support
* Similar Movies<img width="1280" height="2856" alt="Screenshot_20260814_145237" src="https://github.com/user-attachments/assets/0c789a22-7e37-456c-b66b-38009ecec7ab" />

* Genre Filter

---

# 👨‍💻 Author

**Bank Lannister**

Android Developer | Kotlin | Jetpack Compose

---

## ⭐ If you like this project

If you found this project helpful, please consider giving it a ⭐ on GitHub!
