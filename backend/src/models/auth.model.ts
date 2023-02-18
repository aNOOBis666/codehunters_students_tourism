// @ts-ignore
import axios from "axios";
import {
  IAuthReturn,
  IMeReturn,
  IUpdateMeProps,
} from "../interfaces/auth.interface";

interface IAuthModel {
  login: (email: string, password: string) => Promise<IAuthReturn>;
  register: (email: string, password: string) => Promise<IAuthReturn>;
  me: (token: string) => Promise<IMeReturn>;
  updateMe: (info: IUpdateMeProps, token: string) => Promise<IMeReturn>;
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

  async me(token: string): Promise<IMeReturn> {
    const { data } = await axios.get("https://stud-api.sabir.pro/me", {
      headers: { Authorization: token },
    });
    return {
      data,
    };
  }

  async updateMe(info: IUpdateMeProps, token: string): Promise<IMeReturn> {
    const { data } = await axios.put("https://stud-api.sabir.pro/users", info, {
      headers: {
        Authorization: token,
      },
    });
    return {
      data,
    };
  }
}
