import { EntityModel } from "../models/entity.model.js";
const entityModel = new EntityModel();
export class EntityController {
    async getDormitories(req, res, next) {
        const { city } = req.query;
        if (city) {
            const data = await entityModel.getDormitories("city", String(city));
            return res.json(data);
        }
        const { data } = await entityModel.getDormitories();
        return res.json(data);
    }
    async getLabs(req, res, next) {
        const { data } = await entityModel.getLabs();
        return res.json(data);
    }
    async getNews(req, res, next) {
        const { data } = await entityModel.getNews();
        return res.json(data);
    }
    async getUniversities(req, res, next) {
        const { data } = await entityModel.getUniversities();
        return res.json(data);
    }
    async getUniversityEvent(req, res, next) {
        const { data } = await entityModel.getUniversityEvent();
        return res.json(data);
    }
}
