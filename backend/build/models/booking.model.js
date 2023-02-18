// @ts-ignore
import axios from "axios";
export class BookingModel {
    async book(info, token) {
        const { data } = await axios.post("https://stud-api.sabir.pro/bookings", info, {
            headers: {
                Authorization: token,
            },
        });
        return data;
    }
    async unbook(info, token) {
        const { data } = await axios.put("https://stud-api.sabir.pro/bookings", info, {
            headers: {
                Authorization: token,
            },
        });
        return data;
    }
    async bookEvent(info, token) {
        const { data } = await axios.post("https://stud-api.sabir.pro/event-bookings", info, {
            headers: {
                Authorization: token,
            },
        });
        return data;
    }
    async getMyEventBook(token) {
        const { data } = await axios.get("https://stud-api.sabir.pro/event-bookings/my", {
            headers: {
                Authorization: token,
            },
        });
        return data;
    }
}
