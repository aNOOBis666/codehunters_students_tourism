import { NextFunction, Request, Response } from "express";
import { EntityModel } from "../models/entity.model.js";
import { IRoomsReturn } from "../interfaces/entity.model.interface";

const entityModel = new EntityModel();

interface IEntityController {
  getNews: (
    req: Request,
    res: Response,
    next: NextFunction
  ) => Promise<Response>;
  getUniversities: (
    req: Request,
    res: Response,
    next: NextFunction
  ) => Promise<Response>;
  getDormitories: (
    req: Request,
    res: Response,
    next: NextFunction
  ) => Promise<Response>;
  getUniversityEvent: (
    req: Request,
    res: Response,
    next: NextFunction
  ) => Promise<Response>;
  getLabs: (
    req: Request,
    res: Response,
    next: NextFunction
  ) => Promise<Response>;
  getRooms: (
    req: Request,
    res: Response,
    next: NextFunction
  ) => Promise<Response>;
}

export class EntityController implements IEntityController {
  async getDormitories(
    req: Request,
    res: Response,
    next: NextFunction
  ): Promise<Response> {
    const { city } = req.query;
    if (city) {
      const data = await entityModel.getDormitories("city", String(city));
      return res.json(data);
    }
    const { data } = await entityModel.getDormitories();
    return res.json(data);
  }

  async getLabs(
    req: Request,
    res: Response,
    next: NextFunction
  ): Promise<Response> {
    const { data } = await entityModel.getLabs();
    return res.json(data);
  }

  async getNews(
    req: Request,
    res: Response,
    next: NextFunction
  ): Promise<Response> {
    const { data } = await entityModel.getNews();
    return res.json(data);
  }

  async getRooms(
    req: Request,
    res: Response,
    next: NextFunction
  ): Promise<Response> {
    const { id } = req.params;
    if (id) {
      const data = await entityModel.getRoomsById(id);
      return res.json(data);
    }
    const { data } = await entityModel.getRooms();
    return res.json(data);
  }

  async getUniversities(
    req: Request,
    res: Response,
    next: NextFunction
  ): Promise<Response> {
    const { data } = await entityModel.getUniversities();
    return res.json(data);
  }

  async getUniversityEvent(
    req: Request,
    res: Response,
    next: NextFunction
  ): Promise<Response> {
    const { data } = await entityModel.getUniversityEvent();
    return res.json(data);
  }
}
