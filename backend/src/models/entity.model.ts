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
  getDormitories: (
    sortBy?: string,
    value?: string
  ) => Promise<IDormitoriesReturn[]>;
  getUniversityEvent: () => Promise<IUniversityEvent[]>;
  getLabs: () => Promise<ILabsReturn[]>;
}

export class EntityModel implements IEntityModel {
  async getNews() {
    return await axios.get("https://stud-api.sabir.pro/articles");
  }

  async getUniversities() {
    return await axios.get("https://stud-api.sabir.pro/universities/all");
  }

  async getDormitories(sortBy?: string, value?: string) {
    if (sortBy && value) {
      const response = await axios.get(
        "https://stud-api.sabir.pro/dormitories/all"
      );
      if (sortBy === "city") {
        return response.data.filter(
          (d: IDormitoriesReturn) =>
            d.details?.["main-info"]?.city.toLowerCase() ===
            value?.toLowerCase()
        );
      }
    }
    return await axios.get("https://stud-api.sabir.pro/dormitories/all");
  }

  async getUniversityEvent() {
    return await axios.get("https://stud-api.sabir.pro/events/all");
  }

  async getLabs() {
    return await axios.get("https://stud-api.sabir.pro/labs/all");
  }
}
