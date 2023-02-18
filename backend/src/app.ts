import express, { Express } from "express";
import { AuthController } from "./controllers/auth.controller.js";
import { EntityController } from "./controllers/entity.controller.js";
import bodyParser from "body-parser";
import { BookingController } from "./controllers/booking.controller.js";

const app: Express = express();
const port = process.env.PORT || 3001;
app.use(bodyParser.json());

const authController = new AuthController();
const entityController = new EntityController();
const bookingController = new BookingController();

app.post("/register", authController.register);

app.post("/login", authController.login);

app.get("/me", authController.me);

app.put("/me", authController.updateMe);

app.get("/lab", entityController.getLabs);

app.get("/room", entityController.getRooms);

app.get("/room/:id", entityController.getRooms);

app.get("/university", entityController.getUniversities);

app.get("/dormitory", entityController.getDormitories);

app.get("/universityEvent", entityController.getUniversityEvent);

app.get("/news", entityController.getNews);

app.post("/book", bookingController.book);

app.delete("/book", bookingController.unbook);

app.post("/bookEvent", bookingController.bookEvent);

app.post("/bookEvent/my", bookingController.getMyEventBook);

app.listen(port, () => {
  console.log(`Сервер запущен по адресу http://localhost:${port}`);
});
