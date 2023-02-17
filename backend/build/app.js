import express from "express";
const app = express();
const port = 3001;
app.get("/", (req, res) => {
    res.json({ msg: "Hello World!" });
});
app.listen(port, () => {
    console.log(`Сервер запущен по адресу http://localhost:${port}`);
});
