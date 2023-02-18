// @ts-ignore
import axios from "axios";
import {
  IDormitoriesReturn,
  ILabsReturn,
  INewsReturn,
  IRoomInterface,
  IRoomsByIdReturn,
  IRoomsReturn,
  IUniversitiesReturn,
  IUniversityEvent,
} from "../interfaces/entity.model.interface";

interface IEntityModel {
  getNews: () => Promise<INewsReturn[]>;
  getUniversities: () => Promise<IUniversitiesReturn[]>;
  getDormitories: (
    sortBy?: string,
    value?: string
  ) => Promise<IDormitoriesReturn>;
  getUniversityEvent: () => Promise<IUniversityEvent[]>;
  getLabs: () => Promise<ILabsReturn[]>;
  getRooms: () => Promise<IRoomsReturn>;
  getRoomsById: (id: string) => Promise<IRoomsReturn>;
}

export class EntityModel implements IEntityModel {
  async getNews() {
    return await axios.get("https://stud-api.sabir.pro/articles");
  }

  async getUniversities() {
    return await axios.get("https://stud-api.sabir.pro/universities/all");
  }

  async getDormitories(
    sortBy?: string,
    value?: string
  ): Promise<IDormitoriesReturn> {
    if (sortBy && value) {
      const response = await axios.get(
        "https://stud-api.sabir.pro/dormitories/all"
      );
      if (sortBy === "city") {
        return response.data.filter(
          (d: IDormitoriesReturn) =>
            d.data?.details?.["main-info"]?.city.toLowerCase() ===
            value?.toLowerCase()
        );
      }
    }
    return await axios.get("https://stud-api.sabir.pro/dormitories/all");
  }

  async getRooms(): Promise<IRoomsReturn> {
    return await axios.get("https://stud-api.sabir.pro/rooms/all");
  }

  // @ts-ignore
  async getRoomsById(id: string): Promise<IRoomsByIdReturn[]> {
    let rooms = await axios.get("https://stud-api.sabir.pro/rooms/all");
    rooms = rooms.data.filter((r: IRoomInterface) => r.dormitoryId === id);
    return rooms;
  }

  async getUniversityEvent() {
    return await axios.get("https://stud-api.sabir.pro/events/all");
  }

  async getLabs() {
    return await axios.get("https://stud-api.sabir.pro/labs/all");
  }
}
