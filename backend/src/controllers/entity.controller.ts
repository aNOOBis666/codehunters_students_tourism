import { NextFunction, Request, Response } from "express";
import { EntityModel } from "../models/entity.model.js";

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
}

export class EntityController implements IEntityController {
  async getDormitories(
    req: Request,
    res: Response,
    next: NextFunction
  ): Promise<Response> {
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
