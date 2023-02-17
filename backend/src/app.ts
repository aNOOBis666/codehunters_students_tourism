import express, { Express } from "express";
import { AuthController } from "./controllers/auth.js";
import bodyParser from "body-parser";

const app: Express = express();
const port = 3001;
app.use(bodyParser.json());

const authController = new AuthController();

app.post("/register", authController.register);

app.post("/login", authController.login);

app.listen(port, () => {
  console.log(`Сервер запущен по адресу http://localhost:${port}`);
});
