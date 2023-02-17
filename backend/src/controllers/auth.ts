import { NextFunction, Request, Response } from "express";
import { AuthModel } from "../models/auth.js";

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
}
