// @ts-ignore
import axios from "axios";
import {
  IDormitoriesReturn,
  ILabsReturn,
  INewsReturn,
  IUniversitiesReturn,
  IUniversityEvent,
} from "../interfaces/entity.model.interface";

interface IEntityModel {
  getNews: () => Promise<INewsReturn[]>;
  getUniversities: () => Promise<IUniversitiesReturn[]>;
  getDormitories: () => Promise<IDormitoriesReturn>;
  getUniversityEvent: () => Promise<IUniversityEvent>;
  getLabs: () => Promise<ILabsReturn>;
}

export class EntityModel implements IEntityModel {
  async getNews() {
    return await axios.get("https://stud-api.sabir.pro/articles");
  }

  async getUniversities() {
    return await axios.get("https://stud-api.sabir.pro/universities/all");
  }

  async getDormitories() {
    return await axios.get("https://stud-api.sabir.pro/dormitories/all");
  }

  async getUniversityEvent() {
    return await axios.get("https://stud-api.sabir.pro/events/all");
  }

  async getLabs() {
    return await axios.get("https://stud-api.sabir.pro/labs/all");
  }
}
