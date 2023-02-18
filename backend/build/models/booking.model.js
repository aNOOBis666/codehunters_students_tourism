// @ts-ignore
import axios from "axios";
class BookingModel {
    async book(info) {
        const { data } = await axios.post("https://stud-api.sabir.pro/bookings", info);
        return data;
    }
    async unbook(info) {
        const { data } = await axios.put("https://stud-api.sabir.pro/bookings", info);
        return data;
    }
    async bookEvent(info) {
        const { data } = await axios.post("https://stud-api.sabir.pro/event-bookings", info);
        return data;
    }
    async getMyEventBook(token) {
        const { data } = await axios.get("https://stud-api.sabir.pro/event-bookings/my", {
            token,
        });
        return data;
    }
}
