# Мобильное приложение "Студтуризм"
## Стек
### Frontend
- Kotlin
- Android SDK 
- Jetpack
- Coroutines
### Backend
- TypeScript
- Express
- Axios
## Frontend


## Backend
### Сборка
Backend уже развернут на сервере по [ссылке](https://codehunters-service.onrender.com): 

Но, если появится надобность развернуть сервер локально, это можно сделать следующими командами:

1. `npm install` в папке backend
2. `npm run build` в папке backend
3. `npm run start` в папке backend

### Реализованные роуты
- `/login` - POST запрос, который принимает `email` и `password`.
- `/register` - POST запрос, который принимает `email` и `password`.
- `/me` - GET запрос, который получается информацию об авторизированном пользователе. `Header` запроса должен включать в себя токен `Authorization`, который дается при логине и регистрации юзера.
- `/me` - PUT запрос, который получается информацию об авторизированном пользователе. `Header` запроса должен включать в себя токен `Authorization`, который дается при логине и регистрации юзера. А также, должен содержать в себе все поля, которые были получены при GET запросе на путь `/me`
- `/lab` - GET запрос, возвращающий лаборатории.
- `/room` - GET запрос, возвращающий все комнаты.
- `/room/:dormitoryId` - GET запрос, возвращающий комнаты, относящиесся к тому общежитию, айди которого указано через слеш.
- `/news` - GET запрос, возвращающий новости.
- `/university` - GET запрос, возвращающий университеты.
- `/dormitory` - GET запрос, возвращающий общежития.
- `/universityEvent` - GET запрос, возвращающий события в университетах.
- `/news` - GET запрос, возвращающий статьи.
- `/book` - POST запрос, позволяющий забронировать место.
- `/book` - DELETE запрос, позволяющий удалить бронь. В теле запроса нужно указать `id` брони.
- `/bookEvent` - POST запрос, позволяющий забронировать событие.
- `/bookEvent/my` - POST запрос, позволяющий просмотреть свои забронированные события.

Также на стороне бекенда реализована сортировка списков.

---

### Входные данные для методов

### `login`
```ts
{
  email: string;
  password: string;
}
```

### `register`
```ts
{
  email: string;
  password: string;
}
```

### `book`
```ts
{
  roomId: string;
  quantity: number;
  dates: {
    from: string;
    to: string;
  };
}
```

### `unbook`
```ts
{
  dates: {
    from: string;
    to: string;
  };
  id: string;
  status: "canceled";
}
```


### `bookEvent`
```ts
{
  details: {
    email: string;
    fullName: string;
    participants: { fullName: string; phone: string; email: string }[];
    phone: string;
    quantity: string;
  };
  eventId: string;
}
```