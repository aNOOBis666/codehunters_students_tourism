import express, { Express } from "express";
import { AuthController } from "./controllers/auth.controller.js";
import { EntityController } from "./controllers/entity.controller.js";
import bodyParser from "body-parser";

const app: Express = express();
const port = 3001;
app.use(bodyParser.json());

const authController = new AuthController();
const entityController = new EntityController();

app.post("/register", authController.register);

app.post("/login", authController.login);

app.get("/lab", entityController.getLabs);

app.get("/university", entityController.getUniversities);

app.get("/dormitory", entityController.getDormitories);

app.get("/universityEvent", entityController.getUniversityEvent);

app.get("/news", entityController.getNews);

app.listen(port, () => {
  console.log(`Сервер запущен по адресу http://localhost:${port}`);
});
