// @ts-ignore
import axios from "axios";
export class EntityModel {
    async getNews() {
        return await axios.get("https://stud-api.sabir.pro/articles");
    }
    async getUniversities() {
        return await axios.get("https://stud-api.sabir.pro/universities/all");
    }
    async getDormitories(sortBy, value) {
        if (sortBy && value) {
            const response = await axios.get("https://stud-api.sabir.pro/dormitories/all");
            if (sortBy === "city") {
                return response.data.filter((d) => d.details?.["main-info"]?.city.toLowerCase() ===
                    value?.toLowerCase());
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
