import { NextFunction, Request, Response } from "express";
import { BookingModel } from "../models/booking.model.js";

const bookingModel = new BookingModel();

interface IBookingController {
  book: (req: Request, res: Response, next: NextFunction) => Promise<Response>;
  unbook: (
    req: Request,
    res: Response,
    next: NextFunction
  ) => Promise<Response>;
  bookEvent: (
    req: Request,
    res: Response,
    next: NextFunction
  ) => Promise<Response>;
  getMyEventBook: (
    req: Request,
    res: Response,
    next: NextFunction
  ) => Promise<Response>;
}

export class BookingController implements IBookingController {
  async book(
    req: Request,
    res: Response,
    next: NextFunction
  ): Promise<Response> {
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

  async unbook(
    req: Request,
    res: Response,
    next: NextFunction
  ): Promise<Response> {
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

  async bookEvent(
    req: Request,
    res: Response,
    next: NextFunction
  ): Promise<Response> {
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

  async getMyEventBook(
    req: Request,
    res: Response,
    next: NextFunction
  ): Promise<Response> {
    const token = req.header("Authorization");
    if (!token) {
      return res.status(400).json({ message: "Не передан токен авторизации" });
    }
    const data = await bookingModel.getMyEventBook(token);
    return res.json(data);
  }
}
