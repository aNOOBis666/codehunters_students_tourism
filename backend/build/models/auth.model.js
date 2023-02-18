// @ts-ignore
import axios from "axios";
export class AuthModel {
    async login(email, password) {
        const { data } = await axios.post("https://stud-api.sabir.pro/users/login", {
            email,
            password,
        });
        return {
            data,
        };
    }
    async register(email, password) {
        const { data } = await axios.post("https://stud-api.sabir.pro/users/signup", {
            email,
            password,
        });
        return {
            data,
        };
    }
    async me(token) {
        const { data } = await axios.get("https://stud-api.sabir.pro/me", {
            headers: { Authorization: token },
        });
        return {
            data,
        };
    }
    async updateMe(info, token) {
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
