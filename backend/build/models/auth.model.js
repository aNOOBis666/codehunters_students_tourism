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
        console.log(token);
        const { data } = await axios.get("https://stud-api.sabir.pro/me", {
            headers: { Authorization: token },
        });
        return {
            data,
        };
    }
}
