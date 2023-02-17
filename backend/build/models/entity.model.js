// @ts-ignore
import axios from "axios";
export class EntityModel {
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
