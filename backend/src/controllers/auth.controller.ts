import { NextFunction, Request, Response } from "express";
import { AuthModel } from "../models/auth.model.js";

const authModel = new AuthModel();

interface IAuthController {
  login: (
    req: Request,
    res: Response,
    next: NextFunction
  ) => Promise<Response | Error>;
  register: (
    req: Request,
    res: Response,
    next: NextFunction
  ) => Promise<Response | Error>;

  me: (
    req: Request,
    res: Response,
    next: NextFunction
  ) => Promise<Response | Error>;

  updateMe: (
    req: Request,
    res: Response,
    next: NextFunction
  ) => Promise<Response>;
}

export class AuthController implements IAuthController {
  async login(
    req: Request,
    res: Response,
    next: NextFunction
  ): Promise<Response | Error> {
    const { email, password } = req.body;
    if (!email || !password) {
      return res
        .status(400)
        .json({ message: "Оба поля должны быть заполненны" });
    }
    const { data } = await authModel.login(email, password);
    return res.json(data);
  }

  async register(
    req: Request,
    res: Response,
    next: NextFunction
  ): Promise<Response | Error> {
    const { email, password } = req.body;
    if (!email || !password) {
      return res
        .status(400)
        .json({ message: "Некорректно указана почта или пароль" });
    }
    const { data } = await authModel.register(email, password);
    return res.json(data);
  }

  async me(
    req: Request,
    res: Response,
    next: NextFunction
  ): Promise<Response | Error> {
    const token = req.header("Authorization");
    if (!token) {
      return res.status(401).json({ message: "Не указан токен авторизации" });
    }
    const { data } = await authModel.me(token);
    if (!data) {
      return res.status(401).json({ msg: "Юзер не найден" });
    }
    return res.json(data);
  }
  // @ts-ignore
  async updateMe(req: Request, res: Response, next: NextFunction) {
    const token = req.header("Authorization");
    const info = req.body;
    if (!info) {
      return res.status(400).json({ message: "Не указан объект юзера" });
    }
    if (!token) {
      return res.status(400).json({ message: "Не указан токен" });
    }
    const { data } = await authModel.updateMe(info, token);
    return res.json(data);
  }
}
