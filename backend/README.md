# Backend для мобильного приложения "Студтуризм"
## Реализованные роуты
- `/login` - POST запрос, который принимает `email` и `password`.
- `/register` - POST запрос, который принимает `email` и `password`.
- `/me` - GET запрос, который получается информацию об авторизированном пользователе. `Header` запроса должен включать в себя токен `Authorization`, который дается при логине и регистрации юзера.
- `/lab` - GET запрос, возвращающий лаборатории.
- `/news` - GET запрос, возвращающий новости.
- `/university` - GET запрос, возвращающий университеты.
- `/dormitory` - GET запрос, возвращающий общежития.
- `/universityEvent` - GET запрос, возвращающий события в университетах.

Также на стороне бекенда реализована сортировка списков.

---

## Входные данные для методов

### `login`
```ts

```

### `register`
```ts

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