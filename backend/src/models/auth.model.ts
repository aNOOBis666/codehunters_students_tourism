// @ts-ignore
import axios from "axios";
import { IAuthReturn } from "../interfaces/auth.interface";

interface IAuthModel {
  login: (email: string, password: string) => Promise<IAuthReturn>;
  register: (email: string, password: string) => Promise<IAuthReturn>;
}

export class AuthModel implements IAuthModel {
  async login(email: string, password: string): Promise<IAuthReturn> {
    const { data } = await axios.post(
      "https://stud-api.sabir.pro/users/login",
      {
        email,
        password,
      }
    );
    return {
      data,
    };
  }

  async register(email: string, password: string): Promise<IAuthReturn> {
    const { data } = await axios.post(
      "https://stud-api.sabir.pro/users/signup",
      {
        email,
        password,
      }
    );
    return {
      data,
    };
  }
}
