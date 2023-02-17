import { AuthModel } from "../models/auth.js";
const authModel = new AuthModel();
export class AuthController {
    async login(req, res, next) {
        const { email, password } = req.body;
        if (!email || !password) {
            return res
                .status(400)
                .json({ message: "Оба поля должны быть заполненны" });
        }
        const { data } = await authModel.login(email, password);
        return res.json(data);
    }
    async register(req, res, next) {
        const { email, password } = req.body;
        if (!email || !password) {
            return res
                .status(400)
                .json({ message: "Некорректно указана почта или пароль" });
        }
        const { data } = await authModel.register(email, password);
        return res.json(data);
    }
}
