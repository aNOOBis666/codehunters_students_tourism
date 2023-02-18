import { BookingModel } from "../models/booking.model.js";
const bookingModel = new BookingModel();
export class BookingController {
    async book(req, res, next) {
        const info = req.body;
        const token = req.header("Authorization");
        if (!token) {
            return res.status(400).json({ message: "Не передан токен" });
        }
        if (!info) {
            return res.status(400).json({ message: "Не передан объект букинга" });
        }
        const data = await bookingModel.book(info, token);
        return res.json(data);
    }
    async unbook(req, res, next) {
        const info = req.body;
        const token = req.header("Authorization");
        if (!token) {
            return res.status(400).json({ message: "Не передан токен" });
        }
        if (!info) {
            return res.status(400).json({ message: "Не передан объект букинга" });
        }
        const data = await bookingModel.unbook(info, token);
        return res.json(data);
    }
    async bookEvent(req, res, next) {
        const info = req.body;
        const token = req.header("Authorization");
        if (!token) {
            return res.status(400).json({ message: "Не передан токен" });
        }
        if (!info) {
            return res.status(400).json({ message: "Не передан объект события" });
        }
        const data = await bookingModel.bookEvent(info, token);
        return res.json(data);
    }
    async getMyEventBook(req, res, next) {
        const token = req.header("Authorization");
        if (!token) {
            return res.status(400).json({ message: "Не передан токен авторизации" });
        }
        const data = await bookingModel.getMyEventBook(token);
        return res.json(data);
    }
}
